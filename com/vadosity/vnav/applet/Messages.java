/*    */ package com.vadosity.vnav.applet;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Messages
/*    */ {
/*    */   private static final String BUNDLE_NAME = "com.vadosity.vnav.applet.messages";
/* 22 */   private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("com.vadosity.vnav.applet.messages");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getString(String key) {
/*    */     try {
/* 30 */       return RESOURCE_BUNDLE.getString(key);
/* 31 */     } catch (MissingResourceException e) {
/* 32 */       return String.valueOf('!') + key + '!';
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\applet\Messages.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */