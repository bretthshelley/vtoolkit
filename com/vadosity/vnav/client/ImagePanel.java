/*    */ package com.vadosity.vnav.client;
/*    */ import java.awt.Container;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.MediaTracker;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class ImagePanel extends JPanel {
/*  9 */   private Image image = null;
/* 10 */   protected MediaTracker tracker = new MediaTracker(this);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized Image getImage() {
/* 19 */     return this.image;
/*    */   }
/*    */   public synchronized void setImage(Image image) {
/* 22 */     this.image = image;
/* 23 */     if (image == null) {
/*    */       return;
/*    */     }
/*    */     try {
/* 27 */       this.tracker.addImage(image, 0);
/* 28 */       this.tracker.waitForID(0);
/* 29 */       Container container = getParent();
/* 30 */       setSize(image.getWidth(this), image.getHeight(this));
/* 31 */       setPreferredSize(new Dimension(image.getWidth(this), 
/* 32 */             image.getHeight(this)));
/* 33 */       updateUI();
/*    */     }
/* 35 */     catch (Exception e) {
/*    */       
/* 37 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void paint(Graphics g) {
/* 46 */     super.paint(g);
/* 47 */     if (this.image == null)
/*    */       return; 
/*    */     try {
/* 50 */       MediaTracker tracker = new MediaTracker(this);
/* 51 */       tracker.addImage(this.image, 0);
/* 52 */       tracker.waitForID(0);
/* 53 */       setSize(this.image.getWidth(this), this.image.getHeight(this));
/* 54 */       g.drawImage(this.image, 0, 0, this);
/*    */     }
/* 56 */     catch (Exception e) {
/*    */       
/* 58 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ImagePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */