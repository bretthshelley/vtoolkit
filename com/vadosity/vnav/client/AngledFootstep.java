/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ 
/*     */ public class AngledFootstep implements Serializable {
/*   7 */   private double angle = 0.0D;
/*   8 */   private Point center = new Point(0, 0);
/*   9 */   protected AngledOval front = null;
/*  10 */   protected AngledOval back = null;
/*     */   
/*  12 */   private Color fillColor = Settings.getFootstepFillColor();
/*  13 */   private Color outlineColor = Settings.getFootstepOutlineColor();
/*     */   
/*  15 */   public Color getFillColor() { return this.fillColor; } public void setFillColor(Color color) {
/*  16 */     this.fillColor = color;
/*     */   }
/*  18 */   public Color getOutlineColor() { return this.outlineColor; } public void setOutlineColor(Color color) {
/*  19 */     this.outlineColor = color;
/*     */   } public Point getCenter() {
/*  21 */     return this.center;
/*     */   }
/*     */   public void setCenter(Point center) {
/*  24 */     this.center = center;
/*     */   }
/*     */   public double getAngle() {
/*  27 */     return this.angle;
/*     */   }
/*     */   public void setAngle(double radians) {
/*  30 */     this.angle = radians;
/*     */   }
/*  32 */   public void setDegrees(double degrees) { setAngle(Math.toRadians(degrees)); } public void setDegrees(String degrees) {
/*  33 */     setDegrees(degrees);
/*     */   }
/*     */   public String getDisplayAngleDegrees() {
/*  36 */     double degrees = Math.toDegrees(this.angle);
/*  37 */     degrees = Math.round(degrees);
/*  38 */     if (degrees > 360.0D)
/*     */     {
/*  40 */       return degrees % 360.0D;
/*     */     }
/*  42 */     if (degrees >= 0.0D)
/*     */     {
/*  44 */       return degrees;
/*     */     }
/*  46 */     if (degrees < 0.0D)
/*     */     {
/*  48 */       return 360.0D + degrees;
/*     */     }
/*  50 */     return Math.toDegrees(this.angle);
/*     */   }
/*     */   
/*  53 */   private int frontLength = -1;
/*  54 */   private int frontWidth = -1;
/*  55 */   private int backLength = -1;
/*  56 */   private int backWidth = -1;
/*  57 */   private int frontCenterX = -1;
/*  58 */   private int frontCenterY = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doCalculations() {
/*  64 */     this.frontLength = 6 * Settings.getFootstepLength() / 10;
/*  65 */     this.frontWidth = Settings.getFootstepWidth();
/*  66 */     this.backLength = 3 * Settings.getFootstepLength() / 10;
/*  67 */     this.backWidth = 2 * Settings.getFootstepWidth() / 3;
/*     */ 
/*     */     
/*  70 */     this.frontCenterX = (int)Math.round(this.center.x + (this.frontLength / 2) * Math.cos(this.angle));
/*  71 */     this.frontCenterY = (int)Math.round(this.center.y + (this.frontLength / 2) * Math.sin(this.angle));
/*     */     
/*  73 */     int backCenterX = (int)Math.round(this.center.x - (Settings.getFootstepLength() / 4) * Math.cos(-this.angle));
/*  74 */     int backCenterY = (int)Math.round(this.center.y + (Settings.getFootstepLength() / 4) * Math.sin(-this.angle));
/*     */     
/*  76 */     this.front = new AngledOval(new Point(this.frontCenterX, this.frontCenterY), getAngle());
/*  77 */     this.front.setLength(this.frontLength);
/*  78 */     this.front.setWidth(this.frontWidth);
/*  79 */     this.front.doCalculations();
/*     */     
/*  81 */     this.back = new AngledOval(new Point(backCenterX, backCenterY), getAngle());
/*  82 */     this.back.setLength(this.backLength);
/*  83 */     this.back.setWidth(this.backWidth);
/*  84 */     this.back.doCalculations();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  90 */     Color orig = g.getColor();
/*  91 */     if (this.front == null || this.back == null) {
/*     */       return;
/*     */     }
/*     */     
/*  95 */     this.front.setFillColor(getFillColor());
/*  96 */     this.front.setOutlineColor(getOutlineColor());
/*  97 */     this.front.paint(g);
/*     */     
/*  99 */     this.back.setFillColor(getFillColor());
/* 100 */     this.back.setOutlineColor(getOutlineColor());
/* 101 */     this.back.paint(g);
/*     */     
/* 103 */     g.setColor(orig);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AngledFootstep() {}
/*     */ 
/*     */   
/*     */   public AngledFootstep(Point center, double angle) {
/* 112 */     setCenter(center);
/* 113 */     setAngle(angle);
/* 114 */     doCalculations();
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AngledFootstep.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */