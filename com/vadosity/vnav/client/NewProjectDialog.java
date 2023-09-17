/*     */ package com.vadosity.vnav.client;
/*     */ import com.zfqjava.swing.JDirChooser;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.HeadlessException;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.io.File;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class NewProjectDialog extends JDialog {
/*  15 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  16 */   JLabel lblProjectName = new JLabel();
/*  17 */   JTextField tfProjectName = new JTextField();
/*  18 */   JLabel lblProjectLocation = new JLabel();
/*  19 */   JTextField tfProjectLocation = new JTextField();
/*  20 */   JButton btnDirectory = new JButton();
/*  21 */   JLabel lblSpacer = new JLabel();
/*  22 */   JButton btnCancel = new JButton();
/*  23 */   JButton btnOk = new JButton();
/*  24 */   String projectsDirectory = null;
/*  25 */   String newProjectDirectory = null;
/*     */   
/*  27 */   int result = 2;
/*     */ 
/*     */ 
/*     */   
/*     */   public NewProjectDialog() throws HeadlessException {
/*     */     try {
/*  33 */       jbInit();
/*     */       
/*  35 */       this.projectsDirectory = RegistryInterface.getProjectsDirectory();
/*  36 */       this.tfProjectName.setText(getNewProjectName());
/*  37 */       updateProjectDirectory();
/*     */       
/*  39 */       ImageIcon dirIcon = new ImageIcon(ImageUtil.loadFolderImage());
/*  40 */       this.btnDirectory.setIcon(dirIcon);
/*     */     }
/*  42 */     catch (Exception e) {
/*  43 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NewProjectDialog(Frame f) throws HeadlessException {
/*  50 */     super(f);
/*     */ 
/*     */     
/*     */     try {
/*  54 */       jbInit();
/*     */       
/*  56 */       this.projectsDirectory = RegistryInterface.getProjectsDirectory();
/*  57 */       this.tfProjectName.setText(getNewProjectName());
/*  58 */       updateProjectDirectory();
/*     */       
/*  60 */       ImageIcon dirIcon = new ImageIcon(ImageUtil.loadFolderImage());
/*  61 */       this.btnDirectory.setIcon(dirIcon);
/*     */     }
/*  63 */     catch (Exception e) {
/*  64 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  70 */     this.lblProjectName.setText("Project Name");
/*  71 */     getContentPane().setLayout(this.gridBagLayout1);
/*  72 */     this.tfProjectName.setMinimumSize(new Dimension(200, 20));
/*  73 */     this.tfProjectName.setPreferredSize(new Dimension(200, 20));
/*  74 */     this.tfProjectName.setText("");
/*  75 */     this.tfProjectName.addKeyListener(new NewProjectDialog_tfProjectName_keyAdapter(this));
/*  76 */     this.tfProjectName.addFocusListener(new NewProjectDialog_tfProjectName_focusAdapter(this));
/*  77 */     this.lblProjectLocation.setText("Project Directory");
/*  78 */     this.tfProjectLocation.setMinimumSize(new Dimension(360, 20));
/*  79 */     this.tfProjectLocation.setPreferredSize(new Dimension(360, 20));
/*  80 */     this.tfProjectLocation.setEditable(false);
/*  81 */     this.btnDirectory.setMaximumSize(new Dimension(33, 9));
/*  82 */     this.btnDirectory.setMinimumSize(new Dimension(40, 20));
/*  83 */     this.btnDirectory.setPreferredSize(new Dimension(40, 20));
/*  84 */     this.btnDirectory.setText("");
/*  85 */     this.btnDirectory.addActionListener(new NewProjectDialog_btnDirectory_actionAdapter(this));
/*  86 */     this.lblSpacer.setMaximumSize(new Dimension(120, 15));
/*  87 */     this.lblSpacer.setMinimumSize(new Dimension(100, 15));
/*  88 */     this.lblSpacer.setPreferredSize(new Dimension(120, 15));
/*  89 */     this.lblSpacer.setText("");
/*  90 */     this.btnCancel.setMaximumSize(new Dimension(80, 23));
/*  91 */     this.btnCancel.setMinimumSize(new Dimension(80, 23));
/*  92 */     this.btnCancel.setPreferredSize(new Dimension(80, 23));
/*  93 */     this.btnCancel.setText("Cancel");
/*  94 */     this.btnCancel.addActionListener(new NewProjectDialog_btnCancel_actionAdapter(this));
/*  95 */     this.btnOk.setMaximumSize(new Dimension(80, 23));
/*  96 */     this.btnOk.setMinimumSize(new Dimension(80, 23));
/*  97 */     this.btnOk.setPreferredSize(new Dimension(80, 23));
/*  98 */     this.btnOk.setText("OK");
/*  99 */     this.btnOk.addActionListener(new NewProjectDialog_btnOk_actionAdapter(this));
/* 100 */     addInputMethodListener(new NewProjectDialog_this_inputMethodAdapter(this));
/* 101 */     setTitle("Create New Project Directory");
/* 102 */     getContentPane().add(this.lblSpacer, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/* 103 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 104 */     getContentPane().add(this.tfProjectName, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 105 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 106 */     getContentPane().add(this.lblProjectName, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 107 */           16, 0, new Insets(5, 10, 0, 5), 0, 0));
/* 108 */     getContentPane().add(this.tfProjectLocation, new GridBagConstraints(0, 3, 2, 1, 0.0D, 1.0D, 
/* 109 */           18, 2, new Insets(5, 10, 5, 0), 0, 0));
/* 110 */     getContentPane().add(this.lblProjectLocation, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 111 */           16, 0, new Insets(10, 10, 0, 5), 0, 0));
/* 112 */     getContentPane().add(this.btnCancel, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/* 113 */           12, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 114 */     getContentPane().add(this.btnOk, new GridBagConstraints(2, 0, 1, 1, 1.0D, 0.0D, 
/* 115 */           12, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 116 */     getContentPane().add(this.btnDirectory, new GridBagConstraints(2, 3, 1, 1, 0.0D, 0.0D, 
/* 117 */           18, 0, new Insets(5, 0, 5, 5), 0, 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateProjectDirectory() {
/* 122 */     String text = this.tfProjectName.getText().trim();
/*     */     
/* 124 */     this.newProjectDirectory = String.valueOf(this.projectsDirectory) + File.separator + text;
/* 125 */     this.newProjectDirectory = Formatter.replaceAll(this.newProjectDirectory, "." + File.separator, "");
/* 126 */     String doubleSep = String.valueOf(File.separator) + File.separator;
/* 127 */     this.newProjectDirectory = Formatter.replaceAll(this.newProjectDirectory, doubleSep, File.separator);
/* 128 */     this.tfProjectLocation.setText(this.newProjectDirectory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNewProjectName() {
/*     */     try {
/* 137 */       File dir = new File(this.projectsDirectory);
/* 138 */       File[] fa = dir.listFiles();
/* 139 */       if (fa == null || fa.length == 0) return "Tour 1"; 
/* 140 */       int counter = 1;
/* 141 */       while ("a".equals("a")) {
/*     */         
/* 143 */         String testName = "Project " + counter;
/* 144 */         boolean valueFound = false;
/* 145 */         for (int i = 0; i < fa.length; i++) {
/*     */           
/* 147 */           if (fa[i].getName().equalsIgnoreCase(testName) && fa[i].isDirectory()) {
/*     */             
/* 149 */             valueFound = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 153 */         if (!valueFound) return testName; 
/* 154 */         counter++;
/*     */       } 
/* 156 */       return "Not Reachable";
/*     */     
/*     */     }
/* 159 */     catch (Exception e) {
/*     */       
/* 161 */       return "New Project";
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
/*     */   void btnDirectory_actionPerformed(ActionEvent e) {
/*     */     try {
/* 174 */       JDirChooser chooser = new JDirChooser();
/* 175 */       chooser.setSelectedFile(new File(this.projectsDirectory));
/* 176 */       chooser.setFileSelectionMode(1);
/*     */       
/* 178 */       int result = chooser.showDialog(this, "Select Base Directory", null);
/* 179 */       if (result == 1)
/*     */         return; 
/* 181 */       File f = chooser.getSelectedFile();
/* 182 */       this.projectsDirectory = f.getAbsolutePath();
/* 183 */       RegistryInterface.setProjectsDirectory(this.projectsDirectory);
/*     */       
/* 185 */       updateProjectDirectory();
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 190 */     catch (Exception ex) {
/*     */       
/* 192 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   void tfProjectName_focusLost(FocusEvent e) {
/* 197 */     updateProjectDirectory();
/*     */   }
/*     */ 
/*     */   
/*     */   void tfProjectName_keyTyped(KeyEvent e) {
/* 202 */     updateProjectDirectory();
/*     */     
/* 204 */     if (e.getKeyChar() == '\n')
/*     */     {
/* 206 */       btnOk_actionPerformed((ActionEvent)null);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void this_inputMethodTextChanged(InputMethodEvent e) {
/* 212 */     updateProjectDirectory();
/*     */   }
/*     */   
/*     */   void btnCancel_actionPerformed(ActionEvent e) {
/* 216 */     setResult(2);
/* 217 */     dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getResult() {
/* 227 */     return this.result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResult(int result) {
/* 233 */     this.result = result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupDirectory(File directory) {
/* 239 */     if (!directory.isDirectory()) directory.mkdir(); 
/* 240 */     if (!directory.exists()) {
/*     */       
/*     */       try {
/*     */         
/* 244 */         directory.createNewFile();
/*     */       }
/* 246 */       catch (Exception e) {
/*     */         
/* 248 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 256 */     if (this.tfProjectName.getText().trim().equals("")) {
/*     */       
/* 258 */       String message = "Please Specify New Project Directory Name";
/* 259 */       String title = "No Name Specified";
/* 260 */       JOptionPane.showMessageDialog(this, message, title, 2);
/* 261 */       this.tfProjectName.requestFocus();
/*     */       
/*     */       return;
/*     */     } 
/* 265 */     this.result = 0;
/*     */ 
/*     */     
/* 268 */     File dir = new File(this.newProjectDirectory);
/* 269 */     setupDirectory(dir);
/*     */ 
/*     */     
/* 272 */     RegistryInterface.setCurrentProjectDirectory(this.newProjectDirectory);
/*     */     
/* 274 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\NewProjectDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */