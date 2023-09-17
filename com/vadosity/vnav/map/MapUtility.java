/*    */ package com.vadosity.vnav.map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapUtility
/*    */ {
/*    */   public static final double METERS_PER_DEGREE_LATITUDE = 111319.5D;
/*    */   
/*    */   public static double round7(double d) {
/* 10 */     if (d == 0.0D) return d; 
/* 11 */     double result = Math.round(d * 1.0E7D) / 1.0E7D;
/* 12 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static double getWGS84DegreesLatitude(double meters) {
/* 18 */     if (meters == 0.0D) throw new IllegalArgumentException("meters cannot be zero");
/*    */     
/* 20 */     return round7(meters / 111319.5D);
/*    */   }
/*    */ 
/*    */   
/*    */   public static double getWGS84DegreesLongitude(double meters, double degreesLatitude) {
/* 25 */     if (meters == 0.0D) throw new IllegalArgumentException("meters cannot be zero"); 
/* 26 */     double conversionFactor = Math.cos(Math.toRadians(degreesLatitude)) * 111319.5D;
/* 27 */     return round7(meters / conversionFactor);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\map\MapUtility.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */