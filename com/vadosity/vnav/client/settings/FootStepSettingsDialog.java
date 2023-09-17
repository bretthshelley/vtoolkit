/*     */ package com.vadosity.vnav.client.settings;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FootStepSettingsDialog extends JDialog {
/*  11 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  12 */   JLabel lblFootStepWidth = new JLabel();
/*  13 */   JLabel lblFootstepLength = new JLabel();
/*  14 */   JLabel lblFillColor = new JLabel();
/*  15 */   JLabel lblOutlineColor = new JLabel();
/*  16 */   JLabel lblSelectedFill = new JLabel();
/*  17 */   JLabel lblSelectedOutline = new JLabel();
/*  18 */   JComboBox cbFootWidth = new JComboBox();
/*  19 */   JComboBox cbFootLength = new JComboBox();
/*  20 */   JPanel panFootFill = new JPanel();
/*  21 */   JButton btnFootFillNull = new JButton();
/*  22 */   BorderLayout borderLayout3 = new BorderLayout();
/*  23 */   JPanel panFootOut = new JPanel();
/*  24 */   JButton btnOk = new JButton();
/*  25 */   JPanel panFootSelFill = new JPanel();
/*  26 */   JButton btnFootSelFillNull = new JButton();
/*  27 */   JPanel panFootSelOut = new JPanel();
/*  28 */   BorderLayout borderLayout1 = new BorderLayout();
/*  29 */   DrawFootStepsSettingsButton drawFootStepsSettingsButton = new DrawFootStepsSettingsButton();
/*  30 */   JLabel lblToggle = new JLabel();
/*     */ 
/*     */   
/*     */   public FootStepSettingsDialog(Dialog p0, String p1, boolean p2) {
/*  34 */     super(p0, p1, p2);
/*     */     try {
/*  36 */       jbInit();
/*     */     
/*     */     }
/*  39 */     catch (Exception e) {
/*  40 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FootStepSettingsDialog(Frame p0, String p1, boolean p2) {
/*  47 */     super(p0, p1, p2);
/*     */     try {
/*  49 */       jbInit();
/*     */     
/*     */     }
/*  52 */     catch (Exception e) {
/*  53 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void populateLists() {
/*  61 */     this.cbFootLength.addItem(new Integer(4));
/*  62 */     this.cbFootLength.addItem(new Integer(6));
/*  63 */     this.cbFootLength.addItem(new Integer(8));
/*  64 */     this.cbFootLength.addItem(new Integer(10));
/*  65 */     this.cbFootLength.addItem(new Integer(14));
/*  66 */     this.cbFootLength.addItem(new Integer(18));
/*  67 */     this.cbFootLength.addItem(new Integer(20));
/*  68 */     this.cbFootLength.addItem(new Integer(24));
/*  69 */     this.cbFootLength.addItem(new Integer(30));
/*  70 */     this.cbFootLength.addItem(new Integer(40));
/*  71 */     this.cbFootLength.addItem(new Integer(50));
/*  72 */     this.cbFootLength.setSelectedItem(new Integer(Settings.getFootstepLength()));
/*     */ 
/*     */     
/*  75 */     this.cbFootWidth.addItem(new Integer(4));
/*  76 */     this.cbFootWidth.addItem(new Integer(6));
/*  77 */     this.cbFootWidth.addItem(new Integer(7));
/*  78 */     this.cbFootWidth.addItem(new Integer(8));
/*  79 */     this.cbFootWidth.addItem(new Integer(9));
/*  80 */     this.cbFootWidth.addItem(new Integer(10));
/*  81 */     this.cbFootWidth.addItem(new Integer(12));
/*  82 */     this.cbFootWidth.addItem(new Integer(14));
/*  83 */     this.cbFootWidth.addItem(new Integer(16));
/*  84 */     this.cbFootWidth.addItem(new Integer(20));
/*  85 */     this.cbFootWidth.addItem(new Integer(25));
/*  86 */     this.cbFootWidth.setSelectedItem(new Integer(Settings.getFootstepWidth()));
/*     */     
/*  88 */     this.panFootFill.setBackground(Settings.getFootstepFillColor());
/*  89 */     this.panFootOut.setBackground(Settings.getFootstepOutlineColor());
/*  90 */     this.panFootSelFill.setBackground(Settings.getSelectedFootstepFillColor());
/*  91 */     this.panFootSelOut.setBackground(Settings.getSelectedFootstepOutlineColor());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  97 */     populateLists();
/*  98 */     this.lblFootStepWidth.setText("Footstep Width");
/*  99 */     getContentPane().setLayout(this.gridBagLayout1);
/* 100 */     this.lblFootstepLength.setText("Footstep Length");
/* 101 */     this.lblFillColor.setText("Fill Color");
/* 102 */     this.lblOutlineColor.setText("Outline Color");
/* 103 */     this.lblSelectedFill.setText("Fill Color when Selected");
/* 104 */     this.lblSelectedOutline.setText("Outline Color when Selected");
/* 105 */     this.panFootFill.setBorder(BorderFactory.createRaisedBevelBorder());
/* 106 */     this.panFootFill.setMaximumSize(new Dimension(80, 20));
/* 107 */     this.panFootFill.setMinimumSize(new Dimension(80, 20));
/* 108 */     this.panFootFill.setPreferredSize(new Dimension(80, 20));
/* 109 */     this.panFootFill.addMouseListener(new FootStepSettingsDialog_panFootFill_mouseAdapter(this));
/* 110 */     this.cbFootWidth.setMinimumSize(new Dimension(60, 20));
/* 111 */     this.cbFootWidth.setPreferredSize(new Dimension(60, 20));
/* 112 */     this.cbFootWidth.addActionListener(new FootStepSettingsDialog_cbFootWidth_actionAdapter(this));
/* 113 */     this.cbFootLength.setMinimumSize(new Dimension(60, 20));
/* 114 */     this.cbFootLength.setPreferredSize(new Dimension(60, 20));
/* 115 */     this.cbFootLength.addActionListener(new FootStepSettingsDialog_cbFootLength_actionAdapter(this));
/* 116 */     this.btnFootFillNull.setMaximumSize(new Dimension(20, 20));
/* 117 */     this.btnFootFillNull.setMinimumSize(new Dimension(20, 20));
/* 118 */     this.btnFootFillNull.setPreferredSize(new Dimension(20, 20));
/* 119 */     this.btnFootFillNull.setMargin(new Insets(2, 4, 2, 4));
/* 120 */     this.btnFootFillNull.setText("X");
/* 121 */     this.btnFootFillNull.addActionListener(new FootStepSettingsDialog_btnFootFillNull_actionAdapter(this));
/* 122 */     this.panFootOut.setBorder(BorderFactory.createRaisedBevelBorder());
/* 123 */     this.panFootOut.setMaximumSize(new Dimension(80, 20));
/* 124 */     this.panFootOut.setMinimumSize(new Dimension(80, 20));
/* 125 */     this.panFootOut.setPreferredSize(new Dimension(80, 20));
/* 126 */     this.panFootOut.addMouseListener(new FootStepSettingsDialog_panFootOut_mouseAdapter(this));
/* 127 */     this.panFootOut.setLayout(this.borderLayout3);
/* 128 */     this.btnOk.setText("OK");
/* 129 */     this.btnOk.addActionListener(new FootStepSettingsDialog_btnOk_actionAdapter(this));
/* 130 */     this.panFootSelFill.setBorder(BorderFactory.createRaisedBevelBorder());
/* 131 */     this.panFootSelFill.setMaximumSize(new Dimension(80, 20));
/* 132 */     this.panFootSelFill.setMinimumSize(new Dimension(80, 20));
/* 133 */     this.panFootSelFill.setPreferredSize(new Dimension(80, 20));
/* 134 */     this.panFootSelFill.addMouseListener(new FootStepSettingsDialog_panFootSelFill_mouseAdapter(this));
/* 135 */     this.btnFootSelFillNull.setMaximumSize(new Dimension(20, 20));
/* 136 */     this.btnFootSelFillNull.setMinimumSize(new Dimension(20, 20));
/* 137 */     this.btnFootSelFillNull.setPreferredSize(new Dimension(20, 20));
/* 138 */     this.btnFootSelFillNull.setHorizontalAlignment(0);
/* 139 */     this.btnFootSelFillNull.setMargin(new Insets(4, 4, 4, 4));
/* 140 */     this.btnFootSelFillNull.setText("X");
/* 141 */     this.btnFootSelFillNull.addActionListener(new FootStepSettingsDialog_btnFootSelFillNull_actionAdapter(this));
/* 142 */     this.panFootSelOut.setBorder(BorderFactory.createRaisedBevelBorder());
/* 143 */     this.panFootSelOut.setMaximumSize(new Dimension(60, 20));
/* 144 */     this.panFootSelOut.setMinimumSize(new Dimension(80, 20));
/* 145 */     this.panFootSelOut.setPreferredSize(new Dimension(80, 20));
/* 146 */     this.panFootSelOut.addMouseListener(new FootStepSettingsDialog_panFootSelOut_mouseAdapter(this));
/* 147 */     this.panFootSelOut.setLayout(this.borderLayout1);
/* 148 */     this.drawFootStepsSettingsButton.setMaximumSize(new Dimension(100, 60));
/* 149 */     this.drawFootStepsSettingsButton.setMinimumSize(new Dimension(100, 60));
/* 150 */     this.drawFootStepsSettingsButton.setPreferredSize(new Dimension(100, 60));
/* 151 */     this.drawFootStepsSettingsButton.setText("");
/* 152 */     this.lblToggle.setText("Toggle On/Off");
/* 153 */     setTitle("Footstep Settings Dialog");
/* 154 */     getContentPane().add(this.lblFootStepWidth, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 155 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 156 */     getContentPane().add(this.lblFootstepLength, new GridBagConstraints(0, 2, 2, 1, 0.0D, 0.0D, 
/* 157 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 158 */     getContentPane().add(this.lblFillColor, new GridBagConstraints(0, 3, 3, 1, 0.0D, 0.0D, 
/* 159 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 160 */     getContentPane().add(this.lblOutlineColor, new GridBagConstraints(0, 4, 3, 1, 0.0D, 0.0D, 
/* 161 */           17, 0, new Insets(5, 10, 0, 0), 0, 0));
/* 162 */     getContentPane().add(this.lblSelectedFill, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.0D, 
/* 163 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 164 */     getContentPane().add(this.lblSelectedOutline, new GridBagConstraints(0, 6, 1, 1, 0.0D, 0.0D, 
/* 165 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 166 */     getContentPane().add(this.cbFootWidth, new GridBagConstraints(3, 1, 1, 1, 0.0D, 0.0D, 
/* 167 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 168 */     getContentPane().add(this.cbFootLength, new GridBagConstraints(3, 2, 1, 1, 0.0D, 0.0D, 
/* 169 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 170 */     getContentPane().add(this.panFootFill, new GridBagConstraints(3, 3, 1, 1, 0.0D, 0.0D, 
/* 171 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 172 */     getContentPane().add(this.panFootOut, new GridBagConstraints(3, 4, 1, 1, 0.0D, 0.0D, 
/* 173 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 174 */     getContentPane().add(this.panFootSelFill, new GridBagConstraints(3, 5, 1, 1, 0.0D, 0.0D, 
/* 175 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 176 */     getContentPane().add(this.panFootSelOut, new GridBagConstraints(3, 6, 1, 1, 0.0D, 0.0D, 
/* 177 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 178 */     getContentPane().add(this.drawFootStepsSettingsButton, new GridBagConstraints(3, 0, 2, 1, 0.0D, 0.0D, 
/* 179 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 180 */     getContentPane().add(this.btnOk, new GridBagConstraints(5, 0, 1, 1, 0.5D, 0.0D, 
/* 181 */           12, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 182 */     getContentPane().add(this.lblToggle, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 183 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 184 */     getContentPane().add(this.btnFootFillNull, new GridBagConstraints(4, 3, 1, 1, 0.0D, 0.0D, 
/* 185 */           17, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 186 */     getContentPane().add(this.btnFootSelFillNull, new GridBagConstraints(4, 5, 1, 1, 0.0D, 0.0D, 
/* 187 */           17, 0, new Insets(0, 0, 0, 0), 0, 0));
/*     */   }
/*     */   
/*     */   void btnFootFillNull_actionPerformed(ActionEvent e) {
/* 191 */     this.panFootFill.setBackground((Color)null);
/* 192 */     Settings.setFootstepFillColor(null);
/* 193 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void panFootFill_mouseClicked(MouseEvent e) {
/* 197 */     String title = "Footstep Fill Color";
/* 198 */     Color c = JColorChooser.showDialog(this, title, Settings.getFootstepFillColor());
/* 199 */     if (c == null)
/* 200 */       return;  if (c.equals(Settings.getFootstepFillColor()))
/* 201 */       return;  Settings.setFootstepFillColor(c);
/* 202 */     this.panFootFill.setBackground(c);
/* 203 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 208 */     dispose();
/*     */   }
/*     */   
/*     */   void panFootOut_mouseClicked(MouseEvent e) {
/* 212 */     String title = "Footstep Outline Color";
/* 213 */     Color c = JColorChooser.showDialog(this, title, Settings.getFootstepOutlineColor());
/* 214 */     if (c == null)
/* 215 */       return;  if (c.equals(Settings.getFootstepOutlineColor()))
/* 216 */       return;  Settings.setFootstepOutlineColor(c);
/* 217 */     this.panFootOut.setBackground(c);
/* 218 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void panFootSelFill_mouseClicked(MouseEvent e) {
/* 223 */     String title = "Footstep Fill Color when Selected";
/* 224 */     Color c = JColorChooser.showDialog(this, title, 
/* 225 */         Settings.getSelectedFootstepFillColor());
/* 226 */     if (c == null)
/* 227 */       return;  if (c.equals(Settings.getSelectedFootstepFillColor()))
/* 228 */       return;  Settings.setSelectedFootstepFillColor(c);
/* 229 */     this.panFootSelFill.setBackground(c);
/* 230 */     Global.fireSelectedPhotoPointChanged(this);
/* 231 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void panFootSelOut_mouseClicked(MouseEvent e) {
/* 238 */     String title = "Footstep Outline Color when Selected";
/* 239 */     Color c = JColorChooser.showDialog(this, title, Settings.getSelectedFootstepOutlineColor());
/* 240 */     if (c == null)
/* 241 */       return;  if (c.equals(Settings.getSelectedFootstepOutlineColor()))
/* 242 */       return;  Settings.setSelectedFootstepOutlineColor(c);
/* 243 */     this.panFootSelOut.setBackground(c);
/* 244 */     Global.fireSelectedPhotoPointChanged(this);
/* 245 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnFootSelFillNull_actionPerformed(ActionEvent e) {
/* 250 */     this.panFootSelFill.setBackground((Color)null);
/* 251 */     Settings.setSelectedFootstepFillColor(null);
/* 252 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void cbFootWidth_actionPerformed(ActionEvent e) {
/* 257 */     Settings.setFootstepWidth(((Integer)this.cbFootWidth.getSelectedItem()).intValue());
/*     */     
/* 259 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void cbFootLength_actionPerformed(ActionEvent e) {
/* 264 */     Settings.setFootstepLength(((Integer)this.cbFootLength.getSelectedItem()).intValue());
/*     */     
/* 266 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\FootStepSettingsDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */