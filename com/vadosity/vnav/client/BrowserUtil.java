/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ public class BrowserUtil
/*     */ {
/*     */   public static final int WINDOWS_OS = 1;
/*     */   public static final int UNIX_OS = 2;
/*     */   public static final int MACINTOSH_OS = 3;
/*     */   private static final String WIN_ID = "Windows";
/*     */   
/*     */   public static int getOperatingSystem() {
/*  15 */     String os = System.getProperty("os.name");
/*  16 */     if (os != null && os.startsWith("Windows")) return 1; 
/*  17 */     return 2;
/*     */   }
/*     */   private static final String WIN_PATH = "rundll32"; private static final String WIN_FLAG = "url.dll,FileProtocolHandler"; private static final String UNIX_PATH = "netscape"; private static final String UNIX_FLAG = "-remote openURL";
/*     */   
/*     */   public static String[] getCommands() {
/*  22 */     String[] exec = (String[])null;
/*  23 */     if (System.getProperty("os.name").startsWith("Windows")) {
/*     */       
/*  25 */       exec = 
/*  26 */         new String[] {
/*  27 */           "rundll32 url.dll,FileProtocolHandler {0}"
/*     */         };
/*     */     }
/*  30 */     else if (System.getProperty("os.name").startsWith("Mac")) {
/*     */       
/*  32 */       Vector browsers = new Vector();
/*     */       
/*     */       try {
/*  35 */         Process p = Runtime.getRuntime().exec("which open");
/*  36 */         if (p.waitFor() == 0)
/*     */         {
/*  38 */           browsers.add("open {0}");
/*     */         }
/*     */       }
/*  41 */       catch (Exception exception) {}
/*  42 */       if (browsers.size() == 0)
/*     */       {
/*  44 */         exec = (String[])null;
/*     */       }
/*     */       else
/*     */       {
/*  48 */         exec = browsers.<String>toArray(new String[0]);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  53 */       Vector browsers = new Vector();
/*     */       
/*     */       try {
/*  56 */         Process p = Runtime.getRuntime().exec("which firebird");
/*  57 */         if (p.waitFor() == 0)
/*     */         {
/*  59 */           browsers.add("firebird -remote openURL({0})");
/*  60 */           browsers.add("firebird {0}");
/*     */         }
/*     */       
/*  63 */       } catch (Exception exception) {}
/*     */ 
/*     */       
/*     */       try {
/*  67 */         Process p = Runtime.getRuntime().exec("which mozilla");
/*  68 */         if (p.waitFor() == 0)
/*     */         {
/*  70 */           browsers.add("mozilla -remote openURL({0})");
/*  71 */           browsers.add("mozilla {0}");
/*     */         }
/*     */       
/*  74 */       } catch (Exception exception) {}
/*     */ 
/*     */       
/*     */       try {
/*  78 */         Process p = Runtime.getRuntime().exec("which opera");
/*  79 */         if (p.waitFor() == 0) {
/*  80 */           browsers.add("opera -remote openURL({0})");
/*  81 */           browsers.add("opera {0}");
/*     */         }
/*     */       
/*  84 */       } catch (Exception exception) {}
/*     */       
/*     */       try {
/*  87 */         Process p = Runtime.getRuntime().exec("which galeon");
/*  88 */         if (p.waitFor() == 0)
/*     */         {
/*  90 */           browsers.add("galeon {0}");
/*     */         }
/*     */       }
/*  93 */       catch (Exception exception) {}
/*     */       
/*     */       try {
/*  96 */         Process p = Runtime.getRuntime().exec("which konqueror");
/*  97 */         if (p.waitFor() == 0)
/*     */         {
/*  99 */           browsers.add("konqueror {0}");
/*     */         }
/*     */       }
/* 102 */       catch (IOException iOException) {
/*     */ 
/*     */       
/* 105 */       } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 110 */         Process p = Runtime.getRuntime().exec("which netscape");
/* 111 */         if (p.waitFor() == 0)
/*     */         {
/* 113 */           browsers.add("netscape -remote openURL({0})");
/* 114 */           browsers.add("netscape {0}");
/*     */         }
/*     */       
/* 117 */       } catch (Exception exception) {}
/*     */       
/*     */       try {
/* 120 */         Process p = Runtime.getRuntime().exec("which xterm");
/* 121 */         if (p.waitFor() == 0)
/*     */         {
/* 123 */           p = Runtime.getRuntime().exec("which lynx");
/* 124 */           if (p.waitFor() == 0)
/*     */           {
/* 126 */             browsers.add("xterm -e lynx {0}");
/*     */           }
/*     */         }
/*     */       
/* 130 */       } catch (Exception exception) {}
/*     */       
/* 132 */       if (browsers.size() == 0) {
/*     */         
/* 134 */         exec = (String[])null;
/*     */       }
/*     */       else {
/*     */         
/* 138 */         exec = browsers.<String>toArray(new String[0]);
/*     */       } 
/*     */     } 
/* 141 */     return exec;
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
/*     */   
/*     */   public static void displayURL(String url) throws BrowserException {
/* 167 */     int os = getOperatingSystem();
/* 168 */     String cmd = null;
/*     */     
/*     */     try {
/* 171 */       if (os == 1)
/*     */       {
/*     */         
/* 174 */         cmd = "rundll32 url.dll,FileProtocolHandler " + url;
/* 175 */         Process p = Runtime.getRuntime().exec(cmd);
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */         
/* 184 */         cmd = "netscape -remote openURL(" + url + ")";
/* 185 */         Process p = Runtime.getRuntime().exec(cmd);
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 190 */           int exitCode = p.waitFor();
/* 191 */           if (exitCode != 0)
/*     */           {
/*     */ 
/*     */             
/* 195 */             cmd = "netscape " + url;
/* 196 */             p = Runtime.getRuntime().exec(cmd);
/*     */           }
/*     */         
/* 199 */         } catch (InterruptedException interruptedException) {}
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 204 */     catch (Exception x) {
/*     */ 
/*     */       
/* 207 */       throw new RuntimeException(x);
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
/*     */   public static boolean isWindowsPlatform() {
/* 219 */     String os = System.getProperty("os.name");
/* 220 */     if (os != null && os.startsWith("Windows")) return true; 
/* 221 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\BrowserUtil.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */