/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JViewport;
/*     */ 
/*     */ public class SelectedPhotoImagePanel extends JPanel implements GlobalChangeListener {
/*  13 */   JViewport viewport = null;
/*  14 */   JScrollPane scrollPane = null;
/*  15 */   ImagePanel imagePanel = null;
/*     */   
/*  17 */   private Image image = null;
/*  18 */   private Vector vPhotoLinks = new Vector();
/*     */   Point lastPt; Rectangle lastRect; Rectangle lastVisibleRect; int counter;
/*  20 */   public Image getImage() { return this.image; } public void setImage(Image image) {
/*  21 */     this.image = image;
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  25 */     super.paint(g);
/*  26 */     if (Global.getPhoto() == null)
/*  27 */       return;  if (this.image == null)
/*     */       return; 
/*     */     try {
/*  30 */       MediaTracker tracker = new MediaTracker(this);
/*  31 */       tracker.addImage(this.image, 0);
/*  32 */       tracker.waitForID(0);
/*     */       
/*  34 */       int width = this.image.getWidth(this);
/*  35 */       int height = this.image.getHeight(this);
/*     */       
/*  37 */       if (Global.getPhoto() != null && 
/*  38 */         Global.getPhoto().isPanoramic()) {
/*     */         
/*  40 */         g.drawImage(this.image, 0, 0, this);
/*  41 */         setCursor(new Cursor(13));
/*     */       }
/*     */       else {
/*     */         
/*  45 */         g.drawImage(this.image, 0, 0, this);
/*     */         
/*  47 */         if (Global.getPhoto().isPanoramic())
/*     */         {
/*  49 */           setCursor(new Cursor(13));
/*     */         }
/*     */         else
/*     */         {
/*  53 */           setCursor(new Cursor(12));
/*     */         }
/*     */       
/*     */       } 
/*  57 */     } catch (Exception e) {
/*     */       
/*  59 */       e.printStackTrace();
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
/*     */   public ImagePanel getImagePanelReference() {
/*  71 */     if (this.imagePanel != null) return this.imagePanel; 
/*  72 */     if (Global.getTour() == null) return null;
/*     */     
/*  74 */     Vector v = Global.getGlobalChangeListeners();
/*  75 */     if (v == null || v.size() == 0) return null;
/*     */     
/*  77 */     Object object = null;
/*  78 */     for (int i = 0; i < v.size(); i++) {
/*     */       
/*  80 */       object = v.elementAt(i);
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/*  85 */         if (object instanceof ViewImagePanel)
/*     */         {
/*  87 */           this.imagePanel = (ImagePanel)object;
/*  88 */           return this.imagePanel;
/*     */         }
/*     */       
/*  91 */       } catch (Throwable throwable) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {}
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {}
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {
/* 108 */     if (Global.getView() == null)
/* 109 */       return;  if (selectedPhoto == null) {
/*     */       return;
/*     */     }
/* 112 */     Image im = null;
/* 113 */     if (selectedPhoto.getBytes() != null && (selectedPhoto.getBytes()).length > 0)
/*     */     {
/* 115 */       im = Toolkit.getDefaultToolkit().createImage(selectedPhoto.getBytes());
/*     */     }
/* 117 */     setImage(im);
/*     */ 
/*     */     
/* 120 */     int width = selectedPhoto.getPhotoWidth();
/* 121 */     int height = selectedPhoto.getPhotoHeight();
/*     */     
/* 123 */     if (!selectedPhoto.isPanoramic()) {
/*     */ 
/*     */       
/* 126 */       System.out.println("photo w,h: " + width + "," + height);
/* 127 */       setSize(width, height);
/* 128 */       setMinimumSize(new Dimension(width, height));
/* 129 */       setPreferredSize(new Dimension(width, height));
/*     */       
/* 131 */       updateUI();
/*     */       return;
/*     */     } 
/* 134 */     if (selectedPhoto.isPanoramic() && src instanceof Thread) {
/*     */ 
/*     */       
/* 137 */       setSize(width, height);
/* 138 */       setMinimumSize(new Dimension(width, height));
/* 139 */       setPreferredSize(new Dimension(width, height));
/*     */ 
/*     */       
/* 142 */       PhotoPoint prior = Global.getPreviousPhoto().getPhotoPoint();
/* 143 */       PhotoPoint current = Global.getPhoto().getPhotoPoint();
/* 144 */       PhotoPoint next = Global.getNextPhoto().getPhotoPoint();
/*     */ 
/*     */       
/* 147 */       initScrollPaneAndViewport();
/*     */ 
/*     */ 
/*     */       
/* 151 */       double ma = GraphicsUtil.getAngleBetweenPhotoPoints(prior, current);
/* 152 */       double sa = selectedPhoto.getStartAngle();
/* 153 */       double ca = selectedPhoto.getCoverageAngle();
/* 154 */       double va = ca * this.viewport.getWidth() / getWidth();
/*     */ 
/*     */       
/* 157 */       double rae = -1.0D;
/* 158 */       if (sa > ma) { rae = 6.283185307179586D - sa + ma; }
/* 159 */       else { rae = ma - sa; }
/*     */ 
/*     */ 
/*     */       
/* 163 */       double sva = sa + rae - va / 2.0D;
/* 164 */       double fva = sa + rae + va / 2.0D;
/* 165 */       if (sva > 6.283185307179586D) {
/*     */         
/* 167 */         sva %= 6.283185307179586D;
/* 168 */         fva %= 6.283185307179586D;
/*     */       } 
/*     */ 
/*     */       
/* 172 */       int xpe = (int)(rae * selectedPhoto.getPhotoWidth() / ca);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 181 */       int paneWidth = this.viewport.getWidth();
/*     */       
/* 183 */       if (xpe > selectedPhoto.getPhotoWidth()) {
/*     */ 
/*     */         
/* 186 */         int fppw = (int)(selectedPhoto.getPhotoWidth() * 6.283185307179586D / ca);
/*     */ 
/*     */         
/* 189 */         int distanceFromRight = xpe - selectedPhoto.getPhotoWidth();
/* 190 */         int distanceFromLeft = fppw - xpe;
/*     */         
/* 192 */         if (distanceFromLeft <= distanceFromRight)
/*     */         {
/*     */           
/* 195 */           this.viewport.setViewPosition(new Point(0, 0));
/* 196 */           sva = sa;
/* 197 */           fva = sa + va;
/*     */         
/*     */         }
/*     */         else
/*     */         {
/*     */           
/* 203 */           this.viewport.setViewPosition(new Point(selectedPhoto.getPhotoWidth() - this.viewport.getWidth(), 0));
/* 204 */           sva = sa + ca - va;
/* 205 */           fva = sa + ca;
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 212 */         int leftx = xpe - paneWidth / 2;
/*     */         
/* 214 */         if (leftx < 0) {
/*     */ 
/*     */           
/* 217 */           leftx = 0;
/* 218 */           sva = sa;
/* 219 */           fva = sa + va;
/*     */         }
/* 221 */         else if (leftx + this.viewport.getWidth() > selectedPhoto.getPhotoWidth()) {
/*     */ 
/*     */           
/* 224 */           leftx = selectedPhoto.getPhotoWidth() - this.viewport.getWidth();
/* 225 */           fva = sa + ca;
/* 226 */           sva = fva - va;
/*     */         } 
/* 228 */         int topy = 0;
/* 229 */         this.viewport.setViewPosition(new Point(leftx, topy));
/*     */       } 
/*     */ 
/*     */       
/* 233 */       selectedPhoto.setStartVisibleAngle(sva);
/* 234 */       selectedPhoto.setFinishVisibleAngle(fva);
/*     */ 
/*     */ 
/*     */       
/* 238 */       updateUI();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 244 */     if (selectedPhoto.isPanoramic() && src instanceof ImagePanel) {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */         
/* 250 */         setSize(width, height);
/* 251 */         setMinimumSize(new Dimension(width, height));
/* 252 */         setPreferredSize(new Dimension(width, height));
/*     */ 
/*     */         
/* 255 */         initScrollPaneAndViewport();
/*     */ 
/*     */         
/* 258 */         double ma = Global.getMovementAngle();
/* 259 */         double sa = selectedPhoto.getStartAngle();
/* 260 */         double ca = selectedPhoto.getCoverageAngle();
/* 261 */         double va = ca * this.viewport.getWidth() / getWidth();
/*     */ 
/*     */         
/* 264 */         double rae = -1.0D;
/* 265 */         if (sa > ma) { rae = 6.283185307179586D - sa + ma; }
/* 266 */         else { rae = ma - sa; }
/*     */ 
/*     */ 
/*     */         
/* 270 */         double sva = sa + rae - va / 2.0D;
/* 271 */         double fva = sa + rae + va / 2.0D;
/* 272 */         if (sva > 6.283185307179586D) {
/*     */           
/* 274 */           sva %= 6.283185307179586D;
/* 275 */           fva %= 6.283185307179586D;
/*     */         } 
/*     */ 
/*     */         
/* 279 */         int xpe = (int)(rae * selectedPhoto.getPhotoWidth() / ca);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 288 */         int paneWidth = this.viewport.getWidth();
/*     */         
/* 290 */         if (xpe > selectedPhoto.getPhotoWidth()) {
/*     */ 
/*     */           
/* 293 */           int fppw = (int)(selectedPhoto.getPhotoWidth() * 6.283185307179586D / ca);
/*     */ 
/*     */           
/* 296 */           int distanceFromRight = xpe - selectedPhoto.getPhotoWidth();
/* 297 */           int distanceFromLeft = fppw - xpe;
/*     */           
/* 299 */           if (distanceFromLeft <= distanceFromRight)
/*     */           {
/*     */             
/* 302 */             this.viewport.setViewPosition(new Point(0, 0));
/* 303 */             sva = sa;
/* 304 */             fva = sa + va;
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 309 */             this.viewport.setViewPosition(new Point(selectedPhoto.getPhotoWidth() - this.viewport.getWidth(), 0));
/* 310 */             sva = sa + ca - va;
/* 311 */             fva = sa + ca;
/*     */           }
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 317 */           int leftx = xpe - paneWidth / 2;
/*     */           
/* 319 */           if (leftx < 0) {
/*     */ 
/*     */             
/* 322 */             leftx = 0;
/* 323 */             sva = sa;
/* 324 */             fva = sa + va;
/*     */           }
/* 326 */           else if (leftx + this.viewport.getWidth() > selectedPhoto.getPhotoWidth()) {
/*     */ 
/*     */             
/* 329 */             leftx = selectedPhoto.getPhotoWidth() - this.viewport.getWidth();
/* 330 */             fva = sa + ca;
/* 331 */             sva = fva - va;
/*     */           } 
/* 333 */           int topy = 0;
/* 334 */           this.viewport.setViewPosition(new Point(leftx, topy));
/*     */         } 
/* 336 */         selectedPhoto.setStartVisibleAngle(sva);
/* 337 */         selectedPhoto.setFinishVisibleAngle(fva);
/* 338 */         updateUI();
/*     */         
/*     */         return;
/* 341 */       } catch (Exception exception) {}
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 346 */       if (selectedPhoto.isPanoramic() && src instanceof JViewport) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 351 */       if (selectedPhoto.isPanoramic() && src == this) {
/*     */         
/* 353 */         JScrollPane pane = (JScrollPane)getParent().getParent();
/* 354 */         JViewport vp = pane.getViewport();
/*     */         
/* 356 */         double vpw = vp.getWidth();
/* 357 */         double pw = selectedPhoto.getPhotoWidth();
/* 358 */         double vpx0 = (vp.getViewPosition()).x;
/* 359 */         double ca = selectedPhoto.getCoverageAngle();
/* 360 */         double sa = selectedPhoto.getStartAngle();
/*     */         
/* 362 */         double sva = vpx0 * ca / pw + sa;
/* 363 */         double fva = vpw / pw * ca + sva;
/*     */         
/* 365 */         selectedPhoto.setStartVisibleAngle(sva);
/* 366 */         selectedPhoto.setFinishVisibleAngle(fva);
/*     */         
/* 368 */         if (getImagePanelReference() != null)
/*     */         {
/* 370 */           getImagePanelReference().updateUI();
/*     */         }
/*     */         
/* 373 */         Global.fireSelectedPhotoChanged(vp);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 379 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initScrollPaneAndViewport() {
/*     */     try {
/* 390 */       if (this.scrollPane == null) {
/*     */         
/* 392 */         this.scrollPane = (JScrollPane)getParent().getParent();
/* 393 */         this.scrollPane.setDoubleBuffered(true);
/* 394 */         this.scrollPane.getHorizontalScrollBar().addAdjustmentListener(new HorizontalAdjustmentListener(this));
/*     */       } 
/* 396 */       if (this.viewport == null)
/*     */       {
/* 398 */         this.viewport = this.scrollPane.getViewport();
/* 399 */         this.viewport.setDoubleBuffered(true);
/*     */       }
/*     */     
/*     */     }
/* 403 */     catch (Exception exception) {}
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
/*     */   private void jbInit() throws Exception {
/* 420 */     addMouseMotionListener(new SelectedPhotoImagePanel_this_mouseMotionAdapter(this));
/* 421 */     addMouseListener(new SelectedPhotoImagePanel_this_mouseAdapter(this));
/*     */   }
/*     */ 
/*     */   
/*     */   void this_mouseClicked(MouseEvent e) {
/* 426 */     Global.stopRunner();
/* 427 */     Global.selectNextPhoto(this);
/*     */   }
/*     */   
/* 430 */   public SelectedPhotoImagePanel() { this.lastPt = null;
/* 431 */     this.lastRect = null;
/* 432 */     this.lastVisibleRect = null;
/* 433 */     this.counter = 0; try {
/*     */       jbInit(); Global.addGlobalChangeListener(this);
/*     */     } catch (Exception e) {
/*     */       e.printStackTrace();
/* 437 */     }  } void this_mouseDragged(MouseEvent e) { if (AutoRunner.isPanning()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 442 */     Photo photo = Global.getPhoto();
/* 443 */     if (photo == null || !photo.isPanoramic())
/*     */       return; 
/* 445 */     Point pt = e.getPoint();
/*     */     
/* 447 */     int dx = 0;
/* 448 */     int dy = 0;
/* 449 */     Rectangle visibleRect = ((JViewport)getParent()).getVisibleRect();
/*     */     
/* 451 */     int maxDelta = 40;
/* 452 */     if (this.lastPt != null) {
/*     */       
/* 454 */       dx = pt.x - this.lastPt.x;
/* 455 */       dy = pt.y - this.lastPt.y;
/*     */       
/* 457 */       if (dx < -maxDelta) { dx = -maxDelta; }
/* 458 */       else if (dx > maxDelta) { dx = maxDelta; }
/* 459 */        if (dy < -maxDelta) { dy = -maxDelta; }
/* 460 */       else if (dy > maxDelta) { dy = maxDelta; }
/*     */ 
/*     */       
/* 463 */       JViewport vp = (JViewport)getParent();
/* 464 */       Rectangle newRect = new Rectangle(visibleRect.x + dx, 
/* 465 */           visibleRect.y + dy, 
/* 466 */           visibleRect.width, 
/* 467 */           visibleRect.height);
/* 468 */       vp.scrollRectToVisible(newRect);
/*     */     } 
/*     */     
/* 471 */     this.lastPt = pt;
/* 472 */     this.lastVisibleRect = visibleRect;
/*     */ 
/*     */     
/* 475 */     if (getImagePanelReference() != null) {
/*     */ 
/*     */       
/* 478 */       photoChanged(Global.getPhoto(), this);
/* 479 */       ((GlobalChangeListener)getImagePanelReference()).photoChanged(photo, this);
/*     */     }
/*     */     else {
/*     */       
/* 483 */       Global.fireSelectedPhotoChanged(this);
/*     */     }  }
/*     */   
/*     */   class HorizontalAdjustmentListener implements AdjustmentListener { final SelectedPhotoImagePanel this$0;
/*     */     
/*     */     HorizontalAdjustmentListener(SelectedPhotoImagePanel this$0) {
/* 489 */       this.this$0 = this$0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void adjustmentValueChanged(AdjustmentEvent evt) {
/* 495 */       if (Global.getPhoto() == null || !Global.getPhoto().isPanoramic()) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 501 */       if (this.this$0.getImagePanelReference() != null) {
/*     */ 
/*     */         
/* 504 */         this.this$0.photoChanged(Global.getPhoto(), this.this$0);
/* 505 */         ((GlobalChangeListener)this.this$0.getImagePanelReference()).photoChanged(Global.getPhoto(), this.this$0);
/*     */       }
/*     */       else {
/*     */         
/* 509 */         Global.fireSelectedPhotoChanged(this.this$0);
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\SelectedPhotoImagePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */