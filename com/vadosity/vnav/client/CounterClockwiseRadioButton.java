/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JRadioButton;
/*    */ 
/*    */ public class CounterClockwiseRadioButton
/*    */   extends JRadioButton
/*    */   implements SettingsChangeListener {
/*    */   public CounterClockwiseRadioButton() {
/*    */     try {
/* 14 */       jbInit();
/* 15 */       Global.addSettingsChangeListener(this);
/*    */     }
/* 17 */     catch (Exception e) {
/* 18 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 24 */     if (equals(src))
/* 25 */       return;  setSelected(!Settings.isClockwise());
/* 26 */     if (Settings.isAddPanoramicPhotos())
/*    */     {
/*    */       
/* 29 */       setEnabled(true);
/*    */     }
/* 31 */     if (Settings.getNumberPhotos() > 1)
/*    */     {
/*    */       
/* 34 */       setEnabled(true);
/*    */     }
/* 36 */     if (Settings.getNumberPhotos() < 2 && !Settings.isAddPanoramicPhotos())
/*    */     {
/*    */       
/* 39 */       setEnabled(false);
/*    */     }
/*    */ 
/*    */     
/* 43 */     updateUI();
/*    */   }
/*    */ 
/*    */   
/*    */   public CounterClockwiseRadioButton(Icon icon) {
/* 48 */     super(icon);
/* 49 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public CounterClockwiseRadioButton(Action a) {
/* 53 */     super(a);
/* 54 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public CounterClockwiseRadioButton(Icon icon, boolean selected) {
/* 58 */     super(icon, selected);
/* 59 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public CounterClockwiseRadioButton(String text) {
/* 63 */     super(text);
/* 64 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public CounterClockwiseRadioButton(String text, boolean selected) {
/* 68 */     super(text, selected);
/* 69 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public CounterClockwiseRadioButton(String text, Icon icon) {
/* 73 */     super(text, icon);
/* 74 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public CounterClockwiseRadioButton(String text, Icon icon, boolean selected) {
/* 78 */     super(text, icon, selected);
/* 79 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 82 */     addActionListener(new CounterClockwiseRadioButton_this_actionAdapter(this));
/*    */   }
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 86 */     Settings.setClockwise(false);
/* 87 */     Photo photo = Global.getPhoto();
/* 88 */     if (photo != null && photo.isPanoramic()) {
/*    */       
/* 90 */       photo.setClockwise(false);
/* 91 */       Global.fireSelectedPhotoChanged(this);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 96 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\CounterClockwiseRadioButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */