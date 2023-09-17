/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JCheckBoxMenuItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AlwaysCenterMenuItem
/*    */   extends JCheckBoxMenuItem
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public void init() {
/* 15 */     Global.addSettingsChangeListener(this);
/* 16 */     setSelected(Settings.isAlwaysCenter());
/* 17 */     updateUI();
/*    */   }
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 22 */     if (equals(src))
/* 23 */       return;  setSelected(Settings.isAlwaysCenter());
/* 24 */     updateUI();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AlwaysCenterMenuItem() {
/*    */     try {
/* 32 */       jbInit();
/* 33 */       init();
/*    */     }
/* 35 */     catch (Exception e) {
/* 36 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public AlwaysCenterMenuItem(Icon icon) {
/* 41 */     super(icon);
/* 42 */     init();
/*    */   }
/*    */   
/*    */   public AlwaysCenterMenuItem(String text) {
/* 46 */     super(text);
/* 47 */     init();
/*    */   }
/*    */   
/*    */   public AlwaysCenterMenuItem(Action a) {
/* 51 */     super(a);
/* 52 */     init();
/*    */   }
/*    */   
/*    */   public AlwaysCenterMenuItem(String text, Icon icon) {
/* 56 */     super(text, icon);
/* 57 */     init();
/*    */   }
/*    */   
/*    */   public AlwaysCenterMenuItem(String text, boolean b) {
/* 61 */     super(text, b);
/* 62 */     init();
/*    */   }
/*    */   
/*    */   public AlwaysCenterMenuItem(String text, Icon icon, boolean b) {
/* 66 */     super(text, icon, b);
/* 67 */     init();
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 70 */     addActionListener(new AlwaysCenterMenuItem_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 75 */     Settings.setAlwaysCenter(isSelected());
/* 76 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AlwaysCenterMenuItem.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */