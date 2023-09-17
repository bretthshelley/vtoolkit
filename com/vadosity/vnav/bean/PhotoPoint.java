/*     */ package com.vadosity.vnav.bean;
/*     */ 
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ import java.io.Serializable;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class PhotoPoint
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 358426671708947884L;
/*  15 */   private String name = "";
/*  16 */   private String description = "";
/*  17 */   private Vector vPhotos = new Vector();
/*  18 */   private int x = -1;
/*  19 */   private int y = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/*  24 */     if (object == null) return false; 
/*  25 */     if (!(object instanceof PhotoPoint)) return false; 
/*  26 */     PhotoPoint pt = (PhotoPoint)object;
/*  27 */     return (this.x == pt.x && this.y == pt.y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  33 */     int numPhotos = getNumberOfPhotos();
/*  34 */     String message = null;
/*  35 */     if (numPhotos == 1) {
/*     */       
/*  37 */       message = "Point with {0} Photo";
/*     */     }
/*     */     else {
/*     */       
/*  41 */       message = "Point with {0} Photos";
/*     */     } 
/*  43 */     String[] sa = { numPhotos };
/*  44 */     return MessageFormat.format(message, (Object[])sa);
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  49 */     int diameter = Settings.getPhotoPointDiameter();
/*  50 */     int radius = diameter / 2;
/*     */     
/*  52 */     if (Settings.isCirclePoints())
/*     */     {
/*     */       
/*  55 */       if (equals(Global.getPhotoPoint())) {
/*     */ 
/*     */         
/*  58 */         if (Settings.getSelectedPhotoPointFillColor() != null) {
/*     */           
/*  60 */           g.setColor(Settings.getSelectedPhotoPointFillColor());
/*  61 */           g.fillOval(getX() - radius, getY() - radius, diameter, diameter);
/*     */         } 
/*     */         
/*  64 */         if (Settings.getSelectedPhotoPointOutlineColor() != null)
/*     */         {
/*  66 */           g.setColor(Settings.getSelectedPhotoPointOutlineColor());
/*  67 */           g.drawOval(getX() - radius, getY() - radius, diameter, diameter);
/*  68 */           if (Settings.isDrawDotInCircle()) g.fillOval(getX() - 1, getY() - 1, 4, 4);
/*     */         
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/*  74 */         if (Settings.getPhotoPointFillColor() != null) {
/*     */           
/*  76 */           g.setColor(Settings.getPhotoPointFillColor());
/*  77 */           g.fillOval(getX() - radius, getY() - radius, diameter, diameter);
/*     */         } 
/*  79 */         if (Settings.getPhotoPointOutlineColor() != null) {
/*     */           
/*  81 */           g.setColor(Settings.getPhotoPointOutlineColor());
/*  82 */           g.drawOval(getX() - radius, getY() - radius, diameter, diameter);
/*  83 */           if (Settings.isDrawDotInCircle()) g.fillOval(getX() - 1, getY() - 1, 4, 4); 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isPanoramic() {
/*  90 */     if (getFirstPhoto() == null) return false; 
/*  91 */     return getFirstPhoto().isPanoramic();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfBytes() {
/*  97 */     if (this.vPhotos == null) return 0; 
/*  98 */     int count = 0;
/*  99 */     for (int i = 0; i < this.vPhotos.size(); i++) {
/*     */       
/* 101 */       if (((Photo)this.vPhotos.elementAt(i)).getBytes() != null)
/* 102 */         count += (((Photo)this.vPhotos.elementAt(i)).getBytes()).length; 
/*     */     } 
/* 104 */     return count;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfEmptyPhotos() {
/* 109 */     if (this.vPhotos == null) return 0; 
/* 110 */     int count = 0;
/* 111 */     for (int i = 0; i < this.vPhotos.size(); i++) {
/*     */       
/* 113 */       if (((Photo)this.vPhotos.elementAt(i)).getBytes() == null || ((
/* 114 */         (Photo)this.vPhotos.elementAt(i)).getBytes()).length == 0) count++; 
/*     */     } 
/* 116 */     return count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doCalculations() {
/* 123 */     if (Global.getTour().isLocked())
/*     */       return; 
/* 125 */     if (this.vPhotos != null)
/*     */     {
/* 127 */       for (int i = 0; i < this.vPhotos.size(); i++) {
/*     */         
/* 129 */         if ((Photo)this.vPhotos.elementAt(i) != null)
/*     */         {
/* 131 */           ((Photo)this.vPhotos.elementAt(i)).doCalculations();
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
/*     */   
/*     */   public Point getPoint() {
/* 146 */     return new Point(this.x, this.y);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfPhotos() {
/* 151 */     if (this.vPhotos == null) return 0; 
/* 152 */     return this.vPhotos.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasMultiplePhotos() {
/* 157 */     if (this.vPhotos == null || this.vPhotos.isEmpty() || this.vPhotos.size() <= 1) return false; 
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/* 163 */     if (Global.getView() != null) return (int)Math.round(this.x * Global.getView().getScale()); 
/* 164 */     return this.x;
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/* 168 */     if (Global.getTour() == null)
/* 169 */       return;  Global.getTour().setModified(true);
/* 170 */     this.x = x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/* 175 */     if (Global.getView() != null) return (int)Math.round(this.y * Global.getView().getScale()); 
/* 176 */     return this.y;
/*     */   }
/*     */   
/*     */   public void setY(int y) {
/* 180 */     if (Global.getTour() == null)
/* 181 */       return;  Global.getTour().setModified(true);
/* 182 */     this.y = y;
/*     */   }
/*     */ 
/*     */   
/*     */   public Photo getFirstPhoto() {
/* 187 */     if (this.vPhotos == null || this.vPhotos.isEmpty()) return null; 
/* 188 */     return this.vPhotos.elementAt(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Photo photo) {
/* 199 */     if (photo == null) {
/*     */       return;
/*     */     }
/* 202 */     Global.getTour().setModified(true);
/* 203 */     this.vPhotos.add(photo);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAllPhotos() {
/* 208 */     Global.getTour().setModified(true);
/* 209 */     this.vPhotos.removeAllElements();
/* 210 */     this.vPhotos = new Vector();
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Photo photo) {
/* 215 */     if (photo == null)
/* 216 */       return;  Global.getTour().setModified(true);
/* 217 */     this.vPhotos.remove(photo);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/* 222 */     Global.getTour().setModified(true);
/* 223 */     this.name = name;
/*     */   } public String getName() {
/* 225 */     return this.name;
/*     */   } public String getDescription() {
/* 227 */     return this.description;
/*     */   }
/*     */   public void setDescription(String description) {
/* 230 */     Global.getTour().setModified(true);
/* 231 */     this.description = description;
/*     */   }
/*     */   public Vector getVPhotos() {
/* 234 */     return this.vPhotos;
/*     */   }
/*     */   public void setVPhotos(Vector vPhotos) {
/* 237 */     Global.getTour().setModified(true);
/* 238 */     this.vPhotos = vPhotos;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\bean\PhotoPoint.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */