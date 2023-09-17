/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.awt.datatransfer.DataFlavor;
/*    */ import java.awt.datatransfer.Transferable;
/*    */ import java.io.File;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.TransferHandler;
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
/*    */ public class ToolkitTransferHandler
/*    */   extends TransferHandler
/*    */ {
/*    */   public boolean canImport(JComponent arg0, DataFlavor[] dfa) {
/* 26 */     for (int i = 0; i < dfa.length; i++) {
/*    */       
/* 28 */       if (dfa[i].isFlavorJavaFileListType()) return true; 
/*    */     } 
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean importData(JComponent c, Transferable t) {
/*    */     try {
/* 37 */       Object data = t.getTransferData(DataFlavor.javaFileListFlavor);
/* 38 */       List list = (List)data;
/* 39 */       Iterator it = list.iterator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 46 */       File f = it.next();
/* 47 */       VadosityToolkit.createAndAddViewFromImageFile(c, f);
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
/*    */     }
/* 73 */     catch (Exception e) {
/*    */       
/* 75 */       e.printStackTrace();
/*    */     } 
/* 77 */     return super.importData(c, t);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static Action getCopyAction() {
/* 83 */     return TransferHandler.getCopyAction();
/*    */   }
/*    */   
/*    */   public static Action getCutAction() {
/* 87 */     return TransferHandler.getCutAction();
/*    */   }
/*    */   
/*    */   public static Action getPasteAction() {
/* 91 */     return TransferHandler.getPasteAction();
/*    */   }
/*    */   
/*    */   public int getSourceActions(JComponent c) {
/* 95 */     return 3;
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ToolkitTransferHandler.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */