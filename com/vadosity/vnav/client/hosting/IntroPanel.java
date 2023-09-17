/*     */ package com.vadosity.vnav.client.hosting;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class IntroPanel extends JPanel {
/*   9 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  10 */   JPanel jPanel1 = new JPanel();
/*  11 */   JLabel lblThreeFiles = new JLabel();
/*  12 */   JLabel lblDash2 = new JLabel();
/*  13 */   JLabel lblDash1 = new JLabel();
/*  14 */   JLabel lblDash3 = new JLabel();
/*  15 */   JLabel lblActivatedFile = new JLabel();
/*  16 */   JLabel lblVadosityJar = new JLabel();
/*  17 */   JLabel lblWebPage = new JLabel();
/*     */   TitledBorder borderOverview;
/*  19 */   JLabel lblOverview = new JLabel();
/*  20 */   JLabel lblResideAnywhere = new JLabel();
/*  21 */   JLabel lblBandwidth = new JLabel();
/*  22 */   JPanel jPanel3 = new JPanel();
/*  23 */   JLabel lblDash7 = new JLabel();
/*  24 */   JLabel lblDash8 = new JLabel();
/*  25 */   JButton btnNext = new JButton();
/*  26 */   JPanel jPanel2 = new JPanel();
/*  27 */   JButton btnCancel = new JButton();
/*  28 */   JLabel lblWizard = new JLabel();
/*  29 */   JPanel jPanel4 = new JPanel();
/*  30 */   JLabel lblAppletSetup = new JLabel();
/*  31 */   JLabel lblCustomize = new JLabel();
/*  32 */   JLabel lblDash4 = new JLabel();
/*  33 */   JLabel lblDash5 = new JLabel();
/*  34 */   JLabel lblDeploy = new JLabel();
/*  35 */   JLabel lblDash6 = new JLabel();
/*     */   
/*     */   public IntroPanel() {
/*     */     try {
/*  39 */       jbInit();
/*     */     }
/*  41 */     catch (Exception e) {
/*  42 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  48 */     this.borderOverview = new TitledBorder("Overview");
/*  49 */     setLayout(this.gridBagLayout1);
/*  50 */     this.jPanel1.setBackground(Color.blue);
/*  51 */     this.jPanel1.setMinimumSize(new Dimension(10, 3));
/*  52 */     this.jPanel1.setPreferredSize(new Dimension(10, 3));
/*  53 */     this.lblThreeFiles.setFont(new Font("SansSerif", 1, 12));
/*  54 */     this.lblThreeFiles.setText("Three files are needed to host a tour on your website");
/*  55 */     this.lblDash2.setFont(new Font("SansSerif", 1, 16));
/*  56 */     this.lblDash2.setText("-");
/*  57 */     this.lblDash1.setFont(new Font("SansSerif", 1, 16));
/*  58 */     this.lblDash1.setText("-");
/*  59 */     this.lblDash3.setFont(new Font("SansSerif", 1, 16));
/*  60 */     this.lblDash3.setText("-");
/*  61 */     this.lblActivatedFile.setFont(new Font("SansSerif", 0, 12));
/*  62 */     this.lblActivatedFile.setRequestFocusEnabled(true);
/*  63 */     this.lblActivatedFile.setText("A Tour File (*.tour)");
/*  64 */     this.lblVadosityJar.setFont(new Font("SansSerif", 0, 12));
/*  65 */     this.lblVadosityJar.setText("The \"vadosity.jar\" archive (included with this software)");
/*  66 */     this.lblWebPage.setFont(new Font("SansSerif", 0, 12));
/*  67 */     this.lblWebPage.setText("A web page with an Applet that points to the tour and archive");
/*  68 */     this.lblOverview.setFont(new Font("SansSerif", 1, 12));
/*  69 */     this.lblOverview.setText("Hosting Overview");
/*  70 */     this.lblResideAnywhere.setFont(new Font("SansSerif", 0, 12));
/*  71 */     this.lblResideAnywhere.setToolTipText("");
/*  72 */     this.lblResideAnywhere.setText("A Vadosity Tour resides on any web-server (It's just a file)");
/*  73 */     this.lblBandwidth.setFont(new Font("SansSerif", 0, 12));
/*  74 */     this.lblBandwidth.setText("Business class bandwidth enables efficient tour viewing.");
/*  75 */     this.jPanel3.setPreferredSize(new Dimension(10, 3));
/*  76 */     this.jPanel3.setMinimumSize(new Dimension(10, 3));
/*  77 */     this.jPanel3.setBackground(Color.blue);
/*  78 */     this.lblDash7.setFont(new Font("SansSerif", 1, 16));
/*  79 */     this.lblDash7.setText("-");
/*  80 */     this.lblDash8.setFont(new Font("SansSerif", 1, 16));
/*  81 */     this.lblDash8.setText("-");
/*  82 */     this.btnNext.setText("Next");
/*  83 */     this.btnNext.addActionListener(new IntroPanel_btnNext_actionAdapter(this));
/*  84 */     this.jPanel2.setMinimumSize(new Dimension(10, 40));
/*  85 */     this.jPanel2.setPreferredSize(new Dimension(10, 40));
/*  86 */     this.btnCancel.setText("Cancel");
/*  87 */     this.btnCancel.addActionListener(new IntroPanel_btnCancel_actionAdapter(this));
/*  88 */     this.lblWizard.setFont(new Font("SansSerif", 1, 12));
/*  89 */     this.lblWizard.setText("This Wizard sets up the Tour Applet");
/*  90 */     this.jPanel4.setBackground(Color.blue);
/*  91 */     this.jPanel4.setMinimumSize(new Dimension(10, 3));
/*  92 */     this.jPanel4.setPreferredSize(new Dimension(10, 3));
/*  93 */     this.lblAppletSetup.setFont(new Font("SansSerif", 0, 12));
/*  94 */     this.lblAppletSetup.setText("Setup is Easy - Default Values will work");
/*  95 */     this.lblCustomize.setFont(new Font("SansSerif", 0, 12));
/*  96 */     this.lblCustomize.setText("Enables full customization (market branding) of tour web page");
/*  97 */     this.lblDash4.setFont(new Font("SansSerif", 1, 16));
/*  98 */     this.lblDash4.setText("-");
/*  99 */     this.lblDash5.setFont(new Font("SansSerif", 1, 16));
/* 100 */     this.lblDash5.setText("-");
/* 101 */     this.lblDeploy.setFont(new Font("SansSerif", 0, 12));
/* 102 */     this.lblDeploy.setText("Assists in deploying files to your web-server");
/* 103 */     this.lblDash6.setFont(new Font("SansSerif", 1, 16));
/* 104 */     this.lblDash6.setText("-");
/* 105 */     addComponentListener(new IntroPanel_this_componentAdapter(this));
/* 106 */     add(this.lblThreeFiles, new GridBagConstraints(0, 5, 2, 1, 0.0D, 0.0D, 
/* 107 */           17, 0, new Insets(15, 5, 5, 5), 0, 0));
/* 108 */     add(this.lblDash1, new GridBagConstraints(0, 7, 1, 1, 0.0D, 0.0D, 
/* 109 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 110 */     add(this.lblDash2, new GridBagConstraints(0, 8, 1, 1, 0.0D, 0.0D, 
/* 111 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 112 */     add(this.lblDash3, new GridBagConstraints(0, 9, 1, 1, 0.0D, 0.0D, 
/* 113 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 114 */     add(this.lblActivatedFile, new GridBagConstraints(1, 7, 1, 1, 0.0D, 0.0D, 
/* 115 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 116 */     add(this.lblVadosityJar, new GridBagConstraints(1, 8, 1, 1, 0.0D, 0.0D, 
/* 117 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 118 */     add(this.lblWebPage, new GridBagConstraints(1, 9, 1, 1, 0.0D, 0.0D, 
/* 119 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 120 */     add(this.jPanel1, new GridBagConstraints(0, 6, 4, 1, 0.0D, 0.0D, 
/* 121 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/* 122 */     add(this.lblOverview, new GridBagConstraints(0, 0, 3, 1, 0.0D, 0.0D, 
/* 123 */           17, 0, new Insets(10, 5, 5, 5), 0, 0));
/* 124 */     add(this.lblResideAnywhere, new GridBagConstraints(1, 2, 1, 1, 0.0D, 0.0D, 
/* 125 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 126 */     add(this.lblBandwidth, new GridBagConstraints(1, 3, 1, 1, 0.0D, 0.0D, 
/* 127 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 128 */     add(this.jPanel3, new GridBagConstraints(0, 1, 5, 1, 0.0D, 0.0D, 
/* 129 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/* 130 */     add(this.lblDash7, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 131 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 132 */     add(this.lblDash8, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/* 133 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 134 */     this.jPanel2.add(this.btnCancel, (Object)null);
/* 135 */     this.jPanel2.add(this.btnNext, (Object)null);
/* 136 */     add(this.lblDash6, new GridBagConstraints(0, 14, 1, 1, 0.0D, 0.0D, 
/* 137 */           11, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 138 */     add(this.lblCustomize, new GridBagConstraints(1, 13, 1, 1, 0.0D, 0.0D, 
/* 139 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 140 */     add(this.lblDeploy, new GridBagConstraints(1, 14, 1, 1, 0.0D, 1.0D, 
/* 141 */           18, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 142 */     add(this.lblAppletSetup, new GridBagConstraints(1, 12, 1, 1, 0.0D, 0.0D, 
/* 143 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 144 */     add(this.lblDash4, new GridBagConstraints(0, 12, 1, 1, 0.0D, 0.0D, 
/* 145 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 146 */     add(this.lblDash5, new GridBagConstraints(0, 13, 1, 1, 0.0D, 0.0D, 
/* 147 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 148 */     add(this.lblWizard, new GridBagConstraints(0, 10, 2, 1, 0.0D, 0.0D, 
/* 149 */           17, 0, new Insets(15, 5, 5, 5), 0, 0));
/* 150 */     add(this.jPanel4, new GridBagConstraints(0, 11, 2, 1, 0.0D, 0.0D, 
/* 151 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/* 152 */     add(this.jPanel2, new GridBagConstraints(0, 15, 2, 1, 0.0D, 0.0D, 
/* 153 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/*     */   }
/*     */   
/*     */   void btnNext_actionPerformed(ActionEvent e) {
/* 157 */     ((CardLayout)getParent().getLayout()).next(getParent());
/*     */   }
/*     */   
/*     */   void btnCancel_actionPerformed(ActionEvent e) {
/* 161 */     ((JDialog)getParent().getParent().getParent().getParent()).dispose();
/*     */   }
/*     */   
/*     */   void this_componentShown(ComponentEvent e) {
/* 165 */     ((JDialog)getParent().getParent().getParent().getParent()).setTitle("Hosting Wizard: Step 1 of 4 - Introduction");
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\hosting\IntroPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */