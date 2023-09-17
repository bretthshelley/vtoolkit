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
/*     */ class SliderSimulator
/*     */   extends Thread
/*     */ {
/*     */   private long waitTime;
/*     */   final AlphaSlider this$0;
/*     */   
/*     */   SliderSimulator(AlphaSlider paramAlphaSlider) {
/* 131 */     this.this$0 = paramAlphaSlider;
/*     */     
/* 133 */     this.waitTime = 500L;
/* 134 */   } public long getWaitTime() { return this.waitTime; } public void setWaitTime(long milliseconds) {
/* 135 */     this.waitTime = milliseconds;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 141 */       Thread.sleep(this.waitTime);
/*     */       
/* 143 */       int startValue = this.this$0.getValue();
/*     */       
/* 145 */       if (startValue < 50) {
/*     */         int i;
/* 147 */         for (i = startValue; i <= this.this$0.getMaximum(); i += 5) {
/*     */           
/* 149 */           this.this$0.setValue(i);
/* 150 */           this.this$0.updateUI();
/* 151 */           Thread.sleep(50L);
/*     */         } 
/* 153 */         for (i = this.this$0.getMaximum(); i > startValue; i -= 5) {
/*     */           
/* 155 */           this.this$0.setValue(i);
/* 156 */           Thread.sleep(50L);
/* 157 */           this.this$0.updateUI();
/*     */         } 
/*     */       } else {
/*     */         int i;
/*     */ 
/*     */         
/* 163 */         for (i = startValue; i > 0; i -= 5) {
/*     */           
/* 165 */           this.this$0.setValue(i);
/* 166 */           this.this$0.updateUI();
/* 167 */           Thread.sleep(50L);
/*     */         } 
/* 169 */         for (i = 0; i < startValue; i += 5)
/*     */         {
/* 171 */           this.this$0.setValue(i);
/* 172 */           Thread.sleep(50L);
/* 173 */           this.this$0.updateUI();
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 178 */     } catch (Exception exception) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AlphaSlider$SliderSimulator.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */