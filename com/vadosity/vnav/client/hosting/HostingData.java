/*     */ package com.vadosity.vnav.client.hosting;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ 
/*     */ public class HostingData implements Serializable {
/*   9 */   private int appletWidth = 800; static final long serialVersionUID = 582164014709722106L;
/*  10 */   private int appletHeight = 600;
/*  11 */   private String displayLanguage = "English";
/*  12 */   private String tourDirectoryUrl = "http://www.yourwebsite.com/tours";
/*  13 */   private String tourFilename = "";
/*  14 */   private String htmlFilename = "";
/*  15 */   private File tourFile = null;
/*  16 */   public static int APPLET_TAG_TYPE = 1;
/*  17 */   public static int OBJECT_TAG_TYPE = 2;
/*  18 */   private int tagType = APPLET_TAG_TYPE;
/*  19 */   private String tourName = "";
/*  20 */   private transient String htmlText = "";
/*  21 */   private File stagingDirectory = null;
/*  22 */   private String vadosityJarFilePath = "vadosity.jar";
/*     */ 
/*     */   
/*     */   public String getVadosityJarFilePath() {
/*  26 */     if (this.vadosityJarFilePath == null) this.vadosityJarFilePath = "vadosity.jar"; 
/*  27 */     return this.vadosityJarFilePath;
/*     */   }
/*     */   
/*     */   public void setVadosityJarFilePath(String path) {
/*  31 */     this.vadosityJarFilePath = path;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveState() {
/*     */     try {
/*  39 */       FileOutputStream fos = new FileOutputStream("HostingData.ser");
/*  40 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/*  41 */       oos.writeObject(this);
/*  42 */       oos.flush();
/*  43 */       oos.close();
/*     */     }
/*  45 */     catch (Exception e) {
/*     */       
/*  47 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static HostingData retrieveState() {
/*     */     try {
/*  55 */       if (!(new File("HostingData.ser")).exists()) return null;
/*     */ 
/*     */       
/*  58 */       FileInputStream fis = new FileInputStream("HostingData.ser");
/*  59 */       ObjectInputStream ois = new ObjectInputStream(fis);
/*  60 */       Object object = ois.readObject();
/*  61 */       ois.close();
/*  62 */       return (HostingData)object;
/*     */     }
/*  64 */     catch (Exception e) {
/*     */       
/*  66 */       e.printStackTrace();
/*  67 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTourFileUrl() {
/*  76 */     String url = this.tourDirectoryUrl;
/*  77 */     if (!url.endsWith("/")) url = String.valueOf(url) + "/"; 
/*  78 */     url = String.valueOf(url) + this.tourFilename;
/*  79 */     return url;
/*     */   }
/*     */   
/*     */   public String getHtmlFileUrl() {
/*  83 */     String url = this.tourDirectoryUrl;
/*  84 */     if (!url.endsWith("/")) url = String.valueOf(url) + "/"; 
/*  85 */     url = String.valueOf(url) + this.htmlFilename;
/*  86 */     return url;
/*     */   }
/*     */   
/*     */   public String getJarFileUrl() {
/*  90 */     String url = this.tourDirectoryUrl;
/*  91 */     if (!url.endsWith("/")) url = String.valueOf(url) + "/"; 
/*  92 */     url = String.valueOf(url) + "vadosity.jar";
/*  93 */     return url;
/*     */   }
/*     */   
/*  96 */   private static HostingData instance = null;
/*     */ 
/*     */   
/*     */   public static HostingData getInstance() {
/* 100 */     if (instance == null) {
/*     */       
/* 102 */       instance = retrieveState();
/* 103 */       if (instance == null) instance = new HostingData(); 
/*     */     } 
/* 105 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAppletHeight() {
/* 114 */     return this.appletHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAppletWidth() {
/* 122 */     return this.appletWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAppletHeight(int i) {
/* 130 */     this.appletHeight = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAppletWidth(int i) {
/* 138 */     this.appletWidth = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTourDirectoryUrl() {
/* 146 */     return this.tourDirectoryUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTourDirectoryUrl(String string) {
/* 154 */     this.tourDirectoryUrl = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTourFilename() {
/* 162 */     return this.tourFilename;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTourFilename(String string) {
/* 170 */     this.tourFilename = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHtmlFilename() {
/* 178 */     return this.htmlFilename;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHtmlFilename(String string) {
/* 186 */     this.htmlFilename = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getTourFile() {
/* 194 */     return this.tourFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTourFile(File file) {
/* 202 */     this.tourFile = file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTagType() {
/* 210 */     return this.tagType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTagType(int i) {
/* 218 */     if (i != APPLET_TAG_TYPE && i != OBJECT_TAG_TYPE) {
/* 219 */       throw new IllegalArgumentException("invalid tag type specified ");
/*     */     }
/*     */     
/* 222 */     this.tagType = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTourName() {
/* 230 */     return this.tourName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTourName(String string) {
/* 238 */     this.tourName = string;
/*     */   }
/*     */   
/* 241 */   public String getHtmlText() { return this.htmlText; } public void setHtmlText(String s) {
/* 242 */     this.htmlText = s;
/*     */   }
/*     */   
/*     */   public File getStagingDirectory() {
/* 246 */     return this.stagingDirectory;
/*     */   } public void setStagingDirectory(File directory) {
/* 248 */     this.stagingDirectory = directory;
/*     */   }
/*     */   
/*     */   public String getDisplayLanguage() {
/* 252 */     return this.displayLanguage;
/*     */   }
/*     */   
/*     */   public void setDisplayLanguage(String displayLanguage) {
/* 256 */     this.displayLanguage = displayLanguage;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\hosting\HostingData.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */