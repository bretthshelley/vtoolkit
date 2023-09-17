/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import javax.swing.JToolBar;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MainClientToolBar
/*    */   extends JToolBar
/*    */ {
/* 13 */   SettingsToolBar settingsToolBar = new SettingsToolBar();
/* 14 */   NavigationToolBar navigationToolBar = new NavigationToolBar();
/* 15 */   ViewEditToolBar viewEditToolBar = new ViewEditToolBar();
/*    */   
/*    */   public MainClientToolBar() {
/*    */     try {
/* 19 */       jbInit();
/*    */     }
/* 21 */     catch (Exception e) {
/* 22 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 26 */     setFloatable(false);
/*    */ 
/*    */     
/* 29 */     add(this.settingsToolBar);
/* 30 */     add(this.navigationToolBar);
/* 31 */     add(this.viewEditToolBar);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\MainClientToolBar.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */