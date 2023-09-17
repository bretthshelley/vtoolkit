/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.text.MessageFormat;
/*    */ import java.util.Iterator;
/*    */ import javax.swing.JMenu;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RecentFilesMenu
/*    */   extends JMenu
/*    */ {
/*    */   public RecentFilesMenu() {
/* 19 */     updateMenuItems();
/* 20 */     RecentFilesMap.getInstance().setRecentFilesMenu(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateMenuItems() {
/* 25 */     setText("Recent Files");
/* 26 */     removeAll();
/* 27 */     updateUI();
/* 28 */     setEnabled(false);
/*    */ 
/*    */     
/* 31 */     if (RecentFilesMap.getInstance().isEmpty()) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 36 */     Iterator it = RecentFilesMap.getInstance().keys().iterator();
/* 37 */     while (it.hasNext()) {
/*    */       
/* 39 */       String filepathKey = it.next();
/* 40 */       String filenameValue = (String)RecentFilesMap.getInstance().get(filepathKey);
/*    */ 
/*    */       
/* 43 */       JMenuItem menuItem = new JMenuItem();
/* 44 */       menuItem.setText(filenameValue);
/* 45 */       menuItem.setToolTipText(filepathKey);
/*    */ 
/*    */       
/* 48 */       RecentFilesMenuActionListener listener = new RecentFilesMenuActionListener(this);
/* 49 */       listener.fileToOpen = filepathKey;
/* 50 */       listener.filename = filenameValue;
/* 51 */       menuItem.addActionListener(listener);
/*    */       
/* 53 */       add(menuItem);
/*    */     } 
/*    */     
/* 56 */     setEnabled(true);
/*    */   }
/*    */   
/*    */   class RecentFilesMenuActionListener implements ActionListener {
/*    */     public String fileToOpen;
/*    */     
/*    */     RecentFilesMenuActionListener(RecentFilesMenu this$0) {
/* 63 */       this.this$0 = this$0;
/*    */       
/* 65 */       this.fileToOpen = null;
/* 66 */       this.filename = null;
/*    */     }
/*    */     public String filename; final RecentFilesMenu this$0;
/*    */     
/*    */     public void actionPerformed(ActionEvent e) {
/*    */       try {
/* 72 */         String filename = this.fileToOpen;
/* 73 */         Object object = new Object(this, filename);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 82 */         SwingUtilities.invokeLater((Runnable)object);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       }
/* 88 */       catch (Exception ex) {
/*    */         
/* 90 */         String message = "File corrupt or not present at \n{0}";
/* 91 */         String[] sa = { this.fileToOpen };
/* 92 */         message = MessageFormat.format(message, (Object[])sa);
/* 93 */         String title = "File Error";
/* 94 */         JOptionPane.showMessageDialog(null, message, title, 0);
/*    */ 
/*    */         
/* 97 */         RecentFilesMap.getInstance().remove(this.fileToOpen);
/* 98 */         RecentFilesMap.saveInstance();
/* 99 */         this.this$0.updateMenuItems();
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\RecentFilesMenu.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */