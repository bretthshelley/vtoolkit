/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.event.TreeSelectionEvent;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.DefaultTreeCellRenderer;
/*     */ import javax.swing.tree.TreePath;
/*     */ 
/*     */ public class TourTreePanel extends JPanel implements GlobalChangeListener {
/*  16 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  17 */   JScrollPane jScrollPane1 = new JScrollPane();
/*  18 */   JTree treeTour = new JTree();
/*  19 */   JCheckBox ckOrderByPoints = new JCheckBox();
/*  20 */   JPopupMenu pm = new JPopupMenu();
/*  21 */   JMenuItem miDeleteNode = new JMenuItem();
/*  22 */   String rootNodeName = "Tour";
/*  23 */   ImageIcon leafIcon = null;
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
/*     */   private boolean activated;
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
/*     */   public TourTreePanel() {
/*  46 */     this.activated = false; try { jbInit(); Global.addGlobalChangeListener(this); this.leafIcon = new ImageIcon(ImageUtil.loadFootstepImage()); DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer(); renderer.setLeafIcon(this.leafIcon); this.treeTour.setCellRenderer(renderer); } catch (Exception e) { e.printStackTrace(); }
/*  47 */      } public boolean isActivated() { return this.activated; }
/*     */   
/*     */   public void setActivated(boolean b) {
/*  50 */     if (b) {
/*     */ 
/*     */       
/*  53 */       Global.addGlobalChangeListener(this);
/*  54 */       setupTree();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  59 */       Global.removeGlobalChangeListener(this);
/*     */     } 
/*  61 */     this.activated = b;
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/*  65 */     setLayout(this.gridBagLayout1);
/*  66 */     this.jScrollPane1.setMinimumSize(new Dimension(300, 300));
/*  67 */     this.jScrollPane1.setPreferredSize(new Dimension(300, 300));
/*  68 */     this.ckOrderByPoints.setToolTipText("");
/*  69 */     this.ckOrderByPoints.setText("Group By Points");
/*  70 */     this.ckOrderByPoints.addActionListener(new TourTreePanel_ckOrderByPoints_actionAdapter(this));
/*  71 */     this.miDeleteNode.setText("Delete");
/*  72 */     this.miDeleteNode.addActionListener(new TourTreePanel_miDeleteNode_actionAdapter(this));
/*  73 */     add(this.jScrollPane1, new GridBagConstraints(0, 1, 1, 1, 1.0D, 1.0D, 
/*  74 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/*  75 */     this.jScrollPane1.getViewport().add(this.treeTour, (Object)null);
/*  76 */     add(this.ckOrderByPoints, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/*  77 */           18, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  78 */     this.pm.add(this.miDeleteNode);
/*     */     
/*  80 */     setupTree();
/*     */     
/*  82 */     this.treeTour.addTreeSelectionListener(new TourTreePanel_treeTour_treeSelectionAdapter(this));
/*  83 */     this.treeTour.addMouseListener(new TourTreePanel_treeTour_mouseAdapter(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupTree() {
/*  89 */     if (this.treeTour.getModel() != null)
/*     */     {
/*     */       
/*  92 */       this.treeTour.setModel((TreeModel)null);
/*     */     }
/*     */ 
/*     */     
/*  96 */     DefaultMutableTreeNode root = new DefaultMutableTreeNode(this.rootNodeName);
/*     */     
/*  98 */     TourTreeModel treeModel = new TourTreeModel(root);
/*  99 */     treeModel.setOrderByPoints(this.ckOrderByPoints.isSelected());
/* 100 */     treeModel.setup();
/* 101 */     this.treeTour.setModel(treeModel);
/* 102 */     this.treeTour.updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void ckOrderByPoints_actionPerformed(ActionEvent e) {
/* 108 */     setupTree();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void tourChanged(Tour selectedTour, Object src) {
/* 114 */     if (src == null)
/* 115 */       return;  if (src == this || src.getClass().equals(getClass()))
/* 116 */       return;  setupTree();
/*     */   }
/*     */ 
/*     */   
/*     */   public void viewChanged(View selectedView, Object src) {
/* 121 */     if (Global.getTour() == null)
/* 122 */       return;  if (src == this)
/*     */       return; 
/* 124 */     setupTree();
/*     */ 
/*     */     
/* 127 */     DefaultMutableTreeNode tourRoot = (DefaultMutableTreeNode)this.treeTour.getModel().getRoot();
/*     */ 
/*     */ 
/*     */     
/* 131 */     int viewIndex = Global.getTour().getViews().indexOf(Global.getView());
/* 132 */     if (viewIndex == -1) viewIndex = 0; 
/* 133 */     TreePath path = null;
/* 134 */     if (tourRoot.getChildCount() == 0) {
/*     */       
/* 136 */       path = new TreePath(tourRoot);
/* 137 */       this.treeTour.setSelectionPath(path);
/* 138 */       this.treeTour.scrollPathToVisible(path);
/* 139 */       this.treeTour.updateUI();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 144 */     DefaultMutableTreeNode viewNode = (DefaultMutableTreeNode)tourRoot.getChildAt(viewIndex);
/* 145 */     path = new TreePath(new Object[] { tourRoot, viewNode });
/* 146 */     this.treeTour.setSelectionPath(path);
/* 147 */     this.treeTour.scrollPathToVisible(path);
/* 148 */     this.treeTour.updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {
/* 154 */     if (selectedPhoto == null || Global.getTour() == null || Global.getView() == null)
/* 155 */       return;  if (src == this) {
/*     */       return;
/*     */     }
/*     */     try {
/* 159 */       if (Global.getPhoto() == null) {
/*     */         return;
/*     */       }
/*     */       
/* 163 */       DefaultMutableTreeNode tourRoot = (DefaultMutableTreeNode)this.treeTour.getModel().getRoot();
/*     */ 
/*     */       
/* 166 */       int viewIndex = Global.getTour().getViews().indexOf(Global.getView());
/* 167 */       if (viewIndex < 0) viewIndex = 0; 
/* 168 */       DefaultMutableTreeNode viewNode = (DefaultMutableTreeNode)tourRoot.getChildAt(viewIndex);
/*     */       
/* 170 */       TreePath path = null;
/* 171 */       if (viewNode.getChildCount() == 0) {
/*     */         return;
/*     */       }
/*     */       
/* 175 */       if (this.ckOrderByPoints.isSelected()) {
/*     */ 
/*     */         
/* 178 */         int photoIndex = Global.getView().getPhotos().indexOf(Global.getPhoto());
/* 179 */         if (photoIndex < 0) photoIndex = 0; 
/* 180 */         DefaultMutableTreeNode photoNode = (DefaultMutableTreeNode)viewNode.getChildAt(photoIndex);
/* 181 */         path = new TreePath(new Object[] { tourRoot, viewNode, photoNode });
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 186 */         int ptIndex = ((Vector)Global.getView().getVPhotoPoints()).indexOf(Global.getPhotoPoint());
/* 187 */         if (ptIndex < 0) ptIndex = 0; 
/* 188 */         DefaultMutableTreeNode ptNode = (DefaultMutableTreeNode)viewNode.getChildAt(ptIndex);
/*     */         
/* 190 */         int photoIndex = Global.getPhotoPoint().getVPhotos().indexOf(Global.getPhoto());
/* 191 */         if (photoIndex < 0) photoIndex = 0;
/*     */         
/*     */         try {
/* 194 */           DefaultMutableTreeNode photoNode = (DefaultMutableTreeNode)ptNode.getChildAt(photoIndex);
/* 195 */           path = new TreePath(new Object[] { tourRoot, viewNode, ptNode, photoNode });
/*     */         }
/* 197 */         catch (Exception e) {
/*     */           
/* 199 */           path = new TreePath(new Object[] { tourRoot, viewNode, ptNode });
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 204 */       this.treeTour.setSelectionPath(path);
/* 205 */       this.treeTour.scrollPathToVisible(path);
/* 206 */       this.treeTour.updateUI();
/*     */     
/*     */     }
/* 209 */     catch (Exception e) {
/*     */       
/* 211 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {
/* 217 */     if (src == this)
/* 218 */       return;  setupTree();
/*     */   }
/*     */ 
/*     */   
/*     */   void treeTour_valueChanged(TreeSelectionEvent e) {
/* 223 */     TreePath path = e.getNewLeadSelectionPath();
/* 224 */     if (path == null || path.getLastPathComponent() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 228 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
/* 229 */     Photo pathPhoto = null;
/* 230 */     PhotoPoint pathPhotoPoint = null;
/* 231 */     View pathView = null;
/*     */     
/* 233 */     Object userObject = node.getUserObject();
/* 234 */     if (userObject instanceof Tour) {
/*     */       return;
/*     */     }
/*     */     
/* 238 */     if (userObject instanceof View) {
/*     */       
/* 240 */       pathView = (View)userObject;
/* 241 */       PhotoPoint pt = pathView.getFirstPhotoPoint();
/* 242 */       Photo photo = (pt == null) ? null : pt.getFirstPhoto();
/*     */       
/* 244 */       Global.setView(pathView, this);
/* 245 */       Global.setPhotoPoint(pt, this);
/* 246 */       Global.setPhoto(photo, this);
/*     */       return;
/*     */     } 
/* 249 */     if (userObject instanceof PhotoPoint) {
/*     */ 
/*     */ 
/*     */       
/* 253 */       pathPhotoPoint = (PhotoPoint)userObject;
/* 254 */       pathPhoto = pathPhotoPoint.getFirstPhoto();
/*     */       
/* 256 */       DefaultMutableTreeNode parent = (DefaultMutableTreeNode)node.getParent();
/* 257 */       pathView = (View)parent.getUserObject();
/*     */     }
/* 259 */     else if (userObject instanceof Photo) {
/*     */ 
/*     */ 
/*     */       
/* 263 */       pathPhoto = (Photo)userObject;
/*     */       
/* 265 */       DefaultMutableTreeNode parent = (DefaultMutableTreeNode)node.getParent();
/* 266 */       if (parent.getUserObject() instanceof PhotoPoint) {
/*     */         
/* 268 */         pathPhotoPoint = (PhotoPoint)parent.getUserObject();
/* 269 */         pathView = (View)((DefaultMutableTreeNode)parent.getParent()).getUserObject();
/*     */       }
/* 271 */       else if (parent.getUserObject() instanceof View) {
/*     */         
/* 273 */         pathView = (View)parent.getUserObject();
/* 274 */         pathPhotoPoint = pathPhoto.getPhotoPoint();
/*     */       } 
/*     */     } 
/*     */     
/* 278 */     if (pathView != null && !pathView.equals(Global.getView()))
/*     */     {
/*     */       
/* 281 */       Global.setView(pathView, this);
/*     */     }
/* 283 */     if (pathPhotoPoint != null && !pathPhotoPoint.equals(Global.getPhotoPoint()))
/*     */     {
/*     */       
/* 286 */       Global.setPhotoPoint(pathPhotoPoint, this);
/*     */     }
/* 288 */     if (pathPhoto == null || pathPhoto.equals(Global.getPhoto())) {
/*     */       
/* 290 */       if (pathPhoto == null) Global.setPhoto(null, this); 
/*     */     } else {
/* 292 */       Global.setPhoto(pathPhoto, this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void miDeleteNode_actionPerformed(ActionEvent e) {
/* 300 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)this.treeTour.getSelectionPath().getLastPathComponent();
/*     */     
/* 302 */     Object userObject = node.getUserObject();
/*     */ 
/*     */     
/* 305 */     if (userObject instanceof View) {
/*     */ 
/*     */       
/* 308 */       Global.getTour().remove((View)userObject);
/* 309 */       Global.getTour().getViews().remove(userObject);
/*     */       
/* 311 */       ((DefaultMutableTreeNode)node.getParent()).remove(node);
/* 312 */       this.treeTour.updateUI();
/*     */       
/* 314 */       if (Global.getTour().getViews().size() > 0)
/*     */       {
/* 316 */         Global.setView(Global.getTour().getViews().elementAt(0), this);
/* 317 */         Global.setPhotoPoint(Global.getView().getFirstPhotoPoint(), this);
/* 318 */         Global.setPhoto(Global.getPhotoPoint().getFirstPhoto(), this);
/*     */       }
/*     */       else
/*     */       {
/* 322 */         Global.setView(null, this);
/* 323 */         Global.setPhotoPoint(null, this);
/* 324 */         Global.setPhoto(null, this);
/*     */       }
/*     */     
/* 327 */     } else if (userObject instanceof PhotoPoint) {
/*     */ 
/*     */       
/* 330 */       Global.getView().getVPhotoPoints().remove(userObject);
/*     */       
/* 332 */       for (int i = 0; i < ((PhotoPoint)userObject).getVPhotos().size(); i++)
/*     */       {
/* 334 */         Global.getView().getPhotos().remove(((PhotoPoint)userObject).getVPhotos().elementAt(i));
/*     */       }
/* 336 */       ((DefaultMutableTreeNode)node.getParent()).remove(node);
/* 337 */       this.treeTour.updateUI();
/*     */ 
/*     */       
/* 340 */       if (Global.getView().getVPhotoPoints().size() > 0)
/*     */       {
/* 342 */         Global.fireSelectedViewChanged(this);
/* 343 */         Global.setPhotoPoint(Global.getView().getFirstPhotoPoint(), this);
/* 344 */         Global.setPhoto(Global.getPhotoPoint().getFirstPhoto(), this);
/*     */       }
/*     */       else
/*     */       {
/* 348 */         Global.fireSelectedViewChanged(this);
/* 349 */         Global.setPhotoPoint(null, this);
/* 350 */         Global.setPhoto(null, this);
/*     */       }
/*     */     
/* 353 */     } else if (userObject instanceof Photo) {
/*     */ 
/*     */       
/* 356 */       Global.getView().getPhotos().remove(userObject);
/* 357 */       Global.getPhotoPoint().remove((Photo)userObject);
/*     */ 
/*     */       
/* 360 */       DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)node.getParent();
/* 361 */       ((DefaultMutableTreeNode)node.getParent()).remove(node);
/*     */ 
/*     */       
/* 364 */       if (Global.getPhotoPoint().getFirstPhoto() == null) {
/*     */ 
/*     */         
/* 367 */         Global.getView().getVPhotoPoints().remove(Global.getPhotoPoint());
/*     */         
/* 369 */         if (parentNode.getUserObject() instanceof PhotoPoint)
/*     */         {
/*     */           
/* 372 */           ((DefaultMutableTreeNode)parentNode.getParent()).remove(parentNode);
/*     */         }
/*     */       } 
/* 375 */       this.treeTour.updateUI();
/* 376 */       Global.selectNextPhotoPoint(this);
/* 377 */       Global.selectNextPhoto(this);
/*     */     } 
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
/*     */   void treeTour_mouseReleased(MouseEvent e) {
/* 390 */     if (e.isPopupTrigger())
/*     */     {
/* 392 */       this.pm.show(this, e.getX(), e.getY());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\TourTreePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */