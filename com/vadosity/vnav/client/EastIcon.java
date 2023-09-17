/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Polygon;
/*    */ import javax.swing.Icon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EastIcon
/*    */   implements Icon
/*    */ {
/* 13 */   int iconHeight = 10;
/* 14 */   int iconWidth = 10;
/*    */ 
/*    */   
/*    */   public int getIconHeight() {
/* 18 */     return this.iconHeight;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getIconWidth() {
/* 23 */     return this.iconWidth;
/*    */   }
/*    */ 
/*    */   
/*    */   public void paintIcon(Component c, Graphics g, int x, int y) {
/* 28 */     this.iconWidth = (c.getSize()).width / 2;
/* 29 */     this.iconHeight = (c.getSize()).height / 2;
/*    */     
/* 31 */     int leftx = this.iconWidth - this.iconWidth / 2;
/* 32 */     int rightx = this.iconWidth + this.iconWidth / 2;
/* 33 */     int topy = this.iconHeight - this.iconHeight / 2;
/* 34 */     int bottomy = this.iconHeight + this.iconHeight / 2;
/* 35 */     Polygon p = new Polygon();
/*    */     
/* 37 */     p.addPoint(leftx, topy);
/* 38 */     p.addPoint(rightx, this.iconHeight);
/* 39 */     p.addPoint(leftx, bottomy);
/*    */     
/* 41 */     g.fillPolygon(p);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\EastIcon.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */