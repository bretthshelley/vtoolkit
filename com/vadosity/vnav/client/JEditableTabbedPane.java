/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import java.awt.Component;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JEditableTabbedPane
/*     */   extends JTabbedPane
/*     */ {
/*  29 */   JTextField tfEditor = new JTextField();
/*  30 */   JPopupMenu popupMenu = new JPopupMenu();
/*  31 */   int selectedIndex = -1;
/*     */   
/*     */   public JEditableTabbedPane() {
/*     */     try {
/*  35 */       jbInit();
/*     */       
/*  37 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*  38 */       SwingUtilities.updateComponentTreeUI(this);
/*     */ 
/*     */     
/*     */     }
/*  42 */     catch (Exception e) {
/*  43 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public JEditableTabbedPane(int p0) {
/*  48 */     super(p0);
/*     */   }
/*     */   
/*     */   public void addTab(String title, Component component) {
/*  52 */     addTab(title, component, (Icon)null);
/*     */   }
/*     */   
/*     */   public void addTab(String title, Component component, Icon extraIcon) {
/*  56 */     addTab(title, new CloseTabIcon(extraIcon), component);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JEditableTabbedPane(int p0, int p1) {
/*  62 */     super(p0, p1);
/*     */   }
/*     */   private void jbInit() throws Exception {
/*  65 */     this.tfEditor.setText("");
/*  66 */     this.tfEditor.addFocusListener(new JEditableTabbedPane_tfEditor_focusAdapter(this));
/*  67 */     this.tfEditor.addActionListener(new JEditableTabbedPane_tfEditor_actionAdapter(this));
/*  68 */     addMouseListener(new JEditableTabbedPane_this_mouseAdapter(this));
/*     */   }
/*     */ 
/*     */   
/*     */   void tfEditor_actionPerformed(ActionEvent e) {
/*  73 */     if (this.selectedIndex == -1)
/*     */       return; 
/*  75 */     setTitleAt(this.selectedIndex, this.tfEditor.getText());
/*  76 */     this.popupMenu.setVisible(false);
/*     */   }
/*     */   
/*     */   void tfEditor_focusLost(FocusEvent e) {
/*  80 */     if (this.selectedIndex == -1)
/*     */       return; 
/*  82 */     setTitleAt(this.selectedIndex, this.tfEditor.getText());
/*  83 */     this.popupMenu.setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseClicked(MouseEvent e) {
/*  90 */     if (Settings.getMode() == 1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  95 */     int tabNumber = getUI().tabForCoordinate(this, e.getX(), e.getY());
/*  96 */     if (tabNumber < 0)
/*  97 */       return;  Rectangle rect = ((CloseTabIcon)getIconAt(tabNumber)).getBounds();
/*  98 */     if (rect.contains(e.getX(), e.getY())) {
/*     */ 
/*     */       
/* 101 */       removeTabAt(tabNumber);
/* 102 */       updateUI();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 107 */     if (e.getClickCount() > 1)
/*     */     {
/*     */ 
/*     */       
/* 111 */       for (int i = 0; i < getTabCount(); i++) {
/*     */         
/* 113 */         if (getBoundsAt(i).contains(e.getPoint())) {
/*     */           
/* 115 */           this.selectedIndex = i;
/* 116 */           this.tfEditor.setText(getTitleAt(i));
/* 117 */           int tfx = (getBoundsAt(i)).x + 15;
/* 118 */           int tfy = (getBoundsAt(i)).y;
/* 119 */           int tfw = (getBoundsAt(i)).width;
/* 120 */           int tfh = (getBoundsAt(i)).height;
/* 121 */           this.tfEditor.setBounds(tfx, tfy, tfw, tfh);
/* 122 */           this.popupMenu.add(this.tfEditor);
/* 123 */           this.popupMenu.setPopupSize(tfw, tfh);
/* 124 */           this.popupMenu.setBorderPainted(false);
/* 125 */           this.popupMenu.setBounds(tfx, tfy, tfw, tfh);
/* 126 */           this.popupMenu.setVisible(true);
/* 127 */           this.tfEditor.requestFocus();
/* 128 */           this.popupMenu.show(this, (getBoundsAt(i)).x, (getBoundsAt(i)).y);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getTabText(MouseEvent e) {
/* 138 */     for (int i = 0; i < getTabCount(); i++) {
/*     */       
/* 140 */       if (getBoundsAt(i).contains(e.getPoint()))
/*     */       {
/* 142 */         return getTitleAt(i);
/*     */       }
/*     */     } 
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseReleased(MouseEvent e) {
/* 152 */     if (Settings.getMode() == 1) {
/*     */       return;
/*     */     }
/* 155 */     if (e.isPopupTrigger()) {
/*     */       
/* 157 */       String tabText = getTabText(e);
/* 158 */       if (tabText == null)
/* 159 */         return;  Window window = SwingUtilities.getWindowAncestor(this);
/* 160 */       JFrame f = (JFrame)window;
/* 161 */       TextEditDialog dlg = new TextEditDialog(f);
/* 162 */       dlg.setFormattedText(tabText);
/* 163 */       dlg.setSize(350, 250);
/* 164 */       Point location = new Point(e.getX(), e.getY());
/* 165 */       SwingUtilities.convertPointToScreen(location, this);
/* 166 */       dlg.setLocation(location);
/* 167 */       String title = "Set Tab Text";
/* 168 */       dlg.setTitle(title);
/* 169 */       dlg.setModal(true);
/* 170 */       dlg.setVisible(true);
/*     */ 
/*     */       
/* 173 */       if (dlg.getResult() == 2)
/*     */         return; 
/* 175 */       String html = dlg.getFormattedText();
/* 176 */       if (html == null || html.trim().equals(""))
/*     */         return; 
/* 178 */       for (int i = 0; i < getTabCount(); i++) {
/*     */         
/* 180 */         if (getBoundsAt(i).contains(e.getPoint())) {
/*     */           
/* 182 */           setTitleAt(i, html);
/* 183 */           ((View)Global.getTour().getViews().elementAt(i)).setName(html);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\JEditableTabbedPane.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */