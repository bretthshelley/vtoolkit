/*    */ package com.vadosity.vnav.client;
/*    */ 
/*    */ import com.vadosity.vnav.bean.PhotoPoint;
/*    */ import com.vadosity.vnav.bean.View;
/*    */ import java.awt.Graphics;
/*    */ import java.util.Iterator;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class Trail {
/* 10 */   private Vector vFeet = new Vector();
/* 11 */   private View view = null;
/*    */ 
/*    */   
/*    */   public Trail(View view) {
/* 15 */     if (view == null)
/* 16 */       return;  this.view = view;
/* 17 */     doCalculations();
/*    */   }
/*    */ 
/*    */   
/*    */   public void doCalculations() {
/* 22 */     if (Global.getTour().isLocked())
/*    */       return; 
/* 24 */     if (this.view.getVPhotoPoints() == null || this.view.getVPhotoPoints().size() < 2)
/*    */       return; 
/* 26 */     Iterator it = this.view.getVPhotoPoints().iterator();
/* 27 */     this.vFeet = null;
/* 28 */     this.vFeet = new Vector();
/* 29 */     while (it.hasNext()) {
/*    */       
/* 31 */       PhotoPoint pt = it.next();
/* 32 */       if (pt == null || (
/* 33 */         pt.getFirstPhoto().isPanoramic() && !pt.hasMultiplePhotos()))
/* 34 */         continue;  AngledFootstep step = new AngledFootstep(pt.getPoint(), pt.getFirstPhoto().getStartAngle());
/* 35 */       this.vFeet.add(step);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 42 */     for (int i = 0; i < this.vFeet.size(); i++) {
/*    */       
/* 44 */       if (this.vFeet.elementAt(i) instanceof AngledFootstep)
/*    */       {
/* 46 */         ((AngledFootstep)this.vFeet.elementAt(i)).paint(g);
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\Trail.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */