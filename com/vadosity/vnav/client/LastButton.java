/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Polygon;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ public class LastButton
/*    */   extends JButton {
/*    */   public LastButton() {
/*    */     try {
/* 13 */       jbInit();
/*    */     }
/* 15 */     catch (Exception e) {
/* 16 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 23 */     super.paint(g);
/*    */     
/* 25 */     int centerx = (getSize()).width / 2;
/* 26 */     int centery = (getSize()).height / 2;
/*    */     
/* 28 */     int leftx = centerx - 4;
/* 29 */     int rightx = centerx + 4;
/* 30 */     int topy = centery - 8;
/* 31 */     int bottomy = centery + 8;
/* 32 */     Polygon p = new Polygon();
/*    */     
/* 34 */     p.addPoint(leftx, topy);
/* 35 */     p.addPoint(rightx, centery);
/* 36 */     p.addPoint(leftx, bottomy);
/* 37 */     g.setColor(Color.black);
/*    */     
/* 39 */     g.drawLine(rightx + 1, topy, rightx + 1, bottomy);
/* 40 */     g.drawLine(rightx + 2, topy, rightx + 2, bottomy);
/*    */     
/* 42 */     g.fillPolygon(p);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 48 */     addActionListener(new LastButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 53 */     Global.stopRunner();
/* 54 */     Global.selectLastPhoto(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\LastButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */