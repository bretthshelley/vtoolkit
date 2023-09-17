/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class ViewLink
/*     */   implements Serializable {
/*     */   static final long serialVersionUID = -5042520450760833364L;
/*     */   private int x;
/*     */   private int y;
/*     */   private String targetViewId;
/*     */   private Photo targetPhoto;
/*     */   private String displayString;
/*  23 */   private Rectangle rect = null;
/*     */ 
/*     */   
/*  26 */   private int fontSize = 12;
/*  27 */   public int getFontSize() { return this.fontSize; } public void setFontSize(int n) {
/*  28 */     this.fontSize = n;
/*     */   }
/*  30 */   private String style = "SansSerif";
/*  31 */   public String getStyle() { return this.style; } public void setStyle(String fontStyle) {
/*  32 */     this.style = fontStyle;
/*     */   }
/*     */   public boolean bold = false;
/*  35 */   public boolean isBold() { return this.bold; } public void setBold(boolean b) {
/*  36 */     this.bold = b;
/*     */   }
/*     */   public boolean italics = false;
/*  39 */   public boolean isItalics() { return this.italics; } public void setItalics(boolean b) {
/*  40 */     this.italics = b;
/*     */   }
/*  42 */   private int red = 0;
/*  43 */   private int green = 0;
/*  44 */   private int blue = 255;
/*     */   
/*     */   public void setTextColor(Color c) {
/*  47 */     if (c == null)
/*  48 */       return;  this.red = c.getRed(); this.green = c.getGreen(); this.blue = c.getBlue();
/*     */   } public Color getTextColor() {
/*  50 */     return new Color(this.red, this.green, this.blue);
/*     */   }
/*  52 */   private int activeRed = 255;
/*  53 */   private int activeGreen = 0;
/*  54 */   private int activeBlue = 255;
/*     */   
/*     */   public void setActiveTextColor(Color c) {
/*  57 */     if (c == null)
/*  58 */       return;  this.activeRed = c.getRed(); this.activeGreen = c.getGreen(); this.activeBlue = c.getBlue();
/*     */   } public Color getActiveTextColor() {
/*  60 */     return new Color(this.activeRed, this.activeGreen, this.activeBlue);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  64 */     String s = "ViewLink:";
/*  65 */     s = String.valueOf(s) + " x,y=" + this.x + "," + this.y;
/*  66 */     s = String.valueOf(s) + "; targetView=" + ((getTargetView() == null) ? "null" : getTargetView().getName());
/*  67 */     s = String.valueOf(s) + "; targetPhoto=" + this.targetPhoto;
/*  68 */     s = String.valueOf(s) + "; displayString= " + getDisplayString();
/*  69 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ViewLink() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(MouseEvent evt) {
/*  80 */     return contains(evt.getPoint());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/*     */     try {
/*  87 */       ViewLink v = (ViewLink)object;
/*     */       
/*  89 */       if (getX() != v.getX()) return false; 
/*  90 */       if (getY() != v.getY()) return false; 
/*  91 */       if (!getDisplayString().equals(v.getDisplayString())) return false; 
/*  92 */       return true;
/*     */     
/*     */     }
/*  95 */     catch (Exception e) {
/*     */       
/*  97 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Point pt) {
/* 104 */     if (pt == null) return false; 
/* 105 */     if (this.rect == null) return false; 
/* 106 */     return this.rect.contains(pt);
/*     */   }
/*     */ 
/*     */   
/*     */   public ViewLink(int x, int y, View targetView, Photo targetPhoto) {
/* 111 */     this.x = x;
/* 112 */     this.y = y;
/* 113 */     setTargetView(targetView);
/* 114 */     this.targetPhoto = targetPhoto;
/*     */   }
/*     */ 
/*     */   
/*     */   public ViewLink(int x, int y, View targetView, Photo targetPhoto, String displayString) {
/* 119 */     this.x = x;
/* 120 */     this.y = y;
/* 121 */     setTargetView(targetView);
/* 122 */     this.targetPhoto = targetPhoto;
/* 123 */     this.displayString = displayString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/* 130 */     Graphics2D g2d = (Graphics2D)g;
/*     */     
/* 132 */     int n = 0;
/* 133 */     if (this.bold) n = 1; 
/* 134 */     if (this.italics) n = 2; 
/* 135 */     if (this.bold && this.italics) n = 3; 
/* 136 */     Font font = new Font(this.style, n, this.fontSize);
/*     */     
/* 138 */     g.setFont(font);
/* 139 */     FontMetrics fontMetrics = g2d.getFontMetrics();
/* 140 */     int width = fontMetrics.stringWidth(getDisplayString());
/* 141 */     int height = fontMetrics.getHeight();
/*     */     
/* 143 */     int x0 = this.x - width / 2;
/* 144 */     int y0 = this.y;
/*     */     
/* 146 */     if (x0 < 0) x0 = 0; 
/* 147 */     if (y0 < 0) y0 = 0; 
/* 148 */     this.rect = new Rectangle(x0, y0 - (int)(0.6666666666666666D * height), width, (int)(0.75D * height));
/*     */     
/* 150 */     if (Global.getView() != null) {
/*     */ 
/*     */       
/* 153 */       int maxX = this.rect.x + this.rect.width;
/* 154 */       if (maxX > Global.getView().getPhotoWidth())
/*     */       {
/* 156 */         this.rect.x = Global.getView().getPhotoWidth() - this.rect.width;
/*     */       }
/* 158 */       int maxY = this.rect.y + this.rect.height;
/* 159 */       if (maxY > Global.getView().getPhotoHeight())
/*     */       {
/* 161 */         this.rect.y = Global.getView().getPhotoHeight() - this.rect.height;
/*     */       }
/*     */     } 
/* 164 */     g.drawString(getDisplayString(), this.rect.x, this.rect.y + this.rect.height);
/*     */   }
/*     */   
/*     */   public Photo getTargetPhoto() {
/* 168 */     return this.targetPhoto; } public void setTargetPhoto(Photo photo) {
/* 169 */     this.targetPhoto = photo;
/*     */   }
/* 171 */   public int getX() { return this.x; } public void setX(int i) {
/* 172 */     this.x = i;
/*     */   }
/* 174 */   public int getY() { return this.y; } public void setY(int i) {
/* 175 */     this.y = i;
/*     */   }
/*     */   
/*     */   public View getTargetView() {
/* 179 */     if (this.targetViewId == null || 
/* 180 */       Global.getTour() == null || 
/* 181 */       Global.getTour().getViews() == null || 
/* 182 */       Global.getTour().getViews().isEmpty()) return null;
/*     */ 
/*     */     
/* 185 */     for (int i = 0; i < Global.getTour().getViews().size(); i++) {
/*     */       
/* 187 */       View ithView = Global.getTour().getViews().elementAt(i);
/* 188 */       if (ithView != null && 
/* 189 */         ithView.getId().equalsIgnoreCase(this.targetViewId))
/*     */       {
/* 191 */         return ithView;
/*     */       }
/*     */     } 
/* 194 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTargetView(View view) {
/* 199 */     if (view != null) {
/*     */       
/* 201 */       this.targetViewId = view.getId();
/* 202 */       setDisplayString(view.getName());
/*     */     }
/*     */     else {
/*     */       
/* 206 */       this.targetViewId = null;
/* 207 */       setDisplayString("");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDisplayString() {
/* 213 */     if (this.displayString != null) return this.displayString;
/*     */ 
/*     */     
/* 216 */     View v = getTargetView();
/* 217 */     if (v != null) return v.getName(); 
/* 218 */     return "";
/*     */   }
/*     */   public void setDisplayString(String displayString) {
/* 221 */     this.displayString = displayString;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ViewLink.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */