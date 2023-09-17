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
/*    */ public class DrawFootStepsToggleButton extends JToggleButton implements GlobalChangeListener, SettingsChangeListener {
/*    */   public void settingsChanged(Object src) {
/* 14 */     setSelected(Settings.isDrawFootSteps());
/* 15 */     updateUI();
/*    */   }
/*    */ 
/*    */   
/*    */   public void tourChanged(Tour selectedTour, Object src) {}
/*    */   
/*    */   public void viewChanged(View selectedView, Object src) {
/* 22 */     if (selectedView == null || selectedView.getViewSettings() == null)
/*    */       return; 
/* 24 */     setSelected(selectedView.getViewSettings().isDrawFootSteps());
/* 25 */     updateUI();
/*    */   }
/*    */   
/*    */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*    */   
/*    */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*    */   
/*    */   public void paint(Graphics g) {
/* 33 */     super.paint(g);
/*    */     
/* 35 */     int x0 = (getSize()).width / 2;
/* 36 */     int y0 = (getSize()).height / 2;
/*    */     
/* 38 */     AngledFootstep af = new AngledFootstep(new Point(x0, y0), -0.7853981633974483D);
/* 39 */     af.paint(g);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DrawFootStepsToggleButton() {
/*    */     try {
/* 46 */       jbInit();
/* 47 */       Global.addGlobalChangeListener(this);
/* 48 */       Global.addSettingsChangeListener(this);
/* 49 */       setSelected(true);
/*    */     }
/* 51 */     catch (Exception e) {
/* 52 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 56 */     addActionListener(new DrawFootStepsToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 62 */     Settings.setDrawFootSteps(isSelected());
/* 63 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\DrawFootStepsToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */