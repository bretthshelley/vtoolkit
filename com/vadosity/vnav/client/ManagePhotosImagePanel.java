/*    */ package com.vadosity.vnav.client;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.MediaTracker;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ public class ManagePhotosImagePanel extends JPanel {
/*  9 */   private Image image = null;
/* 10 */   MediaTracker tracker = new MediaTracker(this);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized Image getImage() {
/* 17 */     return this.image;
/*    */   }
/*    */   public synchronized void setImage(Image image) {
/* 20 */     this.image = image;
/* 21 */     if (image == null)
/*    */       return; 
/*    */     try {
/* 24 */       this.tracker = null;
/* 25 */       this.tracker = new MediaTracker(this);
/* 26 */       this.tracker.addImage(image, 0);
/* 27 */       this.tracker.waitForID(0);
/* 28 */       int width = image.getWidth(this);
/* 29 */       int height = image.getHeight(this);
/* 30 */       if (width < 340 && height < 260) {
/*    */         
/* 32 */         setSize(width, height);
/* 33 */         setPreferredSize(new Dimension(width, height));
/* 34 */         setMaximumSize(new Dimension(width, height));
/* 35 */         setMinimumSize(new Dimension(width, height));
/* 36 */         updateUI();
/*    */ 
/*    */         
/*    */         return;
/*    */       } 
/*    */       
/* 42 */       if (width > 640) {
/*    */         
/* 44 */         double ratio = width / 640.0D;
/* 45 */         width = (int)(width / ratio);
/* 46 */         height = (int)(height / ratio);
/*    */       } 
/* 48 */       if (height > 480) {
/*    */         
/* 50 */         double ratio = height / 480.0D;
/* 51 */         width = (int)(width / ratio);
/* 52 */         height = (int)(height / ratio);
/*    */       } 
/*    */       
/* 55 */       setSize(width, height);
/* 56 */       setPreferredSize(new Dimension(width, height));
/* 57 */       updateUI();
/*    */     
/*    */     }
/* 60 */     catch (Exception e) {
/*    */       
/* 62 */       JOptionPane.showMessageDialog(this, "+ManagePhotosImagePanel:setImage " + e.getMessage(), e.toString(), 0);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void paint(Graphics g) {
/* 68 */     super.paint(g);
/* 69 */     if (this.image == null)
/*    */       return; 
/*    */     try {
/* 72 */       g.drawImage(this.image, 0, 0, getWidth(), getHeight(), this);
/*    */ 
/*    */ 
/*    */     
/*    */     }
/* 77 */     catch (Exception e) {
/*    */       
/* 79 */       JOptionPane.showMessageDialog(this, "+ManagePhotosImagePanel:paint " + e.getMessage(), e.toString(), 0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ManagePhotosImagePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */