/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.TreeNode;
/*     */ 
/*     */ public class TourTreeModel extends DefaultTreeModel {
/*  11 */   public boolean getOrderByPoints() { return this.orderByPoints; } private boolean orderByPoints = false; public void setOrderByPoints(boolean b) {
/*  12 */     this.orderByPoints = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public TourTreeModel(TreeNode root) {
/*  17 */     super(root);
/*  18 */     setup();
/*     */   }
/*     */ 
/*     */   
/*     */   public TourTreeModel(TreeNode root, boolean asksAllowsChildren) {
/*  23 */     super(root, asksAllowsChildren);
/*  24 */     setup();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setup() {
/*  29 */     DefaultMutableTreeNode root = null;
/*     */ 
/*     */     
/*  32 */     if (Global.getTour() == null) {
/*     */       
/*  34 */       root = new DefaultMutableTreeNode("No Tour Loaded");
/*  35 */       setRoot(root);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  41 */     root = new DefaultMutableTreeNode(Global.getTour());
/*  42 */     setupViewNodes(root);
/*     */ 
/*     */     
/*  45 */     setRoot(root);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setupPhotoNodes(DefaultMutableTreeNode viewNode, View view) {
/*  51 */     if (viewNode == null || view == null)
/*     */       return; 
/*  53 */     Iterator it = view.getPhotos().iterator();
/*     */     
/*  55 */     int i = 0;
/*  56 */     Photo ithPhoto = null;
/*  57 */     while (it.hasNext()) {
/*     */       
/*  59 */       ithPhoto = it.next();
/*  60 */       if (ithPhoto == null)
/*  61 */         continue;  DefaultMutableTreeNode node = new DefaultMutableTreeNode(ithPhoto);
/*  62 */       viewNode.add(node);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setupPhotoNodes(DefaultMutableTreeNode photoPointNode, PhotoPoint pt) {
/*  69 */     if (photoPointNode == null || pt == null || pt.getVPhotos() == null)
/*     */       return; 
/*  71 */     Iterator it = pt.getVPhotos().iterator();
/*     */     
/*  73 */     int i = 0;
/*  74 */     Photo ithPhoto = null;
/*  75 */     while (it.hasNext()) {
/*     */       
/*  77 */       ithPhoto = it.next();
/*  78 */       DefaultMutableTreeNode node = new DefaultMutableTreeNode(ithPhoto);
/*  79 */       photoPointNode.add(node);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setupPhotoPointNodes(DefaultMutableTreeNode viewNode, View view) {
/*  86 */     if (viewNode == null || view == null)
/*     */       return; 
/*  88 */     Iterator it = view.getVPhotoPoints().iterator();
/*     */     
/*  90 */     int i = 0;
/*  91 */     while (it.hasNext()) {
/*     */       
/*  93 */       PhotoPoint ithPt = it.next();
/*  94 */       DefaultMutableTreeNode node = new DefaultMutableTreeNode(ithPt);
/*  95 */       setupPhotoNodes(node, ithPt);
/*  96 */       viewNode.add(node);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setupViewNodes(DefaultMutableTreeNode root) {
/* 103 */     if (root == null) {
/*     */       return;
/*     */     }
/*     */     
/* 107 */     if (Global.getTour().getViews() == null || 
/* 108 */       Global.getTour().getViews().size() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 114 */     Vector views = Global.getTour().getViews();
/* 115 */     for (int i = 0; i < views.size(); i++) {
/*     */       
/* 117 */       View view = views.elementAt(i);
/* 118 */       DefaultMutableTreeNode ithViewNode = new DefaultMutableTreeNode(view);
/* 119 */       if (!this.orderByPoints) { setupPhotoNodes(ithViewNode, view); }
/* 120 */       else { setupPhotoPointNodes(ithViewNode, view); }
/* 121 */        root.add(ithViewNode);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\TourTreeModel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */