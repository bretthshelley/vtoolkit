/*    */ package com.vadosity.vnav.client.filefilter;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.swing.filechooser.FileFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JpegFileFilter
/*    */   extends FileFilter
/*    */ {
/*    */   public boolean accept(File file) {
/* 16 */     if (file == null) return false; 
/* 17 */     if (file.isDirectory()) return true;
/*    */     
/* 19 */     String path = file.getAbsolutePath().trim().toLowerCase();
/* 20 */     if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return true;
/*    */     
/* 22 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 30 */     return "JPG (jpg,jpeg) files";
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\filefilter\JpegFileFilter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */