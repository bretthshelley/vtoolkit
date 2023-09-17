/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import com.vadosity.vnav.bean.PhotoPoint;
/*    */ import com.vadosity.vnav.bean.Tour;
/*    */ import com.vadosity.vnav.bean.View;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.JToggleButton;
/*    */ 
/*    */ public class CirclePointsToggleButton
/*    */   extends JToggleButton implements GlobalChangeListener, SettingsChangeListener {
/*    */   public void settingsChanged(Object src) {
/* 15 */     setSelected(Settings.isCirclePoints());
/* 16 */     updateUI();
/*    */   }
/*    */   protected boolean mouseIn = false;
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 21 */     Settings.setCirclePoints(isSelected());
/* 22 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */   
/*    */   public void tourChanged(Tour selectedTour, Object src) {}
/*    */   
/*    */   public void viewChanged(View selectedView, Object src) {
/* 28 */     setSelected(Settings.isCirclePoints());
/* 29 */     updateUI();
/*    */   }
/*    */   
/*    */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*    */   
/*    */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*    */   
/*    */   public void paint(Graphics g) {
/* 37 */     super.paint(g);
/*    */     
/* 39 */     int x = (getSize()).width / 2;
/* 40 */     int y = (getSize()).height / 2;
/*    */     
/* 42 */     int w = 3 * (getSize()).width / 5;
/* 43 */     int h = 3 * (getSize()).height / 5;
/* 44 */     int radius = (w < h) ? w : h;
/*    */     
/* 46 */     double x1 = (1 * (getSize()).width / 5);
/* 47 */     double y1 = (1 * (getSize()).width / 5);
/*    */     
/* 49 */     if (Settings.getPhotoPointFillColor() != null) {
/*    */       
/* 51 */       g.setColor(Settings.getPhotoPointFillColor());
/* 52 */       g.fillOval(x - radius / 2, y - radius / 2, radius, radius);
/*    */     } 
/*    */     
/* 55 */     g.setColor(Settings.getPhotoPointOutlineColor());
/* 56 */     g.drawOval(x - radius / 2, y - radius / 2, radius, radius);
/* 57 */     if (Settings.isDrawDotInCircle()) g.fillOval(x - 1, y - 1, 4, 4);
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CirclePointsToggleButton() {
/*    */     try {
/* 67 */       jbInit();
/* 68 */       Global.addGlobalChangeListener(this);
/* 69 */       Global.addSettingsChangeListener(this);
/*    */     }
/* 71 */     catch (Exception e) {
/* 72 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private void jbInit() throws Exception {
/* 77 */     addMouseListener(new CirclePointsToggleButton_this_mouseAdapter(this));
/* 78 */     addActionListener(new CirclePointsToggleButton_this_actionAdapter(this));
/*    */   }
/*    */   
/*    */   void this_mouseEntered(MouseEvent e) {
/* 82 */     this.mouseIn = true;
/* 83 */     updateUI();
/*    */   }
/*    */   
/*    */   void this_mouseExited(MouseEvent e) {
/* 87 */     this.mouseIn = false;
/* 88 */     updateUI();
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\CirclePointsToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */