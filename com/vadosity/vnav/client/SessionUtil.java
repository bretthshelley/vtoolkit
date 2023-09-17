/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ 
/*    */ public class SessionUtil
/*    */ {
/*    */   public static boolean debug = false;
/*    */   
/*    */   public static String getTerraServerUrl() {
/* 13 */     return "http://terraserver-usa.com/GetImageArea.ashx";
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getToolkitPurchaseUrl() {
/* 18 */     return "http://www.vadosity.com/ToolkitPurchase.do";
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getVadosityUrl() {
/* 23 */     return "http://www.vadosity.com/Ping.html";
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getActivationUrl() {
/* 28 */     return "http://www.vadosity.com/Activation.do";
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getInternetUrl() {
/* 33 */     return "http://www.google.com";
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isInternetAvailable() {
/* 38 */     URL url = null;
/* 39 */     HttpURLConnection httpConn = null;
/*    */     
/*    */     try {
/*    */       try {
/* 43 */         url = new URL(getInternetUrl());
/* 44 */         httpConn = (HttpURLConnection)url.openConnection();
/* 45 */         httpConn.setDoInput(true);
/*    */         
/* 47 */         StringBuffer buf = new StringBuffer();
/* 48 */         InputStreamReader reader = new InputStreamReader(
/* 49 */             httpConn.getInputStream());
/* 50 */         BufferedReader br = new BufferedReader(reader);
/* 51 */         String line = null;
/* 52 */         int count = 5;
/* 53 */         while ((line = br.readLine()) != null) {
/*    */           
/* 55 */           count++;
/* 56 */           if (count == 5) return true; 
/* 57 */           buf.append(line);
/*    */         } 
/* 59 */         return true;
/*    */       } finally {
/*    */ 
/*    */ 
/*    */         
/*    */         try { 
/*    */ 
/*    */           
/* 67 */           httpConn.disconnect(); } catch (Exception exception) {}
/*    */       } 
/*    */     } catch (Exception e) {
/*    */       return false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\SessionUtil.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */