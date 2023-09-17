/*    */ package com.vadosity.vnav.applet;
/*    */ 
/*    */ import java.applet.Applet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AppletUtil
/*    */ {
/* 10 */   private static Applet applet = null;
/*    */   
/*    */   public static void setInstance(Applet a) {
/* 13 */     System.out.println(" instance set to : " + a);
/* 14 */     applet = a;
/*    */   } public static Applet getInstance() {
/* 16 */     return applet;
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\applet\AppletUtil.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */