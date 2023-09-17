/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.Tour;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ 
/*     */ public class ViewTabbedPane
/*     */   extends JEditableTabbedPane implements GlobalChangeListener {
/*  19 */   JPanel mainViewPanel = null;
/*     */ 
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {
/*     */     try {
/*  28 */       if (selectedTour == null) {
/*     */         
/*  30 */         removeAll();
/*  31 */         updateUI();
/*     */         
/*     */         return;
/*     */       } 
/*  35 */       setup();
/*     */     }
/*  37 */     catch (RuntimeException e) {
/*     */       
/*  39 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {
/*  44 */     if (Global.getTour() == null)
/*  45 */       return;  if (Global.isLoadingTour()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  50 */       if (this.mainViewPanel == null) throw new IllegalStateException("mainViewPanel attribute has not been set");
/*     */ 
/*     */ 
/*     */       
/*  54 */       int numTabs = getTabCount();
/*  55 */       int numViews = Global.getTour().getViews().size();
/*     */       
/*  57 */       if (numTabs != numViews)
/*     */       {
/*  59 */         if (numTabs < numViews) {
/*     */ 
/*     */           
/*  62 */           View lastView = Global.getTour().getViews().elementAt(numViews - 1);
/*  63 */           JPanel panel = new JPanel();
/*  64 */           panel.setLayout(new BorderLayout());
/*  65 */           panel.add(this.mainViewPanel, "Center");
/*  66 */           addTab(lastView.getName(), panel);
/*  67 */           setSelectedIndex(numViews - 1);
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */       
/*  73 */       int selectedViewIndex = getSelectedViewIndex();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  78 */       if (selectedViewIndex != -1)
/*     */       {
/*  80 */         JPanel panel = (JPanel)getComponentAt(selectedViewIndex);
/*  81 */         panel.add(this.mainViewPanel, "Center");
/*  82 */         this.mainViewPanel.updateUI();
/*  83 */         setSelectedIndex(selectedViewIndex);
/*  84 */         setTitleAt(selectedViewIndex, Global.getView().getName());
/*     */       }
/*     */     
/*  87 */     } catch (RuntimeException e) {
/*     */       
/*  89 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSelectedViewIndex() {
/*  98 */     for (int i = 0; i < Global.getTour().getViews().size(); i++) {
/*     */       
/* 100 */       if (((View)Global.getTour().getViews().elementAt(i)).equals(Global.getView()))
/*     */       {
/* 102 */         return i;
/*     */       }
/*     */     } 
/* 105 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public ViewTabbedPane() {
/* 110 */     Global.addGlobalChangeListener(this);
/*     */     try {
/* 112 */       jbInit();
/*     */     
/*     */     }
/* 115 */     catch (Exception e) {
/* 116 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public ViewTabbedPane(int p0) {
/* 121 */     super(p0);
/* 122 */     Global.addGlobalChangeListener(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public ViewTabbedPane(int p0, int p1) {
/* 127 */     super(p0, p1);
/* 128 */     Global.addGlobalChangeListener(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setup() {
/*     */     try {
/* 135 */       removeAll();
/* 136 */       updateUI();
/* 137 */       if (Global.getTour() == null)
/*     */         return; 
/* 139 */       Vector vViews = Global.getTour().getViews();
/* 140 */       if (vViews == null)
/* 141 */         return;  int selectedViewIndex = -1;
/* 142 */       for (int i = 0; i < vViews.size(); i++) {
/*     */ 
/*     */         
/* 145 */         JPanel jPanel = new JPanel();
/* 146 */         jPanel.setLayout(new BorderLayout());
/* 147 */         String viewText = ((View)vViews.elementAt(i)).getName();
/*     */ 
/*     */         
/* 150 */         if (vViews.size() > getTabCount())
/*     */         {
/* 152 */           addTab(viewText, jPanel);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 157 */         selectedViewIndex = 0;
/*     */       } 
/* 159 */       if (selectedViewIndex == -1) selectedViewIndex = 0; 
/* 160 */       if (vViews.size() == 0) {
/*     */         return;
/*     */       }
/* 163 */       JPanel panel = (JPanel)getComponentAt(0);
/* 164 */       panel.add(this.mainViewPanel, "Center");
/* 165 */       this.mainViewPanel.updateUI();
/*     */     }
/* 167 */     catch (Exception e) {
/*     */       
/* 169 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void tfEditor_actionPerformed(ActionEvent e) {
/* 176 */     if (this.selectedIndex == -1)
/*     */       return; 
/* 178 */     setTitleAt(this.selectedIndex, this.tfEditor.getText());
/* 179 */     this.popupMenu.setVisible(false);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 184 */       View view = Global.getTour().getViews().elementAt(this.selectedIndex);
/* 185 */       view.setName(this.tfEditor.getText());
/*     */     }
/* 187 */     catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void tfEditor_focusLost(FocusEvent e) {
/* 193 */     if (this.selectedIndex == -1)
/*     */       return; 
/* 195 */     setTitleAt(this.selectedIndex, this.tfEditor.getText());
/* 196 */     this.popupMenu.setVisible(false);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 201 */       View view = Global.getTour().getViews().elementAt(this.selectedIndex);
/* 202 */       view.setName(this.tfEditor.getText());
/*     */     }
/* 204 */     catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseClicked(MouseEvent e) {
/* 212 */     if (Settings.getMode() == 1) {
/*     */       return;
/*     */     }
/* 215 */     int tabNumber = getUI().tabForCoordinate(this, e.getX(), e.getY());
/* 216 */     if (tabNumber < 0)
/* 217 */       return;  Rectangle rect = ((CloseTabIcon)getIconAt(tabNumber)).getBounds();
/* 218 */     if (rect.contains(e.getX(), e.getY())) {
/*     */ 
/*     */       
/* 221 */       String message = "Do you really wish to delete this view?";
/* 222 */       String title = "Delete View Confirmation";
/*     */       
/* 224 */       int result = JOptionPane.showConfirmDialog(this, message, title, 1);
/* 225 */       if (result == 2)
/* 226 */         return;  if (result == 1) {
/*     */         return;
/*     */       }
/*     */       
/*     */       try {
/* 231 */         String viewId = ((View)Global.getTour().getViews().elementAt(tabNumber)).getId();
/* 232 */         Global.getTour().getViews().removeElementAt(tabNumber);
/* 233 */         Global.fireSelectedViewChanged(this);
/*     */       }
/* 235 */       catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 240 */       removeTabAt(tabNumber);
/*     */ 
/*     */ 
/*     */       
/* 244 */       int remainingViews = Global.getTour().getViews().size();
/* 245 */       if (remainingViews > 0) {
/*     */ 
/*     */         
/* 248 */         if (remainingViews == tabNumber) {
/*     */ 
/*     */ 
/*     */           
/* 252 */           int newViewIndex = tabNumber - 1;
/* 253 */           Global.setView(Global.getTour().getViews().elementAt(newViewIndex), this);
/*     */           return;
/*     */         } 
/* 256 */         if (remainingViews > tabNumber) {
/*     */ 
/*     */           
/* 259 */           Global.setView(Global.getTour().getViews().elementAt(tabNumber), this);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 265 */       updateUI();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 270 */     if (e.getClickCount() > 1)
/*     */     {
/* 272 */       for (int i = 0; i < getTabCount(); i++) {
/*     */         
/* 274 */         if (getBoundsAt(i).contains(e.getPoint())) {
/*     */           
/* 276 */           this.selectedIndex = i;
/* 277 */           this.tfEditor.setText(getTitleAt(i));
/* 278 */           int tfx = (getBoundsAt(i)).x + 15;
/* 279 */           int tfy = (getBoundsAt(i)).y;
/* 280 */           int tfw = (getBoundsAt(i)).width;
/* 281 */           int tfh = (getBoundsAt(i)).height;
/* 282 */           this.tfEditor.setBounds(tfx, tfy, tfw, tfh);
/* 283 */           this.popupMenu.add(this.tfEditor);
/* 284 */           this.popupMenu.setPopupSize(tfw, tfh);
/* 285 */           this.popupMenu.setBorderPainted(false);
/* 286 */           this.popupMenu.setBounds(tfx, tfy, tfw, tfh);
/* 287 */           this.popupMenu.setVisible(true);
/* 288 */           this.tfEditor.requestFocus();
/* 289 */           this.popupMenu.show(this, (getBoundsAt(i)).x, (getBoundsAt(i)).y);
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
/*     */   public JPanel getMainViewPanel() {
/* 302 */     return this.mainViewPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMainViewPanel(JPanel mainViewPanel) {
/* 308 */     this.mainViewPanel = mainViewPanel;
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/* 312 */     addChangeListener(new ViewTabbedPane_this_changeAdapter(this));
/* 313 */     String tt = "<html><body><font color=\"#000000\">";
/* 314 */     tt = String.valueOf(tt) + "&nbsp;Use any satellite photo, map, floor plan diagram, etc. to create a virtual tour.&nbsp;<br>";
/* 315 */     tt = String.valueOf(tt) + "&nbsp;- Right Click to See Additional Menu Options&nbsp;<br>";
/* 316 */     tt = String.valueOf(tt) + "&nbsp;- Use your mouse to Drag Icons&nbsp;<br>";
/* 317 */     tt = String.valueOf(tt) + "&nbsp;- Use the angle editor to modify angles&nbsp;<br>";
/* 318 */     tt = String.valueOf(tt) + "&nbsp;- Mouse over any icon to see the associated photo&nbsp;<br>";
/* 319 */     tt = String.valueOf(tt) + "&nbsp;&nbsp;<br>";
/* 320 */     tt = String.valueOf(tt) + "</font></body></html>";
/* 321 */     setToolTipText(tt);
/*     */   }
/*     */ 
/*     */   
/*     */   void this_stateChanged(ChangeEvent e) {
/* 326 */     if (Global.getTour() == null) {
/*     */       
/* 328 */       removeAll();
/* 329 */       updateUI();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 335 */     View view = null;
/* 336 */     int lastViewIndex = Global.getTour().getViews().size() - 1;
/* 337 */     if (!Global.getTour().getViews().isEmpty()) {
/*     */       
/* 339 */       if (getSelectedIndex() > lastViewIndex)
/* 340 */         return;  if (getSelectedIndex() != -1) {
/* 341 */         view = Global.getTour().getViews().elementAt(getSelectedIndex());
/*     */       }
/*     */     } 
/* 344 */     Global.setView(view, this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ViewTabbedPane.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */