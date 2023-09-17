/*     */ package com.vadosity.vnav.map;
/*     */ 
/*     */ import com.vadosity.vnav.client.BrowserUtil;
/*     */ import java.awt.Dialog;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class ZipDialog
/*     */   extends JDialog {
/*  22 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  23 */   JLabel lblZip = new JLabel();
/*  24 */   JTextField tfZip = new JTextField();
/*  25 */   JButton btnGo = new JButton();
/*  26 */   JButton btnSearchInternet = new JButton();
/*     */   
/*  28 */   String latitude = null;
/*  29 */   String longitude = null;
/*  30 */   JLabel lblOr = new JLabel();
/*     */ 
/*     */ 
/*     */   
/*     */   public ZipDialog() {
/*     */     try {
/*  36 */       jbInit();
/*     */     }
/*  38 */     catch (Exception e) {
/*     */       
/*  40 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ZipDialog(Dialog p0, String p1, boolean p2) {
/*  46 */     super(p0, p1, p2);
/*     */     
/*     */     try {
/*  49 */       jbInit();
/*     */     }
/*  51 */     catch (Exception e) {
/*     */       
/*  53 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ZipDialog(Frame p0, String p1, boolean p2) {
/*  59 */     super(p0, p1, p2);
/*     */     
/*     */     try {
/*  62 */       jbInit();
/*     */     }
/*  64 */     catch (Exception e) {
/*     */       
/*  66 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  72 */     this.lblZip.setText("Zip");
/*  73 */     getContentPane().setLayout(this.gridBagLayout1);
/*  74 */     this.tfZip.setMinimumSize(new Dimension(60, 20));
/*  75 */     this.tfZip.setPreferredSize(new Dimension(60, 20));
/*  76 */     this.tfZip.setText("");
/*  77 */     this.tfZip.addKeyListener(new ZipDialog_tfZip_keyAdapter(this));
/*  78 */     this.btnGo.setText("Go");
/*  79 */     this.btnGo.addActionListener(new ZipDialog_btnGo_actionAdapter(this));
/*  80 */     this.btnSearchInternet.setText("Search Internet");
/*  81 */     this.btnSearchInternet.addActionListener(new ZipDialog_btnSearchInternet_actionAdapter(this));
/*  82 */     this.lblOr.setText("- Or -");
/*  83 */     getContentPane().add(this.lblZip, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  84 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  85 */     getContentPane().add(this.tfZip, new GridBagConstraints(1, 0, 1, 1, 0.0D, 1.0D, 
/*  86 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  87 */     getContentPane().add(this.btnGo, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 
/*  88 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  89 */     getContentPane().add(this.btnSearchInternet, new GridBagConstraints(0, 2, 3, 1, 0.0D, 1.0D, 
/*  90 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  91 */     getContentPane().add(this.lblOr, new GridBagConstraints(0, 1, 3, 1, 0.0D, 1.0D, 
/*  92 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  93 */     this.btnGo.requestFocus();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnSearchInternet_actionPerformed(ActionEvent e) {
/*     */     try {
/*  99 */       String url = "http://www.census.gov/cgi-bin/gazetteer";
/* 100 */       BrowserUtil.displayURL(url);
/* 101 */       dispose();
/*     */     }
/* 103 */     catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnGo_actionPerformed(ActionEvent e) {
/*     */     try {
/* 114 */       String zip = this.tfZip.getText().trim();
/* 115 */       if (zip.equals("")) {
/*     */         
/* 117 */         String message = "Please Enter US Zip Code";
/* 118 */         String title = "Enter Zip";
/* 119 */         JOptionPane.showMessageDialog(this, message, title, 1);
/* 120 */         this.tfZip.requestFocus();
/*     */         return;
/*     */       } 
/* 123 */       if (zip.length() != 5) {
/*     */         
/* 125 */         String message = "Please enter first 5 Digits of Zip code";
/* 126 */         String title = "Enter 5 Digit Zip Only";
/* 127 */         JOptionPane.showMessageDialog(this, message, title, 1);
/* 128 */         this.tfZip.requestFocus();
/*     */         
/*     */         return;
/*     */       } 
/* 132 */       String zipSought = "#" + zip;
/*     */       
/* 134 */       File in = new File("zipgeo.txt");
/* 135 */       FileInputStream fis = new FileInputStream(in);
/* 136 */       byte[] bytes = new byte[fis.available()];
/* 137 */       fis.read(bytes);
/* 138 */       String data = new String(bytes);
/*     */       
/* 140 */       int index = data.indexOf(zipSought);
/*     */       
/* 142 */       if (index == -1) {
/*     */         
/* 144 */         this.latitude = null;
/* 145 */         this.longitude = null;
/*     */         
/* 147 */         String message = "Unable to Find your ZipCode. Please enter another nearby Zip Code";
/* 148 */         String title = "Zip Not Found";
/* 149 */         JOptionPane.showMessageDialog(this, message, title, 1);
/* 150 */         this.tfZip.requestFocus();
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 155 */       int firstCommaIndex = data.indexOf(",", index);
/* 156 */       int secondCommaIndex = data.indexOf(",", firstCommaIndex + 1);
/* 157 */       int endIndex = data.indexOf("\n", secondCommaIndex);
/*     */       
/* 159 */       this.latitude = data.substring(firstCommaIndex + 1, secondCommaIndex);
/* 160 */       this.longitude = data.substring(secondCommaIndex + 1, endIndex);
/* 161 */       dispose();
/*     */     
/*     */     }
/* 164 */     catch (Exception ex) {
/*     */       
/* 166 */       ex.printStackTrace();
/*     */     } 
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
/*     */   public String getLatitude() {
/* 179 */     return this.latitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLongitude() {
/* 187 */     return this.longitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLatitude(String string) {
/* 195 */     this.latitude = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLongitude(String string) {
/* 203 */     this.longitude = string;
/*     */   }
/*     */ 
/*     */   
/*     */   void tfZip_keyTyped(KeyEvent e) {
/* 208 */     if (e.getID() == 10)
/*     */     {
/* 210 */       btnGo_actionPerformed((ActionEvent)null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\map\ZipDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */