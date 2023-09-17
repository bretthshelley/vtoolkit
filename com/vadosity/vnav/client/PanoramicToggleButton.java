/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JToggleButton;
/*     */ 
/*     */ public class PanoramicToggleButton
/*     */   extends JToggleButton
/*     */   implements SettingsChangeListener {
/*     */   boolean mouseIn;
/*     */   
/*     */   public void paint(Graphics g) {
/*  14 */     super.paint(g);
/*     */     
/*  16 */     int x = (getSize()).width / 2;
/*  17 */     int y = (getSize()).height / 2;
/*     */     
/*  19 */     int w = 5 * (getSize()).width / 10;
/*  20 */     int h = 5 * (getSize()).height / 10;
/*  21 */     int radius = (w < h) ? w : h;
/*     */     
/*  23 */     double x1 = (1 * getWidth() / 5);
/*  24 */     double y1 = (1 * getHeight() / 5);
/*     */ 
/*     */     
/*  27 */     if (Settings.getPhotoPointFillColor() != null) {
/*     */       
/*  29 */       g.setColor(this.mouseIn ? Settings.getSelectedPhotoPointFillColor() : Settings.getPhotoPointFillColor());
/*  30 */       g.fillOval(x - radius / 2, y - radius / 2, radius, radius);
/*     */     } 
/*  32 */     g.setColor(this.mouseIn ? Settings.getSelectedPhotoPointOutlineColor() : Settings.getPhotoPointOutlineColor());
/*  33 */     g.drawOval(x - radius / 2, y - radius / 2, radius, radius);
/*     */ 
/*     */     
/*  36 */     int arcDegrees = 135;
/*  37 */     int startDegrees = 90;
/*  38 */     double startAngle = Math.toRadians(startDegrees);
/*     */     
/*  40 */     Color fillColor = null;
/*  41 */     Color outlineColor = null;
/*  42 */     if (this.mouseIn) {
/*     */       
/*  44 */       fillColor = Settings.getSelectedFlashFillColor();
/*  45 */       outlineColor = Settings.getSelectedFlashOutlineColor();
/*     */     }
/*     */     else {
/*     */       
/*  49 */       fillColor = Settings.getFlashFillColor();
/*  50 */       outlineColor = Settings.getFlashOutlineColor();
/*     */     } 
/*  52 */     g.setColor(fillColor);
/*  53 */     if (fillColor != null)
/*     */     {
/*  55 */       g.fillArc(x - 3 * radius / 4, y - 3 * radius / 4, 3 * radius / 2, 3 * radius / 2, startDegrees, arcDegrees);
/*     */     }
/*  57 */     g.setColor(outlineColor);
/*  58 */     g.drawArc(x - 3 * radius / 4, y - 3 * radius / 4, 3 * radius / 2, 3 * radius / 2, startDegrees, arcDegrees);
/*     */ 
/*     */ 
/*     */     
/*  62 */     double c1 = Math.cos(startAngle);
/*  63 */     double s1 = Math.sin(startAngle);
/*  64 */     int x2 = x + (int)Math.round((3 * radius / 4) * c1);
/*  65 */     int y2 = y - (int)Math.round((3 * radius / 4) * s1);
/*  66 */     g.drawLine(x, y, x2, y2);
/*     */ 
/*     */     
/*  69 */     double c2 = Math.cos(Math.toRadians(225.0D));
/*  70 */     double s2 = Math.sin(Math.toRadians(225.0D));
/*  71 */     int x3 = x + (int)Math.round((3 * radius / 4) * c2);
/*  72 */     int y3 = y - (int)Math.round((3 * radius / 4) * s2);
/*  73 */     g.drawLine(x, y, x3, y3);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PanoramicToggleButton() {
/*  97 */     this.mouseIn = false; try { jbInit(); Global.addSettingsChangeListener(this); } catch (Exception e) { e.printStackTrace(); }
/*     */   
/*  99 */   } public void settingsChanged(Object src) { updateUI(); } void this_mouseEntered(MouseEvent e) { this.mouseIn = true;
/* 100 */     updateUI(); }
/*     */    private void jbInit() throws Exception {
/*     */     addMouseListener(new PanoramicToggleButton_this_mouseAdapter(this));
/*     */   } void this_mouseExited(MouseEvent e) {
/* 104 */     this.mouseIn = false;
/* 105 */     updateUI();
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\PanoramicToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */