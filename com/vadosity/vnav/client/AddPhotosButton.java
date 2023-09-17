/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ 
/*    */ public class AddPhotosButton
/*    */   extends JButton
/*    */ {
/*    */   public AddPhotosButton() {
/*    */     try {
/* 13 */       jbInit();
/* 14 */       setIcon(new ImageIcon(ImageUtil.loadImage("many-files_.gif")));
/*    */     
/*    */     }
/* 17 */     catch (Exception e) {
/* 18 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private void jbInit() throws Exception {
/* 23 */     setText("Add Photos");
/* 24 */     addActionListener(new AddPhotosButton_this_actionAdapter(this));
/*    */   }
/*    */ 
/*    */   
/*    */   void this_actionPerformed(ActionEvent e) {
/* 29 */     ImportPhotosDialog dlg = new ImportPhotosDialog(VadosityToolkit.getInstance(), "Add Photos to Project", true);
/* 30 */     dlg.setSize(500, 250);
/* 31 */     dlg.setLocation((VadosityToolkit.getInstance().getLocation()).x + VadosityToolkit.getInstance().getWidth() / 2 - dlg.getWidth() / 2, (VadosityToolkit.getInstance().getLocation()).y + VadosityToolkit.getInstance().getHeight() / 2 - dlg.getHeight() / 2);
/* 32 */     dlg.setVisible(true);
/* 33 */     VadosityToolkit.getInstance().setupPhotoDirectory(RegistryInterface.getCurrentProjectDirectory().getAbsolutePath());
/* 34 */     VadosityToolkit.getInstance().setupPhotoScrollerSize();
/* 35 */     VadosityToolkit.getInstance().setupSplitPane();
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AddPhotosButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */