/*    */ package com.vadosity.vnav.client;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Point;
/*    */ import java.awt.Polygon;
/*    */ 
/*    */ public class Arrow {
/*  7 */   private double angle = 0.0D;
/*  8 */   private Point arrowTip = null;
/*  9 */   private Point arrowBase = null;
/*    */   
/* 11 */   protected int length = -1;
/* 12 */   protected double leftBladeAngle = -1.0D;
/* 13 */   protected int leftTipx = -1;
/* 14 */   protected int leftTipy = -1;
/* 15 */   protected double rightBladeAngle = -1.0D;
/* 16 */   protected int rightTipx = -1;
/* 17 */   protected int rightTipy = -1;
/*    */   
/* 19 */   private transient Color color = null;
/* 20 */   public Color getColor() { return this.color; } public void setColor(Color c) {
/* 21 */     this.color = c;
/*    */   }
/*    */ 
/*    */   
/*    */   public Arrow() {}
/*    */ 
/*    */   
/*    */   public Arrow(Point base, Point tip) {
/* 29 */     setArrowBase(base);
/* 30 */     setArrowTip(tip);
/* 31 */     doCalculations();
/*    */   }
/*    */ 
/*    */   
/*    */   public void doCalculations() {
/* 36 */     this.angle = Math.atan2((this.arrowTip.y - this.arrowBase.y), (this.arrowTip.x - this.arrowBase.x));
/* 37 */     this.length = (int)Point.distance(this.arrowBase.x, this.arrowBase.y, this.arrowTip.x, this.arrowTip.y);
/* 38 */     this.leftBladeAngle = this.angle + Math.PI - Settings.getArrowBladeAngle();
/* 39 */     this.leftTipx = this.arrowTip.x + (int)(Settings.getArrowBladeLength() * Math.cos(this.leftBladeAngle));
/* 40 */     this.leftTipy = this.arrowTip.y + (int)(Settings.getArrowBladeLength() * Math.sin(this.leftBladeAngle));
/* 41 */     this.rightBladeAngle = this.angle - Math.PI - Settings.getArrowBladeAngle();
/* 42 */     this.rightTipx = this.arrowTip.x + (int)(Settings.getArrowBladeLength() * Math.cos(this.rightBladeAngle));
/* 43 */     this.rightTipy = this.arrowTip.y + (int)(Settings.getArrowBladeLength() * Math.sin(this.rightBladeAngle));
/*    */   }
/*    */   
/*    */   public Point getArrowTip() {
/* 47 */     return this.arrowTip;
/*    */   }
/*    */   public void setArrowTip(Point tip) {
/* 50 */     this.arrowTip = tip;
/*    */   }
/*    */   
/* 53 */   public Point getArrowBase() { return this.arrowBase; } public void setArrowBase(Point p) {
/* 54 */     this.arrowBase = p;
/*    */   } public double getAngle() {
/* 56 */     return this.angle;
/*    */   }
/*    */   public void setAngle(double radians) {
/* 59 */     this.angle = radians;
/*    */   }
/* 61 */   public void setDegrees(double degrees) { setAngle(Math.toRadians(degrees)); } public void setDegrees(String degrees) {
/* 62 */     setDegrees(degrees);
/*    */   }
/*    */   public String getDisplayAngleDegrees() {
/* 65 */     double degrees = Math.toDegrees(this.angle);
/* 66 */     degrees = Math.round(degrees);
/* 67 */     if (degrees > 360.0D)
/*    */     {
/* 69 */       return degrees % 360.0D;
/*    */     }
/* 71 */     if (degrees >= 0.0D)
/*    */     {
/* 73 */       return degrees;
/*    */     }
/* 75 */     if (degrees < 0.0D)
/*    */     {
/* 77 */       return 360.0D + degrees;
/*    */     }
/* 79 */     return Math.toDegrees(this.angle);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 85 */     int rad = 4;
/* 86 */     g.fillOval(this.arrowBase.x - rad / 2, this.arrowBase.y - rad / 2, rad, rad);
/*    */     
/* 88 */     if (this.color != null) { g.setColor(this.color); }
/* 89 */     else { g.setColor(Color.red); }
/* 90 */      g.drawLine(this.arrowBase.x, this.arrowBase.y, this.arrowTip.x, this.arrowTip.y);
/* 91 */     Polygon p = new Polygon();
/* 92 */     p.addPoint(this.leftTipx, this.leftTipy);
/* 93 */     p.addPoint(this.rightTipx, this.rightTipy);
/* 94 */     p.addPoint(this.arrowTip.x, this.arrowTip.y);
/* 95 */     g.fillPolygon(p);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\Arrow.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */