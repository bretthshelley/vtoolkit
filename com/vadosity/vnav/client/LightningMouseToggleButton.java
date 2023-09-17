/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.JToggleButton;
/*     */ 
/*     */ public class LightningMouseToggleButton
/*     */   extends JToggleButton
/*     */   implements SettingsChangeListener
/*     */ {
/*     */   public void settingsChanged(Object src) {
/*  13 */     setSelected(Settings.isSelectOnMouseOver());
/*  14 */     updateUI();
/*     */   }
/*     */ 
/*     */   
/*     */   void this_actionPerformed(ActionEvent e) {
/*  19 */     Settings.setSelectOnMouseOver(isSelected());
/*  20 */     Global.fireSettingsChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  25 */     super.paint(g);
/*     */     
/*  27 */     int w = (getSize()).width;
/*  28 */     int h = (getSize()).height;
/*     */     
/*  30 */     int ax = 50 * w / 100;
/*  31 */     int ay = 10 * h / 100;
/*     */     
/*  33 */     int bx = 20 * w / 100;
/*  34 */     int by = 35 * h / 100;
/*     */     
/*  36 */     int cx = 40 * w / 100;
/*  37 */     int cy = 30 * h / 100;
/*     */     
/*  39 */     int dx = 40 * w / 100;
/*  40 */     int dy = 50 * h / 100;
/*     */     
/*  42 */     int ex = 70 * w / 100;
/*  43 */     int ey = 20 * h / 100;
/*     */     
/*  45 */     int fx = 55 * w / 100;
/*  46 */     int fy = 20 * h / 100;
/*     */     
/*  48 */     int[] x = { ax, bx, cx, dx, ex, fx };
/*  49 */     int[] y = { ay, by, cy, dy, ey, fy };
/*     */     
/*  51 */     g.setColor(Color.yellow);
/*  52 */     g.fillPolygon(x, y, 6);
/*  53 */     g.setColor(Color.black);
/*  54 */     g.drawPolygon(x, y, 6);
/*     */ 
/*     */     
/*  57 */     int radiusW = 15 * (getSize()).width / 100;
/*  58 */     int radiusH = 15 * (getSize()).height / 100;
/*  59 */     int radius = (radiusW < radiusH) ? radiusW : radiusH;
/*  60 */     int innerRadius = 2 * radius / 3;
/*  61 */     int circx = 30 * w / 100;
/*  62 */     int circy = 70 * h / 100;
/*  63 */     int leftx = circx - radius;
/*  64 */     int topy = circy - radius;
/*  65 */     int innerLeftx = circx - innerRadius;
/*  66 */     int innerTopy = circy - innerRadius;
/*     */     
/*  68 */     double angle = Math.toRadians(15.0D);
/*  69 */     int length = 30 * w / 100;
/*  70 */     int tail = 60 * w / 100;
/*     */     
/*  72 */     int x1 = (int)Math.round(circx - radius * Math.sin(angle));
/*  73 */     int y1 = (int)Math.round(circy - radius * Math.cos(angle));
/*     */     
/*  75 */     int x2 = (int)Math.round(circx + radius * Math.sin(angle));
/*  76 */     int y2 = (int)Math.round(circy + radius * Math.cos(angle));
/*     */     
/*  78 */     int x3 = (int)Math.round(x1 + length * Math.cos(angle));
/*  79 */     int y3 = (int)Math.round(y1 - length * Math.sin(angle));
/*     */     
/*  81 */     int x4 = (int)Math.round(x2 + length * Math.cos(angle));
/*  82 */     int y4 = (int)Math.round(y2 - length * Math.sin(angle));
/*     */     
/*  84 */     int tailx = (int)Math.round(circx + tail * Math.cos(angle));
/*  85 */     int taily = (int)Math.round(circy - tail * Math.sin(angle));
/*     */     
/*  87 */     int[] boxx = {
/*     */         
/*  89 */         x1, x2, x4, x3 };
/*  90 */     int[] boxy = {
/*     */         
/*  92 */         y1, y2, y4, y3
/*     */       };
/*  94 */     g.setColor(Color.black);
/*  95 */     g.drawLine(circx, circy, tailx, taily);
/*     */     
/*  97 */     g.setColor(Color.green);
/*  98 */     g.fillOval(leftx, topy, radius * 2, radius * 2);
/*  99 */     g.setColor(Color.black);
/* 100 */     g.drawOval(leftx, topy, radius * 2, radius * 2);
/* 101 */     g.drawOval(leftx, topy, radius * 2, radius * 2);
/* 102 */     g.drawOval(innerLeftx, innerTopy, innerRadius * 2, innerRadius * 2);
/*     */     
/* 104 */     g.setColor(Color.green);
/* 105 */     g.fillPolygon(boxx, boxy, 4);
/* 106 */     g.setColor(Color.black);
/* 107 */     g.drawLine(x1, y1, x3, y3);
/* 108 */     g.drawLine(x4, y4, x3, y3);
/* 109 */     g.drawLine(x2, y2, x4, y4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LightningMouseToggleButton() {
/*     */     try {
/* 117 */       jbInit();
/* 118 */       Global.addSettingsChangeListener(this);
/*     */     }
/* 120 */     catch (Exception e) {
/*     */       
/* 122 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jbInit() throws Exception {
/* 128 */     addActionListener(new LightningMouseToggleButton_this_actionAdapter(this));
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\LightningMouseToggleButton.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */