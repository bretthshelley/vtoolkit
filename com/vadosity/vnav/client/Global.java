/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import java.awt.Component;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.Iterator;
/*     */ import java.util.TreeMap;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class Global {
/*  12 */   private static Container windowContainer = null;
/*     */   
/*     */   public static Container getWindowContainer() {
/*  15 */     return windowContainer;
/*     */   }
/*     */   
/*     */   public static void setWindowContainer(Container c) {
/*  19 */     windowContainer = c;
/*     */   }
/*     */   
/*     */   public static boolean loadingTour = false;
/*     */   
/*     */   public static boolean isLoadingTour() {
/*  25 */     return loadingTour;
/*     */   }
/*     */   public static void setLoadingTour(boolean loadingTour) {
/*  28 */     Global.loadingTour = loadingTour;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  33 */   public static int selectedPhotoIndex = 0;
/*  34 */   private static double movementAngle = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void keyPressed(KeyEvent e) {
/*  40 */     if (e.getKeyCode() == 39) {
/*     */       
/*  42 */       if (e.isAltDown()) { selectLastPhoto("a"); }
/*  43 */       else { selectNextPhoto("a"); }
/*     */ 
/*     */     
/*  46 */     } else if (e.getKeyCode() == 37) {
/*     */       
/*  48 */       if (e.isAltDown()) { selectFirstPhoto("a"); }
/*  49 */       else { selectPreviousPhoto("a"); }
/*     */ 
/*     */     
/*  52 */     } else if (e.getKeyCode() == 38) {
/*     */       
/*  54 */       if (e.isAltDown()) { selectLastPhoto("a"); }
/*  55 */       else { selectNextPhoto("a"); }
/*     */ 
/*     */     
/*  58 */     } else if (e.getKeyCode() == 40) {
/*     */       
/*  60 */       if (e.isAltDown()) { selectFirstPhoto("a"); }
/*  61 */       else { selectPreviousPhoto("a"); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  67 */   private static AutoRunner runner = null;
/*  68 */   public static synchronized AutoRunner getAutoRunner() { return runner; } public static synchronized void setAutoRunner(AutoRunner autoRunner) {
/*  69 */     runner = autoRunner;
/*     */   }
/*     */   public static void stopRunner() {
/*  72 */     if (runner == null)
/*  73 */       return;  runner.setOkToContinue(false);
/*  74 */     fireSettingsChanged("runner stopping");
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isRunnerAlive() {
/*  79 */     if (runner == null) return false; 
/*  80 */     return runner.isOkToContinue();
/*     */   }
/*     */   
/*  83 */   private static Vector vRepaintListeners = new Vector(); public static Vector getRepaintListeners() {
/*  84 */     return vGlobalChangeListeners;
/*     */   }
/*     */   public static void addRepaintListener(Component component) {
/*  87 */     if (component == null)
/*  88 */       return;  if (vRepaintListeners.contains(component))
/*  89 */       return;  vRepaintListeners.add(component);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeRepaintListener(Component component) {
/*  94 */     if (component == null)
/*  95 */       return;  vRepaintListeners.remove(component);
/*     */   }
/*     */   
/*     */   public static void clearRepaintListeners() {
/*  99 */     vRepaintListeners.removeAllElements();
/* 100 */     vRepaintListeners = null;
/* 101 */     vRepaintListeners = new Vector();
/*     */   }
/*     */   
/*     */   public static void fireRepaint(Photo photo) {
/* 105 */     if (vRepaintListeners == null || vRepaintListeners.size() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 110 */     int w = 50;
/* 111 */     int x = photo.getPhotoPoint().getX();
/* 112 */     int y = photo.getPhotoPoint().getY();
/* 113 */     for (int i = 0; i < vRepaintListeners.size(); i++)
/*     */     {
/* 115 */       ((Component)vRepaintListeners.elementAt(i)).repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   private static Vector vGlobalChangeListeners = new Vector(); public static Vector getGlobalChangeListeners() {
/* 124 */     return vGlobalChangeListeners;
/*     */   }
/*     */   public static void addGlobalChangeListener(GlobalChangeListener listener) {
/* 127 */     if (listener == null)
/* 128 */       return;  if (vGlobalChangeListeners.contains(listener))
/* 129 */       return;  vGlobalChangeListeners.add(listener);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeGlobalChangeListener(GlobalChangeListener listener) {
/* 134 */     if (listener == null)
/* 135 */       return;  vGlobalChangeListeners.remove(listener);
/*     */   }
/*     */   
/*     */   public static void clearGlobalChangeListeners() {
/* 139 */     vGlobalChangeListeners.removeAllElements();
/* 140 */     vGlobalChangeListeners = null;
/* 141 */     vGlobalChangeListeners = new Vector();
/*     */   }
/*     */   
/* 144 */   private static Vector vSettingsChangeListeners = new Vector();
/*     */   
/*     */   public static void addSettingsChangeListener(SettingsChangeListener listener) {
/* 147 */     if (listener == null)
/* 148 */       return;  vSettingsChangeListeners.add(listener);
/*     */   }
/*     */   
/*     */   public static void removeSettingsChangeListener(SettingsChangeListener listener) {
/* 152 */     if (listener == null)
/* 153 */       return;  vSettingsChangeListeners.remove(listener);
/*     */   }
/*     */   
/*     */   public static void clearSettingsChangeListeners() {
/* 157 */     vSettingsChangeListeners.removeAllElements();
/* 158 */     vSettingsChangeListeners = null;
/* 159 */     vSettingsChangeListeners = new Vector();
/*     */   }
/*     */   
/*     */   public static void fireSettingsChanged(Object src) {
/* 163 */     if (vSettingsChangeListeners == null || vSettingsChangeListeners.size() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 167 */     for (int i = 0; i < vSettingsChangeListeners.size(); i++) {
/*     */ 
/*     */       
/*     */       try {
/* 171 */         ((SettingsChangeListener)vSettingsChangeListeners.elementAt(i)).settingsChanged(src);
/*     */       }
/* 173 */       catch (Exception exception) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 181 */   private static Tour scoutTour = null;
/*     */ 
/*     */   
/*     */   public static Tour getTour() {
/* 185 */     return scoutTour;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setTour(Tour sl, Object src) {
/*     */     try {
/* 191 */       scoutTour = sl;
/*     */       
/* 193 */       if (vGlobalChangeListeners == null || vGlobalChangeListeners.isEmpty())
/*     */         return; 
/* 195 */       for (int i = 0; i < vGlobalChangeListeners.size(); i++) {
/*     */         
/* 197 */         if (vGlobalChangeListeners.elementAt(i) == null) {
/*     */           
/* 199 */           vGlobalChangeListeners.remove(i);
/* 200 */           i--;
/*     */         } else {
/*     */ 
/*     */           
/*     */           try {
/* 205 */             ((GlobalChangeListener)vGlobalChangeListeners.elementAt(i)).tourChanged(scoutTour, src);
/*     */           }
/* 207 */           catch (Exception e) {
/*     */             
/* 209 */             e.printStackTrace();
/*     */           } 
/*     */         } 
/*     */       } 
/* 213 */     } catch (RuntimeException e) {
/*     */       
/* 215 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setModified() {
/* 221 */     if (getTour() != null) getTour().setModified(true); 
/*     */   }
/*     */   
/* 224 */   private static View selectedView = null; public static View getView() {
/* 225 */     return selectedView;
/*     */   }
/*     */   public static void setView(View view, Object src) {
/* 228 */     selectedView = view;
/* 229 */     if (view != null && view.getPhotos().isEmpty()) {
/*     */       
/* 231 */       setPhoto(null, src);
/* 232 */       setPhotoPoint(null, src);
/*     */     } 
/*     */     
/* 235 */     fireSelectedViewChanged(src);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void fireSelectedViewChanged(Object src) {
/* 240 */     if (vGlobalChangeListeners == null || vGlobalChangeListeners.isEmpty())
/*     */       return; 
/* 242 */     for (int i = 0; i < vGlobalChangeListeners.size(); i++) {
/*     */ 
/*     */       
/*     */       try {
/* 246 */         ((GlobalChangeListener)vGlobalChangeListeners.elementAt(i)).viewChanged(selectedView, src);
/*     */       }
/* 248 */       catch (Exception e) {
/*     */         
/* 250 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 256 */   private static PhotoPoint selectedPhotoPoint = null; public static PhotoPoint getPhotoPoint() {
/* 257 */     return selectedPhotoPoint;
/*     */   }
/*     */   public static void setPhotoPoint(PhotoPoint pt, Object src) {
/* 260 */     selectedPhotoPoint = pt;
/* 261 */     fireSelectedPhotoPointChanged(src);
/*     */   }
/*     */   
/*     */   public static void fireSelectedPhotoPointChanged(Object src) {
/* 265 */     if (vGlobalChangeListeners == null || vGlobalChangeListeners.isEmpty())
/*     */       return; 
/* 267 */     for (int i = 0; i < vGlobalChangeListeners.size(); i++)
/*     */     {
/* 269 */       ((GlobalChangeListener)vGlobalChangeListeners.elementAt(i)).photoPointChanged(selectedPhotoPoint, src);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 274 */   private static Photo selectedPhoto = null; public static Photo getPhoto() {
/* 275 */     return selectedPhoto;
/*     */   }
/*     */   public static void setPhoto(Photo photo, Object src) {
/* 278 */     selectedPhoto = photo;
/*     */ 
/*     */     
/* 281 */     if (photo == null) {
/*     */       
/* 283 */       Settings.setEditAngleMode(false);
/*     */     }
/*     */     else {
/*     */       
/* 287 */       Settings.setEditAngleMode(true);
/* 288 */       Settings.setAddPanoramicPhotos(photo.isPanoramic());
/* 289 */       if (photo.isPanoramic()) {
/*     */         
/* 291 */         Settings.setClockwise(photo.isClockwise());
/* 292 */         Settings.setFullCircle(photo.isCompleteRevolution());
/*     */       } 
/*     */     } 
/* 295 */     fireSettingsChanged("");
/* 296 */     fireSelectedPhotoChanged(src);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void fireSelectedPhotoChanged(Object src) {
/* 301 */     if (vGlobalChangeListeners == null || vGlobalChangeListeners.size() == 0) {
/*     */       return;
/*     */     }
/* 304 */     for (int i = 0; i < vGlobalChangeListeners.size(); i++) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 309 */         ((GlobalChangeListener)vGlobalChangeListeners.elementAt(i)).photoChanged(selectedPhoto, src);
/*     */       }
/* 311 */       catch (Exception exception) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearGlobalValues() {
/* 320 */     setTour(null, "");
/* 321 */     setView(null, "");
/* 322 */     setPhotoPoint(null, "");
/* 323 */     setPhoto(null, "");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSelectedPhotoIndex(int index) {
/* 328 */     selectedPhotoIndex = index;
/*     */   }
/*     */   
/*     */   public static int getSelectedPhotoIndex() {
/* 332 */     return selectedPhotoIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void selectFirstPhoto(Object src) {
/* 337 */     if (getView() == null)
/*     */       return; 
/* 339 */     if (getView().getVPhotoPoints() == null || 
/* 340 */       getView().getVPhotoPoints().isEmpty())
/*     */       return; 
/* 342 */     Photo firstPhoto = getView().getPhotos().firstElement();
/* 343 */     if (firstPhoto != null) {
/*     */       
/* 345 */       setPhotoPoint(firstPhoto.getPhotoPoint(), src);
/* 346 */       setPhoto(firstPhoto, src);
/* 347 */       setSelectedPhotoIndex(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void selectLastPhoto(Object src) {
/* 355 */     if (getView() == null)
/*     */       return; 
/* 357 */     if (getView().getVPhotoPoints() == null || 
/* 358 */       getView().getVPhotoPoints().isEmpty())
/*     */       return; 
/* 360 */     Photo lastPhoto = getView().getPhotos().lastElement();
/*     */     
/* 362 */     if (lastPhoto != null) {
/*     */       
/* 364 */       setSelectedPhotoIndex(getView().getPhotos().size() - 1);
/* 365 */       setPhotoPoint(lastPhoto.getPhotoPoint(), src);
/* 366 */       setPhoto(lastPhoto, src);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Photo getNextPhoto() {
/* 372 */     if (getView() == null) return null;
/*     */     
/* 374 */     if (getView().getVPhotoPoints() == null || 
/* 375 */       getView().getVPhotoPoints().isEmpty()) return null;
/*     */     
/* 377 */     Photo photo = getPhoto();
/* 378 */     PhotoPoint photoPoint = getPhotoPoint();
/*     */     
/* 380 */     if (photo == null && photoPoint == null) {
/*     */ 
/*     */       
/* 383 */       if (getView().getPhotos().size() == 0) return null; 
/* 384 */       Photo p = getView().getPhotos().elementAt(0);
/* 385 */       return p;
/*     */     } 
/*     */ 
/*     */     
/* 389 */     Vector vPhotos = getView().getPhotos();
/* 390 */     for (int i = 0; i < vPhotos.size(); i++) {
/*     */       
/* 392 */       Photo ithPhoto = vPhotos.elementAt(i);
/* 393 */       if (photo.equals(ithPhoto)) {
/*     */ 
/*     */         
/* 396 */         i++;
/* 397 */         if (i == vPhotos.size()) i = 0; 
/* 398 */         Photo nextPhoto = vPhotos.elementAt(i);
/* 399 */         return nextPhoto;
/*     */       } 
/*     */     } 
/* 402 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void selectNextPhoto(Object src) {
/* 408 */     if (getView() == null)
/*     */       return; 
/* 410 */     if (getView().getVPhotoPoints() == null || 
/* 411 */       getView().getVPhotoPoints().isEmpty()) {
/*     */       return;
/*     */     }
/* 414 */     Photo photo = getPhoto();
/* 415 */     PhotoPoint photoPoint = getPhotoPoint();
/*     */     
/* 417 */     if (photo == null && photoPoint == null) {
/*     */ 
/*     */       
/* 420 */       if (getView().getPhotos().size() == 0)
/* 421 */         return;  Photo p = getView().getPhotos().elementAt(0);
/* 422 */       setSelectedPhotoIndex(0);
/* 423 */       setPhotoPoint(p.getPhotoPoint(), src);
/* 424 */       setPhoto(p, src);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/* 433 */       Vector vPhotos = getView().getPhotos();
/* 434 */       for (int i = 0; i < vPhotos.size(); i++) {
/*     */         
/* 436 */         Photo ithPhoto = vPhotos.elementAt(i);
/* 437 */         if (photo.equals(ithPhoto)) {
/*     */ 
/*     */           
/* 440 */           i++;
/* 441 */           if (i == vPhotos.size()) i = 0; 
/* 442 */           Photo nextPhoto = vPhotos.elementAt(i);
/* 443 */           setPhotoPoint(nextPhoto.getPhotoPoint(), src);
/* 444 */           setPhoto(nextPhoto, src);
/* 445 */           setSelectedPhotoIndex(i);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void selectNextClockwisePhoto(Object src) {
/* 460 */     if (getPhotoPoint() == null || 
/* 461 */       !getPhotoPoint().hasMultiplePhotos() || 
/* 462 */       getPhoto() == null)
/*     */       return; 
/* 464 */     Photo photo = getPhoto();
/* 465 */     PhotoPoint photoPoint = getPhotoPoint();
/*     */ 
/*     */ 
/*     */     
/* 469 */     TreeMap tm = new TreeMap();
/*     */     
/* 471 */     Vector vPhotos = photoPoint.getVPhotos();
/* 472 */     for (int i = 0; i < vPhotos.size(); i++) {
/*     */       
/* 474 */       Photo p = vPhotos.elementAt(i);
/*     */ 
/*     */       
/* 477 */       Double d = null;
/* 478 */       double degrees = Math.toDegrees(p.getStartAngle());
/* 479 */       degrees = Math.round(degrees);
/* 480 */       if (degrees > 360.0D) { d = new Double(degrees % 360.0D); }
/* 481 */       else if (degrees >= 0.0D) { d = new Double(degrees); }
/* 482 */       else if (degrees < 0.0D) { d = new Double(360.0D + degrees); }
/* 483 */        tm.put(d, p);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 488 */     Iterator it = tm.values().iterator();
/* 489 */     Photo first = null;
/* 490 */     while (it.hasNext()) {
/*     */       
/* 492 */       Photo ithPhoto = it.next();
/* 493 */       if (first == null) first = ithPhoto; 
/* 494 */       if (ithPhoto.equals(photo)) {
/*     */ 
/*     */         
/* 497 */         if (it.hasNext()) {
/*     */           
/* 499 */           setPhoto(it.next(), src);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/* 505 */         setPhoto(first, src);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void selectNextCounterClockwisePhoto(Object src) {
/* 515 */     if (getPhotoPoint() == null || 
/* 516 */       !getPhotoPoint().hasMultiplePhotos() || 
/* 517 */       getPhoto() == null)
/*     */       return; 
/* 519 */     Photo photo = getPhoto();
/* 520 */     PhotoPoint photoPoint = getPhotoPoint();
/*     */ 
/*     */ 
/*     */     
/* 524 */     TreeMap tm = new TreeMap();
/*     */     
/* 526 */     Vector vPhotos = photoPoint.getVPhotos();
/* 527 */     for (int i = 0; i < vPhotos.size(); i++) {
/*     */       
/* 529 */       Photo p = vPhotos.elementAt(i);
/*     */ 
/*     */       
/* 532 */       Double d = null;
/* 533 */       double degrees = Math.toDegrees(p.getStartAngle());
/* 534 */       degrees = Math.round(degrees);
/* 535 */       if (degrees > 360.0D) { d = new Double(-(degrees % 360.0D)); }
/* 536 */       else if (degrees >= 0.0D) { d = new Double(-degrees); }
/* 537 */       else if (degrees < 0.0D) { d = new Double(-(360.0D + degrees)); }
/* 538 */        tm.put(d, p);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 543 */     Iterator it = tm.values().iterator();
/* 544 */     Photo first = null;
/* 545 */     while (it.hasNext()) {
/*     */       
/* 547 */       Photo ithPhoto = it.next();
/* 548 */       if (first == null) first = ithPhoto; 
/* 549 */       if (ithPhoto.equals(photo)) {
/*     */ 
/*     */         
/* 552 */         if (it.hasNext()) {
/*     */           
/* 554 */           setPhoto(it.next(), src);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/* 560 */         setPhoto(first, src);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void selectNextPhotoPoint(Object src) {
/* 574 */     if (getView() == null)
/*     */       return; 
/* 576 */     if (getView().getVPhotoPoints() == null || 
/* 577 */       getView().getVPhotoPoints().isEmpty())
/*     */       return; 
/* 579 */     Photo photo = getPhoto();
/* 580 */     PhotoPoint photoPoint = getPhotoPoint();
/*     */     
/* 582 */     if (photo == null && photoPoint == null) {
/*     */ 
/*     */       
/* 585 */       if (getView().getPhotos().size() == 0)
/* 586 */         return;  Photo p = getView().getPhotos().elementAt(0);
/* 587 */       setPhotoPoint(p.getPhotoPoint(), src);
/* 588 */       setPhoto(p, src);
/* 589 */       setSelectedPhotoIndex(0);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 594 */       Vector vPhotoPoints = (Vector)getView().getVPhotoPoints();
/* 595 */       for (int i = 0; i < vPhotoPoints.size(); i++) {
/*     */         
/* 597 */         PhotoPoint ithPhotoPoint = vPhotoPoints.elementAt(i);
/* 598 */         if (photoPoint.equals(ithPhotoPoint)) {
/*     */ 
/*     */           
/* 601 */           i++;
/* 602 */           if (i == vPhotoPoints.size()) i = 0; 
/* 603 */           PhotoPoint nextPhotoPoint = vPhotoPoints.elementAt(i);
/* 604 */           setPhotoPoint(nextPhotoPoint, src);
/* 605 */           setPhoto(nextPhotoPoint.getFirstPhoto(), src);
/* 606 */           setSelectedPhotoIndex(i);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized Photo getPreviousPhoto() {
/* 617 */     if (getView() == null) return null;
/*     */     
/* 619 */     if (getView().getVPhotoPoints() == null || 
/* 620 */       getView().getVPhotoPoints().isEmpty()) return null;
/*     */     
/* 622 */     Photo photo = getPhoto();
/* 623 */     PhotoPoint photoPoint = getPhotoPoint();
/*     */     
/* 625 */     if (photo == null && photoPoint == null) {
/*     */ 
/*     */       
/* 628 */       if (getView().getPhotos().size() == 0) return null; 
/* 629 */       Photo p = getView().getPhotos().elementAt(0);
/* 630 */       return p;
/*     */     } 
/*     */ 
/*     */     
/* 634 */     Vector vPhotos = getView().getPhotos();
/* 635 */     for (int i = 0; i < vPhotos.size(); i++) {
/*     */       
/* 637 */       Photo ithPhoto = vPhotos.elementAt(i);
/* 638 */       if (photo.equals(ithPhoto)) {
/*     */ 
/*     */         
/* 641 */         i--;
/* 642 */         if (i == -1) i = vPhotos.size() - 1; 
/* 643 */         Photo previousPhoto = vPhotos.elementAt(i);
/* 644 */         return previousPhoto;
/*     */       } 
/*     */     } 
/* 647 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void selectPreviousPhoto(Object src) {
/* 654 */     if (getView() == null)
/*     */       return; 
/* 656 */     if (getView().getVPhotoPoints() == null || 
/* 657 */       getView().getVPhotoPoints().isEmpty())
/*     */       return; 
/* 659 */     Photo photo = getPhoto();
/* 660 */     PhotoPoint photoPoint = getPhotoPoint();
/*     */     
/* 662 */     if (photo == null && photoPoint == null) {
/*     */ 
/*     */       
/* 665 */       if (getView().getPhotos().size() == 0)
/* 666 */         return;  Photo p = getView().getPhotos().elementAt(0);
/* 667 */       setPhoto(p, src);
/* 668 */       setPhotoPoint(p.getPhotoPoint(), src);
/* 669 */       setSelectedPhotoIndex(0);
/*     */     }
/*     */     else {
/*     */       
/* 673 */       Vector vPhotos = getView().getPhotos();
/* 674 */       for (int i = 0; i < vPhotos.size(); i++) {
/*     */         
/* 676 */         Photo ithPhoto = vPhotos.elementAt(i);
/* 677 */         if (photo.equals(ithPhoto)) {
/*     */ 
/*     */           
/* 680 */           i--;
/* 681 */           if (i == -1) i = vPhotos.size() - 1; 
/* 682 */           Photo nextPhoto = vPhotos.elementAt(i);
/* 683 */           setPhoto(nextPhoto, src);
/* 684 */           setPhotoPoint(nextPhoto.getPhotoPoint(), src);
/* 685 */           setSelectedPhotoIndex(i);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void selectPreviousPhotoPoint(Object src) {
/* 697 */     if (getView() == null)
/*     */       return; 
/* 699 */     if (getView().getVPhotoPoints() == null || 
/* 700 */       getView().getVPhotoPoints().isEmpty())
/*     */       return; 
/* 702 */     Photo photo = getPhoto();
/* 703 */     PhotoPoint photoPoint = getPhotoPoint();
/*     */     
/* 705 */     if (photo == null && photoPoint == null) {
/*     */ 
/*     */       
/* 708 */       if (getView().getPhotos().size() == 0)
/* 709 */         return;  Photo p = getView().getPhotos().elementAt(0);
/* 710 */       setPhotoPoint(p.getPhotoPoint(), src);
/* 711 */       setPhoto(p, src);
/*     */     }
/*     */     else {
/*     */       
/* 715 */       Vector vPhotoPoints = (Vector)getView().getVPhotoPoints();
/* 716 */       for (int i = 0; i < vPhotoPoints.size(); i++) {
/*     */         
/* 718 */         PhotoPoint ithPhotoPoint = vPhotoPoints.elementAt(i);
/* 719 */         if (photoPoint.equals(ithPhotoPoint)) {
/*     */ 
/*     */           
/* 722 */           i--;
/* 723 */           if (i == -1) i = vPhotoPoints.size() - 1; 
/* 724 */           PhotoPoint nextPhotoPoint = vPhotoPoints.elementAt(i);
/* 725 */           setPhoto(nextPhotoPoint.getFirstPhoto(), src);
/* 726 */           setPhotoPoint(nextPhotoPoint, src);
/* 727 */           setSelectedPhotoIndex(i);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setMovementAngle(double movementAngle) {
/* 737 */     Global.movementAngle = movementAngle;
/*     */   }
/*     */   
/*     */   public static double getMovementAngle() {
/* 741 */     return movementAngle;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\Global.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */