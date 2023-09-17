/*     */ package com.vadosity.vnav.client.hosting;
/*     */ import java.awt.Container;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.util.Locale;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class HtmlViewPanel extends JPanel {
/*  10 */   JTextArea taHtml = new JTextArea();
/*  11 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  12 */   JButton btnBack = new JButton();
/*  13 */   JPanel jPanel1 = new JPanel();
/*  14 */   JButton btnNext = new JButton();
/*  15 */   JLabel lblEditHtml = new JLabel();
/*  16 */   JScrollPane scrollHtml = new JScrollPane();
/*     */   
/*     */   public HtmlViewPanel() throws HeadlessException {
/*     */     try {
/*  20 */       jbInit();
/*     */     }
/*  22 */     catch (Exception e) {
/*  23 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/*  28 */     this.taHtml.setBorder(BorderFactory.createLoweredBevelBorder());
/*  29 */     setLayout(this.gridBagLayout1);
/*  30 */     this.btnBack.setText("Back");
/*  31 */     this.btnBack.addActionListener(new HtmlViewPanel_btnBack_actionAdapter(this));
/*  32 */     this.jPanel1.setMinimumSize(new Dimension(40, 40));
/*  33 */     this.jPanel1.setPreferredSize(new Dimension(40, 40));
/*  34 */     this.btnNext.setText("Next");
/*  35 */     this.btnNext.addActionListener(new HtmlViewPanel_btnNext_actionAdapter(this));
/*  36 */     this.lblEditHtml.setText("Edit HTML below to customize your tour's web page, or just click 'Next'");
/*     */     
/*  38 */     addFocusListener(new HtmlViewPanel_this_focusAdapter(this));
/*  39 */     addComponentListener(new HtmlViewPanel_this_componentAdapter(this));
/*  40 */     this.scrollHtml.setPreferredSize(new Dimension(23, 23));
/*  41 */     add(this.jPanel1, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/*  42 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/*  43 */     this.jPanel1.add(this.btnBack, (Object)null);
/*  44 */     this.jPanel1.add(this.btnNext, (Object)null);
/*  45 */     add(this.scrollHtml, new GridBagConstraints(0, 1, 1, 1, 1.0D, 1.0D, 
/*  46 */           10, 1, new Insets(0, 10, 0, 10), 0, 0));
/*  47 */     add(this.lblEditHtml, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  48 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  49 */     this.scrollHtml.getViewport().add(this.taHtml, (Object)null);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnBack_actionPerformed(ActionEvent e) {
/*  54 */     ((CardLayout)getParent().getLayout()).previous(getParent());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateHtmlText() {
/*  60 */     String lang = HostingData.getInstance().getDisplayLanguage();
/*  61 */     Locale locale = null;
/*  62 */     if (lang != null) {
/*     */       
/*  64 */       Locale[] locales = Locale.getAvailableLocales();
/*  65 */       Locale ithLocale = null;
/*  66 */       for (int i = 0; i < locales.length; i++) {
/*     */         
/*  68 */         ithLocale = locales[i];
/*  69 */         if (ithLocale != null) {
/*  70 */           String ithDisplayLanguage = ithLocale.getDisplayLanguage(ithLocale);
/*  71 */           if (ithDisplayLanguage.equalsIgnoreCase(lang)) {
/*     */             
/*  73 */             locale = ithLocale;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  79 */     StringBuffer buf = new StringBuffer();
/*  80 */     buf.append("<html> \n");
/*  81 */     buf.append("<head><title>" + HostingData.getInstance().getTourName() + "</title></head> \n");
/*  82 */     buf.append("<body> \n");
/*     */     
/*  84 */     if (HostingData.getInstance().getTagType() == HostingData.OBJECT_TAG_TYPE) {
/*     */       
/*  86 */       buf.append(" <OBJECT classid = \"clsid:8AD9C840-044E-11D1-B3E9-00805F499D93\" \n");
/*  87 */       buf.append("   codebase = \"http://java.sun.com/products/plugin/autodl/jinstall-1_4-windows-i586.cab#Version=1,4,0,0\" \n");
/*  88 */       buf.append("   WIDTH = \"" + HostingData.getInstance().getAppletWidth() + "\"  HEIGHT = \"" + HostingData.getInstance().getAppletHeight() + "\" \n");
/*  89 */       buf.append("   NAME = \"VadosityToolkit Applet\" ALIGN = \"middle\" VSPACE = \"0\" HSPACE = \"0\" > \n");
/*  90 */       buf.append("   <PARAM NAME = CODE VALUE = \"VadosityApplet.class\" > \n");
/*  91 */       buf.append("   <PARAM NAME = ARCHIVE VALUE = \"" + HostingData.getInstance().getTourDirectoryUrl() + "/vadosity.jar\" >  \n");
/*  92 */       buf.append("   <PARAM NAME = NAME VALUE = \"" + HostingData.getInstance().getTourName() + "\" >  \n");
/*  93 */       buf.append("   <PARAM NAME = \"type\" VALUE = \"application/x-java-applet;version=1.4\">   \n");
/*  94 */       buf.append("   <PARAM NAME = \"scriptable\" VALUE = \"false\">  \n");
/*  95 */       buf.append("   <PARAM NAME = \"file\" VALUE=\"" + HostingData.getInstance().getTourFileUrl() + "\">  \n");
/*  96 */       if (locale != null && !locale.equals(Locale.ENGLISH))
/*     */       {
/*  98 */         buf.append(" <PARAM NAME = \"language\" VALUE=\"" + locale + "\">   \n");
/*     */       }
/* 100 */       buf.append("   <COMMENT> \n");
/* 101 */       buf.append("     <EMBED type = \"application/x-java-applet;version=1.4\"  \n");
/* 102 */       buf.append("            CODE = \"VadosityApplet.class\"  \n");
/* 103 */       buf.append("            ARCHIVE = \"" + HostingData.getInstance().getTourDirectoryUrl() + "/vadosity.jar\"    \n");
/* 104 */       buf.append("            NAME = \"" + HostingData.getInstance().getTourName() + "\"   \n");
/* 105 */       buf.append("            WIDTH = \"" + HostingData.getInstance().getAppletWidth() + "\"  \n");
/* 106 */       buf.append("            HEIGHT = \"" + HostingData.getInstance().getAppletHeight() + "\"    \n");
/* 107 */       buf.append("            ALIGN = \"middle\" VSPACE = \"0\" HSPACE = \"0\" \n");
/* 108 */       buf.append("            file =\"" + HostingData.getInstance().getTourFileUrl() + "\"   \n");
/* 109 */       if (locale != null && !locale.equals(Locale.ENGLISH))
/*     */       {
/* 111 */         buf.append("          language=\"" + locale + "\"   \n");
/*     */       }
/* 113 */       buf.append("            scriptable = false \n");
/* 114 */       buf.append("            pluginspage = \"http://java.sun.com/products/plugin/index.html#download\">   \n");
/* 115 */       buf.append("     <NOEMBED></NOEMBED>   \n");
/* 116 */       buf.append("   </COMMENT>  \n");
/* 117 */       buf.append("</OBJECT>   \n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       buf.append("<APPLET    \n");
/* 165 */       buf.append("   CODE = \"VadosityApplet.class\"  \n");
/* 166 */       buf.append("   ARCHIVE = \"" + HostingData.getInstance().getTourDirectoryUrl() + "/vadosity.jar\"    \n");
/* 167 */       buf.append("   NAME = \"" + HostingData.getInstance().getTourName() + "\"   \n");
/* 168 */       buf.append("   WIDTH = \"" + HostingData.getInstance().getAppletWidth() + "\"  \n");
/* 169 */       buf.append("   HEIGHT = \"" + HostingData.getInstance().getAppletHeight() + "\"    \n");
/* 170 */       buf.append("   ALIGN = \"middle\" VSPACE = \"0\" HSPACE = \"0\"> \n");
/* 171 */       buf.append("   <PARAM NAME = file VALUE=\"" + HostingData.getInstance().getTourFileUrl() + "\">   \n");
/* 172 */       if (locale != null && !locale.equals(Locale.ENGLISH))
/*     */       {
/* 174 */         buf.append("   <PARAM NAME = language VALUE=\"" + locale + "\">   \n");
/*     */       }
/* 176 */       buf.append("</APPLET>   \n");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     buf.append("</body>  \n");
/* 191 */     buf.append("</html>  \n");
/*     */ 
/*     */     
/* 194 */     this.taHtml.setText(buf.toString());
/* 195 */     this.taHtml.setCaretPosition(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_focusGained(FocusEvent e) {
/* 206 */     updateHtmlText();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void this_componentShown(ComponentEvent e) {
/* 212 */     updateHtmlText();
/*     */     
/* 214 */     Container parent = getParent();
/* 215 */     JDialog dlg = null;
/*     */     
/*     */     while (true) {
/* 218 */       if (parent instanceof JDialog) {
/*     */         
/* 220 */         dlg = (JDialog)parent;
/*     */         
/*     */         break;
/*     */       } 
/*     */       
/* 225 */       parent = parent.getParent();
/*     */     } 
/*     */     
/* 228 */     dlg.setTitle("Hosting Wizard: Step 3 of 4 - View / Edit Tour Page HTML");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void btnNext_actionPerformed(ActionEvent e) {
/* 234 */     HostingData.getInstance().setHtmlText(this.taHtml.getText());
/* 235 */     HostingData.getInstance().saveState();
/* 236 */     ((CardLayout)getParent().getLayout()).next(getParent());
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\hosting\HtmlViewPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */