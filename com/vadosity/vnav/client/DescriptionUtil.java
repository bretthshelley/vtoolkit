/*    */ package com.vadosity.vnav.client;
/*    */ import com.vadosity.vnav.bean.Photo;
/*    */ import com.vadosity.vnav.bean.Tour;
/*    */ import com.vadosity.vnav.bean.View;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class DescriptionUtil {
/*  8 */   private static Vector vListeners = new Vector();
/*    */   
/*    */   public static void addListener(DescriptionChangeListener listener) {
/* 11 */     if (listener == null)
/* 12 */       return;  vListeners.add(listener);
/*    */   }
/*    */   
/*    */   public static void removeListener(DescriptionChangeListener listener) {
/* 16 */     if (listener == null)
/* 17 */       return;  vListeners.remove(listener);
/*    */   }
/*    */   
/*    */   public static void clearListeners() {
/* 21 */     vListeners.removeAllElements();
/* 22 */     vListeners = new Vector();
/*    */   }
/*    */   
/*    */   public static void fireDescriptionChanged(DescribedObject describedObject, Object src) {
/* 26 */     for (int i = 0; i < vListeners.size(); i++)
/*    */     {
/* 28 */       ((DescriptionChangeListener)vListeners.elementAt(i)).descriptionChanged(describedObject, src);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isTourTreeDescribed(Tour tour) {
/* 35 */     if (tour == null) throw new IllegalArgumentException("tour is null");
/*    */     
/* 37 */     if (isTourDescribed(tour)) return true;
/*    */     
/* 39 */     Vector vViews = tour.getViews();
/* 40 */     if (vViews == null || vViews.size() == 0) return false;
/*    */     
/* 42 */     View ithView = null;
/* 43 */     for (int i = 0; i < vViews.size(); i++) {
/*    */       
/* 45 */       ithView = vViews.elementAt(i);
/* 46 */       if (ithView != null && 
/* 47 */         isViewTreeDescribed(ithView)) return true; 
/*    */     } 
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isViewTreeDescribed(View view) {
/* 54 */     if (view == null) throw new IllegalArgumentException("view is null");
/*    */     
/* 56 */     if (isViewDescribed(view)) return true;
/*    */     
/* 58 */     Vector vPhotos = view.getPhotos();
/* 59 */     if (vPhotos == null || vPhotos.size() == 0) return false;
/*    */     
/* 61 */     Photo ithPhoto = null;
/* 62 */     for (int i = 0; i < vPhotos.size(); i++) {
/*    */       
/* 64 */       ithPhoto = vPhotos.elementAt(i);
/* 65 */       if (ithPhoto != null && 
/* 66 */         isPhotoDescribed(ithPhoto)) return true; 
/*    */     } 
/* 68 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isTourDescribed(Tour tour) {
/* 74 */     if (tour == null) throw new IllegalArgumentException("tour is null"); 
/* 75 */     return (tour.getDescription() != null && !tour.getDescription().trim().equals(""));
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isViewDescribed(View view) {
/* 80 */     if (view == null) throw new IllegalArgumentException("view is null"); 
/* 81 */     return (view.getDescription() != null && !view.getDescription().trim().equals(""));
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isPhotoDescribed(Photo photo) {
/* 86 */     if (photo == null) throw new IllegalArgumentException("photo is null"); 
/* 87 */     return (photo.getDescription() != null && !photo.getDescription().trim().equals(""));
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\DescriptionUtil.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */