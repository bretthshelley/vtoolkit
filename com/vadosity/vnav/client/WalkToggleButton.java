/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JToggleButton;
/*    */ 
/*    */ 
/*    */ public class WalkToggleButton
/*    */   extends JToggleButton
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public WalkToggleButton() {
/*    */     try {
/* 14 */       jbInit();
/* 15 */       Global.addSettingsChangeListener(this);
/* 16 */       setSelected(false);
/* 17 */       setIcon(new ImageIcon(ImageUtil.loadWalkImage()));
/* 18 */       setToolTipText("Start Walking");
/*    */     }
/* 20 */     catch (Exception e) {
/*    */       
/* 22 */       setText("Walk");
/* 23 */       setToolTipText("Start Walking");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 30 */     addActionListener(new WalkToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 39 */     if (Global.getAutoRunner() == null || !Global.getAutoRunner().isAlive()) {
/*    */ 
/*    */       
/* 42 */       setSelected(false);
/*    */ 
/*    */     
/*    */     }
/* 46 */     else if (AutoRunner.getSleepTime() == 1000L) {
/*    */       
/* 48 */       setSelected(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 55 */     if (Global.getTour() == null || Global.getView() == null) {
/*    */       return;
/*    */     }
/* 58 */     if (Global.getAutoRunner() != null && Global.getAutoRunner().isAlive()) {
/*    */       
/* 60 */       Global.getAutoRunner().interrupt();
/* 61 */       Global.setAutoRunner(null);
/* 62 */       Global.fireSettingsChanged(this);
/*    */     } 
/* 64 */     setSelected(true);
/* 65 */     updateUI();
/* 66 */     AutoRunner runner = new AutoRunner();
/* 67 */     runner.setRunForward(true);
/* 68 */     AutoRunner.setSleepTime(1000L);
/* 69 */     runner.start();
/* 70 */     Global.setAutoRunner(runner);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\WalkToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */