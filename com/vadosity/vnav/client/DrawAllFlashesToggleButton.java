/*    */ package com.vadosity.vnav.client;
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import com.vadosity.vnav.bean.PhotoPoint;
/*    */ import com.vadosity.vnav.bean.Tour;
/*    */ import com.vadosity.vnav.bean.View;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Polygon;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JToggleButton;
/*    */ 
/*    */ public class DrawAllFlashesToggleButton extends JToggleButton implements GlobalChangeListener, SettingsChangeListener {
/*    */   public void settingsChanged(Object src) {
/* 13 */     setSelected(Settings.isDrawAllFlashes());
/* 14 */     updateUI();
/*    */   }
/*    */   
/*    */   public void tourChanged(Tour selectedTour, Object src) {}
/*    */   
/*    */   public void viewChanged(View selectedView, Object src) {
/* 20 */     setSelected(Settings.isDrawAllFlashes());
/* 21 */     updateUI();
/*    */   }
/*    */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*    */   
/*    */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*    */   
/*    */   public void paint(Graphics g) {
/* 28 */     super.paint(g);
/*    */     
/* 30 */     int x0 = 4 * (getSize()).width / 5;
/* 31 */     int y0 = 4 * (getSize()).height / 5;
/*    */     
/* 33 */     int radiusW = 3 * (getSize()).width / 5;
/* 34 */     int radiusH = 3 * (getSize()).height / 5;
/* 35 */     int radius = (radiusW < radiusH) ? radiusW : radiusH;
/*    */     
/* 37 */     double x1 = x0 + radius * Math.cos(Math.PI);
/* 38 */     double y1 = y0;
/*    */     
/* 40 */     double x2 = x0 + radius * Math.cos(3.665191429188092D);
/* 41 */     double y2 = y0 + radius * Math.sin(3.665191429188092D);
/*    */     
/* 43 */     double x3 = x0 + radius * Math.cos(4.1887902047863905D);
/* 44 */     double y3 = y0 + radius * Math.sin(4.1887902047863905D);
/*    */     
/* 46 */     double x4 = x0 + radius * Math.cos(4.71238898038469D);
/* 47 */     double y4 = y0 + radius * Math.sin(4.71238898038469D);
/*    */     
/* 49 */     Polygon p1 = new Polygon();
/* 50 */     p1.addPoint(x0, y0);
/* 51 */     p1.addPoint((int)x1, (int)y1);
/* 52 */     p1.addPoint((int)x2, (int)y2);
/*    */     
/* 54 */     Polygon p2 = new Polygon();
/* 55 */     p2.addPoint(x0, y0);
/* 56 */     p2.addPoint((int)x3, (int)y3);
/* 57 */     p2.addPoint((int)x4, (int)y4);
/* 58 */     if (Settings.getFlashFillColor() != null) {
/*    */       
/* 60 */       g.setColor(Settings.getFlashFillColor());
/* 61 */       g.fillPolygon(p1);
/* 62 */       g.fillPolygon(p2);
/*    */     } 
/* 64 */     if (Settings.getFlashOutlineColor() != null) {
/*    */       
/* 66 */       g.setColor(Settings.getFlashOutlineColor());
/* 67 */       g.drawPolygon(p1);
/* 68 */       g.drawPolygon(p2);
/*    */     } 
/*    */   }
/*    */   
/*    */   public DrawAllFlashesToggleButton() {
/*    */     try {
/* 74 */       jbInit();
/* 75 */       Global.addGlobalChangeListener(this);
/* 76 */       Global.addSettingsChangeListener(this);
/*    */     }
/* 78 */     catch (Exception e) {
/* 79 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 83 */     addActionListener(new DrawAllFlashesToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 88 */     Settings.setDrawAllFlashes(isSelected());
/* 89 */     Global.fireSettingsChanged(this);
/* 90 */     updateUI();
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\DrawAllFlashesToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */