/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.text.MessageFormat;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RecentFilesMenuActionListener
/*    */   implements ActionListener
/*    */ {
/*    */   public String fileToOpen;
/*    */   public String filename;
/*    */   final RecentFilesMenu this$0;
/*    */   
/*    */   RecentFilesMenuActionListener(RecentFilesMenu paramRecentFilesMenu) {
/* 63 */     this.this$0 = paramRecentFilesMenu;
/*    */     
/* 65 */     this.fileToOpen = null;
/* 66 */     this.filename = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/*    */     try {
/* 72 */       String filename = this.fileToOpen;
/* 73 */       Object object = new Object(this, filename);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 82 */       SwingUtilities.invokeLater((Runnable)object);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     }
/* 88 */     catch (Exception ex) {
/*    */       
/* 90 */       String message = "File corrupt or not present at \n{0}";
/* 91 */       String[] sa = { this.fileToOpen };
/* 92 */       message = MessageFormat.format(message, (Object[])sa);
/* 93 */       String title = "File Error";
/* 94 */       JOptionPane.showMessageDialog(null, message, title, 0);
/*    */ 
/*    */       
/* 97 */       RecentFilesMap.getInstance().remove(this.fileToOpen);
/* 98 */       RecentFilesMap.saveInstance();
/* 99 */       this.this$0.updateMenuItems();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\RecentFilesMenu$RecentFilesMenuActionListener.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */