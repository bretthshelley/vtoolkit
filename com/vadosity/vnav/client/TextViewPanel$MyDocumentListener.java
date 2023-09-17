/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
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
/*     */ public class MyDocumentListener
/*     */   implements DocumentListener
/*     */ {
/*     */   final TextViewPanel this$0;
/*     */   
/*     */   protected MyDocumentListener(TextViewPanel paramTextViewPanel) {
/* 106 */     this.this$0 = paramTextViewPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertUpdate(DocumentEvent e) {}
/*     */ 
/*     */   
/*     */   public void removeUpdate(DocumentEvent e) {}
/*     */ 
/*     */   
/*     */   public void changedUpdate(DocumentEvent e) {
/* 118 */     this.this$0.editorPane.getCaret().setSelectionVisible(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\TextViewPanel$MyDocumentListener.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */