/*    */ package com.vadosity.vnav;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Formatter
/*    */ {
/*    */   public static boolean isHTMLEmpty(String html) {
/*  8 */     if (html == null) return true;
/*    */     
/* 10 */     if (html.trim().equals("")) return true;
/*    */     
/* 12 */     String text = html.trim();
/*    */     
/* 14 */     int start = text.indexOf("<body>");
/* 15 */     int finish = text.indexOf("</body>");
/* 16 */     if (start == -1) return false; 
/* 17 */     if (finish == -1) return false; 
/* 18 */     start += 6;
/* 19 */     String body = text.substring(start, finish).trim();
/* 20 */     body = body.trim().toLowerCase();
/*    */     
/* 22 */     body = replaceAll(body, "<p>", "");
/* 23 */     body = replaceAll(body, "</p>", "");
/* 24 */     body = replaceAll(body, "<b>", "");
/* 25 */     body = replaceAll(body, "</b>", "");
/*    */     
/* 27 */     if (body.trim().equals("")) return true; 
/* 28 */     return false;
/*    */   }
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
/*    */   public static String replaceAll(String base, String sought, String replacement) {
/* 43 */     if (base == null) return base; 
/* 44 */     if (sought == null) return base; 
/* 45 */     if (replacement == null) return base;
/*    */     
/* 47 */     int startIndex = 0;
/* 48 */     int index = 0;
/* 49 */     String before = null, after = null;
/* 50 */     while ((index = base.indexOf(sought, startIndex)) != -1) {
/*    */       
/* 52 */       int lastIndex = base.length() - 1;
/* 53 */       before = (index == 0) ? "" : base.substring(0, index);
/* 54 */       after = (index == lastIndex) ? "" : base.substring(index + sought.length());
/* 55 */       base = String.valueOf(before) + replacement + after;
/* 56 */       startIndex = before.length() + replacement.length();
/*    */     } 
/* 58 */     return base;
/*    */   }
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
/*    */   public static String replaceAll(String base, int character, String replacement) {
/* 71 */     if (base == null || base.trim().equals("")) return base; 
/* 72 */     if (character < 1)
/* 73 */       throw new IllegalArgumentException("character argument cannot be less than one."); 
/* 74 */     if (replacement == null) replacement = ""; 
/* 75 */     if (replacement.length() == 1 && replacement.charAt(0) == character) {
/* 76 */       return base;
/*    */     }
/* 78 */     String result = new String(base);
/* 79 */     int i = result.indexOf(character);
/* 80 */     if (i == -1) return result; 
/* 81 */     String before = null, after = null;
/* 82 */     while (i != -1) {
/*    */       
/* 84 */       int lastIndex = result.length() - 1;
/* 85 */       before = (i == 0) ? "" : result.substring(0, i);
/* 86 */       after = (i == lastIndex) ? "" : result.substring(i + 1);
/* 87 */       result = String.valueOf(before) + replacement + after;
/* 88 */       int seekFrom = before.length() + replacement.length();
/* 89 */       i = result.indexOf(character, seekFrom);
/*    */     } 
/* 91 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\Formatter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */