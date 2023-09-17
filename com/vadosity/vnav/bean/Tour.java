/*     */ package com.vadosity.vnav.bean;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class Tour
/*     */   implements Serializable, Cloneable {
/*     */   static final long serialVersionUID = -7072510327475720662L;
/*  10 */   private String name = "";
/*  11 */   private String description = "";
/*     */   private boolean modified = false;
/*  13 */   private Vector vViews = new Vector();
/*  14 */   private String filename = null;
/*     */   
/*     */   public static final int SMALL_PHOTO_SIZE = -1;
/*     */   
/*     */   public static final int MEDIUM_PHOTO_SIZE = 0;
/*     */   
/*     */   public static final int LARGE_PHOTO_SIZE = 1;
/*     */   
/*     */   public static final int SMALL_PHOTO_WIDTH = 320;
/*     */   
/*     */   public static final int MEDIUM_PHOTO_WIDTH = 480;
/*     */   
/*     */   public static final int LARGE_PHOTO_WIDTH = 640;
/*     */   
/*     */   public static final int SMALL_PHOTO_HEIGHT = 240;
/*     */   public static final int MEDIUM_PHOTO_HEIGHT = 360;
/*     */   public static final int LARGE_PHOTO_HEIGHT = 480;
/*     */   private int photoSize;
/*  32 */   private double latitude = 0.0D;
/*  33 */   public double getLatitude() { return this.latitude; } public void setLatitude(double d) {
/*  34 */     this.latitude = d;
/*     */   }
/*  36 */   private double longitude = 0.0D;
/*  37 */   public double getLongitude() { return this.longitude; } public void setLongitude(double d) {
/*  38 */     this.longitude = d;
/*     */   } private boolean locked = false;
/*     */   public boolean isLocked() {
/*  41 */     return this.locked;
/*     */   }
/*     */   public void setLocked(boolean b) {
/*  44 */     if (b) doCalculations(); 
/*  45 */     this.locked = b;
/*     */   }
/*     */   
/*  48 */   private File photoDirectory = null;
/*  49 */   public File getPhotoDirectory() { return this.photoDirectory; } public void setPhotoDirectory(File f) {
/*  50 */     this.photoDirectory = f;
/*     */   }
/*     */   
/*     */   public int getNumberOfBytes() {
/*  54 */     if (this.vViews == null) return 0; 
/*  55 */     int count = 0;
/*  56 */     for (int i = 0; i < this.vViews.size(); i++)
/*     */     {
/*  58 */       count += ((View)this.vViews.elementAt(i)).getNumberOfBytes();
/*     */     }
/*  60 */     return count;
/*     */   }
/*     */ 
/*     */   
/*     */   public void doCalculations() {
/*  65 */     if (this.vViews != null)
/*     */     {
/*  67 */       for (int i = 0; i < this.vViews.size(); i++)
/*     */       {
/*  69 */         ((View)this.vViews.elementAt(i)).doCalculations();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFilename() {
/*  75 */     return this.filename;
/*     */   }
/*     */   public void setFilename(String filename) {
/*  78 */     this.filename = filename;
/*  79 */     setModified(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public View getFirstView() {
/*  84 */     if (this.vViews == null || this.vViews.size() == 0) return new View(); 
/*  85 */     return this.vViews.elementAt(0);
/*     */   }
/*     */   
/*  88 */   public boolean isModified() { return this.modified; } public void setModified(boolean b) {
/*  89 */     this.modified = b;
/*     */   }
/*     */   
/*     */   public void updateView(View view) {
/*  93 */     if (view == null)
/*  94 */       return;  if (this.vViews == null)
/*  95 */       return;  if (this.vViews.size() == 0) {
/*     */       return;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(View view) {
/* 102 */     getViews().add(view);
/* 103 */     setModified(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(View view) {
/* 108 */     getViews().remove(view);
/* 109 */     setModified(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAllViews() {
/* 114 */     getViews().removeAllElements();
/* 115 */     setViews(new Vector());
/* 116 */     setModified(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/* 121 */     this.name = name;
/* 122 */     setModified(true);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 126 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 130 */     this.description = description;
/* 131 */     setModified(true);
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 135 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setViews(Vector vViews) {
/* 139 */     this.vViews = vViews;
/* 140 */     setModified(true);
/*     */   }
/*     */   
/*     */   public Vector getViews() {
/* 144 */     return this.vViews;
/*     */   }
/*     */   public String toString() {
/* 147 */     return (getName() == null) ? "" : getName();
/*     */   } public synchronized int getPhotoSize() {
/* 149 */     return this.photoSize;
/*     */   }
/*     */   public synchronized void setPhotoSize(int photoSize) {
/* 152 */     this.photoSize = photoSize;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\bean\Tour.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */