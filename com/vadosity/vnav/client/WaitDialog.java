/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import javax.swing.JInternalFrame;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class WaitDialog extends JDialog {
/*   8 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*   9 */   JProgressBar progressBar = new JProgressBar();
/*  10 */   ProgressBarRunner runner = null;
/*  11 */   int numElements = 0;
/*  12 */   int counter = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WaitDialog(Frame f, String title, boolean modal, int numElements) {
/*  18 */     super(f, title, modal);
/*  19 */     this.numElements = numElements;
/*     */ 
/*     */     
/*     */     try {
/*  23 */       jbInit();
/*     */     }
/*  25 */     catch (Exception exception) {}
/*     */ 
/*     */     
/*  28 */     this.progressBar.setMaximum(numElements);
/*  29 */     this.progressBar.setValue(this.counter);
/*     */   }
/*     */ 
/*     */   
/*     */   public WaitDialog(Frame f, String title, boolean p2) {
/*  34 */     super(f, title, p2);
/*     */     
/*     */     try {
/*  37 */       jbInit();
/*     */     
/*     */     }
/*  40 */     catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     setSize(250, 100);
/*  46 */     if (f != null) {
/*     */       
/*  48 */       setLocation((f.getLocation()).x + f.getWidth() / 2 - 
/*  49 */           getWidth() / 2, 
/*  50 */           (f.getLocation()).y + f.getHeight() / 2 - 
/*  51 */           getHeight() / 2);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  56 */       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
/*  57 */       setLocation((int)(screen.getWidth() / 2.0D - (getWidth() / 2)), 
/*  58 */           (int)(screen.getHeight() / 2.0D - (getHeight() / 2)));
/*     */     } 
/*  60 */     setVisible(true);
/*     */ 
/*     */ 
/*     */     
/*  64 */     this.runner = new ProgressBarRunner(this, this.progressBar);
/*  65 */     this.runner.start();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WaitDialog(JInternalFrame internalFrame, String title, boolean modal) {
/*  71 */     setTitle(title);
/*  72 */     setModal(modal);
/*     */     
/*     */     try {
/*  75 */       jbInit();
/*     */     
/*     */     }
/*  78 */     catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/*  82 */     setSize(250, 100);
/*  83 */     if (internalFrame != null) {
/*     */       
/*  85 */       setLocation((internalFrame.getLocation()).x + internalFrame.getWidth() / 2 - getWidth() / 2, 
/*  86 */           (internalFrame.getLocation()).y + internalFrame.getHeight() / 2 - getHeight() / 2);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  91 */       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
/*  92 */       setLocation((int)(screen.getWidth() / 2.0D - (getWidth() / 2)), (int)(screen.getHeight() / 2.0D - (getHeight() / 2)));
/*     */     } 
/*  94 */     setVisible(true);
/*     */     
/*  96 */     this.runner = new ProgressBarRunner(this, this.progressBar);
/*  97 */     this.runner.start();
/*     */   }
/*     */   
/*     */   public void step() {
/* 101 */     this.progressBar.setValue(this.progressBar.getValue() + 1);
/* 102 */     this.progressBar.paintImmediately(0, 0, getWidth(), getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WaitDialog(Dialog p0, String p1, boolean p2) {
/* 110 */     super(p0, p1, p2);
/*     */     
/*     */     try {
/* 113 */       jbInit();
/*     */     
/*     */     }
/* 116 */     catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/* 120 */     this.runner = new ProgressBarRunner(this, this.progressBar);
/* 121 */     this.runner.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WaitDialog() {
/*     */     try {
/* 129 */       jbInit();
/*     */     }
/* 131 */     catch (Exception e) {
/*     */       
/* 133 */       e.printStackTrace();
/*     */     } 
/* 135 */     this.runner = new ProgressBarRunner(this, this.progressBar);
/* 136 */     this.runner.start();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 141 */     getContentPane().setLayout(this.gridBagLayout1);
/* 142 */     getContentPane().add(this.progressBar, new GridBagConstraints(0, 1, 1, 1, 1.0D, 0.0D, 
/* 143 */           10, 2, new Insets(5, 5, 5, 5), 0, 0));
/*     */   }
/*     */   
/*     */   class ProgressBarRunner extends Thread {
/*     */     public JProgressBar progressBar;
/*     */     final WaitDialog this$0;
/*     */     
/*     */     ProgressBarRunner(WaitDialog this$0, JProgressBar pb) {
/* 151 */       this.this$0 = this$0; this.progressBar = null;
/* 152 */       this.progressBar = pb;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/* 157 */       int counter = 0;
/*     */ 
/*     */       
/*     */       try {
/* 161 */         while (counter < 101)
/*     */         {
/* 163 */           counter += 2;
/* 164 */           this.progressBar.setValue(counter);
/* 165 */           this.progressBar.updateUI();
/* 166 */           this.progressBar.paintImmediately(0, 0, this.this$0.getWidth(), 
/* 167 */               this.this$0.getHeight());
/* 168 */           if (counter > 100) counter = 1;
/*     */           
/*     */           try {
/* 171 */             Thread.sleep(100L);
/*     */           }
/* 173 */           catch (Exception exception) {}
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 179 */       catch (Exception e) {
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
/* 198 */         this.this$0.dispose();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/* 207 */       if (this.runner != null && this.runner.isAlive()) {
/*     */         
/* 209 */         this.runner.interrupt();
/* 210 */         this.runner = null;
/*     */       } 
/* 212 */       super.dispose();
/*     */     }
/* 214 */     catch (Exception ex) {
/*     */       
/* 216 */       dispose();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\WaitDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */