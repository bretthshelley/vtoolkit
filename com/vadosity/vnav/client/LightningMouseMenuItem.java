/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JCheckBoxMenuItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LightningMouseMenuItem
/*    */   extends JCheckBoxMenuItem
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public void init() {
/* 15 */     Global.addSettingsChangeListener(this);
/* 16 */     setSelected(Settings.isSelectOnMouseOver());
/* 17 */     updateUI();
/*    */   }
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 22 */     if (equals(src))
/* 23 */       return;  setSelected(Settings.isSelectOnMouseOver());
/* 24 */     updateUI();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LightningMouseMenuItem() {
/*    */     try {
/* 32 */       jbInit();
/* 33 */       init();
/*    */     }
/* 35 */     catch (Exception e) {
/* 36 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public LightningMouseMenuItem(Icon icon) {
/* 41 */     super(icon);
/* 42 */     init();
/*    */   }
/*    */   
/*    */   public LightningMouseMenuItem(String text) {
/* 46 */     super(text);
/* 47 */     init();
/*    */   }
/*    */   
/*    */   public LightningMouseMenuItem(Action a) {
/* 51 */     super(a);
/* 52 */     init();
/*    */   }
/*    */   
/*    */   public LightningMouseMenuItem(String text, Icon icon) {
/* 56 */     super(text, icon);
/* 57 */     init();
/*    */   }
/*    */   
/*    */   public LightningMouseMenuItem(String text, boolean b) {
/* 61 */     super(text, b);
/* 62 */     init();
/*    */   }
/*    */   
/*    */   public LightningMouseMenuItem(String text, Icon icon, boolean b) {
/* 66 */     super(text, icon, b);
/* 67 */     init();
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 70 */     addActionListener(new LightningMouseMenuItem_this_actionAdapter(this));
/*    */   }
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 74 */     Settings.setSelectOnMouseOver(isSelected());
/* 75 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\LightningMouseMenuItem.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */