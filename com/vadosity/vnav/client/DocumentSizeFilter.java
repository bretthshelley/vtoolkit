/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.Toolkit;
/*    */ import javax.swing.text.AttributeSet;
/*    */ import javax.swing.text.BadLocationException;
/*    */ import javax.swing.text.DocumentFilter;
/*    */ 
/*    */ public class DocumentSizeFilter
/*    */   extends DocumentFilter {
/*    */   public DocumentSizeFilter(int maxChars) {
/* 11 */     this.maxCharacters = maxChars;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   int maxCharacters;
/*    */   
/*    */   boolean DEBUG = false;
/*    */ 
/*    */   
/*    */   public void insertString(DocumentFilter.FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
/* 22 */     if (fb.getDocument().getLength() + str.length() <= this.maxCharacters) {
/* 23 */       super.insertString(fb, offs, str, a);
/*    */     } else {
/* 25 */       Toolkit.getDefaultToolkit().beep();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void replace(DocumentFilter.FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
/* 36 */     if (fb.getDocument().getLength() + str.length() - 
/* 37 */       length <= this.maxCharacters) {
/* 38 */       super.replace(fb, offs, length, str, a);
/*    */     } else {
/* 40 */       Toolkit.getDefaultToolkit().beep();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\DocumentSizeFilter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */