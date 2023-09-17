/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ public class EditModeToggleButton
/*     */   extends JButton
/*     */   implements SettingsChangeListener
/*     */ {
/*  13 */   private static EditModeToggleButton instance = null; public static EditModeToggleButton getInstance() {
/*  14 */     return instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public EditModeToggleButton() {
/*     */     try {
/*  20 */       jbInit();
/*  21 */       Global.addSettingsChangeListener(this);
/*  22 */       instance = this;
/*     */       
/*  24 */       if (VadosityToolkit.isViewOnly()) setVisible(false);
/*     */     
/*     */     }
/*  27 */     catch (Exception e) {
/*     */       
/*  29 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  36 */     setIcon(new ImageIcon(ImageUtil.loadEditImage()));
/*  37 */     addActionListener(new EditModeToggleButton_this_actionAdapter(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/*  46 */     setVisible((Settings.getMode() == 1));
/*     */     
/*  48 */     if (VadosityToolkit.isViewOnly()) setVisible(false);
/*     */   
/*     */   }
/*     */   
/*     */   void this_actionPerformed(ActionEvent e) {
/*  53 */     doEditRoutine();
/*     */     
/*  55 */     if (VadosityToolkit.isViewOnly()) setVisible(false);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void doEditRoutine() {
/*  64 */     boolean licenseOk = VadosityToolkit.getInstance().isLicenseOk();
/*  65 */     if (licenseOk) {
/*     */       
/*  67 */       Settings.setMode(0);
/*  68 */       Global.fireSettingsChanged(VadosityToolkit.getInstance());
/*     */       
/*     */       return;
/*     */     } 
/*  72 */     if (VadosityToolkit.getInstance().getDaysRemaining() < 0) VadosityToolkit.getInstance().setDaysRemaining(0); 
/*  73 */     if (VadosityToolkit.getInstance().getDaysRemaining() > 0) {
/*     */       
/*  75 */       Settings.setMode(0);
/*  76 */       Global.fireSettingsChanged(VadosityToolkit.getInstance());
/*     */       
/*     */       return;
/*     */     } 
/*  80 */     LicenseKeyDialog dlg = new LicenseKeyDialog(VadosityToolkit.getInstance(), true);
/*  81 */     dlg.setDaysRemaining(VadosityToolkit.getInstance().getDaysRemaining());
/*  82 */     int dlgWidth = 500, dlgHeight = 400;
/*  83 */     dlg.setSize(dlgWidth, dlgHeight);
/*  84 */     dlg.setModal(true);
/*     */     
/*  86 */     int x = (VadosityToolkit.getInstance().getLocation()).x;
/*  87 */     int y = (VadosityToolkit.getInstance().getLocation()).y;
/*  88 */     int w = (VadosityToolkit.getInstance().getSize()).width;
/*  89 */     int h = (VadosityToolkit.getInstance().getSize()).height;
/*     */     
/*  91 */     int dlgx = x + w / 2 - dlgWidth / 2;
/*  92 */     int dlgy = y + h / 2 - dlgHeight / 2;
/*  93 */     dlg.setLocation(dlgx, dlgy);
/*  94 */     dlg.setVisible(true);
/*     */ 
/*     */     
/*  97 */     licenseOk = VadosityToolkit.getInstance().isLicenseOk();
/*  98 */     System.out.println("license ok: " + licenseOk);
/*  99 */     if (licenseOk) {
/*     */       
/* 101 */       Settings.setMode(0);
/* 102 */       Global.fireSettingsChanged(VadosityToolkit.getInstance());
/*     */     }
/*     */     else {
/*     */       
/* 106 */       Settings.setMode(1);
/* 107 */       Global.fireSettingsChanged(VadosityToolkit.getInstance());
/* 108 */       String message = "Your Evaluation Period has expired.\n\n";
/* 109 */       message = String.valueOf(message) + " Please License your product first.  Editing and New Tour Creation will then be re-enabled.";
/* 110 */       String title = "Evaluation Period Expired";
/* 111 */       JOptionPane.showMessageDialog(VadosityToolkit.getInstance(), message, title, 2);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\EditModeToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */