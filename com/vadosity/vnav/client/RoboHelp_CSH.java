/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoboHelp_CSH
/*     */ {
/*     */   public static final int HH_DISPLAY_TOPIC = 0;
/*     */   public static final int HH_DISPLAY_TOC = 1;
/*     */   public static final int HH_DISPLAY_INDEX = 2;
/*     */   public static final int HH_DISPLAY_SEARCH = 3;
/*     */   public static final int HH_HELP_CONTEXT = 15;
/*     */   
/*     */   public static boolean RH_ShowHelp(int hParent, String a_pszHelpFile, int uCommand, int dwData) {
/*  61 */     String strHelpPath = a_pszHelpFile;
/*  62 */     String strWnd = "";
/*  63 */     int nPos = a_pszHelpFile.indexOf(">");
/*  64 */     if (nPos != -1) {
/*     */       
/*  66 */       strHelpPath = a_pszHelpFile.substring(0, nPos);
/*  67 */       strWnd = a_pszHelpFile.substring(nPos + 1);
/*     */     } 
/*     */     
/*  70 */     if (isServerBased(a_pszHelpFile))
/*     */     {
/*  72 */       return ShowWebHelpServer_CSH(strHelpPath, strWnd, uCommand, dwData);
/*     */     }
/*     */     
/*  75 */     return ShowWebHelp_CSH(strHelpPath, strWnd, uCommand, dwData);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean ShowWebHelpServer_CSH(String strHelpPath, String strWnd, int uCommand, int nMapId) {
/*  80 */     String strUrl = "";
/*  81 */     if (strHelpPath != null) {
/*     */       
/*  83 */       if (uCommand == 15) {
/*     */         
/*  85 */         if (strHelpPath.indexOf("?") == -1) {
/*  86 */           strUrl = String.valueOf(strHelpPath) + "?ctxid=" + nMapId;
/*     */         } else {
/*  88 */           strUrl = String.valueOf(strHelpPath) + "&ctxid=" + nMapId;
/*     */         }
/*     */       
/*     */       }
/*  92 */       else if (strHelpPath.indexOf("?") == -1) {
/*  93 */         strUrl = String.valueOf(strHelpPath) + "?ctxid=0";
/*     */       } else {
/*  95 */         strUrl = String.valueOf(strHelpPath) + "&ctxid=0";
/*     */       } 
/*  97 */       if (strWnd != null && strWnd.length() > 0)
/*     */       {
/*  99 */         strUrl = String.valueOf(strUrl) + ">" + strWnd;
/*     */       }
/* 101 */       return ShowHelpURL(strUrl);
/*     */     } 
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean ShowWebHelp_CSH(String strHelpPath, String strWnd, int uCommand, int nMapId) {
/* 108 */     String strHelpFile = "";
/* 109 */     if (strHelpPath != null) {
/*     */       
/* 111 */       if (uCommand == 0)
/*     */       {
/* 113 */         strHelpFile = String.valueOf(strHelpPath) + "#<id=0";
/*     */       }
/* 115 */       if (uCommand == 15) {
/*     */         
/* 117 */         strHelpFile = String.valueOf(strHelpPath) + "#<id=" + nMapId;
/*     */       }
/* 119 */       else if (uCommand == 2) {
/*     */         
/* 121 */         strHelpFile = String.valueOf(strHelpPath) + "#<cmd=idx";
/*     */       }
/* 123 */       else if (uCommand == 3) {
/*     */         
/* 125 */         strHelpFile = String.valueOf(strHelpPath) + "#<cmd=fts";
/*     */       }
/* 127 */       else if (uCommand == 1) {
/*     */         
/* 129 */         strHelpFile = String.valueOf(strHelpPath) + "#<cmd=toc";
/*     */       } 
/* 131 */       if (strHelpFile.length() > 0) {
/*     */         
/* 133 */         if (strWnd != null && strWnd.length() > 0)
/*     */         {
/* 135 */           strHelpFile = String.valueOf(strHelpFile) + ">>wnd=" + strWnd;
/*     */         }
/* 137 */         strHelpFile = String.valueOf(strHelpFile) + ">>java=true";
/* 138 */         return ShowHelpURL(strHelpFile);
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean ShowHelpURL(String strUrl) {
/* 148 */     String strPath = null;
/* 149 */     boolean bIE = true;
/*     */     
/* 151 */     if (isWindows()) {
/*     */       
/* 153 */       if (isFromMS()) {
/*     */         
/* 155 */         String strWndPath = System.getProperty("com.ms.windir");
/* 156 */         if (strWndPath != null)
/*     */         {
/* 158 */           strPath = String.valueOf(strWndPath.substring(0, 2)) + "\\Program Files\\Internet Explorer\\IEXPLORE.EXE";
/*     */         }
/*     */       } 
/* 161 */       if (strPath == null) {
/*     */         
/* 163 */         String strPaths = System.getProperty("java.library.path");
/* 164 */         String strSeperator = System.getProperty("path.separator");
/* 165 */         int nPos = 0;
/* 166 */         boolean bFound = false;
/* 167 */         int nPosx = -1;
/*     */         
/*     */         do {
/* 170 */           nPosx = strPaths.indexOf(strSeperator, nPos);
/* 171 */           if (nPosx == -1)
/*     */             continue; 
/* 173 */           strPath = strPaths.substring(nPos, nPosx);
/* 174 */           strPath.replace('/', '\\');
/* 175 */           nPos = nPosx + 1;
/* 176 */           int nFindPos = -1;
/* 177 */           if ((nFindPos = strPath.toLowerCase().indexOf("\\program files")) != -1) {
/*     */             
/* 179 */             if (strPath.length() == nFindPos + 14 || 
/* 180 */               strPath.charAt(nFindPos + 14) == '\\') {
/*     */               
/* 182 */               bFound = true;
/*     */               
/*     */               break;
/*     */             } 
/* 186 */           } else if ((nFindPos = strPath.toLowerCase().indexOf("\\progra~1")) != -1) {
/*     */             
/* 188 */             if (strPath.length() == nFindPos + 9 || 
/* 189 */               strPath.charAt(nFindPos + 9) == '\\') {
/*     */               
/* 191 */               bFound = true;
/*     */               
/*     */               break;
/*     */             } 
/* 195 */           } else if ((nFindPos = strPath.toLowerCase().indexOf("\\windows")) != -1) {
/*     */             
/* 197 */             if (strPath.length() == nFindPos + 8 || 
/* 198 */               strPath.charAt(nFindPos + 8) == '\\') {
/*     */               
/* 200 */               strPath = String.valueOf(strPath.substring(0, nFindPos + 1)) + "program files";
/* 201 */               bFound = true;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 206 */         } while (nPosx != -1);
/* 207 */         if (bFound)
/*     */         {
/* 209 */           int nPos1 = strPath.toLowerCase().indexOf("program files");
/* 210 */           strPath = strPath.substring(0, nPos1 + 13);
/* 211 */           strPath = String.valueOf(strPath) + "\\Internet Explorer\\IEXPLORE.EXE";
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 217 */       strPath = "netscape";
/* 218 */       bIE = false;
/*     */     } 
/*     */     
/* 221 */     if (strPath != null) {
/*     */       
/*     */       try {
/* 224 */         Runtime.getRuntime().exec(String.valueOf(strPath) + " " + strUrl);
/* 225 */         return true;
/*     */       }
/* 227 */       catch (IOException e) {
/*     */         
/* 229 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 233 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isFromMS() {
/* 238 */     String s = System.getProperty("java.vendor");
/* 239 */     if (s.toLowerCase().indexOf("microsoft") == 0) {
/* 240 */       return true;
/*     */     }
/* 242 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isFromSun() {
/* 247 */     String s = System.getProperty("java.vendor");
/* 248 */     if (s.toLowerCase().indexOf("sun") == 0) {
/* 249 */       return true;
/*     */     }
/* 251 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isWindows() {
/* 256 */     String s = System.getProperty("os.name");
/* 257 */     if (s.toLowerCase().indexOf("window") == 0) {
/* 258 */       return true;
/*     */     }
/* 260 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isServerBased(String strHelpFile) {
/* 265 */     if (strHelpFile.length() > 0) {
/*     */       
/* 267 */       int nPos = strHelpFile.lastIndexOf('.');
/* 268 */       if (nPos != -1 && strHelpFile.length() >= nPos + 4) {
/*     */         
/* 270 */         String sExt = strHelpFile.substring(nPos, nPos + 4);
/* 271 */         if (sExt.equalsIgnoreCase(".htm"))
/*     */         {
/* 273 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 277 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String makeUrlForServerBased(String a_pszHelpFile, String strContextID) {
/* 282 */     return String.valueOf(a_pszHelpFile) + "?context=" + strContextID;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String makeUrlForWebHelpBased(String a_pszHelpFile, String strContextID) {
/* 287 */     return String.valueOf(a_pszHelpFile) + "#context=" + strContextID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private URL makeURL(URL base, String local, String url) throws MalformedURLException {
/*     */     try {
/* 295 */       String protocol = base.getProtocol();
/* 296 */       String host = base.getHost();
/* 297 */       String file = base.getFile();
/* 298 */       int port = base.getPort();
/*     */       
/* 300 */       String fileNew0 = tuHtmlToText(file);
/* 301 */       String fileNew1 = GetNormalizedLocal(fileNew0);
/* 302 */       String fileNew = TruncURLtoQuestionMark(fileNew1);
/* 303 */       URL baseNew = new URL(protocol, host, port, fileNew);
/*     */       
/* 305 */       String localNew0 = tuHtmlToText(local);
/* 306 */       String localNew = GetNormalizedLocal(localNew0);
/* 307 */       return new URL(baseNew, localNew);
/*     */     }
/* 309 */     catch (MalformedURLException x) {
/* 310 */       x.printStackTrace();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 316 */       File f = new File(local);
/* 317 */       if (f.exists())
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 322 */         return new URL("file:/" + local);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 330 */       return new URL(base, url);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String TruncURLtoQuestionMark(String str) {
/* 337 */     String strRc = str;
/* 338 */     int nQuestionMarkPos = str.indexOf('?');
/* 339 */     if (nQuestionMarkPos != -1) {
/* 340 */       strRc = str.substring(0, nQuestionMarkPos);
/*     */     }
/* 342 */     return strRc;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String GetNormalizedLocal(String str) {
/* 347 */     String local = str;
/*     */     
/* 349 */     for (int i = 0; i < local.length(); i++) {
/*     */       
/* 351 */       if (local.charAt(i) > '')
/*     */       {
/* 353 */         local = String.valueOf(local.substring(0, i)) + "%" + Integer.toString(local.charAt(i), 16) + local.substring(i + 1, local.length());
/*     */       }
/*     */     } 
/* 356 */     return local;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String tuHtmlToText(String value) {
/* 364 */     if (value == null) {
/* 365 */       return null;
/*     */     }
/* 367 */     int i = value.indexOf('&');
/*     */     
/* 369 */     if (i < 0) return value;
/*     */     
/* 371 */     String strOut = "";
/*     */ 
/*     */     
/* 374 */     while (i > -1 && i < value.length() - 2) {
/* 375 */       strOut = String.valueOf(strOut) + value.substring(0, i);
/*     */       
/* 377 */       String str = value.substring(i);
/* 378 */       String strEnd = "";
/* 379 */       int j = str.indexOf(';');
/* 380 */       if (j < 0) {
/* 381 */         strOut = String.valueOf(strOut) + str;
/*     */         
/*     */         break;
/*     */       } 
/* 385 */       if (j < str.length() - 1) {
/* 386 */         value = str.substring(j + 1);
/*     */       } else {
/*     */         
/* 389 */         value = "";
/*     */       } 
/* 391 */       str = str.substring(1, j);
/*     */ 
/*     */       
/* 394 */       switch (Character.toUpperCase(str.charAt(0))) {
/*     */         
/*     */         case 'A':
/* 397 */           if (str.equalsIgnoreCase("amp")) {
/* 398 */             str = "&";
/*     */           }
/*     */           break;
/*     */         case 'C':
/* 402 */           if (str.equalsIgnoreCase("copy")) {
/* 403 */             str = "(c)";
/*     */           }
/*     */           break;
/*     */         case 'G':
/* 407 */           if (str.equalsIgnoreCase("gt")) {
/* 408 */             str = ">";
/*     */           }
/*     */           break;
/*     */         case 'L':
/* 412 */           if (str.equalsIgnoreCase("lt")) {
/* 413 */             str = "<";
/*     */           }
/*     */           break;
/*     */         case 'N':
/* 417 */           if (str.equalsIgnoreCase("nbsp")) {
/* 418 */             str = " ";
/*     */           }
/*     */           break;
/*     */         case 'Q':
/* 422 */           if (str.equalsIgnoreCase("quot")) {
/* 423 */             str = "\"";
/*     */           }
/*     */           break;
/*     */         case 'R':
/* 427 */           if (str.equalsIgnoreCase("reg")) {
/* 428 */             str = "(R)";
/*     */           }
/*     */           break;
/*     */       } 
/* 432 */       strOut = String.valueOf(strOut) + str;
/* 433 */       i = value.indexOf('&');
/* 434 */       if (i < 0) {
/* 435 */         strOut = String.valueOf(strOut) + value;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 441 */     return strOut;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\RoboHelp_CSH.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */