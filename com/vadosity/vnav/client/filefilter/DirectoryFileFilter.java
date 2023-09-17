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
/*    */ public class DirectoryFileFilter
/*    */   extends FileFilter
/*    */ {
/*    */   public boolean accept(File file) {
/* 16 */     if (file == null) return false; 
/* 17 */     if (file.isDirectory()) return true; 
/* 18 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 23 */     return "Directories Only";
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\filefilter\DirectoryFileFilter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */