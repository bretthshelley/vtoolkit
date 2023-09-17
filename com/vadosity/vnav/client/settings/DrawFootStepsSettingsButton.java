/*    */ package com.vadosity.vnav.client.settings;
/*    */ 
/*    */ import com.vadosity.vnav.client.Global;
/*    */ import com.vadosity.vnav.client.Settings;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.JToggleButton;
/*    */ 
/*    */ public class DrawFootStepsSettingsButton
/*    */   extends JToggleButton
/*    */ {
/*    */   protected boolean mouseIn = false;
/*    */   
/*    */   public void paint(Graphics g) {
/* 16 */     super.paint(g);
/*    */     
/* 18 */     int w = getWidth();
/* 19 */     int h = getHeight();
/*    */     
/* 21 */     int bigx = 5 * w / 10;
/* 22 */     int bigw = 4 * w / 10;
/* 23 */     int bigy = 3 * h / 10;
/* 24 */     int bigh = 4 * h / 10;
/*    */     
/* 26 */     int smallx = 2 * w / 10;
/* 27 */     int smallw = (int)(2.5D * w / 10.0D);
/* 28 */     int smally = (int)(3.5D * h / 10.0D);
/* 29 */     int smallh = 3 * h / 10;
/*    */     
/* 31 */     if (this.mouseIn) {
/*    */       
/* 33 */       if (Settings.getSelectedFootstepFillColor() != null) {
/*    */         
/* 35 */         g.setColor(Settings.getSelectedFootstepFillColor());
/* 36 */         g.fillOval(bigx, bigy, bigw, bigh);
/* 37 */         g.fillOval(smallx, smally, smallw, smallh);
/*    */       } 
/* 39 */       g.setColor(Settings.getSelectedFootstepOutlineColor());
/* 40 */       g.drawOval(bigx, bigy, bigw, bigh);
/* 41 */       g.drawOval(smallx, smally, smallw, smallh);
/*    */     }
/*    */     else {
/*    */       
/* 45 */       if (Settings.getFootstepFillColor() != null) {
/*    */         
/* 47 */         g.setColor(Settings.getFootstepFillColor());
/* 48 */         g.fillOval(bigx, bigy, bigw, bigh);
/* 49 */         g.fillOval(smallx, smally, smallw, smallh);
/*    */       } 
/* 51 */       g.setColor(Settings.getFootstepOutlineColor());
/* 52 */       g.drawOval(bigx, bigy, bigw, bigh);
/* 53 */       g.drawOval(smallx, smally, smallw, smallh);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DrawFootStepsSettingsButton() {
/*    */     try {
/* 62 */       jbInit();
/*    */       
/* 64 */       setSelected(Settings.isDrawFootSteps());
/*    */     
/*    */     }
/* 67 */     catch (Exception e) {
/* 68 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 72 */     addActionListener(new DrawFootStepsSettingsButton_this_actionAdapter(this));
/* 73 */     addMouseListener(new DrawFootStepsSettingsButton_this_mouseAdapter(this));
/*    */   }
/*    */   
/*    */   void this_mouseEntered(MouseEvent e) {
/* 77 */     this.mouseIn = true;
/* 78 */     updateUI();
/*    */   }
/*    */   
/*    */   void this_mouseExited(MouseEvent e) {
/* 82 */     this.mouseIn = false;
/* 83 */     updateUI();
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 88 */     Settings.setDrawFootSteps(isSelected());
/* 89 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\DrawFootStepsSettingsButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */