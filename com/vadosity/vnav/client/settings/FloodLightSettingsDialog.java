/*     */ package com.vadosity.vnav.client.settings;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class FloodLightSettingsDialog extends JDialog implements SettingsChangeListener {
/*  14 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  15 */   FloodLightToggleButton floodLightToggleButton = new FloodLightToggleButton();
/*  16 */   JLabel lblToggle = new JLabel();
/*  17 */   JButton btnOk = new JButton();
/*  18 */   JLabel lblFillColor = new JLabel();
/*  19 */   JPanel panelFill = new JPanel();
/*  20 */   JLabel lblOutline = new JLabel();
/*  21 */   JPanel panelOutline = new JPanel();
/*  22 */   JLabel lblAlpha = new JLabel();
/*  23 */   JComboBox cbAlpha = new JComboBox();
/*  24 */   JButton btnDefaults = new JButton();
/*  25 */   JLabel lblFloodLightLength = new JLabel();
/*  26 */   JComboBox cbLength = new JComboBox();
/*     */ 
/*     */ 
/*     */   
/*     */   public FloodLightSettingsDialog(Dialog p0, String p1, boolean p2) {
/*  31 */     super(p0, p1, p2);
/*     */     
/*     */     try {
/*  34 */       jbInit();
/*  35 */       Global.addSettingsChangeListener(this);
/*     */     }
/*  37 */     catch (Exception e) {
/*     */       
/*  39 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FloodLightSettingsDialog(Frame p0, String p1, boolean p2) {
/*  46 */     super(p0, p1, p2);
/*     */     
/*     */     try {
/*  49 */       jbInit();
/*  50 */       Global.addSettingsChangeListener(this);
/*     */     }
/*  52 */     catch (Exception e) {
/*     */       
/*  54 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FloodLightSettingsDialog() {
/*     */     try {
/*  62 */       jbInit();
/*  63 */       Global.addSettingsChangeListener(this);
/*     */     }
/*  65 */     catch (Exception e) {
/*  66 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/*  72 */     this.panelFill.setBackground(Settings.getFloodLightFillColor());
/*  73 */     this.panelOutline.setBackground(Settings.getFloodLightOutlineColor());
/*  74 */     setSize(new Dimension(getWidth() + 1, getHeight()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  79 */     Global.removeSettingsChangeListener(this);
/*  80 */     super.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void populateElements() {
/*  86 */     this.cbAlpha.addItem(new Alpha(25));
/*  87 */     this.cbAlpha.addItem(new Alpha(50));
/*  88 */     this.cbAlpha.addItem(new Alpha(75));
/*  89 */     this.cbAlpha.addItem(new Alpha(100));
/*  90 */     this.cbAlpha.addItem(new Alpha(125));
/*  91 */     this.cbAlpha.addItem(new Alpha(150));
/*  92 */     this.cbAlpha.addItem(new Alpha(175));
/*  93 */     this.cbAlpha.addItem(new Alpha(200));
/*  94 */     this.cbAlpha.addItem(new Alpha(225));
/*  95 */     this.cbAlpha.addItem(new Alpha(255));
/*  96 */     this.cbAlpha.setSelectedItem(new Alpha(Settings.getLightAlpha()));
/*     */     
/*  98 */     this.cbLength.addItem(new Integer(50));
/*  99 */     this.cbLength.addItem(new Integer(100));
/* 100 */     this.cbLength.addItem(new Integer(150));
/* 101 */     this.cbLength.addItem(new Integer(200));
/* 102 */     this.cbLength.addItem(new Integer(400));
/* 103 */     this.cbLength.addItem(new Integer(800));
/* 104 */     this.cbLength.addItem(new Integer(1200));
/* 105 */     this.cbLength.addItem(new Integer(2000));
/* 106 */     this.cbLength.setSelectedItem(new Integer(Settings.getFloodLightLength()));
/*     */     
/* 108 */     this.panelFill.setBackground(Settings.getFloodLightFillColor());
/* 109 */     this.panelOutline.setBackground(Settings.getFloodLightOutlineColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 116 */     populateElements();
/* 117 */     this.floodLightToggleButton.setMaximumSize(new Dimension(80, 60));
/* 118 */     this.floodLightToggleButton.setMinimumSize(new Dimension(80, 60));
/* 119 */     this.floodLightToggleButton.setPreferredSize(new Dimension(80, 60));
/* 120 */     getContentPane().setLayout(this.gridBagLayout1);
/* 121 */     this.lblToggle.setText("Toggle On/Off");
/* 122 */     this.btnOk.setText("OK");
/* 123 */     this.btnOk.addActionListener(new FloodLightSettingsDialog_btnOk_actionAdapter(this));
/* 124 */     this.lblFillColor.setText("Fill Color");
/* 125 */     this.panelFill.setBorder(BorderFactory.createRaisedBevelBorder());
/* 126 */     this.panelFill.setMinimumSize(new Dimension(20, 20));
/* 127 */     this.panelFill.setPreferredSize(new Dimension(20, 20));
/* 128 */     this.panelFill.addMouseListener(new FloodLightSettingsDialog_panelFill_mouseAdapter(this));
/* 129 */     this.lblOutline.setText("Outline");
/* 130 */     this.panelOutline.setBorder(BorderFactory.createRaisedBevelBorder());
/* 131 */     this.panelOutline.setMinimumSize(new Dimension(20, 20));
/* 132 */     this.panelOutline.setPreferredSize(new Dimension(20, 20));
/* 133 */     this.panelOutline.addMouseListener(new FloodLightSettingsDialog_panelOutline_mouseAdapter(this));
/* 134 */     this.lblAlpha.setText("Transparency");
/* 135 */     this.cbAlpha.setMinimumSize(new Dimension(80, 20));
/* 136 */     this.cbAlpha.setPreferredSize(new Dimension(80, 20));
/* 137 */     this.btnDefaults.setText("Restore Defaults");
/* 138 */     this.btnDefaults.addActionListener(new FloodLightSettingsDialog_btnDefaults_actionAdapter(this));
/* 139 */     this.lblFloodLightLength.setToolTipText("");
/* 140 */     this.lblFloodLightLength.setText("Length");
/* 141 */     this.cbLength.setMinimumSize(new Dimension(80, 20));
/* 142 */     this.cbLength.setPreferredSize(new Dimension(80, 20));
/* 143 */     setTitle("Floodlight Settings Dialog");
/* 144 */     getContentPane().add((Component)this.floodLightToggleButton, new GridBagConstraints(1, 0, 2, 1, 0.0D, 0.0D, 
/* 145 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 146 */     getContentPane().add(this.lblToggle, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 147 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 148 */     getContentPane().add(this.btnOk, new GridBagConstraints(3, 0, 1, 1, 1.0D, 0.0D, 
/* 149 */           12, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 150 */     getContentPane().add(this.lblFillColor, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 151 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 152 */     getContentPane().add(this.panelFill, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/* 153 */           17, 2, new Insets(5, 5, 5, 5), 0, 0));
/* 154 */     getContentPane().add(this.lblOutline, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 155 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 156 */     getContentPane().add(this.panelOutline, new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 
/* 157 */           17, 2, new Insets(5, 5, 5, 5), 0, 0));
/* 158 */     getContentPane().add(this.lblAlpha, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/* 159 */           17, 0, new Insets(5, 10, 0, 5), 0, 0));
/* 160 */     getContentPane().add(this.cbAlpha, new GridBagConstraints(2, 3, 1, 1, 0.0D, 0.0D, 
/* 161 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 162 */     getContentPane().add(this.btnDefaults, new GridBagConstraints(0, 5, 4, 1, 0.0D, 0.0D, 
/* 163 */           10, 0, new Insets(15, 5, 5, 5), 0, 0));
/* 164 */     getContentPane().add(this.lblFloodLightLength, new GridBagConstraints(0, 4, 1, 1, 0.0D, 0.0D, 
/* 165 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 166 */     getContentPane().add(this.cbLength, new GridBagConstraints(2, 4, 1, 1, 0.0D, 0.0D, 
/* 167 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 168 */     this.cbAlpha.addActionListener(new FloodLightSettingsDialog_cbAlpha_actionAdapter(this));
/* 169 */     this.cbLength.addActionListener(new FloodLightSettingsDialog_cbLength_actionAdapter(this));
/*     */   }
/*     */ 
/*     */   
/*     */   void panelFill_mouseClicked(MouseEvent e) {
/* 174 */     String title = "Fill Color";
/* 175 */     Color c = JColorChooser.showDialog(this, title, Settings.getFloodLightFillColor());
/* 176 */     if (c == null)
/*     */       return; 
/* 178 */     Color newColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), Settings.getFloodLightAlpha());
/* 179 */     Settings.setFloodLightFillColor(newColor);
/* 180 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 184 */     dispose();
/*     */   }
/*     */   
/*     */   void panelOutline_mouseClicked(MouseEvent e) {
/* 188 */     String title = "Outline Color";
/* 189 */     Color c = JColorChooser.showDialog(this, title, Settings.getFloodLightOutlineColor());
/* 190 */     if (c == null)
/*     */       return; 
/* 192 */     Color newColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), Settings.getFloodLightAlpha());
/* 193 */     Settings.setFloodLightOutlineColor(newColor);
/* 194 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void btnDefaults_actionPerformed(ActionEvent e) {
/* 200 */     Settings.setFloodLightFillColor((new ViewSettings()).getFloodLightFillColor());
/* 201 */     Settings.setFloodLightOutlineColor((new ViewSettings()).getFloodLightOutlineColor());
/* 202 */     Settings.setFloodLightAlpha((new ViewSettings()).getFloodLightAlpha());
/* 203 */     Settings.setFloodLightLength((new ViewSettings()).getFloodLightLength());
/* 204 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void cbAlpha_actionPerformed(ActionEvent e) {
/* 209 */     Alpha alpha = (Alpha)this.cbAlpha.getSelectedItem();
/* 210 */     Settings.setFloodLightAlpha(alpha.getValue());
/*     */     
/* 212 */     Color floodFill = Settings.getFloodLightFillColor();
/* 213 */     if (floodFill != null) {
/*     */       
/* 215 */       Color newFloodFill = new Color(floodFill.getRed(), floodFill.getGreen(), floodFill.getBlue(), alpha.getValue());
/* 216 */       Settings.setFloodLightFillColor(newFloodFill);
/*     */     } 
/*     */     
/* 219 */     Color floodOutline = Settings.getFloodLightOutlineColor();
/* 220 */     if (floodOutline != null) {
/*     */       
/* 222 */       Color newFloodOutline = new Color(floodOutline.getRed(), floodOutline.getGreen(), floodOutline.getBlue(), alpha.getValue());
/* 223 */       Settings.setFloodLightOutlineColor(newFloodOutline);
/*     */     } 
/*     */     
/* 226 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void cbLength_actionPerformed(ActionEvent e) {
/* 231 */     Settings.setFloodLightLength(((Integer)this.cbLength.getSelectedItem()).intValue());
/* 232 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\FloodLightSettingsDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */