/*    */ package com.vadosity.vnav.client;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.GridBagConstraints;
/*    */ import java.awt.GridBagLayout;
/*    */ import java.awt.Insets;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JToolBar;
/*    */ 
/*    */ public class MultiPanel extends JPanel {
/* 11 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/* 12 */   AnglePanel anglePanel = new AnglePanel();
/* 13 */   FullCircleCheckBox ckFullCircle = new FullCircleCheckBox();
/* 14 */   CounterClockwiseRadioButton radioCounterClockwise = new CounterClockwiseRadioButton();
/* 15 */   ClockwiseRadioButton radioClockwise = new ClockwiseRadioButton();
/* 16 */   JToolBar toolBarStartAngle = new JToolBar();
/* 17 */   JToolBar tb = new JToolBar();
/* 18 */   JPanel panelToolBar = new JPanel();
/* 19 */   GridBagLayout gridBagLayout2 = new GridBagLayout();
/* 20 */   GridLayout gridLayout1 = new GridLayout();
/*    */   
/*    */   public MultiPanel() {
/*    */     try {
/* 24 */       jbInit();
/* 25 */       MultiPanelInitializer mpi = new MultiPanelInitializer(this);
/* 26 */       mpi.start();
/*    */     }
/* 28 */     catch (Exception e) {
/* 29 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void jbInit() throws Exception {
/* 35 */     setLayout(this.gridBagLayout1);
/* 36 */     setBorder(BorderFactory.createRaisedBevelBorder());
/* 37 */     this.radioClockwise.setText("Clockwise");
/* 38 */     this.radioClockwise.setFont(new Font("Dialog", 0, 11));
/* 39 */     this.radioClockwise.setSelected(true);
/* 40 */     this.ckFullCircle.setFont(new Font("Dialog", 0, 11));
/* 41 */     this.ckFullCircle.setText("Full Circle");
/*    */     
/* 43 */     this.anglePanel.setPreferredSize(new Dimension(160, 160));
/* 44 */     this.anglePanel.setLayout(this.gridBagLayout2);
/* 45 */     this.toolBarStartAngle.setPreferredSize(new Dimension(160, 160));
/* 46 */     this.toolBarStartAngle.setMargin(new Insets(5, 5, 5, 5));
/* 47 */     this.panelToolBar.setPreferredSize(new Dimension(200, 200));
/* 48 */     this.panelToolBar.setLayout(this.gridLayout1);
/*    */     
/* 50 */     this.anglePanel.setMinimumSize(new Dimension(160, 160));
/* 51 */     this.toolBarStartAngle.setAlignmentX(1.0F);
/* 52 */     this.toolBarStartAngle.setAlignmentY(1.0F);
/* 53 */     this.toolBarStartAngle.setBorder((Border)null);
/* 54 */     this.toolBarStartAngle.setMinimumSize(new Dimension(160, 160));
/* 55 */     this.panelToolBar.setMinimumSize(new Dimension(200, 200));
/* 56 */     this.anglePanel.setBorder(BorderFactory.createLoweredBevelBorder());
/* 57 */     this.anglePanel.setMaximumSize(new Dimension(32767, 32767));
/* 58 */     this.radioCounterClockwise.setFont(new Font("Dialog", 0, 11));
/* 59 */     this.radioCounterClockwise.setText("Counter Clockwise");
/* 60 */     add(this.radioClockwise, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 61 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 62 */     add(this.radioCounterClockwise, new GridBagConstraints(1, 0, 2, 1, 0.0D, 0.0D, 
/* 63 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 64 */     add(this.ckFullCircle, new GridBagConstraints(0, 1, 2, 1, 0.0D, 0.0D, 
/* 65 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 66 */     add(this.panelToolBar, new GridBagConstraints(0, 2, 3, 1, 0.0D, 0.0D, 
/* 67 */           17, 0, new Insets(5, 5, 5, 5), -18, -48));
/* 68 */     this.panelToolBar.add(this.toolBarStartAngle, (Object)null);
/* 69 */     this.toolBarStartAngle.add(this.anglePanel);
/*    */     
/* 71 */     this.panelToolBar.setLayout(new BorderLayout());
/* 72 */     this.panelToolBar.add(this.toolBarStartAngle, "Center");
/*    */ 
/*    */ 
/*    */     
/* 76 */     this.toolBarStartAngle.setFloatable(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\MultiPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */