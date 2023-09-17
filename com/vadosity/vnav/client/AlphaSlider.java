/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.Tour;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSlider;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AlphaSlider
/*     */   extends JSlider
/*     */   implements GlobalChangeListener
/*     */ {
/*     */   boolean simulationComplete = false;
/*  19 */   JPanel imagePanel = null;
/*     */ 
/*     */   
/*     */   public AlphaSlider() {
/*  23 */     setVisible(false);
/*  24 */     setEnabled(false);
/*  25 */     Global.addGlobalChangeListener(this);
/*     */     try {
/*  27 */       jbInit();
/*     */     }
/*  29 */     catch (Exception e) {
/*  30 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   public void tourChanged(Tour selectedTour, Object src) {}
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {
/*  36 */     if (selectedView == null || 
/*  37 */       selectedView.getOverlayImageBytes() == null || (
/*  38 */       selectedView.getOverlayImageBytes()).length == 0) {
/*     */       
/*  40 */       setEnabled(false);
/*  41 */       setVisible(false);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  46 */     setEnabled(true);
/*  47 */     setVisible(true);
/*     */     
/*  49 */     double alpha = selectedView.getOverlayAlpha();
/*  50 */     int percent = (int)Math.round(alpha * 100.0D);
/*  51 */     setValue(percent);
/*     */     
/*  53 */     if (!isSimulationComplete()) {
/*     */       
/*  55 */       SliderSimulator sim = new SliderSimulator(this);
/*  56 */       sim.setWaitTime(3000L);
/*  57 */       sim.start();
/*  58 */       setSimulationComplete(true);
/*     */     } 
/*     */     
/*  61 */     updateUI();
/*     */   }
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */   
/*     */   private void jbInit() throws Exception {
/*  67 */     setOrientation(1);
/*  68 */     setPaintTicks(false);
/*  69 */     addMouseListener(new AlphaSlider_this_mouseAdapter(this));
/*  70 */     addChangeListener(new AlphaSlider_this_changeAdapter(this));
/*     */     
/*  72 */     String tt = "<html><body><font size=\"4\" color=\"#0000ff\"><b>";
/*  73 */     tt = String.valueOf(tt) + "&nbsp;Fade In and Out&nbsp;<br>";
/*  74 */     tt = String.valueOf(tt) + "&nbsp;between two overlaying Images.&nbsp;<br>";
/*  75 */     tt = String.valueOf(tt) + "&nbsp;<u><font color=\"#000000\">Double-click</font></u>";
/*  76 */     tt = String.valueOf(tt) + "<font size=\"4\" color=\"#0000ff\"> to Run Automatically.&nbsp;</br>";
/*  77 */     tt = String.valueOf(tt) + "</b></font></body></html>";
/*     */     
/*  79 */     setToolTipText(tt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void this_stateChanged(ChangeEvent e) {
/*  85 */     if (Global.getView() != null) {
/*     */       
/*  87 */       Global.getView().setOverlayAlpha(getValue() / 100.0D);
/*  88 */       if (this.imagePanel != null)
/*     */       {
/*  90 */         this.imagePanel.updateUI();
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
/*     */   public JPanel getImagePanel() {
/* 103 */     return this.imagePanel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImagePanel(JPanel panel) {
/* 111 */     this.imagePanel = panel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSimulationComplete() {
/* 119 */     return this.simulationComplete;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSimulationComplete(boolean b) {
/* 127 */     this.simulationComplete = b;
/*     */   }
/*     */   class SliderSimulator extends Thread {
/*     */     private long waitTime;
/* 131 */     SliderSimulator(AlphaSlider this$0) { this.this$0 = this$0;
/*     */       
/* 133 */       this.waitTime = 500L; } final AlphaSlider this$0; public long getWaitTime() {
/* 134 */       return this.waitTime; } public void setWaitTime(long milliseconds) {
/* 135 */       this.waitTime = milliseconds;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/* 141 */         Thread.sleep(this.waitTime);
/*     */         
/* 143 */         int startValue = this.this$0.getValue();
/*     */         
/* 145 */         if (startValue < 50) {
/*     */           int i;
/* 147 */           for (i = startValue; i <= this.this$0.getMaximum(); i += 5) {
/*     */             
/* 149 */             this.this$0.setValue(i);
/* 150 */             this.this$0.updateUI();
/* 151 */             Thread.sleep(50L);
/*     */           } 
/* 153 */           for (i = this.this$0.getMaximum(); i > startValue; i -= 5) {
/*     */             
/* 155 */             this.this$0.setValue(i);
/* 156 */             Thread.sleep(50L);
/* 157 */             this.this$0.updateUI();
/*     */           } 
/*     */         } else {
/*     */           int i;
/*     */ 
/*     */           
/* 163 */           for (i = startValue; i > 0; i -= 5) {
/*     */             
/* 165 */             this.this$0.setValue(i);
/* 166 */             this.this$0.updateUI();
/* 167 */             Thread.sleep(50L);
/*     */           } 
/* 169 */           for (i = 0; i < startValue; i += 5)
/*     */           {
/* 171 */             this.this$0.setValue(i);
/* 172 */             Thread.sleep(50L);
/* 173 */             this.this$0.updateUI();
/*     */           }
/*     */         
/*     */         }
/*     */       
/* 178 */       } catch (Exception exception) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseClicked(MouseEvent e) {
/* 188 */     if (e.getClickCount() > 1) {
/*     */       
/* 190 */       SliderSimulator sim = new SliderSimulator(this);
/* 191 */       sim.setWaitTime(300L);
/* 192 */       sim.start();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AlphaSlider.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */