/*     */ package com.vadosity.vnav.bean;
/*     */ import com.vadosity.vnav.client.Flash;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.LightArrow;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.MediaTracker;
/*     */ import java.awt.Point;
/*     */ import java.awt.Polygon;
/*     */ import java.text.MessageFormat;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class Photo implements Serializable, Cloneable {
/*     */   static final long serialVersionUID = 1978025845485056998L;
/*  17 */   private String name = "";
/*  18 */   private String description = "";
/*     */   
/*  20 */   private byte[] bytes = null;
/*  21 */   protected transient Flash flash = null;
/*  22 */   public Flash getFlash() { return this.flash; } public void setFlash(Flash flash) {
/*  23 */     this.flash = flash;
/*     */   }
/*  25 */   private double startVisibleAngle = 0.0D;
/*  26 */   public double getStartVisibleAngle() { return this.startVisibleAngle; } public void setStartVisibleAngle(double radians) {
/*  27 */     this.startVisibleAngle = radians;
/*     */   }
/*  29 */   private double finishVisibleAngle = 0.0D; private PhotoPoint photoPoint; private int photoWidth; private int photoHeight; private boolean panoramic; private double startAngle; private double finishAngle; private boolean clockwise; private boolean completeRevolution; private double coverageAngle;
/*  30 */   public double getFinishVisibleAngle() { return this.finishVisibleAngle; } public void setFinishVisibleAngle(double radians) {
/*  31 */     this.finishVisibleAngle = radians;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  40 */     String message = "Photo ({0} bytes)";
/*  41 */     String[] sa = { getNumberOfBytes() };
/*  42 */     message = MessageFormat.format(message, (Object[])sa);
/*  43 */     return message;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfBytes() {
/*  48 */     if (this.bytes == null) return 0; 
/*  49 */     return this.bytes.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintPanoramic(Graphics g) {
/*  56 */     int radius = Settings.getFlashLength();
/*  57 */     int startDegrees = -((int)Math.toDegrees(this.startAngle));
/*  58 */     int startVisibleDegrees = -((int)Math.toDegrees(this.startVisibleAngle));
/*     */     
/*  60 */     int coveredVisibleDegrees = (int)Math.toDegrees(this.startVisibleAngle - this.finishVisibleAngle);
/*     */     
/*  62 */     int arcAngle = 0;
/*  63 */     int centerx = getPhotoPoint().getX();
/*  64 */     int centery = getPhotoPoint().getY();
/*  65 */     int diameter = Settings.getPhotoPointDiameter();
/*  66 */     int circRadius = diameter / 2;
/*     */ 
/*     */     
/*  69 */     if (equals(Global.getPhoto())) {
/*     */ 
/*     */       
/*  72 */       g.setColor(Settings.getSelectedPhotoPointFillColor());
/*  73 */       g.fillOval(centerx - circRadius, centery - circRadius, diameter, diameter);
/*     */       
/*  75 */       g.setColor(Settings.getSelectedPhotoPointOutlineColor());
/*  76 */       g.drawOval(centerx - circRadius, centery - circRadius, diameter, diameter);
/*  77 */       if (Settings.isDrawDotInCircle()) g.fillOval(centerx - 1, centery - 1, 4, 4);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  82 */       if (Settings.getPhotoPointFillColor() != null) {
/*     */         
/*  84 */         Color c = Settings.getPhotoPointFillColor();
/*  85 */         g.setColor(c);
/*  86 */         g.fillOval(centerx - circRadius, centery - circRadius, diameter, diameter);
/*     */       } 
/*  88 */       g.setColor(Settings.getPhotoPointOutlineColor());
/*  89 */       g.drawOval(centerx - circRadius, centery - circRadius, diameter, diameter);
/*  90 */       if (Settings.isDrawDotInCircle()) g.fillOval(centerx - 1, centery - 1, 4, 4);
/*     */     
/*     */     } 
/*  93 */     if (isClockwise()) { arcAngle = -((int)Math.toDegrees(this.coverageAngle)); }
/*  94 */     else { arcAngle = (int)Math.toDegrees(this.coverageAngle); }
/*     */ 
/*     */     
/*  97 */     Color fillColor = null;
/*  98 */     Color outlineColor = null;
/*     */ 
/*     */     
/* 101 */     fillColor = Settings.getFlashFillColor();
/* 102 */     outlineColor = Settings.getFlashOutlineColor();
/* 103 */     if (fillColor != null) {
/*     */       
/* 105 */       g.setColor(fillColor);
/* 106 */       g.fillArc(centerx - radius, centery - radius, 2 * radius, 2 * radius, startDegrees, arcAngle);
/*     */     } 
/* 108 */     g.setColor(outlineColor);
/* 109 */     g.drawArc(centerx - radius, centery - radius, 2 * radius, 2 * radius, startDegrees, arcAngle);
/*     */ 
/*     */     
/* 112 */     if (this == Global.getPhoto()) {
/*     */ 
/*     */       
/* 115 */       fillColor = Settings.getSelectedFlashFillColor();
/* 116 */       outlineColor = Settings.getSelectedFlashOutlineColor();
/* 117 */       if (fillColor != null) {
/*     */         
/* 119 */         g.setColor(fillColor);
/* 120 */         g.fillArc(centerx - radius, centery - radius, 2 * radius, 2 * radius, startVisibleDegrees, coveredVisibleDegrees);
/*     */       } 
/* 122 */       g.setColor(outlineColor);
/* 123 */       double vc1 = Math.cos(this.startVisibleAngle);
/* 124 */       double vs1 = Math.sin(this.startVisibleAngle);
/* 125 */       int vx1 = centerx + (int)Math.round(radius * vc1);
/* 126 */       int vy1 = centery + (int)Math.round(radius * vs1);
/* 127 */       double vc2 = Math.cos(this.finishVisibleAngle);
/* 128 */       double vs2 = Math.sin(this.finishVisibleAngle);
/* 129 */       int vx2 = centerx + (int)Math.round(radius * vc2);
/* 130 */       int vy2 = centery + (int)Math.round(radius * vs2);
/* 131 */       g.drawLine(centerx, centery, vx1, vy1);
/* 132 */       g.drawLine(centerx, centery, vx2, vy2);
/*     */     } 
/*     */ 
/*     */     
/* 136 */     g.setColor(Settings.getFlashOutlineColor());
/* 137 */     g.drawArc(centerx - radius, centery - radius, 2 * radius, 2 * radius, startVisibleDegrees, coveredVisibleDegrees);
/*     */     
/* 139 */     double c1 = Math.cos(this.startAngle);
/* 140 */     double s1 = Math.sin(this.startAngle);
/* 141 */     int x1 = centerx + (int)Math.round(radius * c1);
/* 142 */     int y1 = centery + (int)Math.round(radius * s1);
/* 143 */     g.drawLine(centerx, centery, x1, y1);
/*     */     
/* 145 */     if (!isCompleteRevolution()) {
/*     */       
/* 147 */       double c2 = Math.cos(this.finishAngle);
/* 148 */       double s2 = Math.sin(this.finishAngle);
/* 149 */       int x2 = centerx + (int)Math.round(radius * c2);
/* 150 */       int y2 = centery + (int)Math.round(radius * s2);
/* 151 */       g.drawLine(centerx, centery, x2, y2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintPanoramicMarkers(Graphics g) {
/* 160 */     int centerx = getPhotoPoint().getX();
/* 161 */     int centery = getPhotoPoint().getY();
/* 162 */     g.setColor(Settings.getFlashOutlineColor());
/* 163 */     g.drawLine(centerx, centery - 5, centerx, centery + 5);
/* 164 */     g.drawLine(centerx - 5, centery, centerx + 5, centery);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintFloodLight(Graphics g) {
/* 170 */     if (!Settings.isDrawFloodLights()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 175 */     if (equals(Global.getPhoto()))
/*     */     {
/* 177 */       if (isPanoramic()) {
/*     */         
/* 179 */         if (this.startVisibleAngle == this.finishVisibleAngle)
/*     */           return; 
/* 181 */         int distance = Settings.getFloodLightLength();
/*     */         
/* 183 */         g.setColor(Settings.getFloodLightOutlineColor());
/* 184 */         if (Settings.getFloodLightOutlineColor() == null) g.setColor(Color.blue); 
/* 185 */         int sva0x = getPhotoPoint().getX();
/* 186 */         int sva0y = getPhotoPoint().getY();
/* 187 */         int sva1x = (int)(sva0x + distance * Math.cos(this.startVisibleAngle));
/* 188 */         int sva1y = (int)(sva0y + distance * Math.sin(this.startVisibleAngle));
/* 189 */         g.drawLine(sva0x, sva0y, sva1x, sva1y);
/*     */         
/* 191 */         int fva0x = getPhotoPoint().getX();
/* 192 */         int fva0y = getPhotoPoint().getY();
/* 193 */         int fva1x = (int)(fva0x + distance * Math.cos(this.finishVisibleAngle));
/* 194 */         int fva1y = (int)(fva0y + distance * Math.sin(this.finishVisibleAngle));
/* 195 */         g.drawLine(fva0x, fva0y, fva1x, fva1y);
/*     */         
/* 197 */         g.setColor(Settings.getFloodLightFillColor());
/* 198 */         Polygon p = new Polygon();
/* 199 */         p.addPoint(sva1x, sva1y);
/* 200 */         p.addPoint(fva0x, fva0y);
/* 201 */         p.addPoint(fva1x, fva1y);
/* 202 */         g.fillPolygon(p);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 207 */         int distance = Settings.getFloodLightLength();
/* 208 */         double displayAngle = Math.toRadians(Settings.getFlashCoverageDegrees());
/* 209 */         int sva0x = getPhotoPoint().getX();
/* 210 */         int sva0y = getPhotoPoint().getY();
/* 211 */         int sva1x = (int)(sva0x + distance * Math.cos(this.startAngle - displayAngle / 2.0D));
/* 212 */         int sva1y = (int)(sva0y + distance * Math.sin(this.startAngle - displayAngle / 2.0D));
/*     */ 
/*     */         
/* 215 */         int fva0x = getPhotoPoint().getX();
/* 216 */         int fva0y = getPhotoPoint().getY();
/* 217 */         int fva1x = (int)(fva0x + distance * Math.cos(this.startAngle + displayAngle / 2.0D));
/* 218 */         int fva1y = (int)(fva0y + distance * Math.sin(this.startAngle + displayAngle / 2.0D));
/* 219 */         g.setColor(Settings.getFloodLightFillColor());
/* 220 */         Polygon p = new Polygon();
/* 221 */         p.addPoint(sva1x, sva1y);
/* 222 */         p.addPoint(fva0x, fva0y);
/* 223 */         p.addPoint(fva1x, fva1y);
/* 224 */         g.fillPolygon(p);
/*     */         
/* 226 */         g.setColor(Settings.getFloodLightOutlineColor());
/* 227 */         g.drawLine(sva0x, sva0y, sva1x, sva1y);
/* 228 */         g.drawLine(fva0x, fva0y, fva1x, fva1y);
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
/*     */   public void paint(Graphics g) {
/* 240 */     PhotoPoint photoPoint = getPhotoPoint();
/* 241 */     if (photoPoint == null || g == null)
/*     */       return; 
/* 243 */     if (isPanoramic() && (
/* 244 */       Settings.isCirclePoints() || 
/* 245 */       Settings.isDrawAllFlashes() || 
/* 246 */       Settings.isDrawLightArrows() || 
/* 247 */       Settings.isDrawFootSteps())) {
/*     */       
/* 249 */       paintPanoramic(g);
/* 250 */       paintFloodLight(g);
/*     */       return;
/*     */     } 
/* 253 */     if (isPanoramic())
/*     */     {
/* 255 */       paintPanoramicMarkers(g);
/*     */     }
/* 257 */     paintFloodLight(g);
/*     */ 
/*     */     
/* 260 */     if (Settings.isDrawAllFlashes()) {
/*     */ 
/*     */       
/* 263 */       int length = Settings.getFlashLength();
/* 264 */       double flashCoverageAngle = Math.toRadians(Settings.getFlashCoverageDegrees());
/* 265 */       double photoAngle = getStartAngle();
/* 266 */       double angle = photoAngle - flashCoverageAngle / 2.0D;
/* 267 */       int x = photoPoint.getX();
/* 268 */       int y = photoPoint.getY();
/*     */       
/* 270 */       int x0 = x - length;
/* 271 */       int y0 = y - length;
/* 272 */       int w = length * 2;
/* 273 */       int h = length * 2;
/*     */ 
/*     */       
/* 276 */       if (equals(Global.getPhoto()) && Settings.getSelectedFlashFillColor() != null) {
/*     */         
/* 278 */         g.setColor(Settings.getSelectedFlashFillColor());
/* 279 */         g.fillArc(x0, y0, w, h, (int)Math.toDegrees(-angle), (int)Math.toDegrees(-flashCoverageAngle));
/*     */       }
/* 281 */       else if (!equals(Global.getPhoto()) && Settings.getFlashFillColor() != null) {
/*     */         
/* 283 */         g.setColor(Settings.getFlashFillColor());
/* 284 */         g.fillArc(x0, y0, w, h, (int)Math.toDegrees(-angle), (int)Math.toDegrees(-flashCoverageAngle));
/*     */       } 
/*     */ 
/*     */       
/* 288 */       if (equals(Global.getPhoto()) && Settings.getSelectedFlashOutlineColor() != null) {
/*     */         
/* 290 */         g.setColor(Settings.getSelectedFlashOutlineColor());
/* 291 */         g.drawArc(x0, y0, w, h, (int)Math.toDegrees(-angle), (int)Math.toDegrees(-flashCoverageAngle));
/*     */ 
/*     */         
/* 294 */         double angleRad1 = angle;
/* 295 */         double angleRad2 = angle + flashCoverageAngle;
/* 296 */         int x1 = x + (int)(length * Math.cos(angleRad1));
/* 297 */         int y1 = y + (int)(length * Math.sin(angleRad1));
/* 298 */         int x2 = x + (int)(length * Math.cos(angleRad2));
/* 299 */         int y2 = y + (int)(length * Math.sin(angleRad2));
/* 300 */         g.drawLine(x, y, x1, y1);
/* 301 */         g.drawLine(x, y, x2, y2);
/*     */       }
/* 303 */       else if (Settings.getFlashOutlineColor() != null) {
/*     */         
/* 305 */         g.setColor(Settings.getFlashOutlineColor());
/* 306 */         g.drawArc(x0, y0, w, h, (int)Math.toDegrees(-angle), (int)Math.toDegrees(-flashCoverageAngle));
/*     */ 
/*     */         
/* 309 */         double angleRad1 = angle;
/* 310 */         double angleRad2 = angle + flashCoverageAngle;
/* 311 */         int x1 = x + (int)(length * Math.cos(angleRad1));
/* 312 */         int y1 = y + (int)(length * Math.sin(angleRad1));
/* 313 */         int x2 = x + (int)(length * Math.cos(angleRad2));
/* 314 */         int y2 = y + (int)(length * Math.sin(angleRad2));
/* 315 */         g.drawLine(x, y, x1, y1);
/* 316 */         g.drawLine(x, y, x2, y2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 321 */     if (Settings.isDrawLightArrows()) {
/*     */       
/* 323 */       int len = Settings.getLightArrowLength();
/*     */       
/* 325 */       int x1 = (int)Math.round(photoPoint.getX() + len * Math.cos(getStartAngle()));
/* 326 */       int y1 = (int)Math.round(photoPoint.getY() + len * Math.sin(getStartAngle()));
/* 327 */       if (equals(Global.getPhoto())) {
/*     */         
/* 329 */         (new LightArrow(new Point(photoPoint.getX(), photoPoint.getY()), new Point(x1, y1))).paintSelected(g, null);
/*     */       }
/*     */       else {
/*     */         
/* 333 */         (new LightArrow(new Point(photoPoint.getX(), photoPoint.getY()), new Point(x1, y1))).paint(g, null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doCalculations() {
/* 343 */     if (Global.getTour().isLocked())
/* 344 */       return;  this.flash = new Flash(this);
/* 345 */     this.flash.doCalculations();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Photo()
/*     */   {
/* 355 */     this.photoPoint = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 401 */     this.photoWidth = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 410 */     this.photoHeight = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 420 */     this.panoramic = false;
/*     */ 
/*     */ 
/*     */     
/* 424 */     this.startAngle = -1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 433 */     this.finishAngle = -1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 442 */     this.clockwise = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 451 */     this.completeRevolution = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 460 */     this.coverageAngle = 0.0D; } public Photo(PhotoPoint photoPoint) { this.photoPoint = null; this.photoWidth = -1; this.photoHeight = -1; this.panoramic = false; this.startAngle = -1.0D; this.finishAngle = -1.0D; this.clockwise = true; this.completeRevolution = false; this.coverageAngle = 0.0D; setPhotoPoint(photoPoint); this.flash = new Flash(this); }
/* 461 */   public PhotoPoint getPhotoPoint() { return this.photoPoint; } public void setPhotoPoint(PhotoPoint photoPoint) { this.photoPoint = photoPoint; } public void setName(String name) { Global.getTour().setModified(true); this.name = name; } public String getName() { return this.name; } public void setDescription(String description) { Global.getTour().setModified(true); this.description = description; } public String getDescription() { return this.description; } public byte[] getBytes() { return this.bytes; } public void setBytes(byte[] bytes) { this.bytes = bytes; Global.getTour().setModified(true); if (bytes != null) try { JPanel p = new JPanel(); MediaTracker tracker = new MediaTracker(p); Image im = Toolkit.getDefaultToolkit().createImage(bytes); tracker.addImage(im, 0); tracker.waitForID(0); this.photoHeight = im.getHeight(p); this.photoWidth = im.getWidth(p); im = null; tracker = null; } catch (Exception e) { e.printStackTrace(); }   } public int getPhotoWidth() { if (this.photoWidth == -1) setBytes(getBytes());  return this.photoWidth; } public int getPhotoHeight() { if (this.photoHeight == -1) setBytes(getBytes());  return this.photoHeight; } public double getCoverageAngle() { return this.coverageAngle; }
/* 462 */   public void setPanoramic(boolean b) { this.panoramic = b; } public boolean isPanoramic() { return this.panoramic; } public double getStartAngle() { return this.startAngle; } public void setStartAngle(double angle) { Global.getTour().setModified(true); this.startAngle = angle % 6.283185307179586D; if (isPanoramic()) determineCoverageAngle();  } public double getFinishAngle() { return this.finishAngle; } public void setFinishAngle(double angle) { Global.getTour().setModified(true); this.finishAngle = angle; if (isPanoramic()) determineCoverageAngle();  } public boolean isClockwise() { return this.clockwise; } public void setClockwise(boolean b) { Global.getTour().setModified(true); this.clockwise = b; determineCoverageAngle(); } public boolean isCompleteRevolution() { return this.completeRevolution; } public void setCompleteRevolution(boolean b) { Global.getTour().setModified(true); this.completeRevolution = b; determineCoverageAngle(); } public void setCoverageAngle(double angle) { this.coverageAngle = angle; }
/*     */   
/*     */   public void setCoverageDegrees(double degrees) {
/* 465 */     setCoverageAngle(Math.toRadians(degrees));
/*     */   }
/*     */   
/*     */   public void setCoverageDegrees(String degrees) {
/* 469 */     setCoverageDegrees(Double.parseDouble(degrees));
/*     */   }
/*     */   
/*     */   public void determineCoverageAngle() {
/* 473 */     if (this.finishAngle > 6.283185307179586D) this.finishAngle %= 6.283185307179586D; 
/* 474 */     if (this.finishAngle < 0.0D) this.finishAngle += 6.283185307179586D; 
/* 475 */     if (this.startAngle > 6.283185307179586D) this.startAngle %= 6.283185307179586D; 
/* 476 */     if (this.startAngle < 0.0D) this.startAngle += 6.283185307179586D;
/*     */     
/* 478 */     if (this.completeRevolution || this.finishAngle == this.startAngle) {
/*     */       
/* 480 */       this.coverageAngle = 6.283185307179586D;
/*     */       
/*     */       return;
/*     */     } 
/* 484 */     if (this.clockwise && this.finishAngle > this.startAngle) {
/*     */       
/* 486 */       this.coverageAngle = this.finishAngle - this.startAngle;
/*     */       return;
/*     */     } 
/* 489 */     if (this.clockwise && this.finishAngle < this.startAngle) {
/*     */       
/* 491 */       this.coverageAngle = 6.283185307179586D - this.startAngle + this.finishAngle;
/*     */       return;
/*     */     } 
/* 494 */     if (!this.clockwise && this.finishAngle > this.startAngle) {
/*     */       
/* 496 */       this.coverageAngle = this.startAngle + 6.283185307179586D - this.finishAngle;
/*     */       return;
/*     */     } 
/* 499 */     if (!this.clockwise && this.finishAngle < this.startAngle) {
/*     */       
/* 501 */       this.coverageAngle = this.startAngle - this.finishAngle;
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\bean\Photo.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */