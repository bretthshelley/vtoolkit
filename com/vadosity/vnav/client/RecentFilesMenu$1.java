/*  1 */ package com.vadosity.vnav.client;final class null implements Runnable { null(RecentFilesMenu.RecentFilesMenuActionListener paramRecentFilesMenuActionListener, String paramString) { this.this$1 = paramRecentFilesMenuActionListener; this.val$filename = paramString; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   final RecentFilesMenu.RecentFilesMenuActionListener this$1;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String val$filename;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 78 */     FileUtility.openTour(this.val$filename, null);
/*    */   } }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\RecentFilesMenu$1.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */