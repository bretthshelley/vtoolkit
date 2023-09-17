/*    */ package com.vadosity.vnav.client.settings;
/*    */ 
/*    */ public class Alpha
/*    */ {
/*  5 */   String label = "";
/*  6 */   int value = -1;
/*    */ 
/*    */   
/*    */   Alpha(int alpha) {
/* 10 */     this.value = alpha;
/*    */     
/* 12 */     double a = (int)((255 - alpha) / 255.0D * 10.0D);
/* 13 */     this.label = (int)(a * 10.0D) + " %";
/*    */   }
/*    */   public int getValue() {
/* 16 */     return this.value;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 20 */     return this.label;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/*    */     try {
/* 27 */       int objectValue = ((Alpha)object).getValue();
/* 28 */       if (objectValue / 25 == this.value / 25) return true; 
/* 29 */       return false;
/*    */     }
/* 31 */     catch (Exception e) {
/*    */       
/* 33 */       return false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\Alpha.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */