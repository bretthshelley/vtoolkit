/*     */ package com.vadosity.vnav.bean;
/*     */ 
/*     */ import com.vadosity.vnav.client.Global;
/*     */ import java.awt.Color;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class ViewSettings
/*     */   implements Serializable
/*     */ {
/*     */   static final long serialVersionUID = -20407518486144600L;
/*     */   
/*     */   public boolean changed(boolean oldState, boolean newState) {
/*  17 */     if (oldState && newState) return true; 
/*  18 */     if (!oldState && !newState) return true; 
/*  19 */     return false;
/*     */   }
/*     */   
/*     */   public void checkModified(boolean oldState, boolean newState) {
/*  23 */     if (Global.getTour() != null)
/*  24 */       return;  if (changed(oldState, newState)) Global.getTour().setModified(true);
/*     */   
/*     */   }
/*     */   
/*     */   public boolean changed(int oldValue, int newValue) {
/*  29 */     return (oldValue == newValue);
/*     */   }
/*     */   
/*     */   public void checkModified(int oldValue, int newValue) {
/*  33 */     if (Global.getTour() != null)
/*  34 */       return;  if (changed(oldValue, newValue)) Global.getTour().setModified(true);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkModified(Object old, Object newObj) {
/*  40 */     if (Global.getTour() != null)
/*  41 */       return;  if (changed(old, newObj)) Global.getTour().setModified(true);
/*     */   
/*     */   }
/*     */   
/*     */   public boolean changed(Object old, Object newObj) {
/*  46 */     if (old == null && newObj == null) return true; 
/*  47 */     if (old == null && newObj != null) return true; 
/*  48 */     if (old != null && newObj == null) return true; 
/*  49 */     return old.equals(newObj);
/*     */   }
/*     */   
/*  52 */   public static int LIGHT_ARROW_LENGTH_DEFAULT = 25;
/*  53 */   private int lightArrowLength = LIGHT_ARROW_LENGTH_DEFAULT;
/*  54 */   public int getLightArrowLength() { return this.lightArrowLength; } public void setLightArrowLength(int n) {
/*  55 */     this.lightArrowLength = n;
/*     */   }
/*     */   public static boolean DRAW_FOOTSTEPS_DEFAULT = false;
/*  58 */   private boolean drawFootSteps = DRAW_FOOTSTEPS_DEFAULT; public boolean isDrawFootSteps() {
/*  59 */     return this.drawFootSteps;
/*     */   }
/*     */   public void setDrawFootSteps(boolean b) {
/*  62 */     checkModified(this.drawFootSteps, b);
/*  63 */     this.drawFootSteps = b;
/*     */   }
/*     */   
/*     */   public static boolean DRAW_DOT_IN_CIRCLE_DEFAULT = false;
/*  67 */   private boolean drawDotInCircle = DRAW_DOT_IN_CIRCLE_DEFAULT;
/*  68 */   public boolean isDrawDotInCircle() { return this.drawDotInCircle; } public void setDrawDotInCircle(boolean b) {
/*  69 */     this.drawDotInCircle = b;
/*     */   }
/*  71 */   public static int FLOOD_LIGHT_LENGTH_DEFAULT = 1200;
/*  72 */   private int floodLightLength = FLOOD_LIGHT_LENGTH_DEFAULT;
/*  73 */   public int getFloodLightLength() { return this.floodLightLength; } public void setFloodLightLength(int n) {
/*  74 */     this.floodLightLength = n;
/*     */   }
/*     */   public static boolean CIRCLE_POINTS_DEFAULT = true;
/*  77 */   private boolean circlePoints = CIRCLE_POINTS_DEFAULT; public boolean isCirclePoints() {
/*  78 */     return this.circlePoints;
/*     */   }
/*     */   public void setCirclePoints(boolean b) {
/*  81 */     checkModified(this.circlePoints, b);
/*  82 */     this.circlePoints = b;
/*     */   }
/*     */   
/*     */   public static boolean ALWAYS_CENTER_DEFAULT = false;
/*  86 */   private boolean alwaysCenter = ALWAYS_CENTER_DEFAULT; public boolean isAlwaysCenter() {
/*  87 */     return this.alwaysCenter;
/*     */   }
/*     */   public void setAlwaysCenter(boolean b) {
/*  90 */     checkModified(this.alwaysCenter, b);
/*  91 */     this.alwaysCenter = b;
/*     */   }
/*     */   
/*     */   public static boolean DRAW_LIGHT_ARROWS_DEFAULT = true;
/*  95 */   private boolean drawLightArrows = DRAW_LIGHT_ARROWS_DEFAULT; public boolean isDrawLightArrows() {
/*  96 */     return this.drawLightArrows;
/*     */   }
/*     */   public void setDrawLightArrows(boolean b) {
/*  99 */     checkModified(this.drawLightArrows, b);
/* 100 */     this.drawLightArrows = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean DRAW_ALL_FLASHES_DEFAULT = false;
/* 105 */   private boolean drawAllFlashes = DRAW_ALL_FLASHES_DEFAULT; public boolean isDrawAllFlashes() {
/* 106 */     return this.drawAllFlashes;
/*     */   }
/*     */   public void setDrawAllFlashes(boolean b) {
/* 109 */     checkModified(this.drawAllFlashes, b);
/* 110 */     this.drawAllFlashes = b;
/*     */   }
/*     */   
/* 113 */   public static Color VISIBLE_FILL_COLOR_DEFAULT = Color.blue;
/* 114 */   private Color visibleFillColor = VISIBLE_FILL_COLOR_DEFAULT; public Color getVisibleFillColor() {
/* 115 */     return this.visibleFillColor;
/*     */   }
/*     */   public void setVisibleFillColor(Color c) {
/* 118 */     checkModified(this.visibleFillColor, c);
/* 119 */     this.visibleFillColor = c;
/*     */   }
/*     */   
/* 122 */   public static Color VISIBLE_OUTLINE_COLOR_DEFAULT = Color.blue;
/* 123 */   private Color visibleOutlineColor = VISIBLE_OUTLINE_COLOR_DEFAULT;
/*     */   
/*     */   public Color getVisibleOutlineColor() {
/* 126 */     return this.visibleOutlineColor;
/*     */   }
/*     */   
/*     */   public void setVisibleOutlineColor(Color c) {
/* 130 */     checkModified(this.visibleOutlineColor, c);
/* 131 */     this.visibleOutlineColor = c;
/*     */   }
/*     */   
/*     */   public static boolean FLASHES_ACTIVATED_DEFAULT = true;
/* 135 */   private boolean flashesActivated = FLASHES_ACTIVATED_DEFAULT; public boolean isFlashesActivated() {
/* 136 */     return this.flashesActivated;
/*     */   }
/*     */   public void setFlashesActivated(boolean b) {
/* 139 */     checkModified(this.flashesActivated, b);
/* 140 */     this.flashesActivated = b;
/*     */   }
/*     */   
/* 143 */   public static int PROXIMITY_DISTANCE_DEFAULT = 10;
/* 144 */   private int proximityDistance = PROXIMITY_DISTANCE_DEFAULT;
/*     */ 
/*     */   
/*     */   public int getProximityDistance(PhotoPoint pt) {
/* 148 */     if (this.proximity == USER_DEFINED_PROXIMITY) return this.proximityDistance; 
/* 149 */     if (getProximity() == OPTIMIZED_PROXIMITY && pt != null && pt.getFirstPhoto() != null) {
/*     */       
/* 151 */       if (pt.getFirstPhoto().isPanoramic()) return getFlashLength(); 
/* 152 */       return getPhotoPointDiameter() / 2;
/*     */     } 
/* 154 */     return this.proximityDistance;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setProximityDistance(int pixels) {
/* 159 */     checkModified(this.proximityDistance, pixels);
/* 160 */     this.proximityDistance = pixels;
/*     */   }
/*     */   
/* 163 */   public static int OPTIMIZED_PROXIMITY = 0;
/* 164 */   public static int USER_DEFINED_PROXIMITY = 3;
/* 165 */   private int proximity = OPTIMIZED_PROXIMITY;
/*     */   
/*     */   public int getProximity() {
/* 168 */     return this.proximity;
/*     */   }
/*     */   
/*     */   public void setProximity(int proximityConstant) {
/* 172 */     if (proximityConstant != OPTIMIZED_PROXIMITY && 
/* 173 */       proximityConstant != USER_DEFINED_PROXIMITY)
/*     */     {
/* 175 */       throw new IllegalArgumentException("proximity must be set to OPTIMIZED_PROXIMITY, or USER_DEFINED_PROXIMITY");
/*     */     }
/* 177 */     this.proximity = proximityConstant;
/*     */   }
/*     */ 
/*     */   
/* 181 */   public static int FLASH_COVERAGE_DEGREES_DEFAULT = 45;
/* 182 */   public int flashCoverageDegrees = FLASH_COVERAGE_DEGREES_DEFAULT; public int getFlashCoverageDegrees() {
/* 183 */     return this.flashCoverageDegrees;
/*     */   }
/*     */   public void setFlashCoverageDegrees(int degrees) {
/* 186 */     checkModified(this.flashCoverageDegrees, degrees);
/* 187 */     this.flashCoverageDegrees = degrees;
/*     */   }
/*     */   
/* 190 */   public static int FLASH_LENGTH_DEFAULT = 25;
/* 191 */   public int flashLength = FLASH_LENGTH_DEFAULT; public int getFlashLength() {
/* 192 */     return this.flashLength;
/*     */   }
/*     */   public void setFlashLength(int pixels) {
/* 195 */     checkModified(this.flashLength, pixels);
/* 196 */     this.flashLength = pixels;
/*     */   }
/*     */   
/* 199 */   public static Color FLASH_FILL_COLOR_DEFAULT = new Color(204, 255, 255, 156);
/* 200 */   private Color flashFillColor = FLASH_FILL_COLOR_DEFAULT;
/*     */   
/*     */   public void setFlashFillColor(Color c) {
/* 203 */     checkModified(this.flashFillColor, c);
/* 204 */     this.flashFillColor = c;
/*     */   }
/*     */   
/*     */   public Color getFlashFillColor() {
/* 208 */     return this.flashFillColor;
/*     */   }
/* 210 */   public static Color FLASH_FILL_COLOR_SELECTED_DEFAULT = new Color(255, 255, 0, 156);
/* 211 */   private Color selectedFlashFillColor = FLASH_FILL_COLOR_SELECTED_DEFAULT;
/*     */   
/*     */   public void setSelectedFlashFillColor(Color c) {
/* 214 */     checkModified(this.selectedFlashFillColor, c);
/* 215 */     this.selectedFlashFillColor = c;
/*     */   } public Color getSelectedFlashFillColor() {
/* 217 */     return this.selectedFlashFillColor;
/*     */   }
/* 219 */   public static Color FLASH_OUTLINE_COLOR_DEFAULT = Color.black;
/* 220 */   private Color flashOutlineColor = FLASH_OUTLINE_COLOR_DEFAULT;
/*     */   
/*     */   public void setFlashOutlineColor(Color c) {
/* 223 */     checkModified(this.flashOutlineColor, c);
/* 224 */     this.flashOutlineColor = c;
/*     */   } public Color getFlashOutlineColor() {
/* 226 */     return this.flashOutlineColor;
/*     */   }
/* 228 */   public static Color FLASH_OUTLINE_COLOR_SELECTED_DEFAULT = Color.black;
/* 229 */   private Color selectedFlashOutlineColor = FLASH_OUTLINE_COLOR_SELECTED_DEFAULT;
/*     */   
/*     */   public void setSelectedFlashOutlineColor(Color c) {
/* 232 */     checkModified(this.selectedFlashOutlineColor, c);
/* 233 */     this.selectedFlashOutlineColor = c;
/*     */   } public Color getSelectedFlashOutlineColor() {
/* 235 */     return this.selectedFlashOutlineColor;
/*     */   }
/* 237 */   public static int PHOTO_POINT_DIAMETER_DEFAULT = 20;
/* 238 */   private int photoPointDiameter = PHOTO_POINT_DIAMETER_DEFAULT;
/*     */   
/*     */   public void setPhotoPointDiameter(int pixels) {
/* 241 */     checkModified(this.photoPointDiameter, pixels);
/* 242 */     this.photoPointDiameter = pixels;
/*     */   } public int getPhotoPointDiameter() {
/* 244 */     return this.photoPointDiameter;
/*     */   }
/* 246 */   public static Color PHOTO_POINT_OUTLINE_COLOR_DEFAULT = Color.blue;
/* 247 */   private Color photoPointOutlineColor = PHOTO_POINT_OUTLINE_COLOR_DEFAULT;
/*     */   
/*     */   public void setPhotoPointOutlineColor(Color c) {
/* 250 */     checkModified(this.photoPointOutlineColor, c);
/* 251 */     this.photoPointOutlineColor = c;
/*     */   } public Color getPhotoPointOutlineColor() {
/* 253 */     return this.photoPointOutlineColor;
/*     */   }
/* 255 */   public static Color PHOTO_POINT_FILL_COLOR_DEFAULT = null;
/* 256 */   private Color photoPointFillColor = PHOTO_POINT_FILL_COLOR_DEFAULT;
/*     */   
/*     */   public void setPhotoPointFillColor(Color c) {
/* 259 */     checkModified(this.photoPointFillColor, c);
/* 260 */     this.photoPointFillColor = c;
/*     */   } public Color getPhotoPointFillColor() {
/* 262 */     return this.photoPointFillColor;
/*     */   }
/* 264 */   public static Color PHOTO_POINT_OUTLINE_COLOR_SELECTED_DEFAULT = Color.blue;
/* 265 */   private Color selectedPhotoPointOutlineColor = PHOTO_POINT_OUTLINE_COLOR_SELECTED_DEFAULT;
/*     */   
/*     */   public void setSelectedPhotoPointOutlineColor(Color c) {
/* 268 */     checkModified(this.selectedPhotoPointOutlineColor, c);
/* 269 */     this.selectedPhotoPointOutlineColor = c;
/*     */   } public Color getSelectedPhotoPointOutlineColor() {
/* 271 */     return this.selectedPhotoPointOutlineColor;
/*     */   }
/* 273 */   public static Color PHOTO_POINT_FILL_COLOR_SELECTED_DEFAULT = Color.green;
/* 274 */   private Color selectedPhotoPointFillColor = PHOTO_POINT_FILL_COLOR_SELECTED_DEFAULT;
/*     */   
/*     */   public void setSelectedPhotoPointFillColor(Color c) {
/* 277 */     checkModified(this.selectedPhotoPointFillColor, c);
/* 278 */     this.selectedPhotoPointFillColor = c;
/*     */   } public Color getSelectedPhotoPointFillColor() {
/* 280 */     return this.selectedPhotoPointFillColor;
/*     */   }
/* 282 */   public static Color FOOTSTEP_FILL_COLOR_DEFAULT = new Color(0, 0, 255);
/* 283 */   private Color footstepFillColor = FOOTSTEP_FILL_COLOR_DEFAULT;
/*     */   
/*     */   public void setFootstepFillColor(Color c) {
/* 286 */     checkModified(this.footstepFillColor, c);
/* 287 */     this.footstepFillColor = c;
/*     */   } public Color getFootstepFillColor() {
/* 289 */     return this.footstepFillColor;
/*     */   }
/* 291 */   public static Color FOOTSTEP_OUTLINE_COLOR_DEFAULT = Color.black;
/* 292 */   private Color footstepOutlineColor = FOOTSTEP_OUTLINE_COLOR_DEFAULT;
/*     */   
/*     */   public void setFootstepOutlineColor(Color c) {
/* 295 */     checkModified(this.footstepOutlineColor, c);
/* 296 */     this.footstepOutlineColor = c;
/*     */   } public Color getFootstepOutlineColor() {
/* 298 */     return this.footstepOutlineColor;
/*     */   }
/* 300 */   public static Color FOOTSTEP_FILL_COLOR_SELECTED_DEFAULT = new Color(0, 255, 0);
/* 301 */   private Color selectedFootstepFillColor = FOOTSTEP_FILL_COLOR_SELECTED_DEFAULT;
/*     */   
/*     */   public void setSelectedFootstepFillColor(Color c) {
/* 304 */     checkModified(this.selectedFootstepFillColor, c);
/* 305 */     this.selectedFootstepFillColor = c;
/*     */   } public Color getSelectedFootstepFillColor() {
/* 307 */     return this.selectedFootstepFillColor;
/*     */   }
/* 309 */   public static Color FOOTSTEP_OUTLINE_COLOR_SELECTED_DEFAULT = Color.black;
/* 310 */   private Color selectedFootstepOutlineColor = FOOTSTEP_OUTLINE_COLOR_SELECTED_DEFAULT;
/*     */   
/*     */   public void setSelectedFootstepOutlineColor(Color c) {
/* 313 */     checkModified(this.selectedFootstepOutlineColor, c);
/* 314 */     this.selectedFootstepOutlineColor = c;
/*     */   } public Color getSelectedFootstepOutlineColor() {
/* 316 */     return this.selectedFootstepOutlineColor;
/*     */   }
/* 318 */   public static double ARROW_BLADE_ANGLE_DEFAULT = 0.5235987755982988D;
/* 319 */   private double arrowBladeAngle = ARROW_BLADE_ANGLE_DEFAULT;
/* 320 */   public void setArrowBladeAngle(double arrowBladeAngle) { this.arrowBladeAngle = arrowBladeAngle; } public double getArrowBladeAngle() {
/* 321 */     return this.arrowBladeAngle;
/*     */   }
/*     */   
/* 324 */   public static int ARROW_BLADE_LENGTH_DEFAULT = 14;
/* 325 */   private int arrowBladeLength = ARROW_BLADE_LENGTH_DEFAULT;
/*     */   
/*     */   public void setArrowBladeLength(int n) {
/* 328 */     checkModified(this.arrowBladeLength, n);
/* 329 */     this.arrowBladeLength = n;
/*     */   } public int getArrowBladeLength() {
/* 331 */     return this.arrowBladeLength;
/*     */   }
/* 333 */   public static Color LIGHT_ARROW_COLOR_DEFAULT = Color.blue;
/* 334 */   private Color lightArrowColor = LIGHT_ARROW_COLOR_DEFAULT;
/*     */   
/*     */   public void setLightArrowColor(Color c) {
/* 337 */     checkModified(this.lightArrowColor, c);
/* 338 */     this.lightArrowColor = c;
/*     */   }
/*     */   public Color getLightArrowColor() {
/* 341 */     return this.lightArrowColor;
/*     */   }
/* 343 */   public static Color LIGHT_ARROW_COLOR_SELECTED_DEFAULT = Color.black;
/* 344 */   private Color selectedLightArrowColor = LIGHT_ARROW_COLOR_SELECTED_DEFAULT;
/*     */   
/*     */   public void setSelectedLightArrowColor(Color c) {
/* 347 */     checkModified(this.selectedLightArrowColor, c);
/* 348 */     this.selectedLightArrowColor = c;
/*     */   } public Color getSelectedLightArrowColor() {
/* 350 */     return this.selectedLightArrowColor;
/*     */   }
/* 352 */   public static int LIGHT_ARROW_BLADE_LENGTH_DEFAULT = 12;
/* 353 */   private int lightArrowBladeLength = LIGHT_ARROW_BLADE_LENGTH_DEFAULT;
/*     */   
/*     */   public void setLightArrowBladeLength(int n) {
/* 356 */     checkModified(this.lightArrowBladeLength, n);
/* 357 */     this.lightArrowBladeLength = n;
/*     */   } public int getLightArrowBladeLength() {
/* 359 */     return this.lightArrowBladeLength;
/*     */   }
/* 361 */   public static int FOOT_STEP_LENGTH_DEFAULT = 20;
/* 362 */   private int footstepLength = FOOT_STEP_LENGTH_DEFAULT;
/*     */   
/*     */   public void setFootstepLength(int n) {
/* 365 */     checkModified(this.footstepLength, n);
/* 366 */     this.footstepLength = n;
/*     */   } public int getFootstepLength() {
/* 368 */     return this.footstepLength;
/*     */   }
/* 370 */   public static int FOOT_STEP_WIDTH_DEFAULT = 9;
/* 371 */   private int footstepWidth = FOOT_STEP_WIDTH_DEFAULT;
/*     */   
/*     */   public void setFootstepWidth(int n) {
/* 374 */     checkModified(this.footstepWidth, n);
/* 375 */     this.footstepWidth = n;
/*     */   } public int getFootstepWidth() {
/* 377 */     return this.footstepWidth;
/*     */   }
/*     */   
/* 380 */   public static int MOTION_SIM_THRESHOLD_DEFAULT = 250;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 387 */   private int motionSimThreshold = MOTION_SIM_THRESHOLD_DEFAULT; public int getMotionSimThreshold() {
/* 388 */     return this.motionSimThreshold;
/*     */   }
/*     */   public void setMotionSimThreshold(int pixels) {
/* 391 */     checkModified(this.motionSimThreshold, pixels);
/* 392 */     this.motionSimThreshold = pixels;
/*     */   }
/*     */   
/*     */   public static boolean DRAW_FLOOD_LIGHT_DEFAULT = true;
/* 396 */   private boolean drawFloodLight = DRAW_FLOOD_LIGHT_DEFAULT;
/*     */   
/*     */   public boolean isDrawFloodLight() {
/* 399 */     return this.drawFloodLight;
/*     */   }
/*     */   
/*     */   public void setDrawFloodLight(boolean b) {
/* 403 */     checkModified(this.drawFloodLight, b);
/* 404 */     this.drawFloodLight = b;
/*     */   }
/*     */ 
/*     */   
/* 408 */   public static Color FLOOD_LIGHT_FILL_COLOR_DEFAULT = new Color(0, 102, 255, 56);
/* 409 */   private Color floodLightFillColor = FLOOD_LIGHT_FILL_COLOR_DEFAULT;
/*     */   
/*     */   public Color getFloodLightFillColor() {
/* 412 */     return this.floodLightFillColor;
/*     */   }
/*     */   
/*     */   public void setFloodLightFillColor(Color color) {
/* 416 */     this.floodLightFillColor = color;
/*     */   }
/*     */   
/* 419 */   public static Color FLOOD_LIGHT_OUTLINE_COLOR_DEFAULT = new Color(0, 51, 204);
/* 420 */   private Color floodLightOutlineColor = FLOOD_LIGHT_OUTLINE_COLOR_DEFAULT;
/*     */   
/*     */   public Color getFloodLightOutlineColor() {
/* 423 */     return this.floodLightOutlineColor;
/*     */   }
/*     */   
/*     */   public void setFloodLightOutlineColor(Color color) {
/* 427 */     this.floodLightOutlineColor = color;
/*     */   }
/*     */   
/* 430 */   public static int LIGHT_ALPHA_DEFAULT = 56;
/* 431 */   private int lightAlpha = LIGHT_ALPHA_DEFAULT;
/*     */   
/*     */   public int getLightAlpha() {
/* 434 */     return this.lightAlpha;
/*     */   }
/*     */   
/*     */   public void setLightAlpha(int i) {
/* 438 */     checkModified(this.lightAlpha, i);
/* 439 */     this.lightAlpha = i;
/*     */   }
/*     */   
/* 442 */   public static int FLOOD_LIGHT_ALPHA_DEFAULT = 56;
/* 443 */   private int floodLightAlpha = FLOOD_LIGHT_ALPHA_DEFAULT;
/*     */   
/*     */   public int getFloodLightAlpha() {
/* 446 */     return this.floodLightAlpha;
/*     */   }
/*     */   
/*     */   public void setFloodLightAlpha(int i) {
/* 450 */     checkModified(this.floodLightAlpha, i);
/* 451 */     this.floodLightAlpha = i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ViewSettings copyOf() {
/*     */     try {
/* 458 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 459 */       ObjectOutputStream oos = new ObjectOutputStream(baos);
/* 460 */       oos.writeObject(this);
/* 461 */       ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
/* 462 */       ObjectInputStream ois = new ObjectInputStream(bais);
/* 463 */       Object deepCopy = ois.readObject();
/* 464 */       return (ViewSettings)deepCopy;
/*     */     }
/* 466 */     catch (Exception e) {
/*     */       
/* 468 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\bean\ViewSettings.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */