/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ViewModeButton
/*    */   extends JButton
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public ViewModeButton() {
/*    */     try {
/* 15 */       jbInit();
/* 16 */       Global.addSettingsChangeListener(this);
/* 17 */       setSelected(false);
/*    */     }
/* 19 */     catch (Exception e) {
/*    */       
/* 21 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 28 */     setIcon(new ImageIcon(ImageUtil.loadBinoImage()));
/* 29 */     addActionListener(new ViewModeToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 38 */     setVisible((Settings.getMode() == 0));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 45 */     Settings.setMode(1);
/* 46 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ViewModeButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */