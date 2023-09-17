/*     */ package com.vadosity.vnav.client;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class RecentFilesMap implements Serializable {
/*  12 */   protected int maxSize = 10; static final long serialVersionUID = 8843716952717816067L;
/*  13 */   protected Vector vKeys = new Vector();
/*  14 */   protected Vector vValues = new Vector();
/*     */   
/*  16 */   private static RecentFilesMap instance = null;
/*     */   
/*     */   public static RecentFilesMap getInstance() {
/*  19 */     if (instance == null) loadInstance(); 
/*  20 */     return instance;
/*     */   }
/*     */   
/*  23 */   private transient RecentFilesMenu recentFilesMenu = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void loadInstance() {
/*     */     try {
/*  30 */       instance = new RecentFilesMap();
/*  31 */       String[] sa = RegistryInterface.getRecentFiles();
/*  32 */       if (sa == null || sa.length == 0)
/*     */         return; 
/*  34 */       for (int i = 0; i < sa.length; i++)
/*     */       {
/*  36 */         String[] keyValue = sa[i].split("=");
/*  37 */         String key = keyValue[0];
/*  38 */         String value = keyValue[1];
/*  39 */         instance.vKeys.add(key);
/*  40 */         instance.vValues.add(value);
/*     */       }
/*     */     
/*  43 */     } catch (Throwable t) {
/*     */       
/*  45 */       t.printStackTrace();
/*  46 */       deleteInstance();
/*  47 */       instance = new RecentFilesMap();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deleteInstance() {
/*     */     try {
/*  55 */       File f = new File("RecentFilesMap.data");
/*  56 */       f.delete();
/*     */     }
/*  58 */     catch (Exception e) {
/*     */       
/*  60 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveInstance() {
/*     */     try {
/*  69 */       StringBuffer data = new StringBuffer();
/*     */       
/*  71 */       for (int i = 0; i < instance.vKeys.size(); i++)
/*     */       {
/*  73 */         data.append((new StringBuffer()).append(instance.vKeys.elementAt(i)).append("=").append(instance.vValues.elementAt(i)).append(";").toString());
/*     */       }
/*  75 */       RegistryInterface.setRecentFiles(data.toString());
/*     */     }
/*  77 */     catch (Exception e) {
/*     */       
/*  79 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecentFilesMap() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RecentFilesMap(int maxSize) {
/*  91 */     this.maxSize = maxSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Object getFirstValue() {
/*  96 */     if (this.vValues.size() == 0) return null; 
/*  97 */     return this.vValues.elementAt(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Object getFirstKey() {
/* 102 */     if (this.vKeys.size() == 0) return null; 
/* 103 */     return this.vKeys.elementAt(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void clear() {
/* 109 */     this.vKeys = new Vector();
/* 110 */     this.vValues = new Vector();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean containsKey(Object object) {
/* 120 */     if (object == null) return false; 
/* 121 */     return this.vKeys.contains(object);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean containsValue(Object object) {
/* 126 */     if (object == null) return false; 
/* 127 */     return this.vValues.contains(object);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set entrySet() {
/* 132 */     throw new UnsupportedOperationException("entrySet method not supported by " + getClass().getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Object get(Object object) {
/* 137 */     if (object == null) return null;
/*     */     
/* 139 */     if (!this.vKeys.contains(object))
/*     */     {
/* 141 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 145 */     return this.vValues.elementAt(this.vKeys.indexOf(object));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Object getKey(int index) {
/* 151 */     int lastIndex = size() - 1;
/* 152 */     if (index > lastIndex) return null; 
/* 153 */     return this.vKeys.elementAt(index);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Object getValue(int index) {
/* 158 */     int lastIndex = size() - 1;
/* 159 */     if (index > lastIndex) return null; 
/* 160 */     return this.vValues.elementAt(index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean isEmpty() {
/* 167 */     return this.vKeys.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Set keySet() {
/* 172 */     HashSet set = new HashSet();
/* 173 */     set.addAll(this.vKeys);
/* 174 */     return set;
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
/*     */   public synchronized Object put(Object key, Object value) {
/* 189 */     if (key == null) throw new IllegalArgumentException("key value may not be null ");
/*     */     
/* 191 */     Object previousValue = null;
/* 192 */     int previousIndex = -1;
/* 193 */     if (containsKey(key)) {
/*     */       
/* 195 */       previousValue = get(key);
/* 196 */       previousIndex = this.vKeys.indexOf(key);
/* 197 */       this.vKeys.remove(previousIndex);
/* 198 */       this.vValues.remove(previousIndex);
/*     */     } 
/* 200 */     this.vKeys.add(0, key);
/* 201 */     this.vValues.add(0, value);
/* 202 */     if (this.maxSize > -1 && this.vKeys.size() > this.maxSize) {
/*     */       
/* 204 */       this.vKeys.setSize(this.maxSize);
/* 205 */       this.vValues.setSize(this.maxSize);
/*     */     } 
/* 207 */     if (this.recentFilesMenu != null) this.recentFilesMenu.updateMenuItems(); 
/* 208 */     return previousValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void putAll(Map map) {
/* 213 */     if (map == null || map.isEmpty())
/*     */       return; 
/* 215 */     Set set = map.keySet();
/* 216 */     Iterator iterator = set.iterator();
/*     */     
/* 218 */     while (iterator.hasNext()) {
/*     */       
/* 220 */       Object key = iterator.next();
/* 221 */       put(key, map.get(key));
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
/*     */   public synchronized Object remove(Object key) {
/* 235 */     if (!containsKey(key)) return null;
/*     */     
/* 237 */     int index = this.vKeys.indexOf(key);
/* 238 */     Object previousValue = this.vValues.elementAt(index);
/* 239 */     this.vKeys.remove(index);
/* 240 */     this.vValues.remove(index);
/*     */     
/* 242 */     if (this.recentFilesMenu != null) this.recentFilesMenu.updateMenuItems();
/*     */     
/* 244 */     return previousValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 249 */     return this.vKeys.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Collection keys() {
/* 254 */     return this.vKeys;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Collection values() {
/* 259 */     return this.vValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxSize() {
/* 268 */     if (this.maxSize < 0) return -1; 
/* 269 */     return this.maxSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setMaxSize(int max) {
/* 279 */     if (max < 0) {
/*     */       
/* 281 */       this.maxSize = -1;
/*     */       return;
/*     */     } 
/* 284 */     this.maxSize = max;
/* 285 */     if (this.vKeys.size() > max) {
/*     */       
/* 287 */       this.vKeys.setSize(this.maxSize);
/* 288 */       this.vValues.setSize(this.maxSize);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 294 */     StringBuffer buf = new StringBuffer();
/* 295 */     buf.append(String.valueOf(getClass().getName()) + "maxSize: " + this.maxSize + "\n");
/* 296 */     for (int i = 0; i < this.vKeys.size(); i++)
/*     */     {
/* 298 */       buf.append("[" + this.vKeys.elementAt(i) + "] = [" + this.vValues.elementAt(i) + "]\n");
/*     */     }
/* 300 */     return buf.toString();
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
/*     */   public RecentFilesMenu getRecentFilesMenu() {
/* 313 */     return this.recentFilesMenu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecentFilesMenu(RecentFilesMenu menu) {
/* 321 */     this.recentFilesMenu = menu;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\RecentFilesMap.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */