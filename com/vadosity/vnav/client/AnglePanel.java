/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.MouseEvent;
/*     */ 
/*     */ public class AnglePanel extends JPanel implements GlobalChangeListener, SettingsChangeListener {
/*  10 */   private double startAngle = -1.0D;
/*  11 */   private double finishAngle = -1.0D;
/*     */   private int arrowLength;
/*     */   private boolean mouseDragging = false;
/*  14 */   private Point mouse = null;
/*     */   
/*     */   private boolean dragStartAngle = false;
/*     */   private boolean dragFinishAngle = false;
/*     */   private boolean paintFinishAngle = true;
/*     */   
/*     */   public AnglePanel() {
/*     */     try {
/*  22 */       jbInit();
/*  23 */       Global.addGlobalChangeListener(this);
/*  24 */       Global.addSettingsChangeListener(this);
/*     */     }
/*  26 */     catch (Exception e) {
/*  27 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   private void jbInit() throws Exception {
/*  31 */     addMouseListener(new AnglePanel_this_mouseAdapter(this));
/*  32 */     addMouseMotionListener(new AnglePanel_this_mouseMotionAdapter(this));
/*     */   }
/*     */   public void tourChanged(Tour selectedTour, Object src) {}
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {}
/*     */   
/*     */   public void photoChanged(Photo photo, Object src) {
/*  40 */     if (photo == null)
/*     */       return; 
/*  42 */     setStartAngle(photo.getStartAngle());
/*     */     
/*  44 */     if (!photo.isPanoramic())
/*     */     {
/*  46 */       this.paintFinishAngle = false;
/*     */     }
/*  48 */     if (photo.isPanoramic()) {
/*     */       
/*  50 */       this.paintFinishAngle = true;
/*  51 */       setFinishAngle(photo.getFinishAngle());
/*     */     } 
/*  53 */     updateUI();
/*     */   }
/*     */   
/*     */   public void settingsChanged(Object src) {
/*  57 */     if (src == this) {
/*     */       return;
/*     */     }
/*  60 */     if (Global.getPhoto() == null && 
/*  61 */       MultiPhotoUtil.getInstance().getAngles() != null && (
/*  62 */       MultiPhotoUtil.getInstance().getAngles()).length == 1) {
/*     */ 
/*     */       
/*  65 */       setStartAngle(Settings.getStartAngle());
/*  66 */       updateUI();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintAngleValues(Graphics g) {
/* 152 */     if (Global.getPhoto() != null) {
/*     */       
/* 154 */       if (isPaintFinishAngle()) {
/*     */ 
/*     */         
/* 157 */         int i = 20;
/* 158 */         int j = getHeight() - 5;
/* 159 */         int finishX = getWidth() - 50;
/* 160 */         int finishY = j;
/* 161 */         g.setColor(Color.blue);
/* 162 */         g.drawString((int)Math.toDegrees(this.startAngle), i, j);
/* 163 */         g.setColor(Color.red);
/* 164 */         g.drawString((int)Math.toDegrees(this.finishAngle), finishX, finishY);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 169 */       int startX = getWidth() / 2 - 10;
/* 170 */       int startY = getHeight() - 5;
/* 171 */       g.setColor(Color.blue);
/* 172 */       g.drawString((int)Math.toDegrees(this.startAngle), startX, startY);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 177 */     if (Global.getPhoto() == null) {
/*     */       
/* 179 */       double[] angles = MultiPhotoUtil.getInstance().getAngles();
/*     */       
/* 181 */       if (angles.length < 1)
/*     */         return; 
/* 183 */       if (angles.length == 1 || Settings.isFullCircle()) {
/*     */         
/* 185 */         int i = getWidth() / 2 - 10;
/* 186 */         int j = getHeight() - 5;
/* 187 */         g.setColor(Color.blue);
/* 188 */         g.drawString((int)Math.toDegrees(angles[0]), i, j);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 193 */       int startX = 20;
/* 194 */       int startY = getHeight() - 5;
/* 195 */       int finishX = getWidth() - 50;
/* 196 */       int finishY = startY;
/* 197 */       g.setColor(Color.blue);
/* 198 */       g.drawString((int)Math.toDegrees(angles[0]), startX, startY);
/* 199 */       g.setColor(Color.red);
/* 200 */       double lastAngle = angles[angles.length - 1] % 6.283185307179586D;
/* 201 */       g.drawString((int)Math.toDegrees(lastAngle), finishX, finishY);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/* 222 */     super.paint(g);
/* 223 */     int arrowLength = getWidth() / 3;
/*     */     
/* 225 */     if (Global.getPhoto() != null) {
/*     */ 
/*     */       
/* 228 */       GraphicsUtil.paintArrowFromCenter(g, arrowLength, this, this.startAngle, Color.blue, false);
/* 229 */       if (isPaintFinishAngle())
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 234 */         GraphicsUtil.paintArrowFromCenter(g, arrowLength, this, this.finishAngle, Color.red, false);
/*     */       }
/* 236 */       paintAngleValues(g);
/*     */     } 
/* 238 */     if (Global.getPhoto() == null) {
/*     */ 
/*     */ 
/*     */       
/* 242 */       MultiPhotoUtil.getInstance().determineCoverageAngle();
/* 243 */       MultiPhotoUtil.getInstance().determineAngleBetweenPhotos();
/* 244 */       MultiPhotoUtil.getInstance().determineAngles();
/*     */       
/* 246 */       paintAngleValues(g);
/*     */ 
/*     */       
/*     */       try {
/* 250 */         double[] angles = MultiPhotoUtil.getInstance().getAngles();
/* 251 */         if (Settings.isAddPanoramicPhotos() || Settings.getNumberPhotos() > 1) {
/*     */ 
/*     */           
/* 254 */           int radius = 3 * arrowLength / 4;
/* 255 */           int startAngle = -((int)Math.toDegrees(angles[0]));
/* 256 */           int arcAngle = 0;
/* 257 */           if (Settings.isClockwise()) { arcAngle = -((int)Math.toDegrees(
/* 258 */                 MultiPhotoUtil.getInstance().getCoverageAngle())); }
/* 259 */           else { arcAngle = (int)Math.toDegrees(MultiPhotoUtil.getInstance()
/* 260 */                 .getCoverageAngle()); }
/* 261 */            g.setColor(Color.white);
/* 262 */           g.fillArc(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius, 
/* 263 */               startAngle, arcAngle);
/* 264 */           g.setColor(Color.black);
/* 265 */           g.drawArc(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius, 
/* 266 */               startAngle, arcAngle);
/*     */         } 
/*     */         
/* 269 */         Point base = new Point(getWidth() / 2, getHeight() / 2);
/* 270 */         Point tip = null;
/* 271 */         for (int i = 0; i < angles.length; i++) {
/*     */           
/* 273 */           if (i == 0) {
/*     */             
/* 275 */             g.setColor(Color.blue);
/*     */           }
/* 277 */           else if (i != 0 && i == angles.length - 1) {
/*     */             
/* 279 */             if (Settings.isAddPanoramicPhotos() && angles.length == 2 && Settings.isFullCircle())
/* 280 */               continue;  g.setColor(Color.red);
/*     */           }
/*     */           else {
/*     */             
/* 284 */             g.setColor(Color.black);
/*     */           } 
/* 286 */           double ci = Math.cos(angles[i]);
/* 287 */           double si = Math.sin(angles[i]);
/* 288 */           int x1 = getWidth() / 2 + (int)Math.round(arrowLength * ci);
/* 289 */           int y1 = getHeight() / 2 + (int)Math.round(arrowLength * si);
/* 290 */           tip = new Point(x1, y1);
/* 291 */           (new LightArrow(base, tip)).paint(g, g.getColor());
/*     */           
/* 293 */           if (angles.length > 1) {
/*     */ 
/*     */             
/* 296 */             int textH = 14;
/* 297 */             int textW = 10;
/*     */             
/* 299 */             int xOffset = (int)Math.round(textW * ci);
/* 300 */             int yOffset = (int)Math.round(textH * si);
/* 301 */             if (ci > 0.0D) xOffset = 0; 
/* 302 */             if (si < 0.0D) yOffset = 0; 
/* 303 */             g.drawString(i + 1, x1 + xOffset, y1 + yOffset);
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/* 308 */       } catch (Exception e) {
/*     */         
/* 310 */         e.printStackTrace();
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
/*     */   
/*     */   void this_mouseDragged(MouseEvent e) {
/* 324 */     this.mouse = e.getPoint();
/* 325 */     if (!this.mouseDragging) {
/*     */       
/* 327 */       makeDragDecision();
/* 328 */       this.mouseDragging = true;
/*     */     } 
/*     */     
/* 331 */     double angleFromCenter = GraphicsUtil.getAngleFromCenter(this, e.getPoint());
/* 332 */     if (this.dragStartAngle) {
/*     */       
/* 334 */       this.startAngle = angleFromCenter;
/* 335 */       Settings.setStartAngle(this.startAngle);
/* 336 */       if (Global.getPhoto() != null) {
/*     */         
/* 338 */         Global.getPhoto().setStartAngle(this.startAngle);
/* 339 */         Global.fireSelectedPhotoChanged(this);
/*     */       } 
/* 341 */       Global.fireSettingsChanged(this);
/*     */     } 
/* 343 */     if (this.dragFinishAngle) {
/*     */       
/* 345 */       this.finishAngle = angleFromCenter;
/* 346 */       Settings.setFinishAngle(this.finishAngle);
/* 347 */       if (Global.getPhoto() != null) {
/*     */         
/* 349 */         Global.getPhoto().setFinishAngle(this.finishAngle);
/* 350 */         Global.fireSelectedPhotoChanged(this);
/*     */       } 
/* 352 */       Global.fireSettingsChanged(this);
/*     */     } 
/*     */ 
/*     */     
/* 356 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getFinishAngle() {
/* 367 */     return this.finishAngle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFinishAngle(double finishAngle) {
/* 373 */     this.finishAngle = finishAngle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getStartAngle() {
/* 379 */     return this.startAngle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartAngle(double startAngle) {
/* 385 */     this.startAngle = startAngle;
/*     */   }
/*     */ 
/*     */   
/*     */   public void makeDragDecision() {
/* 390 */     double angle = GraphicsUtil.getAngleFromCenter(this, this.mouse);
/* 391 */     double startAngleDiff = GraphicsUtil.angularDiff(this.startAngle, angle);
/* 392 */     double finishAngleDiff = GraphicsUtil.angularDiff(this.finishAngle, angle);
/*     */     
/* 394 */     if (Settings.isFullCircle() && Global.getPhoto() == null) {
/*     */       
/* 396 */       this.dragStartAngle = true;
/* 397 */       this.dragFinishAngle = false;
/*     */       return;
/*     */     } 
/* 400 */     if (startAngleDiff <= finishAngleDiff) {
/*     */       
/* 402 */       this.dragStartAngle = true;
/* 403 */       this.dragFinishAngle = false;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 408 */     this.dragStartAngle = false;
/* 409 */     this.dragFinishAngle = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseReleased(MouseEvent e) {
/* 416 */     this.mouseDragging = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPaintFinishAngle() {
/* 422 */     return this.paintFinishAngle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPaintFinishAngle(boolean paintFinishAngle) {
/* 428 */     this.paintFinishAngle = paintFinishAngle;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\AnglePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */