/*    */ package com.vadosity.vnav.client.filefilter;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.text.MessageFormat;
/*    */ import javax.swing.filechooser.FileFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SettingsFileFilter
/*    */   extends FileFilter
/*    */ {
/*    */   public static final String SETTINGS_FILE_EXTENSION = ".settings";
/*    */   
/*    */   public boolean accept(File f) {
/* 17 */     if (f.isDirectory()) return true;
/*    */     
/* 19 */     String path = f.getAbsolutePath();
/* 20 */     path = path.toLowerCase().trim();
/*    */     
/* 22 */     if (path.endsWith(".settings"))
/*    */     {
/* 24 */       return true;
/*    */     }
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 32 */     String description = "Vadosity Settings Files (*{0})";
/* 33 */     String[] sa = { ".settings" };
/* 34 */     description = MessageFormat.format(description, (Object[])sa);
/* 35 */     return description;
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\filefilter\SettingsFileFilter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */