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
/*    */ 
/*    */ public class GifFileFilter
/*    */   extends FileFilter
/*    */ {
/*    */   public static final String GIF_FILE_EXTENSION = ".gif";
/*    */   
/*    */   public boolean accept(File file) {
/* 19 */     if (file == null) return false; 
/* 20 */     if (file.isDirectory()) return true;
/*    */     
/* 22 */     String path = file.getAbsolutePath().trim().toLowerCase();
/* 23 */     if (path.endsWith(".gif")) return true;
/*    */     
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 30 */     return "GIF image files";
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\filefilter\GifFileFilter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */