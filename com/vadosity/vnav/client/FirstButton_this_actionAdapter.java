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
/*    */ class FirstButton_this_actionAdapter
/*    */   implements ActionListener
/*    */ {
/*    */   FirstButton adaptee;
/*    */   
/*    */   FirstButton_this_actionAdapter(FirstButton adaptee) {
/* 71 */     this.adaptee = adaptee;
/*    */   }
/*    */   public void actionPerformed(ActionEvent e) {
/* 74 */     this.adaptee.this_actionPerformed(e);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\FirstButton_this_actionAdapter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */