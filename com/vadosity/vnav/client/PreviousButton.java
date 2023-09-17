/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Polygon;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ public class PreviousButton
/*    */   extends JButton {
/*    */   public void paint(Graphics g) {
/* 12 */     super.paint(g);
/*    */     
/* 14 */     int centerx = (getSize()).width / 2;
/* 15 */     int centery = (getSize()).height / 2;
/*    */     
/* 17 */     int leftx = centerx - 4;
/* 18 */     int rightx = centerx + 4;
/* 19 */     int topy = centery - 8;
/* 20 */     int bottomy = centery + 8;
/* 21 */     Polygon p = new Polygon();
/*    */     
/* 23 */     p.addPoint(leftx, centery);
/* 24 */     p.addPoint(rightx, topy);
/* 25 */     p.addPoint(rightx, bottomy);
/* 26 */     p.addPoint(leftx, centery);
/* 27 */     g.setColor(Color.black);
/*    */     
/* 29 */     g.fillPolygon(p);
/*    */   }
/*    */ 
/*    */   
/*    */   public PreviousButton() {
/*    */     try {
/* 35 */       jbInit();
/*    */     }
/* 37 */     catch (Exception e) {
/* 38 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 42 */     addActionListener(new PreviousButton_this_actionAdapter(this));
/*    */   }
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 46 */     Global.stopRunner();
/* 47 */     Global.selectPreviousPhoto(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\PreviousButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */