/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.applet.AppletUtil;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.net.URL;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ 
/*    */ public class VadosityLabel
/*    */   extends JLabel
/*    */ {
/*    */   public VadosityLabel() {
/*    */     try {
/* 14 */       jbInit();
/*    */     }
/* 16 */     catch (Exception e) {
/* 17 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private void jbInit() throws Exception {
/* 21 */     setText("<html><font size=\"3\"><a href=\"http://www.vadosity.com\">Vadosity Inc. © 2004<a></font></html>");
/* 22 */     addMouseListener(new VadosityLabel_this_mouseAdapter(this));
/* 23 */     setToolTipText("http://www.vadosity.com");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void this_mouseClicked(MouseEvent e) {
/*    */     try {
/* 33 */       AppletUtil.getInstance().getAppletContext().showDocument(new URL("http://www.vadosity.com"), "_blank");
/*    */       
/*    */       return;
/* 36 */     } catch (Throwable throwable) {
/*    */ 
/*    */       
/*    */       try {
/*    */ 
/*    */ 
/*    */         
/* 43 */         BrowserUtil.displayURL("http://www.vadosity.com");
/*    */         
/*    */         return;
/* 46 */       } catch (Throwable throwable1) {
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\VadosityLabel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */