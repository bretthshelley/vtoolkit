/*     */ package com.vadosity.vnav.client.hosting;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class HtmlSetupPanel extends JPanel {
/*  13 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  14 */   JLabel lblAppletDimensions = new JLabel();
/*  15 */   JLabel lblWidth = new JLabel();
/*  16 */   JComboBox cbWidth = new JComboBox();
/*  17 */   JLabel lblHeight = new JLabel();
/*  18 */   JComboBox cbHeight = new JComboBox();
/*  19 */   JLabel lblTourFile = new JLabel();
/*  20 */   JTextField tfTourFile = new JTextField();
/*  21 */   JLabel lblHtmlFileName = new JLabel();
/*  22 */   JTextField tfHtmlFileName = new JTextField();
/*  23 */   JButton btnNext = new JButton();
/*  24 */   JButton btnPrevious = new JButton();
/*  25 */   JLabel lblEnterTourDirectory = new JLabel();
/*  26 */   JTextField tfTourDirectory = new JTextField();
/*     */   
/*  28 */   JPanel jPanel2 = new JPanel();
/*  29 */   JLabel lblTag = new JLabel();
/*  30 */   JRadioButton radioApplet = new JRadioButton();
/*  31 */   JRadioButton radioObject = new JRadioButton();
/*  32 */   ButtonGroup groupTagType = new ButtonGroup();
/*  33 */   JLabel lblTourName = new JLabel();
/*  34 */   JTextField tfTourName = new JTextField();
/*     */ 
/*     */   
/*     */   public HtmlSetupPanel() {
/*     */     try {
/*  39 */       jbInit();
/*  40 */       setup();
/*     */     }
/*  42 */     catch (Exception e) {
/*  43 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setup() {
/*  49 */     this.cbWidth.addItem(new Integer(500));
/*  50 */     this.cbWidth.addItem(new Integer(600));
/*  51 */     this.cbWidth.addItem(new Integer(700));
/*  52 */     this.cbWidth.addItem(new Integer(800));
/*  53 */     this.cbWidth.addItem(new Integer(900));
/*  54 */     this.cbWidth.addItem(new Integer(1000));
/*  55 */     this.cbWidth.addItem(new Integer(1200));
/*  56 */     this.cbWidth.addItem(new Integer(1500));
/*     */     
/*  58 */     this.cbHeight.addItem(new Integer(400));
/*  59 */     this.cbHeight.addItem(new Integer(500));
/*  60 */     this.cbHeight.addItem(new Integer(600));
/*  61 */     this.cbHeight.addItem(new Integer(700));
/*  62 */     this.cbHeight.addItem(new Integer(800));
/*  63 */     this.cbHeight.addItem(new Integer(1000));
/*  64 */     this.cbHeight.addItem(new Integer(1200));
/*     */     
/*  66 */     Integer iw = new Integer(HostingData.getInstance().getAppletWidth());
/*  67 */     Integer ih = new Integer(HostingData.getInstance().getAppletHeight());
/*     */     
/*  69 */     this.cbWidth.setSelectedItem(iw);
/*  70 */     this.cbHeight.setSelectedItem(ih);
/*     */ 
/*     */ 
/*     */     
/*  74 */     if (Global.getTour() != null) {
/*     */ 
/*     */       
/*  77 */       String path = FileUtility.getInstance().getCurrentFile().getAbsolutePath();
/*  78 */       path = path.substring(path.lastIndexOf(File.separator) + 1);
/*  79 */       this.tfTourFile.setText(path);
/*  80 */       HostingData.getInstance().setTourFilename(path);
/*     */       
/*  82 */       String tourName = path.substring(0, path.lastIndexOf("."));
/*  83 */       this.tfTourName.setText(tourName);
/*  84 */       HostingData.getInstance().setTourName(tourName);
/*     */ 
/*     */       
/*  87 */       HostingData.getInstance().setTourFile(FileUtility.getInstance().getCurrentFile());
/*     */ 
/*     */       
/*  90 */       String filename = path.substring(0, path.indexOf(TourFileFilter.TOUR_EXTENSION));
/*  91 */       filename = String.valueOf(filename) + ".html";
/*  92 */       this.tfHtmlFileName.setText(filename);
/*     */     }
/*     */     else {
/*     */       
/*  96 */       this.tfTourFile.setText(HostingData.getInstance().getTourFilename());
/*  97 */       this.tfTourName.setText(HostingData.getInstance().getTourName());
/*  98 */       this.tfTourDirectory.setText(HostingData.getInstance().getTourDirectoryUrl());
/*  99 */       this.tfHtmlFileName.setText(HostingData.getInstance().getHtmlFilename());
/*     */     } 
/*     */ 
/*     */     
/* 103 */     if (HostingData.getInstance().getTagType() == HostingData.APPLET_TAG_TYPE) {
/*     */       
/* 105 */       this.radioApplet.setSelected(true);
/* 106 */       this.radioObject.setSelected(false);
/*     */     }
/*     */     else {
/*     */       
/* 110 */       this.radioObject.setSelected(true);
/* 111 */       this.radioApplet.setSelected(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 120 */     setLayout(this.gridBagLayout1);
/* 121 */     this.lblAppletDimensions.setText("Applet Dimensions:");
/* 122 */     this.lblAppletDimensions.setVerticalAlignment(0);
/* 123 */     this.lblWidth.setText("Width");
/* 124 */     this.cbWidth.setMinimumSize(new Dimension(60, 19));
/* 125 */     this.cbWidth.setPreferredSize(new Dimension(60, 19));
/* 126 */     this.lblHeight.setText("Height");
/* 127 */     this.cbHeight.setMinimumSize(new Dimension(60, 19));
/* 128 */     this.cbHeight.setPreferredSize(new Dimension(60, 19));
/* 129 */     this.lblTourFile.setText("Tour File");
/* 130 */     this.tfTourFile.setMinimumSize(new Dimension(150, 20));
/* 131 */     this.tfTourFile.setPreferredSize(new Dimension(150, 20));
/* 132 */     this.tfTourFile.setText("");
/* 133 */     this.tfTourFile.setEditable(false);
/* 134 */     this.lblHtmlFileName.setText("HTML File Name");
/* 135 */     this.tfHtmlFileName.setText("");
/* 136 */     this.btnNext.setText("Next");
/* 137 */     this.btnNext.addActionListener(new HtmlSetupPanel_btnNext_actionAdapter(this));
/* 138 */     this.btnPrevious.setText("Back");
/* 139 */     this.btnPrevious.addActionListener(new HtmlSetupPanel_btnPrevious_actionAdapter(this));
/* 140 */     this.lblEnterTourDirectory.setFont(new Font("Dialog", 1, 11));
/* 141 */     this.lblEnterTourDirectory.setText("Enter your Website's tour directory");
/* 142 */     this.tfTourDirectory.setText("http://www.yourwebsite.com/tours");
/* 143 */     this.jPanel2.setMinimumSize(new Dimension(40, 40));
/* 144 */     this.jPanel2.setPreferredSize(new Dimension(40, 40));
/* 145 */     this.jPanel2.setRequestFocusEnabled(true);
/* 146 */     this.lblTag.setText("Tag to Use:");
/* 147 */     this.radioApplet.setText("Applet");
/* 148 */     this.radioApplet.addActionListener(new HtmlSetupPanel_radioApplet_actionAdapter(this));
/* 149 */     this.radioObject.setSelected(true);
/* 150 */     this.radioObject.setText("Object (Java Plug-In)");
/* 151 */     this.radioObject.addActionListener(new HtmlSetupPanel_radioObject_actionAdapter(this));
/* 152 */     this.lblTourName.setText("Tour Name");
/* 153 */     this.tfTourName.setText("");
/* 154 */     addComponentListener(new HtmlSetupPanel_this_componentAdapter(this));
/* 155 */     add(this.lblAppletDimensions, new GridBagConstraints(0, 2, 2, 1, 0.0D, 0.0D, 
/* 156 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 157 */     add(this.lblWidth, new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 
/* 158 */           17, 0, new Insets(5, 15, 5, 5), 0, 0));
/* 159 */     add(this.cbWidth, new GridBagConstraints(3, 2, 1, 1, 0.0D, 0.0D, 
/* 160 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 161 */     add(this.lblHeight, new GridBagConstraints(4, 2, 1, 1, 0.0D, 0.0D, 
/* 162 */           10, 0, new Insets(5, 15, 5, 5), 0, 0));
/* 163 */     add(this.cbHeight, new GridBagConstraints(5, 2, 1, 1, 0.0D, 0.0D, 
/* 164 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 165 */     add(this.lblTourFile, new GridBagConstraints(0, 3, 2, 1, 0.0D, 0.0D, 
/* 166 */           17, 0, new Insets(5, 5, 0, 5), 0, 0));
/* 167 */     add(this.tfTourFile, new GridBagConstraints(2, 3, 4, 1, 0.0D, 0.0D, 
/* 168 */           10, 2, new Insets(5, 5, 5, 5), 0, 0));
/* 169 */     add(this.lblHtmlFileName, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.0D, 
/* 170 */           17, 0, new Insets(5, 5, 0, 0), 0, 0));
/* 171 */     add(this.tfHtmlFileName, new GridBagConstraints(2, 5, 4, 1, 0.0D, 0.0D, 
/* 172 */           10, 2, new Insets(5, 5, 5, 5), 0, 0));
/* 173 */     add(this.lblEnterTourDirectory, new GridBagConstraints(0, 0, 8, 1, 0.0D, 1.0D, 
/* 174 */           16, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 175 */     add(this.tfTourDirectory, new GridBagConstraints(0, 1, 8, 1, 0.0D, 0.0D, 
/* 176 */           17, 2, new Insets(5, 5, 15, 5), 0, 0));
/* 177 */     add(this.jPanel2, new GridBagConstraints(0, 8, 7, 1, 0.0D, 0.0D, 
/* 178 */           10, 1, new Insets(15, 0, 0, 0), 0, 0));
/* 179 */     this.jPanel2.add(this.btnPrevious, (Object)null);
/* 180 */     this.jPanel2.add(this.btnNext, (Object)null);
/* 181 */     add(this.lblTag, new GridBagConstraints(0, 7, 1, 1, 0.0D, 1.0D, 
/* 182 */           18, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 183 */     add(this.radioApplet, new GridBagConstraints(2, 7, 2, 1, 0.0D, 0.0D, 
/* 184 */           18, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 185 */     add(this.radioObject, new GridBagConstraints(4, 7, 3, 1, 0.0D, 0.0D, 
/* 186 */           18, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 187 */     add(this.lblTourName, new GridBagConstraints(0, 4, 1, 1, 0.0D, 0.0D, 
/* 188 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 189 */     add(this.tfTourName, new GridBagConstraints(2, 4, 4, 1, 0.0D, 0.0D, 
/* 190 */           10, 2, new Insets(5, 5, 5, 5), 0, 0));
/* 191 */     this.groupTagType.add(this.radioApplet);
/* 192 */     this.groupTagType.add(this.radioObject);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnPrevious_actionPerformed(ActionEvent e) {
/* 197 */     ((CardLayout)getParent().getLayout()).previous(getParent());
/*     */   }
/*     */ 
/*     */   
/*     */   void btnSelectTourFile_actionPerformed(ActionEvent e) {
/* 202 */     JFileChooser chooser = new JFileChooser();
/* 203 */     String title = "Select Tour File";
/* 204 */     chooser.setDialogTitle(title);
/* 205 */     chooser.setFileFilter((FileFilter)new TourFileFilter());
/* 206 */     chooser.setDialogType(0);
/* 207 */     chooser.setMultiSelectionEnabled(false);
/* 208 */     if (HostingData.getInstance().getTourFile() != null) {
/*     */       
/* 210 */       chooser.setSelectedFile(HostingData.getInstance().getTourFile());
/*     */     }
/* 212 */     else if (Global.getTour() != null) {
/*     */       
/* 214 */       chooser.setSelectedFile(FileUtility.getInstance().getCurrentFile());
/*     */     } 
/*     */     
/* 217 */     int result = chooser.showSaveDialog(this);
/* 218 */     if (result == 1)
/*     */       return; 
/* 220 */     HostingData.getInstance().setTourFile(chooser.getSelectedFile());
/*     */     
/* 222 */     String path = HostingData.getInstance().getTourFile().getAbsolutePath();
/* 223 */     path = path.substring(path.lastIndexOf(File.separator) + 1);
/* 224 */     this.tfTourFile.setText(path);
/*     */     
/* 226 */     String tourName = path.substring(0, path.indexOf(TourFileFilter.TOUR_EXTENSION));
/* 227 */     HostingData.getInstance().setTourName(tourName);
/* 228 */     this.tfTourName.setText(tourName);
/*     */     
/* 230 */     String htmlTourName = String.valueOf(tourName) + ".html";
/* 231 */     this.tfHtmlFileName.setText(htmlTourName);
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
/*     */   void btnNext_actionPerformed(ActionEvent e) {
/* 243 */     String tourDirectoryUrl = this.tfTourDirectory.getText().trim();
/* 244 */     if (tourDirectoryUrl.equals("")) {
/*     */       
/* 246 */       String message = "Please enter your website's tour directory.";
/* 247 */       JOptionPane.showMessageDialog(this, message);
/* 248 */       this.tfTourDirectory.requestFocus();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 253 */     if (tourDirectoryUrl.indexOf("http://") == -1 && tourDirectoryUrl.indexOf("https://") == -1) {
/*     */       
/* 255 */       tourDirectoryUrl = "http://" + tourDirectoryUrl;
/* 256 */       this.tfTourDirectory.setText(tourDirectoryUrl);
/*     */     } 
/*     */     
/* 259 */     String tourfilename = this.tfTourFile.getText().trim();
/* 260 */     if (tourfilename.equals("")) {
/*     */       
/* 262 */       String message = "Please enter your tour file name";
/* 263 */       JOptionPane.showMessageDialog(this, message);
/* 264 */       this.tfTourFile.requestFocus();
/*     */       
/*     */       return;
/*     */     } 
/* 268 */     String htmlfilename = this.tfHtmlFileName.getText().trim();
/* 269 */     if (htmlfilename.equals("")) {
/*     */       
/* 271 */       String message = "Please enter your html file name";
/* 272 */       JOptionPane.showMessageDialog(this, message);
/* 273 */       this.tfHtmlFileName.requestFocus();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 279 */     int appletHeight = ((Integer)this.cbHeight.getSelectedItem()).intValue();
/* 280 */     HostingData.getInstance().setAppletHeight(appletHeight);
/*     */     
/* 282 */     int appletWidth = ((Integer)this.cbWidth.getSelectedItem()).intValue();
/* 283 */     HostingData.getInstance().setAppletWidth(appletWidth);
/*     */     
/* 285 */     HostingData.getInstance().setTourDirectoryUrl(tourDirectoryUrl);
/* 286 */     HostingData.getInstance().setTourFilename(tourfilename);
/* 287 */     HostingData.getInstance().setHtmlFilename(htmlfilename);
/*     */     
/* 289 */     HostingData.getInstance().setTourName(this.tfTourName.getText());
/*     */     
/* 291 */     if (this.radioApplet.isSelected()) { HostingData.getInstance().setTagType(HostingData.APPLET_TAG_TYPE); }
/* 292 */     else if (this.radioObject.isSelected()) { HostingData.getInstance().setTagType(HostingData.OBJECT_TAG_TYPE); }
/*     */     
/* 294 */     HostingData.getInstance().saveState();
/* 295 */     ((CardLayout)getParent().getLayout()).next(getParent());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void radioApplet_actionPerformed(ActionEvent e) {
/* 301 */     HostingData.getInstance().setTagType(HostingData.APPLET_TAG_TYPE);
/*     */   }
/*     */   
/*     */   void radioObject_actionPerformed(ActionEvent e) {
/* 305 */     HostingData.getInstance().setTagType(HostingData.OBJECT_TAG_TYPE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void this_componentShown(ComponentEvent e) {
/* 311 */     ((JDialog)getParent().getParent().getParent().getParent()).setTitle("Hosting Wizard: Step 2 of 4 - Applet Setup");
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\hosting\HtmlSetupPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */