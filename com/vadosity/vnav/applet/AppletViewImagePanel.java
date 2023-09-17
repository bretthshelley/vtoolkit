/*     */ package com.vadosity.vnav.applet;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import com.vadosity.vnav.client.AngledFootstep;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.GraphicsUtil;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class AppletViewImagePanel extends ImagePanel implements GlobalChangeListener, SettingsChangeListener {
/*  20 */   private Image overlayImage = null; public synchronized Image getOverlayImage() {
/*  21 */     return this.overlayImage;
/*     */   }
/*     */   public synchronized void setOverlayImage(Image image) {
/*  24 */     this.overlayImage = image;
/*  25 */     if (image == null) {
/*     */       return;
/*     */     }
/*     */     try {
/*  29 */       this.tracker.addImage(this.overlayImage, 0);
/*  30 */       this.tracker.waitForID(0);
/*  31 */       updateUI();
/*     */     }
/*  33 */     catch (Exception e) {
/*     */       
/*  35 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*  39 */   private Point lastMousePt = null;
/*     */ 
/*     */   
/*     */   public AppletViewImagePanel() {
/*     */     try {
/*  44 */       jbInit();
/*  45 */       Global.addGlobalChangeListener(this);
/*  46 */       Global.addSettingsChangeListener(this);
/*  47 */       Global.addRepaintListener((Component)this);
/*     */       
/*  49 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/*  50 */       UIManager.setLookAndFeel(nativeLF);
/*  51 */       SwingUtilities.updateComponentTreeUI((Component)this);
/*     */     
/*     */     }
/*  54 */     catch (Exception e) {
/*  55 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/*  60 */     addMouseListener(new AppletViewImagePanel_this_mouseAdapter(this));
/*  61 */     setLayout(null);
/*  62 */     addMouseMotionListener(new AppletViewImagePanel_this_mouseMotionAdapter(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  69 */     super.paint(g);
/*  70 */     if (Global.getView() == null) { setImage(null);
/*     */       return; }
/*     */     
/*  73 */     Graphics2D g2d = (Graphics2D)g;
/*  74 */     if (this.overlayImage != null) {
/*     */ 
/*     */       
/*  77 */       g2d.setComposite(AlphaComposite.getInstance(3, (float)Global.getView().getOverlayAlpha()));
/*  78 */       g.drawImage(this.overlayImage, 0, 0, (ImageObserver)this);
/*  79 */       g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
/*     */     } 
/*     */ 
/*     */     
/*  83 */     if (Global.getTour() != null) Global.getTour().doCalculations();
/*     */     
/*  85 */     Collection c = Global.getView().getPhotos();
/*  86 */     if (c != null && !c.isEmpty()) {
/*     */       
/*  88 */       Iterator it = c.iterator();
/*  89 */       while (it.hasNext()) {
/*     */         
/*  91 */         Photo photo = it.next();
/*  92 */         photo.paint(g);
/*  93 */         photo.getPhotoPoint().paint(g);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  98 */     if (Settings.isDrawFootSteps())
/*     */     {
/* 100 */       Global.getView().getTrail().paint(g);
/*     */     }
/*     */     
/* 103 */     if (Global.getPhoto() != null)
/*     */     {
/* 105 */       Global.getPhoto().paint(g);
/*     */     }
/*     */ 
/*     */     
/* 109 */     if (Global.getPhotoPoint() != null && Settings.isDrawFootSteps())
/*     */     {
/* 111 */       if (!Global.getPhoto().isPanoramic()) {
/*     */ 
/*     */         
/* 114 */         AngledFootstep step = new AngledFootstep(
/* 115 */             Global.getPhotoPoint().getPoint(), 
/* 116 */             Global.getPhoto().getStartAngle());
/* 117 */         step.setFillColor(Settings.getSelectedFootstepFillColor());
/* 118 */         step.setOutlineColor(Settings.getSelectedFootstepOutlineColor());
/* 119 */         step.paint(g);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 124 */     if (Settings.isDrawProximity()) paintProximity(g);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void paintProximity(Graphics g) {
/*     */     try {
/* 133 */       Vector vPhotos = Global.getView().getPhotos();
/* 134 */       Photo photo = null;
/*     */       
/* 136 */       for (int i = 0; i < vPhotos.size(); i++)
/*     */       {
/* 138 */         photo = vPhotos.elementAt(i);
/* 139 */         int radius = Settings.getProximityDistance(photo.getPhotoPoint());
/* 140 */         g.setColor(new Color(0, 0, 255, 56));
/* 141 */         g.fillOval(photo.getPhotoPoint().getX() - radius, photo.getPhotoPoint().getY() - radius, radius * 2, radius * 2);
/* 142 */         g.setColor(Color.blue);
/* 143 */         g.drawOval(photo.getPhotoPoint().getX() - radius, photo.getPhotoPoint().getY() - radius, radius * 2, radius * 2);
/*     */       }
/*     */     
/* 146 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseClicked(MouseEvent e) {
/* 155 */     if (Global.getView() == null)
/* 156 */       return;  Collection c = Global.getView().getVPhotoPoints();
/* 157 */     if (c == null || c.isEmpty()) {
/*     */       return;
/*     */     }
/* 160 */     boolean selectedChecked = false;
/* 161 */     Iterator it = c.iterator();
/* 162 */     while (it.hasNext()) {
/*     */       
/* 164 */       PhotoPoint pt = null;
/* 165 */       if (!selectedChecked) {
/*     */         
/* 167 */         pt = Global.getPhotoPoint();
/* 168 */         if (pt == null) pt = it.next(); 
/* 169 */         selectedChecked = true;
/*     */       }
/*     */       else {
/*     */         
/* 173 */         pt = it.next();
/*     */       } 
/*     */       
/* 176 */       int distance = (int)Point.distance((e.getPoint()).x, (e.getPoint()).y, pt.getX(), pt.getY());
/* 177 */       if (distance <= Settings.getProximityDistance(pt)) {
/*     */         
/* 179 */         Global.stopRunner();
/* 180 */         if (pt.equals(Global.getPhotoPoint())) {
/*     */ 
/*     */ 
/*     */           
/* 184 */           if (!Global.getPhoto().isPanoramic() || distance < Settings.getPhotoPointDiameter() / 2) {
/*     */             
/* 186 */             this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 195 */           int lastDistance = (int)Math.floor(Point.distance(this.lastMousePt.x, this.lastMousePt.y, pt.getX(), pt.getY()));
/*     */           
/* 197 */           if (distance < lastDistance) {
/*     */ 
/*     */             
/* 200 */             this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */           
/* 208 */           double d1 = Math.atan2((e.getY() - pt.getY()), (e.getX() - pt.getX()));
/* 209 */           if (d1 < 0.0D) d1 += 6.283185307179586D; 
/* 210 */           double lastMovementAngle = Global.getMovementAngle();
/* 211 */           double lower = lastMovementAngle - 0.08726646259971647D;
/* 212 */           double upper = lastMovementAngle + 0.08726646259971647D;
/* 213 */           if (d1 < lower || d1 > upper) {
/*     */ 
/*     */ 
/*     */             
/* 217 */             Global.setMovementAngle(d1);
/* 218 */             Global.fireSelectedPhotoChanged(this);
/*     */           } 
/*     */           
/* 221 */           this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 231 */         double movementAngle = GraphicsUtil.getAngleBetweenPhotoPoints(Global.getPhotoPoint(), pt);
/* 232 */         Global.setMovementAngle(movementAngle);
/* 233 */         Photo photoToShow = GraphicsUtil.getPhotoWithAngleCloseTo(pt, movementAngle);
/*     */         
/* 235 */         if (photoToShow == Global.getPhoto()) {
/*     */           
/* 237 */           this.lastMousePt = e.getPoint();
/*     */           return;
/*     */         } 
/* 240 */         if (pt != Global.getPhotoPoint())
/*     */         {
/* 242 */           Global.setPhotoPoint(pt, this);
/*     */         }
/* 244 */         Global.setPhoto(photoToShow, this);
/* 245 */         this.lastMousePt = e.getPoint();
/*     */         return;
/*     */       } 
/*     */     } 
/* 249 */     if (Settings.isFlashesActivated()) {
/*     */ 
/*     */       
/* 252 */       it = null;
/* 253 */       it = c.iterator();
/* 254 */       while (it.hasNext()) {
/*     */         
/* 256 */         PhotoPoint pt = it.next();
/* 257 */         if (pt == null) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 264 */         if (Settings.getMotionSimThreshold() > 0) {
/*     */           
/* 266 */           if (Global.getPhotoPoint() == null)
/* 267 */             break;  int distance = (int)Point.distance(pt.getX(), pt.getY(), Global.getPhotoPoint().getX(), Global.getPhotoPoint().getY());
/*     */           
/* 269 */           if (distance < Settings.getMotionSimThreshold() && 
/* 270 */             !pt.equals(Global.getPhotoPoint()))
/*     */             continue; 
/*     */         } 
/* 273 */         for (int i = 0; i < pt.getNumberOfPhotos(); i++) {
/*     */ 
/*     */           
/* 276 */           Photo photo = pt.getVPhotos().elementAt(i);
/* 277 */           if (e != null && photo != null && photo.getFlash() != null && photo.getFlash().contains(e.getPoint())) {
/*     */             
/* 279 */             Global.stopRunner();
/* 280 */             if (photo == Global.getPhoto()) {
/*     */               
/* 282 */               this.lastMousePt = e.getPoint();
/*     */               return;
/*     */             } 
/* 285 */             if (pt != Global.getPhotoPoint())
/*     */             {
/* 287 */               Global.setPhotoPoint(pt, this);
/*     */             }
/* 289 */             Global.setPhoto(photo, this);
/* 290 */             this.lastMousePt = e.getPoint();
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseMoved(MouseEvent e) {
/* 301 */     if (Global.getView() == null)
/* 302 */       return;  if (!Settings.isSelectOnMouseOver())
/*     */       return; 
/* 304 */     Collection c = Global.getView().getVPhotoPoints();
/* 305 */     Vector vLinks = Global.getView().getViewLinks();
/* 306 */     if ((c == null || c.isEmpty()) && (vLinks == null || vLinks.size() == 0)) {
/*     */       return;
/*     */     }
/*     */     try {
/* 310 */       boolean selectedChecked = false;
/* 311 */       Iterator it = c.iterator();
/* 312 */       while (it.hasNext()) {
/*     */ 
/*     */         
/* 315 */         PhotoPoint pt = null;
/* 316 */         if (!selectedChecked) {
/*     */           
/* 318 */           pt = Global.getPhotoPoint();
/* 319 */           if (pt == null) pt = it.next(); 
/* 320 */           selectedChecked = true;
/*     */         }
/*     */         else {
/*     */           
/* 324 */           pt = it.next();
/*     */         } 
/*     */         
/* 327 */         int distance = (int)Point.distance(e.getX(), e.getY(), pt.getX(), pt.getY());
/* 328 */         if (distance <= Settings.getProximityDistance(pt)) {
/*     */           
/* 330 */           Global.stopRunner();
/* 331 */           if (pt.equals(Global.getPhotoPoint())) {
/*     */ 
/*     */ 
/*     */             
/* 335 */             if (!Global.getPhoto().isPanoramic() || distance < Settings.getPhotoPointDiameter() / 2) {
/*     */               
/* 337 */               this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 346 */             int lastDistance = (int)Math.floor(Point.distance(this.lastMousePt.x, this.lastMousePt.y, pt.getX(), pt.getY()));
/*     */             
/* 348 */             if (distance < lastDistance) {
/*     */ 
/*     */               
/* 351 */               this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */ 
/*     */             
/* 359 */             double d1 = Math.atan2((e.getY() - pt.getY()), (e.getX() - pt.getX()));
/* 360 */             if (d1 < 0.0D) d1 += 6.283185307179586D; 
/* 361 */             double lastMovementAngle = Global.getMovementAngle();
/* 362 */             double lower = lastMovementAngle - 0.08726646259971647D;
/* 363 */             double upper = lastMovementAngle + 0.08726646259971647D;
/* 364 */             if (d1 < lower || d1 > upper) {
/*     */ 
/*     */ 
/*     */               
/* 368 */               Global.setMovementAngle(d1);
/* 369 */               Global.fireSelectedPhotoChanged(this);
/*     */             } 
/*     */             
/* 372 */             this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 382 */           double movementAngle = GraphicsUtil.getAngleBetweenPhotoPoints(Global.getPhotoPoint(), pt);
/* 383 */           Global.setMovementAngle(movementAngle);
/* 384 */           Photo photoToShow = GraphicsUtil.getPhotoWithAngleCloseTo(pt, movementAngle);
/*     */           
/* 386 */           if (photoToShow == Global.getPhoto()) {
/*     */             
/* 388 */             this.lastMousePt = e.getPoint();
/*     */             return;
/*     */           } 
/* 391 */           if (pt != Global.getPhotoPoint())
/*     */           {
/* 393 */             Global.setPhotoPoint(pt, this);
/*     */           }
/* 395 */           Global.setPhoto(photoToShow, this);
/* 396 */           this.lastMousePt = e.getPoint();
/*     */           return;
/*     */         } 
/*     */       } 
/* 400 */       if (Settings.isFlashesActivated()) {
/*     */ 
/*     */         
/* 403 */         it = null;
/* 404 */         it = c.iterator();
/* 405 */         while (it.hasNext()) {
/*     */           
/* 407 */           PhotoPoint pt = it.next();
/* 408 */           if (pt == null) {
/*     */             continue;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 416 */           if (Settings.getMotionSimThreshold() > 0) {
/*     */             
/* 418 */             if (Global.getPhotoPoint() == null)
/* 419 */               break;  int distance = (int)Point.distance(pt.getX(), pt.getY(), Global.getPhotoPoint().getX(), Global.getPhotoPoint().getY());
/*     */             
/* 421 */             if (distance < Settings.getMotionSimThreshold() && 
/* 422 */               !pt.equals(Global.getPhotoPoint()))
/*     */               continue; 
/*     */           } 
/* 425 */           for (int i = 0; i < pt.getNumberOfPhotos(); i++) {
/*     */ 
/*     */             
/* 428 */             Photo photo = pt.getVPhotos().elementAt(i);
/* 429 */             if (e != null && photo != null && photo.getFlash() != null && photo.getFlash().contains(e.getPoint())) {
/*     */               
/* 431 */               Global.stopRunner();
/* 432 */               if (photo == Global.getPhoto()) {
/*     */                 
/* 434 */                 this.lastMousePt = e.getPoint();
/*     */                 return;
/*     */               } 
/* 437 */               if (pt != Global.getPhotoPoint())
/*     */               {
/* 439 */                 Global.setPhotoPoint(pt, this);
/*     */               }
/* 441 */               Global.setPhoto(photo, this);
/* 442 */               this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 451 */     } catch (Exception e2) {
/*     */       
/* 453 */       e2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {
/* 459 */     if (selectedTour == null) {
/*     */       
/* 461 */       setImage(null);
/* 462 */       updateUI();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {
/* 468 */     if (Global.getTour() == null)
/*     */       return; 
/* 470 */     boolean originalState = Global.getTour().isLocked();
/* 471 */     Global.getTour().setLocked(false);
/* 472 */     Global.getTour().doCalculations();
/* 473 */     Global.getTour().setLocked(originalState);
/*     */     
/* 475 */     Image im = null;
/* 476 */     if (selectedView != null && selectedView.getImageBytes() != null)
/*     */     {
/* 478 */       im = Toolkit.getDefaultToolkit().createImage(selectedView.getImageBytes());
/*     */     }
/* 480 */     setImage(im);
/*     */ 
/*     */     
/* 483 */     Image overlayIm = null;
/* 484 */     if (selectedView != null && selectedView.getOverlayImageBytes() != null)
/*     */     {
/* 486 */       overlayIm = Toolkit.getDefaultToolkit().createImage(selectedView.getOverlayImageBytes());
/*     */     }
/* 488 */     setOverlayImage(overlayIm);
/*     */ 
/*     */     
/* 491 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/* 497 */     if (src == this)
/* 498 */       return;  updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {
/* 504 */     if (selectedPhoto != null && 
/* 505 */       selectedPhoto.getDescription() != null) {
/* 506 */       Formatter.isHTMLEmpty(selectedPhoto.getDescription());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 520 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseDragged(MouseEvent e) {
/* 531 */     if (Settings.getMode() == 1) {
/*     */       return;
/*     */     }
/*     */     
/* 535 */     int proximity = 200;
/*     */     
/* 537 */     if (Global.getPhotoPoint() != null) {
/*     */ 
/*     */       
/* 540 */       PhotoPoint pt = Global.getPhotoPoint();
/* 541 */       int distance = (int)Point.distance((e.getPoint()).x, (e.getPoint()).y, 
/* 542 */           pt.getX(), pt.getY());
/* 543 */       if (distance <= proximity) {
/*     */         
/* 545 */         Global.getPhotoPoint().setX(e.getX());
/* 546 */         Global.getPhotoPoint().setY(e.getY());
/* 547 */         Global.fireSelectedPhotoPointChanged(this);
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\applet\AppletViewImagePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */