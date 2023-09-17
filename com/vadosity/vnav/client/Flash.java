/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import java.awt.Point;
/*    */ import java.awt.Polygon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Flash
/*    */ {
/* 13 */   private Polygon polygon = new Polygon();
/* 14 */   private Photo photo = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public Flash() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Flash(Photo photo) {
/* 23 */     this.photo = photo;
/* 24 */     doCalculations();
/*    */   }
/*    */ 
/*    */   
/*    */   public void doCalculations() {
/* 29 */     int length = Settings.getFlashLength();
/*    */     
/* 31 */     double coverageAngle = Math.toRadians(Settings.getFlashCoverageDegrees());
/* 32 */     double photoAngle = this.photo.getStartAngle();
/* 33 */     double startAngle = photoAngle - coverageAngle / 2.0D;
/* 34 */     double finishAngle = startAngle + coverageAngle;
/*    */     
/* 36 */     int x = this.photo.getPhotoPoint().getX();
/* 37 */     int y = this.photo.getPhotoPoint().getY();
/*    */     
/* 39 */     int x1 = (int)Math.round(x + length * Math.cos(startAngle));
/* 40 */     int y1 = (int)Math.round(y + length * Math.sin(startAngle));
/* 41 */     int x2 = (int)Math.round(x + length * Math.cos(finishAngle));
/* 42 */     int y2 = (int)Math.round(y + length * Math.sin(finishAngle));
/*    */     
/* 44 */     this.polygon = new Polygon();
/* 45 */     this.polygon.addPoint(x, y);
/* 46 */     this.polygon.addPoint(x1, y1);
/* 47 */     this.polygon.addPoint(x2, y2);
/* 48 */     this.polygon.addPoint(x, y);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean contains(Point point) {
/* 54 */     if (point == null)
/*    */     {
/* 56 */       return false;
/*    */     }
/* 58 */     if (this.polygon == null)
/*    */     {
/* 60 */       return false;
/*    */     }
/* 62 */     return this.polygon.contains(point);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\Flash.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */