/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JRadioButton;
/*    */ 
/*    */ public class ClockwiseRadioButton
/*    */   extends JRadioButton
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public ClockwiseRadioButton() {
/*    */     try {
/* 15 */       jbInit();
/* 16 */       Global.addSettingsChangeListener(this);
/*    */     }
/* 18 */     catch (Exception e) {
/* 19 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 25 */     if (equals(src))
/* 26 */       return;  setSelected(Settings.isClockwise());
/* 27 */     if (Settings.isAddPanoramicPhotos())
/*    */     {
/*    */       
/* 30 */       setEnabled(true);
/*    */     }
/* 32 */     if (Settings.getNumberPhotos() > 1)
/*    */     {
/*    */       
/* 35 */       setEnabled(true);
/*    */     }
/* 37 */     if (Settings.getNumberPhotos() < 2 && !Settings.isAddPanoramicPhotos())
/*    */     {
/*    */       
/* 40 */       setEnabled(false);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ClockwiseRadioButton(Icon icon) {
/* 47 */     super(icon);
/* 48 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public ClockwiseRadioButton(Action a) {
/* 52 */     super(a);
/* 53 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public ClockwiseRadioButton(Icon icon, boolean selected) {
/* 57 */     super(icon, selected);
/* 58 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public ClockwiseRadioButton(String text) {
/* 62 */     super(text);
/* 63 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public ClockwiseRadioButton(String text, boolean selected) {
/* 67 */     super(text, selected);
/* 68 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public ClockwiseRadioButton(String text, Icon icon) {
/* 72 */     super(text, icon);
/* 73 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public ClockwiseRadioButton(String text, Icon icon, boolean selected) {
/* 77 */     super(text, icon, selected);
/* 78 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 81 */     addActionListener(new ClockwiseRadioButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 86 */     Settings.setClockwise(true);
/* 87 */     Photo photo = Global.getPhoto();
/* 88 */     if (photo != null && photo.isPanoramic()) {
/*    */       
/* 90 */       photo.setClockwise(true);
/* 91 */       Global.fireSelectedPhotoChanged(this);
/*    */     } 
/* 93 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ClockwiseRadioButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */