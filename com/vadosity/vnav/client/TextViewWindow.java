/*    */ package com.vadosity.vnav.client;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.GridBagLayout;
/*    */ import java.awt.Point;
/*    */ import java.io.ByteArrayInputStream;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.text.AbstractDocument;
/*    */ 
/*    */ public class TextViewWindow extends JWindow {
/* 13 */   JScrollPane jScrollPane1 = new JScrollPane(); AbstractDocument doc;
/* 14 */   BorderLayout borderLayout1 = new BorderLayout();
/* 15 */   JEditorPane editorPane = new JEditorPane();
/* 16 */   JPanel jPanel1 = new JPanel();
/* 17 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*    */ 
/*    */   
/*    */   public TextViewWindow(Point location, String text) {
/*    */     try {
/* 22 */       jbInit();
/*    */       
/* 24 */       ByteArrayInputStream bais = new ByteArrayInputStream(text.getBytes());
/* 25 */       this.editorPane.getEditorKit().read(bais, this.editorPane.getDocument(), 0);
/* 26 */       this.editorPane.updateUI();
/* 27 */       Dimension preferredSize = this.editorPane.getPreferredSize();
/* 28 */       int px = 300;
/* 29 */       if (preferredSize.width > 500) { px = 500; }
/* 30 */       else if (preferredSize.width < 200) { px = 200; }
/*    */       
/* 32 */       int py = 200;
/* 33 */       if (preferredSize.height > 300) { py = 300; }
/* 34 */       else if (preferredSize.height < 100) { py = 100; }
/*    */       
/* 36 */       setSize(px, py);
/* 37 */       setLocation(location);
/* 38 */       KillerThread kt = new KillerThread(this, this);
/* 39 */       kt.start();
/* 40 */       setVisible(true);
/*    */     }
/* 42 */     catch (Exception e) {
/* 43 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 47 */     getContentPane().setLayout(this.borderLayout1);
/* 48 */     this.editorPane.setText("editorPane");
/* 49 */     this.editorPane.addMouseListener(new TextViewWindow_editorPane_mouseAdapter(this));
/* 50 */     this.jPanel1.setLayout(this.gridBagLayout1);
/* 51 */     getContentPane().add(this.jScrollPane1, "Center");
/* 52 */     getContentPane().add(this.jPanel1, "East");
/* 53 */     this.jScrollPane1.getViewport().add(this.editorPane, (Object)null);
/* 54 */     this.editorPane.setContentType("text/html");
/*    */   }
/*    */   class KillerThread extends Thread { TextViewWindow tf;
/*    */     final TextViewWindow this$0;
/*    */     
/*    */     KillerThread(TextViewWindow this$0, TextViewWindow tf) {
/* 60 */       this.this$0 = this$0;
/*    */       this.tf = null;
/* 62 */       this.tf = tf;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void run() {
/*    */       try {
/* 69 */         Thread.sleep((ToolTipManager.sharedInstance().getDismissDelay() * 3));
/* 70 */         this.tf.dispose();
/*    */       }
/* 72 */       catch (Exception e) {
/*    */         
/* 74 */         e.printStackTrace();
/*    */       } 
/*    */     } }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void editorPane_mouseClicked(MouseEvent e) {
/* 85 */     dispose();
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\TextViewWindow.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */