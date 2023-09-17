/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Iterator;
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
/*     */ class DNDPhotoResizingThread
/*     */   extends Thread
/*     */ {
/* 103 */   WaitDialog waitDlg = null;
/* 104 */   Iterator fileIterator = null;
/* 105 */   VadosityToolkit vt = null;
/*     */ 
/*     */ 
/*     */   
/*     */   DNDPhotoResizingThread(WaitDialog dlg, Iterator fileIt, VadosityToolkit vt) {
/* 110 */     this.waitDlg = dlg;
/* 111 */     this.fileIterator = fileIt;
/* 112 */     this.vt = vt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 119 */     while (this.fileIterator.hasNext()) {
/*     */       
/* 121 */       File f = this.fileIterator.next();
/*     */       
/* 123 */       if (f.getName().toLowerCase().indexOf(".jpg") == -1)
/* 124 */         continue;  this.waitDlg.setTitle("Processing: " + f.getName());
/*     */ 
/*     */       
/* 127 */       this.waitDlg.step();
/*     */     } 
/* 129 */     this.waitDlg.dispose();
/* 130 */     this.vt.setupPhotoDirectory(RegistryInterface.getCurrentProjectDirectory().getAbsolutePath());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WaitDialog getWaitDlg() {
/* 136 */     return this.waitDlg;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWaitDlg(WaitDialog waitDlg) {
/* 141 */     this.waitDlg = waitDlg;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\DNDPhotoResizingThread.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */