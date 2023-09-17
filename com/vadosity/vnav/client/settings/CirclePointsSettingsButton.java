/*    */ package com.vadosity.vnav.client.settings;
/*    */ 
/*    */ import com.vadosity.vnav.client.CirclePointsToggleButton;
/*    */ import com.vadosity.vnav.client.Settings;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ public class CirclePointsSettingsButton
/*    */   extends CirclePointsToggleButton
/*    */ {
/*    */   public void paint(Graphics g) {
/* 12 */     super.paint(g);
/*    */     
/* 14 */     int x = (getSize()).width / 2;
/* 15 */     int y = (getSize()).height / 2;
/*    */     
/* 17 */     int w = 3 * (getSize()).width / 5;
/* 18 */     int h = 3 * (getSize()).height / 5;
/* 19 */     int radius = (w < h) ? w : h;
/*    */     
/* 21 */     double x1 = (1 * (getSize()).width / 5);
/* 22 */     double y1 = (1 * (getSize()).width / 5);
/*    */     
/* 24 */     if (this.mouseIn) {
/*    */       
/* 26 */       if (Settings.getSelectedPhotoPointFillColor() != null) {
/*    */         
/* 28 */         g.setColor(Settings.getSelectedPhotoPointFillColor());
/* 29 */         g.fillOval(x - radius / 2, y - radius / 2, radius, radius);
/*    */       } 
/*    */       
/* 32 */       g.setColor(Settings.getSelectedPhotoPointOutlineColor());
/* 33 */       g.drawOval(x - radius / 2, y - radius / 2, radius, radius);
/* 34 */       if (Settings.isDrawDotInCircle()) g.fillOval(x - 1, y - 1, 4, 4);
/*    */     
/*    */     }
/*    */     else {
/*    */       
/* 39 */       if (Settings.getPhotoPointFillColor() != null) {
/*    */         
/* 41 */         g.setColor(Settings.getPhotoPointFillColor());
/* 42 */         g.fillOval(x - radius / 2, y - radius / 2, radius, radius);
/*    */       } 
/*    */       
/* 45 */       g.setColor(Settings.getPhotoPointOutlineColor());
/* 46 */       g.drawOval(x - radius / 2, y - radius / 2, radius, radius);
/* 47 */       if (Settings.isDrawDotInCircle()) g.fillOval(x - 1, y - 1, 4, 4); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\CirclePointsSettingsButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */