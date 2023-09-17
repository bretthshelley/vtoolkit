/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.Formatter;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.text.AbstractDocument;
/*     */ 
/*     */ public class TextViewPanel extends JPanel implements GlobalChangeListener, SettingsChangeListener {
/*  24 */   JEditorPane editorPane = new JEditorPane();
/*  25 */   String formattedText = null;
/*     */   AbstractDocument doc;
/*  27 */   JScrollPane scrollerEditorPane = new JScrollPane();
/*  28 */   BorderLayout borderLayout3 = new BorderLayout();
/*  29 */   JPanel northPanel = new JPanel();
/*  30 */   GridBagLayout gridBagLayout2 = new GridBagLayout();
/*  31 */   JLabel lblDescription = new JLabel();
/*  32 */   JButton btnEdit = new JButton();
/*     */   
/*  34 */   private static TextViewPanel instance = null;
/*  35 */   GridBagLayout gridBagLayout1 = new GridBagLayout(); public static TextViewPanel getInstance() {
/*  36 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TextViewPanel() {
/*  42 */     initTextEditingPanel();
/*  43 */     Global.addGlobalChangeListener(this);
/*  44 */     Global.addSettingsChangeListener(this);
/*  45 */     instance = this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initTextEditingPanel() {
/*     */     try {
/*  52 */       jbInit();
/*     */ 
/*     */       
/*  55 */       this.editorPane.setContentType("text/html");
/*  56 */       this.doc = (AbstractDocument)this.editorPane.getDocument();
/*  57 */       this.doc.addDocumentListener(new MyDocumentListener(this));
/*     */ 
/*     */       
/*  60 */       this.editorPane.requestFocus();
/*  61 */       this.editorPane.setCaretPosition(0);
/*     */ 
/*     */ 
/*     */       
/*  65 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/*  66 */       UIManager.setLookAndFeel(nativeLF);
/*  67 */       SwingUtilities.updateComponentTreeUI(this);
/*     */     
/*     */     }
/*  70 */     catch (Exception e) {
/*  71 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/*  76 */     setLayout(this.gridBagLayout1);
/*  77 */     this.editorPane.setMargin(new Insets(5, 5, 5, 5));
/*  78 */     this.editorPane.setText("");
/*  79 */     this.editorPane.setContentType("text/html");
/*  80 */     this.editorPane.setMinimumSize(new Dimension(250, 100));
/*  81 */     this.editorPane.setPreferredSize(new Dimension(250, 100));
/*  82 */     this.editorPane.setCaretPosition(0);
/*     */     
/*  84 */     this.northPanel.setMinimumSize(new Dimension(10, 30));
/*  85 */     this.northPanel.setPreferredSize(new Dimension(10, 45));
/*  86 */     this.northPanel.setLayout(this.gridBagLayout2);
/*  87 */     this.lblDescription.setFont(new Font("Dialog", 1, 11));
/*  88 */     this.lblDescription.setText("Tour Description:");
/*  89 */     this.btnEdit.setFont(new Font("Dialog", 1, 11));
/*  90 */     this.btnEdit.setText("Edit");
/*  91 */     this.btnEdit.addActionListener(new TextEditPanel_btnEdit_actionAdapter(this));
/*  92 */     this.northPanel.add(this.lblDescription, new GridBagConstraints(0, 0, 1, 1, 0.1D, 1.0D, 
/*  93 */           16, 0, new Insets(5, 5, 10, 5), 0, 0));
/*  94 */     this.northPanel.add(this.btnEdit, new GridBagConstraints(1, 0, 1, 1, 3.0D, 0.0D, 
/*  95 */           16, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  96 */     add(this.scrollerEditorPane, new GridBagConstraints(0, 1, 1, 1, 1.0D, 1.0D, 
/*  97 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/*  98 */     add(this.northPanel, new GridBagConstraints(0, 0, 1, 1, 1.0D, 0.0D, 
/*  99 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/* 100 */     this.scrollerEditorPane.getViewport().add(this.editorPane, (Object)null);
/*     */   }
/*     */   
/*     */   protected class MyDocumentListener implements DocumentListener { final TextViewPanel this$0;
/*     */     
/*     */     protected MyDocumentListener(TextViewPanel this$0) {
/* 106 */       this.this$0 = this$0;
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
/* 118 */       this.this$0.editorPane.getCaret().setSelectionVisible(true);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateFormattedText() {
/*     */     try {
/* 126 */       String docText = this.editorPane.getDocument().getText(0, this.doc.getLength());
/* 127 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 128 */       this.editorPane.getEditorKit().write(baos, this.doc, 0, this.doc.getLength());
/* 129 */       this.formattedText = new String(baos.toByteArray());
/* 130 */       if (Global.getTour() != null)
/*     */       {
/* 132 */         Global.getTour().setDescription(this.formattedText);
/* 133 */         Global.getTour().setModified(true);
/*     */       }
/*     */     
/*     */     }
/* 137 */     catch (Exception ex) {
/*     */       
/* 139 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFormattedText() {
/* 145 */     return this.formattedText;
/*     */   }
/*     */   public void setFormattedText(String text) {
/* 148 */     this.formattedText = text;
/*     */     
/* 150 */     if (this.formattedText == null || this.formattedText.trim().equals("")) {
/*     */       
/* 152 */       this.editorPane.setText("");
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 158 */         this.editorPane.setText("");
/* 159 */         ByteArrayInputStream bais = new ByteArrayInputStream(this.formattedText.getBytes());
/* 160 */         this.editorPane.getEditorKit().read(bais, this.doc, 0);
/* 161 */         this.editorPane.setCaretPosition(0);
/*     */       }
/* 163 */       catch (Exception e) {
/*     */         
/* 165 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {
/* 176 */     if (Global.getTour() == null) {
/*     */       
/* 178 */       setFormattedText("");
/* 179 */       updateFormattedText();
/*     */     }
/*     */     else {
/*     */       
/* 183 */       setFormattedText(Global.getTour().getDescription());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {
/* 197 */     if (selectedPhoto != null && 
/* 198 */       selectedPhoto.getDescription() != null && 
/* 199 */       !Formatter.isHTMLEmpty(selectedPhoto.getDescription())) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 204 */       setFormattedText(Global.getPhoto().getDescription());
/* 205 */       this.lblDescription.setText("Photo Description:");
/* 206 */       this.lblDescription.setVisible(true);
/* 207 */       this.editorPane.setVisible(true);
/* 208 */       this.scrollerEditorPane.setVisible(true);
/* 209 */       setVisible(true);
/* 210 */       updateUI();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 217 */     else if (Global.getTour() == null) {
/*     */       
/* 219 */       setFormattedText("");
/* 220 */       updateFormattedText();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 225 */       setFormattedText(Global.getTour().getDescription());
/* 226 */       this.lblDescription.setText("Tour Description: ");
/*     */       
/* 228 */       if (Formatter.isHTMLEmpty(Global.getTour().getDescription()) && 
/* 229 */         Settings.getMode() == 1) {
/*     */         
/* 231 */         this.lblDescription.setVisible(false);
/* 232 */         this.scrollerEditorPane.setVisible(false);
/* 233 */         this.editorPane.setVisible(false);
/* 234 */         setVisible(false);
/* 235 */         updateUI();
/*     */       }
/*     */       else {
/*     */         
/* 239 */         this.lblDescription.setVisible(true);
/* 240 */         this.scrollerEditorPane.setVisible(true);
/* 241 */         this.editorPane.setVisible(true);
/* 242 */         setVisible(true);
/* 243 */         updateUI();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 248 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/* 260 */     if (Settings.getMode() == 0) {
/*     */       
/* 262 */       setVisible(true);
/* 263 */       this.editorPane.setVisible(true);
/* 264 */       this.lblDescription.setVisible(true);
/* 265 */       this.editorPane.setEditable(false);
/* 266 */       this.btnEdit.setVisible(true);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 272 */       this.editorPane.setEditable(false);
/*     */       
/* 274 */       if (Formatter.isHTMLEmpty(this.editorPane.getText()))
/*     */       {
/* 276 */         if (Global.getTour() == null || 
/* 277 */           Global.getTour().getDescription() == null || 
/* 278 */           Global.getTour().getDescription().trim().equals("") || 
/* 279 */           !Formatter.isHTMLEmpty(Global.getTour().getDescription())) {
/*     */ 
/*     */ 
/*     */           
/* 283 */           setVisible(false);
/* 284 */           this.editorPane.setVisible(false);
/* 285 */           this.lblDescription.setVisible(false);
/*     */         } 
/*     */       }
/* 288 */       this.btnEdit.setVisible(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnEdit_actionPerformed(ActionEvent e) {
/* 297 */     TextEditDialog ted = new TextEditDialog(VadosityToolkit.getInstance());
/* 298 */     if (Global.getTour() != null) ted.setFormattedText(Global.getTour().getDescription()); 
/* 299 */     ted.setModal(true);
/* 300 */     ted.setTitle("Edit Tour Description");
/* 301 */     int x = VadosityToolkit.getInstance().getX() + (VadosityToolkit.getInstance()).width / 2 - 200;
/* 302 */     int y = VadosityToolkit.getInstance().getY() + (VadosityToolkit.getInstance()).height / 2 - 200;
/* 303 */     ted.setLocation(x, y);
/* 304 */     ted.setSize(400, 400);
/* 305 */     ted.setVisible(true);
/*     */     
/* 307 */     int result = ted.getResult();
/* 308 */     if (result == 0 && Global.getTour() != null) {
/*     */       
/* 310 */       Global.getTour().setDescription(ted.getFormattedText());
/* 311 */       Global.getTour().setModified(true);
/* 312 */       setFormattedText(ted.getFormattedText());
/*     */     } 
/*     */ 
/*     */     
/* 316 */     this.lblDescription.setVisible(true);
/* 317 */     this.editorPane.setVisible(true);
/* 318 */     this.scrollerEditorPane.setVisible(true);
/* 319 */     this.btnEdit.setVisible(true);
/* 320 */     updateUI();
/* 321 */     settingsChanged(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\TextViewPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */