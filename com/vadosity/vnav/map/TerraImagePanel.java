/*     */ package com.vadosity.vnav.map;
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ 
/*     */ public class TerraImagePanel extends ImagePanel {
/*   9 */   private Image overlayImage = null;
/*  10 */   private Point mouse = null;
/*  11 */   private double overlayAlpha = 0.2D;
/*     */   
/*     */   public synchronized Image getOverlayImage() {
/*  14 */     return this.overlayImage;
/*     */   }
/*     */   public synchronized void setOverlayImage(Image image) {
/*  17 */     this.overlayImage = image;
/*  18 */     if (image == null) {
/*     */       return;
/*     */     }
/*     */     try {
/*  22 */       this.tracker.addImage(this.overlayImage, 0);
/*  23 */       this.tracker.waitForID(0);
/*     */ 
/*     */       
/*  26 */       updateUI();
/*     */     }
/*  28 */     catch (Exception e) {
/*     */       
/*  30 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TerraImagePanel() {
/*     */     try {
/*  39 */       jbInit();
/*     */     }
/*  41 */     catch (Exception e) {
/*  42 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   private void jbInit() throws Exception {
/*  46 */     addMouseListener(new TerraImagePanel_this_mouseAdapter(this));
/*  47 */     addMouseMotionListener(new TerraImagePanel_this_mouseMotionAdapter(this));
/*     */   }
/*     */ 
/*     */   
/*     */   void this_mouseMoved(MouseEvent e) {
/*  52 */     this.mouse = e.getPoint();
/*  53 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  60 */     Graphics2D g2d = (Graphics2D)g;
/*     */     
/*  62 */     if (this.overlayImage != null)
/*     */     {
/*     */ 
/*     */       
/*  66 */       g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
/*     */     }
/*     */     
/*  69 */     super.paint(g);
/*     */ 
/*     */ 
/*     */     
/*  73 */     if (this.overlayImage == null) {
/*     */       return;
/*     */     }
/*  76 */     g2d.setComposite(AlphaComposite.getInstance(3, (float)this.overlayAlpha));
/*     */ 
/*     */     
/*     */     try {
/*  80 */       this.tracker.addImage(this.overlayImage, 0);
/*  81 */       this.tracker.waitForID(0);
/*     */       
/*  83 */       g.drawImage(this.overlayImage, 0, 0, (ImageObserver)this);
/*     */     }
/*  85 */     catch (Exception e) {
/*     */       
/*  87 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  92 */     if (this.mouse != null) {
/*     */       
/*  94 */       g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
/*  95 */       int radius = 10;
/*  96 */       int diameter = radius * 2;
/*  97 */       g.setColor(Color.blue);
/*  98 */       g.drawOval(this.mouse.x - radius, this.mouse.y - radius, diameter, diameter);
/*  99 */       g.drawLine(this.mouse.x - diameter, this.mouse.y, this.mouse.x + diameter, this.mouse.y);
/* 100 */       g.drawLine(this.mouse.x, this.mouse.y - diameter, this.mouse.x, this.mouse.y + diameter);
/* 101 */       this.mouse = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseExited(MouseEvent e) {
/* 111 */     this.mouse = null;
/* 112 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Point getMouse() {
/* 124 */     return this.mouse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMouse(Point point) {
/* 133 */     this.mouse = point;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getOverlayAlpha() {
/* 141 */     return this.overlayAlpha;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverlayAlpha(double d) {
/* 149 */     this.overlayAlpha = d;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\map\TerraImagePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */