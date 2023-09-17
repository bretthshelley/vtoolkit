/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.applet.AppletUtil;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Image;
/*     */ import java.awt.MediaTracker;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.InputStream;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageUtil
/*     */ {
/*     */   public static Image loadBinoImage() {
/*  19 */     return loadImage("bino_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadEditImage() {
/*  24 */     return loadImage("edit_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadStopImage() {
/*  29 */     return loadImage("stop.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadSlowImage() {
/*  34 */     return loadImage("slow.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadJogImage() {
/*  39 */     return loadImage("jog.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadWalkImage() {
/*  44 */     return loadImage("/walk.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadLightningMouseImage() {
/*  49 */     return loadImage("/lightning-mouse_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadLightningImage() {
/*  53 */     return loadImage("/lightning_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadFileImage() {
/*  58 */     return loadImage("/file-icon_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadFilesImage() {
/*  63 */     return loadImage("/lightning_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadCameraImage() {
/*  68 */     return loadImage("/camera_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadDownArrowButtonImage() {
/*  73 */     return loadImage("/down-arrow-button_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadUpArrowButtonImage() {
/*  77 */     return loadImage("/up-arrow-button_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadAltButtonImage() {
/*  81 */     return loadImage("/alt-button_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadProductImage() {
/*  85 */     return loadImage("/productbox_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadAlwaysCenterImage() {
/*  90 */     return loadImage("/always-center_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadFloodLightImage() {
/*  95 */     return loadImage("/floodlight_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadPanoramicImage_() {
/*  99 */     return loadImage("/panoramic_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadCircleImage() {
/* 104 */     return loadImage("/circle_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadFlashesImage() {
/* 108 */     return loadImage("/flashes_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadLightArrowImage() {
/* 112 */     return loadImage("/lightarrow_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadFootstepImage() {
/* 117 */     return loadImage("/footsteps_.gif");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Image loadArrowUpImageDisabled() {
/* 123 */     return loadImage("/arrow-up-disabled.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadFolderImage() {
/* 128 */     return loadImage("/folder_.gif");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Image loadVadosityImage() {
/* 134 */     return loadImage("/Vadosity16x_.gif");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Image loadSettingsImage() {
/* 141 */     return loadImage("/settings_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadColorsImage() {
/* 146 */     return loadImage("/colors_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadItalicImage() {
/* 151 */     return loadImage("/italic_.gif");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadRightJustifyImage() {
/* 156 */     return loadImage("/right-justify_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadLeftJustifyImage() {
/* 160 */     return loadImage("/left-justify_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadCenterJustifyImage() {
/* 164 */     return loadImage("/center-justify_.gif");
/*     */   }
/*     */   
/*     */   public static Image loadPanoramicImage() {
/* 168 */     return loadImage("/panoramic_.gif");
/*     */   }
/*     */ 
/*     */   
/* 172 */   private static Dimension documentImageDimension = null; public static Dimension getDocumentImageDimension() {
/* 173 */     return documentImageDimension;
/*     */   }
/* 175 */   private static Image documentImage = null;
/*     */   
/*     */   public static Image getDocumentImage() {
/* 178 */     if (documentImage == null)
/*     */     {
/* 180 */       documentImage = loadImage("document_.gif");
/*     */     }
/* 182 */     return documentImage;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Image loadImage(String path) {
/* 187 */     if (path == null) return null;
/*     */     
/* 189 */     if (!path.startsWith("/")) path = "/" + path;
/*     */     
/* 191 */     Image image = null;
/*     */ 
/*     */     
/*     */     try {
/* 195 */       InputStream is = "".getClass().getResourceAsStream(path);
/* 196 */       byte[] bytes = new byte[is.available()];
/* 197 */       is.read(bytes);
/* 198 */       is.close();
/* 199 */       image = Toolkit.getDefaultToolkit().createImage(bytes);
/* 200 */       MediaTracker tracker = new MediaTracker(new JFrame());
/* 201 */       tracker.addImage(image, 1);
/* 202 */       tracker.waitForAll();
/*     */     
/*     */     }
/* 205 */     catch (Exception e) {
/*     */       
/* 207 */       System.out.println("**** COULD NOT LOAD IMAGE: " + e);
/*     */       
/* 209 */       if (AppletUtil.getInstance() != null) {
/*     */         
/* 211 */         path = path.substring(1);
/* 212 */         System.out.println("document base: " + AppletUtil.getInstance().getCodeBase() + " path: " + path);
/* 213 */         Image im = AppletUtil.getInstance().getImage(AppletUtil.getInstance().getCodeBase(), path);
/* 214 */         MediaTracker tracker = new MediaTracker(new JFrame());
/* 215 */         tracker.addImage(im, 1);
/*     */         
/*     */         try {
/* 218 */           tracker.waitForAll();
/*     */         }
/* 220 */         catch (InterruptedException interruptedException) {}
/*     */ 
/*     */         
/* 223 */         return im;
/*     */       } 
/* 225 */       return null;
/*     */     } 
/* 227 */     return image;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Image loadImage(String path, Component observer) {
/* 234 */     if (path == null) return null;
/*     */     
/* 236 */     if (!path.startsWith("/")) path = "/" + path;
/*     */     
/* 238 */     Image image = null;
/*     */ 
/*     */     
/*     */     try {
/* 242 */       InputStream is = "".getClass().getResourceAsStream(path);
/* 243 */       byte[] bytes = new byte[is.available()];
/* 244 */       is.read(bytes);
/* 245 */       is.close();
/* 246 */       image = Toolkit.getDefaultToolkit().createImage(bytes);
/* 247 */       MediaTracker tracker = new MediaTracker(observer);
/* 248 */       tracker.addImage(image, 1);
/* 249 */       tracker.waitForAll();
/*     */     
/*     */     }
/* 252 */     catch (Exception e) {
/*     */       
/* 254 */       System.out.println("**** COULD NOT LOAD IMAGE: " + e);
/*     */       
/* 256 */       if (AppletUtil.getInstance() != null) {
/*     */         
/* 258 */         path = path.substring(1);
/* 259 */         System.out.println("document base: " + AppletUtil.getInstance().getCodeBase() + " path: " + path);
/* 260 */         Image im = AppletUtil.getInstance().getImage(AppletUtil.getInstance().getCodeBase(), path);
/* 261 */         MediaTracker tracker = new MediaTracker(observer);
/* 262 */         tracker.addImage(im, 1);
/*     */         
/*     */         try {
/* 265 */           tracker.waitForAll();
/*     */         }
/* 267 */         catch (InterruptedException interruptedException) {}
/*     */ 
/*     */         
/* 270 */         return im;
/*     */       } 
/* 272 */       return null;
/*     */     } 
/* 274 */     return image;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getImageBytes(String path) {
/* 281 */     if (path == null) return null;
/*     */     
/* 283 */     if (!path.startsWith("/")) path = "/" + path;
/*     */     
/* 285 */     byte[] bytes = (byte[])null;
/*     */     
/*     */     try {
/* 288 */       InputStream is = "".getClass().getResourceAsStream(path);
/* 289 */       bytes = new byte[is.available()];
/* 290 */       is.read(bytes);
/* 291 */       is.close();
/*     */     
/*     */     }
/* 294 */     catch (Exception e) {
/*     */       
/* 296 */       return null;
/*     */     } 
/* 298 */     return bytes;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ImageUtil.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */