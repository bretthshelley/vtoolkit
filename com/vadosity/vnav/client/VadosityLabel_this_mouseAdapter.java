/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.MouseAdapter;
/*    */ import java.awt.event.MouseEvent;
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
/*    */ class VadosityLabel_this_mouseAdapter
/*    */   extends MouseAdapter
/*    */ {
/*    */   VadosityLabel adaptee;
/*    */   
/*    */   VadosityLabel_this_mouseAdapter(VadosityLabel adaptee) {
/* 60 */     this.adaptee = adaptee;
/*    */   }
/*    */   public void mouseClicked(MouseEvent e) {
/* 63 */     this.adaptee.this_mouseClicked(e);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\VadosityLabel_this_mouseAdapter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */