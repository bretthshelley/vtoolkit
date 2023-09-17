/*    */ package com.vadosity.vnav.client.filefilter;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.swing.filechooser.FileFilter;
/*    */ 
/*    */ public class TourFileFilter
/*    */   extends FileFilter {
/*  8 */   public static String TOUR_EXTENSION = ".tour";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean accept(File f) {
/* 17 */     if (f.isDirectory()) return true;
/*    */     
/* 19 */     String path = f.getAbsolutePath();
/* 20 */     path = path.toLowerCase().trim();
/*    */     
/* 22 */     if (path.endsWith(TOUR_EXTENSION))
/*    */     {
/* 24 */       return true;
/*    */     }
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 32 */     return "Vadosity Tour Files (*.tour)";
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\filefilter\TourFileFilter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */