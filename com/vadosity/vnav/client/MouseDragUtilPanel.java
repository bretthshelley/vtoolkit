/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.PhotoPoint;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Point;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class MouseDragUtilPanel extends JPanel {
/* 10 */   private Point mouse = null;
/* 11 */   public Point getMouse() { return this.mouse; } public void setMouse(Point pt) {
/* 12 */     this.mouse = pt;
/*    */   }
/*    */   private boolean mouseBeingDragged = false;
/* 15 */   public boolean isMouseBeingDragged() { return this.mouseBeingDragged; } public void setMouseBeingDragged(boolean b) {
/* 16 */     this.mouseBeingDragged = b;
/*    */   }
/* 18 */   private PhotoPoint toDragPhotoPoint = new PhotoPoint();
/* 19 */   Point tip = new Point();
/* 20 */   private double[] angles = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 31 */     super.paint(g);
/*    */ 
/*    */     
/* 34 */     if (this.mouseBeingDragged && this.mouse != null) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 40 */       if (this.mouse == null)
/*    */         return; 
/* 42 */       this.toDragPhotoPoint.setX(this.mouse.x);
/* 43 */       this.toDragPhotoPoint.setY(this.mouse.y);
/* 44 */       this.toDragPhotoPoint.paint(g);
/*    */       
/* 46 */       MultiPhotoUtil.getInstance().setPhotoPoint(this.toDragPhotoPoint);
/* 47 */       this.angles = MultiPhotoUtil.getInstance().getAngles();
/*    */       
/* 49 */       for (int i = 0; i < this.angles.length; i++) {
/*    */ 
/*    */         
/* 52 */         this.tip.x = (int)(this.mouse.x + 25.0D * Math.cos(this.angles[i]));
/* 53 */         this.tip.y = (int)(this.mouse.y + 25.0D * Math.sin(this.angles[i]));
/* 54 */         Arrow arrow = new Arrow(this.mouse, this.tip);
/* 55 */         if (i == 0) { arrow.setColor(Color.blue); }
/* 56 */         else if (i < this.angles.length - 1) { arrow.setColor(Color.black); }
/* 57 */         else { arrow.setColor(Color.red); }
/* 58 */          arrow.paint(g);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\MouseDragUtilPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */