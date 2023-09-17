/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JCheckBox;
/*    */ 
/*    */ public class FullCircleCheckBox
/*    */   extends JCheckBox
/*    */   implements SettingsChangeListener
/*    */ {
/*    */   public void settingsChanged(Object src) {
/* 14 */     if (equals(src))
/*    */       return; 
/* 16 */     setSelected(Settings.isFullCircle());
/*    */     
/* 18 */     if (Settings.getNumberPhotos() > 1 || Settings.isAddPanoramicPhotos()) {
/*    */ 
/*    */       
/* 21 */       setEnabled(true);
/*    */     
/*    */     }
/*    */     else {
/*    */       
/* 26 */       setEnabled(false);
/*    */     } 
/* 28 */     updateUI();
/*    */   }
/*    */ 
/*    */   
/*    */   public FullCircleCheckBox() {
/*    */     try {
/* 34 */       jbInit();
/* 35 */       Global.addSettingsChangeListener(this);
/*    */     }
/* 37 */     catch (Exception e) {
/* 38 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public FullCircleCheckBox(Icon icon) {
/* 43 */     super(icon);
/* 44 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public FullCircleCheckBox(Icon icon, boolean selected) {
/* 48 */     super(icon, selected);
/* 49 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public FullCircleCheckBox(String text) {
/* 53 */     super(text);
/* 54 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public FullCircleCheckBox(Action a) {
/* 58 */     super(a);
/* 59 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public FullCircleCheckBox(String text, boolean selected) {
/* 63 */     super(text, selected);
/* 64 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public FullCircleCheckBox(String text, Icon icon) {
/* 68 */     super(text, icon);
/* 69 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   
/*    */   public FullCircleCheckBox(String text, Icon icon, boolean selected) {
/* 73 */     super(text, icon, selected);
/* 74 */     Global.addSettingsChangeListener(this);
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 77 */     addActionListener(new FullCircleCheckBox_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 82 */     Photo selectedPhoto = Global.getPhoto();
/* 83 */     if (selectedPhoto != null)
/*    */     {
/* 85 */       if (selectedPhoto.isPanoramic()) {
/*    */         
/* 87 */         selectedPhoto.setCompleteRevolution(isSelected());
/* 88 */         Global.fireSelectedPhotoChanged(this);
/*    */       } 
/*    */     }
/* 91 */     Settings.setFullCircle(isSelected());
/* 92 */     Global.fireSettingsChanged(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\FullCircleCheckBox.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */