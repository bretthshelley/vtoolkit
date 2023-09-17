/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import com.vadosity.vnav.bean.PhotoPoint;
/*    */ import com.vadosity.vnav.bean.Tour;
/*    */ import com.vadosity.vnav.bean.View;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Point;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JToggleButton;
/*    */ 
/*    */ public class DrawLightArrowsToggleButton extends JToggleButton implements GlobalChangeListener, SettingsChangeListener {
/*    */   public void settingsChanged(Object source) {
/* 14 */     setSelected(Settings.isDrawLightArrows());
/* 15 */     updateUI();
/*    */   }
/*    */   
/*    */   public void tourChanged(Tour selectedTour, Object src) {}
/*    */   
/*    */   public void viewChanged(View selectedView, Object src) {
/* 21 */     setSelected(Settings.isDrawLightArrows());
/* 22 */     updateUI();
/*    */   }
/*    */ 
/*    */   
/*    */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*    */   
/*    */   public void paint(Graphics g) {
/* 29 */     super.paint(g);
/*    */     
/* 31 */     int x = (getSize()).width / 2;
/* 32 */     int y = (getSize()).height / 2;
/*    */     
/* 34 */     int w = 3 * (getSize()).width / 5;
/* 35 */     int h = 3 * (getSize()).height / 5;
/* 36 */     int length = (w < h) ? w : h;
/*    */ 
/*    */     
/* 39 */     double x1 = (1 * (getSize()).width / 4);
/* 40 */     double y1 = (1 * (getSize()).width / 4);
/*    */     
/* 42 */     double angle = 0.7853981633974483D;
/*    */     
/* 44 */     double x2 = x1 + length * Math.cos(angle);
/* 45 */     double y2 = y1 + length * Math.sin(angle);
/*    */     
/* 47 */     g.setColor(Settings.getLightArrowColor());
/* 48 */     (new LightArrow(new Point((int)x1, (int)y1), new Point((int)x2, (int)y2))).paint(g, null);
/*    */   }
/*    */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*    */   
/*    */   public DrawLightArrowsToggleButton() {
/*    */     try {
/* 54 */       jbInit();
/* 55 */       Global.addGlobalChangeListener(this);
/* 56 */       Global.addSettingsChangeListener(this);
/*    */     }
/* 58 */     catch (Exception e) {
/* 59 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 63 */     addActionListener(new DrawLightArrowsToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 68 */     Settings.setDrawLightArrows(isSelected());
/* 69 */     Global.fireSettingsChanged(this);
/* 70 */     updateUI();
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\DrawLightArrowsToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */