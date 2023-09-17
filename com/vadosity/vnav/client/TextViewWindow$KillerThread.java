/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import javax.swing.ToolTipManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class KillerThread
/*    */   extends Thread
/*    */ {
/*    */   TextViewWindow tf;
/*    */   final TextViewWindow this$0;
/*    */   
/*    */   KillerThread(TextViewWindow paramTextViewWindow1, TextViewWindow tf) {
/* 60 */     this.this$0 = paramTextViewWindow1;
/*    */     this.tf = null;
/* 62 */     this.tf = tf;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/*    */     try {
/* 69 */       Thread.sleep((ToolTipManager.sharedInstance().getDismissDelay() * 3));
/* 70 */       this.tf.dispose();
/*    */     }
/* 72 */     catch (Exception e) {
/*    */       
/* 74 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\TextViewWindow$KillerThread.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */