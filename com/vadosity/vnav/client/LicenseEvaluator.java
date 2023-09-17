/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LicenseEvaluator
/*     */ {
/*     */   private static String fixKey(String key) {
/*  13 */     StringBuffer s = new StringBuffer();
/*     */     
/*  15 */     for (int i = 0; i < key.length(); i++) {
/*     */       
/*  17 */       if (Character.isLetter(key.charAt(i)) || Character.isDigit(key.charAt(i)))
/*     */       {
/*  19 */         s.append(key.charAt(i));
/*     */       }
/*     */     } 
/*  22 */     return s.toString().toUpperCase();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isLengthOk(String key) {
/*  27 */     if (key == null) return false; 
/*  28 */     if (key.trim().equals("")) return false;
/*     */     
/*  30 */     return (isLetterLengthOk(key) && isDigitLengthOk(key));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isLetterLengthOk(String key) {
/*  37 */     if (key == null) return false; 
/*  38 */     if (key.trim().equals("")) return false;
/*     */     
/*  40 */     String s = key.toUpperCase().trim();
/*     */     
/*  42 */     int count = 0;
/*  43 */     for (int i = 0; i < s.length(); i++) {
/*     */       
/*  45 */       if (Character.isLetter(s.charAt(i))) count++; 
/*     */     } 
/*  47 */     return (count == 20);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isDigitLengthOk(String key) {
/*  52 */     if (key == null) return false; 
/*  53 */     if (key.trim().equals("")) return false;
/*     */     
/*  55 */     String s = key.toUpperCase().trim();
/*     */     
/*  57 */     int count = 0;
/*  58 */     for (int i = 0; i < s.length(); i++) {
/*     */       
/*  60 */       if (Character.isDigit(s.charAt(i))) count++; 
/*     */     } 
/*  62 */     return (count == 5);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getLetters(String key) {
/*  67 */     String s = key.toUpperCase().trim();
/*  68 */     StringBuffer buf = new StringBuffer(20);
/*     */     
/*  70 */     int count = 0;
/*  71 */     for (int i = 0; i < s.length(); i++) {
/*     */       
/*  73 */       if (Character.isLetter(s.charAt(i))) buf.append(s.charAt(i)); 
/*     */     } 
/*  75 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getDigits(String key) {
/*  80 */     String s = key.toUpperCase().trim();
/*  81 */     StringBuffer buf = new StringBuffer(20);
/*     */     
/*  83 */     int count = 0;
/*  84 */     for (int i = 0; i < s.length(); i++) {
/*     */       
/*  86 */       if (Character.isDigit(s.charAt(i))) buf.append(s.charAt(i)); 
/*     */     } 
/*  88 */     return buf.toString();
/*     */   }
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
/*     */   public static boolean isKeyOk(String key) {
/*     */     try {
/* 105 */       key = fixKey(key);
/*     */       
/* 107 */       if (!isLengthOk(key)) return false;
/*     */       
/* 109 */       int[] mix = {
/*     */           
/* 111 */           0, 0, 1, 
/* 112 */           1, 
/* 113 */           1, 
/* 114 */           1, 
/* 115 */           1
/*     */         };
/*     */       
/* 118 */       if (!String.valueOf(key.charAt(20)).equals(String.valueOf(key.charAt(4)))) return false; 
/* 119 */       if (!String.valueOf(key.charAt(21)).equals(String.valueOf(key.charAt(8)))) return false; 
/* 120 */       if (!String.valueOf(key.charAt(22)).equals(String.valueOf(key.charAt(12)))) return false; 
/* 121 */       if (!String.valueOf(key.charAt(23)).equals(String.valueOf(key.charAt(15)))) return false;
/*     */       
/* 123 */       return isNumericStringOk(key);
/*     */     }
/* 125 */     catch (Exception e) {
/*     */       
/* 127 */       e.printStackTrace();
/* 128 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String extractNumericString(String key) {
/* 134 */     StringBuffer buf = new StringBuffer();
/* 135 */     for (int i = 0; i < key.length(); i++) {
/*     */       
/* 137 */       if (Character.isDigit(key.charAt(i))) buf.append(key.charAt(i)); 
/*     */     } 
/* 139 */     return buf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isNumericStringOk(String key) {
/*     */     try {
/* 146 */       String numericString = extractNumericString(key);
/* 147 */       System.out.println("numeric string extracted in evaluator: " + numericString);
/*     */       
/* 149 */       if (numericString == null) return false; 
/* 150 */       if (numericString.length() != 5) return false;
/*     */       
/* 152 */       int firstTwo = Integer.parseInt(numericString.substring(0, 2));
/* 153 */       int third = Integer.parseInt(numericString.substring(2, 3));
/* 154 */       int lastTwo = Integer.parseInt(numericString.substring(3));
/*     */       
/* 156 */       int lastNumber = (int)Math.abs(firstTwo * Math.sin(third));
/*     */       
/* 158 */       System.out.println("last number calculated in evaluator: " + lastNumber);
/*     */       
/* 160 */       if (lastNumber == lastTwo) return true; 
/* 161 */       return false;
/*     */     }
/* 163 */     catch (Exception e) {
/*     */       
/* 165 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\LicenseEvaluator.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */