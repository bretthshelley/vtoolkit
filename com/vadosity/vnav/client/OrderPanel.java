/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class OrderPanel extends JPanel implements GlobalChangeListener {
/*  14 */   JScrollPane jScrollPane1 = new JScrollPane();
/*  15 */   JList listOrder = new JList();
/*  16 */   Vector vListeners = new Vector();
/*     */   boolean recording = false;
/*  18 */   Vector vOrder = new Vector();
/*     */   Vector v; GridBagLayout gridBagLayout1; JButton btnResetOrder; JLabel lblPathOrder; JPanel instructionPanel; GridBagLayout gridBagLayout2; JLabel lblSelectPhotos; JLabel lblUpArrow; JLabel lblDownArrow; private boolean activated; JPanel jPanel1; JLabel lblAdded; JButton btnStartRecording;
/*     */   JButton btnCancel;
/*     */   GridBagLayout gridBagLayout3;
/*     */   JLabel lblRemaining;
/*     */   JLabel lblClickToStart;
/*     */   JLabel lblMouseOver;
/*     */   JLabel lblCancelRecording;
/*     */   JPanel jPanel2;
/*     */   TitledBorder titledBorderTweakOrder;
/*     */   GridBagLayout gridBagLayout4;
/*     */   TitledBorder titledBorderToRecordOrder;
/*     */   ImagePanel panelUp;
/*     */   ImagePanel panelDown;
/*     */   ImagePanel panelAlt1;
/*     */   ImagePanel panelAlt2;
/*     */   JLabel jLabel1;
/*     */   JLabel jLabel2;
/*     */   JLabel jLabel3;
/*     */   JLabel jLabel4;
/*     */   
/*  39 */   public OrderPanel() { this.v = new Vector();
/*  40 */     this.gridBagLayout1 = new GridBagLayout();
/*  41 */     this.btnResetOrder = new JButton();
/*  42 */     this.lblPathOrder = new JLabel();
/*  43 */     this.instructionPanel = new JPanel();
/*  44 */     this.gridBagLayout2 = new GridBagLayout();
/*  45 */     this.lblSelectPhotos = new JLabel();
/*  46 */     this.lblUpArrow = new JLabel();
/*  47 */     this.lblDownArrow = new JLabel();
/*     */     
/*  49 */     this.activated = false;
/*  50 */     this.jPanel1 = new JPanel();
/*  51 */     this.lblAdded = new JLabel();
/*  52 */     this.btnStartRecording = new JButton();
/*  53 */     this.btnCancel = new JButton();
/*  54 */     this.gridBagLayout3 = new GridBagLayout();
/*  55 */     this.lblRemaining = new JLabel();
/*  56 */     this.lblClickToStart = new JLabel();
/*  57 */     this.lblMouseOver = new JLabel();
/*  58 */     this.lblCancelRecording = new JLabel();
/*  59 */     this.jPanel2 = new JPanel();
/*     */     
/*  61 */     this.gridBagLayout4 = new GridBagLayout();
/*     */     
/*  63 */     this.panelUp = new ImagePanel();
/*  64 */     this.panelDown = new ImagePanel();
/*  65 */     this.panelAlt1 = new ImagePanel();
/*  66 */     this.panelAlt2 = new ImagePanel();
/*  67 */     this.jLabel1 = new JLabel();
/*  68 */     this.jLabel2 = new JLabel();
/*  69 */     this.jLabel3 = new JLabel();
/*  70 */     this.jLabel4 = new JLabel(); try { jbInit(); Global.addGlobalChangeListener(this); setupList(); this.panelUp.setImage(ImageUtil.loadUpArrowButtonImage()); this.panelDown.setImage(ImageUtil.loadDownArrowButtonImage()); this.panelAlt1.setImage(ImageUtil.loadAltButtonImage()); this.panelAlt2.setImage(ImageUtil.loadAltButtonImage()); } catch (Exception e) { e.printStackTrace(); }
/*  71 */      } public boolean isActivated() { return this.activated; }
/*     */   
/*     */   public void setActivated(boolean b) {
/*  74 */     if (b) {
/*     */ 
/*     */       
/*  77 */       Global.addGlobalChangeListener(this);
/*  78 */       setupList();
/*  79 */       if (Global.getView() != null && !Global.getView().isPhotoOrderSet())
/*     */       {
/*  81 */         Global.getView().setPhotoOrderSet(true);
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/*  87 */       Global.removeGlobalChangeListener(this);
/*  88 */       this.listOrder.removeAll();
/*     */     } 
/*  90 */     this.activated = b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setupList() {
/*  97 */     if (Global.getTour() == null || Global.getView() == null) {
/*     */       
/*  99 */       this.listOrder.setListData(new Vector());
/* 100 */       this.listOrder.updateUI();
/*     */       
/*     */       return;
/*     */     } 
/* 104 */     this.v = Global.getView().getPhotos();
/* 105 */     this.listOrder.setListData(this.v);
/* 106 */     if (Global.getPhoto() != null) this.listOrder.setSelectedValue(Global.getPhoto(), true); 
/* 107 */     this.listOrder.updateUI();
/*     */   }
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {}
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {
/* 113 */     if (selectedView == null) {
/*     */       
/* 115 */       this.listOrder.setListData(new Vector());
/* 116 */       this.listOrder.updateUI();
/*     */       return;
/*     */     } 
/* 119 */     setupList();
/*     */   }
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {
/* 123 */     if (selectedPhoto == null)
/*     */       return; 
/* 125 */     if (this.recording) {
/*     */ 
/*     */       
/* 128 */       if (this.vOrder.contains(selectedPhoto))
/* 129 */         return;  this.vOrder.add(selectedPhoto);
/* 130 */       this.listOrder.setListData(this.vOrder);
/* 131 */       this.listOrder.setSelectedValue(selectedPhoto, true);
/* 132 */       this.listOrder.updateUI();
/* 133 */       this.lblAdded.setText("Added: " + this.vOrder.size());
/* 134 */       int remaining = Global.getView().getNumberOfPhotos() - this.vOrder.size();
/* 135 */       this.lblRemaining.setText("Remaining: " + remaining);
/*     */       
/* 137 */       if (this.vOrder.size() == Global.getView().getNumberOfPhotos())
/*     */       {
/* 139 */         String message = "Finished!\n\nAll Photos have been added.\n\nSelect 'Start Recording' to try again";
/* 140 */         String title = "Order has been set";
/* 141 */         JOptionPane.showMessageDialog(this, message);
/* 142 */         this.btnStartRecording.setEnabled(true);
/* 143 */         this.btnCancel.setEnabled(false);
/* 144 */         this.recording = false;
/*     */         
/* 146 */         Global.getView().setOrder(this.vOrder);
/* 147 */         setupList();
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 153 */       if (equals(src))
/* 154 */         return;  this.listOrder.setSelectedValue(selectedPhoto, true);
/*     */     } 
/*     */   }
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */   
/*     */   private void jbInit() throws Exception {
/* 160 */     this.titledBorderTweakOrder = new TitledBorder("");
/* 161 */     this.titledBorderToRecordOrder = new TitledBorder("");
/* 162 */     setLayout(this.gridBagLayout1);
/* 163 */     this.jScrollPane1.setMinimumSize(new Dimension(160, 160));
/* 164 */     this.jScrollPane1.setPreferredSize(new Dimension(180, 200));
/* 165 */     this.listOrder.addKeyListener(new OrderPanel_listOrder_keyAdapter(this));
/* 166 */     this.listOrder.addListSelectionListener(new OrderPanel_listOrder_listSelectionAdapter(this));
/* 167 */     this.listOrder.setMinimumSize(new Dimension(0, 0));
/* 168 */     this.btnResetOrder.setText("Reset Order");
/* 169 */     this.btnResetOrder.addActionListener(new OrderPanel_btnResetOrder_actionAdapter(this));
/* 170 */     this.lblPathOrder.setFont(new Font("Dialog", 1, 11));
/* 171 */     this.lblPathOrder.setText("Photo Order");
/* 172 */     this.instructionPanel.setBorder(this.titledBorderToRecordOrder);
/* 173 */     this.instructionPanel.setMinimumSize(new Dimension(400, 100));
/* 174 */     this.instructionPanel.setOpaque(true);
/* 175 */     this.instructionPanel.setPreferredSize(new Dimension(400, 100));
/* 176 */     this.instructionPanel.setLayout(this.gridBagLayout2);
/* 177 */     this.lblSelectPhotos.setFont(new Font("Dialog", 0, 12));
/* 178 */     this.lblSelectPhotos.setText("* Select photos in list");
/* 179 */     this.lblUpArrow.setFont(new Font("Dialog", 0, 12));
/* 180 */     this.lblUpArrow.setToolTipText("");
/* 181 */     this.lblUpArrow.setText("keys to move photo(s) up in order");
/* 182 */     this.lblDownArrow.setFont(new Font("Dialog", 0, 12));
/* 183 */     this.lblDownArrow.setText("keys to move photo(s) down");
/* 184 */     this.jPanel1.setLayout(this.gridBagLayout3);
/* 185 */     this.jPanel1.setPreferredSize(new Dimension(180, 200));
/* 186 */     this.jPanel1.setMinimumSize(new Dimension(180, 200));
/* 187 */     this.lblAdded.setEnabled(false);
/* 188 */     this.lblAdded.setRequestFocusEnabled(true);
/* 189 */     this.lblAdded.setText("Added:");
/* 190 */     this.btnStartRecording.setText("Start Recording");
/* 191 */     this.btnStartRecording.addActionListener(new OrderPanel_btnStartRecording_actionAdapter(this));
/* 192 */     this.btnCancel.setEnabled(false);
/* 193 */     this.btnCancel.setText("Cancel Recording");
/* 194 */     this.btnCancel.addActionListener(new OrderPanel_btnCancel_actionAdapter(this));
/* 195 */     this.lblRemaining.setEnabled(false);
/* 196 */     this.lblRemaining.setText("Remaining:");
/* 197 */     this.lblClickToStart.setFont(new Font("Dialog", 0, 12));
/* 198 */     this.lblClickToStart.setText("* Click the 'Start Recording' button");
/* 199 */     this.lblMouseOver.setFont(new Font("Dialog", 0, 12));
/* 200 */     this.lblMouseOver.setText("* Mouse over all photos in desired order");
/* 201 */     this.lblCancelRecording.setFont(new Font("Dialog", 0, 12));
/* 202 */     this.lblCancelRecording.setToolTipText("");
/* 203 */     this.lblCancelRecording.setText("* Cancel by clicking 'Cancel Recording' button");
/* 204 */     this.jPanel2.setBorder(this.titledBorderTweakOrder);
/* 205 */     this.jPanel2.setMinimumSize(new Dimension(360, 100));
/* 206 */     this.jPanel2.setPreferredSize(new Dimension(360, 110));
/* 207 */     this.jPanel2.setRequestFocusEnabled(true);
/* 208 */     this.jPanel2.setLayout(this.gridBagLayout4);
/* 209 */     this.titledBorderTweakOrder.setTitleFont(new Font("Dialog", 1, 12));
/* 210 */     this.titledBorderTweakOrder.setTitle("To 'Tweak' Order");
/* 211 */     this.titledBorderTweakOrder.setBorder(BorderFactory.createEtchedBorder());
/* 212 */     this.titledBorderToRecordOrder.setTitleFont(new Font("Dialog", 1, 12));
/* 213 */     this.titledBorderToRecordOrder.setTitle("To Record Order");
/* 214 */     setMinimumSize(new Dimension(760, 215));
/* 215 */     setPreferredSize(new Dimension(760, 225));
/* 216 */     this.panelUp.setMinimumSize(new Dimension(25, 25));
/* 217 */     this.panelUp.setPreferredSize(new Dimension(25, 25));
/* 218 */     this.panelDown.setMinimumSize(new Dimension(25, 25));
/* 219 */     this.panelDown.setPreferredSize(new Dimension(25, 25));
/* 220 */     this.panelAlt1.setMinimumSize(new Dimension(25, 25));
/* 221 */     this.panelAlt1.setPreferredSize(new Dimension(25, 25));
/* 222 */     this.panelAlt2.setMinimumSize(new Dimension(25, 25));
/* 223 */     this.panelAlt2.setPreferredSize(new Dimension(25, 25));
/* 224 */     this.jLabel1.setFont(new Font("Dialog", 1, 12));
/* 225 */     this.jLabel1.setText("+");
/* 226 */     this.jLabel2.setFont(new Font("Dialog", 1, 12));
/* 227 */     this.jLabel2.setText("+");
/* 228 */     this.jLabel3.setText("*");
/* 229 */     this.jLabel4.setText("*");
/* 230 */     add(this.jScrollPane1, new GridBagConstraints(0, 1, 1, 2, 0.0D, 0.0D, 
/* 231 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 232 */     add(this.lblPathOrder, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 233 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 234 */     add(this.instructionPanel, new GridBagConstraints(3, 1, 1, 1, 0.0D, 0.0D, 
/* 235 */           13, 1, new Insets(0, 0, 0, 0), 0, 0));
/* 236 */     this.jScrollPane1.getViewport().add(this.listOrder, (Object)null);
/* 237 */     this.instructionPanel.add(this.lblClickToStart, new GridBagConstraints(0, 1, 1, 1, 1.0D, 0.0D, 
/* 238 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 239 */     this.instructionPanel.add(this.lblMouseOver, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 240 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 241 */     this.instructionPanel.add(this.lblCancelRecording, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/* 242 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 243 */     add(this.jPanel1, new GridBagConstraints(2, 1, 1, 2, 0.0D, 0.0D, 
/* 244 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 245 */     this.jPanel1.add(this.btnCancel, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/* 246 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 247 */     this.jPanel1.add(this.btnStartRecording, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 248 */           13, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 249 */     this.jPanel1.add(this.lblAdded, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 250 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 251 */     this.jPanel1.add(this.lblRemaining, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 252 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 253 */     this.jPanel1.add(this.btnResetOrder, new GridBagConstraints(0, 4, 2, 1, 0.0D, 0.0D, 
/* 254 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 255 */     add(this.jPanel2, new GridBagConstraints(3, 2, 1, 1, 0.0D, 0.0D, 
/* 256 */           10, 1, new Insets(0, 0, 0, 0), 0, 0));
/* 257 */     this.jPanel2.add(this.lblSelectPhotos, new GridBagConstraints(0, 0, 5, 1, 1.0D, 0.0D, 
/* 258 */           17, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 259 */     this.jPanel2.add(this.lblUpArrow, new GridBagConstraints(4, 1, 1, 1, 0.0D, 0.0D, 
/* 260 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 261 */     this.jPanel2.add(this.lblDownArrow, new GridBagConstraints(4, 2, 1, 1, 0.0D, 0.0D, 
/* 262 */           17, 1, new Insets(5, 5, 5, 5), 0, 0));
/* 263 */     this.jPanel2.add(this.panelUp, new GridBagConstraints(3, 1, 1, 1, 0.0D, 0.0D, 
/* 264 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 265 */     this.jPanel2.add(this.panelAlt1, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 
/* 266 */           10, 0, new Insets(0, 5, 0, 0), 0, 0));
/* 267 */     this.jPanel2.add(this.panelAlt2, new GridBagConstraints(1, 2, 1, 1, 0.0D, 0.0D, 
/* 268 */           10, 0, new Insets(0, 5, 0, 0), 0, 0));
/* 269 */     this.jPanel2.add(this.jLabel1, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/* 270 */           10, 0, new Insets(0, 2, 0, 2), 1, -1));
/* 271 */     this.jPanel2.add(this.panelDown, new GridBagConstraints(3, 2, 1, 1, 0.0D, 0.0D, 
/* 272 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 273 */     this.jPanel2.add(this.jLabel2, new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 
/* 274 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 275 */     this.jPanel2.add(this.jLabel3, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 276 */           10, 0, new Insets(0, 5, 0, 2), 0, 0));
/* 277 */     this.jPanel2.add(this.jLabel4, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 278 */           10, 0, new Insets(0, 5, 0, 2), 0, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void listOrder_keyPressed(KeyEvent e) {
/* 288 */     if (!e.isAltDown()) {
/*     */       
/* 290 */       Global.setPhotoPoint(((Photo)this.listOrder.getSelectedValue()).getPhotoPoint(), this);
/* 291 */       Global.setPhoto(this.listOrder.getSelectedValue(), this);
/*     */     } 
/*     */ 
/*     */     
/* 295 */     if (e.isAltDown()) {
/*     */       
/* 297 */       if (this.listOrder.getSelectedIndex() == -1)
/* 298 */         return;  Object[] selected = this.listOrder.getSelectedValues();
/* 299 */       int[] selectedIndex = this.listOrder.getSelectedIndices();
/* 300 */       int lastIndex = this.listOrder.getModel().getSize() - 1;
/* 301 */       int newIndex = -1;
/* 302 */       int[] newIndices = new int[selectedIndex.length];
/*     */ 
/*     */       
/* 305 */       if (e.getKeyCode() == 38)
/*     */       {
/* 307 */         if (selectedIndex[0] > 0) {
/*     */           int i;
/* 309 */           for (i = 0; i < selected.length; i++)
/*     */           {
/* 311 */             this.v.remove(selected[i]);
/*     */           }
/*     */           
/* 314 */           for (i = 0; i < selected.length; i++) {
/*     */             
/* 316 */             newIndex = selectedIndex[i] - 1;
/* 317 */             newIndices[i] = newIndex;
/* 318 */             this.v.insertElementAt(selected[i], newIndex);
/*     */           } 
/* 320 */           Global.getView().setOrder(this.v);
/* 321 */           this.listOrder.setListData(this.v);
/* 322 */           this.listOrder.setSelectedIndices(newIndices);
/* 323 */           this.listOrder.updateUI();
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/* 328 */       if (e.getKeyCode() == 40)
/*     */       {
/* 330 */         if (selectedIndex[selectedIndex.length - 1] < lastIndex) {
/*     */           int i;
/* 332 */           for (i = 0; i < selected.length; i++)
/*     */           {
/* 334 */             this.v.remove(selected[i]);
/*     */           }
/*     */           
/* 337 */           for (i = 0; i < selected.length; i++) {
/*     */             
/* 339 */             newIndex = selectedIndex[i] + 1;
/* 340 */             newIndices[i] = newIndex;
/* 341 */             this.v.insertElementAt(selected[i], newIndex);
/*     */           } 
/*     */           
/* 344 */           this.listOrder.setListData(this.v);
/* 345 */           this.listOrder.setSelectedIndices(newIndices);
/* 346 */           this.listOrder.updateUI();
/*     */           return;
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnStartRecording_actionPerformed(ActionEvent e) {
/* 361 */     this.vOrder = new Vector();
/* 362 */     this.listOrder.setListData(this.vOrder);
/* 363 */     this.listOrder.updateUI();
/* 364 */     this.recording = true;
/* 365 */     this.btnStartRecording.setEnabled(false);
/* 366 */     this.btnCancel.setEnabled(true);
/* 367 */     this.lblAdded.setEnabled(true);
/* 368 */     this.lblAdded.setText("Added: 0");
/* 369 */     this.lblRemaining.setEnabled(true);
/* 370 */     this.lblRemaining.setText("Remaining: 0");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void btnCancel_actionPerformed(ActionEvent e) {
/* 376 */     this.recording = false;
/* 377 */     this.btnCancel.setEnabled(false);
/* 378 */     this.btnStartRecording.setEnabled(true);
/* 379 */     this.lblAdded.setEnabled(false);
/* 380 */     this.lblAdded.setText("Added:");
/* 381 */     this.lblRemaining.setEnabled(false);
/* 382 */     this.lblRemaining.setText("Remaining:");
/* 383 */     setupList();
/*     */   }
/*     */ 
/*     */   
/*     */   void listOrder_keyTyped(KeyEvent e) {
/* 388 */     if (this.listOrder.getSelectedValue() == null) {
/*     */       return;
/*     */     }
/* 391 */     if (!e.isAltDown()) {
/*     */       
/* 393 */       Global.setPhotoPoint(((Photo)this.listOrder.getSelectedValue()).getPhotoPoint(), this);
/* 394 */       Global.setPhoto(this.listOrder.getSelectedValue(), this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void listOrder_valueChanged(ListSelectionEvent e) {
/* 403 */     if (this.listOrder.getSelectedValue() == null)
/*     */       return; 
/* 405 */     Global.setPhotoPoint(((Photo)this.listOrder.getSelectedValue()).getPhotoPoint(), this);
/* 406 */     Global.setPhoto(this.listOrder.getSelectedValue(), this);
/*     */   }
/*     */ 
/*     */   
/*     */   void btnResetOrder_actionPerformed(ActionEvent e) {
/* 411 */     String message = "Select 'Yes' to reset the order of photos for the current view";
/* 412 */     String title = "Reset Order Confirmation";
/* 413 */     int result = JOptionPane.showConfirmDialog(this, message, title, 
/* 414 */         0, 
/* 415 */         3);
/* 416 */     if (result == 0) {
/*     */       
/* 418 */       Global.getView().setPhotoOrderSet(false);
/* 419 */       setupList();
/* 420 */       this.listOrder.updateUI();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\OrderPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */