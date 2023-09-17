/*    */ package com.vadosity.vnav.client;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JToolBar;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.border.Border;
/*    */ 
/*    */ public class NavigationToolBar extends JToolBar {
/*  8 */   FirstButton firstButton = new FirstButton();
/*  9 */   LastButton lastButton = new LastButton();
/* 10 */   PreviousButton previousButton = new PreviousButton();
/* 11 */   NextButton nextButton = new NextButton();
/* 12 */   SlowToggleButton slowToggleButton = new SlowToggleButton();
/* 13 */   StopButton stopToggleButton = new StopButton();
/* 14 */   WalkToggleButton walkToggleButton = new WalkToggleButton();
/* 15 */   RunToggleButton runToggleButton = new RunToggleButton();
/*    */ 
/*    */   
/*    */   public NavigationToolBar() {
/*    */     try {
/* 20 */       jbInit();
/* 21 */       String nativeLF = UIManager.getSystemLookAndFeelClassName();
/* 22 */       UIManager.setLookAndFeel(nativeLF);
/* 23 */       SwingUtilities.updateComponentTreeUI(this);
/*    */     
/*    */     }
/* 26 */     catch (Exception e) {
/* 27 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 34 */     this.firstButton.setText("");
/* 35 */     this.firstButton.setPreferredSize(new Dimension(35, 35));
/* 36 */     this.firstButton.setToolTipText("Go to First");
/* 37 */     this.firstButton.setMinimumSize(new Dimension(35, 35));
/* 38 */     this.firstButton.setMaximumSize(new Dimension(35, 35));
/* 39 */     this.lastButton.setMaximumSize(new Dimension(35, 35));
/* 40 */     this.lastButton.setMinimumSize(new Dimension(35, 35));
/* 41 */     this.lastButton.setPreferredSize(new Dimension(35, 35));
/* 42 */     this.lastButton.setToolTipText("Go to Last");
/* 43 */     this.lastButton.setText("");
/* 44 */     this.previousButton.setMaximumSize(new Dimension(35, 35));
/* 45 */     this.previousButton.setMinimumSize(new Dimension(35, 35));
/* 46 */     this.previousButton.setPreferredSize(new Dimension(35, 35));
/* 47 */     this.previousButton.setToolTipText("Go to Previous");
/* 48 */     this.previousButton.setText("");
/* 49 */     this.nextButton.setMaximumSize(new Dimension(35, 35));
/* 50 */     this.nextButton.setMinimumSize(new Dimension(35, 35));
/* 51 */     this.nextButton.setPreferredSize(new Dimension(35, 35));
/* 52 */     this.nextButton.setToolTipText("Go to Next");
/* 53 */     this.nextButton.setText("");
/*    */     
/* 55 */     this.slowToggleButton.setBorder((Border)null);
/* 56 */     this.slowToggleButton.setMaximumSize(new Dimension(35, 35));
/* 57 */     this.slowToggleButton.setMinimumSize(new Dimension(35, 35));
/* 58 */     this.slowToggleButton.setPreferredSize(new Dimension(35, 35));
/* 59 */     this.slowToggleButton.setText("");
/*    */     
/* 61 */     this.stopToggleButton.setBorder((Border)null);
/* 62 */     this.stopToggleButton.setMaximumSize(new Dimension(35, 35));
/* 63 */     this.stopToggleButton.setMinimumSize(new Dimension(35, 35));
/* 64 */     this.stopToggleButton.setPreferredSize(new Dimension(35, 35));
/* 65 */     this.stopToggleButton.setText("");
/* 66 */     this.walkToggleButton.setMaximumSize(new Dimension(35, 35));
/* 67 */     this.walkToggleButton.setMinimumSize(new Dimension(35, 35));
/* 68 */     this.walkToggleButton.setPreferredSize(new Dimension(35, 35));
/* 69 */     this.walkToggleButton.setText("");
/* 70 */     this.runToggleButton.setMaximumSize(new Dimension(35, 35));
/* 71 */     this.runToggleButton.setMinimumSize(new Dimension(35, 35));
/* 72 */     this.runToggleButton.setPreferredSize(new Dimension(35, 35));
/* 73 */     this.runToggleButton.setText("");
/*    */     
/* 75 */     add(this.firstButton, (Object)null);
/* 76 */     add(this.previousButton, (Object)null);
/* 77 */     add(this.nextButton, (Object)null);
/* 78 */     add(this.lastButton, (Object)null);
/* 79 */     add(this.slowToggleButton, (Object)null);
/* 80 */     add(this.walkToggleButton, (Object)null);
/* 81 */     add(this.runToggleButton, (Object)null);
/* 82 */     add(this.stopToggleButton, (Object)null);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\NavigationToolBar.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */