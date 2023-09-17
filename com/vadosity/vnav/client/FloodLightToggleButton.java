/*    */ package com.vadosity.vnav.client;
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import com.vadosity.vnav.bean.PhotoPoint;
/*    */ import com.vadosity.vnav.bean.Tour;
/*    */ import com.vadosity.vnav.bean.View;
/*    */ import com.vadosity.vnav.bean.ViewSettings;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Polygon;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JToggleButton;
/*    */ 
/*    */ public class FloodLightToggleButton extends JToggleButton implements GlobalChangeListener, SettingsChangeListener {
/*    */   public void settingsChanged(Object source) {
/* 14 */     setSelected(Settings.isDrawFloodLights());
/* 15 */     updateUI();
/*    */   }
/*    */   
/*    */   public void tourChanged(Tour selectedTour, Object src) {}
/*    */   
/*    */   public void viewChanged(View selectedView, Object src) {
/* 21 */     setSelected(Settings.isDrawFloodLights());
/* 22 */     updateUI();
/*    */   }
/*    */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*    */   
/*    */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*    */   
/*    */   public void paint(Graphics g) {
/* 29 */     super.paint(g);
/*    */     
/* 31 */     int x1_5 = (getSize()).width / 5;
/* 32 */     int y1_5 = (getSize()).height / 5;
/*    */     
/* 34 */     int x2_5 = 2 * (getSize()).width / 5;
/* 35 */     int y2_5 = 2 * (getSize()).height / 5;
/*    */     
/* 37 */     int w = getWidth();
/* 38 */     int h = getHeight();
/*    */     
/* 40 */     Polygon p = new Polygon();
/* 41 */     p.addPoint(x1_5, y1_5);
/* 42 */     p.addPoint(x2_5, h);
/* 43 */     p.addPoint(w, h);
/* 44 */     p.addPoint(w, y2_5);
/*    */     
/* 46 */     if (Settings.getFloodLightFillColor() == null) {
/*    */       
/* 48 */       g.setColor((new ViewSettings()).getFloodLightFillColor());
/*    */     }
/*    */     else {
/*    */       
/* 52 */       g.setColor(Settings.getFloodLightFillColor());
/*    */     } 
/* 54 */     g.fillPolygon(p);
/*    */     
/* 56 */     if (Settings.getFloodLightOutlineColor() == null) {
/*    */       
/* 58 */       g.setColor((new ViewSettings()).getFloodLightOutlineColor());
/*    */     }
/*    */     else {
/*    */       
/* 62 */       g.setColor(Settings.getFloodLightOutlineColor());
/*    */     } 
/* 64 */     g.drawPolygon(p);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FloodLightToggleButton() {
/*    */     try {
/* 72 */       jbInit();
/* 73 */       Global.addGlobalChangeListener(this);
/* 74 */       Global.addSettingsChangeListener(this);
/*    */     }
/* 76 */     catch (Exception e) {
/* 77 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 81 */     addActionListener(new FloodLightToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 86 */     Settings.setDrawFloodLight(isSelected());
/*    */     
/* 88 */     Global.fireSettingsChanged(this);
/* 89 */     updateUI();
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\FloodLightToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */