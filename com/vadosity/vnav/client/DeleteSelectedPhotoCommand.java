/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import com.vadosity.vnav.bean.PhotoPoint;
/*    */ import com.vadosity.vnav.bean.View;
/*    */ 
/*    */ public class DeleteSelectedPhotoCommand {
/*  8 */   private Photo photo = null;
/*  9 */   private PhotoPoint photoPoint = null;
/* 10 */   private View view = null;
/* 11 */   private Object src = null;
/*    */ 
/*    */   
/*    */   public void execute(Object src) {
/* 15 */     this.photo = Global.getPhoto();
/* 16 */     this.photoPoint = this.photo.getPhotoPoint();
/* 17 */     this.view = Global.getView();
/* 18 */     this.src = src;
/*    */     
/* 20 */     if (this.photo == null || this.photoPoint == null || this.view == null) {
/*    */       return;
/*    */     }
/* 23 */     Global.getView().getPhotos().remove(this.photo);
/* 24 */     Global.getPhotoPoint().getVPhotos().remove(this.photo);
/*    */ 
/*    */     
/* 27 */     if (Global.getPhotoPoint().getVPhotos().isEmpty()) {
/*    */       
/* 29 */       Global.getView().getVPhotoPoints().remove(Global.getPhotoPoint());
/* 30 */       PhotoPoint pt = Global.getView().getFirstPhotoPoint();
/* 31 */       Photo ph = (pt == null) ? null : pt.getFirstPhoto();
/* 32 */       Global.setPhotoPoint(pt, src);
/* 33 */       Global.setPhoto(ph, src);
/*    */     }
/*    */     else {
/*    */       
/* 37 */       Global.selectNextClockwisePhoto(src);
/*    */     } 
/* 39 */     Global.fireSelectedPhotoChanged(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void undo() {
/* 46 */     if (!Global.getTour().getViews().contains(this.view))
/*    */     {
/* 48 */       Global.getTour().add(this.view);
/*    */     }
/* 50 */     Global.setView(this.view, this);
/*    */ 
/*    */     
/* 53 */     if (!Global.getView().getVPhotoPoints().contains(this.photoPoint))
/*    */     {
/* 55 */       this.view.add(this.photoPoint);
/*    */     }
/* 57 */     Global.setPhotoPoint(this.photoPoint, this);
/*    */ 
/*    */     
/* 60 */     this.photoPoint.add(this.photo);
/* 61 */     Global.setPhoto(this.photo, this);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\DeleteSelectedPhotoCommand.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */