/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JMenuItem;
/*     */ 
/*     */ public class ViewImagePanel extends ImagePanel implements GlobalChangeListener, SettingsChangeListener {
/*  17 */   JPopupMenu viewPopup = new JPopupMenu();
/*  18 */   JMenuItem miDeletePhoto = new JMenuItem();
/*  19 */   JMenuItem miDeletePhotoPoint = new JMenuItem();
/*  20 */   JMenuItem miLoadNewImage = new JMenuItem();
/*  21 */   JMenuItem miSetSecondImage = new JMenuItem();
/*  22 */   JMenuItem miRemoveSecondImage = new JMenuItem();
/*  23 */   JMenuItem miEditPhotoDescription = new JMenuItem();
/*     */   
/*  25 */   private Image overlayImage = null; public synchronized Image getOverlayImage() {
/*  26 */     return this.overlayImage;
/*     */   }
/*     */   public synchronized void setOverlayImage(Image image) {
/*  29 */     this.overlayImage = image;
/*  30 */     if (image == null) {
/*     */       return;
/*     */     }
/*     */     try {
/*  34 */       this.tracker.addImage(this.overlayImage, 0);
/*  35 */       this.tracker.waitForID(0);
/*  36 */       updateUI();
/*     */     }
/*  38 */     catch (Exception e) {
/*     */       
/*  40 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*  44 */   private Point lastMousePt = null;
/*     */ 
/*     */   
/*     */   public ViewImagePanel() {
/*     */     try {
/*  49 */       jbInit();
/*  50 */       Global.addGlobalChangeListener(this);
/*  51 */       Global.addSettingsChangeListener(this);
/*  52 */       Global.addRepaintListener(this);
/*     */       
/*  54 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/*  55 */       UIManager.setLookAndFeel(nativeLF);
/*  56 */       SwingUtilities.updateComponentTreeUI(this);
/*     */ 
/*     */     
/*     */     }
/*  60 */     catch (Exception e) {
/*  61 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/*  66 */     addMouseListener(new ViewImagePanel_this_mouseAdapter(this));
/*  67 */     setLayout((LayoutManager)null);
/*  68 */     addMouseMotionListener(new ViewImagePanel_this_mouseMotionAdapter(this));
/*  69 */     this.miDeletePhoto.setToolTipText("Deletes the currently selected photo.");
/*  70 */     this.miDeletePhoto.setText("Delete Selected Photo");
/*  71 */     this.miDeletePhoto.addActionListener(new ViewImagePanel_miDeletePhoto_actionAdapter(this));
/*  72 */     this.miDeletePhotoPoint.setToolTipText("Deletes the Selected Point and all Photos tied to it.");
/*  73 */     this.miDeletePhotoPoint.setText("Delete Selected Photo Point");
/*  74 */     this.miDeletePhotoPoint.addActionListener(new ViewImagePanel_miDeletePhotoPoint_actionAdapter(this));
/*  75 */     this.miLoadNewImage.setText("Change View Image");
/*  76 */     this.miLoadNewImage.addActionListener(new ViewImagePanel_miLoadNewImage_actionAdapter(this));
/*  77 */     this.miSetSecondImage.setText("Set Fade-In Image");
/*  78 */     this.miSetSecondImage.addActionListener(new ViewImagePanel_miSetSecondImage_actionAdapter(this));
/*  79 */     this.miRemoveSecondImage.setText("Remove Fade-In Image");
/*  80 */     this.miRemoveSecondImage.addActionListener(new ViewImagePanel_miRemoveSecondImage_actionAdapter(this));
/*     */     
/*  82 */     this.miEditPhotoDescription.setText("Edit Photo Description");
/*  83 */     this.miEditPhotoDescription.addActionListener(new ViewImagePanel_miEditPhotoDescription_actionAdapter(this));
/*  84 */     this.viewPopup.add(this.miDeletePhoto);
/*  85 */     this.viewPopup.add(this.miDeletePhotoPoint);
/*  86 */     this.viewPopup.add(this.miLoadNewImage);
/*  87 */     this.viewPopup.add(this.miSetSecondImage);
/*  88 */     this.viewPopup.add(this.miRemoveSecondImage);
/*  89 */     this.viewPopup.add(this.miEditPhotoDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void miSetSecondImage_actionPerformed(ActionEvent e) {
/* 100 */     if (Global.getTour() == null) {
/*     */       
/* 102 */       JOptionPane.showMessageDialog(this, "Open Tour First", "No Tour Open", 1);
/*     */       
/*     */       return;
/*     */     } 
/* 106 */     if (Global.getView() == null || Global.getTour().getViews().size() == 0) {
/*     */       
/* 108 */       JOptionPane.showMessageDialog(this, "Open or Add View First", "No View Open", 1);
/*     */       
/*     */       return;
/*     */     } 
/* 112 */     JFileChooser chooser = new JFileChooser();
/* 113 */     chooser.setDialogTitle("Select a Fade-In Image File");
/* 114 */     chooser.setFileFilter((FileFilter)new ImageFileFilter());
/* 115 */     chooser.setLocation((getLocation()).x + getWidth() / 2 - chooser.getWidth() / 2, (getLocation()).y + getHeight() / 2 - chooser.getHeight() / 2);
/* 116 */     int result = chooser.showOpenDialog(this);
/* 117 */     if (result == 1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 123 */       FileInputStream fis = new FileInputStream(chooser.getSelectedFile());
/* 124 */       byte[] bytes = new byte[fis.available()];
/* 125 */       fis.read(bytes);
/* 126 */       fis.close();
/*     */       
/* 128 */       Global.getView().setOverlayImageBytes(bytes);
/* 129 */       Global.getView().setOverlayAlpha(0.25D);
/* 130 */       Global.fireSelectedViewChanged(this);
/*     */ 
/*     */     
/*     */     }
/* 134 */     catch (Exception ex) {
/*     */       
/* 136 */       JOptionPane.showMessageDialog(this, ex.toString(), ex.toString(), 0);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void miRemoveSecondImage_actionPerformed(ActionEvent e) {
/* 146 */     if (Global.getTour() == null) {
/*     */       
/* 148 */       JOptionPane.showMessageDialog(this, "Open Tour First", "No Tour Open", 1);
/*     */       
/*     */       return;
/*     */     } 
/* 152 */     if (Global.getView() == null || Global.getTour().getViews().size() == 0) {
/*     */       
/* 154 */       JOptionPane.showMessageDialog(this, "Open or Add View First", "No View Open", 1);
/*     */       
/*     */       return;
/*     */     } 
/* 158 */     if (Global.getView().getOverlayImageBytes() == null) {
/*     */       
/* 160 */       JOptionPane.showMessageDialog(this, "No Fade-In Image available", "Fade-In Not Available", 1);
/*     */       
/*     */       return;
/*     */     } 
/* 164 */     Global.getView().setOverlayImageBytes(null);
/* 165 */     Global.fireSelectedViewChanged(this);
/* 166 */     Global.getTour().setModified(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/* 176 */     super.paint(g);
/* 177 */     if (Global.getView() == null) { setImage((Image)null);
/*     */       return; }
/*     */     
/* 180 */     Graphics2D g2d = (Graphics2D)g;
/* 181 */     if (this.overlayImage != null) {
/*     */ 
/*     */       
/* 184 */       g2d.setComposite(AlphaComposite.getInstance(3, (float)Global.getView().getOverlayAlpha()));
/* 185 */       g.drawImage(this.overlayImage, 0, 0, this);
/* 186 */       g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
/*     */     } 
/*     */ 
/*     */     
/* 190 */     if (Global.getTour() != null) Global.getTour().doCalculations();
/*     */     
/* 192 */     Collection c = Global.getView().getPhotos();
/* 193 */     if (c != null && !c.isEmpty()) {
/*     */       
/* 195 */       Iterator it = c.iterator();
/* 196 */       while (it.hasNext()) {
/*     */         
/* 198 */         Photo photo = it.next();
/* 199 */         photo.paint(g);
/* 200 */         photo.getPhotoPoint().paint(g);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 205 */     if (Settings.isDrawFootSteps())
/*     */     {
/* 207 */       Global.getView().getTrail().paint(g);
/*     */     }
/*     */     
/* 210 */     if (Global.getPhoto() != null)
/*     */     {
/* 212 */       Global.getPhoto().paint(g);
/*     */     }
/*     */ 
/*     */     
/* 216 */     if (Global.getPhotoPoint() != null && Settings.isDrawFootSteps())
/*     */     {
/* 218 */       if (!Global.getPhoto().isPanoramic()) {
/*     */ 
/*     */         
/* 221 */         AngledFootstep step = new AngledFootstep(
/* 222 */             Global.getPhotoPoint().getPoint(), 
/* 223 */             Global.getPhoto().getStartAngle());
/* 224 */         step.setFillColor(Settings.getSelectedFootstepFillColor());
/* 225 */         step.setOutlineColor(Settings.getSelectedFootstepOutlineColor());
/* 226 */         step.paint(g);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 231 */     if (Settings.isDrawProximity()) paintProximity(g);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void paintProximity(Graphics g) {
/*     */     try {
/* 241 */       Vector vPhotos = Global.getView().getPhotos();
/* 242 */       Photo photo = null;
/*     */       
/* 244 */       for (int i = 0; i < vPhotos.size(); i++)
/*     */       {
/* 246 */         photo = vPhotos.elementAt(i);
/* 247 */         int radius = Settings.getProximityDistance(photo.getPhotoPoint());
/* 248 */         g.setColor(new Color(0, 0, 255, 56));
/* 249 */         g.fillOval(photo.getPhotoPoint().getX() - radius, photo.getPhotoPoint().getY() - radius, radius * 2, radius * 2);
/* 250 */         g.setColor(Color.blue);
/* 251 */         g.drawOval(photo.getPhotoPoint().getX() - radius, photo.getPhotoPoint().getY() - radius, radius * 2, radius * 2);
/*     */       }
/*     */     
/* 254 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseClicked(MouseEvent e) {
/* 263 */     if (Global.getView() == null)
/* 264 */       return;  Collection c = Global.getView().getVPhotoPoints();
/* 265 */     if (c == null || c.isEmpty()) {
/*     */       return;
/*     */     }
/* 268 */     boolean selectedChecked = false;
/* 269 */     Iterator it = c.iterator();
/* 270 */     while (it.hasNext()) {
/*     */       
/* 272 */       PhotoPoint pt = null;
/* 273 */       if (!selectedChecked) {
/*     */         
/* 275 */         pt = Global.getPhotoPoint();
/* 276 */         if (pt == null) pt = it.next(); 
/* 277 */         selectedChecked = true;
/*     */       }
/*     */       else {
/*     */         
/* 281 */         pt = it.next();
/*     */       } 
/*     */       
/* 284 */       int distance = (int)Point.distance((e.getPoint()).x, (e.getPoint()).y, pt.getX(), pt.getY());
/* 285 */       if (distance <= Settings.getProximityDistance(pt)) {
/*     */         
/* 287 */         Global.stopRunner();
/* 288 */         if (pt.equals(Global.getPhotoPoint())) {
/*     */ 
/*     */ 
/*     */           
/* 292 */           if (!Global.getPhoto().isPanoramic() || distance < Settings.getPhotoPointDiameter() / 2) {
/*     */             
/* 294 */             this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 303 */           int lastDistance = (int)Math.floor(Point.distance(this.lastMousePt.x, this.lastMousePt.y, pt.getX(), pt.getY()));
/*     */           
/* 305 */           if (distance < lastDistance) {
/*     */ 
/*     */             
/* 308 */             this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */           
/* 316 */           double d1 = Math.atan2((e.getY() - pt.getY()), (e.getX() - pt.getX()));
/* 317 */           if (d1 < 0.0D) d1 += 6.283185307179586D; 
/* 318 */           double lastMovementAngle = Global.getMovementAngle();
/* 319 */           double lower = lastMovementAngle - 0.08726646259971647D;
/* 320 */           double upper = lastMovementAngle + 0.08726646259971647D;
/* 321 */           if (d1 < lower || d1 > upper) {
/*     */ 
/*     */ 
/*     */             
/* 325 */             Global.setMovementAngle(d1);
/* 326 */             Global.fireSelectedPhotoChanged(this);
/*     */           } 
/*     */           
/* 329 */           this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 339 */         double movementAngle = GraphicsUtil.getAngleBetweenPhotoPoints(Global.getPhotoPoint(), pt);
/* 340 */         Global.setMovementAngle(movementAngle);
/* 341 */         Photo photoToShow = GraphicsUtil.getPhotoWithAngleCloseTo(pt, movementAngle);
/*     */         
/* 343 */         if (photoToShow == Global.getPhoto()) {
/*     */           
/* 345 */           this.lastMousePt = e.getPoint();
/*     */           return;
/*     */         } 
/* 348 */         if (pt != Global.getPhotoPoint())
/*     */         {
/* 350 */           Global.setPhotoPoint(pt, this);
/*     */         }
/* 352 */         Global.setPhoto(photoToShow, this);
/* 353 */         this.lastMousePt = e.getPoint();
/*     */         return;
/*     */       } 
/*     */     } 
/* 357 */     if (Settings.isFlashesActivated()) {
/*     */ 
/*     */       
/* 360 */       it = null;
/* 361 */       it = c.iterator();
/* 362 */       while (it.hasNext()) {
/*     */         
/* 364 */         PhotoPoint pt = it.next();
/* 365 */         if (pt == null) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 372 */         if (Settings.getMotionSimThreshold() > 0) {
/*     */           
/* 374 */           if (Global.getPhotoPoint() == null)
/* 375 */             break;  int distance = (int)Point.distance(pt.getX(), pt.getY(), Global.getPhotoPoint().getX(), Global.getPhotoPoint().getY());
/*     */           
/* 377 */           if (distance < Settings.getMotionSimThreshold() && 
/* 378 */             !pt.equals(Global.getPhotoPoint()))
/*     */             continue; 
/*     */         } 
/* 381 */         for (int i = 0; i < pt.getNumberOfPhotos(); i++) {
/*     */ 
/*     */           
/* 384 */           Photo photo = pt.getVPhotos().elementAt(i);
/* 385 */           if (e != null && photo != null && photo.getFlash() != null && photo.getFlash().contains(e.getPoint())) {
/*     */             
/* 387 */             Global.stopRunner();
/* 388 */             if (photo == Global.getPhoto()) {
/*     */               
/* 390 */               this.lastMousePt = e.getPoint();
/*     */               return;
/*     */             } 
/* 393 */             if (pt != Global.getPhotoPoint())
/*     */             {
/* 395 */               Global.setPhotoPoint(pt, this);
/*     */             }
/* 397 */             Global.setPhoto(photo, this);
/* 398 */             this.lastMousePt = e.getPoint();
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
/* 409 */     if (Global.getView() == null)
/* 410 */       return;  if (!Settings.isSelectOnMouseOver())
/*     */       return; 
/* 412 */     Collection c = Global.getView().getVPhotoPoints();
/* 413 */     Vector vLinks = Global.getView().getViewLinks();
/* 414 */     if ((c == null || c.isEmpty()) && (vLinks == null || vLinks.size() == 0)) {
/*     */       return;
/*     */     }
/*     */     try {
/* 418 */       boolean selectedChecked = false;
/* 419 */       Iterator it = c.iterator();
/* 420 */       while (it.hasNext()) {
/*     */ 
/*     */         
/* 423 */         PhotoPoint pt = null;
/* 424 */         if (!selectedChecked) {
/*     */           
/* 426 */           pt = Global.getPhotoPoint();
/* 427 */           if (pt == null) pt = it.next(); 
/* 428 */           selectedChecked = true;
/*     */         }
/*     */         else {
/*     */           
/* 432 */           pt = it.next();
/*     */         } 
/*     */         
/* 435 */         int distance = (int)Point.distance(e.getX(), e.getY(), pt.getX(), pt.getY());
/* 436 */         if (distance <= Settings.getProximityDistance(pt)) {
/*     */           
/* 438 */           Global.stopRunner();
/* 439 */           if (pt.equals(Global.getPhotoPoint())) {
/*     */ 
/*     */ 
/*     */             
/* 443 */             if (!Global.getPhoto().isPanoramic() || distance < Settings.getPhotoPointDiameter() / 2) {
/*     */               
/* 445 */               this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 454 */             int lastDistance = (int)Math.floor(Point.distance(this.lastMousePt.x, this.lastMousePt.y, pt.getX(), pt.getY()));
/*     */             
/* 456 */             if (distance < lastDistance) {
/*     */ 
/*     */               
/* 459 */               this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */ 
/*     */             
/* 467 */             double d1 = Math.atan2((e.getY() - pt.getY()), (e.getX() - pt.getX()));
/* 468 */             if (d1 < 0.0D) d1 += 6.283185307179586D; 
/* 469 */             double lastMovementAngle = Global.getMovementAngle();
/* 470 */             double lower = lastMovementAngle - 0.08726646259971647D;
/* 471 */             double upper = lastMovementAngle + 0.08726646259971647D;
/* 472 */             if (d1 < lower || d1 > upper) {
/*     */ 
/*     */ 
/*     */               
/* 476 */               Global.setMovementAngle(d1);
/* 477 */               Global.fireSelectedPhotoChanged(this);
/*     */             } 
/*     */             
/* 480 */             this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 490 */           double movementAngle = GraphicsUtil.getAngleBetweenPhotoPoints(Global.getPhotoPoint(), pt);
/* 491 */           Global.setMovementAngle(movementAngle);
/* 492 */           Photo photoToShow = GraphicsUtil.getPhotoWithAngleCloseTo(pt, movementAngle);
/*     */           
/* 494 */           if (photoToShow == Global.getPhoto()) {
/*     */             
/* 496 */             this.lastMousePt = e.getPoint();
/*     */             return;
/*     */           } 
/* 499 */           if (pt != Global.getPhotoPoint())
/*     */           {
/* 501 */             Global.setPhotoPoint(pt, this);
/*     */           }
/* 503 */           Global.setPhoto(photoToShow, this);
/* 504 */           this.lastMousePt = e.getPoint();
/*     */           return;
/*     */         } 
/*     */       } 
/* 508 */       if (Settings.isFlashesActivated()) {
/*     */ 
/*     */         
/* 511 */         it = null;
/* 512 */         it = c.iterator();
/* 513 */         while (it.hasNext()) {
/*     */           
/* 515 */           PhotoPoint pt = it.next();
/* 516 */           if (pt == null) {
/*     */             continue;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 524 */           if (Settings.getMotionSimThreshold() > 0) {
/*     */             
/* 526 */             if (Global.getPhotoPoint() == null)
/* 527 */               break;  int distance = (int)Point.distance(pt.getX(), pt.getY(), Global.getPhotoPoint().getX(), Global.getPhotoPoint().getY());
/*     */             
/* 529 */             if (distance < Settings.getMotionSimThreshold() && 
/* 530 */               !pt.equals(Global.getPhotoPoint()))
/*     */               continue; 
/*     */           } 
/* 533 */           for (int i = 0; i < pt.getNumberOfPhotos(); i++) {
/*     */ 
/*     */             
/* 536 */             Photo photo = pt.getVPhotos().elementAt(i);
/* 537 */             if (e != null && photo != null && photo.getFlash() != null && photo.getFlash().contains(e.getPoint())) {
/*     */               
/* 539 */               Global.stopRunner();
/* 540 */               if (photo == Global.getPhoto()) {
/*     */                 
/* 542 */                 this.lastMousePt = e.getPoint();
/*     */                 return;
/*     */               } 
/* 545 */               if (pt != Global.getPhotoPoint())
/*     */               {
/* 547 */                 Global.setPhotoPoint(pt, this);
/*     */               }
/* 549 */               Global.setPhoto(photo, this);
/* 550 */               this.lastMousePt = e.getPoint();
/*     */ 
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 559 */     } catch (Exception e2) {
/*     */       
/* 561 */       e2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {
/* 567 */     if (selectedTour == null) {
/*     */       
/* 569 */       setImage((Image)null);
/* 570 */       updateUI();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {
/* 576 */     if (this.viewPopup.isShowing()) setupPopup();
/*     */     
/* 578 */     if (Global.getTour() == null)
/*     */       return; 
/* 580 */     boolean originalState = Global.getTour().isLocked();
/* 581 */     Global.getTour().setLocked(false);
/* 582 */     Global.getTour().doCalculations();
/* 583 */     Global.getTour().setLocked(originalState);
/*     */     
/* 585 */     Image im = null;
/* 586 */     if (selectedView != null && selectedView.getImageBytes() != null)
/*     */     {
/* 588 */       im = Toolkit.getDefaultToolkit().createImage(selectedView.getImageBytes());
/*     */     }
/* 590 */     setImage(im);
/*     */ 
/*     */     
/* 593 */     Image overlayIm = null;
/* 594 */     if (selectedView != null && selectedView.getOverlayImageBytes() != null)
/*     */     {
/* 596 */       overlayIm = Toolkit.getDefaultToolkit().createImage(selectedView.getOverlayImageBytes());
/*     */     }
/* 598 */     setOverlayImage(overlayIm);
/*     */     
/* 600 */     if (selectedView != null && Global.getPhoto() != null) {
/*     */       
/* 602 */       boolean photofound = false;
/* 603 */       for (int i = 0; i < selectedView.getPhotos().size(); i++) {
/*     */         
/* 605 */         if (selectedView.getPhotos().elementAt(i).equals(Global.getPhoto())) photofound = true; 
/*     */       }  
/* 607 */       try { if (!photofound) Global.setPhoto(selectedView.getPhotos().elementAt(0), this);  } catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 612 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void settingsChanged(Object src) {
/* 618 */     if (src == this)
/* 619 */       return;  updateUI();
/*     */   }
/*     */ 
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {
/* 624 */     if (this.viewPopup.isShowing()) setupPopup();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 633 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mousePressed(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupPopup() {
/* 649 */     boolean tourSelected = (Global.getTour() != null);
/* 650 */     boolean viewSelected = (Global.getView() != null);
/* 651 */     boolean photoPointSelected = (Global.getPhotoPoint() != null);
/* 652 */     boolean photoSelected = (Global.getPhoto() != null);
/* 653 */     boolean overlayImagePresent = (Global.getView().getOverlayImageBytes() != null);
/*     */ 
/*     */ 
/*     */     
/* 657 */     this.miDeletePhoto.setEnabled(photoSelected);
/* 658 */     this.miDeletePhotoPoint.setEnabled(photoPointSelected);
/* 659 */     this.miLoadNewImage.setEnabled(viewSelected);
/* 660 */     this.miEditPhotoDescription.setEnabled(photoSelected);
/* 661 */     this.miRemoveSecondImage.setEnabled(overlayImagePresent);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 668 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 669 */       SwingUtilities.updateComponentTreeUI(this.viewPopup);
/*     */     }
/* 671 */     catch (Exception exception) {}
/*     */ 
/*     */     
/* 674 */     this.viewPopup.updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseReleased(MouseEvent e) {
/* 681 */     if (Settings.getMode() == 1) {
/*     */       return;
/*     */     }
/* 684 */     if (e.isPopupTrigger()) {
/*     */       
/* 686 */       Global.stopRunner();
/* 687 */       setupPopup();
/* 688 */       this.viewPopup.show(this, e.getX(), e.getY());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void miDeletePhoto_actionPerformed(ActionEvent e) {
/* 695 */     (new DeleteSelectedPhotoCommand()).execute(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void miDeletePhotoPoint_actionPerformed(ActionEvent e) {
/* 701 */     PhotoPoint pt = Global.getPhotoPoint();
/* 702 */     Global.getView().getVPhotoPoints().remove(pt);
/*     */     
/* 704 */     for (int i = 0; i < pt.getVPhotos().size(); i++)
/*     */     {
/* 706 */       Global.getView().getPhotos().remove(pt.getVPhotos().elementAt(i));
/*     */     }
/*     */ 
/*     */     
/* 710 */     if (Global.getView().getVPhotoPoints().size() > 0) {
/*     */       
/* 712 */       Global.setPhotoPoint(Global.getView().getFirstPhotoPoint(), this);
/* 713 */       Global.setPhoto(Global.getPhotoPoint().getFirstPhoto(), this);
/*     */     }
/*     */     else {
/*     */       
/* 717 */       Global.setPhotoPoint(null, this);
/* 718 */       Global.setPhoto(null, this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void miCancel_actionPerformed(ActionEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void miLoadNewImage_actionPerformed(ActionEvent e) {
/* 731 */     Image image = FileUtility.changeViewImage(Global.getView(), this);
/* 732 */     if (image != null)
/*     */     {
/* 734 */       setImage(image);
/*     */     }
/* 736 */     updateUI();
/*     */   }
/*     */ 
/*     */   
/*     */   void this_mouseDragged(MouseEvent e) {
/* 741 */     if (Settings.getMode() == 1) {
/*     */       return;
/*     */     }
/*     */     
/* 745 */     int proximity = 200;
/*     */     
/* 747 */     if (Global.getPhotoPoint() != null) {
/*     */ 
/*     */       
/* 750 */       PhotoPoint pt = Global.getPhotoPoint();
/* 751 */       int distance = (int)Point.distance((e.getPoint()).x, (e.getPoint()).y, 
/* 752 */           pt.getX(), pt.getY());
/* 753 */       if (distance <= proximity) {
/*     */         
/* 755 */         Global.getPhotoPoint().setX(e.getX());
/* 756 */         Global.getPhotoPoint().setY(e.getY());
/* 757 */         Global.fireSelectedPhotoPointChanged(this);
/*     */       } 
/*     */       return;
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
/*     */   
/*     */   private Point getDialogLocation(int desiredWidth, int desiredHeight) {
/*     */     try {
/* 773 */       Container parent = getParent();
/* 774 */       for (; !(parent instanceof JFrame); parent = parent.getParent());
/* 775 */       JFrame pane = (JFrame)parent;
/* 776 */       int x = (pane.getLocation()).x + pane.getWidth() / 2 - desiredWidth / 2;
/* 777 */       int y = (pane.getLocation()).y + pane.getHeight() / 2 - desiredHeight / 2;
/* 778 */       return new Point(x, y);
/*     */     }
/* 780 */     catch (Exception ex) {
/*     */       
/* 782 */       return new Point(0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void miEditPhotoDescription_actionPerformed(ActionEvent e) {
/* 789 */     TextEditDialog ted = new TextEditDialog(VadosityToolkit.getInstance());
/* 790 */     ted.setFormattedText(Global.getPhoto().getDescription());
/* 791 */     ted.setModal(true);
/* 792 */     ted.setTitle("Edit Photo Description");
/* 793 */     int width = 320;
/* 794 */     int height = 340;
/* 795 */     ted.setSize(width, height);
/* 796 */     ted.setLocation(getDialogLocation(width, height));
/* 797 */     ted.setVisible(true);
/*     */     
/* 799 */     int result = ted.getResult();
/* 800 */     if (result == 0)
/*     */     {
/* 802 */       Global.getPhoto().setDescription(ted.getFormattedText());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ViewImagePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */