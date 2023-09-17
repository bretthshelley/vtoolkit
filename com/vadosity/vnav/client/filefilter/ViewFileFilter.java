/*    */ package com.vadosity.vnav.client.filefilter;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.swing.filechooser.FileFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ViewFileFilter
/*    */   extends FileFilter
/*    */ {
/*    */   public static final String VIEW_FILE_EXTENSION = ".view";
/*    */   
/*    */   public boolean accept(File f) {
/* 16 */     if (f.isDirectory()) return true;
/*    */     
/* 18 */     String path = f.getAbsolutePath();
/* 19 */     path = path.toLowerCase().trim();
/*    */     
/* 21 */     if (path.endsWith(".view"))
/*    */     {
/* 23 */       return true;
/*    */     }
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 31 */     return "Vadosity View Files (*.view)";
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\filefilter\ViewFileFilter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */