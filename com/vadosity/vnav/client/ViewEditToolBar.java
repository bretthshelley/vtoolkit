/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.IOException;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class ViewEditToolBar extends JToolBar implements SettingsChangeListener {
/*  10 */   ViewModeButton viewModeToggleButton = new ViewModeButton();
/*  11 */   EditModeToggleButton editModeToggleButton = new EditModeToggleButton();
/*  12 */   JButton dragFromWindowsButton = new JButton();
/*     */ 
/*     */ 
/*     */   
/*     */   public ViewEditToolBar() {
/*     */     try {
/*  18 */       jbInit();
/*  19 */       Global.addSettingsChangeListener(this);
/*     */       
/*  21 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/*  22 */       UIManager.setLookAndFeel(nativeLF);
/*  23 */       SwingUtilities.updateComponentTreeUI(this);
/*     */     
/*     */     }
/*  26 */     catch (Exception e) {
/*  27 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/*  35 */     this.viewModeToggleButton.setBorder(BorderFactory.createEtchedBorder());
/*  36 */     this.viewModeToggleButton.setMaximumSize(new Dimension(100, 35));
/*  37 */     this.viewModeToggleButton.setMinimumSize(new Dimension(100, 35));
/*  38 */     this.viewModeToggleButton.setPreferredSize(new Dimension(100, 35));
/*  39 */     this.viewModeToggleButton.setText("View");
/*  40 */     String ttV = "<html><body>";
/*  41 */     ttV = String.valueOf(ttV) + "<font size=\"4\" color=\"#0000ff\"><b>";
/*  42 */     ttV = String.valueOf(ttV) + "&nbsp;View the Tour.&nbsp;<br>";
/*  43 */     ttV = String.valueOf(ttV) + "</b></font>";
/*  44 */     ttV = String.valueOf(ttV) + "</body></html>";
/*  45 */     this.viewModeToggleButton.setToolTipText(ttV);
/*     */ 
/*     */     
/*  48 */     this.editModeToggleButton.setBorder(BorderFactory.createEtchedBorder());
/*  49 */     this.editModeToggleButton.setMaximumSize(new Dimension(100, 35));
/*  50 */     this.editModeToggleButton.setMinimumSize(new Dimension(100, 35));
/*  51 */     this.editModeToggleButton.setPreferredSize(new Dimension(100, 35));
/*  52 */     this.editModeToggleButton.setText("Edit");
/*  53 */     String ttE = "<html><body>";
/*  54 */     ttE = String.valueOf(ttE) + "<font size=\"4\" color=\"#0000ff\"><b>";
/*  55 */     ttE = String.valueOf(ttE) + "&nbsp;Edit Mode enable you to add Photos, add View Tabs, &nbsp;<br>";
/*  56 */     ttE = String.valueOf(ttE) + "&nbsp;Reposition icons, and configure your tour.&nbsp;<br>";
/*  57 */     ttE = String.valueOf(ttE) + "</b></font>";
/*  58 */     ttE = String.valueOf(ttE) + "</body></html>";
/*  59 */     this.editModeToggleButton.setToolTipText(ttE);
/*     */     
/*  61 */     ToolTipManager.sharedInstance().setDismissDelay(15000);
/*  62 */     String ttWE = "<html><body>";
/*  63 */     ttWE = String.valueOf(ttWE) + "<font size=\"4\" color=\"#0000ff\"><b>";
/*  64 */     ttWE = String.valueOf(ttWE) + "&nbsp;Drag an Image File from Windows Explorer&nbsp;<br>";
/*  65 */     ttWE = String.valueOf(ttWE) + "&nbsp;onto your Vadosity Window to Create a View Tab.<br>";
/*  66 */     ttWE = String.valueOf(ttWE) + "</b></font>";
/*  67 */     ttWE = String.valueOf(ttWE) + "</body></html>";
/*     */ 
/*     */     
/*  70 */     this.dragFromWindowsButton.setToolTipText(ttWE);
/*  71 */     this.dragFromWindowsButton.setText("Add View Tab with Explorer");
/*  72 */     this.dragFromWindowsButton.setMaximumSize(new Dimension(200, 35));
/*  73 */     this.dragFromWindowsButton.setMinimumSize(new Dimension(200, 35));
/*  74 */     this.dragFromWindowsButton.setPreferredSize(new Dimension(200, 35));
/*     */     
/*  76 */     add(this.viewModeToggleButton, (Object)null);
/*  77 */     add(this.editModeToggleButton, (Object)null);
/*  78 */     add(this.dragFromWindowsButton);
/*     */     
/*  80 */     this.dragFromWindowsButton.addActionListener(
/*     */         
/*  82 */         new ActionListener(this) {
/*     */           final ViewEditToolBar this$0;
/*     */           
/*     */           public void actionPerformed(ActionEvent evt) {
/*  86 */             String[] sa = new String[2];
/*  87 */             sa[0] = "iexplore";
/*  88 */             sa[1] = String.valueOf(System.getProperty("user.home")) + File.separator + "My Documents";
/*     */ 
/*     */             
/*     */             try {
/*  92 */               Runtime.getRuntime().exec(sa);
/*     */             }
/*  94 */             catch (IOException ex) {
/*     */               
/*  96 */               JOptionPane.showMessageDialog(VadosityToolkit.getInstance(), "Unable to Open Window Explorer", "error", 0);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/* 107 */     this.dragFromWindowsButton.setVisible((Settings.getMode() == 0));
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ViewEditToolBar.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */