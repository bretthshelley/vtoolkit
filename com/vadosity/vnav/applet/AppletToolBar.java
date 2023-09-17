/*    */ package com.vadosity.vnav.applet;
/*    */ 
/*    */ import com.vadosity.vnav.client.NavigationToolBar;
/*    */ import com.vadosity.vnav.client.SettingsToolBar;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JToolBar;
/*    */ 
/*    */ public class AppletToolBar
/*    */   extends JToolBar {
/* 10 */   SettingsToolBar settingsToolBar = new SettingsToolBar();
/* 11 */   NavigationToolBar navigationToolBar = new NavigationToolBar();
/*    */   
/*    */   public AppletToolBar() {
/*    */     try {
/* 15 */       jbInit();
/*    */     }
/* 17 */     catch (Exception e) {
/* 18 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 22 */     setFloatable(false);
/* 23 */     add((Component)this.settingsToolBar);
/* 24 */     add((Component)this.navigationToolBar);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\applet\AppletToolBar.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */