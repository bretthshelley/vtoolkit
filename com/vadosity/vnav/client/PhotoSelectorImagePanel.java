/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ public class PhotoSelectorImagePanel extends ScaledImagePanel implements GlobalChangeListener {
/*  12 */   private byte[] imageBytes = null;
/*     */   
/*  14 */   private Point mouse = null;
/*  15 */   public Point getMouse() { return this.mouse; } public void setMouse(Point pt) {
/*  16 */     this.mouse = pt;
/*     */   }
/*  18 */   private Point lastPt = null;
/*  19 */   private Point originPt = null;
/*     */   private boolean mouseBeingDragged = false;
/*     */   
/*  22 */   public boolean isMouseBeingDragged() { return this.mouseBeingDragged; } public void setMouseBeingDragged(boolean b) {
/*  23 */     this.mouseBeingDragged = b;
/*     */   }
/*     */   
/*  26 */   private ViewImagePanel viewImagePanel = null;
/*  27 */   private ToolkitContentPane toolkitContentPane = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public PhotoSelectorImagePanel() {
/*     */     try {
/*  33 */       jbInit();
/*  34 */       Global.addGlobalChangeListener(this);
/*     */     }
/*  36 */     catch (Exception e) {
/*  37 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   private void jbInit() throws Exception {
/*  41 */     addMouseMotionListener(new PhotoSelectorImagePanel_this_mouseMotionAdapter(this));
/*  42 */     addMouseListener(new PhotoSelectorImagePanel_this_mouseAdapter(this));
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
/*     */   public void tourChanged(Tour selectedTour, Object src) {
/*  60 */     if (selectedTour == null) {
/*     */       
/*  62 */       setImage((Image)null);
/*  63 */       updateUI();
/*     */     } 
/*     */   }
/*     */   public void viewChanged(View selectedView, Object src) {}
/*     */   public void photoChanged(Photo selectedPhoto, Object src) {}
/*     */   
/*     */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {}
/*     */   
/*     */   void this_mouseClicked(MouseEvent e) {
/*  72 */     if (e.getClickCount() < 2)
/*  73 */       return;  if (Global.getPhoto() == null)
/*  74 */       return;  if (this.imageBytes == null)
/*  75 */       return;  Global.getPhoto().setBytes(this.imageBytes);
/*  76 */     Global.fireSelectedPhotoChanged(this);
/*     */   }
/*     */   public byte[] getImageBytes() {
/*  79 */     return this.imageBytes;
/*     */   }
/*     */   public void setImageBytes(byte[] bytes) {
/*  82 */     if (bytes == null)
/*  83 */       return;  this.imageBytes = bytes;
/*  84 */     Image im = Toolkit.getDefaultToolkit().createImage(bytes);
/*  85 */     setImage(im);
/*  86 */     updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void findToolkitContentPane() {
/*  92 */     Container parent = null;
/*  93 */     Component child = this;
/*  94 */     while ((parent = child.getParent()) != null) {
/*     */       
/*  96 */       if (parent instanceof ToolkitContentPane) {
/*     */         
/*  98 */         this.toolkitContentPane = (ToolkitContentPane)parent;
/*     */         return;
/*     */       } 
/* 101 */       child = parent;
/*     */     } 
/* 103 */     throw new IllegalStateException("Unable to locate mouse drag util panel");
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
/*     */   
/*     */   void this_mouseDragged(MouseEvent e) {
/*     */     // Byte code:
/*     */     //   0: invokestatic getPhoto : ()Lcom/vadosity/vnav/bean/Photo;
/*     */     //   3: ifnull -> 16
/*     */     //   6: aconst_null
/*     */     //   7: aload_0
/*     */     //   8: invokestatic setPhoto : (Lcom/vadosity/vnav/bean/Photo;Ljava/lang/Object;)V
/*     */     //   11: aconst_null
/*     */     //   12: aload_0
/*     */     //   13: invokestatic setPhotoPoint : (Lcom/vadosity/vnav/bean/PhotoPoint;Ljava/lang/Object;)V
/*     */     //   16: aload_0
/*     */     //   17: aload_1
/*     */     //   18: invokevirtual getPoint : ()Ljava/awt/Point;
/*     */     //   21: putfield mouse : Ljava/awt/Point;
/*     */     //   24: aload_0
/*     */     //   25: iconst_1
/*     */     //   26: putfield mouseBeingDragged : Z
/*     */     //   29: aload_0
/*     */     //   30: getfield toolkitContentPane : Lcom/vadosity/vnav/client/ToolkitContentPane;
/*     */     //   33: ifnonnull -> 40
/*     */     //   36: aload_0
/*     */     //   37: invokespecial findToolkitContentPane : ()V
/*     */     //   40: aload_0
/*     */     //   41: aload_1
/*     */     //   42: invokevirtual getPoint : ()Ljava/awt/Point;
/*     */     //   45: aload_0
/*     */     //   46: getfield toolkitContentPane : Lcom/vadosity/vnav/client/ToolkitContentPane;
/*     */     //   49: invokestatic convertPoint : (Ljava/awt/Component;Ljava/awt/Point;Ljava/awt/Component;)Ljava/awt/Point;
/*     */     //   52: astore_2
/*     */     //   53: aload_0
/*     */     //   54: getfield toolkitContentPane : Lcom/vadosity/vnav/client/ToolkitContentPane;
/*     */     //   57: aload_2
/*     */     //   58: invokevirtual setMouse : (Ljava/awt/Point;)V
/*     */     //   61: aload_0
/*     */     //   62: getfield toolkitContentPane : Lcom/vadosity/vnav/client/ToolkitContentPane;
/*     */     //   65: iconst_1
/*     */     //   66: invokevirtual setMouseBeingDragged : (Z)V
/*     */     //   69: aload_0
/*     */     //   70: getfield toolkitContentPane : Lcom/vadosity/vnav/client/ToolkitContentPane;
/*     */     //   73: invokevirtual updateUI : ()V
/*     */     //   76: invokestatic getInstance : ()Lcom/vadosity/vnav/client/MultiPhotoUtil;
/*     */     //   79: invokevirtual getAngles : ()[D
/*     */     //   82: astore_3
/*     */     //   83: invokestatic getPhoto : ()Lcom/vadosity/vnav/bean/Photo;
/*     */     //   86: ifnonnull -> 322
/*     */     //   89: aload_3
/*     */     //   90: ifnull -> 322
/*     */     //   93: aload_3
/*     */     //   94: arraylength
/*     */     //   95: iconst_1
/*     */     //   96: if_icmpeq -> 111
/*     */     //   99: aload_3
/*     */     //   100: arraylength
/*     */     //   101: iconst_2
/*     */     //   102: if_icmpne -> 322
/*     */     //   105: invokestatic isFullCircle : ()Z
/*     */     //   108: ifeq -> 322
/*     */     //   111: aload_0
/*     */     //   112: getfield lastPt : Ljava/awt/Point;
/*     */     //   115: ifnonnull -> 126
/*     */     //   118: aload_0
/*     */     //   119: aload_1
/*     */     //   120: invokevirtual getPoint : ()Ljava/awt/Point;
/*     */     //   123: putfield lastPt : Ljava/awt/Point;
/*     */     //   126: aload_0
/*     */     //   127: getfield originPt : Ljava/awt/Point;
/*     */     //   130: ifnonnull -> 144
/*     */     //   133: aload_0
/*     */     //   134: aload_1
/*     */     //   135: invokevirtual getPoint : ()Ljava/awt/Point;
/*     */     //   138: putfield originPt : Ljava/awt/Point;
/*     */     //   141: goto -> 322
/*     */     //   144: aload_0
/*     */     //   145: getfield lastPt : Ljava/awt/Point;
/*     */     //   148: getfield x : I
/*     */     //   151: i2d
/*     */     //   152: aload_0
/*     */     //   153: getfield lastPt : Ljava/awt/Point;
/*     */     //   156: getfield y : I
/*     */     //   159: i2d
/*     */     //   160: aload_1
/*     */     //   161: invokevirtual getX : ()I
/*     */     //   164: i2d
/*     */     //   165: aload_1
/*     */     //   166: invokevirtual getY : ()I
/*     */     //   169: i2d
/*     */     //   170: invokestatic distance : (DDDD)D
/*     */     //   173: dstore #4
/*     */     //   175: dload #4
/*     */     //   177: ldc2_w 10.0
/*     */     //   180: dcmpl
/*     */     //   181: ifle -> 322
/*     */     //   184: invokestatic getStartAngle : ()D
/*     */     //   187: dstore #6
/*     */     //   189: aload_1
/*     */     //   190: invokevirtual getY : ()I
/*     */     //   193: aload_0
/*     */     //   194: getfield lastPt : Ljava/awt/Point;
/*     */     //   197: getfield y : I
/*     */     //   200: isub
/*     */     //   201: i2d
/*     */     //   202: aload_1
/*     */     //   203: invokevirtual getX : ()I
/*     */     //   206: aload_0
/*     */     //   207: getfield lastPt : Ljava/awt/Point;
/*     */     //   210: getfield x : I
/*     */     //   213: isub
/*     */     //   214: i2d
/*     */     //   215: invokestatic atan2 : (DD)D
/*     */     //   218: dstore #8
/*     */     //   220: dload #6
/*     */     //   222: dload #8
/*     */     //   224: invokestatic angularDiff : (DD)D
/*     */     //   227: dstore #10
/*     */     //   229: dload #10
/*     */     //   231: ldc2_w 20.0
/*     */     //   234: invokestatic toRadians : (D)D
/*     */     //   237: dcmpg
/*     */     //   238: ifge -> 275
/*     */     //   241: aload_1
/*     */     //   242: invokevirtual getY : ()I
/*     */     //   245: aload_0
/*     */     //   246: getfield originPt : Ljava/awt/Point;
/*     */     //   249: getfield y : I
/*     */     //   252: isub
/*     */     //   253: i2d
/*     */     //   254: aload_1
/*     */     //   255: invokevirtual getX : ()I
/*     */     //   258: aload_0
/*     */     //   259: getfield originPt : Ljava/awt/Point;
/*     */     //   262: getfield x : I
/*     */     //   265: isub
/*     */     //   266: i2d
/*     */     //   267: invokestatic atan2 : (DD)D
/*     */     //   270: dstore #8
/*     */     //   272: goto -> 283
/*     */     //   275: aload_0
/*     */     //   276: aload_1
/*     */     //   277: invokevirtual getPoint : ()Ljava/awt/Point;
/*     */     //   280: putfield originPt : Ljava/awt/Point;
/*     */     //   283: dload #8
/*     */     //   285: invokestatic setStartAngle : (D)V
/*     */     //   288: aload_3
/*     */     //   289: arraylength
/*     */     //   290: iconst_2
/*     */     //   291: if_icmpne -> 310
/*     */     //   294: invokestatic isFullCircle : ()Z
/*     */     //   297: ifeq -> 310
/*     */     //   300: invokestatic getStartAngle : ()D
/*     */     //   303: ldc2_w 3.141592653589793
/*     */     //   306: dadd
/*     */     //   307: invokestatic setFinishAngle : (D)V
/*     */     //   310: aload_0
/*     */     //   311: invokestatic fireSettingsChanged : (Ljava/lang/Object;)V
/*     */     //   314: aload_0
/*     */     //   315: aload_1
/*     */     //   316: invokevirtual getPoint : ()Ljava/awt/Point;
/*     */     //   319: putfield lastPt : Ljava/awt/Point;
/*     */     //   322: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #110	-> 0
/*     */     //   #112	-> 6
/*     */     //   #113	-> 11
/*     */     //   #117	-> 16
/*     */     //   #118	-> 24
/*     */     //   #121	-> 29
/*     */     //   #123	-> 40
/*     */     //   #124	-> 53
/*     */     //   #125	-> 61
/*     */     //   #126	-> 69
/*     */     //   #130	-> 76
/*     */     //   #131	-> 83
/*     */     //   #132	-> 89
/*     */     //   #134	-> 93
/*     */     //   #136	-> 99
/*     */     //   #139	-> 111
/*     */     //   #140	-> 126
/*     */     //   #144	-> 144
/*     */     //   #145	-> 175
/*     */     //   #147	-> 184
/*     */     //   #148	-> 189
/*     */     //   #149	-> 220
/*     */     //   #152	-> 229
/*     */     //   #154	-> 241
/*     */     //   #159	-> 275
/*     */     //   #161	-> 283
/*     */     //   #163	-> 288
/*     */     //   #165	-> 300
/*     */     //   #167	-> 310
/*     */     //   #169	-> 314
/*     */     //   #175	-> 322
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	323	0	this	Lcom/vadosity/vnav/client/PhotoSelectorImagePanel;
/*     */     //   0	323	1	e	Ljava/awt/event/MouseEvent;
/*     */     //   53	270	2	abs	Ljava/awt/Point;
/*     */     //   83	240	3	angles	[D
/*     */     //   175	147	4	distance	D
/*     */     //   189	133	6	priorStartAngle	D
/*     */     //   220	102	8	newStartAngle	D
/*     */     //   229	93	10	angularDiff	D
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
/*     */   
/*     */   void this_mouseReleased(MouseEvent e) {
/* 179 */     this.mouseBeingDragged = false;
/* 180 */     this.mouse = null;
/*     */ 
/*     */     
/* 183 */     if (this.toolkitContentPane == null) findToolkitContentPane();
/*     */     
/* 185 */     this.toolkitContentPane.setMouse((Point)null);
/* 186 */     this.toolkitContentPane.setMouseBeingDragged(false);
/* 187 */     this.toolkitContentPane.updateUI();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 192 */     if (this.toolkitContentPane == null) {
/*     */       return;
/*     */     }
/* 195 */     if (this.viewImagePanel == null) this.viewImagePanel = getViewImagePanel(this.toolkitContentPane);
/*     */ 
/*     */     
/* 198 */     if (this.viewImagePanel == null) throw new IllegalStateException("viewImagePanel could not be located in component tree");
/*     */ 
/*     */ 
/*     */     
/* 202 */     MouseEvent mouseEvent = SwingUtilities.convertMouseEvent(this, e, this.viewImagePanel);
/* 203 */     if (!this.viewImagePanel.contains(mouseEvent.getPoint()))
/*     */       return; 
/* 205 */     Rectangle viewRect = ((JViewport)this.viewImagePanel.getParent()).getViewRect();
/*     */     
/* 207 */     if (!viewRect.contains(mouseEvent.getPoint())) {
/*     */       return;
/*     */     }
/*     */     
/* 211 */     if (Global.getTour() == null) {
/*     */       
/* 213 */       String message = "Please open an existing tour \nor create a new tour prior to adding photos";
/* 214 */       String title = "No tour open";
/* 215 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*     */       
/*     */       return;
/*     */     } 
/* 219 */     if (Global.getView() == null) {
/*     */       
/* 221 */       String message = "Please add a view tab (floor plan, map,etc) to the tour prior to adding photos";
/* 222 */       String title = "No View tab";
/* 223 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 229 */     boolean pointFound = false;
/* 230 */     Collection c = Global.getView().getVPhotoPoints();
/* 231 */     if (c != null && !c.isEmpty()) {
/*     */       
/* 233 */       Iterator it = c.iterator();
/* 234 */       while (it.hasNext()) {
/*     */         
/* 236 */         PhotoPoint pt = it.next();
/* 237 */         int distance = (int)Point.distance(mouseEvent.getX(), mouseEvent.getY(), pt.getX(), pt.getY());
/* 238 */         if (distance <= Settings.getProximityDistance(pt)) {
/*     */           
/* 240 */           Global.setPhotoPoint(pt, this);
/*     */           
/* 242 */           Global.setPhoto(pt.getFirstPhoto(), this);
/*     */           
/* 244 */           pointFound = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 251 */     if (!pointFound) {
/*     */       
/* 253 */       if (MultiPhotoUtil.getInstance().getPhotoBytes() == null) {
/*     */         
/* 255 */         String message = "Please select a photo to add to the Floor plan Diagram";
/* 256 */         String title = "No Photo Selected";
/* 257 */         JOptionPane.showMessageDialog(this, message, title, 1);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 262 */       PhotoPoint newPt = new PhotoPoint();
/* 263 */       newPt.setX((mouseEvent.getPoint()).x);
/* 264 */       newPt.setY((mouseEvent.getPoint()).y);
/* 265 */       MultiPhotoUtil.getInstance().setPhotoPoint(newPt);
/* 266 */       newPt = MultiPhotoUtil.getInstance().assemblePhotosOnPoint();
/*     */       
/* 268 */       Global.setPhotoPoint(newPt, this);
/* 269 */       Global.setPhoto(newPt.getFirstPhoto(), this);
/* 270 */       Global.getView().add(newPt);
/* 271 */       boolean originalState = Global.getTour().isLocked();
/* 272 */       Global.getTour().setLocked(false);
/* 273 */       Global.getTour().doCalculations();
/* 274 */       Global.getTour().setLocked(originalState);
/*     */ 
/*     */       
/* 277 */       MultiPhotoUtil.getInstance().setPhotoPoint(null);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 282 */     if (pointFound) {
/*     */       
/* 284 */       if (MultiPhotoUtil.getInstance().getPhotoBytes() == null) {
/*     */         
/* 286 */         String message = "Please select a photo to add to the Floor plan Diagram";
/* 287 */         String title = "No Photo Selected";
/* 288 */         JOptionPane.showMessageDialog(this, message, title, 1);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 293 */       PhotoPoint selectedPt = Global.getPhotoPoint();
/* 294 */       int newIndex = selectedPt.getVPhotos().size();
/*     */ 
/*     */       
/* 297 */       MultiPhotoUtil.getInstance().setPhotoPoint(selectedPt);
/*     */ 
/*     */       
/* 300 */       selectedPt = MultiPhotoUtil.getInstance().assemblePhotosOnPoint();
/*     */ 
/*     */       
/* 303 */       Global.setPhoto(selectedPt.getVPhotos().elementAt(newIndex), this);
/*     */       
/* 305 */       boolean originalState = Global.getTour().isLocked();
/* 306 */       Global.getTour().setLocked(false);
/* 307 */       Global.getTour().doCalculations();
/* 308 */       Global.getTour().setLocked(originalState);
/*     */ 
/*     */       
/* 311 */       MultiPhotoUtil.getInstance().setPhotoPoint(null);
/*     */     } 
/*     */     
/* 314 */     System.gc();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ViewImagePanel getViewImagePanel(Container container) {
/* 320 */     if (container instanceof ViewImagePanel)
/*     */     {
/* 322 */       return (ViewImagePanel)container;
/*     */     }
/*     */     
/* 325 */     Component[] ca = container.getComponents();
/* 326 */     if (ca == null) return null;
/*     */ 
/*     */     
/* 329 */     for (int i = 0; i < ca.length; i++) {
/*     */       
/* 331 */       if (ca[i] instanceof ViewImagePanel)
/*     */       {
/* 333 */         return (ViewImagePanel)ca[i];
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 338 */       if (ca[i] instanceof Container) {
/*     */         
/* 340 */         ViewImagePanel v = getViewImagePanel((Container)ca[i]);
/* 341 */         if (v != null) return v;
/*     */       
/*     */       } 
/*     */     } 
/* 345 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\PhotoSelectorImagePanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */