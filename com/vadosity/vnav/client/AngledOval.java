/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ import java.awt.Polygon;
/*     */ 
/*     */ public class AngledOval implements Serializable {
/*   8 */   private double angle = 0.0D;
/*   9 */   private Point center = null;
/*  10 */   private int length = 16;
/*  11 */   private int width = 8;
/*     */   
/*  13 */   int Nx = -1;
/*  14 */   int Ny = -1;
/*  15 */   int NEx = -1;
/*  16 */   int NEy = -1;
/*  17 */   int Ex = -1;
/*  18 */   int Ey = -1;
/*  19 */   int SEx = -1;
/*  20 */   int SEy = -1;
/*  21 */   int Sx = -1;
/*  22 */   int Sy = -1;
/*  23 */   int SWx = -1;
/*  24 */   int SWy = -1;
/*  25 */   int Wx = -1;
/*  26 */   int Wy = -1;
/*  27 */   int NWx = -1;
/*  28 */   int NWy = -1;
/*     */   
/*  30 */   private Color fillColor = Settings.getFootstepFillColor();
/*  31 */   private Color outlineColor = Settings.getFootstepOutlineColor();
/*     */   
/*  33 */   public Color getFillColor() { return this.fillColor; } public void setFillColor(Color color) {
/*  34 */     this.fillColor = color;
/*     */   }
/*  36 */   public Color getOutlineColor() { return this.outlineColor; } public void setOutlineColor(Color color) {
/*  37 */     this.outlineColor = color;
/*     */   }
/*  39 */   public int getLength() { return this.length; } public void setLength(int length) {
/*  40 */     this.length = length;
/*     */   }
/*  42 */   public int getWidth() { return this.width; } public void setWidth(int width) {
/*  43 */     this.width = width;
/*     */   } public Point getCenter() {
/*  45 */     return this.center;
/*     */   }
/*     */   public void setCenter(Point center) {
/*  48 */     this.center = center;
/*     */   }
/*     */   public double getAngle() {
/*  51 */     return this.angle;
/*     */   }
/*     */   public void setAngle(double radians) {
/*  54 */     this.angle = radians;
/*     */   }
/*  56 */   public void setDegrees(double degrees) { setAngle(Math.toRadians(degrees)); } public void setDegrees(String degrees) {
/*  57 */     setDegrees(degrees);
/*     */   }
/*     */   public String getDisplayAngleDegrees() {
/*  60 */     double degrees = Math.toDegrees(this.angle);
/*  61 */     degrees = Math.round(degrees);
/*  62 */     if (degrees > 360.0D)
/*     */     {
/*  64 */       return degrees % 360.0D;
/*     */     }
/*  66 */     if (degrees >= 0.0D)
/*     */     {
/*  68 */       return degrees;
/*     */     }
/*  70 */     if (degrees < 0.0D)
/*     */     {
/*  72 */       return 360.0D + degrees;
/*     */     }
/*  74 */     return Math.toDegrees(this.angle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doCalculations() {
/*  80 */     double a = this.length / 2.0D;
/*  81 */     double b = this.width / 2.0D;
/*  82 */     double c = (a + b) / 2.2D;
/*     */     
/*  84 */     double cN = Math.cos(this.angle - 1.5707963267948966D);
/*  85 */     double sN = Math.sin(this.angle - 1.5707963267948966D);
/*  86 */     double cNE = Math.cos(this.angle - 0.7853981633974483D);
/*  87 */     double sNE = Math.sin(this.angle - 0.7853981633974483D);
/*  88 */     double cE = Math.cos(this.angle);
/*  89 */     double sE = Math.sin(this.angle);
/*  90 */     double cSE = Math.cos(this.angle + 0.7853981633974483D);
/*  91 */     double sSE = Math.sin(this.angle + 0.7853981633974483D);
/*  92 */     double cS = Math.cos(this.angle + 1.5707963267948966D);
/*  93 */     double sS = Math.sin(this.angle + 1.5707963267948966D);
/*  94 */     double cSW = Math.cos(this.angle + 2.356194490192345D);
/*  95 */     double sSW = Math.sin(this.angle + 2.356194490192345D);
/*  96 */     double cW = Math.cos(this.angle - Math.PI);
/*  97 */     double sW = Math.sin(this.angle - Math.PI);
/*  98 */     double cNW = Math.cos(this.angle - 2.356194490192345D);
/*  99 */     double sNW = Math.sin(this.angle - 2.356194490192345D);
/*     */     
/* 101 */     this.Nx = (int)Math.round(this.center.x + cN * b);
/* 102 */     this.Ny = (int)Math.round(this.center.y + sN * b);
/* 103 */     this.NEx = (int)Math.round(this.center.x + cNE * c);
/* 104 */     this.NEy = (int)Math.round(this.center.y + sNE * c);
/* 105 */     this.Ex = (int)Math.round(this.center.x + cE * a);
/* 106 */     this.Ey = (int)Math.round(this.center.y + sE * a);
/* 107 */     this.SEx = (int)Math.round(this.center.x + cSE * c);
/* 108 */     this.SEy = (int)Math.round(this.center.y + sSE * c);
/* 109 */     this.Sx = (int)Math.round(this.center.x + cS * b);
/* 110 */     this.Sy = (int)Math.round(this.center.y + sS * b);
/* 111 */     this.SWx = (int)Math.round(this.center.x + cSW * c);
/* 112 */     this.SWy = (int)Math.round(this.center.y + sSW * c);
/* 113 */     this.Wx = (int)Math.round(this.center.x + cW * a);
/* 114 */     this.Wy = (int)Math.round(this.center.y + sW * a);
/* 115 */     this.NWx = (int)Math.round(this.center.x + cNW * c);
/* 116 */     this.NWy = (int)Math.round(this.center.y + sNW * c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/* 122 */     Color orig = g.getColor();
/*     */     
/* 124 */     Polygon p = new Polygon();
/* 125 */     p.addPoint(this.Nx, this.Ny);
/* 126 */     p.addPoint(this.NEx, this.NEy);
/* 127 */     p.addPoint(this.Ex, this.Ey);
/* 128 */     p.addPoint(this.SEx, this.SEy);
/* 129 */     p.addPoint(this.Sx, this.Sy);
/* 130 */     p.addPoint(this.SWx, this.SWy);
/* 131 */     p.addPoint(this.Wx, this.Wy);
/* 132 */     p.addPoint(this.NWx, this.NWy);
/*     */     
/* 134 */     if (getFillColor() != null) {
/*     */       
/* 136 */       g.setColor(getFillColor());
/* 137 */       g.fillPolygon(p);
/*     */     } 
/* 139 */     g.setColor(getOutlineColor());
/* 140 */     g.drawPolygon(p);
/*     */     
/* 142 */     g.setColor(orig);
/*     */   }
/*     */ 
/*     */   
/*     */   public AngledOval() {}
/*     */   
/*     */   public AngledOval(Point center, double angle) {
/* 149 */     setCenter(center);
/* 150 */     setAngle(angle);
/* 151 */     doCalculations();
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AngledOval.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */