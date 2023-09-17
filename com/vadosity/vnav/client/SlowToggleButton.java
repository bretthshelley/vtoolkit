/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JToggleButton;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ 
/*    */ public class SlowToggleButton
/*    */   extends JToggleButton
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public SlowToggleButton() {
/*    */     try {
/* 16 */       addActionListener(new ActionListener(this) { final SlowToggleButton this$0;
/*    */             
/*    */             public void actionPerformed(ActionEvent e) {
/* 19 */               if (Global.getTour() == null || Global.getView() == null) {
/*    */                 return;
/*    */               }
/*    */ 
/*    */               
/* 24 */               if (Global.getAutoRunner() != null && Global.getAutoRunner().isAlive()) {
/*    */                 
/* 26 */                 Global.getAutoRunner().interrupt();
/* 27 */                 Global.setAutoRunner(null);
/* 28 */                 Global.fireSettingsChanged(this);
/*    */               } 
/* 30 */               this.this$0.setSelected(true);
/* 31 */               this.this$0.updateUI();
/* 32 */               AutoRunner runner = new AutoRunner();
/* 33 */               runner.setRunForward(true);
/* 34 */               AutoRunner.setSleepTime(4000L);
/* 35 */               runner.start();
/* 36 */               Global.setAutoRunner(runner);
/*    */             } }
/*    */         );
/*    */ 
/*    */       
/* 41 */       Global.addSettingsChangeListener(this);
/* 42 */       setSelected(false);
/* 43 */       setIcon(new ImageIcon(ImageUtil.loadSlowImage()));
/* 44 */       setToolTipText("Move Slowly thru Tour");
/*    */     }
/* 46 */     catch (Exception e) {
/*    */       
/* 48 */       setText("Slow");
/* 49 */       setToolTipText("Move Slowly thru Tour");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 59 */     if (Global.getAutoRunner() == null || !Global.getAutoRunner().isAlive()) {
/*    */       
/* 61 */       SwingUtilities.invokeLater(new Runnable(this) { public void run() { this.this$0.setSelected(false); }
/*    */             
/*    */             final SlowToggleButton this$0; }
/*    */         );
/* 65 */     } else if (AutoRunner.getSleepTime() == 4000L) {
/*    */       
/* 67 */       SwingUtilities.invokeLater(new Runnable(this) { public void run() { this.this$0.setSelected(true); }
/*    */ 
/*    */             
/*    */             final SlowToggleButton this$0; }
/*    */         );
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\SlowToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */