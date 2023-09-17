/*     */ package com.vadosity.vnav.applet;
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
/*     */ public class MyDocumentListener
/*     */   implements DocumentListener
/*     */ {
/*     */   final AppletTextViewPanel this$0;
/*     */   
/*     */   protected MyDocumentListener(AppletTextViewPanel paramAppletTextViewPanel) {
/*  96 */     this.this$0 = paramAppletTextViewPanel;
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
/* 108 */     this.this$0.editorPane.getCaret().setSelectionVisible(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\applet\AppletTextViewPanel$MyDocumentListener.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */