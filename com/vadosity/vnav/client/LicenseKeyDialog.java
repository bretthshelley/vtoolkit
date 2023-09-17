/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class LicenseKeyDialog extends JDialog {
/*  13 */   BorderLayout borderLayout1 = new BorderLayout();
/*  14 */   JPanel southPanel = new JPanel();
/*  15 */   JButton btnContinue = new JButton();
/*  16 */   JPanel centerPanel = new JPanel();
/*  17 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  18 */   JLabel lblOrderNow = new JLabel();
/*  19 */   JButton btnBuyNow = new JButton();
/*  20 */   JLabel lblKey = new JLabel();
/*  21 */   JTextField tfKey = new JTextField();
/*  22 */   JLabel lblInstructions = new JLabel();
/*  23 */   JButton btnGo = new JButton();
/*  24 */   JLabel jLabel1 = new JLabel();
/*     */   
/*  26 */   String licenseKey = "";
/*     */   
/*  28 */   public String daysRemaining = "15";
/*     */ 
/*     */   
/*     */   public LicenseKeyDialog(Frame frame, boolean modal) {
/*  32 */     super(frame, "License Purchase Dialog", modal);
/*     */     
/*     */     try {
/*  35 */       jbInit();
/*     */       
/*  37 */       this.lblInstructions.setIcon(new ImageIcon(ImageUtil.loadProductImage()));
/*     */       
/*  39 */       pack();
/*     */     }
/*  41 */     catch (Exception ex) {
/*     */       
/*  43 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  49 */     setResizable(false);
/*  50 */     setTitle("License Purchase Dialog");
/*  51 */     getContentPane().setLayout(this.borderLayout1);
/*  52 */     this.southPanel.setMinimumSize(new Dimension(10, 40));
/*  53 */     this.southPanel.setPreferredSize(new Dimension(10, 40));
/*  54 */     this.btnContinue.setText("Continue Trial");
/*  55 */     this.btnContinue.addActionListener(new LicenseKeyDialog_btnContinue_actionAdapter(this));
/*  56 */     this.centerPanel.setLayout(this.gridBagLayout1);
/*  57 */     this.lblOrderNow.setForeground(Color.black);
/*  58 */     this.lblOrderNow.setToolTipText("");
/*  59 */     this.lblOrderNow.setHorizontalAlignment(0);
/*  60 */     this.lblOrderNow.setText("<html><a href=#>Order Vadosity ® 2.0 Now</a></html>");
/*  61 */     this.lblOrderNow.addMouseListener(new LicenseKeyDialog_lblOrderNow_mouseAdapter(this));
/*  62 */     this.btnBuyNow.setText("Buy Now");
/*  63 */     this.btnBuyNow.addActionListener(new LicenseKeyDialog_btnBuyNow_actionAdapter(this));
/*  64 */     this.lblKey.setFont(new Font("Dialog", 1, 11));
/*  65 */     this.lblKey.setText("Key");
/*  66 */     this.tfKey.setMinimumSize(new Dimension(300, 25));
/*  67 */     this.tfKey.setPreferredSize(new Dimension(300, 25));
/*  68 */     this.tfKey.setText("");
/*  69 */     this.tfKey.addKeyListener(new LicenseKeyDialog_tfKey_keyAdapter(this));
/*  70 */     this.tfKey.addFocusListener(new LicenseKeyDialog_tfKey_focusAdapter(this));
/*  71 */     this.tfKey.addActionListener(new LicenseKeyDialog_tfKey_actionAdapter(this));
/*  72 */     this.lblInstructions.setFont(new Font("Dialog", 1, 11));
/*  73 */     this.lblInstructions.setText("Enter Your License Key and Select 'Go'");
/*  74 */     this.btnGo.setText("Go");
/*  75 */     this.btnGo.addActionListener(new LicenseKeyDialog_btnGo_actionAdapter(this));
/*  76 */     this.jLabel1.setForeground(Color.blue);
/*  77 */     this.jLabel1.setMaximumSize(new Dimension(215, 30));
/*  78 */     this.jLabel1.setMinimumSize(new Dimension(215, 30));
/*  79 */     this.jLabel1.setPreferredSize(new Dimension(215, 30));
/*  80 */     this.jLabel1.setHorizontalAlignment(0);
/*  81 */     this.jLabel1.setHorizontalTextPosition(0);
/*  82 */     this.jLabel1.setText("You have {0} days Left in Your Trial");
/*     */     
/*  84 */     getContentPane().add(this.southPanel, "South");
/*  85 */     this.southPanel.add(this.btnContinue, (Object)null);
/*  86 */     this.centerPanel.add(this.lblKey, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/*  87 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  88 */     this.centerPanel.add(this.tfKey, new GridBagConstraints(1, 3, 1, 1, 0.0D, 0.0D, 
/*  89 */           10, 0, new Insets(5, 5, 5, 0), 0, 0));
/*  90 */     this.centerPanel.add(this.lblInstructions, new GridBagConstraints(0, 2, 3, 1, 0.0D, 0.0D, 
/*  91 */           17, 0, new Insets(25, 5, 5, 5), 0, 0));
/*  92 */     this.centerPanel.add(this.btnGo, new GridBagConstraints(3, 3, 1, 1, 0.0D, 0.0D, 
/*  93 */           17, 0, new Insets(5, 0, 5, 5), 0, 0));
/*  94 */     this.centerPanel.add(this.lblOrderNow, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  95 */           10, 2, new Insets(0, 0, 0, 0), 0, 0));
/*  96 */     this.centerPanel.add(this.btnBuyNow, new GridBagConstraints(0, 1, 5, 1, 0.0D, 0.0D, 
/*  97 */           10, 0, new Insets(5, 0, 5, 5), 0, 0));
/*  98 */     getContentPane().add(this.jLabel1, "North");
/*  99 */     getContentPane().add(this.centerPanel, "Center");
/*     */   }
/*     */   
/*     */   void btnContinue_actionPerformed(ActionEvent e) {
/* 103 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void lblOrderNow_mouseClicked(MouseEvent e) {
/*     */     try {
/* 109 */       BrowserUtil.displayURL("http://www.vadosity.com/ToolkitPurchase.do");
/*     */     }
/* 111 */     catch (BrowserException browserException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnBuyNow_actionPerformed(ActionEvent e) {
/*     */     try {
/* 119 */       BrowserUtil.displayURL("http://www.vadosity.com/ToolkitPurchase.do");
/*     */     }
/* 121 */     catch (BrowserException browserException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void lblPayPal_mouseClicked(MouseEvent e) {
/*     */     try {
/* 130 */       BrowserUtil.displayURL("http://www.paypal.com");
/*     */     }
/* 132 */     catch (BrowserException browserException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void tfKey_actionPerformed(ActionEvent e) {
/* 140 */     this.licenseKey = this.tfKey.getText().trim();
/* 141 */     btnGo_actionPerformed((ActionEvent)null);
/*     */   }
/*     */ 
/*     */   
/*     */   void tfKey_focusLost(FocusEvent e) {
/* 146 */     this.licenseKey = this.tfKey.getText().trim();
/*     */   }
/*     */   
/*     */   void btnGo_actionPerformed(ActionEvent e) {
/* 150 */     if (this.licenseKey.trim().equals("")) {
/*     */       
/* 152 */       this.licenseKey = this.tfKey.getText().trim();
/* 153 */       if (this.licenseKey.trim().equals("")) {
/*     */         
/* 155 */         String str1 = "Please enter a License Key";
/* 156 */         String str2 = "Missing License Key";
/* 157 */         JOptionPane.showMessageDialog(this, str1, str2, 2);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 162 */     boolean keyOk = LicenseEvaluator.isKeyOk(this.licenseKey);
/* 163 */     if (keyOk) {
/*     */       
/* 165 */       RegistryInterface.setLicenseKeyInWindowsRegistry(this.licenseKey);
/* 166 */       VadosityToolkit.getInstance().setLicenseOk(true);
/* 167 */       String str1 = "Congratulations!  Your Product Features are fully Activated.";
/* 168 */       String str2 = "Product Key Accepted";
/* 169 */       JOptionPane.showMessageDialog(this, str1, str2, 1);
/* 170 */       dispose();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 175 */     String message = "Invalid License Key. Please check key and try again.";
/* 176 */     String title = "Invalid License Key";
/* 177 */     JOptionPane.showMessageDialog(this, message, title, 1);
/* 178 */     VadosityToolkit.getInstance().setLicenseOk(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDaysRemaining() {
/* 198 */     return this.daysRemaining;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDaysRemaining(String daysRemaining) {
/* 204 */     this.daysRemaining = daysRemaining;
/*     */     
/* 206 */     this.jLabel1.setText("You have " + daysRemaining + " day(s) Left in your Free Trial");
/* 207 */     this.jLabel1.updateUI();
/*     */   }
/*     */ 
/*     */   
/*     */   void tfKey_keyTyped(KeyEvent e) {
/* 212 */     if (e.getKeyChar() == '\n')
/*     */     {
/* 214 */       btnGo_actionPerformed((ActionEvent)null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\LicenseKeyDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */