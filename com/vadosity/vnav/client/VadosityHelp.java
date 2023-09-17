/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VadosityHelp
/*    */ {
/*    */   public static void main(String[] args) {
/*    */     try {
/* 13 */       File root = new File(".");
/* 14 */       String helpUrl = String.valueOf(root.getAbsolutePath()) + File.separator + "FlashHelp" + File.separator + "Help.htm";
/* 15 */       RoboHelp_CSH.RH_ShowHelp(0, helpUrl, 0, 0);
/*    */     }
/* 17 */     catch (Exception ex) {
/*    */       
/* 19 */       JOptionPane.showMessageDialog(null, ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\VadosityHelp.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */