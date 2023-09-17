/*     */ package com.vadosity.vnav.client.settings;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class FlashSettingsDialog extends JDialog implements SettingsChangeListener {
/*  12 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  13 */   JLabel lblFlashAngle = new JLabel();
/*  14 */   JLabel lblFlashLen = new JLabel();
/*  15 */   JLabel lblFillColor = new JLabel();
/*  16 */   JLabel lblOutlineColor = new JLabel();
/*  17 */   JLabel lblSelectedFill = new JLabel();
/*  18 */   JLabel lblSelectedOutline = new JLabel();
/*  19 */   JComboBox cbFlashAngle = new JComboBox();
/*  20 */   JComboBox cbFlashLen = new JComboBox();
/*  21 */   JPanel panFlashFill = new JPanel();
/*  22 */   JButton btnFlashFillNull = new JButton();
/*  23 */   BorderLayout borderLayout3 = new BorderLayout();
/*  24 */   JPanel panFlashOut = new JPanel();
/*  25 */   JButton btnOk = new JButton();
/*  26 */   JPanel panFlashSelFill = new JPanel();
/*  27 */   JButton btnFlashSelFillNull = new JButton();
/*  28 */   JPanel panFlashSelOut = new JPanel();
/*  29 */   BorderLayout borderLayout1 = new BorderLayout();
/*  30 */   JLabel lblToggle = new JLabel();
/*  31 */   DrawAllFlashesSettingsButton drawAllFlashesSettingsButton = new DrawAllFlashesSettingsButton();
/*  32 */   JComboBox cbAlpha = new JComboBox();
/*  33 */   JLabel lblAlpha = new JLabel();
/*     */ 
/*     */   
/*     */   public FlashSettingsDialog(Dialog p0, String p1, boolean p2) {
/*  37 */     super(p0, p1, p2);
/*     */     try {
/*  39 */       jbInit();
/*  40 */       Global.addSettingsChangeListener(this);
/*     */     }
/*  42 */     catch (Exception e) {
/*  43 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FlashSettingsDialog(Frame p0, String p1, boolean p2) {
/*  50 */     super(p0, p1, p2);
/*     */     try {
/*  52 */       jbInit();
/*  53 */       Global.addSettingsChangeListener(this);
/*     */     }
/*  55 */     catch (Exception e) {
/*  56 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/*  63 */     this.panFlashFill.setBackground(Settings.getFlashFillColor());
/*  64 */     this.panFlashOut.setBackground(Settings.getFlashOutlineColor());
/*  65 */     this.panFlashSelFill.setBackground(Settings.getSelectedFlashFillColor());
/*  66 */     this.panFlashSelOut.setBackground(Settings.getSelectedFlashOutlineColor());
/*  67 */     this.panFlashFill.updateUI();
/*  68 */     this.panFlashSelFill.updateUI();
/*  69 */     this.panFlashOut.updateUI();
/*  70 */     this.panFlashSelOut.updateUI();
/*     */     
/*  72 */     setSize(new Dimension(getWidth() + 1, getHeight()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void populateLists() {
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
/*     */ 
/*     */     
/*  91 */     this.cbFlashAngle.addItem(new Integer(20));
/*  92 */     this.cbFlashAngle.addItem(new Integer(25));
/*  93 */     this.cbFlashAngle.addItem(new Integer(30));
/*  94 */     this.cbFlashAngle.addItem(new Integer(35));
/*  95 */     this.cbFlashAngle.addItem(new Integer(35));
/*  96 */     this.cbFlashAngle.addItem(new Integer(40));
/*  97 */     this.cbFlashAngle.addItem(new Integer(45));
/*  98 */     this.cbFlashAngle.addItem(new Integer(50));
/*  99 */     this.cbFlashAngle.addItem(new Integer(60));
/* 100 */     this.cbFlashAngle.setSelectedItem(new Integer(Settings.getFlashCoverageDegrees()));
/*     */     
/* 102 */     this.cbAlpha.addItem(new Alpha(25));
/* 103 */     this.cbAlpha.addItem(new Alpha(50));
/* 104 */     this.cbAlpha.addItem(new Alpha(75));
/* 105 */     this.cbAlpha.addItem(new Alpha(100));
/* 106 */     this.cbAlpha.addItem(new Alpha(125));
/* 107 */     this.cbAlpha.addItem(new Alpha(150));
/* 108 */     this.cbAlpha.addItem(new Alpha(175));
/* 109 */     this.cbAlpha.addItem(new Alpha(200));
/* 110 */     this.cbAlpha.addItem(new Alpha(225));
/* 111 */     this.cbAlpha.addItem(new Alpha(255));
/* 112 */     this.cbAlpha.setSelectedItem(new Alpha(Settings.getLightAlpha()));
/*     */     
/* 114 */     this.panFlashFill.setBackground(Settings.getFlashFillColor());
/* 115 */     this.panFlashOut.setBackground(Settings.getFlashOutlineColor());
/* 116 */     this.panFlashSelFill.setBackground(Settings.getSelectedFlashFillColor());
/* 117 */     this.panFlashSelOut.setBackground(Settings.getSelectedFlashOutlineColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 124 */     populateLists();
/* 125 */     this.lblFlashAngle.setText("Flash Angle");
/* 126 */     getContentPane().setLayout(this.gridBagLayout1);
/* 127 */     this.lblFlashLen.setText("Flash Length");
/* 128 */     this.lblFillColor.setText("Fill Color");
/* 129 */     this.lblOutlineColor.setText("Outline Color");
/* 130 */     this.lblSelectedFill.setText("Fill Color when Selected");
/* 131 */     this.lblSelectedOutline.setText("Outline Color when Selected");
/* 132 */     this.panFlashFill.setBorder(BorderFactory.createRaisedBevelBorder());
/* 133 */     this.panFlashFill.setMaximumSize(new Dimension(80, 20));
/* 134 */     this.panFlashFill.setMinimumSize(new Dimension(80, 20));
/* 135 */     this.panFlashFill.setPreferredSize(new Dimension(80, 20));
/* 136 */     this.panFlashFill.addMouseListener(new FlashSettingsDialog_panFlashFill_mouseAdapter(this));
/* 137 */     this.cbFlashAngle.setMinimumSize(new Dimension(60, 20));
/* 138 */     this.cbFlashAngle.setPreferredSize(new Dimension(60, 20));
/* 139 */     this.cbFlashAngle.setMaximumRowCount(12);
/* 140 */     this.cbFlashLen.setMinimumSize(new Dimension(60, 20));
/* 141 */     this.cbFlashLen.setPreferredSize(new Dimension(60, 20));
/* 142 */     this.cbFlashLen.setMaximumRowCount(12);
/* 143 */     this.btnFlashFillNull.setMaximumSize(new Dimension(20, 20));
/* 144 */     this.btnFlashFillNull.setMinimumSize(new Dimension(20, 20));
/* 145 */     this.btnFlashFillNull.setPreferredSize(new Dimension(20, 20));
/* 146 */     this.btnFlashFillNull.setMargin(new Insets(2, 4, 2, 4));
/* 147 */     this.btnFlashFillNull.setText("X");
/* 148 */     this.btnFlashFillNull.addActionListener(new FlashSettingsDialog_btnFlashFillNull_actionAdapter(this));
/* 149 */     this.panFlashOut.setBorder(BorderFactory.createRaisedBevelBorder());
/* 150 */     this.panFlashOut.setMaximumSize(new Dimension(80, 20));
/* 151 */     this.panFlashOut.setMinimumSize(new Dimension(80, 20));
/* 152 */     this.panFlashOut.setPreferredSize(new Dimension(80, 20));
/* 153 */     this.panFlashOut.addMouseListener(new FlashSettingsDialog_panFlashOut_mouseAdapter(this));
/* 154 */     this.panFlashOut.setLayout(this.borderLayout3);
/* 155 */     this.btnOk.setText("OK");
/* 156 */     this.btnOk.addActionListener(new FlashSettingsDialog_btnOk_actionAdapter(this));
/* 157 */     this.panFlashSelFill.setBorder(BorderFactory.createRaisedBevelBorder());
/* 158 */     this.panFlashSelFill.setMaximumSize(new Dimension(80, 20));
/* 159 */     this.panFlashSelFill.setMinimumSize(new Dimension(80, 20));
/* 160 */     this.panFlashSelFill.setPreferredSize(new Dimension(80, 20));
/* 161 */     this.panFlashSelFill.addMouseListener(new FlashSettingsDialog_panFlashSelFill_mouseAdapter(this));
/* 162 */     this.btnFlashSelFillNull.setMaximumSize(new Dimension(20, 20));
/* 163 */     this.btnFlashSelFillNull.setMinimumSize(new Dimension(20, 20));
/* 164 */     this.btnFlashSelFillNull.setPreferredSize(new Dimension(20, 20));
/* 165 */     this.btnFlashSelFillNull.setHorizontalAlignment(0);
/* 166 */     this.btnFlashSelFillNull.setMargin(new Insets(4, 4, 4, 4));
/* 167 */     this.btnFlashSelFillNull.setText("X");
/* 168 */     this.btnFlashSelFillNull.addActionListener(new FlashSettingsDialog_btnFlashSelFillNull_actionAdapter(this));
/* 169 */     this.panFlashSelOut.setBorder(BorderFactory.createRaisedBevelBorder());
/* 170 */     this.panFlashSelOut.setMaximumSize(new Dimension(60, 20));
/* 171 */     this.panFlashSelOut.setMinimumSize(new Dimension(80, 20));
/* 172 */     this.panFlashSelOut.setPreferredSize(new Dimension(80, 20));
/* 173 */     this.panFlashSelOut.addMouseListener(new FlashSettingsDialog_panFlashSelOut_mouseAdapter(this));
/* 174 */     this.panFlashSelOut.setLayout(this.borderLayout1);
/* 175 */     this.lblToggle.setText("Toggle On/Off");
/* 176 */     this.drawAllFlashesSettingsButton.setMaximumSize(new Dimension(30, 30));
/* 177 */     this.drawAllFlashesSettingsButton.setMinimumSize(new Dimension(30, 30));
/* 178 */     this.drawAllFlashesSettingsButton.setPreferredSize(new Dimension(30, 30));
/* 179 */     this.drawAllFlashesSettingsButton.setText("");
/* 180 */     this.cbAlpha.setMinimumSize(new Dimension(80, 20));
/* 181 */     this.cbAlpha.setPreferredSize(new Dimension(80, 20));
/* 182 */     this.cbAlpha.setMaximumRowCount(12);
/* 183 */     this.lblAlpha.setToolTipText("");
/* 184 */     this.lblAlpha.setText("Transparency");
/* 185 */     setTitle("Flash Settings Dialog");
/* 186 */     getContentPane().add(this.lblFlashAngle, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 187 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 188 */     getContentPane().add(this.lblFlashLen, new GridBagConstraints(0, 2, 2, 1, 0.0D, 0.0D, 
/* 189 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 190 */     getContentPane().add(this.lblFillColor, new GridBagConstraints(0, 3, 3, 1, 0.0D, 0.0D, 
/* 191 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 192 */     getContentPane().add(this.lblOutlineColor, new GridBagConstraints(0, 4, 3, 1, 0.0D, 0.0D, 
/* 193 */           17, 0, new Insets(5, 10, 0, 0), 0, 0));
/* 194 */     getContentPane().add(this.lblSelectedFill, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.0D, 
/* 195 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 196 */     getContentPane().add(this.lblSelectedOutline, new GridBagConstraints(0, 6, 1, 1, 0.0D, 0.0D, 
/* 197 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 198 */     getContentPane().add(this.cbFlashAngle, new GridBagConstraints(3, 1, 1, 1, 0.0D, 0.0D, 
/* 199 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 200 */     getContentPane().add(this.cbFlashLen, new GridBagConstraints(3, 2, 1, 1, 0.0D, 0.0D, 
/* 201 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 202 */     getContentPane().add(this.panFlashFill, new GridBagConstraints(3, 3, 1, 1, 0.0D, 0.0D, 
/* 203 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 204 */     getContentPane().add(this.panFlashOut, new GridBagConstraints(3, 4, 1, 1, 0.0D, 0.0D, 
/* 205 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 206 */     getContentPane().add(this.panFlashSelFill, new GridBagConstraints(3, 5, 1, 1, 0.0D, 0.0D, 
/* 207 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 208 */     getContentPane().add(this.panFlashSelOut, new GridBagConstraints(3, 6, 1, 1, 0.0D, 0.0D, 
/* 209 */           17, 2, new Insets(5, 5, 5, 0), 0, 0));
/* 210 */     getContentPane().add(this.btnFlashFillNull, new GridBagConstraints(4, 3, 1, 1, 0.0D, 0.0D, 
/* 211 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 212 */     getContentPane().add(this.btnFlashSelFillNull, new GridBagConstraints(4, 5, 1, 1, 0.0D, 0.0D, 
/* 213 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 214 */     getContentPane().add(this.lblToggle, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 215 */           17, 0, new Insets(5, 10, 5, 10), 0, 0));
/* 216 */     getContentPane().add((Component)this.drawAllFlashesSettingsButton, new GridBagConstraints(3, 0, 1, 1, 0.0D, 0.0D, 
/* 217 */           17, 0, new Insets(5, 5, 5, 5), 47, 28));
/* 218 */     getContentPane().add(this.btnOk, new GridBagConstraints(5, 0, 1, 1, 0.5D, 0.0D, 
/* 219 */           12, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 220 */     getContentPane().add(this.cbAlpha, new GridBagConstraints(3, 7, 1, 1, 0.0D, 0.0D, 
/* 221 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 222 */     getContentPane().add(this.lblAlpha, new GridBagConstraints(0, 7, 1, 1, 0.0D, 0.0D, 
/* 223 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 224 */     this.cbFlashAngle.addActionListener(new FlashSettingsDialog_cbFlashAngle_actionAdapter(this));
/* 225 */     this.cbFlashLen.addActionListener(new FlashSettingsDialog_cbFlashLen_actionAdapter(this));
/* 226 */     this.cbAlpha.addActionListener(new FlashSettingsDialog_cbAlpha_actionAdapter(this));
/*     */   }
/*     */   
/*     */   void btnFlashFillNull_actionPerformed(ActionEvent e) {
/* 230 */     this.panFlashFill.setBackground((Color)null);
/* 231 */     Settings.setFlashFillColor(null);
/* 232 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void panFlashFill_mouseClicked(MouseEvent e) {
/* 237 */     String title = "Fill Color";
/* 238 */     Color c = JColorChooser.showDialog(this, title, Settings.getFlashFillColor());
/* 239 */     if (c == null)
/*     */       return; 
/* 241 */     Color newColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), Settings.getLightAlpha());
/* 242 */     Settings.setFlashFillColor(newColor);
/* 243 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 248 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void panFlashOut_mouseClicked(MouseEvent e) {
/* 253 */     String title = "Outline Color";
/* 254 */     Color c = JColorChooser.showDialog(this, title, Settings.getFlashOutlineColor());
/* 255 */     if (c == null)
/* 256 */       return;  if (c.equals(Settings.getFlashOutlineColor()))
/* 257 */       return;  Settings.setFlashOutlineColor(c);
/* 258 */     this.panFlashOut.setBackground(c);
/* 259 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void panFlashSelFill_mouseClicked(MouseEvent e) {
/* 265 */     String title = "Fill Color when selected";
/* 266 */     Color c = JColorChooser.showDialog(this, title, Settings.getSelectedFlashFillColor());
/* 267 */     if (c == null)
/*     */       return; 
/* 269 */     Color newColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), Settings.getLightAlpha());
/* 270 */     Settings.setSelectedFlashFillColor(newColor);
/* 271 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void panFlashSelOut_mouseClicked(MouseEvent e) {
/* 277 */     String title = "Outline Color when selected";
/* 278 */     Color c = JColorChooser.showDialog(this, title, Settings.getSelectedFlashOutlineColor());
/* 279 */     if (c == null)
/* 280 */       return;  if (c.equals(Settings.getSelectedFlashOutlineColor()))
/* 281 */       return;  Settings.setSelectedFlashOutlineColor(c);
/* 282 */     this.panFlashSelOut.setBackground(c);
/* 283 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnFlashSelFillNull_actionPerformed(ActionEvent e) {
/* 288 */     this.panFlashSelFill.setBackground((Color)null);
/* 289 */     Settings.setSelectedFlashFillColor(null);
/* 290 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 296 */     Global.removeSettingsChangeListener(this);
/* 297 */     super.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void cbFlashAngle_actionPerformed(ActionEvent e) {
/* 302 */     Settings.setFlashCoverageDegrees(((Integer)this.cbFlashAngle.getSelectedItem()).intValue());
/* 303 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void cbFlashLen_actionPerformed(ActionEvent e) {
/* 307 */     Settings.setFlashLength(((Integer)this.cbFlashLen.getSelectedItem()).intValue());
/* 308 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void cbAlpha_actionPerformed(ActionEvent e) {
/* 313 */     Alpha alpha = (Alpha)this.cbAlpha.getSelectedItem();
/* 314 */     Settings.setLightAlpha(alpha.getValue());
/*     */     
/* 316 */     Color flashFill = Settings.getFlashFillColor();
/* 317 */     if (flashFill != null) {
/*     */       
/* 319 */       Color newFlashFill = new Color(flashFill.getRed(), flashFill.getGreen(), flashFill.getBlue(), alpha.getValue());
/* 320 */       Settings.setFlashFillColor(newFlashFill);
/*     */     } 
/*     */     
/* 323 */     Color selFill = Settings.getSelectedFlashFillColor();
/* 324 */     if (selFill != null) {
/*     */       
/* 326 */       Color newSelFill = new Color(selFill.getRed(), selFill.getGreen(), selFill.getBlue(), alpha.getValue());
/* 327 */       Settings.setSelectedFlashFillColor(newSelFill);
/*     */     } 
/* 329 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\FlashSettingsDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */