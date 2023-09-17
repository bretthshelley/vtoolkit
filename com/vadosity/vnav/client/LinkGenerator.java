/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class LinkGenerator
/*     */ {
/*     */   public static void main(String[] args) {
/*  15 */     if (args == null || args.length == 0) {
/*     */       
/*  17 */       System.out.println("no arguments specified ");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  22 */     if (args.length < 2) {
/*     */       
/*  24 */       System.out.println("in[0] and out[1] files must be specified");
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  30 */     String in = args[0];
/*  31 */     String out = args[1];
/*     */ 
/*     */     
/*  34 */     String[] saAddresses = readFile(in);
/*  35 */     if (saAddresses == null) {
/*     */       
/*  37 */       System.out.println("error reading input file : " + in);
/*     */       
/*     */       return;
/*     */     } 
/*  41 */     generateOutputFile(saAddresses, out);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void generateOutputFile(String[] saAddresses, String out) {
/*  48 */     StringBuffer buf = new StringBuffer();
/*     */ 
/*     */ 
/*     */     
/*  52 */     String baseUrl = "http://www.vadosity.com/Download.do?eval=true&to=";
/*  53 */     String url = null;
/*  54 */     buf.append("<html><body><u>Click to Send Email to Addressee- </u><br>");
/*  55 */     for (int i = 0; i < saAddresses.length; i++) {
/*     */       
/*  57 */       url = String.valueOf(baseUrl) + saAddresses[i] + "&rand=" + Math.random();
/*  58 */       buf.append("<a href=\"" + url + "\">" + saAddresses[i] + "</a><br>");
/*     */     } 
/*  60 */     buf.append("</body></html>");
/*     */ 
/*     */     
/*     */     try {
/*  64 */       FileOutputStream fos = new FileOutputStream(out);
/*  65 */       fos.write(buf.toString().getBytes());
/*  66 */       fos.flush();
/*  67 */       fos.close();
/*  68 */       System.out.println("output written to " + (new File(out)).getAbsolutePath());
/*     */     
/*     */     }
/*  71 */     catch (Exception e) {
/*     */       
/*  73 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] readFile(String filename) {
/*  81 */     Vector v = new Vector();
/*     */ 
/*     */     
/*     */     try {
/*  85 */       BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
/*  86 */       String line = null;
/*     */       
/*  88 */       while ((line = reader.readLine()) != null) {
/*     */         
/*  90 */         line = line.trim().toLowerCase();
/*  91 */         v.add(line);
/*     */       } 
/*     */       
/*  94 */       String[] sa = new String[v.size()];
/*  95 */       for (int i = 0; i < sa.length; i++)
/*     */       {
/*  97 */         sa[i] = v.elementAt(i);
/*     */       }
/*  99 */       return sa;
/*     */     }
/* 101 */     catch (FileNotFoundException ex) {
/*     */       
/* 103 */       ex.printStackTrace();
/* 104 */       return null;
/*     */     }
/* 106 */     catch (IOException ex) {
/*     */       
/* 108 */       ex.printStackTrace();
/* 109 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\LinkGenerator.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */