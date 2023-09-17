/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ 
/*    */ public class PhotoBytes {
/*  7 */   private byte[] bytes = null;
/*  8 */   public byte[] getBytes() { return this.bytes; } public void setBytes(byte[] bytes) {
/*  9 */     this.bytes = bytes;
/*    */   }
/*    */ 
/*    */   
/*    */   public PhotoBytes() {}
/*    */ 
/*    */   
/*    */   public PhotoBytes(byte[] bytes) {
/* 17 */     setBytes(bytes);
/*    */   }
/*    */ 
/*    */   
/*    */   public PhotoBytes(File f) {
/* 22 */     if (f == null) {
/* 23 */       throw new IllegalArgumentException("file is null");
/*    */     }
/*    */     try {
/* 26 */       FileInputStream fis = new FileInputStream(f);
/* 27 */       this.bytes = new byte[fis.available()];
/* 28 */       fis.read(this.bytes);
/*    */     }
/* 30 */     catch (Exception e) {
/*    */       
/* 32 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PhotoBytes(String filename) {
/* 39 */     if (filename == null || filename.trim().equalsIgnoreCase("")) {
/* 40 */       throw new IllegalArgumentException("filename argument is null");
/*    */     }
/*    */     try {
/* 43 */       File f = new File(filename);
/* 44 */       FileInputStream fis = new FileInputStream(f);
/* 45 */       this.bytes = new byte[fis.available()];
/* 46 */       fis.read(this.bytes);
/*    */     }
/* 48 */     catch (Exception e) {
/*    */       
/* 50 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\PhotoBytes.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */