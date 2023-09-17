/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StopButton
/*    */   extends JButton
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public StopButton() {
/*    */     try {
/* 16 */       jbInit();
/* 17 */       Global.addSettingsChangeListener(this);
/* 18 */       setIcon(new ImageIcon(ImageUtil.loadStopImage()));
/* 19 */       setToolTipText("Stop Auto-Tour");
/*    */     }
/* 21 */     catch (Exception e) {
/*    */       
/* 23 */       setText("Stop");
/* 24 */       setToolTipText("Stop Auto-Tour");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 31 */     addActionListener(new StopToggleButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 40 */     if (Global.getAutoRunner() == null || !Global.getAutoRunner().isAlive()) {
/*    */       
/* 42 */       SwingUtilities.invokeLater(new Runnable(this) { public void run() { this.this$0.setVisible(false); this.this$0.updateUI(); }
/*    */              final StopButton this$0; }
/*    */         );
/*    */     } else {
/* 46 */       SwingUtilities.invokeLater(new Runnable(this) { public void run() { this.this$0.setVisible(true); this.this$0.updateUI(); }
/*    */              final StopButton this$0; }
/*    */         );
/*    */     } 
/*    */   }
/*    */   void this_actionPerformed(ActionEvent e) {
/* 52 */     if (Global.getTour() == null || Global.getView() == null) {
/*    */       return;
/*    */     }
/* 55 */     if (Global.getAutoRunner() != null && Global.getAutoRunner().isAlive()) {
/*    */       
/* 57 */       Global.getAutoRunner().interrupt();
/* 58 */       Global.setAutoRunner(null);
/* 59 */       Global.fireSettingsChanged(this);
/*    */     } 
/* 61 */     updateUI();
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\StopButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */