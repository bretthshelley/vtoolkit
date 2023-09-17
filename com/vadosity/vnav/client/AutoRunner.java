/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import javax.swing.SwingUtilities;
/*     */ 
/*     */ 
/*     */ public class AutoRunner
/*     */   extends Thread
/*     */ {
/*     */   public boolean waitToInitialize = false;
/*  10 */   public long waitToInitializeTime = 6000L; private boolean okToContinue = true;
/*     */   
/*     */   public boolean isOkToContinue() {
/*  13 */     return this.okToContinue;
/*     */   }
/*     */   public void setOkToContinue(boolean b) {
/*  16 */     this.okToContinue = b;
/*  17 */     if (!this.okToContinue) panning = false; 
/*     */   }
/*     */   
/*  20 */   private static long sleepTime = 1000L;
/*  21 */   public static long getSleepTime() { return sleepTime; } public static void setSleepTime(long time) {
/*  22 */     sleepTime = time;
/*     */   }
/*     */   private boolean runForward = true;
/*  25 */   public boolean isRunForward() { return this.runForward; } public void setRunForward(boolean b) {
/*  26 */     this.runForward = b;
/*     */   }
/*     */   private static boolean stopPanning = false;
/*  29 */   public static boolean isStopPanning() { return stopPanning; } public static void setStopPanning(boolean b) {
/*  30 */     stopPanning = b;
/*     */   }
/*     */   private static boolean panning = false;
/*  33 */   public static boolean isPanning() { return panning; } public static void setPanning(boolean b) {
/*  34 */     panning = b;
/*     */   }
/*     */   private static boolean turnAngleCalculated = false;
/*  37 */   public static boolean isTurnAngleCalculated() { return turnAngleCalculated; } public static void setTurnAngleCalculated(boolean b) {
/*  38 */     turnAngleCalculated = b;
/*     */   }
/*  40 */   private int panDirection = -1;
/*     */ 
/*     */   
/*     */   public void run() {
/*  44 */     stopPanning = false;
/*  45 */     this.okToContinue = true;
/*  46 */     if (Global.getView() == null || Global.getView().getPhotos().size() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  53 */       if (this.waitToInitialize) {
/*     */         
/*  55 */         Thread.sleep(this.waitToInitializeTime);
/*  56 */         this.waitToInitialize = false;
/*     */       } 
/*  58 */       while (this.okToContinue) {
/*     */ 
/*     */         
/*  61 */         Runnable doSelectNextPhoto = new Runnable(this) {
/*     */             final AutoRunner this$0;
/*     */             
/*     */             public void run() {
/*  65 */               Global.getPhoto().isPanoramic();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  80 */               if (this.this$0.runForward)
/*     */               {
/*  82 */                 Global.selectNextPhoto(this);
/*     */               }
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*  89 */         SwingUtilities.invokeLater(doSelectNextPhoto);
/*  90 */         Thread.sleep(getSleepTime());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 114 */       panning = false;
/* 115 */       turnAngleCalculated = false;
/* 116 */       stopPanning = false;
/*     */     }
/* 118 */     catch (Exception e) {
/*     */ 
/*     */       
/* 121 */       panning = false;
/* 122 */       turnAngleCalculated = false;
/* 123 */       stopPanning = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AutoRunner.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */