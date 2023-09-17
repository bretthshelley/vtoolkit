/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GraphicsUtil
/*     */ {
/*     */   public static final double circle = 6.283185307179586D;
/*     */   public static final double FIVE_DEGREES = 0.08726646259971647D;
/*     */   public static final double TEN_DEGREES = 0.17453292519943295D;
/*     */   public static final double FIFTEEN_DEGREES = 0.2617993877991494D;
/*     */   public static final double TWENTY_DEGREES = 0.3490658503988659D;
/*     */   
/*     */   public static Photo getPhotoWithAngleCloseTo(PhotoPoint photoPoint, double angle) {
/*  21 */     if (!photoPoint.hasMultiplePhotos()) return photoPoint.getFirstPhoto(); 
/*  22 */     double tenDegrees = Math.toRadians(10.0D);
/*     */     
/*  24 */     Photo closestMatch = null;
/*  25 */     for (int i = 0; i < photoPoint.getVPhotos().size(); i++) {
/*     */       
/*  27 */       Photo ithPhoto = photoPoint.getVPhotos().elementAt(i);
/*  28 */       if (i == 0) {
/*     */         
/*  30 */         closestMatch = photoPoint.getVPhotos().elementAt(i);
/*  31 */         if (angularDiff(closestMatch.getStartAngle(), angle) < tenDegrees)
/*     */         {
/*  33 */           return closestMatch;
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/*  38 */         double angularDiff = angularDiff(ithPhoto.getStartAngle(), angle);
/*  39 */         if (angularDiff < tenDegrees)
/*     */         {
/*  41 */           return ithPhoto;
/*     */         }
/*  43 */         double diffClosestMatch = angularDiff(closestMatch.getStartAngle(), angle);
/*  44 */         double diffIthPhoto = angularDiff(ithPhoto.getStartAngle(), angle);
/*  45 */         if (diffIthPhoto < diffClosestMatch)
/*     */         {
/*  47 */           closestMatch = ithPhoto; } 
/*     */       } 
/*     */     } 
/*  50 */     return closestMatch;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getAngleFromCenter(Component component, Point pt) {
/*  56 */     int x = component.getWidth() / 2;
/*  57 */     int y = component.getHeight() / 2;
/*  58 */     int rise = pt.y - y;
/*  59 */     int run = pt.x - x;
/*  60 */     double angle = Math.atan2(rise, run);
/*  61 */     if (angle < 0.0D) angle += 6.283185307179586D; 
/*  62 */     return angle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double angularDiff(double a, double b) {
/*  68 */     if (Math.abs(a - b) < Math.PI) return Math.abs(a - b); 
/*  69 */     if (a > b)
/*     */     {
/*  71 */       return Math.abs(6.283185307179586D - a + b);
/*     */     }
/*     */ 
/*     */     
/*  75 */     return Math.abs(6.283185307179586D - b + a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void paintArrow(Graphics g, int length, Point start, double angle, Color color, boolean selected) {
/*  81 */     int x0 = start.x;
/*  82 */     int y0 = start.y;
/*     */     
/*  84 */     int x1 = (int)(x0 + length * Math.cos(angle));
/*  85 */     int y1 = (int)(y0 + length * Math.sin(angle));
/*  86 */     g.setColor(color);
/*     */     
/*  88 */     Point tip = new Point(x1, y1);
/*  89 */     LightArrow arrow = new LightArrow(start, tip);
/*  90 */     arrow.setArrowColor(color);
/*  91 */     if (selected) { arrow.paint(g, color); }
/*  92 */     else { arrow.paintSelected(g, color); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public static void paintArrowFromCenter(Graphics g, int length, Component component, double angle, Color color, boolean selected) {
/*  98 */     int x0 = component.getWidth() / 2;
/*  99 */     int y0 = component.getHeight() / 2;
/* 100 */     Point pt = new Point(x0, y0);
/* 101 */     paintArrow(g, length, pt, angle, color, selected);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getDisplayDegrees(double angle) {
/* 106 */     double degrees = Math.toDegrees(angle);
/* 107 */     degrees = Math.round(degrees);
/* 108 */     if (degrees > 360.0D) return (int)(degrees % 360.0D); 
/* 109 */     if (degrees >= 0.0D) return (int)degrees; 
/* 110 */     if (degrees < 0.0D) return (int)(360.0D + degrees); 
/* 111 */     return (int)Math.toDegrees(angle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getAngleBetweenPhotoPoints(PhotoPoint ptFrom, PhotoPoint ptTo) {
/* 117 */     if (ptFrom == null || ptTo == null) return 0.0D; 
/* 118 */     int rise = ptTo.getY() - ptFrom.getY();
/* 119 */     int run = ptTo.getX() - ptFrom.getX();
/* 120 */     double angle = Math.atan2(rise, run);
/* 121 */     if (angle < 0.0D)
/*     */     {
/* 123 */       angle += 6.283185307179586D;
/*     */     }
/* 125 */     return angle;
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
/*     */   public static double calculateTurnAngle(PhotoPoint pt0, PhotoPoint pt1, PhotoPoint pt2) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual getY : ()I
/*     */     //   4: aload_0
/*     */     //   5: invokevirtual getY : ()I
/*     */     //   8: isub
/*     */     //   9: istore_3
/*     */     //   10: aload_1
/*     */     //   11: invokevirtual getX : ()I
/*     */     //   14: aload_0
/*     */     //   15: invokevirtual getX : ()I
/*     */     //   18: isub
/*     */     //   19: istore #4
/*     */     //   21: iload_3
/*     */     //   22: i2d
/*     */     //   23: iload #4
/*     */     //   25: i2d
/*     */     //   26: invokestatic atan2 : (DD)D
/*     */     //   29: dstore #5
/*     */     //   31: dload #5
/*     */     //   33: dconst_0
/*     */     //   34: dcmpg
/*     */     //   35: ifge -> 46
/*     */     //   38: dload #5
/*     */     //   40: ldc2_w 6.283185307179586
/*     */     //   43: dadd
/*     */     //   44: dstore #5
/*     */     //   46: aload_2
/*     */     //   47: invokevirtual getY : ()I
/*     */     //   50: aload_1
/*     */     //   51: invokevirtual getY : ()I
/*     */     //   54: isub
/*     */     //   55: istore #7
/*     */     //   57: aload_2
/*     */     //   58: invokevirtual getX : ()I
/*     */     //   61: aload_1
/*     */     //   62: invokevirtual getX : ()I
/*     */     //   65: isub
/*     */     //   66: istore #8
/*     */     //   68: iload #7
/*     */     //   70: i2d
/*     */     //   71: iload #8
/*     */     //   73: i2d
/*     */     //   74: invokestatic atan2 : (DD)D
/*     */     //   77: dstore #9
/*     */     //   79: dload #9
/*     */     //   81: dconst_0
/*     */     //   82: dcmpg
/*     */     //   83: ifge -> 94
/*     */     //   86: dload #9
/*     */     //   88: ldc2_w 6.283185307179586
/*     */     //   91: dadd
/*     */     //   92: dstore #9
/*     */     //   94: dload #9
/*     */     //   96: dload #5
/*     */     //   98: dsub
/*     */     //   99: dstore #11
/*     */     //   101: dload #11
/*     */     //   103: invokestatic abs : (D)D
/*     */     //   106: dstore #13
/*     */     //   108: dload #13
/*     */     //   110: ldc2_w 3.141592653589793
/*     */     //   113: dcmpl
/*     */     //   114: ifle -> 146
/*     */     //   117: dload #11
/*     */     //   119: dconst_0
/*     */     //   120: dcmpl
/*     */     //   121: ifle -> 135
/*     */     //   124: dload #11
/*     */     //   126: ldc2_w 6.283185307179586
/*     */     //   129: dsub
/*     */     //   130: dstore #11
/*     */     //   132: goto -> 146
/*     */     //   135: dload #11
/*     */     //   137: ldc2_w 6.283185307179586
/*     */     //   140: dadd
/*     */     //   141: dup2
/*     */     //   142: dstore #11
/*     */     //   144: dstore #11
/*     */     //   146: dload #11
/*     */     //   148: dreturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #137	-> 0
/*     */     //   #138	-> 10
/*     */     //   #139	-> 21
/*     */     //   #140	-> 31
/*     */     //   #142	-> 46
/*     */     //   #143	-> 57
/*     */     //   #144	-> 68
/*     */     //   #145	-> 79
/*     */     //   #149	-> 94
/*     */     //   #150	-> 101
/*     */     //   #151	-> 108
/*     */     //   #153	-> 117
/*     */     //   #154	-> 135
/*     */     //   #157	-> 146
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	149	0	pt0	Lcom/vadosity/vnav/bean/PhotoPoint;
/*     */     //   0	149	1	pt1	Lcom/vadosity/vnav/bean/PhotoPoint;
/*     */     //   0	149	2	pt2	Lcom/vadosity/vnav/bean/PhotoPoint;
/*     */     //   10	139	3	rise10	I
/*     */     //   21	128	4	run10	I
/*     */     //   31	118	5	alpha	D
/*     */     //   57	92	7	rise21	I
/*     */     //   68	81	8	run21	I
/*     */     //   79	70	9	beta	D
/*     */     //   101	48	11	turnAngle	D
/*     */     //   108	41	13	absTurnAngle	D
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
/*     */   public static void drawLightArrow(Graphics g, PhotoPoint photoPoint, Photo photo) {
/* 164 */     int x1 = (int)Math.round(photoPoint.getX() + 
/* 165 */         Settings.getPhotoPointDiameter() * 
/* 166 */         Math.cos(photo.getStartAngle()));
/* 167 */     int y1 = (int)Math.round(photoPoint.getY() + 
/* 168 */         Settings.getPhotoPointDiameter() * 
/* 169 */         Math.sin(photo.getStartAngle()));
/* 170 */     if (photo.equals(Global.getPhoto())) {
/*     */       
/* 172 */       (new LightArrow(new Point(photoPoint.getX(), photoPoint.getY()), new Point(x1, y1))).paintSelected(g, null);
/*     */     }
/*     */     else {
/*     */       
/* 176 */       (new LightArrow(new Point(photoPoint.getX(), photoPoint.getY()), new Point(x1, y1))).paint(g, null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\GraphicsUtil.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */