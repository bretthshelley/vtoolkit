/*     */ package com.vadosity.vnav.map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapRequestor
/*     */   extends Thread
/*     */ {
/*     */   boolean okToContinue = true;
/*     */   private static final int UNINITIALIZED = -1000000;
/*  11 */   public static int MAP_NUMBER_LIMIT = 500;
/*  12 */   private double latitude = -1000000.0D;
/*  13 */   private double longitude = -1000000.0D;
/*  14 */   private double startingWidth = -1000000.0D;
/*  15 */   private double startingHeight = -1000000.0D;
/*  16 */   private double widthIncrement = -1000000.0D;
/*  17 */   private double heightIncrement = -1000000.0D;
/*  18 */   private int pixelWidth = -1000000;
/*  19 */   private int pixelHeight = -1000000;
/*  20 */   private int numberOfMaps = -1000000;
/*  21 */   public String baseUrl = "http://tiger.census.gov/cgi-bin/mapper/map.gif";
/*     */   private boolean finished = false;
/*     */   
/*  24 */   public boolean isFinished() { return this.finished; } public void setFinished(boolean b) {
/*  25 */     this.finished = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean blueStar = false;
/*     */   
/*     */   public boolean redStar = false;
/*     */   
/*     */   public boolean isOkToContinue() {
/*  34 */     return this.okToContinue; } public void setOkToContinue(boolean b) {
/*  35 */     this.okToContinue = b;
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
/*     */   public double getHeightIncrement() {
/*  47 */     return this.heightIncrement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLatitude() {
/*  54 */     return this.latitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLongitude() {
/*  61 */     return this.longitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfMaps() {
/*  68 */     return this.numberOfMaps;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPixelHeight() {
/*  75 */     return this.pixelHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPixelWidth() {
/*  82 */     return this.pixelWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getStartingHeight() {
/*  89 */     return this.startingHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getStartingWidth() {
/*  96 */     return this.startingWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getWidthIncrement() {
/* 103 */     return this.widthIncrement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeightIncrement(double d) {
/* 110 */     this.heightIncrement = d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLatitude(double d) {
/* 117 */     this.latitude = d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLongitude(double d) {
/* 124 */     this.longitude = d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumberOfMaps(int i) {
/* 131 */     this.numberOfMaps = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPixelHeight(int i) {
/* 138 */     this.pixelHeight = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPixelWidth(int i) {
/* 145 */     this.pixelWidth = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartingHeight(double d) {
/* 152 */     this.startingHeight = d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartingWidth(double d) {
/* 159 */     this.startingWidth = d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWidthIncrement(double d) {
/* 166 */     this.widthIncrement = d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBaseUrl() {
/* 173 */     return this.baseUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseUrl(String string) {
/* 180 */     this.baseUrl = string;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\map\MapRequestor.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */