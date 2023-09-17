/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JToggleButton;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RunToggleButton
/*    */   extends JToggleButton
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public RunToggleButton() {
/*    */     try {
/* 15 */       jbInit();
/* 16 */       Global.addSettingsChangeListener(this);
/* 17 */       setSelected(false);
/* 18 */       ImageIcon icon = new ImageIcon(ImageUtil.loadJogImage());
/* 19 */       if (icon == null) { setText("Run"); }
/* 20 */       else { setIcon(icon); }
/* 21 */        setToolTipText("Start Running");
/*    */     }
/* 23 */     catch (Exception e) {
/*    */       
/* 25 */       setText("Run");
/* 26 */       setToolTipText("Start Running");
/* 27 */       updateUI();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 34 */     addActionListener(new JogToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 43 */     if (Global.getAutoRunner() == null || !Global.getAutoRunner().isAlive()) {
/*    */ 
/*    */       
/* 46 */       setSelected(false);
/*    */ 
/*    */     
/*    */     }
/* 50 */     else if (AutoRunner.getSleepTime() == 500L) {
/*    */       
/* 52 */       setSelected(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 59 */     if (Global.getTour() == null || Global.getView() == null) {
/*    */       return;
/*    */     }
/* 62 */     if (Global.getAutoRunner() != null && Global.getAutoRunner().isAlive()) {
/*    */       
/* 64 */       Global.getAutoRunner().interrupt();
/* 65 */       Global.setAutoRunner(null);
/* 66 */       Global.fireSettingsChanged(this);
/*    */     } 
/* 68 */     setSelected(true);
/* 69 */     updateUI();
/* 70 */     AutoRunner runner = new AutoRunner();
/* 71 */     runner.setRunForward(true);
/* 72 */     AutoRunner.setSleepTime(500L);
/* 73 */     runner.start();
/* 74 */     Global.setAutoRunner(runner);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\RunToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */