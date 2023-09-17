/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Polygon;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.SwingUtilities;
/*    */ import javax.swing.UIManager;
/*    */ 
/*    */ public class FirstButton extends JButton {
/*    */   public FirstButton() {
/*    */     try {
/* 14 */       jbInit();
/* 15 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/* 16 */       UIManager.setLookAndFeel(nativeLF);
/* 17 */       SwingUtilities.updateComponentTreeUI(this);
/* 18 */       updateUI();
/*    */     
/*    */     }
/* 21 */     catch (Exception e) {
/* 22 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 29 */     super.paint(g);
/*    */ 
/*    */     
/* 32 */     int centerx = (getSize()).width / 2;
/* 33 */     int centery = (getSize()).height / 2;
/*    */     
/* 35 */     int leftx = centerx - 4;
/* 36 */     int rightx = centerx + 4;
/* 37 */     int topy = centery - 8;
/* 38 */     int bottomy = centery + 8;
/* 39 */     Polygon p = new Polygon();
/*    */     
/* 41 */     p.addPoint(leftx, centery);
/* 42 */     p.addPoint(rightx, topy);
/* 43 */     p.addPoint(rightx, bottomy);
/* 44 */     p.addPoint(leftx, centery);
/* 45 */     g.setColor(Color.black);
/*    */     
/* 47 */     g.drawLine(leftx - 1, topy, leftx - 1, bottomy);
/* 48 */     g.drawLine(leftx - 2, topy, leftx - 2, bottomy);
/*    */     
/* 50 */     g.fillPolygon(p);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 56 */     addActionListener(new FirstButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 61 */     Global.stopRunner();
/* 62 */     Global.selectFirstPhoto(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\FirstButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */