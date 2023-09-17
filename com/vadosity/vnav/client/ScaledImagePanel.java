/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.MediaTracker;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class ScaledImagePanel extends JPanel {
/* 10 */   private Image image = null;
/*    */   public synchronized Image getImage() {
/* 12 */     return this.image;
/*    */   }
/*    */   public synchronized void setImage(Image image) {
/* 15 */     this.image = image;
/* 16 */     if (image == null)
/*    */       return; 
/*    */     try {
/* 19 */       MediaTracker tracker = new MediaTracker(this);
/* 20 */       tracker.addImage(image, 0);
/* 21 */       tracker.waitForID(0);
/* 22 */       setSize(image.getWidth(this), image.getHeight(this));
/* 23 */       setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
/* 24 */       updateUI();
/*    */     }
/* 26 */     catch (Exception e) {
/*    */       
/* 28 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void paint(Graphics g) {
/* 37 */     super.paint(g);
/* 38 */     if (this.image == null)
/*    */       return; 
/*    */     try {
/* 41 */       MediaTracker tracker = new MediaTracker(this);
/* 42 */       tracker.addImage(this.image, 0);
/* 43 */       tracker.waitForID(0);
/*    */       
/* 45 */       setSize(this.image.getWidth(this), this.image.getHeight(this));
/* 46 */       g.drawImage(this.image, 0, 0, this);
/*    */     
/*    */     }
/* 49 */     catch (Exception e) {
/*    */       
/* 51 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ScaledImagePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */