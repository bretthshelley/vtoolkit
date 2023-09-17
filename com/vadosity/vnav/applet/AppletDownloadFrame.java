/*    */ package com.vadosity.vnav.applet;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.GridBagConstraints;
/*    */ import java.awt.GridBagLayout;
/*    */ import java.awt.Insets;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JProgressBar;
/*    */ 
/*    */ public class AppletDownloadFrame
/*    */   extends JFrame implements Runnable {
/* 14 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/* 15 */   JProgressBar progressBar = new JProgressBar();
/* 16 */   JLabel lblMessage = new JLabel();
/* 17 */   JLabel jLabel2 = new JLabel();
/*    */ 
/*    */   
/*    */   public AppletDownloadFrame() {
/*    */     try {
/* 22 */       jbInit();
/*    */     }
/* 24 */     catch (Exception e) {
/* 25 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 31 */     int percent = 1;
/* 32 */     int iterations = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/*    */       while (true) {
/* 39 */         Thread.sleep(300L);
/* 40 */         this.progressBar.setValue(percent++);
/* 41 */         if (percent > 100)
/*    */         {
/* 43 */           percent = 1;
/* 44 */           iterations++;
/*    */         }
/*    */       
/*    */       } 
/* 48 */     } catch (Exception e) {
/*    */       
/* 50 */       this.lblMessage.setText("Download Complete");
/* 51 */       while (percent < 100) {
/*    */         
/* 53 */         percent += 15; 
/* 54 */         try { Thread.sleep(50L); } catch (Exception e2) { e2.printStackTrace(); }
/*    */         
/* 56 */         this.progressBar.setValue(percent);
/*    */       }  
/* 58 */       try { Thread.sleep(500L); } catch (Exception e3) { e3.printStackTrace(); }
/*    */       
/*    */       try {
/* 61 */         dispose();
/*    */       }
/* 63 */       catch (Exception e4) {
/*    */         
/* 65 */         e4.printStackTrace();
/*    */       } 
/*    */       return;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 74 */     getContentPane().setLayout(this.gridBagLayout1);
/* 75 */     this.lblMessage.setFont(new Font("Dialog", 1, 12));
/* 76 */     this.lblMessage.setMaximumSize(new Dimension(140, 16));
/* 77 */     this.lblMessage.setText("Downloading Tour ...");
/* 78 */     this.jLabel2.setText("");
/* 79 */     getContentPane().add(this.jLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/* 80 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 81 */     getContentPane().add(this.lblMessage, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 82 */           10, 1, new Insets(5, 5, 5, 5), 0, 27));
/* 83 */     getContentPane().add(this.progressBar, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/* 84 */           10, 2, new Insets(0, 0, 0, 0), 0, 0));
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\applet\AppletDownloadFrame.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */