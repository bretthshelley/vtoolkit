/*    */ package com.vadosity.vnav.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Base64
/*    */ {
/*    */   public static String decode(String s) {
/* 12 */     if (s == null) throw new IllegalArgumentException("argument is null");
/*    */     
/* 14 */     StringBuffer buf = new StringBuffer();
/* 15 */     for (int i = 0; i < s.length(); i++) {
/*    */       
/* 17 */       char ithChar = s.charAt(i);
/* 18 */       ithChar = (char)(ithChar - 5);
/* 19 */       buf.append(ithChar);
/*    */     } 
/* 21 */     return buf.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public static String encode(String s) {
/* 26 */     if (s == null) throw new IllegalArgumentException("argument is null");
/*    */     
/* 28 */     StringBuffer buf = new StringBuffer();
/* 29 */     for (int i = 0; i < s.length(); i++) {
/*    */       
/* 31 */       char ithChar = s.charAt(i);
/* 32 */       ithChar = (char)(ithChar + 5);
/* 33 */       buf.append(ithChar);
/*    */     } 
/* 35 */     return buf.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\bean\Base64.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */