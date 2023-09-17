/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.Tour;
/*     */ import java.io.File;
/*     */ import java.text.MessageFormat;
/*     */ import javax.swing.SwingUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ImportImagesThread
/*     */   extends Thread
/*     */ {
/*     */   String sourceDirectory;
/*     */   String targetDirectory;
/*     */   int targetWidth;
/*     */   int targetHeight;
/*     */   boolean skipImport;
/*     */   final ImportPhotosDialog this$0;
/*     */   
/*     */   ImportImagesThread(ImportPhotosDialog paramImportPhotosDialog, String srcDir, String targetDir, int width, int height) {
/* 355 */     this.this$0 = paramImportPhotosDialog; this.sourceDirectory = null; this.targetDirectory = null; this.targetWidth = 320; this.targetHeight = 240;
/* 356 */     this.sourceDirectory = srcDir;
/* 357 */     this.targetDirectory = targetDir;
/* 358 */     this.skipImport = this.sourceDirectory.toLowerCase().trim().equals(this.targetDirectory.toLowerCase().trim());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void determineTargetWidths() {
/* 364 */     Tour tour = Global.getTour();
/*     */     
/* 366 */     if (tour == null || tour.getPhotoSize() == 0) {
/*     */ 
/*     */       
/* 369 */       this.targetWidth = 480;
/* 370 */       this.targetHeight = 360;
/*     */     }
/* 372 */     else if (tour.getPhotoSize() == -1) {
/*     */ 
/*     */       
/* 375 */       this.targetWidth = 320;
/* 376 */       this.targetHeight = 240;
/*     */     }
/* 378 */     else if (tour.getPhotoSize() == 1) {
/*     */ 
/*     */       
/* 381 */       this.targetWidth = 640;
/* 382 */       this.targetHeight = 480;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 390 */     determineTargetWidths();
/*     */     
/* 392 */     File src = new File(this.sourceDirectory);
/* 393 */     if (src.isDirectory()) {
/*     */ 
/*     */       
/* 396 */       if (!this.this$0.okToContinue) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 401 */       resizeImages(src, this.targetDirectory);
/* 402 */       SwingUtilities.invokeLater((Runnable)new Object(this));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 413 */       if (!this.this$0.okToContinue) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 418 */       try { Thread.sleep(2000L); } catch (Exception exception) {}
/* 419 */       resizeImage(src.getAbsolutePath(), this.targetDirectory);
/*     */     } 
/*     */     
/* 422 */     SwingUtilities.invokeLater((Runnable)new Object(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resizeImage(String path, String targetDirectory) {
/*     */     try {
/* 441 */       String message = "Resizing {0}";
/* 442 */       String[] arrayOfString = { (new File(path)).getName() };
/* 443 */       message = MessageFormat.format(message, (Object[])arrayOfString);
/* 444 */       this.this$0.lblStatus.setText(message);
/* 445 */       Resizer.resize(this.this$0, 
/* 446 */           path, RegistryInterface.getCurrentProjectDirectory().getAbsolutePath(), 
/* 447 */           this.targetWidth, 
/* 448 */           this.targetHeight);
/* 449 */       this.this$0.filesResized++;
/*     */       
/* 451 */       Thread.sleep(100L);
/*     */     }
/* 453 */     catch (Exception exception) {}
/*     */ 
/*     */     
/* 456 */     this.this$0.progressBarStatus.setValue(this.this$0.progressBarStatus.getValue() + 3);
/*     */     
/* 458 */     String status = "Resized {0} file(s) into 'resized' directory";
/* 459 */     String[] sa = { this.this$0.filesResized };
/* 460 */     status = MessageFormat.format(status, (Object[])sa);
/* 461 */     this.this$0.lblStatus.setText(status);
/* 462 */     if (this.this$0.okToContinue) {
/*     */       
/* 464 */       try { Thread.sleep(1500L); } catch (Exception exception) {}
/* 465 */       this.this$0.progressBarStatus.setValue(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resizeImages(File sourceDirectory, String targetDirectory) {
/* 474 */     File[] files = Resizer.getImageFiles(sourceDirectory);
/* 475 */     if (files == null) {
/*     */ 
/*     */       
/* 478 */       this.this$0.lblStatus.setText("No JPG image files found in directory");
/*     */       
/*     */       return;
/*     */     } 
/* 482 */     this.this$0.progressBarStatus.setMaximum(files.length);
/* 483 */     this.this$0.progressBarStatus.setValue(0);
/*     */     
/* 485 */     for (int i = 0; i < files.length; i++) {
/*     */       
/* 487 */       if (!this.this$0.okToContinue)
/* 488 */         break;  String path = files[i].getAbsolutePath().toLowerCase();
/*     */       
/*     */       try {
/* 491 */         String str = "Resizing {0}";
/* 492 */         String[] arrayOfString = { files[i].getName() };
/* 493 */         str = MessageFormat.format(str, (Object[])arrayOfString);
/* 494 */         this.this$0.lblStatus.setText(str);
/*     */         
/* 496 */         Resizer.resize(this.this$0, 
/* 497 */             path, RegistryInterface.getCurrentProjectDirectory().getAbsolutePath(), 
/* 498 */             this.targetWidth, 
/* 499 */             this.targetHeight);
/* 500 */         this.this$0.filesResized++;
/* 501 */         Thread.sleep(100L);
/*     */       }
/* 503 */       catch (Exception exception) {}
/*     */ 
/*     */       
/* 506 */       this.this$0.progressBarStatus.setValue(this.this$0.progressBarStatus.getValue() + 1);
/*     */     } 
/*     */     
/* 509 */     String status = "Resized {0} files into 'resized' directory";
/* 510 */     String[] sa = { this.this$0.filesResized };
/* 511 */     status = MessageFormat.format(status, (Object[])sa);
/* 512 */     this.this$0.lblStatus.setText(status);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 518 */     try { Thread.sleep(2000L); } catch (Exception exception) {}
/* 519 */     this.this$0.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ImportPhotosDialog$ImportImagesThread.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */