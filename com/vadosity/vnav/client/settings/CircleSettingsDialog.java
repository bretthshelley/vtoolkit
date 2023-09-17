/*     */ package com.vadosity.vnav.client.settings;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class CircleSettingsDialog extends JDialog {
/*  11 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  12 */   JLabel lblCircleDiameter = new JLabel();
/*  13 */   JLabel lblFillColor = new JLabel();
/*  14 */   JLabel lblOutlineColor = new JLabel();
/*  15 */   JLabel lblSelectedFill = new JLabel();
/*  16 */   JLabel lblSelectedOutline = new JLabel();
/*  17 */   JPanel panCircleFill = new JPanel();
/*  18 */   JButton btnFootOutNull = new JButton();
/*  19 */   BorderLayout borderLayout3 = new BorderLayout();
/*  20 */   JPanel panCircOut = new JPanel();
/*  21 */   JButton btnOk = new JButton();
/*  22 */   JPanel panCircSelFill = new JPanel();
/*  23 */   JButton btnCircSelFillNull = new JButton();
/*  24 */   JPanel panCircSelOut = new JPanel();
/*  25 */   BorderLayout borderLayout1 = new BorderLayout();
/*  26 */   JComboBox cbDiameter = new JComboBox();
/*  27 */   JLabel lblToggle = new JLabel();
/*  28 */   CirclePointsSettingsButton circlePointsSetttingsButton = new CirclePointsSettingsButton();
/*  29 */   JLabel lblDrawPointInCenter = new JLabel();
/*  30 */   JCheckBox ckDrawPointInCenter = new JCheckBox();
/*     */ 
/*     */   
/*     */   public CircleSettingsDialog(Dialog p0, String p1, boolean p2) {
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
/*     */   public CircleSettingsDialog(Frame p0, String p1, boolean p2) {
/*  47 */     super(p0, p1, p2);
/*     */     try {
/*  49 */       jbInit();
/*     */     }
/*  51 */     catch (Exception e) {
/*  52 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void populateLists() {
/*  60 */     this.cbDiameter.addItem(new Integer(5));
/*  61 */     this.cbDiameter.addItem(new Integer(10));
/*  62 */     this.cbDiameter.addItem(new Integer(15));
/*  63 */     this.cbDiameter.addItem(new Integer(20));
/*  64 */     this.cbDiameter.addItem(new Integer(25));
/*  65 */     this.cbDiameter.addItem(new Integer(30));
/*  66 */     this.cbDiameter.addItem(new Integer(40));
/*  67 */     this.cbDiameter.addItem(new Integer(50));
/*  68 */     this.cbDiameter.setSelectedItem(new Integer(Settings.getPhotoPointDiameter()));
/*     */     
/*  70 */     this.panCircleFill.setBackground(Settings.getPhotoPointFillColor());
/*  71 */     this.panCircOut.setBackground(Settings.getPhotoPointOutlineColor());
/*  72 */     this.panCircSelFill.setBackground(Settings.getSelectedPhotoPointFillColor());
/*  73 */     this.panCircSelOut.setBackground(Settings.getSelectedPhotoPointOutlineColor());
/*     */     
/*  75 */     this.ckDrawPointInCenter.setSelected(Settings.isDrawDotInCircle());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  81 */     populateLists();
/*  82 */     this.lblCircleDiameter.setText("Circle Diameter");
/*  83 */     getContentPane().setLayout(this.gridBagLayout1);
/*  84 */     this.lblFillColor.setText("Fill Color");
/*  85 */     this.lblOutlineColor.setText("Outline Color");
/*  86 */     this.lblSelectedFill.setText("Fill Color when Selected");
/*  87 */     this.lblSelectedOutline.setText("Outline Color when Selected");
/*  88 */     this.panCircleFill.setBorder(BorderFactory.createRaisedBevelBorder());
/*  89 */     this.panCircleFill.setMaximumSize(new Dimension(80, 20));
/*  90 */     this.panCircleFill.setMinimumSize(new Dimension(80, 20));
/*  91 */     this.panCircleFill.setPreferredSize(new Dimension(80, 20));
/*  92 */     this.panCircleFill.addMouseListener(new CircleSettingsDialog_panCircleFill_mouseAdapter(this));
/*  93 */     this.btnFootOutNull.setMaximumSize(new Dimension(20, 20));
/*  94 */     this.btnFootOutNull.setMinimumSize(new Dimension(20, 20));
/*  95 */     this.btnFootOutNull.setPreferredSize(new Dimension(20, 20));
/*  96 */     this.btnFootOutNull.setMargin(new Insets(2, 4, 2, 4));
/*  97 */     this.btnFootOutNull.setText("X");
/*  98 */     this.btnFootOutNull.addActionListener(new CircleSettingsDialog_btnFootOutNull_actionAdapter(this));
/*  99 */     this.panCircOut.setBorder(BorderFactory.createRaisedBevelBorder());
/* 100 */     this.panCircOut.setMaximumSize(new Dimension(80, 20));
/* 101 */     this.panCircOut.setMinimumSize(new Dimension(80, 20));
/* 102 */     this.panCircOut.setPreferredSize(new Dimension(80, 20));
/* 103 */     this.panCircOut.addMouseListener(new CircleSettingsDialog_panCircOut_mouseAdapter(this));
/* 104 */     this.panCircOut.setLayout(this.borderLayout3);
/* 105 */     this.btnOk.setText("OK");
/* 106 */     this.btnOk.addActionListener(new CircleSettingsDialog_btnOk_actionAdapter(this));
/* 107 */     this.panCircSelFill.setBorder(BorderFactory.createRaisedBevelBorder());
/* 108 */     this.panCircSelFill.setMaximumSize(new Dimension(80, 20));
/* 109 */     this.panCircSelFill.setMinimumSize(new Dimension(80, 20));
/* 110 */     this.panCircSelFill.setPreferredSize(new Dimension(80, 20));
/* 111 */     this.panCircSelFill.addMouseListener(new CircleSettingsDialog_panCircSelFill_mouseAdapter(this));
/* 112 */     this.btnCircSelFillNull.setMaximumSize(new Dimension(20, 20));
/* 113 */     this.btnCircSelFillNull.setMinimumSize(new Dimension(20, 20));
/* 114 */     this.btnCircSelFillNull.setPreferredSize(new Dimension(20, 20));
/* 115 */     this.btnCircSelFillNull.setHorizontalAlignment(0);
/* 116 */     this.btnCircSelFillNull.setMargin(new Insets(4, 4, 4, 4));
/* 117 */     this.btnCircSelFillNull.setText("X");
/* 118 */     this.btnCircSelFillNull.addActionListener(new CircleSettingsDialog_btnCircSelFillNull_actionAdapter(this));
/* 119 */     this.panCircSelOut.setBorder(BorderFactory.createRaisedBevelBorder());
/* 120 */     this.panCircSelOut.setMaximumSize(new Dimension(60, 20));
/* 121 */     this.panCircSelOut.setMinimumSize(new Dimension(80, 20));
/* 122 */     this.panCircSelOut.setPreferredSize(new Dimension(80, 20));
/* 123 */     this.panCircSelOut.addMouseListener(new CircleSettingsDialog_panCircSelOut_mouseAdapter(this));
/* 124 */     this.panCircSelOut.setLayout(this.borderLayout1);
/* 125 */     this.cbDiameter.setMinimumSize(new Dimension(60, 20));
/* 126 */     this.cbDiameter.setPreferredSize(new Dimension(60, 20));
/* 127 */     this.lblToggle.setText("Toggle On/Off");
/* 128 */     this.circlePointsSetttingsButton.setMaximumSize(new Dimension(60, 60));
/* 129 */     this.circlePointsSetttingsButton.setMinimumSize(new Dimension(60, 60));
/* 130 */     this.circlePointsSetttingsButton.setPreferredSize(new Dimension(60, 60));
/* 131 */     this.circlePointsSetttingsButton.setText("");
/* 132 */     this.lblDrawPointInCenter.setText("Draw Dot In Circle");
/* 133 */     this.ckDrawPointInCenter.setText("");
/* 134 */     this.ckDrawPointInCenter.addActionListener(new CircleSettingsDialog_ckDrawPointInCenter_actionAdapter(this));
/* 135 */     setTitle("Circle Settings Dialog");
/* 136 */     getContentPane().add(this.lblCircleDiameter, new GridBagConstraints(0, 2, 1, 2, 0.0D, 0.0D, 
/* 137 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 138 */     getContentPane().add(this.lblFillColor, new GridBagConstraints(0, 4, 2, 1, 0.0D, 0.0D, 
/* 139 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 140 */     getContentPane().add(this.lblOutlineColor, new GridBagConstraints(0, 5, 2, 1, 0.0D, 0.0D, 
/* 141 */           17, 0, new Insets(5, 10, 0, 0), 0, 0));
/* 142 */     getContentPane().add(this.lblSelectedFill, new GridBagConstraints(0, 6, 1, 1, 0.0D, 0.0D, 
/* 143 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 144 */     getContentPane().add(this.lblSelectedOutline, new GridBagConstraints(0, 7, 1, 1, 0.0D, 0.0D, 
/* 145 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 146 */     getContentPane().add(this.panCircleFill, new GridBagConstraints(2, 4, 1, 1, 0.0D, 0.0D, 
/* 147 */           10, 0, new Insets(5, 5, 5, 0), 0, 0));
/* 148 */     getContentPane().add(this.panCircOut, new GridBagConstraints(2, 5, 1, 1, 0.0D, 0.0D, 
/* 149 */           10, 0, new Insets(5, 5, 5, 0), 0, 0));
/* 150 */     getContentPane().add(this.panCircSelFill, new GridBagConstraints(2, 6, 1, 1, 0.0D, 0.0D, 
/* 151 */           10, 0, new Insets(5, 5, 5, 0), 0, 0));
/* 152 */     getContentPane().add(this.panCircSelOut, new GridBagConstraints(2, 7, 1, 1, 0.0D, 0.0D, 
/* 153 */           10, 0, new Insets(5, 5, 5, 0), 0, 0));
/* 154 */     getContentPane().add(this.cbDiameter, new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 
/* 155 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 156 */     getContentPane().add(this.btnFootOutNull, new GridBagConstraints(3, 4, 1, 1, 0.0D, 0.0D, 
/* 157 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 158 */     getContentPane().add(this.btnCircSelFillNull, new GridBagConstraints(3, 6, 1, 1, 0.0D, 0.0D, 
/* 159 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 160 */     getContentPane().add(this.btnOk, new GridBagConstraints(4, 0, 1, 2, 0.5D, 0.0D, 
/* 161 */           12, 0, new Insets(5, 0, 0, 5), 0, 0));
/* 162 */     getContentPane().add(this.lblToggle, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 163 */           17, 0, new Insets(5, 10, 0, 5), 0, 0));
/* 164 */     getContentPane().add((Component)this.circlePointsSetttingsButton, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 
/* 165 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 166 */     getContentPane().add(this.lblDrawPointInCenter, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 167 */           17, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 168 */     getContentPane().add(this.ckDrawPointInCenter, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/* 169 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 170 */     this.cbDiameter.addActionListener(new CircleSettingsDialog_cbDiameter_actionAdapter(this));
/*     */   }
/*     */ 
/*     */   
/*     */   void panCircleFill_mouseClicked(MouseEvent e) {
/* 175 */     String title = "Circle Fill Color";
/* 176 */     Color c = JColorChooser.showDialog(this, title, Settings.getPhotoPointFillColor());
/* 177 */     if (c == null)
/* 178 */       return;  if (c.equals(Settings.getPhotoPointFillColor()))
/* 179 */       return;  Settings.setPhotoPointFillColor(c);
/* 180 */     this.panCircleFill.setBackground(c);
/* 181 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 186 */     dispose();
/*     */   }
/*     */   
/*     */   void panCircOut_mouseClicked(MouseEvent e) {
/* 190 */     String title = "Circle Outline Color";
/* 191 */     Color c = JColorChooser.showDialog(this, title, Settings.getPhotoPointOutlineColor());
/* 192 */     if (c == null)
/* 193 */       return;  if (c.equals(Settings.getPhotoPointOutlineColor()))
/* 194 */       return;  Settings.setPhotoPointOutlineColor(c);
/* 195 */     this.panCircOut.setBackground(c);
/* 196 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void panCircSelFill_mouseClicked(MouseEvent e) {
/* 201 */     String title = "Fill Color when selected";
/* 202 */     Color c = JColorChooser.showDialog(this, title, Settings.getSelectedPhotoPointFillColor());
/* 203 */     if (c == null)
/* 204 */       return;  if (c.equals(Settings.getSelectedPhotoPointFillColor()))
/* 205 */       return;  Settings.setSelectedPhotoPointFillColor(c);
/* 206 */     this.panCircSelFill.setBackground(c);
/* 207 */     Global.fireSelectedPhotoPointChanged(this);
/* 208 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void panCircSelOut_mouseClicked(MouseEvent e) {
/* 215 */     String title = "Outline Color when selected";
/* 216 */     Color c = JColorChooser.showDialog(this, title, Settings.getSelectedPhotoPointOutlineColor());
/* 217 */     if (c == null)
/* 218 */       return;  if (c.equals(Settings.getSelectedPhotoPointOutlineColor()))
/* 219 */       return;  Settings.setSelectedPhotoPointOutlineColor(c);
/* 220 */     this.panCircSelOut.setBackground(c);
/* 221 */     Global.fireSelectedPhotoPointChanged(this);
/* 222 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnCircSelFillNull_actionPerformed(ActionEvent e) {
/* 227 */     this.panCircSelFill.setBackground((Color)null);
/* 228 */     Settings.setSelectedPhotoPointFillColor(null);
/* 229 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void cbDiameter_actionPerformed(ActionEvent e) {
/* 234 */     Settings.setPhotoPointDiameter(((Integer)this.cbDiameter.getSelectedItem()).intValue());
/*     */     
/* 236 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnCircFillNull_actionPerformed(ActionEvent e) {
/* 241 */     Settings.setPhotoPointFillColor(null);
/* 242 */     this.panCircleFill.setBackground((Color)null);
/* 243 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void ckDrawPointInCenter_actionPerformed(ActionEvent e) {
/* 247 */     Settings.setDrawDotInCircle(this.ckDrawPointInCenter.isSelected());
/* 248 */     Global.fireSettingsChanged(this);
/* 249 */     this.circlePointsSetttingsButton.updateUI();
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\CircleSettingsDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */