/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ 
/*     */ public class LightArrow {
/*   7 */   private double angle = 0.0D;
/*   8 */   private Point arrowTip = null;
/*   9 */   private Point arrowBase = null;
/*  10 */   private Color arrowColor = null;
/*     */   
/*  12 */   protected int length = -1;
/*  13 */   protected double leftBladeAngle = -1.0D;
/*  14 */   protected int leftTipx = -1;
/*  15 */   protected int leftTipy = -1;
/*  16 */   protected double rightBladeAngle = -1.0D;
/*  17 */   protected int rightTipx = -1;
/*  18 */   protected int rightTipy = -1;
/*     */ 
/*     */   
/*     */   public LightArrow() {}
/*     */ 
/*     */   
/*     */   public LightArrow(Point base, Point tip) {
/*  25 */     setArrowBase(base);
/*  26 */     setArrowTip(tip);
/*  27 */     doCalculations();
/*     */   }
/*     */ 
/*     */   
/*     */   public LightArrow(Point base, Point tip, Color c) {
/*  32 */     this(base, tip);
/*  33 */     setArrowColor(c);
/*     */   }
/*     */   
/*     */   public Color getArrowColor() {
/*  37 */     return this.arrowColor; } public void setArrowColor(Color c) {
/*  38 */     this.arrowColor = c;
/*     */   }
/*     */   
/*     */   public void doCalculations() {
/*  42 */     this.angle = Math.atan2((this.arrowTip.y - this.arrowBase.y), (this.arrowTip.x - this.arrowBase.x));
/*  43 */     this.length = (int)Point.distance(this.arrowBase.x, this.arrowBase.y, this.arrowTip.x, this.arrowTip.y);
/*  44 */     this.leftBladeAngle = this.angle + Math.PI - Settings.getArrowBladeAngle();
/*  45 */     this.leftTipx = this.arrowTip.x + (int)(Settings.getLightArrowBladeLength() * Math.cos(this.leftBladeAngle));
/*  46 */     this.leftTipy = this.arrowTip.y + (int)(Settings.getLightArrowBladeLength() * Math.sin(this.leftBladeAngle));
/*  47 */     this.rightBladeAngle = this.angle - Math.PI - Settings.getArrowBladeAngle();
/*  48 */     this.rightTipx = this.arrowTip.x + (int)(Settings.getLightArrowBladeLength() * Math.cos(this.rightBladeAngle));
/*  49 */     this.rightTipy = this.arrowTip.y + (int)(Settings.getLightArrowBladeLength() * Math.sin(this.rightBladeAngle));
/*     */   }
/*     */   
/*     */   public Point getArrowTip() {
/*  53 */     return this.arrowTip;
/*     */   }
/*     */   public void setArrowTip(Point tip) {
/*  56 */     this.arrowTip = tip;
/*     */   }
/*     */   
/*  59 */   public Point getArrowBase() { return this.arrowBase; } public void setArrowBase(Point p) {
/*  60 */     this.arrowBase = p;
/*     */   } public double getAngle() {
/*  62 */     return this.angle;
/*     */   }
/*     */   public void setAngle(double radians) {
/*  65 */     this.angle = radians;
/*     */   }
/*  67 */   public void setDegrees(double degrees) { setAngle(Math.toRadians(degrees)); } public void setDegrees(String degrees) {
/*  68 */     setDegrees(degrees);
/*     */   }
/*     */   public String getDisplayAngleDegrees() {
/*  71 */     double degrees = Math.toDegrees(this.angle);
/*  72 */     degrees = Math.round(degrees);
/*  73 */     if (degrees > 360.0D)
/*     */     {
/*  75 */       return degrees % 360.0D;
/*     */     }
/*  77 */     if (degrees >= 0.0D)
/*     */     {
/*  79 */       return degrees;
/*     */     }
/*  81 */     if (degrees < 0.0D)
/*     */     {
/*  83 */       return 360.0D + degrees;
/*     */     }
/*  85 */     return Math.toDegrees(this.angle);
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g, Color c) {
/*  90 */     Color orig = g.getColor();
/*     */     
/*  92 */     if (c == null) {
/*     */       
/*  94 */       g.setColor(Settings.getLightArrowColor());
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  99 */       g.setColor(c);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 104 */     g.drawLine(this.arrowBase.x, this.arrowBase.y, this.arrowTip.x, this.arrowTip.y);
/* 105 */     g.drawLine(this.arrowTip.x, this.arrowTip.y, this.leftTipx, this.leftTipy);
/* 106 */     g.drawLine(this.arrowTip.x, this.arrowTip.y, this.rightTipx, this.rightTipy);
/* 107 */     g.setColor(orig);
/*     */   }
/*     */ 
/*     */   
/*     */   public void paintSelected(Graphics g, Color c) {
/* 112 */     Color orig = g.getColor();
/* 113 */     g.setColor((c == null) ? Settings.getSelectedLightArrowColor() : c);
/*     */     
/* 115 */     g.drawLine(this.arrowBase.x, this.arrowBase.y, this.arrowTip.x, this.arrowTip.y);
/* 116 */     Polygon p = new Polygon();
/* 117 */     p.addPoint(this.arrowTip.x, this.arrowTip.y);
/* 118 */     p.addPoint(this.leftTipx, this.leftTipy);
/* 119 */     p.addPoint(this.rightTipx, this.rightTipy);
/* 120 */     g.fillPolygon(p);
/* 121 */     g.setColor(orig);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\LightArrow.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */