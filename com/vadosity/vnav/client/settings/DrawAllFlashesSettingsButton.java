/*     */ package com.vadosity.vnav.client.settings;
/*     */ 
/*     */ import com.vadosity.vnav.client.DrawAllFlashesToggleButton;
/*     */ import com.vadosity.vnav.client.Settings;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Polygon;
/*     */ import java.awt.event.MouseEvent;
/*     */ 
/*     */ public class DrawAllFlashesSettingsButton extends DrawAllFlashesToggleButton {
/*     */   private boolean mouseIn = false;
/*     */   
/*     */   public DrawAllFlashesSettingsButton() {
/*     */     try {
/*  14 */       jbInit();
/*     */     }
/*  16 */     catch (Exception e) {
/*  17 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   private void jbInit() throws Exception {
/*  21 */     addMouseListener(new DrawAllFlashesSettingsButton_this_mouseAdapter(this));
/*     */   }
/*     */   
/*     */   void this_mouseEntered(MouseEvent e) {
/*  25 */     this.mouseIn = true;
/*  26 */     updateUI();
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  31 */     super.paint(g);
/*     */     
/*  33 */     int x0 = 4 * (getSize()).width / 5;
/*  34 */     int y0 = 4 * (getSize()).height / 5;
/*     */     
/*  36 */     int radiusW = 3 * (getSize()).width / 5;
/*  37 */     int radiusH = 3 * (getSize()).height / 5;
/*  38 */     int radius = (radiusW < radiusH) ? radiusW : radiusH;
/*     */     
/*  40 */     double x1 = x0 + radius * Math.cos(Math.PI);
/*  41 */     double y1 = y0;
/*     */     
/*  43 */     double x2 = x0 + radius * Math.cos(3.665191429188092D);
/*  44 */     double y2 = y0 + radius * Math.sin(3.665191429188092D);
/*     */     
/*  46 */     double x3 = x0 + radius * Math.cos(4.1887902047863905D);
/*  47 */     double y3 = y0 + radius * Math.sin(4.1887902047863905D);
/*     */     
/*  49 */     double x4 = x0 + radius * Math.cos(4.71238898038469D);
/*  50 */     double y4 = y0 + radius * Math.sin(4.71238898038469D);
/*     */     
/*  52 */     Polygon p1 = new Polygon();
/*  53 */     p1.addPoint(x0, y0);
/*  54 */     p1.addPoint((int)x1, (int)y1);
/*  55 */     p1.addPoint((int)x2, (int)y2);
/*     */     
/*  57 */     Polygon p2 = new Polygon();
/*  58 */     p2.addPoint(x0, y0);
/*  59 */     p2.addPoint((int)x3, (int)y3);
/*  60 */     p2.addPoint((int)x4, (int)y4);
/*  61 */     if (this.mouseIn) {
/*     */       
/*  63 */       if (Settings.getSelectedFlashFillColor() != null) {
/*     */         
/*  65 */         g.setColor(Settings.getSelectedFlashFillColor());
/*  66 */         g.fillPolygon(p1);
/*  67 */         g.fillPolygon(p2);
/*     */       } 
/*  69 */       if (Settings.getSelectedFlashOutlineColor() != null)
/*     */       {
/*  71 */         g.setColor(Settings.getSelectedFlashOutlineColor());
/*  72 */         g.drawPolygon(p1);
/*  73 */         g.drawPolygon(p2);
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  79 */       if (Settings.getFlashFillColor() != null) {
/*     */         
/*  81 */         g.setColor(Settings.getFlashFillColor());
/*  82 */         g.fillPolygon(p1);
/*  83 */         g.fillPolygon(p2);
/*     */       } 
/*  85 */       if (Settings.getFlashOutlineColor() != null) {
/*     */         
/*  87 */         g.setColor(Settings.getFlashOutlineColor());
/*  88 */         g.drawPolygon(p1);
/*  89 */         g.drawPolygon(p2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void this_mouseExited(MouseEvent e) {
/* 100 */     this.mouseIn = false;
/* 101 */     updateUI();
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\DrawAllFlashesSettingsButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */