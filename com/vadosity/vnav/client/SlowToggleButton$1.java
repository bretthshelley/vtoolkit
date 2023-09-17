/*  1 */ package com.vadosity.vnav.client;final class null implements ActionListener { null(SlowToggleButton paramSlowToggleButton) { this.this$0 = paramSlowToggleButton; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   final SlowToggleButton this$0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 19 */     if (Global.getTour() == null || Global.getView() == null) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 24 */     if (Global.getAutoRunner() != null && Global.getAutoRunner().isAlive()) {
/*    */       
/* 26 */       Global.getAutoRunner().interrupt();
/* 27 */       Global.setAutoRunner(null);
/* 28 */       Global.fireSettingsChanged(this);
/*    */     } 
/* 30 */     this.this$0.setSelected(true);
/* 31 */     this.this$0.updateUI();
/* 32 */     AutoRunner runner = new AutoRunner();
/* 33 */     runner.setRunForward(true);
/* 34 */     AutoRunner.setSleepTime(4000L);
/* 35 */     runner.start();
/* 36 */     Global.setAutoRunner(runner);
/*    */   } }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\SlowToggleButton$1.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */