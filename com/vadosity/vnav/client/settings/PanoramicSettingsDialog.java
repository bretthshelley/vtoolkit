/*     */ package com.vadosity.vnav.client.settings;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class PanoramicSettingsDialog extends JDialog implements SettingsChangeListener {
/*  13 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  14 */   JLabel lblFlashLen = new JLabel();
/*  15 */   JLabel lblFillColor = new JLabel();
/*  16 */   JLabel lblOutlineColor = new JLabel();
/*  17 */   JLabel lblSelectedFill = new JLabel();
/*  18 */   JLabel lblSelectedOutline = new JLabel();
/*  19 */   JComboBox cbFlashLen = new JComboBox();
/*  20 */   JPanel panFlashFill = new JPanel();
/*  21 */   JButton btnFlashFillNull = new JButton();
/*  22 */   BorderLayout borderLayout3 = new BorderLayout();
/*  23 */   JPanel panFlashOut = new JPanel();
/*  24 */   JButton btnOk = new JButton();
/*  25 */   JPanel panFlashSelFill = new JPanel();
/*  26 */   JButton btnFlashSelFillNull = new JButton();
/*  27 */   JPanel panFlashSelOut = new JPanel();
/*  28 */   BorderLayout borderLayout1 = new BorderLayout();
/*  29 */   JLabel lblToggle = new JLabel();
/*  30 */   PanoramicToggleButton panoramicToggleButton = new PanoramicToggleButton();
/*  31 */   JComboBox cbAlpha = new JComboBox();
/*  32 */   JLabel lblAlpha = new JLabel();
/*     */ 
/*     */   
/*     */   public PanoramicSettingsDialog(Dialog p0, String p1, boolean p2) {
/*  36 */     super(p0, p1, p2);
/*     */     try {
/*  38 */       jbInit();
/*  39 */       Global.addSettingsChangeListener(this);
/*     */     }
/*  41 */     catch (Exception e) {
/*  42 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PanoramicSettingsDialog(Frame p0, String p1, boolean p2) {
/*  49 */     super(p0, p1, p2);
/*     */     try {
/*  51 */       jbInit();
/*  52 */       Global.addSettingsChangeListener(this);
/*     */     }
/*  54 */     catch (Exception e) {
/*  55 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/*  62 */     this.panFlashFill.setBackground(Settings.getFlashFillColor());
/*  63 */     this.panFlashOut.setBackground(Settings.getFlashOutlineColor());
/*  64 */     this.panFlashSelFill.setBackground(Settings.getSelectedFlashFillColor());
/*  65 */     this.panFlashSelOut.setBackground(Settings.getSelectedFlashOutlineColor());
/*  66 */     this.panFlashFill.updateUI();
/*  67 */     this.panFlashSelFill.updateUI();
/*  68 */     this.panFlashOut.updateUI();
/*  69 */     this.panFlashSelOut.updateUI();
/*  70 */     setSize(new Dimension(getWidth() + 1, getHeight()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void populateLists() {
/*  76 */     this.cbFlashLen.addItem(new Integer(5));
/*  77 */     this.cbFlashLen.addItem(new Integer(10));
/*  78 */     this.cbFlashLen.addItem(new Integer(15));
/*  79 */     this.cbFlashLen.addItem(new Integer(20));
/*  80 */     this.cbFlashLen.addItem(new Integer(25));
/*  81 */     this.cbFlashLen.addItem(new Integer(30));
/*  82 */     this.cbFlashLen.addItem(new Integer(35));
/*  83 */     this.cbFlashLen.addItem(new Integer(40));
/*  84 */     this.cbFlashLen.addItem(new Integer(45));
/*  85 */     this.cbFlashLen.addItem(new Integer(50));
/*  86 */     this.cbFlashLen.addItem(new Integer(60));
/*  87 */     this.cbFlashLen.setSelectedItem(new Integer(Settings.getFlashLength()));
/*     */     
/*  89 */     this.cbAlpha.addItem(new Alpha(25));
/*  90 */     this.cbAlpha.addItem(new Alpha(50));
/*  91 */     this.cbAlpha.addItem(new Alpha(75));
/*  92 */     this.cbAlpha.addItem(new Alpha(100));
/*  93 */     this.cbAlpha.addItem(new Alpha(125));
/*  94 */     this.cbAlpha.addItem(new Alpha(150));
/*  95 */     this.cbAlpha.addItem(new Alpha(175));
/*  96 */     this.cbAlpha.addItem(new Alpha(200));
/*  97 */     this.cbAlpha.addItem(new Alpha(225));
/*  98 */     this.cbAlpha.addItem(new Alpha(255));
/*  99 */     this.cbAlpha.setSelectedItem(new Alpha(Settings.getLightAlpha()));
/*     */ 
/*     */     
/* 102 */     this.panFlashFill.setBackground(Settings.getFlashFillColor());
/* 103 */     this.panFlashOut.setBackground(Settings.getFlashOutlineColor());
/* 104 */     this.panFlashSelFill.setBackground(Settings.getSelectedFlashFillColor());
/* 105 */     this.panFlashSelOut.setBackground(Settings.getSelectedFlashOutlineColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 112 */     populateLists();
/* 113 */     getContentPane().setLayout(this.gridBagLayout1);
/* 114 */     this.lblFlashLen.setText("Flash Length");
/* 115 */     this.lblFillColor.setText("Fill Color");
/* 116 */     this.lblOutlineColor.setText("Outline Color");
/* 117 */     this.lblSelectedFill.setText("Fill Color when Selected");
/* 118 */     this.lblSelectedOutline.setText("Outline Color when Selected");
/* 119 */     this.panFlashFill.setBorder(BorderFactory.createRaisedBevelBorder());
/* 120 */     this.panFlashFill.setMaximumSize(new Dimension(80, 20));
/* 121 */     this.panFlashFill.setMinimumSize(new Dimension(80, 20));
/* 122 */     this.panFlashFill.setPreferredSize(new Dimension(80, 20));
/* 123 */     this.panFlashFill.addMouseListener(new PanoramicSettingsDialog_panFlashFill_mouseAdapter(this));
/* 124 */     this.cbFlashLen.setMinimumSize(new Dimension(60, 20));
/* 125 */     this.cbFlashLen.setPreferredSize(new Dimension(60, 20));
/* 126 */     this.cbFlashLen.setMaximumRowCount(12);
/* 127 */     this.btnFlashFillNull.setMaximumSize(new Dimension(20, 20));
/* 128 */     this.btnFlashFillNull.setMinimumSize(new Dimension(20, 20));
/* 129 */     this.btnFlashFillNull.setPreferredSize(new Dimension(20, 20));
/* 130 */     this.btnFlashFillNull.setMargin(new Insets(2, 4, 2, 4));
/* 131 */     this.btnFlashFillNull.setText("X");
/* 132 */     this.btnFlashFillNull.addActionListener(new PanoramicSettingsDialog_btnFlashFillNull_actionAdapter(this));
/* 133 */     this.panFlashOut.setBorder(BorderFactory.createRaisedBevelBorder());
/* 134 */     this.panFlashOut.setMaximumSize(new Dimension(80, 20));
/* 135 */     this.panFlashOut.setMinimumSize(new Dimension(80, 20));
/* 136 */     this.panFlashOut.setPreferredSize(new Dimension(80, 20));
/* 137 */     this.panFlashOut.addMouseListener(new PanoramicSettingsDialog_panFlashOut_mouseAdapter(this));
/* 138 */     this.panFlashOut.setLayout(this.borderLayout3);
/* 139 */     this.btnOk.setText("OK");
/* 140 */     this.btnOk.addActionListener(new PanoramicSettingsDialog_btnOk_actionAdapter(this));
/* 141 */     this.panFlashSelFill.setBorder(BorderFactory.createRaisedBevelBorder());
/* 142 */     this.panFlashSelFill.setMaximumSize(new Dimension(80, 20));
/* 143 */     this.panFlashSelFill.setMinimumSize(new Dimension(80, 20));
/* 144 */     this.panFlashSelFill.setPreferredSize(new Dimension(80, 20));
/* 145 */     this.panFlashSelFill.addMouseListener(new PanoramicSettingsDialog_panFlashSelFill_mouseAdapter(this));
/* 146 */     this.btnFlashSelFillNull.setMaximumSize(new Dimension(20, 20));
/* 147 */     this.btnFlashSelFillNull.setMinimumSize(new Dimension(20, 20));
/* 148 */     this.btnFlashSelFillNull.setPreferredSize(new Dimension(20, 20));
/* 149 */     this.btnFlashSelFillNull.setHorizontalAlignment(0);
/* 150 */     this.btnFlashSelFillNull.setMargin(new Insets(4, 4, 4, 4));
/* 151 */     this.btnFlashSelFillNull.setText("X");
/* 152 */     this.btnFlashSelFillNull.addActionListener(new PanoramicSettingsDialog_btnFlashSelFillNull_actionAdapter(this));
/* 153 */     this.panFlashSelOut.setBorder(BorderFactory.createRaisedBevelBorder());
/* 154 */     this.panFlashSelOut.setMaximumSize(new Dimension(60, 20));
/* 155 */     this.panFlashSelOut.setMinimumSize(new Dimension(80, 20));
/* 156 */     this.panFlashSelOut.setPreferredSize(new Dimension(80, 20));
/* 157 */     this.panFlashSelOut.addMouseListener(new PanoramicSettingsDialog_panFlashSelOut_mouseAdapter(this));
/* 158 */     this.panFlashSelOut.setLayout(this.borderLayout1);
/* 159 */     this.lblToggle.setText("Toggle On/Off");
/* 160 */     this.panoramicToggleButton.setMaximumSize(new Dimension(50, 50));
/* 161 */     this.panoramicToggleButton.setMinimumSize(new Dimension(50, 50));
/* 162 */     this.panoramicToggleButton.setPreferredSize(new Dimension(50, 50));
/* 163 */     this.panoramicToggleButton.setText("");
/* 164 */     this.cbAlpha.setMinimumSize(new Dimension(80, 20));
/* 165 */     this.cbAlpha.setPreferredSize(new Dimension(80, 20));
/* 166 */     this.cbAlpha.setMaximumRowCount(12);
/* 167 */     this.lblAlpha.setText("Transparency");
/* 168 */     setTitle("Panoramic Settings Dialog");
/* 169 */     getContentPane().add(this.lblFlashLen, new GridBagConstraints(0, 2, 2, 1, 0.0D, 0.0D, 
/* 170 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 171 */     getContentPane().add(this.lblFillColor, new GridBagConstraints(0, 3, 3, 1, 0.0D, 0.0D, 
/* 172 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 173 */     getContentPane().add(this.lblOutlineColor, new GridBagConstraints(0, 4, 3, 1, 0.0D, 0.0D, 
/* 174 */           17, 0, new Insets(5, 10, 0, 0), 0, 0));
/* 175 */     getContentPane().add(this.lblSelectedFill, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.0D, 
/* 176 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 177 */     getContentPane().add(this.lblSelectedOutline, new GridBagConstraints(0, 6, 1, 1, 0.0D, 0.0D, 
/* 178 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 179 */     getContentPane().add(this.cbFlashLen, new GridBagConstraints(3, 2, 1, 1, 0.0D, 0.0D, 
/* 180 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 181 */     getContentPane().add(this.panFlashFill, new GridBagConstraints(3, 3, 1, 1, 0.0D, 0.0D, 
/* 182 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 183 */     getContentPane().add(this.panFlashOut, new GridBagConstraints(3, 4, 1, 1, 0.0D, 0.0D, 
/* 184 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 185 */     getContentPane().add(this.panFlashSelFill, new GridBagConstraints(3, 5, 1, 1, 0.0D, 0.0D, 
/* 186 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 187 */     getContentPane().add(this.panFlashSelOut, new GridBagConstraints(3, 6, 1, 1, 0.0D, 0.0D, 
/* 188 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 189 */     getContentPane().add(this.btnFlashFillNull, new GridBagConstraints(4, 3, 1, 1, 0.0D, 0.0D, 
/* 190 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 191 */     getContentPane().add(this.btnFlashSelFillNull, new GridBagConstraints(4, 5, 1, 1, 0.0D, 0.0D, 
/* 192 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 193 */     getContentPane().add(this.lblToggle, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 194 */           17, 0, new Insets(5, 10, 5, 10), 0, 0));
/* 195 */     getContentPane().add((Component)this.panoramicToggleButton, new GridBagConstraints(3, 0, 1, 1, 0.0D, 0.0D, 
/* 196 */           17, 0, new Insets(5, 5, 5, 5), 47, 28));
/* 197 */     getContentPane().add(this.btnOk, new GridBagConstraints(5, 0, 1, 1, 0.5D, 0.0D, 
/* 198 */           12, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 199 */     getContentPane().add(this.cbAlpha, new GridBagConstraints(3, 7, 1, 1, 0.0D, 0.0D, 
/* 200 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 201 */     getContentPane().add(this.lblAlpha, new GridBagConstraints(0, 7, 1, 1, 0.0D, 0.0D, 
/* 202 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 203 */     this.cbFlashLen.addActionListener(new PanoramicSettingsDialog_cbFlashLen_actionAdapter(this));
/* 204 */     this.cbAlpha.addActionListener(new PanoramicSettingsDialog_cbAlpha_actionAdapter(this));
/*     */   }
/*     */   
/*     */   void btnFlashFillNull_actionPerformed(ActionEvent e) {
/* 208 */     this.panFlashFill.setBackground((Color)null);
/* 209 */     Settings.setFlashFillColor(null);
/* 210 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void panFlashFill_mouseClicked(MouseEvent e) {
/* 215 */     String title = "Fill Color";
/* 216 */     Color c = JColorChooser.showDialog(this, title, Settings.getFlashFillColor());
/* 217 */     if (c == null)
/*     */       return; 
/* 219 */     Color newColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), Settings.getLightAlpha());
/* 220 */     Settings.setFlashFillColor(newColor);
/* 221 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 226 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void panFlashOut_mouseClicked(MouseEvent e) {
/* 231 */     String title = "Outline Color";
/* 232 */     Color c = JColorChooser.showDialog(this, title, Settings.getFlashOutlineColor());
/* 233 */     if (c == null)
/* 234 */       return;  if (c.equals(Settings.getFlashOutlineColor()))
/* 235 */       return;  Settings.setFlashOutlineColor(c);
/* 236 */     this.panFlashOut.setBackground(c);
/* 237 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void panFlashSelFill_mouseClicked(MouseEvent e) {
/* 243 */     String title = "Fill Color when Selected";
/* 244 */     Color c = JColorChooser.showDialog(this, title, Settings.getSelectedFlashFillColor());
/* 245 */     if (c == null)
/*     */       return; 
/* 247 */     Color newColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), Settings.getLightAlpha());
/* 248 */     Settings.setSelectedFlashFillColor(newColor);
/* 249 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void panFlashSelOut_mouseClicked(MouseEvent e) {
/* 255 */     String title = "Outline Color when Selected";
/* 256 */     Color c = JColorChooser.showDialog(this, title, Settings.getSelectedFlashOutlineColor());
/* 257 */     if (c == null)
/* 258 */       return;  if (c.equals(Settings.getSelectedFlashOutlineColor()))
/* 259 */       return;  Settings.setSelectedFlashOutlineColor(c);
/* 260 */     this.panFlashSelOut.setBackground(c);
/* 261 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnFlashSelFillNull_actionPerformed(ActionEvent e) {
/* 266 */     this.panFlashSelFill.setBackground((Color)null);
/* 267 */     Settings.setSelectedFlashFillColor(null);
/* 268 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 274 */     Global.removeSettingsChangeListener(this);
/* 275 */     super.dispose();
/*     */   }
/*     */   
/*     */   void cbFlashLen_actionPerformed(ActionEvent e) {
/* 279 */     Settings.setFlashLength(((Integer)this.cbFlashLen.getSelectedItem()).intValue());
/* 280 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void cbAlpha_actionPerformed(ActionEvent e) {
/* 285 */     Alpha alpha = (Alpha)this.cbAlpha.getSelectedItem();
/* 286 */     Settings.setLightAlpha(alpha.getValue());
/*     */     
/* 288 */     Color flashFill = Settings.getFlashFillColor();
/* 289 */     if (flashFill != null) {
/*     */       
/* 291 */       Color newFlashFill = new Color(flashFill.getRed(), flashFill.getGreen(), flashFill.getBlue(), alpha.getValue());
/* 292 */       Settings.setFlashFillColor(newFlashFill);
/*     */     } 
/*     */     
/* 295 */     Color selFill = Settings.getSelectedFlashFillColor();
/* 296 */     if (selFill != null) {
/*     */       
/* 298 */       Color newSelFill = new Color(selFill.getRed(), selFill.getGreen(), selFill.getBlue(), alpha.getValue());
/* 299 */       Settings.setSelectedFlashFillColor(newSelFill);
/*     */     } 
/*     */     
/* 302 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\PanoramicSettingsDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */