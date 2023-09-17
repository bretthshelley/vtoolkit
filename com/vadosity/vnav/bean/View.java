/*     */ package com.vadosity.vnav.bean;
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Trail;
/*     */ import java.awt.Image;
/*     */ import java.awt.MediaTracker;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class View implements Serializable, Cloneable {
/*  13 */   private String id = null; static final long serialVersionUID = -8198530792902062216L;
/*  14 */   private String name = "";
/*  15 */   private String description = "";
/*  16 */   private byte[] imageBytes = null;
/*  17 */   private byte[] overlayImageBytes = null;
/*  18 */   private double overlayAlpha = 0.2D;
/*  19 */   private Vector vPhotoPoints = new Vector();
/*  20 */   private transient Trail trail = null;
/*  21 */   private Vector vOrderedPhotos = new Vector();
/*  22 */   private double scale = 1.0D;
/*  23 */   private Vector vViewLinks = new Vector();
/*  24 */   private int speedIndex = 2;
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector getViewLinks() {
/*  29 */     if (this.vViewLinks == null) this.vViewLinks = new Vector(); 
/*  30 */     return this.vViewLinks;
/*     */   }
/*     */   private boolean photoOrderSet = false;
/*     */   
/*     */   public boolean isPhotoOrderSet() {
/*  35 */     return this.photoOrderSet;
/*     */   }
/*     */   public void setPhotoOrderSet(boolean b) {
/*  38 */     if (b && this.photoOrderSet)
/*  39 */       return;  if (!b && !this.photoOrderSet)
/*     */       return; 
/*  41 */     if (b) { initPhotoOrder(); }
/*  42 */     else { resetOrder(); }
/*     */     
/*  44 */     this.photoOrderSet = b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  49 */   private ViewSettings viewSettings = new ViewSettings(); private int photoWidth; private int photoHeight;
/*  50 */   public ViewSettings getViewSettings() { return this.viewSettings; } public void setViewSettings(ViewSettings viewSettings) {
/*  51 */     this.viewSettings = viewSettings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfBytes() {
/*  59 */     if (getPhotos() == null) return 0;
/*     */     
/*  61 */     int count = 0;
/*     */ 
/*     */     
/*  64 */     if (getImageBytes() != null) count += (getImageBytes()).length; 
/*  65 */     if (getOverlayImageBytes() != null) count += (getOverlayImageBytes()).length;
/*     */ 
/*     */     
/*  68 */     Iterator it = getVPhotoPoints().iterator();
/*  69 */     while (it.hasNext())
/*     */     {
/*  71 */       count += ((PhotoPoint)it.next()).getNumberOfBytes();
/*     */     }
/*  73 */     return count;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfEmptyPhotos() {
/*  79 */     if (getPhotos() == null) return 0;
/*     */     
/*  81 */     int count = 0;
/*  82 */     for (int i = 0; i < getPhotos().size(); i++) {
/*     */       
/*  84 */       if (((Photo)getPhotos().elementAt(i)).getBytes() == null) count++; 
/*     */     } 
/*  86 */     return count;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOrder(Vector vPhotos) {
/*  91 */     this.vOrderedPhotos = vPhotos;
/*  92 */     this.photoOrderSet = true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initPhotoOrder() {
/*  97 */     this.vOrderedPhotos = getPhotos();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIndexOf(PhotoPoint photoPoint) {
/* 102 */     if (photoPoint == null || this.vPhotoPoints == null || this.vPhotoPoints.size() == 0) return -1;
/*     */     
/* 104 */     for (int i = 0; i < this.vPhotoPoints.size(); i++) {
/*     */       
/* 106 */       PhotoPoint p = this.vPhotoPoints.elementAt(i);
/* 107 */       if (p.equals(photoPoint)) return i; 
/*     */     } 
/* 109 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfPhotos() {
/* 114 */     if (this.vPhotoPoints == null || this.vPhotoPoints.isEmpty()) return 0; 
/* 115 */     return getPhotos().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfPhotoPoints() {
/* 120 */     if (this.vPhotoPoints == null || this.vPhotoPoints.isEmpty()) return 0; 
/* 121 */     return this.vPhotoPoints.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public PhotoPoint getFirstPhotoPoint() {
/* 126 */     if (this.vPhotoPoints == null || this.vPhotoPoints.isEmpty()) return null; 
/* 127 */     return this.vPhotoPoints.elementAt(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetOrder() {
/* 132 */     Global.getTour().setModified(true);
/* 133 */     this.vOrderedPhotos = null;
/* 134 */     this.vOrderedPhotos = new Vector();
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector getPhotos() {
/* 139 */     if (this.vPhotoPoints == null || this.vPhotoPoints.isEmpty()) return new Vector();
/*     */     
/* 141 */     if (this.vOrderedPhotos != null && this.vOrderedPhotos.size() > 0)
/*     */     {
/* 143 */       return this.vOrderedPhotos;
/*     */     }
/*     */     
/* 146 */     Vector vPhotos = new Vector();
/* 147 */     for (int i = 0; i < this.vPhotoPoints.size(); i++) {
/*     */       
/* 149 */       PhotoPoint photoPoint = this.vPhotoPoints.elementAt(i);
/* 150 */       vPhotos.addAll(photoPoint.getVPhotos());
/*     */     } 
/* 152 */     return vPhotos;
/*     */   }
/*     */   
/* 155 */   public Collection getVPhotoPoints() { return this.vPhotoPoints; } public void setVPhotoPoints(Vector vPhotoPoints) {
/* 156 */     this.vPhotoPoints = vPhotoPoints;
/*     */   }
/*     */   
/*     */   public void insert(Photo photo, int x, int y, int index) {
/* 160 */     if (photo == null)
/*     */       return; 
/* 162 */     PhotoPoint newPt = new PhotoPoint();
/* 163 */     newPt.setX(x);
/* 164 */     newPt.setY(y);
/* 165 */     newPt.add(photo);
/* 166 */     this.vPhotoPoints.insertElementAt(newPt, index);
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Photo photo, int x, int y) {
/* 171 */     if (photo == null)
/* 172 */       return;  Global.getTour().setModified(true);
/*     */     
/* 174 */     PhotoPoint pt = findPointAt(x, y);
/* 175 */     if (pt == null) {
/*     */       
/* 177 */       PhotoPoint newPt = new PhotoPoint();
/* 178 */       newPt.setX(x);
/* 179 */       newPt.setY(y);
/* 180 */       newPt.add(photo);
/* 181 */       this.vPhotoPoints.add(newPt);
/*     */       
/* 183 */       if (this.vOrderedPhotos != null && this.vOrderedPhotos.size() > 0)
/*     */       {
/*     */         
/* 186 */         this.vOrderedPhotos.add(photo);
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 192 */       pt.add(photo);
/* 193 */       if (this.vOrderedPhotos != null && this.vOrderedPhotos.size() > 0)
/*     */       {
/*     */         
/* 196 */         this.vOrderedPhotos.add(photo);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private PhotoPoint findPointAt(int x, int y) {
/* 204 */     if (this.vPhotoPoints == null || this.vPhotoPoints.size() == 0) return null;
/*     */     
/* 206 */     for (int i = 0; i < this.vPhotoPoints.size(); i++) {
/*     */       
/* 208 */       PhotoPoint pt = this.vPhotoPoints.elementAt(i);
/* 209 */       if (pt.getX() == x && pt.getY() == y) return this.vPhotoPoints.elementAt(i); 
/*     */     } 
/* 211 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(PhotoPoint photoPoint) {
/* 216 */     if (photoPoint == null)
/* 217 */       return;  Global.getTour().setModified(true);
/*     */     
/* 219 */     this.vPhotoPoints.add(photoPoint);
/*     */     
/* 221 */     if (this.vOrderedPhotos != null && this.vOrderedPhotos.size() > 0)
/*     */     {
/* 223 */       for (int i = 0; i < photoPoint.getVPhotos().size(); i++) {
/*     */ 
/*     */         
/* 226 */         if (!this.vOrderedPhotos.contains(photoPoint.getVPhotos().elementAt(i))) {
/* 227 */           this.vOrderedPhotos.add(photoPoint.getVPhotos().elementAt(i));
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void insert(PhotoPoint photoPoint, int index) {
/* 235 */     if (photoPoint == null)
/* 236 */       return;  Global.getTour().setModified(true);
/*     */     
/* 238 */     this.vPhotoPoints.insertElementAt(photoPoint, index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] loadFileData(String filepath) throws IOException, FileNotFoundException {
/* 244 */     if (filepath == null || filepath.trim().equals("")) throw new IllegalArgumentException("filepath is empty or null");
/*     */     
/* 246 */     FileInputStream fis = new FileInputStream(filepath);
/* 247 */     byte[] bytes = new byte[fis.available()];
/* 248 */     fis.read(bytes);
/* 249 */     fis.close();
/* 250 */     return bytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setId(String id) {
/* 255 */     this.id = id;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/* 260 */     if (this.id == null) this.id = (int)(Math.random() * 1.0E7D); 
/* 261 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/* 266 */     Global.getTour().setModified(true);
/* 267 */     this.name = name;
/*     */   } public String getName() {
/* 269 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 273 */     Global.getTour().setModified(true);
/* 274 */     this.description = description;
/*     */   } public String getDescription() {
/* 276 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setImageBytes(byte[] imageBytes) {
/* 280 */     Global.getTour().setModified(true);
/* 281 */     this.imageBytes = imageBytes;
/* 282 */     if (imageBytes != null) {
/*     */       
/*     */       try {
/*     */         
/* 286 */         JPanel p = new JPanel();
/* 287 */         MediaTracker tracker = new MediaTracker(p);
/* 288 */         Image im = Toolkit.getDefaultToolkit().createImage(imageBytes);
/* 289 */         tracker.addImage(im, 0);
/* 290 */         tracker.waitForID(0);
/* 291 */         this.photoHeight = im.getHeight(p);
/* 292 */         this.photoWidth = im.getWidth(p);
/*     */         
/* 294 */         im = null;
/* 295 */         tracker = null;
/*     */       }
/* 297 */       catch (Exception e) {
/* 298 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public View() {
/* 305 */     this.photoWidth = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     this.photoHeight = -1;
/*     */   }
/*     */   
/* 317 */   public int getPhotoHeight() { if (this.photoHeight == -1)
/*     */     {
/* 319 */       setImageBytes(getImageBytes());
/*     */     }
/* 321 */     return this.photoHeight; } public int getPhotoWidth() {
/*     */     if (this.photoWidth == -1)
/*     */       setImageBytes(getImageBytes()); 
/*     */     return this.photoWidth;
/*     */   } public int getMaxPixelDistance() {
/* 326 */     return (int)Math.round(Math.sqrt((this.photoWidth * this.photoWidth + this.photoHeight * this.photoHeight)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getImageBytes() {
/* 332 */     return this.imageBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 337 */     return "View Tab(" + getNumberOfBytes() + " bytes)";
/*     */   }
/*     */   
/*     */   public Trail getTrail() {
/* 341 */     if (this.trail == null) this.trail = new Trail(this); 
/* 342 */     return this.trail;
/*     */   } public void setTrail(Trail trail) {
/* 344 */     this.trail = trail;
/*     */   }
/*     */   
/*     */   public void doCalculations() {
/* 348 */     if (Global.getTour().isLocked())
/*     */       return; 
/* 350 */     this.trail = new Trail(this);
/*     */     
/* 352 */     if (this.vPhotoPoints != null)
/*     */     {
/* 354 */       for (int i = 0; i < this.vPhotoPoints.size(); i++)
/*     */       {
/* 356 */         ((PhotoPoint)this.vPhotoPoints.elementAt(i)).doCalculations();
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
/*     */   public double getScale() {
/* 368 */     if (this.scale == 0.0D) this.scale = 1.0D; 
/* 369 */     return this.scale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(double d) {
/* 377 */     Global.getTour().setModified(true);
/* 378 */     this.scale = d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getOverlayImageBytes() {
/* 386 */     return this.overlayImageBytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverlayImageBytes(byte[] bs) {
/* 394 */     this.overlayImageBytes = bs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getOverlayAlpha() {
/* 402 */     return this.overlayAlpha;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverlayAlpha(double d) {
/* 410 */     this.overlayAlpha = d;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSpeedIndex() {
/* 415 */     return this.speedIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSpeedIndex(int i) {
/* 420 */     this.speedIndex = i;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\bean\View.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */