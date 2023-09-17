/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.util.MissingResourceException;
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Messages
/*    */ {
/*    */   private static final String BUNDLE_NAME = "com.vadosity.vnav.client.messages";
/* 15 */   private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("com.vadosity.vnav.client.messages");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getString(String key) {
/*    */     try {
/* 23 */       return RESOURCE_BUNDLE.getString(key);
/*    */     }
/* 25 */     catch (MissingResourceException e) {
/*    */       
/* 27 */       return String.valueOf('!') + key + '!';
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\Messages.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */