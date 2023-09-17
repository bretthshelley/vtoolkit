/*     */ package com.vadosity.vnav.applet;
/*     */ 
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.Tour;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.GlobalChangeListener;
/*     */ import java.awt.BorderLayout;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ 
/*     */ public class AppletTabbedPane
/*     */   extends JTabbedPane implements GlobalChangeListener {
/*  17 */   JPanel mainViewPanel = null;
/*     */ 
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {
/*     */     try {
/*  26 */       if (selectedTour == null) {
/*     */         
/*  28 */         removeAll();
/*  29 */         updateUI();
/*     */         
/*     */         return;
/*     */       } 
/*  33 */       setup();
/*     */     }
/*  35 */     catch (RuntimeException e) {
/*     */       
/*  37 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {
/*  42 */     if (Global.getTour() == null)
/*  43 */       return;  if (Global.isLoadingTour()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  48 */       if (this.mainViewPanel == null) throw new IllegalStateException("mainViewPanel attribute has not been set");
/*     */ 
/*     */ 
/*     */       
/*  52 */       int numTabs = getTabCount();
/*  53 */       int numViews = Global.getTour().getViews().size();
/*     */       
/*  55 */       if (numTabs != numViews)
/*     */       {
/*  57 */         if (numTabs < numViews) {
/*     */ 
/*     */           
/*  60 */           View lastView = Global.getTour().getViews().elementAt(numViews - 1);
/*  61 */           JPanel panel = new JPanel();
/*  62 */           panel.setLayout(new BorderLayout());
/*  63 */           panel.add(this.mainViewPanel, "Center");
/*  64 */           addTab(lastView.getName(), panel);
/*  65 */           setSelectedIndex(numViews - 1);
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */       
/*  71 */       int selectedViewIndex = getSelectedViewIndex();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       if (selectedViewIndex != -1)
/*     */       {
/*  78 */         JPanel panel = (JPanel)getComponentAt(selectedViewIndex);
/*  79 */         panel.add(this.mainViewPanel, "Center");
/*  80 */         this.mainViewPanel.updateUI();
/*  81 */         setSelectedIndex(selectedViewIndex);
/*  82 */         setTitleAt(selectedViewIndex, Global.getView().getName());
/*     */       }
/*     */     
/*  85 */     } catch (RuntimeException e) {
/*     */       
/*  87 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSelectedViewIndex() {
/*  96 */     for (int i = 0; i < Global.getTour().getViews().size(); i++) {
/*     */       
/*  98 */       if (((View)Global.getTour().getViews().elementAt(i)).equals(Global.getView()))
/*     */       {
/* 100 */         return i;
/*     */       }
/*     */     } 
/* 103 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public AppletTabbedPane() {
/* 108 */     Global.addGlobalChangeListener(this);
/*     */     try {
/* 110 */       jbInit();
/*     */     
/*     */     }
/* 113 */     catch (Exception e) {
/* 114 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public AppletTabbedPane(int p0) {
/* 119 */     super(p0);
/* 120 */     Global.addGlobalChangeListener(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public AppletTabbedPane(int p0, int p1) {
/* 125 */     super(p0, p1);
/* 126 */     Global.addGlobalChangeListener(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setup() {
/*     */     try {
/* 133 */       removeAll();
/* 134 */       updateUI();
/* 135 */       if (Global.getTour() == null)
/*     */         return; 
/* 137 */       Vector vViews = Global.getTour().getViews();
/* 138 */       if (vViews == null)
/* 139 */         return;  int selectedViewIndex = -1;
/* 140 */       for (int i = 0; i < vViews.size(); i++) {
/*     */ 
/*     */         
/* 143 */         JPanel jPanel = new JPanel();
/* 144 */         jPanel.setLayout(new BorderLayout());
/* 145 */         String viewText = ((View)vViews.elementAt(i)).getName();
/*     */ 
/*     */         
/* 148 */         if (vViews.size() > getTabCount())
/*     */         {
/* 150 */           addTab(viewText, jPanel);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 155 */         selectedViewIndex = 0;
/*     */       } 
/* 157 */       if (selectedViewIndex == -1) selectedViewIndex = 0; 
/* 158 */       if (vViews.size() == 0) {
/*     */         return;
/*     */       }
/* 161 */       JPanel panel = (JPanel)getComponentAt(0);
/* 162 */       panel.add(this.mainViewPanel, "Center");
/* 163 */       this.mainViewPanel.updateUI();
/*     */     }
/* 165 */     catch (Exception e) {
/*     */       
/* 167 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JPanel getMainViewPanel() {
/* 177 */     return this.mainViewPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMainViewPanel(JPanel mainViewPanel) {
/* 183 */     this.mainViewPanel = mainViewPanel;
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/* 187 */     addChangeListener(new AppletTabbedPane_this_changeAdapter(this));
/*     */   }
/*     */ 
/*     */   
/*     */   void this_stateChanged(ChangeEvent e) {
/* 192 */     if (Global.getTour() == null) {
/*     */       
/* 194 */       removeAll();
/* 195 */       updateUI();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 201 */     View view = null;
/* 202 */     int lastViewIndex = Global.getTour().getViews().size() - 1;
/* 203 */     if (!Global.getTour().getViews().isEmpty()) {
/*     */       
/* 205 */       if (getSelectedIndex() > lastViewIndex)
/* 206 */         return;  if (getSelectedIndex() != -1) {
/* 207 */         view = Global.getTour().getViews().elementAt(getSelectedIndex());
/*     */       }
/*     */     } 
/* 210 */     Global.setView(view, this);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\applet\AppletTabbedPane.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */