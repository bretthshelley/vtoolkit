/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ 
/*     */ 
/*     */ public class MultiPhotoUtil
/*     */ {
/*   9 */   private static MultiPhotoUtil instance = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PhotoPoint assemblePanoramicPhoto() {
/*  16 */     if (this.photoBytes == null) throw new IllegalStateException("photoBytes have not been set"); 
/*  17 */     if (this.photoPoint == null) throw new IllegalStateException("PhotoPoint has not been set");
/*     */     
/*  19 */     Photo photo = new Photo(this.photoPoint);
/*  20 */     photo.setStartAngle(this.angles[0]);
/*     */     
/*  22 */     photo.setStartAngle(this.angles[0]);
/*  23 */     photo.setFinishAngle(this.angles[1]);
/*  24 */     photo.setBytes(this.photoBytes[0].getBytes());
/*  25 */     photo.setClockwise(Settings.isClockwise());
/*  26 */     photo.setCompleteRevolution(Settings.isFullCircle());
/*  27 */     photo.setPanoramic(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  33 */     photo.determineCoverageAngle();
/*  34 */     this.photoPoint.add(photo);
/*     */     
/*  36 */     if (!Global.getView().getPhotos().contains(photo))
/*     */     {
/*  38 */       Global.getView().getPhotos().add(photo);
/*     */     }
/*  40 */     return this.photoPoint;
/*     */   }
/*     */ 
/*     */   
/*     */   public PhotoPoint assemblePhotosOnPoint() {
/*  45 */     if (this.photoBytes == null) return null; 
/*  46 */     if (this.angles == null) return null; 
/*  47 */     if (this.photoPoint == null)
/*     */     {
/*  49 */       throw new IllegalStateException("PhotoPoint has not been set");
/*     */     }
/*  51 */     if (Settings.isAddPanoramicPhotos()) return assemblePanoramicPhoto();
/*     */ 
/*     */     
/*  54 */     if (this.photoBytes.length != this.angles.length)
/*     */     {
/*  56 */       throw new IllegalStateException("number of angles and photos are out of synch!");
/*     */     }
/*     */     
/*  59 */     for (int i = 0; i < this.angles.length; i++) {
/*     */       
/*  61 */       Photo photo = new Photo(this.photoPoint);
/*  62 */       photo.setStartAngle(this.angles[i]);
/*  63 */       photo.setBytes(this.photoBytes[i].getBytes());
/*  64 */       photo.doCalculations();
/*  65 */       this.photoPoint.add(photo);
/*  66 */       if (!Global.getView().getPhotos().contains(photo))
/*     */       {
/*  68 */         Global.getView().getPhotos().add(photo);
/*     */       }
/*     */     } 
/*  71 */     return this.photoPoint;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MultiPhotoUtil getInstance() {
/*  76 */     if (instance == null) instance = new MultiPhotoUtil(); 
/*  77 */     return instance;
/*     */   }
/*     */   
/*  80 */   private PhotoBytes[] photoBytes = null;
/*     */   
/*     */   public PhotoBytes[] getPhotoBytes() {
/*  83 */     return this.photoBytes;
/*     */   }
/*     */   
/*     */   public void setPhotoBytes(PhotoBytes[] pba) {
/*  87 */     this.photoBytes = null;
/*  88 */     this.photoBytes = pba;
/*     */   }
/*     */   
/*  91 */   private PhotoPoint photoPoint = null;
/*  92 */   public PhotoPoint getPhotoPoint() { return this.photoPoint; } public void setPhotoPoint(PhotoPoint photoPoint) {
/*  93 */     this.photoPoint = photoPoint;
/*     */   }
/*  95 */   private double[] angles = null;
/*  96 */   public double[] getAngles() { return this.angles; } public void setAngles(double[] angles) {
/*  97 */     this.angles = angles;
/*     */   }
/*  99 */   private double angleBetweenPhotos = 0.0D;
/*     */   
/* 101 */   private double coverageAngle = 0.0D;
/* 102 */   public double getCoverageAngle() { return this.coverageAngle; } public void setCoverageAngle(double angle) {
/* 103 */     this.coverageAngle = angle;
/*     */   }
/*     */   public void setCoverageDegrees(double degrees) {
/* 106 */     setCoverageAngle(Math.toRadians(degrees));
/*     */   }
/*     */   
/*     */   public void setCoverageDegrees(String degrees) {
/* 110 */     setCoverageDegrees(Double.parseDouble(degrees));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void determineAngles() {
/* 116 */     if (Settings.isAddPanoramicPhotos() && Settings.isFullCircle()) {
/*     */       
/* 118 */       this.angles = new double[2];
/* 119 */       this.angles[0] = Settings.getStartAngle();
/* 120 */       this.angles[1] = Settings.getStartAngle() + 6.283185307179586D;
/*     */       return;
/*     */     } 
/* 123 */     if (Settings.getNumberPhotos() == 1 && 
/* 124 */       Settings.isAddPanoramicPhotos() && 
/* 125 */       !Settings.isFullCircle()) {
/*     */       
/* 127 */       this.angles = new double[2];
/* 128 */       this.angles[0] = Settings.getStartAngle();
/* 129 */       this.angles[1] = Settings.getFinishAngle();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 142 */     this.angles = new double[Settings.getNumberPhotos()];
/*     */     int i;
/* 144 */     for (i = 0; i < Settings.getNumberPhotos(); i++) {
/*     */       
/* 146 */       if (Settings.isClockwise()) { this.angles[i] = Settings.getStartAngle() + this.angleBetweenPhotos * i; }
/* 147 */       else { this.angles[i] = Settings.getStartAngle() - this.angleBetweenPhotos * i; }
/*     */     
/*     */     } 
/*     */ 
/*     */     
/* 152 */     if (getPhotoPoint() == null)
/*     */       return; 
/* 154 */     if (Settings.getNumberPhotos() == getPhotoPoint().getVPhotos().size())
/*     */     {
/*     */       
/* 157 */       for (i = 0; i < getPhotoPoint().getVPhotos().size(); i++) {
/*     */         
/* 159 */         Photo photo = getPhotoPoint().getVPhotos().elementAt(i);
/* 160 */         photo.setStartAngle(this.angles[i]);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void determineAngleBetweenPhotos() {
/* 170 */     if (Settings.getNumberPhotos() == 1) {
/*     */       
/* 172 */       this.angleBetweenPhotos = 6.283185307179586D;
/*     */       
/*     */       return;
/*     */     } 
/* 176 */     if (Settings.isFullCircle()) {
/*     */       
/* 178 */       this.angleBetweenPhotos = 6.283185307179586D / Settings.getNumberPhotos();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 183 */     this.angleBetweenPhotos = this.coverageAngle / (Settings.getNumberPhotos() - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void determineCoverageAngle() {
/* 188 */     double startAngle = Settings.getStartAngle();
/* 189 */     double finishAngle = Settings.getFinishAngle();
/* 190 */     boolean clockwise = Settings.isClockwise();
/*     */     
/* 192 */     if (Settings.isFullCircle() || finishAngle == startAngle) {
/*     */       
/* 194 */       this.coverageAngle = 6.283185307179586D;
/*     */       
/*     */       return;
/*     */     } 
/* 198 */     if (clockwise && finishAngle > startAngle) {
/*     */       
/* 200 */       this.coverageAngle = finishAngle - startAngle;
/*     */       return;
/*     */     } 
/* 203 */     if (clockwise && finishAngle < startAngle) {
/*     */       
/* 205 */       this.coverageAngle = 6.283185307179586D - startAngle + finishAngle;
/*     */       return;
/*     */     } 
/* 208 */     if (!clockwise && finishAngle > startAngle) {
/*     */       
/* 210 */       this.coverageAngle = startAngle + 6.283185307179586D - finishAngle;
/*     */       return;
/*     */     } 
/* 213 */     if (!clockwise && finishAngle < startAngle) {
/*     */       
/* 215 */       this.coverageAngle = startAngle - finishAngle;
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\MultiPhotoUtil.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */