/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.MediaTracker;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.Vector;
/*     */ import org.juniverse.jgraphictools.ImageResizer;
/*     */ 
/*     */ public class Resizer {
/*  12 */   private static Image dimensionsImage = null;
/*  13 */   private static MediaTracker tracker = null;
/*     */   
/*  15 */   private static File targetDir = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Dimension getImageSize(String filepath, Component observer) throws Exception {
/*  25 */     if (!(new File(filepath)).exists()) throw new FileNotFoundException("could not find " + filepath); 
/*  26 */     if (observer == null) throw new IllegalArgumentException("component observer is null");
/*     */ 
/*     */     
/*     */     try {
/*  30 */       dimensionsImage = Toolkit.getDefaultToolkit().createImage(filepath);
/*  31 */       tracker = new MediaTracker(observer);
/*  32 */       tracker.addImage(dimensionsImage, 0);
/*  33 */       tracker.waitForID(0);
/*     */       
/*  35 */       Dimension size = new Dimension(dimensionsImage.getWidth(observer), dimensionsImage.getHeight(observer));
/*  36 */       dimensionsImage = null;
/*  37 */       tracker = null;
/*  38 */       return size;
/*     */     }
/*  40 */     catch (Exception e) {
/*     */       
/*  42 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean imageSizesIdentical(int currentWidth, int currentHeight, int targetWidth, int targetHeight, int accuracyRequired) {
/*  48 */     return (Math.abs(currentWidth - targetWidth) <= accuracyRequired && Math.abs(currentHeight - targetHeight) <= accuracyRequired);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void copyFile(String sourcePath, String targetDirectory) throws Exception {
/*  53 */     File file = new File(sourcePath);
/*     */ 
/*     */     
/*  56 */     String filename = file.getName();
/*     */     
/*  58 */     File dir = new File(targetDirectory);
/*  59 */     File[] fa = dir.listFiles();
/*     */     
/*  61 */     for (int i = 0; i < fa.length; i++) {
/*     */       
/*  63 */       if (fa[i].getName().equals(filename))
/*     */       {
/*  65 */         if (fa[i].length() == file.length()) {
/*     */           return;
/*     */         }
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  72 */     FileInputStream fis = new FileInputStream(file);
/*  73 */     FileOutputStream fos = new FileOutputStream(String.valueOf(targetDirectory) + File.separator + file.getName());
/*  74 */     byte[] bytes = new byte[fis.available()];
/*  75 */     fis.read(bytes);
/*  76 */     fos.write(bytes);
/*  77 */     fos.flush();
/*  78 */     fos.close();
/*  79 */     fis.close();
/*  80 */     fis = null;
/*  81 */     fos = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static File[] getImageFiles(File sourceDirectory) {
/*  89 */     File[] files = sourceDirectory.listFiles();
/*  90 */     if (files.length == 0) return null;
/*     */ 
/*     */     
/*  93 */     Vector vValidFiles = new Vector(); int i;
/*  94 */     for (i = 0; i < files.length; i++) {
/*     */       
/*  96 */       String path = files[i].getAbsolutePath().toLowerCase();
/*  97 */       if (path.endsWith("jpg") || path.endsWith("jpeg") || path.endsWith("pjpeg"))
/*     */       {
/*  99 */         vValidFiles.add(files[i]);
/*     */       }
/*     */     } 
/* 102 */     if (vValidFiles.isEmpty()) return null; 
/* 103 */     files = (File[])null;
/* 104 */     files = new File[vValidFiles.size()];
/* 105 */     for (i = 0; i < vValidFiles.size(); ) { files[i] = vValidFiles.elementAt(i); i++; }
/* 106 */      return files;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void resize(Component observer, String filepath, String targetDirectory, int targetWidth, int targetHeight) {
/*     */     try {
/* 117 */       Dimension size = getImageSize(filepath, observer);
/* 118 */       if (size == null) throw new RuntimeException("could not determine image size");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 123 */       if (imageSizesIdentical(size.width, size.height, targetWidth, targetHeight, 3)) {
/*     */         
/* 125 */         copyFile(filepath, targetDirectory);
/*     */         
/*     */         return;
/*     */       } 
/* 129 */       if (size.width <= targetWidth && size.height <= targetHeight) {
/*     */         
/* 131 */         copyFile(filepath, targetDirectory);
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */ 
/*     */       
/* 139 */       double widthRatio = size.width * 1.0D / targetWidth;
/* 140 */       double heightRatio = size.height * 1.0D / targetHeight;
/* 141 */       double lowestRatio = (widthRatio < heightRatio) ? widthRatio : heightRatio;
/* 142 */       double highestRatio = (widthRatio > heightRatio) ? widthRatio : heightRatio;
/* 143 */       double absDifference = Math.abs(widthRatio - heightRatio);
/* 144 */       double differenceRatio = absDifference / lowestRatio;
/* 145 */       if (differenceRatio < 0.03D)
/*     */       {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 151 */           String outpath = String.valueOf(targetDirectory) + File.separator + (new File(filepath)).getName();
/* 152 */           ImageResizer.resize(filepath, outpath, targetWidth, targetHeight);
/*     */         }
/* 154 */         catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 165 */         int slop = 10;
/* 166 */         boolean landscape = ((size.width + slop) / targetWidth > size.height / targetHeight);
/* 167 */         int scaleHeight = -1, scaleWidth = -1;
/*     */         
/* 169 */         if (landscape) {
/*     */ 
/*     */           
/* 172 */           scaleHeight = targetHeight;
/* 173 */           scaleWidth = (int)(size.width / heightRatio);
/*     */         }
/*     */         else {
/*     */           
/* 177 */           scaleWidth = targetWidth;
/* 178 */           scaleHeight = (int)(size.height / widthRatio);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 184 */           ImageResizer ir = new ImageResizer();
/* 185 */           String outpath = String.valueOf(targetDirectory) + File.separator + (new File(filepath)).getName();
/* 186 */           ImageResizer.resize(filepath, outpath, scaleWidth, scaleHeight);
/*     */         }
/* 188 */         catch (Exception exception) {}
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 193 */     catch (Exception e) {
/*     */       
/* 195 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean resizeGif(String filepath, Component observer, int width, int height, String targetDirectory) {
/*     */     try {
/* 223 */       return true;
/*     */ 
/*     */     
/*     */     }
/* 227 */     catch (Exception e) {
/*     */       
/* 229 */       e.printStackTrace();
/* 230 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\Resizer.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */