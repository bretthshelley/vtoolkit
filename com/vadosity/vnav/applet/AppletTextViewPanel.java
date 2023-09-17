/*     */ package com.vadosity.vnav.applet;
/*     */ import com.vadosity.vnav.Formatter;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.Tour;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.GlobalChangeListener;
/*     */ import com.vadosity.vnav.client.SettingsChangeListener;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.text.AbstractDocument;
/*     */ 
/*     */ public class AppletTextViewPanel extends JPanel implements GlobalChangeListener, SettingsChangeListener {
/*  27 */   BorderLayout borderLayout1 = new BorderLayout();
/*  28 */   JEditorPane editorPane = new JEditorPane();
/*  29 */   String formattedText = null;
/*     */   AbstractDocument doc;
/*  31 */   JScrollPane scrollerEditorPane = new JScrollPane();
/*  32 */   BorderLayout borderLayout3 = new BorderLayout();
/*  33 */   JPanel northPanel = new JPanel();
/*  34 */   GridBagLayout gridBagLayout2 = new GridBagLayout();
/*  35 */   JLabel lblDescription = new JLabel();
/*     */ 
/*     */ 
/*     */   
/*     */   public AppletTextViewPanel() {
/*  40 */     initTextEditingPanel();
/*  41 */     Global.addGlobalChangeListener(this);
/*  42 */     Global.addSettingsChangeListener(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initTextEditingPanel() {
/*     */     try {
/*  49 */       jbInit();
/*     */ 
/*     */       
/*  52 */       this.editorPane.setContentType("text/html");
/*  53 */       this.doc = (AbstractDocument)this.editorPane.getDocument();
/*  54 */       this.doc.addDocumentListener(new MyDocumentListener(this));
/*     */ 
/*     */       
/*  57 */       this.editorPane.requestFocus();
/*  58 */       this.editorPane.setCaretPosition(0);
/*     */ 
/*     */ 
/*     */       
/*  62 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/*  63 */       UIManager.setLookAndFeel(nativeLF);
/*  64 */       SwingUtilities.updateComponentTreeUI(this);
/*     */     
/*     */     }
/*  67 */     catch (Exception e) {
/*  68 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/*  73 */     setLayout(this.borderLayout1);
/*  74 */     this.editorPane.setMargin(new Insets(5, 5, 5, 5));
/*  75 */     this.editorPane.setText("");
/*  76 */     this.editorPane.setContentType("text/html");
/*  77 */     this.editorPane.setMinimumSize(new Dimension(250, 100));
/*  78 */     this.editorPane.setPreferredSize(new Dimension(250, 100));
/*  79 */     this.editorPane.setCaretPosition(0);
/*     */     
/*  81 */     this.northPanel.setMinimumSize(new Dimension(10, 20));
/*  82 */     this.northPanel.setPreferredSize(new Dimension(10, 45));
/*  83 */     this.northPanel.setLayout(this.gridBagLayout2);
/*  84 */     this.lblDescription.setFont(new Font("Dialog", 1, 11));
/*  85 */     this.lblDescription.setText("Tour Description:");
/*  86 */     this.northPanel.add(this.lblDescription, new GridBagConstraints(0, 0, 1, 1, 0.1D, 1.0D, 
/*  87 */           16, 0, new Insets(5, 5, 10, 5), 0, 0));
/*  88 */     add(this.scrollerEditorPane, "Center");
/*  89 */     add(this.northPanel, "North");
/*  90 */     this.scrollerEditorPane.getViewport().add(this.editorPane, (Object)null);
/*     */   }
/*     */   
/*     */   protected class MyDocumentListener implements DocumentListener { final AppletTextViewPanel this$0;
/*     */     
/*     */     protected MyDocumentListener(AppletTextViewPanel this$0) {
/*  96 */       this.this$0 = this$0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void insertUpdate(DocumentEvent e) {}
/*     */ 
/*     */     
/*     */     public void removeUpdate(DocumentEvent e) {}
/*     */ 
/*     */     
/*     */     public void changedUpdate(DocumentEvent e) {
/* 108 */       this.this$0.editorPane.getCaret().setSelectionVisible(true);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateFormattedText() {
/*     */     try {
/* 116 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 117 */       this.editorPane.getEditorKit().write(baos, this.doc, 0, this.doc.getLength());
/* 118 */       this.formattedText = new String(baos.toByteArray());
/* 119 */       if (Global.getTour() != null)
/*     */       {
/* 121 */         Global.getTour().setDescription(this.formattedText);
/* 122 */         Global.getTour().setModified(true);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 127 */     catch (Exception ex) {
/*     */       
/* 129 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFormattedText() {
/* 135 */     return this.formattedText;
/*     */   }
/*     */   public void setFormattedText(String text) {
/* 138 */     this.formattedText = text;
/*     */     
/* 140 */     if (this.formattedText == null || this.formattedText.trim().equals("")) {
/*     */       
/* 142 */       this.editorPane.setText("");
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 148 */         this.editorPane.setText("");
/* 149 */         ByteArrayInputStream bais = new ByteArrayInputStream(this.formattedText.getBytes());
/* 150 */         this.editorPane.getEditorKit().read(bais, this.doc, 0);
/*     */       }
/* 152 */       catch (Exception e) {
/*     */         
/* 154 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {
/* 164 */     if (Global.getTour() == null) {
/*     */       
/* 166 */       setFormattedText("");
/* 167 */       updateFormattedText();
/*     */     }
/*     */     else {
/*     */       
/* 171 */       setFormattedText(Global.getTour().getDescription());
/* 172 */       this.editorPane.setCaretPosition(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {
/* 183 */     if (selectedPhoto != null && 
/* 184 */       selectedPhoto.getDescription() != null && 
/* 185 */       !Formatter.isHTMLEmpty(selectedPhoto.getDescription())) {
/*     */ 
/*     */ 
/*     */       
/* 189 */       setFormattedText(Global.getPhoto().getDescription());
/* 190 */       this.lblDescription.setText("Photo Description:");
/* 191 */       this.lblDescription.setVisible(true);
/* 192 */       this.editorPane.setVisible(true);
/* 193 */       this.editorPane.setCaretPosition(0);
/* 194 */       this.scrollerEditorPane.setVisible(true);
/* 195 */       setVisible(true);
/* 196 */       updateUI();
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 201 */     else if (Global.getTour() == null) {
/*     */       
/* 203 */       setFormattedText("");
/* 204 */       updateFormattedText();
/*     */     }
/*     */     else {
/*     */       
/* 208 */       boolean textChanged = !this.editorPane.getText().equals(Global.getTour().getDescription());
/* 209 */       if (textChanged)
/*     */       {
/*     */         
/* 212 */         setFormattedText(Global.getTour().getDescription());
/*     */       }
/* 214 */       this.lblDescription.setText("Tour Description: ");
/*     */       
/* 216 */       if (Formatter.isHTMLEmpty(Global.getTour().getDescription())) {
/*     */         
/* 218 */         this.lblDescription.setVisible(false);
/* 219 */         this.scrollerEditorPane.setVisible(false);
/* 220 */         this.editorPane.setVisible(false);
/* 221 */         setVisible(false);
/* 222 */         updateUI();
/*     */       }
/*     */       else {
/*     */         
/* 226 */         this.lblDescription.setVisible(true);
/* 227 */         this.scrollerEditorPane.setVisible(true);
/* 228 */         this.editorPane.setVisible(true);
/* 229 */         if (textChanged) this.editorPane.setCaretPosition(0); 
/* 230 */         setVisible(true);
/* 231 */         updateUI();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/* 252 */     if (Formatter.isHTMLEmpty(this.editorPane.getText())) {
/*     */       
/* 254 */       setVisible(false);
/* 255 */       this.editorPane.setVisible(false);
/* 256 */       this.lblDescription.setVisible(false);
/*     */     } 
/*     */     
/* 259 */     this.editorPane.setEditable(false);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\applet\AppletTextViewPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */