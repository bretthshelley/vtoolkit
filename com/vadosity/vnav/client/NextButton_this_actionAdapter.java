/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
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
/*    */ class NextButton_this_actionAdapter
/*    */   implements ActionListener
/*    */ {
/*    */   NextButton adaptee;
/*    */   
/*    */   NextButton_this_actionAdapter(NextButton adaptee) {
/* 59 */     this.adaptee = adaptee;
/*    */   }
/*    */   public void actionPerformed(ActionEvent e) {
/* 62 */     this.adaptee.this_actionPerformed(e);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\NextButton_this_actionAdapter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */