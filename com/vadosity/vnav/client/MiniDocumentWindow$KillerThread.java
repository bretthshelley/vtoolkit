/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import javax.swing.ToolTipManager;
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
/*     */ class KillerThread
/*     */   extends Thread
/*     */ {
/*     */   MiniDocumentWindow mdWindow;
/*     */   final MiniDocumentWindow this$0;
/*     */   
/*     */   KillerThread(MiniDocumentWindow paramMiniDocumentWindow1, MiniDocumentWindow mdWindow) {
/*  93 */     this.this$0 = paramMiniDocumentWindow1;
/*     */     this.mdWindow = null;
/*  95 */     this.mdWindow = mdWindow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 102 */       Thread.sleep(ToolTipManager.sharedInstance().getDismissDelay());
/* 103 */       this.mdWindow.dispose();
/*     */     }
/* 105 */     catch (Exception e) {
/*     */       
/* 107 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\MiniDocumentWindow$KillerThread.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */