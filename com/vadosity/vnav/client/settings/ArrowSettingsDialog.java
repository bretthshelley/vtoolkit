/*     */ package com.vadosity.vnav.client.settings;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class ArrowSettingsDialog extends JDialog {
/*  13 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  14 */   JLabel lblArrowLength = new JLabel();
/*  15 */   JLabel lblBladeLength = new JLabel();
/*  16 */   JLabel lblArrowColor = new JLabel();
/*  17 */   JLabel lblSelectedArrowColor = new JLabel();
/*  18 */   JComboBox cbArrowLength = new JComboBox();
/*  19 */   JComboBox cbBladeLength = new JComboBox();
/*  20 */   JPanel panArrowColor = new JPanel();
/*  21 */   JButton btnOk = new JButton();
/*  22 */   JPanel panSelectedArrowColor = new JPanel();
/*  23 */   DrawLightArrowsToggleButton drawLightArrowsToggleButton = new DrawLightArrowsToggleButton();
/*  24 */   JLabel lblToggle = new JLabel();
/*  25 */   JComboBox cbBladeAngle = new JComboBox();
/*  26 */   JLabel lblBladeAngle = new JLabel();
/*     */ 
/*     */   
/*     */   public ArrowSettingsDialog(Dialog p0, String p1, boolean p2) {
/*  30 */     super(p0, p1, p2);
/*     */     try {
/*  32 */       jbInit();
/*     */     
/*     */     }
/*  35 */     catch (Exception e) {
/*  36 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrowSettingsDialog(Frame p0, String p1, boolean p2) {
/*  43 */     super(p0, p1, p2);
/*     */     try {
/*  45 */       jbInit();
/*     */     
/*     */     }
/*  48 */     catch (Exception e) {
/*  49 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void populateLists() {
/*  57 */     this.cbArrowLength.addItem(new Integer(15));
/*  58 */     this.cbArrowLength.addItem(new Integer(20));
/*  59 */     this.cbArrowLength.addItem(new Integer(25));
/*  60 */     this.cbArrowLength.addItem(new Integer(30));
/*  61 */     this.cbArrowLength.addItem(new Integer(35));
/*  62 */     this.cbArrowLength.addItem(new Integer(40));
/*  63 */     this.cbArrowLength.addItem(new Integer(45));
/*  64 */     this.cbArrowLength.addItem(new Integer(60));
/*  65 */     this.cbArrowLength.setSelectedItem(new Integer(Settings.getLightArrowLength()));
/*     */ 
/*     */     
/*  68 */     this.cbBladeLength.addItem(new Integer(6));
/*  69 */     this.cbBladeLength.addItem(new Integer(9));
/*  70 */     this.cbBladeLength.addItem(new Integer(12));
/*  71 */     this.cbBladeLength.addItem(new Integer(15));
/*  72 */     this.cbBladeLength.addItem(new Integer(20));
/*  73 */     this.cbBladeLength.setSelectedItem(new Integer(Settings.getArrowBladeLength()));
/*     */ 
/*     */     
/*  76 */     this.cbBladeAngle.addItem(new Integer(15));
/*  77 */     this.cbBladeAngle.addItem(new Integer(30));
/*  78 */     this.cbBladeAngle.addItem(new Integer(45));
/*  79 */     this.cbBladeAngle.addItem(new Integer(60));
/*  80 */     this.cbBladeAngle.addItem(new Integer(75));
/*  81 */     int bladeAngle = (int)Math.round(Math.toDegrees(Settings.getArrowBladeAngle()));
/*  82 */     this.cbBladeAngle.setSelectedItem(new Integer(bladeAngle));
/*     */     
/*  84 */     this.panArrowColor.setBackground(Settings.getLightArrowColor());
/*  85 */     this.panSelectedArrowColor.setBackground(Settings.getSelectedLightArrowColor());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  91 */     populateLists();
/*  92 */     this.lblArrowLength.setText("Arrow Length");
/*  93 */     getContentPane().setLayout(this.gridBagLayout1);
/*  94 */     this.lblBladeLength.setText("Blade Length");
/*  95 */     this.lblArrowColor.setText("Arrow Color");
/*  96 */     this.lblSelectedArrowColor.setText("Arrow Color when Selected");
/*  97 */     this.panArrowColor.setBorder(BorderFactory.createRaisedBevelBorder());
/*  98 */     this.panArrowColor.setMaximumSize(new Dimension(80, 20));
/*  99 */     this.panArrowColor.setMinimumSize(new Dimension(80, 20));
/* 100 */     this.panArrowColor.setPreferredSize(new Dimension(80, 20));
/* 101 */     this.panArrowColor.addMouseListener(new ArrowSettingsDialog_panArrowColor_mouseAdapter(this));
/* 102 */     this.cbArrowLength.setMinimumSize(new Dimension(60, 20));
/* 103 */     this.cbArrowLength.setPreferredSize(new Dimension(60, 20));
/* 104 */     this.cbBladeLength.setMinimumSize(new Dimension(60, 20));
/* 105 */     this.cbBladeLength.setPreferredSize(new Dimension(60, 20));
/* 106 */     this.btnOk.setText("OK");
/* 107 */     this.btnOk.addActionListener(new ArrowSettingsDialog_btnOk_actionAdapter(this));
/* 108 */     this.panSelectedArrowColor.setBorder(BorderFactory.createRaisedBevelBorder());
/* 109 */     this.panSelectedArrowColor.setMaximumSize(new Dimension(80, 20));
/* 110 */     this.panSelectedArrowColor.setMinimumSize(new Dimension(80, 20));
/* 111 */     this.panSelectedArrowColor.setPreferredSize(new Dimension(80, 20));
/* 112 */     this.panSelectedArrowColor.addMouseListener(new ArrowSettingsDialog_panSelectedArrowColor_mouseAdapter(this));
/* 113 */     this.drawLightArrowsToggleButton.setMaximumSize(new Dimension(60, 60));
/* 114 */     this.drawLightArrowsToggleButton.setMinimumSize(new Dimension(60, 60));
/* 115 */     this.drawLightArrowsToggleButton.setPreferredSize(new Dimension(60, 60));
/* 116 */     this.drawLightArrowsToggleButton.setText("");
/* 117 */     this.lblToggle.setText("Toggle On/Off");
/* 118 */     this.cbBladeAngle.setMinimumSize(new Dimension(60, 20));
/* 119 */     this.cbBladeAngle.setPreferredSize(new Dimension(60, 20));
/* 120 */     this.lblBladeAngle.setText("Blade Angle");
/* 121 */     setTitle("Arrow Settings Dialog");
/* 122 */     getContentPane().add(this.lblArrowLength, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 123 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 124 */     getContentPane().add(this.lblBladeLength, new GridBagConstraints(0, 2, 2, 1, 0.0D, 0.0D, 
/* 125 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 126 */     getContentPane().add(this.lblArrowColor, new GridBagConstraints(0, 4, 1, 1, 0.0D, 0.0D, 
/* 127 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 128 */     getContentPane().add(this.lblSelectedArrowColor, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.0D, 
/* 129 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 130 */     getContentPane().add(this.cbArrowLength, new GridBagConstraints(3, 1, 1, 1, 0.0D, 0.0D, 
/* 131 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 132 */     getContentPane().add(this.cbBladeLength, new GridBagConstraints(3, 2, 1, 1, 0.0D, 0.0D, 
/* 133 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 134 */     getContentPane().add(this.panArrowColor, new GridBagConstraints(3, 4, 1, 1, 0.0D, 0.0D, 
/* 135 */           17, 2, new Insets(0, 5, 5, 0), 0, 0));
/* 136 */     getContentPane().add(this.panSelectedArrowColor, new GridBagConstraints(3, 5, 1, 1, 0.0D, 0.0D, 
/* 137 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 138 */     getContentPane().add((Component)this.drawLightArrowsToggleButton, new GridBagConstraints(3, 0, 2, 1, 0.0D, 0.0D, 
/* 139 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 140 */     getContentPane().add(this.btnOk, new GridBagConstraints(5, 0, 1, 1, 0.5D, 0.0D, 
/* 141 */           12, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 142 */     getContentPane().add(this.lblToggle, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 143 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 144 */     getContentPane().add(this.cbBladeAngle, new GridBagConstraints(3, 3, 1, 1, 0.0D, 0.0D, 
/* 145 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 146 */     getContentPane().add(this.lblBladeAngle, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/* 147 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 148 */     this.cbArrowLength.addActionListener(new ArrowSettingsDialog_cbArrowLength_actionAdapter(this));
/* 149 */     this.cbBladeLength.addActionListener(new ArrowSettingsDialog_cbBladeLength_actionAdapter(this));
/* 150 */     this.cbBladeAngle.addActionListener(new ArrowSettingsDialog_cbBladeAngle_actionAdapter(this));
/*     */   }
/*     */   
/*     */   void btnFootFillNull_actionPerformed(ActionEvent e) {
/* 154 */     this.panArrowColor.setBackground((Color)null);
/* 155 */     Settings.setFootstepFillColor(null);
/* 156 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void panArrowColor_mouseClicked(MouseEvent e) {
/* 161 */     String title = "Arrow Color";
/* 162 */     Color c = JColorChooser.showDialog(this, title, Settings.getLightArrowColor());
/* 163 */     if (c == null)
/* 164 */       return;  if (c.equals(Settings.getLightArrowColor()))
/* 165 */       return;  Settings.setLightArrowColor(c);
/* 166 */     this.panArrowColor.setBackground(c);
/* 167 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 172 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void panSelectedArrowColor_mouseClicked(MouseEvent e) {
/* 177 */     String title = "Selected Arrow Color";
/* 178 */     Color c = JColorChooser.showDialog(this, title, 
/* 179 */         Settings.getSelectedLightArrowColor());
/* 180 */     if (c == null)
/* 181 */       return;  if (c.equals(Settings.getSelectedLightArrowColor()))
/* 182 */       return;  Settings.setSelectedLightArrowColor(c);
/* 183 */     this.panSelectedArrowColor.setBackground(c);
/* 184 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void btnFootSelFillNull_actionPerformed(ActionEvent e) {
/* 188 */     this.panSelectedArrowColor.setBackground((Color)null);
/* 189 */     Settings.setSelectedFootstepFillColor(null);
/* 190 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void cbArrowLength_actionPerformed(ActionEvent e) {
/* 195 */     Settings.setLightArrowLength(((Integer)this.cbArrowLength.getSelectedItem()).intValue());
/* 196 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void cbBladeLength_actionPerformed(ActionEvent e) {
/* 200 */     Settings.setLightArrowBladeLength(((Integer)this.cbBladeLength.getSelectedItem()).intValue());
/* 201 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void cbBladeAngle_actionPerformed(ActionEvent e) {
/* 205 */     Settings.setArrowBladeAngle(Math.toRadians(((Integer)this.cbBladeAngle.getSelectedItem()).intValue()));
/* 206 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\ArrowSettingsDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */