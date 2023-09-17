/*     */ package com.vadosity.vnav.client.settings;
/*     */ import com.vadosity.vnav.bean.ViewSettings;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.TitledBorder;
/*     */ 
/*     */ public class AdvancedSettingsDialog extends JDialog {
/*  15 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  16 */   JPanel panelProximity = new JPanel();
/*     */   TitledBorder borderProximity;
/*  18 */   GridBagLayout gridBagLayout2 = new GridBagLayout();
/*  19 */   JRadioButton radioUserDefined = new JRadioButton();
/*  20 */   JComboBox cbProximity = new JComboBox();
/*  21 */   ButtonGroup buttonGroup = new ButtonGroup();
/*  22 */   JButton btnReset = new JButton();
/*  23 */   JPanel panelViewSettings = new JPanel();
/*     */   TitledBorder borderAllSettings;
/*  25 */   GridBagLayout gridBagLayout3 = new GridBagLayout();
/*  26 */   JButton btnApplySettingsToAll = new JButton();
/*  27 */   JCheckBox ckDrawProximity = new JCheckBox();
/*  28 */   JButton btnOk = new JButton();
/*  29 */   JRadioButton radioOptimized = new JRadioButton();
/*     */ 
/*     */   
/*     */   public AdvancedSettingsDialog() throws HeadlessException {
/*     */     try {
/*  34 */       jbInit();
/*     */     }
/*  36 */     catch (Exception e) {
/*  37 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AdvancedSettingsDialog(Dialog p0, String p1, boolean p2) throws HeadlessException {
/*  43 */     super(p0, p1, p2);
/*     */     
/*     */     try {
/*  46 */       jbInit();
/*     */     }
/*  48 */     catch (Exception e) {
/*     */       
/*  50 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AdvancedSettingsDialog(Frame p0, String p1, boolean p2) throws HeadlessException {
/*  56 */     super(p0, p1, p2);
/*     */     
/*     */     try {
/*  59 */       jbInit();
/*     */     }
/*  61 */     catch (Exception e) {
/*     */       
/*  63 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void populateElements() {
/*  69 */     this.cbProximity.addItem(new Integer(15));
/*  70 */     this.cbProximity.addItem(new Integer(20));
/*  71 */     this.cbProximity.addItem(new Integer(25));
/*  72 */     this.cbProximity.addItem(new Integer(30));
/*  73 */     this.cbProximity.addItem(new Integer(35));
/*  74 */     this.cbProximity.addItem(new Integer(40));
/*  75 */     this.cbProximity.addItem(new Integer(45));
/*  76 */     this.cbProximity.addItem(new Integer(50));
/*  77 */     this.cbProximity.addItem(new Integer(60));
/*  78 */     this.cbProximity.addItem(new Integer(80));
/*  79 */     this.cbProximity.addItem(new Integer(100));
/*  80 */     this.cbProximity.addItem(new Integer(120));
/*  81 */     this.cbProximity.addItem(new Integer(150));
/*  82 */     this.cbProximity.addItem(new Integer(200));
/*  83 */     this.cbProximity.addItem(new Integer(250));
/*     */     
/*  85 */     if (Settings.getProximity() == ViewSettings.OPTIMIZED_PROXIMITY) {
/*     */       
/*  87 */       this.radioOptimized.setSelected(true);
/*  88 */       this.cbProximity.setEnabled(false);
/*     */     }
/*  90 */     else if (Settings.getProximity() == ViewSettings.USER_DEFINED_PROXIMITY) {
/*     */       
/*  92 */       this.radioUserDefined.setSelected(true);
/*  93 */       this.cbProximity.setEnabled(true);
/*  94 */       this.cbProximity.setSelectedItem(new Integer(Settings.getProximityDistance(null)));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  99 */       this.radioOptimized.setSelected(true);
/* 100 */       this.cbProximity.setEnabled(false);
/* 101 */       Settings.setProximity(ViewSettings.OPTIMIZED_PROXIMITY);
/* 102 */       Global.fireSettingsChanged(this);
/*     */     } 
/*     */     
/* 105 */     this.ckDrawProximity.setSelected(Settings.isDrawProximity());
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 110 */     this.borderAllSettings = new TitledBorder("");
/* 111 */     populateElements();
/* 112 */     this.borderProximity = new TitledBorder("");
/* 113 */     getContentPane().setLayout(this.gridBagLayout1);
/* 114 */     this.panelProximity.setBorder(this.borderProximity);
/* 115 */     this.panelProximity.setMinimumSize(new Dimension(300, 140));
/* 116 */     this.panelProximity.setPreferredSize(new Dimension(300, 140));
/* 117 */     this.panelProximity.setLayout(this.gridBagLayout2);
/* 118 */     this.borderProximity.setTitle("Proximity Settings");
/* 119 */     this.radioUserDefined.setText("User Defined");
/* 120 */     this.radioUserDefined.addActionListener(new AdvancedSettingsDialog_radioUserDefined_actionAdapter(this));
/* 121 */     this.cbProximity.setMinimumSize(new Dimension(80, 20));
/* 122 */     this.cbProximity.setPreferredSize(new Dimension(80, 20));
/* 123 */     this.cbProximity.addActionListener(new AdvancedSettingsDialog_cbProximity_actionAdapter(this));
/* 124 */     this.btnReset.setFont(new Font("Dialog", 0, 12));
/* 125 */     this.btnReset.setText("Reset Defaults");
/* 126 */     this.btnReset.addActionListener(new AdvancedSettingsDialog_btnReset_actionAdapter(this));
/* 127 */     this.panelViewSettings.setBorder(this.borderAllSettings);
/* 128 */     this.panelViewSettings.setMinimumSize(new Dimension(300, 100));
/* 129 */     this.panelViewSettings.setPreferredSize(new Dimension(350, 100));
/* 130 */     this.panelViewSettings.setLayout(this.gridBagLayout3);
/* 131 */     this.borderAllSettings.setTitle("All Settings");
/* 132 */     this.btnApplySettingsToAll.setFont(new Font("Dialog", 0, 12));
/* 133 */     this.btnApplySettingsToAll.setText("Apply Current Settings to All Views");
/* 134 */     this.btnApplySettingsToAll.addActionListener(new AdvancedSettingsDialog_btnApplySettingsToAll_actionAdapter(this));
/* 135 */     this.ckDrawProximity.setText("Draw Proximity");
/* 136 */     this.ckDrawProximity.addActionListener(new AdvancedSettingsDialog_ckDrawProximity_actionAdapter(this));
/* 137 */     this.btnOk.setText("OK");
/* 138 */     this.btnOk.addActionListener(new AdvancedSettingsDialog_btnOk_actionAdapter(this));
/* 139 */     this.radioOptimized.setText("Optimized");
/* 140 */     this.radioOptimized.addActionListener(new AdvancedSettingsDialog_radioOptimized_actionAdapter(this));
/* 141 */     setTitle("Advanced Settings Dialog");
/* 142 */     getContentPane().add(this.panelProximity, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 143 */           10, 0, new Insets(5, 10, 5, 5), 0, 0));
/* 144 */     this.panelProximity.add(this.radioUserDefined, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 145 */           17, 0, new Insets(5, 5, 0, 0), 0, 0));
/* 146 */     this.panelProximity.add(this.cbProximity, new GridBagConstraints(1, 1, 2, 2, 0.0D, 0.0D, 
/* 147 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 148 */     this.panelProximity.add(this.ckDrawProximity, new GridBagConstraints(0, 3, 2, 1, 0.0D, 0.0D, 
/* 149 */           17, 0, new Insets(5, 5, 5, 0), 0, 0));
/* 150 */     this.panelProximity.add(this.radioOptimized, new GridBagConstraints(0, 0, 3, 1, 0.0D, 0.0D, 
/* 151 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 152 */     getContentPane().add(this.panelViewSettings, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 153 */           10, 1, new Insets(5, 10, 5, 5), 0, 0));
/* 154 */     this.panelViewSettings.add(this.btnReset, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 155 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 156 */     this.panelViewSettings.add(this.btnApplySettingsToAll, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 157 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 158 */     getContentPane().add(this.btnOk, new GridBagConstraints(1, 0, 1, 1, 1.0D, 0.0D, 
/* 159 */           12, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 160 */     this.buttonGroup.add(this.radioUserDefined);
/* 161 */     this.buttonGroup.add(this.radioOptimized);
/*     */   }
/*     */ 
/*     */   
/*     */   void radioUserDefined_actionPerformed(ActionEvent e) {
/* 166 */     this.cbProximity.setEnabled(true);
/* 167 */     Settings.setProximity(ViewSettings.USER_DEFINED_PROXIMITY);
/* 168 */     int prox = ((Integer)this.cbProximity.getSelectedItem()).intValue();
/* 169 */     Settings.setProximityDistance(prox);
/* 170 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void cbProximity_actionPerformed(ActionEvent e) {
/* 174 */     Settings.setProximity(ViewSettings.USER_DEFINED_PROXIMITY);
/* 175 */     int prox = ((Integer)this.cbProximity.getSelectedItem()).intValue();
/* 176 */     Settings.setProximityDistance(prox);
/* 177 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void btnReset_actionPerformed(ActionEvent e) {
/* 181 */     Global.getView().setViewSettings(new ViewSettings());
/* 182 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnApplySettingsToAll_actionPerformed(ActionEvent e) {
/*     */     try {
/* 188 */       if (Global.getTour() == null) {
/*     */         
/* 190 */         JOptionPane.showMessageDialog(this, "No Tour Open.");
/*     */         
/*     */         return;
/*     */       } 
/* 194 */       ViewSettings vs = Global.getView().getViewSettings();
/* 195 */       for (int i = 0; i < Global.getTour().getViews().size(); i++)
/*     */       {
/* 197 */         ((View)Global.getTour().getViews().elementAt(i)).setViewSettings(vs);
/*     */       }
/* 199 */       Global.fireSelectedPhotoChanged(this);
/* 200 */       Global.fireSettingsChanged(this);
/*     */     
/*     */     }
/* 203 */     catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void ckDrawProximity_actionPerformed(ActionEvent e) {
/* 211 */     Settings.setDrawProximity(this.ckDrawProximity.isSelected());
/* 212 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 216 */     dispose();
/*     */   }
/*     */   
/*     */   void radioOptimized_actionPerformed(ActionEvent e) {
/* 220 */     Settings.setProximity(ViewSettings.OPTIMIZED_PROXIMITY);
/* 221 */     this.cbProximity.setEnabled(false);
/* 222 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\AdvancedSettingsDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */