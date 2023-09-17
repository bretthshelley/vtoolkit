/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.Properties;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class Preferences
/*     */ {
/*     */   private static final String PREFERENCES_FILE_NAME = "vadosity.properties";
/*  14 */   private static Preferences instance = null;
/*  15 */   private Properties properties = new Properties();
/*     */ 
/*     */ 
/*     */   
/*     */   private Preferences() {
/*  20 */     load();
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized Preferences userRoot() {
/*  25 */     if (instance == null) instance = new Preferences(); 
/*  26 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void sync() {
/*     */     try {
/*  35 */       FileOutputStream fos = new FileOutputStream(getPreferencesFileName());
/*  36 */       this.properties.store(fos, "Vadosity Application Preferences - Do not edit");
/*  37 */       fos.flush();
/*  38 */       fos.close();
/*     */     }
/*  40 */     catch (Exception e) {
/*     */ 
/*     */       
/*  43 */       this.properties = new Properties();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized String get(String key, String defaultValue) {
/*  51 */     return this.properties.getProperty(key, defaultValue);
/*     */   }
/*     */   
/*     */   public synchronized int getInt(String key, int defaultValue) {
/*  55 */     String value = this.properties.getProperty(key, defaultValue);
/*  56 */     return Integer.parseInt(value);
/*     */   }
/*     */   
/*     */   public synchronized double getDouble(String key, double defaultValue) {
/*  60 */     String value = this.properties.getProperty(key, defaultValue);
/*  61 */     return Double.parseDouble(value);
/*     */   }
/*     */   
/*     */   public synchronized void put(String key, String value) {
/*  65 */     this.properties.put(key, value);
/*     */   }
/*     */   
/*     */   public synchronized void putInt(String key, int value) {
/*  69 */     this.properties.put(key, value);
/*     */   }
/*     */   
/*     */   public synchronized void putDouble(String key, double value) {
/*  73 */     this.properties.put(key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void load() {
/*     */     try {
/*  81 */       FileInputStream fis = new FileInputStream(getPreferencesFileName());
/*  82 */       this.properties.load(fis);
/*  83 */       fis.close();
/*     */     }
/*  85 */     catch (Exception e) {
/*     */ 
/*     */       
/*  88 */       this.properties = new Properties();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String getPreferencesFileName() {
/*  94 */     return "vadosity.properties";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void clear() {
/* 102 */     this.properties.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveWindowLocation(JFrame f) {
/* 112 */     if (f == null) {
/*     */       return;
/*     */     }
/*     */     try {
/* 116 */       userRoot().putInt(String.valueOf(f.getClass().getName()) + ".x", (f.getLocation()).x);
/* 117 */       userRoot().putInt(String.valueOf(f.getClass().getName()) + ".y", (f.getLocation()).y);
/* 118 */       userRoot().putInt(String.valueOf(f.getClass().getName()) + ".w", (f.getSize()).width);
/* 119 */       userRoot().putInt(String.valueOf(f.getClass().getName()) + ".h", (f.getSize()).height);
/* 120 */       userRoot().sync();
/*     */     }
/* 122 */     catch (Exception e) {
/*     */       
/* 124 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void placeWindow(JFrame f) {
/* 131 */     if (f == null) {
/*     */       return;
/*     */     }
/*     */     try {
/* 135 */       int unitializedValue = -1000000;
/* 136 */       int x = userRoot().getInt(String.valueOf(f.getClass().getName()) + ".x", unitializedValue);
/* 137 */       if (x == unitializedValue) {
/*     */ 
/*     */         
/* 140 */         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
/* 141 */         f.setSize(dim);
/* 142 */         f.setLocation(0, 0);
/*     */         return;
/*     */       } 
/* 145 */       int y = userRoot().getInt(String.valueOf(f.getClass().getName()) + ".y", 0);
/* 146 */       int w = userRoot().getInt(String.valueOf(f.getClass().getName()) + ".w", 800);
/* 147 */       int h = userRoot().getInt(String.valueOf(f.getClass().getName()) + ".h", 600);
/* 148 */       Rectangle lastBounds = new Rectangle(x, y, w, h);
/*     */ 
/*     */       
/* 151 */       f.setBounds(lastBounds);
/* 152 */       f.setSize(w, h);
/*     */     }
/* 154 */     catch (Exception e) {
/*     */       
/* 156 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\Preferences.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */