/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.DefaultListCellRenderer;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ 
/*    */ 
/*    */ public class IconListCellRenderer
/*    */   extends DefaultListCellRenderer
/*    */ {
/*    */   private ImageIcon defaultImageIcon;
/* 14 */   ToolkitTransferHandler tth = new ToolkitTransferHandler();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IconListCellRenderer() {
/* 24 */     this.defaultImageIcon = new ImageIcon(ImageUtil.loadCameraImage());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
/* 35 */     Component defaultRenderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
/* 36 */     ((JLabel)defaultRenderer).setIcon(this.defaultImageIcon);
/*    */     
/* 38 */     return defaultRenderer;
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\IconListCellRenderer.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */