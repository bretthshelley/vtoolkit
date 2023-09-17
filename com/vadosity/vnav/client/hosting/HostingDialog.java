/*    */ package com.vadosity.vnav.client.hosting;
/*    */ import java.awt.CardLayout;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.UIManager;
/*    */ 
/*    */ public class HostingDialog extends JDialog {
/*  9 */   CardLayout cardLayout = new CardLayout();
/* 10 */   IntroPanel introPanel = new IntroPanel();
/* 11 */   HtmlSetupPanel htmlSetupPanel = new HtmlSetupPanel();
/* 12 */   HtmlViewPanel htmlViewPanel = new HtmlViewPanel();
/* 13 */   FileTransferPanel fileTransferPanel = new FileTransferPanel();
/*    */ 
/*    */ 
/*    */   
/*    */   public HostingDialog(JFrame f, String title, boolean modal) {
/* 18 */     super(f, title, modal);
/*    */     
/*    */     try {
/* 21 */       this.cardLayout.addLayoutComponent(this.introPanel, "introPanel");
/* 22 */       this.cardLayout.addLayoutComponent(this.htmlSetupPanel, "htmlSetupPanel");
/* 23 */       this.cardLayout.addLayoutComponent(this.htmlViewPanel, "htmlViewPanel");
/* 24 */       this.cardLayout.addLayoutComponent(this.fileTransferPanel, "fileTransferPanel");
/* 25 */       jbInit();
/* 26 */       getContentPane().add(this.introPanel, "introPanel");
/* 27 */       getContentPane().add(this.htmlSetupPanel, "htmlSetupPanel");
/* 28 */       getContentPane().add(this.htmlViewPanel, "htmlViewPanel");
/* 29 */       getContentPane().add(this.fileTransferPanel, "fileTransferPanel");
/*    */       
/* 31 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/* 32 */       UIManager.setLookAndFeel(nativeLF);
/* 33 */       SwingUtilities.updateComponentTreeUI(this);
/*    */ 
/*    */ 
/*    */     
/*    */     }
/* 38 */     catch (Exception e) {
/* 39 */       JOptionPane.showMessageDialog(this, e.toString());
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 43 */     getContentPane().setLayout(this.cardLayout);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\hosting\HostingDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */