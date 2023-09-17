/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.ViewSettings;
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Settings
/*     */ {
/*     */   public static final long SLOW_TIME = 4000L;
/*     */   public static final long NORMAL_TIME = 1000L;
/*     */   public static final long FAST_TIME = 500L;
/*     */   public static final long FASTER_TIME = 200L;
/*     */   public static final int EDIT_MODE = 0;
/*     */   public static final int VIEW_MODE = 1;
/*  20 */   public static int mode = 1;
/*  21 */   public static int getMode() { return mode; } public static void setMode(int mode) {
/*  22 */     Settings.mode = mode;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean editAngleMode = false;
/*     */ 
/*     */   
/*     */   public static boolean isEditAngleMode() {
/*  30 */     return editAngleMode;
/*     */   }
/*     */   public static void setEditAngleMode(boolean b) {
/*  33 */     editAngleMode = b;
/*     */   }
/*     */   
/*     */   private static boolean drawProximity = false;
/*     */   
/*  38 */   public static boolean isDrawProximity() { return drawProximity; } public static void setDrawProximity(boolean b) {
/*  39 */     drawProximity = b;
/*     */   }
/*     */   
/*     */   private static boolean addViewLinkOnMouseClick = false;
/*  43 */   public static boolean isAddViewLinkOnMouseClick() { return addViewLinkOnMouseClick; } public static void setAddViewLinkOnMouseClick(boolean b) {
/*  44 */     addViewLinkOnMouseClick = b;
/*     */   }
/*     */   private static boolean selectOnMouseOver = true;
/*  47 */   public static boolean isSelectOnMouseOver() { return selectOnMouseOver; } public static void setSelectOnMouseOver(boolean b) {
/*  48 */     selectOnMouseOver = b;
/*     */   }
/*  50 */   private static double startAngle = 0.0D; public static double getStartAngle() {
/*  51 */     return startAngle;
/*     */   }
/*     */   public static void setStartAngle(double radians) {
/*  54 */     startAngle = radians;
/*     */   }
/*     */   
/*     */   public static void setStartDegrees(double degrees) {
/*  58 */     setStartAngle(Math.toRadians(degrees));
/*     */   }
/*     */   
/*     */   public static void setStartDegrees(String degrees) {
/*  62 */     setStartDegrees(Double.parseDouble(degrees));
/*     */   }
/*     */   
/*  65 */   private static double finishAngle = Math.PI;
/*  66 */   public static double getFinishAngle() { return finishAngle; }
/*  67 */   public static void setFinishAngle(double radians) { finishAngle = radians; }
/*  68 */   public static void setFinishDegrees(double degrees) { setFinishAngle(Math.toRadians(degrees)); } public static void setFinishDegrees(String degrees) {
/*  69 */     setFinishDegrees(Double.parseDouble(degrees));
/*     */   }
/*     */   
/*  72 */   private static int numberPhotos = 1;
/*  73 */   public static int getNumberPhotos() { return numberPhotos; } public static void setNumberOfPhotos(int n) {
/*  74 */     numberPhotos = n;
/*     */   }
/*     */   private static boolean fullCircle = true;
/*  77 */   public static boolean isFullCircle() { return fullCircle; } public static void setFullCircle(boolean b) {
/*  78 */     fullCircle = b;
/*     */   }
/*     */   private static boolean clockwise = true;
/*  81 */   public static boolean isClockwise() { return clockwise; } public static void setClockwise(boolean b) {
/*  82 */     clockwise = b;
/*     */   }
/*     */   private static boolean addPanoramicPhotos = false;
/*  85 */   public static boolean isAddPanoramicPhotos() { return addPanoramicPhotos; } public static void setAddPanoramicPhotos(boolean b) {
/*  86 */     addPanoramicPhotos = b;
/*     */   }
/*  88 */   public static File photoDirectory = null;
/*     */   
/*     */   public static Color getVisibleFillColor() {
/*     */     
/*  92 */     try { return Global.getView().getViewSettings().getVisibleFillColor(); }
/*  93 */     catch (Exception e) { return ViewSettings.VISIBLE_FILL_COLOR_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setVisibleFillColor(Color c) {
/*     */     try {
/*  98 */       Global.getView().getViewSettings().setVisibleFillColor(c);
/*  99 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static Color getVisibleOutlineColor() {
/*     */     
/* 104 */     try { return Global.getView().getViewSettings().getVisibleOutlineColor(); }
/* 105 */     catch (Exception e) { return ViewSettings.VISIBLE_OUTLINE_COLOR_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setVisibleOutlineColor(Color c) {
/*     */     try {
/* 110 */       Global.getView().getViewSettings().setVisibleOutlineColor(c);
/* 111 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getLightArrowLength() {
/*     */     
/* 116 */     try { return Global.getView().getViewSettings().getLightArrowLength(); }
/* 117 */     catch (Exception e) { return ViewSettings.LIGHT_ARROW_LENGTH_DEFAULT; }
/*     */   
/*     */   } public static void setLightArrowLength(int n) {
/*     */     try {
/* 121 */       Global.getView().getViewSettings().setLightArrowLength(n);
/* 122 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getFloodLightLength() {
/*     */     
/* 127 */     try { return Global.getView().getViewSettings().getFloodLightLength(); }
/* 128 */     catch (Exception e) { return ViewSettings.FLOOD_LIGHT_LENGTH_DEFAULT; }
/*     */   
/*     */   } public static void setFloodLightLength(int n) {
/*     */     try {
/* 132 */       Global.getView().getViewSettings().setFloodLightLength(n);
/* 133 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMotionSimThreshold() {
/*     */     
/* 140 */     try { return Global.getView().getViewSettings().getMotionSimThreshold(); }
/* 141 */     catch (Exception e) { return ViewSettings.MOTION_SIM_THRESHOLD_DEFAULT; }
/*     */   
/*     */   } public static void setMotionSimThreshold(int pixels) {
/*     */     try {
/* 145 */       Global.getView().getViewSettings().setMotionSimThreshold(pixels);
/* 146 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getFlashLength() {
/*     */     
/* 151 */     try { return Global.getView().getViewSettings().getFlashLength(); }
/* 152 */     catch (Exception e) { return ViewSettings.FLASH_LENGTH_DEFAULT; }
/*     */   
/*     */   } public static void setFlashLength(int pixels) {
/*     */     try {
/* 156 */       Global.getView().getViewSettings().setFlashLength(pixels);
/* 157 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getFlashCoverageDegrees() {
/*     */     
/* 162 */     try { return Global.getView().getViewSettings().getFlashCoverageDegrees(); }
/* 163 */     catch (Exception e) { return ViewSettings.FLASH_COVERAGE_DEGREES_DEFAULT; }
/*     */   
/*     */   } public static void setFlashCoverageDegrees(int degrees) {
/*     */     try {
/* 167 */       Global.getView().getViewSettings().setFlashCoverageDegrees(degrees);
/* 168 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getProximityDistance(PhotoPoint pt) {
/*     */     
/* 173 */     try { return Global.getView().getViewSettings().getProximityDistance(pt); }
/* 174 */     catch (Exception e) { return ViewSettings.PROXIMITY_DISTANCE_DEFAULT; }
/*     */   
/*     */   } public static void setProximityDistance(int pixels) {
/*     */     try {
/* 178 */       Global.getView().getViewSettings().setProximityDistance(pixels);
/* 179 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getProximity() {
/*     */     
/* 184 */     try { return Global.getView().getViewSettings().getProximity(); }
/* 185 */     catch (Exception e) { return ViewSettings.OPTIMIZED_PROXIMITY; }
/*     */   
/*     */   } public static void setProximity(int proximityConstant) {
/*     */     try {
/* 189 */       Global.getView().getViewSettings().setProximity(proximityConstant);
/* 190 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isFlashesActivated() {
/*     */     
/* 197 */     try { return Global.getView().getViewSettings().isFlashesActivated(); }
/* 198 */     catch (Exception e) { return ViewSettings.FLASHES_ACTIVATED_DEFAULT; }
/*     */   
/*     */   } public static void setFlashesActivated(boolean b) {
/*     */     try {
/* 202 */       Global.getView().getViewSettings().setFlashesActivated(b);
/* 203 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static boolean isDrawAllFlashes() {
/*     */     
/* 208 */     try { return Global.getView().getViewSettings().isDrawAllFlashes(); }
/* 209 */     catch (Exception e) { return ViewSettings.DRAW_ALL_FLASHES_DEFAULT; }
/*     */   
/*     */   } public static void setDrawAllFlashes(boolean b) {
/*     */     try {
/* 213 */       Global.getView().getViewSettings().setDrawAllFlashes(b);
/* 214 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static boolean isDrawDotInCircle() {
/*     */     
/* 219 */     try { return Global.getView().getViewSettings().isDrawDotInCircle(); }
/* 220 */     catch (Exception e) { return ViewSettings.DRAW_DOT_IN_CIRCLE_DEFAULT; }
/*     */   
/*     */   } public static void setDrawDotInCircle(boolean b) {
/*     */     try {
/* 224 */       Global.getView().getViewSettings().setDrawDotInCircle(b);
/* 225 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAlwaysCenter() {
/*     */     
/* 232 */     try { return Global.getView().getViewSettings().isAlwaysCenter(); }
/* 233 */     catch (Exception e) { return ViewSettings.ALWAYS_CENTER_DEFAULT; }
/*     */   
/*     */   } public static void setAlwaysCenter(boolean b) {
/*     */     try {
/* 237 */       Global.getView().getViewSettings().setAlwaysCenter(b);
/* 238 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static boolean isDrawFootSteps() {
/*     */     
/* 243 */     try { return Global.getView().getViewSettings().isDrawFootSteps(); }
/* 244 */     catch (Exception e) { return ViewSettings.DRAW_FOOTSTEPS_DEFAULT; }
/*     */   
/*     */   } public static void setDrawFootSteps(boolean b) {
/*     */     try {
/* 248 */       Global.getView().getViewSettings().setDrawFootSteps(b);
/* 249 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static boolean isCirclePoints() {
/*     */     
/* 254 */     try { return Global.getView().getViewSettings().isCirclePoints(); }
/* 255 */     catch (Exception e) { return ViewSettings.CIRCLE_POINTS_DEFAULT; }
/*     */   
/*     */   } public static void setCirclePoints(boolean b) {
/*     */     try {
/* 259 */       Global.getView().getViewSettings().setCirclePoints(b);
/* 260 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static boolean isDrawLightArrows() {
/*     */     
/* 265 */     try { return Global.getView().getViewSettings().isDrawLightArrows(); }
/* 266 */     catch (Exception e) { return ViewSettings.DRAW_LIGHT_ARROWS_DEFAULT; }
/*     */   
/*     */   } public static void setDrawLightArrows(boolean b) {
/*     */     try {
/* 270 */       Global.getView().getViewSettings().setDrawLightArrows(b);
/* 271 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isDrawFloodLights() {
/*     */     
/* 277 */     try { return Global.getView().getViewSettings().isDrawFloodLight(); }
/* 278 */     catch (Exception e) { return ViewSettings.DRAW_FLOOD_LIGHT_DEFAULT; }
/*     */   
/*     */   } public static void setDrawFloodLight(boolean b) {
/*     */     try {
/* 282 */       Global.getView().getViewSettings().setDrawFloodLight(b);
/* 283 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static void setFlashFillColor(Color flashFillColor) {
/*     */     try {
/* 288 */       Global.getView().getViewSettings().setFlashFillColor(flashFillColor);
/* 289 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static Color getFlashFillColor() {
/*     */     
/* 293 */     try { return Global.getView().getViewSettings().getFlashFillColor(); }
/* 294 */     catch (Exception e) { return ViewSettings.FLASH_FILL_COLOR_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setSelectedFlashFillColor(Color flashFillColor) {
/*     */     try {
/* 299 */       Global.getView().getViewSettings().setSelectedFlashFillColor(flashFillColor);
/* 300 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static Color getSelectedFlashFillColor() {
/*     */     
/* 305 */     try { return Global.getView().getViewSettings().getSelectedFlashFillColor(); }
/* 306 */     catch (Exception e) { return ViewSettings.FLASH_FILL_COLOR_SELECTED_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setFlashOutlineColor(Color flashOutlineColor) {
/*     */     try {
/* 311 */       Global.getView().getViewSettings().setFlashOutlineColor(flashOutlineColor);
/* 312 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static Color getFlashOutlineColor() {
/*     */     
/* 316 */     try { return Global.getView().getViewSettings().getFlashOutlineColor(); }
/* 317 */     catch (Exception e) { return ViewSettings.FLASH_OUTLINE_COLOR_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static Color getFloodLightOutlineColor() {
/*     */     
/* 322 */     try { return Global.getView().getViewSettings().getFloodLightOutlineColor(); }
/* 323 */     catch (Exception e) { return ViewSettings.FLOOD_LIGHT_OUTLINE_COLOR_DEFAULT; }
/*     */   
/*     */   } public static Color getFloodLightFillColor() {
/*     */     
/* 327 */     try { return Global.getView().getViewSettings().getFloodLightFillColor(); }
/* 328 */     catch (Exception e) { return ViewSettings.FLOOD_LIGHT_FILL_COLOR_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setFloodLightOutlineColor(Color c) {
/*     */     try {
/* 333 */       Global.getView().getViewSettings().setFloodLightOutlineColor(c);
/* 334 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static void setFloodLightFillColor(Color c) {
/*     */     try {
/* 338 */       Global.getView().getViewSettings().setFloodLightFillColor(c);
/* 339 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getFloodLightAlpha() {
/*     */     
/* 344 */     try { return Global.getView().getViewSettings().getFloodLightAlpha(); }
/* 345 */     catch (Exception e) { return ViewSettings.FLOOD_LIGHT_ALPHA_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setFloodLightAlpha(int alpha) {
/*     */     try {
/* 350 */       Global.getView().getViewSettings().setFloodLightAlpha(alpha);
/* 351 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setSelectedFlashOutlineColor(Color flashOutlineColor) {
/*     */     try {
/* 359 */       Global.getView().getViewSettings().setSelectedFlashOutlineColor(flashOutlineColor);
/* 360 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static Color getSelectedFlashOutlineColor() {
/*     */     
/* 365 */     try { return Global.getView().getViewSettings().getSelectedFlashOutlineColor(); }
/* 366 */     catch (Exception e) { return ViewSettings.FLASH_OUTLINE_COLOR_SELECTED_DEFAULT; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public static Color getSelectedPhotoLinkOutlineColor() {
/* 372 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setPhotoPointDiameter(int photoPointDiameter) {
/*     */     try {
/* 380 */       Global.getView().getViewSettings().setPhotoPointDiameter(photoPointDiameter);
/* 381 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getPhotoPointDiameter() {
/*     */     
/* 386 */     try { return Global.getView().getViewSettings().getPhotoPointDiameter(); }
/* 387 */     catch (Exception e) { return ViewSettings.PHOTO_POINT_DIAMETER_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setPhotoPointOutlineColor(Color photoPointOutlineColor) {
/*     */     try {
/* 392 */       Global.getView().getViewSettings().setPhotoPointOutlineColor(photoPointOutlineColor);
/* 393 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static Color getPhotoPointOutlineColor() {
/*     */     
/* 398 */     try { return Global.getView().getViewSettings().getPhotoPointOutlineColor(); }
/* 399 */     catch (Exception e) { return ViewSettings.PHOTO_POINT_OUTLINE_COLOR_DEFAULT; }
/*     */   
/*     */   }
/*     */   
/*     */   public static void setPhotoPointFillColor(Color photoPointFillColor) {
/*     */     try {
/* 405 */       Global.getView().getViewSettings().setPhotoPointFillColor(photoPointFillColor);
/* 406 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static Color getPhotoPointFillColor() {
/*     */     
/* 411 */     try { return Global.getView().getViewSettings().getPhotoPointFillColor(); }
/* 412 */     catch (Exception e) { return ViewSettings.PHOTO_POINT_FILL_COLOR_DEFAULT; }
/*     */   
/*     */   }
/*     */   
/*     */   public static void setSelectedPhotoPointOutlineColor(Color photoPointOutlineColor) {
/*     */     try {
/* 418 */       Global.getView().getViewSettings().setSelectedPhotoPointOutlineColor(photoPointOutlineColor);
/* 419 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static Color getSelectedPhotoPointOutlineColor() {
/*     */     
/* 424 */     try { return Global.getView().getViewSettings().getSelectedPhotoPointOutlineColor(); }
/* 425 */     catch (Exception e) { return ViewSettings.PHOTO_POINT_OUTLINE_COLOR_SELECTED_DEFAULT; }
/*     */   
/*     */   }
/*     */   
/*     */   public static void setSelectedPhotoPointFillColor(Color photoPointFillColor) {
/*     */     try {
/* 431 */       Global.getView().getViewSettings().setSelectedPhotoPointFillColor(photoPointFillColor);
/* 432 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static Color getSelectedPhotoPointFillColor() {
/*     */     
/* 437 */     try { return Global.getView().getViewSettings().getSelectedPhotoPointFillColor(); }
/* 438 */     catch (Exception e) { return ViewSettings.PHOTO_POINT_FILL_COLOR_SELECTED_DEFAULT; }
/*     */   
/*     */   }
/*     */   
/*     */   public static void setFootstepFillColor(Color footstepFillColor) {
/*     */     try {
/* 444 */       Global.getView().getViewSettings().setFootstepFillColor(footstepFillColor);
/* 445 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static Color getFootstepFillColor() {
/*     */     
/* 449 */     try { return Global.getView().getViewSettings().getFootstepFillColor(); }
/* 450 */     catch (Exception e) { return ViewSettings.FOOTSTEP_FILL_COLOR_DEFAULT; }
/*     */   
/*     */   } public static void setFootstepOutlineColor(Color footstepOutlineColor) {
/*     */     try {
/* 454 */       Global.getView().getViewSettings().setFootstepOutlineColor(footstepOutlineColor);
/* 455 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static Color getFootstepOutlineColor() {
/*     */     
/* 459 */     try { return Global.getView().getViewSettings().getFootstepOutlineColor(); }
/* 460 */     catch (Exception e) { return ViewSettings.FOOTSTEP_OUTLINE_COLOR_DEFAULT; }
/*     */   
/*     */   } public static void setSelectedFootstepFillColor(Color selectedFootstepFillColor) {
/*     */     try {
/* 464 */       Global.getView().getViewSettings().setSelectedFootstepFillColor(selectedFootstepFillColor);
/* 465 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static Color getSelectedFootstepFillColor() {
/*     */     
/* 469 */     try { return Global.getView().getViewSettings().getSelectedFootstepFillColor(); }
/* 470 */     catch (Exception e) { return ViewSettings.FOOTSTEP_FILL_COLOR_SELECTED_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setSelectedFootstepOutlineColor(Color selectedFootstepOutlineColor) {
/*     */     try {
/* 475 */       Global.getView().getViewSettings().setSelectedFootstepOutlineColor(selectedFootstepOutlineColor);
/* 476 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static Color getSelectedFootstepOutlineColor() {
/*     */     
/* 480 */     try { return Global.getView().getViewSettings().getSelectedFootstepOutlineColor(); }
/* 481 */     catch (Exception e) { return ViewSettings.FOOTSTEP_OUTLINE_COLOR_SELECTED_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setArrowBladeAngle(double arrowBladeAngle) {
/*     */     try {
/* 486 */       Global.getView().getViewSettings().setArrowBladeAngle(arrowBladeAngle);
/* 487 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static double getArrowBladeAngle() {
/*     */     
/* 491 */     try { return Global.getView().getViewSettings().getArrowBladeAngle(); }
/* 492 */     catch (Exception e) { return ViewSettings.ARROW_BLADE_ANGLE_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setArrowBladeLength(int arrowBladeLength) {
/*     */     try {
/* 497 */       Global.getView().getViewSettings().setArrowBladeLength(arrowBladeLength);
/* 498 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static int getArrowBladeLength() {
/*     */     
/* 502 */     try { return Global.getView().getViewSettings().getArrowBladeLength(); }
/* 503 */     catch (Exception e) { return ViewSettings.ARROW_BLADE_LENGTH_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static int getLightAlpha() {
/*     */     
/* 508 */     try { return Global.getView().getViewSettings().getLightAlpha(); }
/* 509 */     catch (Exception e) { return ViewSettings.LIGHT_ALPHA_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setLightArrowColor(Color lightArrowColor) {
/*     */     try {
/* 514 */       Global.getView().getViewSettings().setLightArrowColor(lightArrowColor);
/* 515 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static Color getLightArrowColor() {
/*     */     
/* 519 */     try { return Global.getView().getViewSettings().getLightArrowColor(); }
/* 520 */     catch (Exception e) { return ViewSettings.LIGHT_ARROW_COLOR_DEFAULT; }
/*     */   
/*     */   } public static void setSelectedLightArrowColor(Color selectedLightArrowColor) {
/*     */     try {
/* 524 */       Global.getView().getViewSettings().setSelectedLightArrowColor(selectedLightArrowColor);
/* 525 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static Color getSelectedLightArrowColor() {
/*     */     
/* 529 */     try { return Global.getView().getViewSettings().getSelectedLightArrowColor(); }
/* 530 */     catch (Exception e) { return ViewSettings.LIGHT_ARROW_COLOR_SELECTED_DEFAULT; }
/*     */   
/*     */   } public static void setLightArrowBladeLength(int lightArrowBladeLength) {
/*     */     try {
/* 534 */       Global.getView().getViewSettings().setLightArrowBladeLength(lightArrowBladeLength);
/* 535 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static void setLightAlpha(int alpha) {
/*     */     try {
/* 539 */       Global.getView().getViewSettings().setLightAlpha(alpha);
/* 540 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getLightArrowBladeLength() {
/*     */     
/* 546 */     try { return Global.getView().getViewSettings().getLightArrowBladeLength(); }
/* 547 */     catch (Exception e) { return ViewSettings.LIGHT_ARROW_BLADE_LENGTH_DEFAULT; }
/*     */   
/*     */   } public static void setFootstepLength(int footstepLength) {
/*     */     try {
/* 551 */       Global.getView().getViewSettings().setFootstepLength(footstepLength);
/* 552 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static int getFootstepLength() {
/*     */     
/* 557 */     try { return Global.getView().getViewSettings().getFootstepLength(); }
/* 558 */     catch (Exception e) { return ViewSettings.FOOT_STEP_LENGTH_DEFAULT; }
/*     */   
/*     */   }
/*     */   public static void setFootstepWidth(int footstepWidth) {
/*     */     try {
/* 563 */       Global.getView().getViewSettings().setFootstepWidth(footstepWidth);
/* 564 */     } catch (Exception exception) {}
/*     */   }
/*     */   public static int getFootstepWidth() {
/*     */     
/* 568 */     try { return Global.getView().getViewSettings().getFootstepWidth(); }
/* 569 */     catch (Exception e) { return ViewSettings.FOOT_STEP_WIDTH_DEFAULT; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\Settings.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */