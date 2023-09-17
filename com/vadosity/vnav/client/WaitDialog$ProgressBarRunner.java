/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ProgressBarRunner
/*     */   extends Thread
/*     */ {
/*     */   public JProgressBar progressBar;
/*     */   final WaitDialog this$0;
/*     */   
/*     */   ProgressBarRunner(WaitDialog paramWaitDialog, JProgressBar pb) {
/* 151 */     this.this$0 = paramWaitDialog; this.progressBar = null;
/* 152 */     this.progressBar = pb;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/* 157 */     int counter = 0;
/*     */ 
/*     */     
/*     */     try {
/* 161 */       while (counter < 101)
/*     */       {
/* 163 */         counter += 2;
/* 164 */         this.progressBar.setValue(counter);
/* 165 */         this.progressBar.updateUI();
/* 166 */         this.progressBar.paintImmediately(0, 0, this.this$0.getWidth(), 
/* 167 */             this.this$0.getHeight());
/* 168 */         if (counter > 100) counter = 1;
/*     */         
/*     */         try {
/* 171 */           Thread.sleep(100L);
/*     */         }
/* 173 */         catch (Exception exception) {}
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 179 */     catch (Exception e) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 198 */       WaitDialog.access$0(this.this$0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\WaitDialog$ProgressBarRunner.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */