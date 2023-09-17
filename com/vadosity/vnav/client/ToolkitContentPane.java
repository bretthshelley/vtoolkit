/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.MediaTracker;
/*     */ import java.awt.Point;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ToolkitContentPane
/*     */   extends JPanel
/*     */ {
/*  20 */   private Point mouse = null;
/*  21 */   public Point getMouse() { return this.mouse; } public void setMouse(Point pt) {
/*  22 */     this.mouse = pt;
/*     */   }
/*     */   private boolean dataDragging = false;
/*  25 */   public boolean isDataDragging() { return this.dataDragging; } public void setDataDragging(boolean dataDragging) {
/*  26 */     this.dataDragging = dataDragging;
/*     */   }
/*     */   private boolean draggingImageFile = false;
/*  29 */   public boolean isDraggingImageFile() { return this.draggingImageFile; } public void setDraggingImageFile(boolean draggingImageFile) {
/*  30 */     this.draggingImageFile = draggingImageFile;
/*     */   }
/*     */   private boolean mouseBeingDragged = false;
/*  33 */   public boolean isMouseBeingDragged() { return this.mouseBeingDragged; } public void setMouseBeingDragged(boolean b) {
/*  34 */     this.mouseBeingDragged = b;
/*     */   }
/*  36 */   private PhotoPoint toDragPhotoPoint = new PhotoPoint();
/*  37 */   Point tip = new Point();
/*  38 */   private double[] angles = null;
/*     */   
/*  40 */   private ToolkitTransferHandler tth = null;
/*     */   private TCPDropTargetListener dtListener;
/*  42 */   private int acceptableActions = 3;
/*     */   
/*  44 */   private Image fileDraggingImage = null;
/*     */ 
/*     */   
/*     */   private boolean draggingManyFiles = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public ToolkitContentPane() {
/*     */     try {
/*  53 */       this.tth = new ToolkitTransferHandler();
/*  54 */       setTransferHandler(this.tth);
/*     */ 
/*     */       
/*  57 */       this.dtListener = new TCPDropTargetListener();
/*  58 */       getDropTarget().addDropTargetListener(this.dtListener);
/*     */       
/*  60 */       MediaTracker tracker = null;
/*     */ 
/*     */       
/*  63 */       try { tracker = new MediaTracker(this);
/*  64 */         this.fileDraggingImage = ImageUtil.loadFileImage();
/*  65 */         tracker.addImage(this.fileDraggingImage, 0);
/*  66 */         tracker.waitForAll(); }
/*     */       
/*  68 */       catch (Exception exception) {  }
/*  69 */       finally { tracker = null; }
/*     */ 
/*     */     
/*  72 */     } catch (Exception e) {
/*     */       
/*  74 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  83 */     super.paint(g);
/*     */     
/*  85 */     if (isDataDragging() && this.mouse != null)
/*     */     {
/*  87 */       g.drawImage(this.fileDraggingImage, this.mouse.x, this.mouse.y, this);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  92 */     if (this.mouseBeingDragged && this.mouse != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  98 */       if (this.mouse == null)
/*     */         return; 
/* 100 */       this.toDragPhotoPoint.setX(this.mouse.x);
/* 101 */       this.toDragPhotoPoint.setY(this.mouse.y);
/* 102 */       this.toDragPhotoPoint.paint(g);
/*     */       
/* 104 */       MultiPhotoUtil.getInstance().setPhotoPoint(this.toDragPhotoPoint);
/* 105 */       this.angles = MultiPhotoUtil.getInstance().getAngles();
/*     */       
/* 107 */       for (int i = 0; i < this.angles.length; i++) {
/*     */ 
/*     */         
/* 110 */         this.tip.x = (int)(this.mouse.x + 25.0D * Math.cos(this.angles[i]));
/* 111 */         this.tip.y = (int)(this.mouse.y + 25.0D * Math.sin(this.angles[i]));
/* 112 */         Arrow arrow = new Arrow(this.mouse, this.tip);
/* 113 */         if (i == 0) { arrow.setColor(Color.blue); }
/* 114 */         else if (i < this.angles.length - 1) { arrow.setColor(Color.black); }
/* 115 */         else { arrow.setColor(Color.red); }
/* 116 */          arrow.paint(g);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDraggingManyFiles() {
/* 127 */     return this.draggingManyFiles;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDraggingManyFiles(boolean draggingManyFiles) {
/* 133 */     this.draggingManyFiles = draggingManyFiles;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ToolkitContentPane.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */