/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.Tour;
/*     */ import com.zfqjava.swing.JDirChooser;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.io.File;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ 
/*     */ public class ImportPhotosDialog extends JDialog {
/*  16 */   private JPanel panelContent = new JPanel();
/*  17 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  18 */   JPanel panelButtons = new JPanel();
/*  19 */   JButton btnFinish = new JButton();
/*  20 */   JLabel lblInstructions = new JLabel();
/*  21 */   JLabel lblSelectFileOrDirectory = new JLabel();
/*     */   
/*  23 */   JTextField tfPhotoDirectory = new JTextField();
/*  24 */   JButton btnPhotoDirectory = new JButton();
/*  25 */   JLabel lblStatusBold = new JLabel();
/*  26 */   JLabel lblStatus = new JLabel();
/*  27 */   JProgressBar progressBarStatus = new JProgressBar();
/*     */   
/*     */   boolean okToContinue = true;
/*  30 */   int filesImported = 0;
/*  31 */   int filesResized = 0;
/*  32 */   JLabel jLabel1 = new JLabel();
/*     */   
/*  34 */   BorderLayout borderLayout1 = new BorderLayout();
/*  35 */   JLabel lblProcessOptimization = new JLabel();
/*  36 */   ImportImagesThread importThread = null;
/*     */ 
/*     */   
/*  39 */   JButton btnStop = new JButton();
/*  40 */   JPanel jPanel1 = new JPanel();
/*  41 */   JRadioButton radioSmall = new JRadioButton();
/*  42 */   JRadioButton radioMedium = new JRadioButton();
/*  43 */   JRadioButton radioLarge = new JRadioButton();
/*  44 */   GridBagLayout gridBagLayout2 = new GridBagLayout();
/*  45 */   JLabel jLabel2 = new JLabel();
/*  46 */   ButtonGroup group = new ButtonGroup();
/*  47 */   JLabel jLabel3 = new JLabel();
/*     */ 
/*     */   
/*  50 */   public static ImportPhotosDialog instance = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupRadioButtons() {
/*  55 */     this.group.add(this.radioSmall);
/*  56 */     this.group.add(this.radioMedium);
/*  57 */     this.group.add(this.radioLarge);
/*     */     
/*  59 */     if (Global.getTour() == null)
/*     */       return; 
/*  61 */     if (Global.getTour().getPhotoSize() == -1) {
/*     */       
/*  63 */       this.radioSmall.setSelected(true);
/*     */     }
/*  65 */     else if (Global.getTour().getPhotoSize() == 0) {
/*     */       
/*  67 */       this.radioMedium.setSelected(true);
/*  68 */       this.radioMedium.updateUI();
/*     */     }
/*  70 */     else if (Global.getTour().getPhotoSize() == 1) {
/*     */       
/*  72 */       this.radioLarge.setSelected(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ImportPhotosDialog(JFrame frame, String title, boolean modal) {
/*  79 */     super(frame, title, modal);
/*     */ 
/*     */     
/*     */     try {
/*  83 */       jbInit();
/*  84 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/*  85 */       UIManager.setLookAndFeel(nativeLF);
/*  86 */       SwingUtilities.updateComponentTreeUI(this);
/*  87 */       this.btnPhotoDirectory.requestFocus();
/*  88 */       this.btnPhotoDirectory.setIcon(new ImageIcon(ImageUtil.loadFolderImage()));
/*  89 */       setupRadioButtons();
/*  90 */       instance = this;
/*     */     }
/*  92 */     catch (Exception ex) {
/*     */       
/*  94 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ImportPhotosDialog(JDialog dlg, String title, boolean modal) {
/* 100 */     super(dlg, title, modal);
/*     */ 
/*     */     
/*     */     try {
/* 104 */       jbInit();
/* 105 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/* 106 */       UIManager.setLookAndFeel(nativeLF);
/* 107 */       SwingUtilities.updateComponentTreeUI(this);
/* 108 */       this.btnPhotoDirectory.requestFocus();
/* 109 */       this.btnPhotoDirectory.setIcon(new ImageIcon(ImageUtil.loadFolderImage()));
/* 110 */       setupRadioButtons();
/* 111 */       instance = this;
/*     */     }
/* 113 */     catch (Exception ex) {
/*     */       
/* 115 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 121 */     this.panelContent.setLayout(this.gridBagLayout1);
/* 122 */     this.panelButtons.setMinimumSize(new Dimension(10, 40));
/* 123 */     this.panelButtons.setPreferredSize(new Dimension(10, 40));
/* 124 */     this.btnFinish.setText("Finish");
/* 125 */     this.btnFinish.addActionListener(new ImportPhotosDialog_btnFinish_actionAdapter(this));
/* 126 */     this.lblInstructions.setText("Select Entire Directory or individual JPG image file to Begin");
/* 127 */     this.lblInstructions.setFont(new Font("Dialog", 1, 12));
/* 128 */     this.lblInstructions.setMaximumSize(new Dimension(331, 25));
/* 129 */     this.lblInstructions.setMinimumSize(new Dimension(331, 25));
/* 130 */     this.lblInstructions.setPreferredSize(new Dimension(331, 25));
/* 131 */     this.lblInstructions.setRequestFocusEnabled(true);
/* 132 */     this.lblSelectFileOrDirectory.setText("Directory or File");
/* 133 */     this.lblSelectFileOrDirectory.setFont(new Font("Dialog", 0, 12));
/* 134 */     this.tfPhotoDirectory.setText("");
/* 135 */     this.tfPhotoDirectory.setPreferredSize(new Dimension(300, 20));
/* 136 */     this.tfPhotoDirectory.setEditable(false);
/* 137 */     this.tfPhotoDirectory.setBackground(SystemColor.activeCaptionText);
/* 138 */     this.tfPhotoDirectory.setEnabled(false);
/* 139 */     this.tfPhotoDirectory.setMinimumSize(new Dimension(300, 20));
/* 140 */     this.btnPhotoDirectory.addActionListener(new ImportPhotosDialog_btnPhotoDirectory_actionAdapter(this));
/* 141 */     this.btnPhotoDirectory.setPreferredSize(new Dimension(41, 22));
/* 142 */     this.btnPhotoDirectory.setMinimumSize(new Dimension(41, 22));
/* 143 */     this.btnPhotoDirectory.setMaximumSize(new Dimension(41, 22));
/* 144 */     this.btnPhotoDirectory.setFont(new Font("Dialog", 1, 12));
/* 145 */     this.lblStatusBold.setText("Status:");
/* 146 */     this.lblStatusBold.setFont(new Font("Dialog", 1, 12));
/* 147 */     this.lblStatus.setFont(new Font("Dialog", 0, 12));
/* 148 */     this.lblStatus.setText("");
/* 149 */     this.progressBarStatus.setFont(new Font("Dialog", 1, 12));
/* 150 */     this.progressBarStatus.setStringPainted(true);
/* 151 */     getContentPane().setLayout(this.borderLayout1);
/* 152 */     this.lblProcessOptimization.setFont(new Font("Dialog", 0, 12));
/* 153 */     this.lblProcessOptimization.setToolTipText("");
/* 154 */     this.lblProcessOptimization.setText("(This process optimizes images for Internet and Email viewing)");
/* 155 */     setTitle("Add Photos to Project");
/* 156 */     this.btnStop.setEnabled(false);
/* 157 */     this.btnStop.setText("Stop");
/* 158 */     this.btnStop.addActionListener(new ImportPhotosDialog_btnStop_actionAdapter(this));
/* 159 */     this.radioSmall.setText("Small");
/* 160 */     this.radioSmall.addActionListener(new ImportPhotosDialog_radioSmall_actionAdapter(this));
/* 161 */     this.radioMedium.setText("Medium");
/* 162 */     this.radioMedium.addActionListener(new ImportPhotosDialog_radioMedium_actionAdapter(this));
/* 163 */     this.radioLarge.setText("Large");
/* 164 */     this.radioLarge.addActionListener(new ImportPhotosDialog_radioLarge_actionAdapter(this));
/* 165 */     this.jPanel1.setLayout(this.gridBagLayout2);
/* 166 */     this.jLabel2.setText("Photo Size:");
/* 167 */     this.jLabel3.setText("(Medium Recommended)");
/* 168 */     this.panelContent.add(this.panelButtons, new GridBagConstraints(0, 6, 4, 1, 0.0D, 0.0D, 
/* 169 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/* 170 */     this.panelButtons.add(this.btnFinish, (Object)null);
/* 171 */     this.panelButtons.add(this.btnStop, (Object)null);
/* 172 */     this.panelContent.add(this.lblInstructions, new GridBagConstraints(0, 0, 4, 1, 0.0D, 0.5D, 
/* 173 */           16, 0, new Insets(15, 5, 5, 0), 0, 0));
/* 174 */     this.panelContent.add(this.lblSelectFileOrDirectory, new GridBagConstraints(0, 1, 2, 1, 0.0D, 0.0D, 
/* 175 */           17, 0, new Insets(5, 5, 0, 5), 0, 0));
/* 176 */     this.panelContent.add(this.tfPhotoDirectory, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/* 177 */           10, 2, new Insets(5, 5, 0, 0), 0, 0));
/* 178 */     this.panelContent.add(this.btnPhotoDirectory, new GridBagConstraints(3, 1, 1, 1, 0.0D, 0.0D, 
/* 179 */           15, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 180 */     this.panelContent.add(this.lblStatusBold, new GridBagConstraints(0, 3, 1, 1, 0.0D, 1.0D, 
/* 181 */           16, 0, new Insets(0, 5, 5, 5), 0, 0));
/* 182 */     this.panelContent.add(this.lblStatus, new GridBagConstraints(1, 2, 3, 2, 0.0D, 1.0D, 
/* 183 */           16, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 184 */     this.panelContent.add(this.progressBarStatus, new GridBagConstraints(0, 4, 4, 1, 0.0D, 0.0D, 
/* 185 */           11, 2, new Insets(0, 0, 0, 0), 0, 0));
/* 186 */     this.panelContent.add(this.lblProcessOptimization, new GridBagConstraints(0, 5, 3, 1, 0.0D, 0.0D, 
/* 187 */           18, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 188 */     this.panelContent.add(this.jPanel1, new GridBagConstraints(0, 2, 4, 1, 0.0D, 0.0D, 
/* 189 */           10, 1, new Insets(0, 0, 0, 0), 0, 40));
/* 190 */     this.jPanel1.add(this.radioSmall, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/* 191 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 192 */     this.jPanel1.add(this.radioMedium, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 
/* 193 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 194 */     this.jPanel1.add(this.radioLarge, new GridBagConstraints(3, 0, 1, 1, 0.0D, 0.0D, 
/* 195 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 196 */     this.jPanel1.add(this.jLabel2, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 197 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 198 */     this.jPanel1.add(this.jLabel3, new GridBagConstraints(4, 0, 1, 1, 1.0D, 0.0D, 
/* 199 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 200 */     getContentPane().add(this.panelContent, "Center");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnStart_actionPerformed(ActionEvent e) {
/*     */     try {
/* 208 */       if (!inputOk())
/*     */         return; 
/* 210 */       String dir = this.tfPhotoDirectory.getText().trim();
/*     */ 
/*     */ 
/*     */       
/* 214 */       this.okToContinue = true;
/* 215 */       this.filesImported = 0;
/* 216 */       this.filesResized = 0;
/* 217 */       String targetDir = RegistryInterface.getCurrentProjectDirectory().getAbsolutePath();
/*     */       
/* 219 */       this.importThread = new ImportImagesThread(this, dir, targetDir, 320, 240);
/* 220 */       this.importThread.start();
/* 221 */       this.btnStop.setEnabled(true);
/*     */     }
/* 223 */     catch (Exception ex) {
/*     */       
/* 225 */       JOptionPane.showMessageDialog(this, ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean inputOk() {
/* 234 */     String dir = this.tfPhotoDirectory.getText().trim();
/*     */     
/* 236 */     if (dir.equals("")) {
/*     */       
/* 238 */       String message = "Please select a directory or image file to import photos from.";
/* 239 */       String title = "No directory selected";
/* 240 */       this.tfPhotoDirectory.requestFocus();
/* 241 */       JOptionPane.showMessageDialog(this, message, title, 1);
/* 242 */       return false;
/*     */     } 
/*     */     
/* 245 */     File f = new File(dir);
/*     */ 
/*     */     
/* 248 */     if (f.isDirectory()) {
/*     */ 
/*     */       
/* 251 */       File[] files = Resizer.getImageFiles(f);
/*     */       
/* 253 */       if (files == null) {
/*     */         
/* 255 */         this.tfPhotoDirectory.setSelectionStart(0);
/* 256 */         this.tfPhotoDirectory.setSelectionEnd(dir.length());
/*     */         
/* 258 */         String message = "Please Select a directory with JPEG images.";
/* 259 */         String title = "No images available";
/* 260 */         this.tfPhotoDirectory.requestFocus();
/* 261 */         this.tfPhotoDirectory.setSelectionStart(0);
/* 262 */         this.tfPhotoDirectory.setSelectionEnd(dir.length());
/* 263 */         JOptionPane.showMessageDialog(this, message, title, 1);
/* 264 */         return false;
/*     */       } 
/*     */     } 
/* 267 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   void btnFinish_actionPerformed(ActionEvent e) {
/*     */     
/* 273 */     try { this.importThread.interrupt(); this.importThread = null; } catch (Exception exception) {}
/* 274 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnPhotoDirectory_actionPerformed(ActionEvent e) {
/* 279 */     JDirChooser chooser = new JDirChooser();
/*     */     
/* 281 */     chooser.setFileSelectionMode(2);
/* 282 */     chooser.setFileFilter(new DirectoryJpegFileFilter(this));
/*     */     
/* 284 */     int result = chooser.showDialog(this, "Select Directory with Photos", null);
/* 285 */     if (result == 1) {
/*     */       return;
/*     */     }
/* 288 */     File f = chooser.getSelectedFile();
/* 289 */     this.tfPhotoDirectory.setText(f.getAbsolutePath());
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 294 */       if (!inputOk()) {
/*     */         return;
/*     */       }
/*     */       
/* 298 */       String targetDir = RegistryInterface.getCurrentProjectDirectory().getAbsolutePath();
/* 299 */       this.okToContinue = true;
/* 300 */       this.importThread = new ImportImagesThread(this, f.getAbsolutePath(), targetDir, 320, 240);
/* 301 */       this.importThread.start();
/* 302 */       this.btnStop.setEnabled(true);
/*     */     }
/* 304 */     catch (Exception ex) {
/*     */       
/* 306 */       JOptionPane.showMessageDialog(this, ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class DirectoryJpegFileFilter
/*     */     extends FileFilter
/*     */   {
/*     */     final ImportPhotosDialog this$0;
/*     */ 
/*     */ 
/*     */     
/*     */     public DirectoryJpegFileFilter(ImportPhotosDialog this$0) {
/* 321 */       this.this$0 = this$0;
/*     */     }
/*     */     
/*     */     public boolean accept(File file) {
/* 325 */       if (file == null) return false; 
/* 326 */       if (file.isDirectory()) return true;
/*     */       
/* 328 */       String path = file.getAbsolutePath().trim().toLowerCase();
/* 329 */       if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return true;
/*     */       
/* 331 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDescription() {
/* 339 */       return "Directories or JPEG Images (*.jpg)";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   class ImportImagesThread
/*     */     extends Thread
/*     */   {
/*     */     String sourceDirectory;
/*     */     String targetDirectory;
/*     */     int targetWidth;
/*     */     int targetHeight;
/*     */     boolean skipImport;
/*     */     final ImportPhotosDialog this$0;
/*     */     
/*     */     ImportImagesThread(ImportPhotosDialog this$0, String srcDir, String targetDir, int width, int height) {
/* 355 */       this.this$0 = this$0; this.sourceDirectory = null; this.targetDirectory = null; this.targetWidth = 320; this.targetHeight = 240;
/* 356 */       this.sourceDirectory = srcDir;
/* 357 */       this.targetDirectory = targetDir;
/* 358 */       this.skipImport = this.sourceDirectory.toLowerCase().trim().equals(this.targetDirectory.toLowerCase().trim());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void determineTargetWidths() {
/* 364 */       Tour tour = Global.getTour();
/*     */       
/* 366 */       if (tour == null || tour.getPhotoSize() == 0) {
/*     */ 
/*     */         
/* 369 */         this.targetWidth = 480;
/* 370 */         this.targetHeight = 360;
/*     */       }
/* 372 */       else if (tour.getPhotoSize() == -1) {
/*     */ 
/*     */         
/* 375 */         this.targetWidth = 320;
/* 376 */         this.targetHeight = 240;
/*     */       }
/* 378 */       else if (tour.getPhotoSize() == 1) {
/*     */ 
/*     */         
/* 381 */         this.targetWidth = 640;
/* 382 */         this.targetHeight = 480;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 390 */       determineTargetWidths();
/*     */       
/* 392 */       File src = new File(this.sourceDirectory);
/* 393 */       if (src.isDirectory()) {
/*     */ 
/*     */         
/* 396 */         if (!this.this$0.okToContinue) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/* 401 */         resizeImages(src, this.targetDirectory);
/* 402 */         SwingUtilities.invokeLater((Runnable)new Object(this));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 413 */         if (!this.this$0.okToContinue) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/* 418 */         try { Thread.sleep(2000L); } catch (Exception exception) {}
/* 419 */         resizeImage(src.getAbsolutePath(), this.targetDirectory);
/*     */       } 
/*     */       
/* 422 */       SwingUtilities.invokeLater((Runnable)new Object(this));
/*     */     }
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
/*     */     public void resizeImage(String path, String targetDirectory) {
/*     */       try {
/* 441 */         String message = "Resizing {0}";
/* 442 */         String[] arrayOfString = { (new File(path)).getName() };
/* 443 */         message = MessageFormat.format(message, (Object[])arrayOfString);
/* 444 */         this.this$0.lblStatus.setText(message);
/* 445 */         Resizer.resize(this.this$0, 
/* 446 */             path, RegistryInterface.getCurrentProjectDirectory().getAbsolutePath(), 
/* 447 */             this.targetWidth, 
/* 448 */             this.targetHeight);
/* 449 */         this.this$0.filesResized++;
/*     */         
/* 451 */         Thread.sleep(100L);
/*     */       }
/* 453 */       catch (Exception exception) {}
/*     */ 
/*     */       
/* 456 */       this.this$0.progressBarStatus.setValue(this.this$0.progressBarStatus.getValue() + 3);
/*     */       
/* 458 */       String status = "Resized {0} file(s) into 'resized' directory";
/* 459 */       String[] sa = { this.this$0.filesResized };
/* 460 */       status = MessageFormat.format(status, (Object[])sa);
/* 461 */       this.this$0.lblStatus.setText(status);
/* 462 */       if (this.this$0.okToContinue) {
/*     */         
/* 464 */         try { Thread.sleep(1500L); } catch (Exception exception) {}
/* 465 */         this.this$0.progressBarStatus.setValue(0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void resizeImages(File sourceDirectory, String targetDirectory) {
/* 474 */       File[] files = Resizer.getImageFiles(sourceDirectory);
/* 475 */       if (files == null) {
/*     */ 
/*     */         
/* 478 */         this.this$0.lblStatus.setText("No JPG image files found in directory");
/*     */         
/*     */         return;
/*     */       } 
/* 482 */       this.this$0.progressBarStatus.setMaximum(files.length);
/* 483 */       this.this$0.progressBarStatus.setValue(0);
/*     */       
/* 485 */       for (int i = 0; i < files.length; i++) {
/*     */         
/* 487 */         if (!this.this$0.okToContinue)
/* 488 */           break;  String path = files[i].getAbsolutePath().toLowerCase();
/*     */         
/*     */         try {
/* 491 */           String str = "Resizing {0}";
/* 492 */           String[] arrayOfString = { files[i].getName() };
/* 493 */           str = MessageFormat.format(str, (Object[])arrayOfString);
/* 494 */           this.this$0.lblStatus.setText(str);
/*     */           
/* 496 */           Resizer.resize(this.this$0, 
/* 497 */               path, RegistryInterface.getCurrentProjectDirectory().getAbsolutePath(), 
/* 498 */               this.targetWidth, 
/* 499 */               this.targetHeight);
/* 500 */           this.this$0.filesResized++;
/* 501 */           Thread.sleep(100L);
/*     */         }
/* 503 */         catch (Exception exception) {}
/*     */ 
/*     */         
/* 506 */         this.this$0.progressBarStatus.setValue(this.this$0.progressBarStatus.getValue() + 1);
/*     */       } 
/*     */       
/* 509 */       String status = "Resized {0} files into 'resized' directory";
/* 510 */       String[] sa = { this.this$0.filesResized };
/* 511 */       status = MessageFormat.format(status, (Object[])sa);
/* 512 */       this.this$0.lblStatus.setText(status);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 518 */       try { Thread.sleep(2000L); } catch (Exception exception) {}
/* 519 */       this.this$0.dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnStop_actionPerformed(ActionEvent e) {
/* 529 */     this.okToContinue = false;
/* 530 */     this.btnStop.setEnabled(false);
/*     */   }
/*     */   
/*     */   void radioSmall_actionPerformed(ActionEvent e) {
/* 534 */     if (Global.getTour() != null)
/*     */     {
/* 536 */       Global.getTour().setPhotoSize(-1);
/*     */     }
/*     */   }
/*     */   
/*     */   void radioMedium_actionPerformed(ActionEvent e) {
/* 541 */     if (Global.getTour() != null)
/*     */     {
/* 543 */       Global.getTour().setPhotoSize(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void radioLarge_actionPerformed(ActionEvent e) {
/* 549 */     if (Global.getTour() != null)
/*     */     {
/* 551 */       Global.getTour().setPhotoSize(1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ImportPhotosDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */