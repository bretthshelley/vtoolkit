/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.ice.jni.registry.NoSuchKeyException;
/*     */ import com.ice.jni.registry.RegStringValue;
/*     */ import com.ice.jni.registry.Registry;
/*     */ import com.ice.jni.registry.RegistryException;
/*     */ import com.ice.jni.registry.RegistryKey;
/*     */ import com.ice.jni.registry.RegistryValue;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class RegistryInterface
/*     */ {
/*     */   public static String getProjectsDirectory() {
/*     */     try {
/*  18 */       File projectsDir = new File("projects_directory.data");
/*  19 */       if (!projectsDir.exists()) return "Vadosity Projects";
/*     */       
/*  21 */       FileInputStream fis = new FileInputStream(projectsDir);
/*  22 */       byte[] bytes = new byte[fis.available()];
/*  23 */       fis.read(bytes);
/*  24 */       fis.close();
/*  25 */       String data = new String(bytes);
/*  26 */       return data;
/*     */     }
/*  28 */     catch (Throwable t) {
/*     */       
/*  30 */       t.printStackTrace();
/*  31 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void setProjectsDirectory(String directory) {
/*  37 */     RegistryKey key = null;
/*  38 */     RegStringValue value = null;
/*     */ 
/*     */     
/*     */     try {
/*  42 */       File projectsDir = new File("projects_directory.data");
/*  43 */       FileOutputStream fos = new FileOutputStream(projectsDir);
/*  44 */       fos.write(directory.getBytes());
/*  45 */       fos.flush();
/*  46 */       fos.close();
/*     */     }
/*  48 */     catch (Exception ex) {
/*     */       
/*  50 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getCurrentProjectDirectory() {
/*     */     try {
/*  58 */       File dir = new File("project_dir.data");
/*  59 */       if (!dir.exists()) {
/*     */         
/*  61 */         File orig = new File("Vadosity Projects" + File.separator + "Default Project");
/*  62 */         return orig;
/*     */       } 
/*     */       
/*  65 */       FileInputStream fis = new FileInputStream(dir);
/*  66 */       byte[] bytes = new byte[fis.available()];
/*  67 */       fis.read(bytes);
/*  68 */       String data = new String(bytes);
/*  69 */       return new File(data);
/*     */     }
/*  71 */     catch (Throwable t) {
/*     */       
/*  73 */       t.printStackTrace();
/*  74 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCurrentProjectDirectory(String directory) {
/*     */     try {
/*  83 */       File dir = new File("project_dir.data");
/*  84 */       FileOutputStream fos = new FileOutputStream(dir);
/*  85 */       fos.write(directory.getBytes());
/*  86 */       fos.flush();
/*  87 */       fos.close();
/*     */     }
/*  89 */     catch (Exception ex) {
/*     */       
/*  91 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLastTourFile() {
/*  99 */     String[] sa = getRecentFiles();
/* 100 */     if (sa == null || sa.length == 0) return null;
/*     */     
/* 102 */     if (sa[0].indexOf("=") == -1)
/*     */     {
/* 104 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 108 */     return sa[0].substring(0, sa[0].indexOf("="));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] getRecentFiles() {
/*     */     try {
/* 117 */       RegistryKey recentFilesKey = null;
/* 118 */       recentFilesKey = Registry.HKEY_CLASSES_ROOT.openSubKey("VADOSITY_RECENT_FILES");
/* 119 */       RegStringValue recentFilesValue = (RegStringValue)recentFilesKey.getValue("");
/* 120 */       String recentFilesData = recentFilesValue.getData();
/*     */ 
/*     */ 
/*     */       
/* 124 */       String[] sa = recentFilesData.split(";");
/* 125 */       return sa;
/*     */     }
/* 127 */     catch (Throwable t) {
/*     */       
/* 129 */       t.printStackTrace();
/* 130 */       return new String[0];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setRecentFiles(String data) {
/* 156 */     RegistryKey subKey = null;
/* 157 */     RegStringValue value = null;
/*     */ 
/*     */     
/*     */     try {
/* 161 */       subKey = openSubKeyVerbose(Registry.HKEY_CLASSES_ROOT.openSubKey("VADOSITY_RECENT_FILES"), "", 4);
/* 162 */       value = (RegStringValue)subKey.getValue("");
/* 163 */       value.setData(data);
/* 164 */       subKey.setValue((RegistryValue)value);
/* 165 */       subKey.flushKey();
/*     */     }
/* 167 */     catch (RegistryException ex) {
/*     */       
/* 169 */       ex.printStackTrace();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getMostRecentProject() {
/* 189 */     return getMostRecentProjects()[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] getMostRecentProjects() {
/*     */     try {
/* 196 */       RegistryKey vadosityKey = null;
/* 197 */       RegistryKey recentProjectsKey = null;
/* 198 */       vadosityKey = Registry.HKEY_CLASSES_ROOT.openSubKey("Vadosity");
/* 199 */       recentProjectsKey = vadosityKey.openSubKey("Recent Projects");
/* 200 */       RegStringValue recentProjectsValue = (RegStringValue)recentProjectsKey.getValue("");
/* 201 */       String recentProjectsData = recentProjectsValue.getData();
/*     */ 
/*     */ 
/*     */       
/* 205 */       String[] sa = recentProjectsData.split(";");
/* 206 */       return sa;
/*     */     }
/* 208 */     catch (Throwable t) {
/*     */       
/* 210 */       t.printStackTrace();
/* 211 */       return new String[0];
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
/*     */ 
/*     */   
/*     */   public static Locale getLocaleFromWindowsRegistry() {
/*     */     try {
/* 228 */       RegistryKey languageKey = null;
/* 229 */       RegStringValue languageValue = null;
/* 230 */       languageKey = Registry.HKEY_CLASSES_ROOT.openSubKey("VadosityLanguage");
/* 231 */       languageValue = (RegStringValue)languageKey.getValue("");
/* 232 */       String value = languageValue.getData();
/* 233 */       Locale registryLocale = new Locale(value);
/* 234 */       return registryLocale;
/*     */     }
/* 236 */     catch (Throwable t) {
/*     */ 
/*     */       
/* 239 */       t.printStackTrace();
/* 240 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLicenseKeyFromWindowsRegistry() {
/*     */     try {
/* 249 */       RegistryKey key = null;
/* 250 */       RegStringValue value = null;
/* 251 */       key = Registry.HKEY_CLASSES_ROOT.openSubKey("VADOSITY_LICENSE");
/* 252 */       value = (RegStringValue)key.getValue("");
/* 253 */       String data = value.getData();
/* 254 */       return data;
/*     */     }
/* 256 */     catch (Throwable t) {
/*     */       
/* 258 */       t.printStackTrace();
/* 259 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getEvalTimeFromWindowsRegistry() {
/*     */     try {
/* 267 */       RegistryKey key = null;
/* 268 */       RegStringValue value = null;
/* 269 */       key = Registry.HKEY_CLASSES_ROOT.openSubKey("VADOSITY_EVAL_TIME");
/* 270 */       value = (RegStringValue)key.getValue("");
/* 271 */       String data = value.getData();
/* 272 */       return Long.parseLong(data);
/*     */     }
/* 274 */     catch (Throwable t) {
/*     */       
/* 276 */       t.printStackTrace();
/* 277 */       return -1L;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDemoDirectoryFromWindowsRegistry() {
/*     */     try {
/* 287 */       RegistryKey demoDirectoryKey = null;
/* 288 */       RegStringValue demoDirectoryValue = null;
/* 289 */       demoDirectoryKey = Registry.HKEY_CLASSES_ROOT.openSubKey("VadosityDemoDirectory");
/* 290 */       demoDirectoryValue = (RegStringValue)demoDirectoryKey.getValue("");
/* 291 */       String value = demoDirectoryValue.getData();
/* 292 */       return value;
/*     */     }
/* 294 */     catch (Exception e) {
/*     */       
/* 296 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setLocaleInWindowsRegistry(Locale locale) {
/* 303 */     RegistryKey subKey = null;
/* 304 */     RegStringValue value = null;
/*     */ 
/*     */     
/*     */     try {
/* 308 */       subKey = openSubKeyVerbose(Registry.HKEY_CLASSES_ROOT.openSubKey("VadosityLanguage"), "", 4);
/* 309 */       value = (RegStringValue)subKey.getValue("");
/* 310 */       value.setData(locale.toString());
/* 311 */       subKey.setValue((RegistryValue)value);
/* 312 */       subKey.flushKey();
/*     */     }
/* 314 */     catch (RegistryException ex) {
/*     */       
/* 316 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setLicenseKeyInWindowsRegistry(String key) {
/* 326 */     RegistryKey subKey = null;
/* 327 */     RegStringValue value = null;
/*     */ 
/*     */     
/*     */     try {
/* 331 */       subKey = openSubKeyVerbose(Registry.HKEY_CLASSES_ROOT.openSubKey("VADOSITY_LICENSE"), "", 4);
/* 332 */       value = (RegStringValue)subKey.getValue("");
/* 333 */       value.setData(key);
/* 334 */       subKey.setValue((RegistryValue)value);
/* 335 */       subKey.flushKey();
/*     */     }
/* 337 */     catch (RegistryException ex) {
/*     */       
/* 339 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setEvalTimeInWindowsRegistry(long time) {
/* 345 */     RegistryKey subKey = null;
/* 346 */     RegStringValue value = null;
/*     */ 
/*     */     
/*     */     try {
/* 350 */       long l = time;
/* 351 */       subKey = openSubKeyVerbose(Registry.HKEY_CLASSES_ROOT.openSubKey("VADOSITY_EVAL_TIME"), "", 4);
/* 352 */       value = (RegStringValue)subKey.getValue("");
/* 353 */       value.setData(l);
/* 354 */       subKey.setValue((RegistryValue)value);
/* 355 */       subKey.flushKey();
/*     */     }
/* 357 */     catch (RegistryException ex) {
/*     */       
/* 359 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static RegistryKey openSubKeyVerbose(RegistryKey topKey, String keyName, int access) {
/* 366 */     RegistryKey subKey = null;
/*     */     
/*     */     try {
/* 369 */       subKey = topKey.openSubKey(keyName, access);
/*     */     }
/* 371 */     catch (NoSuchKeyException ex) {
/*     */       
/* 373 */       subKey = null;
/*     */     }
/* 375 */     catch (RegistryException ex) {
/*     */       
/* 377 */       subKey = null;
/*     */     } 
/* 379 */     return subKey;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\RegistryInterface.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */