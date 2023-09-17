/*     */ package com.vadosity.vnav.client;
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
/*     */ class MultiPanelInitializer
/*     */   extends Thread
/*     */ {
/*  86 */   private MultiPanel multiPanel = null;
/*     */   
/*     */   MultiPanelInitializer(MultiPanel mp) {
/*  89 */     this.multiPanel = mp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  97 */       Thread.sleep(2500L);
/*  98 */       this.multiPanel.anglePanel.setStartAngle(Math.toRadians(225.0D));
/*     */     }
/* 100 */     catch (Exception e) {
/*     */       
/* 102 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\MultiPanelInitializer.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */