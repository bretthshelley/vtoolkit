/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import com.vadosity.vnav.bean.PhotoPoint;
/*    */ import com.vadosity.vnav.bean.Tour;
/*    */ import com.vadosity.vnav.bean.View;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Insets;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JToggleButton;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AlwaysCenterToggleButton
/*    */   extends JToggleButton
/*    */   implements GlobalChangeListener, SettingsChangeListener
/*    */ {
/*    */   public void settingsChanged(Object src) {
/* 21 */     setSelected(Settings.isAlwaysCenter());
/* 22 */     updateUI();
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 27 */     Settings.setAlwaysCenter(isSelected());
/* 28 */     Global.fireSettingsChanged(this);
/* 29 */     Global.fireSelectedPhotoChanged(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void tourChanged(Tour selectedTour, Object src) {}
/*    */   
/*    */   public void viewChanged(View selectedView, Object src) {
/* 36 */     setSelected(Settings.isAlwaysCenter());
/* 37 */     updateUI();
/*    */   }
/*    */   
/*    */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*    */   
/*    */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*    */   
/*    */   public void paint(Graphics g) {
/* 45 */     super.paint(g);
/*    */     
/* 47 */     int x2 = (getSize()).width / 4;
/* 48 */     int y2 = (getSize()).height / 4;
/* 49 */     int w2 = 1 * (getSize()).width / 2;
/* 50 */     int h2 = 1 * (getSize()).height / 2;
/* 51 */     int x = (getSize()).width / 2;
/* 52 */     int y = (getSize()).height / 2;
/*    */     
/* 54 */     g.setColor(Color.white);
/* 55 */     g.fillRect(x2, y2, w2, h2);
/*    */     
/* 57 */     g.setColor(Color.lightGray);
/* 58 */     g.fillRect(x2 + w2 - 3, y2, 3, h2);
/* 59 */     g.fillRect(x2, y2 + h2 - 3, w2, 3);
/*    */     
/* 61 */     g.setColor(Color.black);
/* 62 */     g.drawRect(x2, y2, w2, h2);
/* 63 */     g.drawLine(x - 3, y, x + 3, y);
/* 64 */     g.drawLine(x, y - 3, x, y + 3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AlwaysCenterToggleButton() {
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
/* 81 */     setFont(new Font("Dialog", 0, 10));
/* 82 */     setHorizontalTextPosition(0);
/* 83 */     setMargin(new Insets(2, 2, 2, 2));
/* 84 */     addActionListener(new AlwaysCenterToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AlwaysCenterToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */