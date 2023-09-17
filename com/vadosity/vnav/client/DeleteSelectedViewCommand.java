/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.View;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DeleteSelectedViewCommand
/*    */ {
/*    */   public void execute(Object src) {
/* 12 */     if (Global.getView() == null) {
/*    */       return;
/*    */     }
/*    */     
/* 16 */     int result = -1;
/*    */     
/* 18 */     String message = "Select 'Yes' to Delete Current View Tab";
/* 19 */     String title = "View Tab Delete Confirmation";
/* 20 */     result = JOptionPane.showConfirmDialog(null, message, title, 1);
/*    */     
/* 22 */     if (result != 0) {
/*    */       return;
/*    */     }
/* 25 */     View v = Global.getView();
/*    */     
/* 27 */     int index = -1;
/*    */     
/* 29 */     for (index = 0; index < Global.getTour().getViews().size(); index++) {
/*    */       
/* 31 */       View ithView = Global.getTour().getViews().elementAt(index);
/* 32 */       if (ithView.equals(Global.getView())) {
/*    */         
/* 34 */         Global.getTour().getViews().remove(index);
/*    */         
/*    */         break;
/*    */       } 
/*    */     } 
/*    */     
/* 40 */     Global.setView(null, this);
/* 41 */     Global.setPhotoPoint(null, this);
/* 42 */     Global.setPhoto(null, this);
/* 43 */     Global.getTour().remove(v);
/*    */ 
/*    */     
/* 46 */     int lastIndex = Global.getTour().getViews().size() - 1;
/* 47 */     if (lastIndex == -1) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 52 */     if (lastIndex == 0) {
/*    */ 
/*    */       
/* 55 */       Global.setView(Global.getTour().getViews().elementAt(0), this);
/* 56 */       Global.setPhotoPoint(Global.getView().getFirstPhotoPoint(), this);
/* 57 */       Global.setPhoto(Global.getPhotoPoint().getFirstPhoto(), this);
/*    */     
/*    */     }
/*    */     else {
/*    */ 
/*    */       
/* 63 */       Global.setView(Global.getTour().getViews().elementAt(index), this);
/* 64 */       Global.setPhotoPoint(Global.getView().getFirstPhotoPoint(), this);
/* 65 */       Global.setPhoto(Global.getPhotoPoint().getFirstPhoto(), this);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\DeleteSelectedViewCommand.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */