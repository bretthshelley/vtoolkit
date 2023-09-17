/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.text.StyledEditorKit;
/*     */ 
/*     */ public class TextEditDialog extends JDialog {
/*  15 */   BorderLayout borderLayout1 = new BorderLayout();
/*  16 */   JPanel toolBarPanel = new JPanel();
/*  17 */   JButton btnBold = new JButton();
/*  18 */   JButton btnItalic = new JButton();
/*  19 */   JButton btnUnderline = new JButton();
/*  20 */   JComboBox cbSize = new JComboBox();
/*  21 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  22 */   JComboBox cbStyle = new JComboBox();
/*  23 */   JEditorPane editorPane = new JEditorPane();
/*  24 */   JButton btnColor = new JButton();
/*  25 */   JButton btnRightJustify = new JButton();
/*  26 */   JButton btnCenterJustify = new JButton();
/*  27 */   JButton btnLeftJustify = new JButton();
/*  28 */   Photo photo = null;
/*     */   
/*  30 */   JPanel southPanel = new JPanel();
/*  31 */   JButton btnOk = new JButton();
/*  32 */   JButton btnCancel = new JButton();
/*     */   
/*  34 */   int selectedTab = 0;
/*     */   
/*  36 */   Color currentColor = Color.black;
/*  37 */   String formattedText = null;
/*     */   
/*     */   AbstractDocument doc;
/*     */   
/*     */   HashMap actionMap;
/*     */   
/*  43 */   Action size8Action = new StyledEditorKit.FontSizeAction("8", 8);
/*  44 */   Action size10Action = new StyledEditorKit.FontSizeAction("10", 10);
/*  45 */   Action size12Action = new StyledEditorKit.FontSizeAction("12", 12);
/*  46 */   Action size14Action = new StyledEditorKit.FontSizeAction("14", 14);
/*  47 */   Action size16Action = new StyledEditorKit.FontSizeAction("16", 16);
/*  48 */   Action size18Action = new StyledEditorKit.FontSizeAction("18", 18);
/*  49 */   Action size24Action = new StyledEditorKit.FontSizeAction("24", 24);
/*  50 */   Action size36Action = new StyledEditorKit.FontSizeAction("36", 36);
/*  51 */   Action size48Action = new StyledEditorKit.FontSizeAction("48", 48);
/*     */ 
/*     */   
/*  54 */   Action serifAction = new StyledEditorKit.FontFamilyAction("Serif", "Serif");
/*  55 */   Action sansSerifAction = new StyledEditorKit.FontFamilyAction("SansSerif", 
/*  56 */       "SansSerif");
/*  57 */   Action monospacedAction = new StyledEditorKit.FontFamilyAction("MonoSpaced", 
/*  58 */       "MonoSpaced");
/*     */ 
/*     */   
/*  61 */   Action rightJustifyAction = null;
/*  62 */   Action leftJustifyAction = null;
/*  63 */   Action centerJustifyAction = null;
/*     */   
/*  65 */   int result = 2;
/*     */   
/*     */   public int getResult() {
/*  68 */     return this.result;
/*     */   }
/*     */   
/*  71 */   JScrollPane scrollerEditorPane = new JScrollPane();
/*  72 */   BorderLayout borderLayout3 = new BorderLayout();
/*  73 */   JTabbedPane tabbedPane = new JTabbedPane();
/*  74 */   JPanel designPanel = new JPanel();
/*  75 */   BorderLayout borderLayout2 = new BorderLayout();
/*  76 */   JPanel htmlPanel = new JPanel();
/*  77 */   JScrollPane scrollerHtml = new JScrollPane();
/*  78 */   BorderLayout borderLayout4 = new BorderLayout();
/*  79 */   JTextArea taHtml = new JTextArea();
/*     */ 
/*     */   
/*     */   public TextEditDialog(Dialog dlg) {
/*  83 */     super(dlg);
/*  84 */     initTextEditDialog();
/*     */   }
/*     */ 
/*     */   
/*     */   public TextEditDialog(Frame frame) {
/*  89 */     super(frame);
/*  90 */     initTextEditDialog();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/*  98 */       TextEditDialog dlg = new TextEditDialog(new JFrame());
/*  99 */       dlg.setDefaultCloseOperation(2);
/* 100 */       dlg.setSize(400, 400);
/* 101 */       dlg.show();
/*     */     }
/* 103 */     catch (Exception e) {
/*     */       
/* 105 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initTextEditDialog() {
/*     */     try {
/* 113 */       jbInit();
/*     */ 
/*     */       
/* 116 */       this.editorPane.setContentType("text/html");
/* 117 */       this.doc = (AbstractDocument)this.editorPane.getDocument();
/*     */       
/* 119 */       createActionTable(this.editorPane);
/*     */       
/* 121 */       this.rightJustifyAction = getActionByName("right-justify");
/* 122 */       this.btnRightJustify.setAction(this.rightJustifyAction);
/* 123 */       this.btnRightJustify.setText("");
/*     */       
/* 125 */       setupSize();
/* 126 */       setupStyle();
/*     */ 
/*     */       
/* 129 */       Action boldAction = new StyledEditorKit.BoldAction();
/* 130 */       boldAction.putValue("Name", "B");
/* 131 */       this.btnBold.setAction(boldAction);
/*     */ 
/*     */       
/* 134 */       Action italicsAction = new StyledEditorKit.ItalicAction();
/* 135 */       italicsAction.putValue("Name", "I");
/* 136 */       this.btnItalic.setAction(italicsAction);
/* 137 */       ImageIcon italicIcon = new ImageIcon(
/* 138 */           ImageUtil.loadItalicImage());
/* 139 */       this.btnItalic.setIcon(italicIcon);
/* 140 */       this.btnItalic.setText("");
/*     */ 
/*     */       
/* 143 */       Action underlineAction = new StyledEditorKit.UnderlineAction();
/* 144 */       this.btnUnderline.setAction(underlineAction);
/* 145 */       this.btnUnderline.setText("<html><b><u>U</u></b></html>");
/* 146 */       this.btnUnderline.setToolTipText("Underline");
/*     */ 
/*     */       
/* 149 */       ImageIcon colorIcon = new ImageIcon(
/* 150 */           ImageUtil.loadColorsImage());
/* 151 */       this.btnColor.setIcon(colorIcon);
/*     */       
/* 153 */       Action alignright = new StyledEditorKit.AlignmentAction("Right Justify", 
/* 154 */           2);
/* 155 */       this.btnRightJustify.setAction(alignright);
/* 156 */       ImageIcon rightJustifyIcon = new ImageIcon(
/* 157 */           ImageUtil.loadRightJustifyImage());
/* 158 */       this.btnRightJustify.setIcon(rightJustifyIcon);
/* 159 */       this.btnRightJustify.setText("");
/* 160 */       this.btnRightJustify.setToolTipText("Align Right");
/*     */       
/* 162 */       this.btnCenterJustify.setAction(getActionByName("center-justify"));
/* 163 */       ImageIcon centerJustifyIcon = new ImageIcon(
/* 164 */           ImageUtil.loadCenterJustifyImage());
/* 165 */       this.btnCenterJustify.setIcon(centerJustifyIcon);
/* 166 */       this.btnCenterJustify.setText("");
/* 167 */       this.btnCenterJustify.setToolTipText("Align Center");
/*     */       
/* 169 */       this.btnLeftJustify.setAction(getActionByName("left-justify"));
/* 170 */       this.btnLeftJustify.setIcon(new ImageIcon(
/* 171 */             ImageUtil.loadLeftJustifyImage()));
/* 172 */       this.btnLeftJustify.setText("");
/* 173 */       this.btnLeftJustify.setToolTipText("Align Left");
/*     */       
/* 175 */       this.doc.addDocumentListener(new MyDocumentListener(this));
/*     */       
/* 177 */       this.editorPane.requestFocus();
/* 178 */       this.editorPane.setCaretPosition(0);
/*     */ 
/*     */       
/* 181 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/* 182 */       UIManager.setLookAndFeel(nativeLF);
/* 183 */       SwingUtilities.updateComponentTreeUI(this);
/*     */     
/*     */     }
/* 186 */     catch (Exception e) {
/*     */       
/* 188 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setupSize() {
/* 194 */     this.cbSize.addItem(new Integer("8"));
/* 195 */     this.cbSize.addItem(new Integer("10"));
/* 196 */     this.cbSize.addItem(new Integer("12"));
/* 197 */     this.cbSize.addItem(new Integer("14"));
/* 198 */     this.cbSize.addItem(new Integer("16"));
/* 199 */     this.cbSize.addItem(new Integer("18"));
/* 200 */     this.cbSize.addItem(new Integer("24"));
/* 201 */     this.cbSize.addItem(new Integer("36"));
/* 202 */     this.cbSize.addItem(new Integer("48"));
/* 203 */     this.cbSize.setSelectedIndex(2);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setupStyle() {
/* 208 */     this.cbStyle.addItem("Serif");
/* 209 */     this.cbStyle.addItem("SansSerif");
/* 210 */     this.cbStyle.addItem("Monospaced");
/* 211 */     this.cbStyle.setSelectedIndex(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createActionTable(JTextComponent textComponent) {
/* 218 */     this.actionMap = new HashMap();
/* 219 */     Action[] actionsArray = textComponent.getActions();
/* 220 */     for (int i = 0; i < actionsArray.length; i++) {
/*     */       
/* 222 */       Action a = actionsArray[i];
/* 223 */       this.actionMap.put(a.getValue("Name"), a);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Action getActionByName(String name) {
/* 229 */     return (Action)this.actionMap.get(name);
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 234 */     getContentPane().setLayout(this.borderLayout1);
/* 235 */     this.toolBarPanel.setMinimumSize(new Dimension(275, 30));
/* 236 */     this.toolBarPanel.setPreferredSize(new Dimension(275, 30));
/* 237 */     this.toolBarPanel.setLayout(this.gridBagLayout1);
/* 238 */     this.btnBold.setFont(new Font("Dialog", 1, 11));
/* 239 */     this.btnBold.setMaximumSize(new Dimension(25, 25));
/* 240 */     this.btnBold.setMinimumSize(new Dimension(25, 25));
/* 241 */     this.btnBold.setPreferredSize(new Dimension(25, 25));
/* 242 */     this.btnBold.setMargin(new Insets(2, 4, 2, 4));
/* 243 */     this.btnBold.setText("B");
/* 244 */     this.btnBold.addActionListener(new TextEditDialog_btnBold_actionAdapter(this));
/* 245 */     this.btnItalic.setFont(new Font("Dialog", 2, 11));
/* 246 */     this.btnItalic.setMaximumSize(new Dimension(25, 25));
/* 247 */     this.btnItalic.setMinimumSize(new Dimension(25, 25));
/* 248 */     this.btnItalic.setPreferredSize(new Dimension(25, 25));
/* 249 */     this.btnItalic.setMargin(new Insets(2, 4, 2, 4));
/* 250 */     this.btnItalic.setText("I");
/* 251 */     this.btnItalic.addActionListener(new TextEditDialog_btnItalic_actionAdapter(this));
/* 252 */     this.btnUnderline.setMaximumSize(new Dimension(25, 25));
/* 253 */     this.btnUnderline.setMinimumSize(new Dimension(25, 25));
/* 254 */     this.btnUnderline.setPreferredSize(new Dimension(25, 25));
/* 255 */     this.btnUnderline.setMargin(new Insets(2, 4, 2, 4));
/* 256 */     this.btnUnderline.setText("UL");
/* 257 */     this.btnUnderline.addActionListener(
/* 258 */         new TextEditDialog_btnUnderline_actionAdapter(this));
/* 259 */     this.cbSize.setMinimumSize(new Dimension(40, 25));
/* 260 */     this.cbSize.setPreferredSize(new Dimension(40, 25));
/* 261 */     this.cbSize.addActionListener(new TextEditDialog_cbSize_actionAdapter(this));
/* 262 */     this.cbStyle.setMinimumSize(new Dimension(80, 25));
/* 263 */     this.cbStyle.setPreferredSize(new Dimension(80, 25));
/* 264 */     this.cbStyle.addActionListener(new TextEditDialog_cbStyle_actionAdapter(this));
/* 265 */     this.editorPane.setMargin(new Insets(5, 5, 5, 5));
/* 266 */     this.editorPane.setText("");
/* 267 */     this.editorPane.setContentType("text/html");
/* 268 */     this.editorPane.addInputMethodListener(
/* 269 */         new TextEditDialog_editorPane_inputMethodAdapter(this));
/* 270 */     this.editorPane.addKeyListener(new TextEditDialog_editorPane_keyAdapter(this));
/* 271 */     this.editorPane.addFocusListener(new TextEditDialog_editorPane_focusAdapter(this));
/* 272 */     this.editorPane.setMinimumSize(new Dimension(250, 100));
/* 273 */     this.editorPane.setPreferredSize(new Dimension(250, 100));
/* 274 */     this.editorPane.setCaretPosition(0);
/*     */     
/* 276 */     this.btnColor.setMaximumSize(new Dimension(25, 25));
/* 277 */     this.btnColor.setMinimumSize(new Dimension(25, 25));
/* 278 */     this.btnColor.setPreferredSize(new Dimension(25, 25));
/* 279 */     this.btnColor.setText("");
/* 280 */     this.btnColor.addActionListener(new TextEditDialog_btnColor_actionAdapter(this));
/* 281 */     this.btnRightJustify.setMaximumSize(new Dimension(25, 25));
/* 282 */     this.btnRightJustify.setMinimumSize(new Dimension(25, 25));
/* 283 */     this.btnRightJustify.setPreferredSize(new Dimension(25, 25));
/* 284 */     this.btnRightJustify.setText("");
/* 285 */     this.btnRightJustify.addActionListener(
/* 286 */         new TextEditDialog_btnRightJustify_actionAdapter(this));
/* 287 */     this.btnCenterJustify.setMaximumSize(new Dimension(25, 25));
/* 288 */     this.btnCenterJustify.setMinimumSize(new Dimension(25, 25));
/* 289 */     this.btnCenterJustify.setPreferredSize(new Dimension(25, 25));
/* 290 */     this.btnCenterJustify.setMnemonic('0');
/* 291 */     this.btnCenterJustify.setText("");
/* 292 */     this.btnCenterJustify.addActionListener(
/* 293 */         new TextEditDialog_btnCenterJustify_actionAdapter(this));
/* 294 */     this.btnLeftJustify.setMaximumSize(new Dimension(25, 25));
/* 295 */     this.btnLeftJustify.setMinimumSize(new Dimension(25, 25));
/* 296 */     this.btnLeftJustify.setPreferredSize(new Dimension(25, 25));
/* 297 */     this.btnLeftJustify.setText("");
/* 298 */     this.btnLeftJustify.addActionListener(
/* 299 */         new TextEditDialog_btnLeftJustify_actionAdapter(this));
/* 300 */     this.southPanel.setMinimumSize(new Dimension(10, 40));
/* 301 */     this.southPanel.setPreferredSize(new Dimension(10, 40));
/* 302 */     this.btnOk.setText("OK");
/* 303 */     this.btnOk.addActionListener(new TextEditDialog_btnOk_actionAdapter(this));
/* 304 */     this.btnCancel.setText("Cancel");
/* 305 */     this.btnCancel.addActionListener(new TextEditDialog_btnCancel_actionAdapter(this));
/* 306 */     addWindowListener(new TextEditDialog_this_windowAdapter(this));
/* 307 */     this.tabbedPane.setTabPlacement(3);
/* 308 */     this.tabbedPane.addChangeListener(new TextEditDialog_tabbedPane_changeAdapter(this));
/* 309 */     this.designPanel.setLayout(this.borderLayout2);
/* 310 */     this.htmlPanel.setLayout(this.borderLayout4);
/* 311 */     this.taHtml.setText("");
/* 312 */     this.taHtml.setLineWrap(true);
/* 313 */     this.taHtml.setWrapStyleWord(true);
/* 314 */     this.taHtml.addFocusListener(new TextEditDialog_taHtml_focusAdapter(this));
/* 315 */     this.southPanel.add(this.btnCancel, (Object)null);
/* 316 */     this.southPanel.add(this.btnOk, (Object)null);
/* 317 */     getContentPane().add(this.tabbedPane, "Center");
/* 318 */     this.toolBarPanel.add(this.btnBold, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 
/* 319 */           10, 0, 
/* 320 */           new Insets(5, 0, 5, 0), 0, 0));
/* 321 */     this.toolBarPanel.add(this.btnItalic, new GridBagConstraints(3, 0, 1, 1, 0.0D, 0.0D, 
/* 322 */           10, 0, 
/* 323 */           new Insets(5, 0, 5, 0), 0, 0));
/* 324 */     this.toolBarPanel.add(this.cbStyle, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 325 */           10, 0, 
/* 326 */           new Insets(5, 0, 5, 0), 0, 0));
/* 327 */     this.toolBarPanel.add(this.cbSize, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/* 328 */           10, 0, 
/* 329 */           new Insets(5, 3, 5, 3), 0, 0));
/* 330 */     this.toolBarPanel.add(this.btnUnderline, new GridBagConstraints(4, 0, 1, 1, 0.0D, 0.0D, 
/* 331 */           10, 0, 
/* 332 */           new Insets(5, 0, 5, 0), 0, 0));
/* 333 */     this.toolBarPanel.add(this.btnColor, new GridBagConstraints(5, 0, 1, 1, 0.0D, 0.0D, 
/* 334 */           10, 0, 
/* 335 */           new Insets(0, 0, 0, 0), 0, 0));
/* 336 */     this.toolBarPanel.add(this.btnLeftJustify, 
/* 337 */         new GridBagConstraints(6, 0, 1, 1, 0.0D, 0.0D, 
/* 338 */           10, 
/* 339 */           0, 
/* 340 */           new Insets(0, 0, 0, 0), 0, 0));
/* 341 */     this.toolBarPanel.add(this.btnCenterJustify, 
/* 342 */         new GridBagConstraints(7, 0, 1, 1, 0.0D, 0.0D, 
/* 343 */           10, 
/* 344 */           0, 
/* 345 */           new Insets(0, 0, 0, 0), 0, 0));
/* 346 */     this.toolBarPanel.add(this.btnRightJustify, 
/* 347 */         new GridBagConstraints(8, 0, 1, 1, 0.0D, 0.0D, 
/* 348 */           10, 
/* 349 */           0, 
/* 350 */           new Insets(0, 0, 0, 0), 0, 0));
/* 351 */     this.designPanel.add(this.scrollerEditorPane, "Center");
/* 352 */     this.scrollerEditorPane.getViewport().add(this.editorPane, (Object)null);
/* 353 */     getContentPane().add(this.southPanel, "South");
/* 354 */     this.tabbedPane.add(this.designPanel, "<html><b>Design</b></html>");
/* 355 */     this.tabbedPane.add(this.htmlPanel, "<html><b>HTML</b></html>");
/* 356 */     this.designPanel.add(this.toolBarPanel, "North");
/* 357 */     this.htmlPanel.add(this.scrollerHtml, "Center");
/* 358 */     this.scrollerHtml.getViewport().add(this.taHtml, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void cbSize_actionPerformed(ActionEvent e) {
/* 365 */     Object object = this.cbSize.getSelectedItem();
/* 366 */     if (object.equals("8")) {
/*     */       
/* 368 */       this.size8Action.actionPerformed(new ActionEvent(this, 8, "8"));
/*     */     }
/* 370 */     else if (object.equals("10")) {
/*     */       
/* 372 */       this.size10Action.actionPerformed(new ActionEvent(this, 10, "10"));
/*     */     }
/* 374 */     else if (object.equals("12")) {
/*     */       
/* 376 */       this.size12Action.actionPerformed(new ActionEvent(this, 12, "11"));
/*     */     }
/* 378 */     else if (object.equals("14")) {
/*     */       
/* 380 */       this.size14Action.actionPerformed(new ActionEvent(this, 14, "14"));
/*     */     }
/* 382 */     else if (object.equals("16")) {
/*     */       
/* 384 */       this.size16Action.actionPerformed(new ActionEvent(this, 16, "16"));
/*     */     }
/* 386 */     else if (object.equals("18")) {
/*     */       
/* 388 */       this.size18Action.actionPerformed(new ActionEvent(this, 18, "18"));
/*     */     }
/* 390 */     else if (object.equals("24")) {
/*     */       
/* 392 */       this.size24Action.actionPerformed(new ActionEvent(this, 24, "24"));
/*     */     }
/* 394 */     else if (object.equals("36")) {
/*     */       
/* 396 */       this.size36Action.actionPerformed(new ActionEvent(this, 36, "36"));
/*     */     }
/* 398 */     else if (object.equals("48")) {
/*     */       
/* 400 */       this.size48Action.actionPerformed(new ActionEvent(this, 48, "48"));
/*     */     } 
/* 402 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */   
/*     */   public void btnCancel_actionPerformed(ActionEvent e) {
/* 407 */     this.result = 2;
/* 408 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void cbStyle_actionPerformed(ActionEvent e) {
/* 413 */     String value = (String)this.cbStyle.getSelectedItem();
/* 414 */     if (value.equals("Serif")) {
/*     */       
/* 416 */       this.serifAction.actionPerformed(new ActionEvent(this, 50, "Serif"));
/*     */     }
/* 418 */     else if (value.equals("SansSerif")) {
/*     */       
/* 420 */       this.sansSerifAction.actionPerformed(new ActionEvent(this, 60, 
/* 421 */             "SansSerif"));
/*     */     }
/* 423 */     else if (value.equals("Monospaced")) {
/*     */       
/* 425 */       this.monospacedAction.actionPerformed(new ActionEvent(this, 70, 
/* 426 */             "Monospaced"));
/*     */     } 
/* 428 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void btnColor_actionPerformed(ActionEvent e) {
/* 434 */     String title = "Select Text Color";
/* 435 */     Color color = JColorChooser.showDialog(this, title, this.currentColor);
/* 436 */     if (color == null) {
/*     */       return;
/*     */     }
/*     */     
/* 440 */     this.currentColor = color;
/*     */     
/* 442 */     Action colorAction = new StyledEditorKit.ForegroundAction("Color", color);
/* 443 */     colorAction.actionPerformed(new ActionEvent(this, 90, "Color"));
/* 444 */     getTextFromDesigner();
/*     */   }
/*     */   protected class MyDocumentListener implements DocumentListener { final TextEditDialog this$0;
/*     */     
/*     */     protected MyDocumentListener(TextEditDialog this$0) {
/* 449 */       this.this$0 = this$0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void insertUpdate(DocumentEvent e) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeUpdate(DocumentEvent e) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void changedUpdate(DocumentEvent e) {
/* 463 */       this.this$0.editorPane.getCaret().setSelectionVisible(true);
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   void this_windowClosing(WindowEvent e) {
/* 469 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnOk_actionPerformed(ActionEvent e) {
/* 474 */     getTextFromDesigner();
/* 475 */     if (this.photo != null) this.photo.setDescription(this.formattedText); 
/* 476 */     this.result = 0;
/* 477 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnLeftJustify_actionPerformed(ActionEvent e) {
/* 482 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void btnCenterJustify_actionPerformed(ActionEvent e) {
/* 488 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void getTextFromDesigner() {
/*     */     try {
/* 495 */       String docText = this.editorPane.getDocument().getText(0, this.doc.getLength());
/* 496 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 497 */       this.editorPane.getEditorKit().write(baos, this.doc, 0, this.doc.getLength());
/* 498 */       this.formattedText = new String(baos.toByteArray());
/*     */       
/* 500 */       this.taHtml.setText(this.formattedText);
/* 501 */       this.taHtml.updateUI();
/*     */     }
/* 503 */     catch (Exception ex) {
/*     */       
/* 505 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void getTextFromHtmlTextArea() {
/*     */     try {
/* 514 */       this.formattedText = this.taHtml.getText();
/* 515 */       setFormattedText(this.formattedText);
/*     */     }
/* 517 */     catch (Exception ex) {
/*     */       
/* 519 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormattedText() {
/* 526 */     return this.formattedText;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFormattedText(String text) {
/* 531 */     this.formattedText = text;
/*     */ 
/*     */     
/*     */     try {
/* 535 */       this.editorPane.setText("");
/* 536 */       this.editorPane.updateUI();
/*     */       
/* 538 */       ByteArrayInputStream bais = new ByteArrayInputStream(
/* 539 */           this.formattedText.getBytes());
/* 540 */       this.editorPane.getEditorKit().read(bais, this.doc, 0);
/* 541 */       this.taHtml.setText(this.formattedText);
/* 542 */       this.editorPane.updateUI();
/* 543 */       this.taHtml.updateUI();
/*     */     }
/* 545 */     catch (Exception e) {
/*     */       
/* 547 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void btnBold_actionPerformed(ActionEvent e) {
/* 553 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */   
/*     */   void editorPane_focusLost(FocusEvent e) {
/* 558 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnUnderline_actionPerformed(ActionEvent e) {
/* 563 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnItalic_actionPerformed(ActionEvent e) {
/* 568 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnRightJustify_actionPerformed(ActionEvent e) {
/* 573 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnNewLine_actionPerformed(ActionEvent e) {
/* 578 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */   
/*     */   void btnLineBreak_actionPerformed(ActionEvent e) {
/* 583 */     insertLineBreak();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertLineBreak() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void editorPane_keyTyped(KeyEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void tabbedPane_stateChanged(ChangeEvent e) {
/* 609 */     if (this.tabbedPane.getSelectedIndex() == 1) {
/*     */       
/* 611 */       getTextFromDesigner();
/* 612 */       this.taHtml.setText(getFormattedText());
/* 613 */       this.taHtml.updateUI();
/*     */     }
/*     */     else {
/*     */       
/* 617 */       getTextFromHtmlTextArea();
/* 618 */       this.taHtml.setText(getFormattedText());
/* 619 */       this.taHtml.updateUI();
/*     */     } 
/* 621 */     this.selectedTab = this.tabbedPane.getSelectedIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   void taHtml_focusLost(FocusEvent e) {
/* 626 */     getTextFromHtmlTextArea();
/*     */   }
/*     */ 
/*     */   
/*     */   void editorPane_caretPositionChanged(InputMethodEvent e) {
/* 631 */     getTextFromDesigner();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Photo getPhoto() {
/* 639 */     return this.photo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPhoto(Photo photo) {
/* 645 */     this.photo = photo;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\TextEditDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */