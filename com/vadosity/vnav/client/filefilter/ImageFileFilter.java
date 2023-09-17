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
/*    */ public class ImageFileFilter
/*    */   extends FileFilter
/*    */ {
/*    */   public boolean accept(File file) {
/* 15 */     if (file == null) return false; 
/* 16 */     if (file.isDirectory()) return true;
/*    */     
/* 18 */     String path = file.getAbsolutePath().trim().toLowerCase();
/* 19 */     if (path.endsWith(".jpg") || path.endsWith(".gif")) return true;
/*    */     
/* 21 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 26 */     return "JPG or GIF image files";
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\filefilter\ImageFileFilter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */