/*     */ package com.vadosity.vnav.client.hosting;
/*     */ import com.zfqjava.swing.JDirChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class FileTransferPanel extends JPanel {
/*  18 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  19 */   JPanel jPanel2 = new JPanel();
/*     */   TitledBorder borderStage;
/*     */   TitledBorder borderTransfer;
/*  22 */   JPanel jPanel3 = new JPanel();
/*  23 */   JLabel lblFileUrls = new JLabel();
/*  24 */   GridBagLayout gridBagLayout2 = new GridBagLayout();
/*  25 */   JLabel lblDash1 = new JLabel();
/*  26 */   JButton btnStageFiles = new JButton();
/*  27 */   JPanel jPanel4 = new JPanel();
/*  28 */   JButton btnBack = new JButton();
/*  29 */   JButton btnFinish = new JButton();
/*  30 */   GridBagLayout gridBagLayout3 = new GridBagLayout();
/*  31 */   JLabel lblTourFileUrl = new JLabel();
/*  32 */   JLabel lblHtmlFileUrl = new JLabel();
/*  33 */   JLabel lblFtpFiles = new JLabel();
/*  34 */   JLabel lblVadosityJarFile = new JLabel();
/*  35 */   JLabel lblDash2 = new JLabel();
/*  36 */   JLabel lblDash3 = new JLabel();
/*  37 */   JPanel jPanel5 = new JPanel();
/*     */   TitledBorder borderTest;
/*  39 */   GridBagLayout gridBagLayout4 = new GridBagLayout();
/*  40 */   JLabel lblSelectGo = new JLabel();
/*  41 */   JTextField tfTourUrl = new JTextField();
/*  42 */   JButton btnTestTour = new JButton();
/*     */   
/*     */   public FileTransferPanel() {
/*     */     try {
/*  46 */       jbInit();
/*     */     }
/*  48 */     catch (Exception e) {
/*  49 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  55 */     this.borderStage = new TitledBorder("1. Stage Files to a directory");
/*  56 */     this.borderTransfer = new TitledBorder("2. FTP Files Directly to your web server");
/*  57 */     this.borderTest = new TitledBorder("");
/*  58 */     setLayout(this.gridBagLayout1);
/*  59 */     this.jPanel2.setBorder(this.borderStage);
/*  60 */     this.jPanel2.setMinimumSize(new Dimension(420, 70));
/*  61 */     this.jPanel2.setPreferredSize(new Dimension(420, 70));
/*  62 */     this.jPanel2.setLayout(this.gridBagLayout2);
/*  63 */     this.jPanel3.setBorder(this.borderTransfer);
/*  64 */     this.jPanel3.setMinimumSize(new Dimension(100, 160));
/*  65 */     this.jPanel3.setPreferredSize(new Dimension(100, 160));
/*  66 */     this.jPanel3.setLayout(this.gridBagLayout3);
/*  67 */     this.lblFileUrls.setToolTipText("");
/*  68 */     this.lblFileUrls.setText("Once complete, files should be present at following URLs:");
/*  69 */     this.lblDash1.setText("-");
/*  70 */     this.btnStageFiles.setText("Stage Files Now");
/*  71 */     this.btnStageFiles.addActionListener(new FileTransferPanel_btnStageFiles_actionAdapter(this));
/*  72 */     this.jPanel4.setMinimumSize(new Dimension(10, 40));
/*  73 */     this.jPanel4.setPreferredSize(new Dimension(10, 40));
/*  74 */     this.btnBack.setText("Back");
/*  75 */     this.btnBack.addActionListener(new FileTransferPanel_btnBack_actionAdapter(this));
/*  76 */     this.btnFinish.setText("Finish");
/*  77 */     this.btnFinish.addActionListener(new FileTransferPanel_btnFinish_actionAdapter(this));
/*  78 */     addComponentListener(new FileTransferPanel_this_componentAdapter(this));
/*  79 */     this.borderStage.setTitle("1. Stage (copy) three files to a single directory");
/*  80 */     this.borderTransfer.setTitle("2. Transfer files to your web server using your preferred software");
/*  81 */     this.lblTourFileUrl.setForeground(Color.blue);
/*  82 */     this.lblTourFileUrl.setText("Tour File Url");
/*  83 */     this.lblTourFileUrl.addMouseListener(new FileTransferPanel_lblTourFileUrl_mouseAdapter(this));
/*  84 */     this.lblHtmlFileUrl.setForeground(Color.blue);
/*  85 */     this.lblHtmlFileUrl.setText("HTML File Url");
/*  86 */     this.lblHtmlFileUrl.addMouseListener(new FileTransferPanel_lblHtmlFileUrl_mouseAdapter(this));
/*  87 */     this.lblFtpFiles.setText("FTP, publish, deploy, transfer or upload files to your webserver");
/*  88 */     this.lblVadosityJarFile.setForeground(Color.blue);
/*  89 */     this.lblVadosityJarFile.setText("Vadosity Jar File Url");
/*  90 */     this.lblVadosityJarFile.addMouseListener(new FileTransferPanel_lblVadosityJarFile_mouseAdapter(this));
/*  91 */     this.lblDash2.setText("-");
/*  92 */     this.lblDash3.setText("-");
/*  93 */     this.jPanel5.setBorder(this.borderTest);
/*  94 */     this.jPanel5.setMinimumSize(new Dimension(10, 100));
/*  95 */     this.jPanel5.setPreferredSize(new Dimension(10, 100));
/*  96 */     this.jPanel5.setLayout(this.gridBagLayout4);
/*  97 */     this.borderTest.setTitle("3. Test Tour");
/*  98 */     this.borderTest.setBorder(BorderFactory.createEtchedBorder());
/*  99 */     this.lblSelectGo.setText("Select 'Go' to Test Tour ");
/* 100 */     this.tfTourUrl.setMinimumSize(new Dimension(340, 20));
/* 101 */     this.tfTourUrl.setPreferredSize(new Dimension(340, 20));
/* 102 */     this.tfTourUrl.setText("");
/* 103 */     this.btnTestTour.setText("Go");
/* 104 */     this.btnTestTour.addActionListener(new FileTransferPanel_btnTestTour_actionAdapter(this));
/* 105 */     add(this.jPanel2, new GridBagConstraints(0, 1, 1, 1, 0.0D, 1.0D, 
/* 106 */           10, 1, new Insets(5, 5, 0, 5), 0, 0));
/* 107 */     this.jPanel2.add(this.btnStageFiles, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 
/* 108 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 109 */     add(this.jPanel3, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 110 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 111 */     this.jPanel3.add(this.lblFileUrls, new GridBagConstraints(0, 1, 2, 1, 0.0D, 0.0D, 
/* 112 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 113 */     this.jPanel3.add(this.lblTourFileUrl, new GridBagConstraints(1, 2, 1, 1, 0.0D, 0.0D, 
/* 114 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 115 */     add(this.jPanel4, new GridBagConstraints(0, 4, 1, 1, 0.0D, 0.0D, 
/* 116 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/* 117 */     this.jPanel4.add(this.btnBack, (Object)null);
/* 118 */     this.jPanel4.add(this.btnFinish, (Object)null);
/* 119 */     add(this.jPanel5, new GridBagConstraints(0, 3, 1, 1, 0.0D, 1.0D, 
/* 120 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 121 */     this.jPanel5.add(this.lblSelectGo, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 122 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 123 */     this.jPanel5.add(this.tfTourUrl, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 124 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 125 */     this.jPanel5.add(this.btnTestTour, new GridBagConstraints(2, 1, 1, 2, 0.0D, 0.0D, 
/* 126 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 127 */     this.jPanel3.add(this.lblHtmlFileUrl, new GridBagConstraints(1, 3, 1, 1, 0.0D, 0.0D, 
/* 128 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 129 */     this.jPanel3.add(this.lblDash1, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 130 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 131 */     this.jPanel3.add(this.lblFtpFiles, new GridBagConstraints(0, 0, 2, 1, 0.0D, 0.0D, 
/* 132 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 133 */     this.jPanel3.add(this.lblDash2, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/* 134 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 135 */     this.jPanel3.add(this.lblVadosityJarFile, new GridBagConstraints(1, 4, 1, 1, 0.0D, 0.0D, 
/* 136 */           17, 0, new Insets(0, 5, 0, 5), 0, 0));
/* 137 */     this.jPanel3.add(this.lblDash3, new GridBagConstraints(0, 4, 1, 1, 0.0D, 0.0D, 
/* 138 */           10, 0, new Insets(0, 5, 0, 5), 0, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnStageFiles_actionPerformed(ActionEvent e) {
/*     */     try {
/* 146 */       JDirChooser chooser = new JDirChooser();
/* 147 */       File projectStagingFile = null;
/*     */       
/*     */       try {
/* 150 */         File file = new File(String.valueOf(System.getProperty("user.home")) + File.separator + "My Documents");
/* 151 */         if (file.exists()) { projectStagingFile = file; }
/* 152 */         else { file = null; }
/*     */       
/* 154 */       } catch (Exception exception) {}
/*     */       
/* 156 */       if (projectStagingFile != null) { chooser.setSelectedFile(projectStagingFile); }
/* 157 */       else if (HostingData.getInstance().getStagingDirectory() != null) { chooser.setSelectedFile(HostingData.getInstance().getStagingDirectory()); }
/* 158 */        chooser.setFileSelectionMode(1);
/* 159 */       String title = "Select Staging Directory";
/* 160 */       int result = chooser.showDialog(this, title, null);
/* 161 */       if (result == 1)
/* 162 */         return;  File f = chooser.getSelectedFile();
/*     */ 
/*     */       
/* 165 */       HostingData.getInstance().setStagingDirectory(f);
/* 166 */       HostingData.getInstance().saveState();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       String htmlFilepath = String.valueOf(f.getAbsolutePath()) + File.separator + HostingData.getInstance().getHtmlFilename();
/* 172 */       FileOutputStream fos1 = new FileOutputStream(htmlFilepath);
/* 173 */       fos1.write(HostingData.getInstance().getHtmlText().getBytes());
/* 174 */       fos1.flush();
/* 175 */       fos1.close();
/* 176 */       fos1 = null;
/*     */ 
/*     */       
/* 179 */       String tourFilepath = String.valueOf(f.getAbsolutePath()) + File.separator + HostingData.getInstance().getTourFilename();
/* 180 */       FileOutputStream fos2 = new FileOutputStream(tourFilepath);
/* 181 */       ObjectOutputStream oos = new ObjectOutputStream(fos2);
/* 182 */       oos.writeObject(Global.getTour());
/* 183 */       oos.flush();
/* 184 */       oos.close();
/* 185 */       oos = null;
/*     */ 
/*     */       
/* 188 */       File jar = new File("vadosity.jar");
/* 189 */       if (!jar.exists())
/*     */       {
/* 191 */         jar = new File(HostingData.getInstance().getVadosityJarFilePath());
/*     */       }
/* 193 */       if (!jar.exists()) {
/*     */ 
/*     */         
/* 196 */         JFileChooser fc = new JFileChooser();
/* 197 */         fc.setMultiSelectionEnabled(false);
/* 198 */         fc.setDialogTitle("Please locate 'vadosity.jar' archive");
/* 199 */         int n = fc.showOpenDialog(this);
/* 200 */         if (n == 1)
/*     */           return; 
/* 202 */         File f2 = fc.getSelectedFile();
/* 203 */         if (!f2.getAbsolutePath().toLowerCase().endsWith("vadosity.jar")) {
/*     */           
/* 205 */           String str = "Unable to locate vadosity.jar archive";
/* 206 */           JOptionPane.showMessageDialog(this, str);
/*     */         }
/*     */         else {
/*     */           
/* 210 */           HostingData.getInstance().setVadosityJarFilePath(f2.getAbsolutePath());
/* 211 */           HostingData.getInstance().saveState();
/* 212 */           jar = new File(HostingData.getInstance().getVadosityJarFilePath());
/*     */         } 
/*     */       } 
/* 215 */       String jarFilepath = null;
/* 216 */       if (jar.exists()) {
/*     */         
/* 218 */         FileInputStream fis3 = new FileInputStream(jar);
/* 219 */         jarFilepath = f + File.separator + "vadosity.jar";
/* 220 */         FileOutputStream fos3 = new FileOutputStream(jarFilepath);
/*     */         
/* 222 */         byte[] bytes = new byte[fis3.available()];
/* 223 */         fis3.read(bytes);
/* 224 */         fos3.write(bytes);
/* 225 */         fos3.flush();
/* 226 */         fos3.close();
/* 227 */         fis3.close();
/*     */       } 
/*     */       
/* 230 */       String message = "Files were staged to following locations:\n{0}\n{1}\n{2}";
/* 231 */       String[] sa = { htmlFilepath, tourFilepath, jarFilepath };
/* 232 */       message = MessageFormat.format(message, (Object[])sa);
/* 233 */       JOptionPane.showMessageDialog(this, message);
/*     */     }
/* 235 */     catch (Exception e2) {
/*     */       
/* 237 */       JOptionPane.showMessageDialog(this, e2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void btnBack_actionPerformed(ActionEvent e) {
/* 244 */     ((CardLayout)getParent().getLayout()).previous(getParent());
/*     */   }
/*     */   
/*     */   void btnFinish_actionPerformed(ActionEvent e) {
/* 248 */     HostingData.getInstance().saveState();
/* 249 */     ((JDialog)getParent().getParent().getParent().getParent()).dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void this_componentShown(ComponentEvent e) {
/* 254 */     setup();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup() {
/* 259 */     String title = "Hosting Wizard: Step 4 of 4 - Stage, Transfer, and Test";
/* 260 */     ((JDialog)getParent().getParent().getParent().getParent()).setTitle(title);
/*     */     
/* 262 */     this.lblHtmlFileUrl.setText(HostingData.getInstance().getHtmlFileUrl());
/* 263 */     this.lblTourFileUrl.setText(HostingData.getInstance().getTourFileUrl());
/* 264 */     this.lblVadosityJarFile.setText(HostingData.getInstance().getJarFileUrl());
/*     */     
/* 266 */     String htmlPageUrl = String.valueOf(HostingData.getInstance().getTourDirectoryUrl()) + "/" + HostingData.getInstance().getHtmlFilename();
/* 267 */     this.tfTourUrl.setText(htmlPageUrl);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnTestTour_actionPerformed(ActionEvent e) {
/*     */     try {
/* 273 */       String url = this.tfTourUrl.getText().trim();
/* 274 */       if (url.toLowerCase().endsWith(".htm") || url.toLowerCase().endsWith(".html"))
/*     */       {
/* 276 */         url = String.valueOf(url) + "?rand=" + Math.random();
/*     */       }
/* 278 */       BrowserUtil.displayURL(url);
/*     */     
/*     */     }
/* 281 */     catch (Exception ex) {
/*     */       
/* 283 */       JOptionPane.showMessageDialog(this, ex.toString(), ex.toString(), 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void lblTourFileUrl_mouseClicked(MouseEvent e) {
/*     */     try {
/* 291 */       String url = this.lblTourFileUrl.getText();
/* 292 */       if (url.toLowerCase().endsWith(".htm") || url.toLowerCase().endsWith(".html"))
/*     */       {
/* 294 */         url = String.valueOf(url) + "?rand=" + Math.random();
/*     */       }
/* 296 */       BrowserUtil.displayURL(url);
/*     */     
/*     */     }
/* 299 */     catch (Exception ex) {
/*     */       
/* 301 */       JOptionPane.showMessageDialog(this, ex.toString(), ex.toString(), 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void lblHtmlFileUrl_mouseClicked(MouseEvent e) {
/*     */     try {
/* 310 */       String url = this.lblHtmlFileUrl.getText().trim();
/* 311 */       if (url.toLowerCase().endsWith(".htm") || url.toLowerCase().endsWith(".html"))
/*     */       {
/* 313 */         url = String.valueOf(url) + "?rand=" + Math.random();
/*     */       }
/* 315 */       BrowserUtil.displayURL(url);
/*     */     
/*     */     }
/* 318 */     catch (Exception ex) {
/*     */       
/* 320 */       JOptionPane.showMessageDialog(this, ex.toString(), ex.toString(), 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void lblVadosityJarFile_mouseClicked(MouseEvent e) {
/*     */     try {
/* 329 */       String url = this.lblVadosityJarFile.getText();
/* 330 */       if (url.toLowerCase().endsWith(".htm") || url.toLowerCase().endsWith(".html"))
/*     */       {
/* 332 */         url = String.valueOf(url) + "?rand=" + Math.random();
/*     */       }
/* 334 */       BrowserUtil.displayURL(url);
/*     */     
/*     */     }
/* 337 */     catch (Exception ex) {
/*     */       
/* 339 */       JOptionPane.showMessageDialog(this, ex.toString(), ex.toString(), 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void lblTourFileUrl_mouseEntered(MouseEvent e) {
/* 345 */     this.lblTourFileUrl.setForeground(Color.magenta);
/*     */   }
/*     */   
/*     */   void lblTourFileUrl_mouseExited(MouseEvent e) {
/* 349 */     this.lblTourFileUrl.setForeground(Color.blue);
/*     */   }
/*     */   
/*     */   void lblHtmlFileUrl_mouseEntered(MouseEvent e) {
/* 353 */     this.lblHtmlFileUrl.setForeground(Color.magenta);
/*     */   }
/*     */   
/*     */   void lblHtmlFileUrl_mouseExited(MouseEvent e) {
/* 357 */     this.lblHtmlFileUrl.setForeground(Color.blue);
/*     */   }
/*     */   
/*     */   void lblVadosityJarFile_mouseEntered(MouseEvent e) {
/* 361 */     this.lblVadosityJarFile.setForeground(Color.magenta);
/*     */   }
/*     */   
/*     */   void lblVadosityJarFile_mouseExited(MouseEvent e) {
/* 365 */     this.lblVadosityJarFile.setForeground(Color.blue);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\hosting\FileTransferPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */