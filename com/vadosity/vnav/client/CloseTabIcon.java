/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Rectangle;
/*     */ import javax.swing.Icon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CloseTabIcon
/*     */   implements Icon
/*     */ {
/*     */   private int x_pos;
/*     */   private int y_pos;
/*     */   private int width;
/*     */   private int height;
/*     */   private Icon fileIcon;
/*     */   
/*     */   public CloseTabIcon(Icon fileIcon) {
/* 242 */     this.fileIcon = fileIcon;
/* 243 */     this.width = 16;
/* 244 */     this.height = 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public void paintIcon(Component c, Graphics g, int x, int y) {
/* 249 */     if (Settings.getMode() == 1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 254 */     this.x_pos = x;
/* 255 */     this.y_pos = y;
/*     */ 
/*     */     
/* 258 */     Color col = g.getColor();
/*     */     
/* 260 */     g.setColor(Color.black);
/* 261 */     int y_p = y + 2;
/* 262 */     g.drawLine(x + 1, y_p, x + 12, y_p);
/* 263 */     g.drawLine(x + 1, y_p + 13, x + 12, y_p + 13);
/* 264 */     g.drawLine(x, y_p + 1, x, y_p + 12);
/* 265 */     g.drawLine(x + 13, y_p + 1, x + 13, y_p + 12);
/* 266 */     g.drawLine(x + 3, y_p + 3, x + 10, y_p + 10);
/* 267 */     g.drawLine(x + 3, y_p + 4, x + 9, y_p + 10);
/* 268 */     g.drawLine(x + 4, y_p + 3, x + 10, y_p + 9);
/* 269 */     g.drawLine(x + 10, y_p + 3, x + 3, y_p + 10);
/* 270 */     g.drawLine(x + 10, y_p + 4, x + 4, y_p + 10);
/* 271 */     g.drawLine(x + 9, y_p + 3, x + 3, y_p + 9);
/* 272 */     g.setColor(col);
/* 273 */     if (this.fileIcon != null) {
/* 274 */       this.fileIcon.paintIcon(c, g, x + this.width, y_p);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getIconWidth() {
/* 279 */     return this.width + ((this.fileIcon != null) ? this.fileIcon.getIconWidth() : 0);
/*     */   }
/*     */   
/*     */   public int getIconHeight() {
/* 283 */     return this.height;
/*     */   }
/*     */   
/*     */   public Rectangle getBounds() {
/* 287 */     return new Rectangle(this.x_pos, this.y_pos, this.width, this.height);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\CloseTabIcon.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */