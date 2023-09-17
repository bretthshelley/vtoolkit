/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Polygon;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ 
/*    */ public class NextButton
/*    */   extends JButton
/*    */ {
/*    */   public void paint(Graphics g) {
/* 14 */     super.paint(g);
/*    */     
/* 16 */     int centerx = (getSize()).width / 2;
/* 17 */     int centery = (getSize()).height / 2;
/*    */     
/* 19 */     int leftx = centerx - 4;
/* 20 */     int rightx = centerx + 4;
/* 21 */     int topy = centery - 8;
/* 22 */     int bottomy = centery + 8;
/* 23 */     Polygon p = new Polygon();
/*    */     
/* 25 */     p.addPoint(leftx, topy);
/* 26 */     p.addPoint(rightx, centery);
/* 27 */     p.addPoint(leftx, bottomy);
/* 28 */     g.setColor(Color.black);
/*    */     
/* 30 */     g.fillPolygon(p);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public NextButton() {
/*    */     try {
/* 37 */       jbInit();
/*    */     }
/* 39 */     catch (Exception e) {
/* 40 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 44 */     addActionListener(new NextButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 49 */     Global.stopRunner();
/* 50 */     Global.selectNextPhoto(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\NextButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */