/*     */ package com.vadosity.vnav.bean;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ public class ProjectSettings
/*     */   implements Serializable
/*     */ {
/*     */   static final long serialVersionUID = 2932609961034392454L;
/*  10 */   private String projectDirectory = null;
/*  11 */   private String originalPhotosDirectory = null;
/*  12 */   private String resizedPhotosDirectory = null;
/*  13 */   private String diagramsDirectory = null;
/*  14 */   private String stagingDirectory = null;
/*  15 */   private String projectName = null;
/*  16 */   private String importedPhotosDirectory = null;
/*     */ 
/*     */   
/*  19 */   public static String DEFAULT_NAME = "tour";
/*  20 */   public static String DEFAULT_ORIGINALS_DIRECTORY_NAME = "originals";
/*  21 */   public static String DEFAULT_RESIZED_DIRECTORY_NAME = "resized";
/*  22 */   public static String DEFAULT_DIAGRAM_DIRECTORY_NAME = "diagrams";
/*  23 */   public static String DEFAULT_STAGING_DIRECTORY_NAME = "staging";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStagingDirectory() {
/*  31 */     return this.stagingDirectory; } public void setStagingDirectory(String dir) {
/*  32 */     this.stagingDirectory = dir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDiagramsDirectory() {
/*  39 */     return this.diagramsDirectory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOriginalPhotosDirectory() {
/*  47 */     return this.originalPhotosDirectory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProjectDirectory() {
/*  55 */     return this.projectDirectory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProjectName() {
/*  63 */     return this.projectName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResizedPhotosDirectory() {
/*  71 */     return this.resizedPhotosDirectory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDiagramsDirectory(String string) {
/*  79 */     this.diagramsDirectory = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginalPhotosDirectory(String string) {
/*  87 */     this.originalPhotosDirectory = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProjectDirectory(String string) {
/*  95 */     this.projectDirectory = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProjectName(String string) {
/* 103 */     this.projectName = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResizedPhotosDirectory(String string) {
/* 111 */     this.resizedPhotosDirectory = string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getImportedPhotosDirectory() {
/* 119 */     return this.importedPhotosDirectory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImportedPhotosDirectory(String string) {
/* 127 */     this.importedPhotosDirectory = string;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\bean\ProjectSettings.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */