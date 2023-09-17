/*    */ package com.vadosity.vnav.client;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JToolBar;
/*    */ import javax.swing.SwingUtilities;
/*    */ import javax.swing.UIManager;
/*    */ 
/*    */ public class SettingsToolBar extends JToolBar implements SettingsChangeListener {
/*  8 */   DrawFootStepsToggleButton drawFootStepsToggleButton = new DrawFootStepsToggleButton();
/*  9 */   CirclePointsToggleButton circlePointsToggleButton = new CirclePointsToggleButton();
/* 10 */   DrawLightArrowsToggleButton drawLightArrowsToggleButton = new DrawLightArrowsToggleButton();
/* 11 */   DrawAllFlashesToggleButton drawAllFlashesToggleButton = new DrawAllFlashesToggleButton();
/* 12 */   FloodLightToggleButton floodLightToggleButton = new FloodLightToggleButton();
/* 13 */   AlwaysCenterToggleButton alwaysCenterToggleButton = new AlwaysCenterToggleButton();
/* 14 */   LightningMouseToggleButton lightningMouseToggleButton = new LightningMouseToggleButton();
/*    */   
/*    */   public SettingsToolBar() {
/*    */     try {
/* 18 */       jbInit();
/*    */       
/* 20 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/* 21 */       UIManager.setLookAndFeel(nativeLF);
/* 22 */       SwingUtilities.updateComponentTreeUI(this);
/* 23 */       Global.addSettingsChangeListener(this);
/*    */     
/*    */     }
/* 26 */     catch (Exception e) {
/* 27 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 35 */     this.drawFootStepsToggleButton.setToolTipText("Draw Footsteps");
/* 36 */     this.drawFootStepsToggleButton.setPreferredSize(new Dimension(35, 35));
/* 37 */     this.drawFootStepsToggleButton.setMinimumSize(new Dimension(35, 35));
/* 38 */     this.drawFootStepsToggleButton.setMaximumSize(new Dimension(35, 35));
/* 39 */     this.floodLightToggleButton.setPreferredSize(new Dimension(35, 35));
/* 40 */     this.floodLightToggleButton.setMinimumSize(new Dimension(35, 35));
/* 41 */     this.floodLightToggleButton.setMaximumSize(new Dimension(35, 35));
/* 42 */     this.circlePointsToggleButton.setMaximumSize(new Dimension(35, 35));
/* 43 */     this.circlePointsToggleButton.setMinimumSize(new Dimension(35, 35));
/* 44 */     this.circlePointsToggleButton.setPreferredSize(new Dimension(35, 35));
/* 45 */     this.circlePointsToggleButton.setToolTipText("Circle Points");
/* 46 */     this.drawLightArrowsToggleButton.setMaximumSize(new Dimension(35, 35));
/* 47 */     this.drawLightArrowsToggleButton.setMinimumSize(new Dimension(35, 35));
/* 48 */     this.drawLightArrowsToggleButton.setPreferredSize(new Dimension(35, 35));
/* 49 */     this.drawLightArrowsToggleButton.setToolTipText("Draw Arrows");
/* 50 */     this.drawLightArrowsToggleButton.setText("");
/* 51 */     this.drawAllFlashesToggleButton.setToolTipText("Draw Flashes");
/* 52 */     this.drawAllFlashesToggleButton.setMinimumSize(new Dimension(35, 35));
/* 53 */     this.drawAllFlashesToggleButton.setPreferredSize(new Dimension(35, 35));
/* 54 */     this.drawAllFlashesToggleButton.setMaximumSize(new Dimension(35, 35));
/* 55 */     this.alwaysCenterToggleButton.setMaximumSize(new Dimension(35, 35));
/* 56 */     this.alwaysCenterToggleButton.setMinimumSize(new Dimension(35, 35));
/* 57 */     this.alwaysCenterToggleButton.setPreferredSize(new Dimension(35, 35));
/* 58 */     this.alwaysCenterToggleButton.setToolTipText("Always Center");
/* 59 */     this.alwaysCenterToggleButton.setText("");
/* 60 */     this.lightningMouseToggleButton.setMaximumSize(new Dimension(35, 35));
/* 61 */     this.lightningMouseToggleButton.setMinimumSize(new Dimension(35, 35));
/* 62 */     this.lightningMouseToggleButton.setPreferredSize(new Dimension(35, 35));
/* 63 */     this.lightningMouseToggleButton.setToolTipText("Activate Lightning Mouse");
/*    */ 
/*    */     
/* 66 */     add(this.drawFootStepsToggleButton, (Object)null);
/* 67 */     add(this.circlePointsToggleButton, (Object)null);
/* 68 */     add(this.drawLightArrowsToggleButton, (Object)null);
/* 69 */     add(this.drawAllFlashesToggleButton, (Object)null);
/* 70 */     add(this.floodLightToggleButton, (Object)null);
/* 71 */     add(this.alwaysCenterToggleButton, (Object)null);
/* 72 */     add(this.lightningMouseToggleButton, (Object)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void settingsChanged(Object src) {
/* 77 */     setVisible((Settings.getMode() == 0));
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\SettingsToolBar.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */