/*    */ package com.vadosity.vnav.client;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.GridBagConstraints;
/*    */ import java.awt.GridBagLayout;
/*    */ import java.awt.Insets;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class AboutDialog extends JDialog {
/* 10 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/* 11 */   JLabel lblTitle = new JLabel();
/* 12 */   JLabel lblCopyright = new JLabel();
/* 13 */   JButton btnOk = new JButton();
/* 14 */   JLabel lblVadosityUrl = new JLabel();
/* 15 */   JLabel lblVersion = new JLabel();
/* 16 */   JLabel lblEmail = new JLabel();
/*    */ 
/*    */   
/*    */   public AboutDialog(JFrame f, String title, boolean modal) {
/* 20 */     super(f, title, modal);
/*    */     try {
/* 22 */       jbInit();
/*    */     }
/* 24 */     catch (Exception e) {
/* 25 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private void jbInit() throws Exception {
/* 30 */     this.lblTitle.setFont(new Font("Dialog", 1, 14));
/* 31 */     this.lblTitle.setText("Vadosity 2 by Vadosity Inc.");
/* 32 */     getContentPane().setLayout(this.gridBagLayout1);
/* 33 */     this.lblCopyright.setFont(new Font("Dialog", 0, 12));
/* 34 */     this.lblCopyright.setMaximumSize(new Dimension(350, 20));
/* 35 */     this.lblCopyright.setMinimumSize(new Dimension(350, 20));
/* 36 */     this.lblCopyright.setPreferredSize(new Dimension(350, 20));
/* 37 */     this.lblCopyright.setHorizontalAlignment(0);
/* 38 */     this.lblCopyright.setText("Copyright © 2006 Vadosity Inc.  All rights reserved.");
/* 39 */     this.btnOk.setMaximumSize(new Dimension(100, 25));
/* 40 */     this.btnOk.setMinimumSize(new Dimension(100, 25));
/* 41 */     this.btnOk.setPreferredSize(new Dimension(100, 25));
/* 42 */     this.btnOk.setText("OK");
/* 43 */     this.btnOk.addActionListener(new AboutDialog_btnOk_actionAdapter(this));
/* 44 */     this.lblVadosityUrl.setFont(new Font("Dialog", 1, 12));
/* 45 */     this.lblVadosityUrl.setForeground(Color.blue);
/* 46 */     this.lblVadosityUrl.setHorizontalAlignment(0);
/* 47 */     this.lblVadosityUrl.setHorizontalTextPosition(0);
/* 48 */     this.lblVadosityUrl.setText("http:\\\\www.vadosity.com");
/* 49 */     this.lblVadosityUrl.addMouseListener(new AboutDialog_lblVadosityUrl_mouseAdapter(this));
/* 50 */     this.lblVersion.setFont(new Font("Dialog", 0, 12));
/* 51 */     this.lblVersion.setText("Version: 2.0");
/* 52 */     this.lblEmail.setFont(new Font("Dialog", 0, 12));
/* 53 */     this.lblEmail.setText("Email: support@vadosity.com");
/* 54 */     setTitle("About Vadosity Inc.");
/* 55 */     getContentPane().add(this.lblTitle, new GridBagConstraints(0, 0, 1, 1, 1.0D, 1.0D, 
/* 56 */           10, 0, new Insets(5, 0, 5, 5), 0, 0));
/* 57 */     getContentPane().add(this.lblCopyright, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 58 */           10, 1, new Insets(0, 5, 0, 5), 0, 0));
/* 59 */     getContentPane().add(this.btnOk, new GridBagConstraints(0, 8, 1, 1, 0.0D, 1.0D, 
/* 60 */           10, 0, new Insets(0, 5, 5, 5), 0, 0));
/* 61 */     getContentPane().add(this.lblVadosityUrl, new GridBagConstraints(0, 4, 1, 1, 0.0D, 0.0D, 
/* 62 */           10, 2, new Insets(15, 5, 0, 5), 0, 0));
/* 63 */     getContentPane().add(this.lblVersion, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 64 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 65 */     getContentPane().add(this.lblEmail, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.0D, 
/* 66 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/*    */   }
/*    */ 
/*    */   
/*    */   void btnOk_actionPerformed(ActionEvent e) {
/* 71 */     dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   void lblVadosityUrl_mouseClicked(MouseEvent e) {
/*    */     try {
/* 77 */       BrowserUtil.displayURL("http:\\\\www.vadosity.com");
/*    */     }
/* 79 */     catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AboutDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */