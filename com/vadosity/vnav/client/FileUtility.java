/*     */ package com.vadosity.vnav.client;
/*     */ import com.vadosity.vnav.bean.PhotoPoint;
/*     */ import com.vadosity.vnav.bean.Tour;
/*     */ import com.vadosity.vnav.bean.View;
/*     */ import com.vadosity.vnav.client.filefilter.ImageFileFilter;
/*     */ import com.vadosity.vnav.client.filefilter.TourFileFilter;
/*     */ import java.awt.Component;
/*     */ import java.awt.Image;
/*     */ import java.awt.MediaTracker;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.TreeMap;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.filechooser.FileFilter;
/*     */ 
/*     */ public class FileUtility implements Serializable {
/*  24 */   private static FileUtility instance = null;
/*     */   
/*     */   static final long serialVersionUID = -1315087149754557704L;
/*     */ 
/*     */   
/*     */   public static FileUtility getInstance() {
/*  30 */     if (instance == null) loadInstance(); 
/*  31 */     return instance;
/*     */   }
/*     */   
/*  34 */   private File currentDirectory = null;
/*  35 */   private File currentFile = null;
/*     */   
/*     */   public static final String storageFilename = "vtoolkit.properties";
/*     */   
/*  39 */   private String projectDirectory = null;
/*     */   
/*     */   public String getProjectDirectory() {
/*  42 */     if (this.projectDirectory == null)
/*     */     {
/*  44 */       this.projectDirectory = RegistryInterface.getMostRecentProject();
/*     */     }
/*  46 */     return this.projectDirectory;
/*     */   }
/*     */   
/*     */   public void setProjectDirectory(String projectDirectory) {
/*  50 */     this.projectDirectory = projectDirectory;
/*     */   }
/*  52 */   private String projectsDirectory = null;
/*  53 */   public String getProjectsDirectory() { return this.projectsDirectory; } public void setProjectsDirectory(String path) {
/*  54 */     this.projectsDirectory = path;
/*     */   }
/*  56 */   private TreeMap photoFileMap = new TreeMap();
/*  57 */   public TreeMap getPhotoFileMap() { return this.photoFileMap; } public void setPhotoFileMap(TreeMap treeMap) {
/*  58 */     this.photoFileMap = treeMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isActivationKeyValid(String key) {
/*  64 */     if (key == null) throw new IllegalArgumentException("key is null"); 
/*  65 */     if (key.trim().equals("")) throw new IllegalArgumentException("key is empty string");
/*     */     
/*     */     try {
/*  68 */       String[] sa = key.split("-");
/*  69 */       if (!sa[0].substring(3).trim().equalsIgnoreCase(sa[4].substring(0, 1).trim())) return false; 
/*  70 */       if (!sa[1].substring(2, 3).trim().equalsIgnoreCase(sa[4].substring(1, 2).trim())) return false; 
/*  71 */       if (!sa[2].substring(1, 2).trim().equalsIgnoreCase(sa[4].substring(2, 3).trim())) return false; 
/*  72 */       if (!sa[3].substring(0, 1).trim().equalsIgnoreCase(sa[4].substring(3).trim())) return false; 
/*  73 */       return true;
/*     */     }
/*  75 */     catch (Exception e) {
/*     */       
/*  77 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Image changeViewImage(View view, Component component) {
/*  84 */     if (view == null) {
/*     */       
/*  86 */       String message = "No View Tab Available";
/*  87 */       String title = "No View Tab Available";
/*  88 */       JOptionPane.showMessageDialog(component, message, title, 0);
/*  89 */       return null;
/*     */     } 
/*     */ 
/*     */     
/*  93 */     JFileChooser chooser = new JFileChooser();
/*  94 */     chooser.setFileFilter((FileFilter)new ImageFileFilter());
/*  95 */     chooser.setDialogTitle("Load New View Image");
/*  96 */     chooser.setDialogType(0);
/*  97 */     chooser.setMultiSelectionEnabled(false);
/*  98 */     chooser.setFileSelectionMode(0);
/*  99 */     if (getInstance().getProjectDirectory() != null)
/*     */     {
/* 101 */       chooser.setCurrentDirectory(new File(getInstance().getProjectDirectory()));
/*     */     }
/* 103 */     int result = chooser.showOpenDialog(component);
/* 104 */     if (result == 1) return null;
/*     */     
/* 106 */     saveInstance();
/*     */     
/* 108 */     File f = chooser.getSelectedFile();
/* 109 */     Image image = null;
/* 110 */     byte[] imageBytes = (byte[])null;
/*     */     
/*     */     try {
/* 113 */       FileInputStream fis = new FileInputStream(f);
/* 114 */       imageBytes = new byte[fis.available()];
/* 115 */       fis.read(imageBytes);
/* 116 */       fis.close();
/* 117 */       image = Toolkit.getDefaultToolkit().createImage(imageBytes);
/*     */     }
/* 119 */     catch (Exception e) {
/*     */       
/* 121 */       String message = "Image File Corrupt : " + e;
/* 122 */       String title = "Unable to Load Image File";
/* 123 */       JOptionPane.showMessageDialog(component, message, title, 0);
/* 124 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 128 */     int w = -1, h = -1;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 133 */       JFrame frame = new JFrame();
/* 134 */       MediaTracker tracker = new MediaTracker(frame);
/* 135 */       tracker.addImage(image, 0);
/* 136 */       tracker.waitForID(0);
/* 137 */       w = image.getWidth(frame);
/* 138 */       h = image.getHeight(frame);
/*     */     }
/* 140 */     catch (Exception e) {
/*     */       
/* 142 */       throw new RuntimeException(e);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 147 */     if (view != null && view.getName() != null && !view.getName().trim().equals("")) {
/*     */       
/* 149 */       String filename = chooser.getSelectedFile().getName();
/* 150 */       String viewName = filename.substring(0, filename.lastIndexOf("."));
/* 151 */       view.setName(viewName);
/*     */     } 
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
/* 168 */     boolean pointsNeedChecking = false;
/* 169 */     int oldW = -1, oldH = -1;
/* 170 */     if (view.getVPhotoPoints().size() > 0) {
/*     */       
/* 172 */       pointsNeedChecking = true;
/*     */ 
/*     */       
/* 175 */       oldW = view.getPhotoWidth();
/* 176 */       oldH = view.getPhotoHeight();
/* 177 */       if (w == oldW && h == oldH) pointsNeedChecking = false;
/*     */     
/*     */     } 
/*     */     
/* 181 */     if (pointsNeedChecking) {
/*     */ 
/*     */       
/* 184 */       boolean resizingNeeded = false;
/* 185 */       int maxX = -1, maxY = -1;
/* 186 */       int xi = -1, yi = -1;
/*     */ 
/*     */       
/* 189 */       Iterator it = view.getVPhotoPoints().iterator();
/* 190 */       PhotoPoint pt = null;
/* 191 */       while (it.hasNext()) {
/*     */         
/* 193 */         pt = it.next();
/* 194 */         if (pt == null)
/* 195 */           continue;  xi = pt.getX();
/* 196 */         yi = pt.getY();
/* 197 */         if (maxX < xi) maxX = xi; 
/* 198 */         if (maxY < yi) maxY = yi;
/*     */       
/*     */       } 
/*     */       
/* 202 */       if (maxX > w || maxY > h) {
/*     */ 
/*     */ 
/*     */         
/* 206 */         String message = "Existing photos lie outside the new image boundary.\n";
/* 207 */         message = String.valueOf(message) + "The points will be automatically relocated to fit the new image.\n";
/* 208 */         message = String.valueOf(message) + "\n\nDo you wish to continue?";
/* 209 */         String title = "Photo relocation required";
/* 210 */         int decision = JOptionPane.showConfirmDialog(null, message, title, 1);
/* 211 */         if (decision == 2 || decision == 1) return null; 
/* 212 */         if (decision == 0)
/*     */         {
/*     */           
/* 215 */           double horizontalScale = oldW * 1.0D / w;
/* 216 */           double verticalScale = oldH * 1.0D / h;
/*     */           
/* 218 */           Iterator it2 = view.getVPhotoPoints().iterator();
/* 219 */           PhotoPoint pt2 = null;
/*     */           
/* 221 */           while (it2.hasNext())
/*     */           {
/* 223 */             pt2 = it2.next();
/* 224 */             if (pt2 == null)
/* 225 */               continue;  xi = pt2.getX();
/* 226 */             yi = pt2.getY();
/* 227 */             int newX = (int)Math.round(xi / horizontalScale);
/* 228 */             int newY = (int)Math.round(yi / verticalScale);
/* 229 */             pt2.setX(newX);
/* 230 */             pt2.setY(newY);
/*     */           
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 239 */         String message = "Existing view image has photo icons but the image size is changing.  \n";
/* 240 */         message = String.valueOf(message) + "\nDo you wish to reposition photo icons to match the new dimensions?";
/* 241 */         String title = "Photo Repositioning Suggested";
/* 242 */         int decision = JOptionPane.showConfirmDialog(null, message, title, 1);
/* 243 */         if (decision == 2) return null; 
/* 244 */         if (decision == 0) {
/*     */ 
/*     */           
/* 247 */           double horizontalScale = oldW * 1.0D / w;
/* 248 */           double verticalScale = oldH * 1.0D / h;
/* 249 */           Iterator it2 = view.getVPhotoPoints().iterator();
/* 250 */           PhotoPoint pt2 = null;
/* 251 */           while (it2.hasNext()) {
/*     */             
/* 253 */             pt2 = it2.next();
/* 254 */             if (pt2 == null)
/* 255 */               continue;  xi = pt2.getX();
/* 256 */             yi = pt2.getY();
/* 257 */             int newX = (int)Math.round(xi / horizontalScale);
/* 258 */             int newY = (int)Math.round(yi / verticalScale);
/* 259 */             pt2.setX(newX);
/* 260 */             pt2.setY(newY);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     view.setImageBytes(imageBytes);
/* 272 */     return image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeTour(Component component) {
/* 278 */     if (Global.getTour() == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 283 */     if (Global.getTour().isModified())
/*     */     {
/* 285 */       if (Settings.getMode() == 0 && !confirmTourChange(component)) {
/*     */         return;
/*     */       }
/*     */     }
/* 289 */     Global.setTour(null, this);
/* 290 */     Global.setPhoto(null, this);
/* 291 */     Global.setPhotoPoint(null, this);
/* 292 */     Global.setView(null, this);
/* 293 */     Global.clearGlobalValues();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveInstance() {
/*     */     try {
/* 301 */       FileOutputStream fos = new FileOutputStream("FileUtility.data");
/* 302 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 303 */       oos.writeObject(getInstance());
/* 304 */       oos.flush();
/* 305 */       oos.close();
/* 306 */       oos = null;
/*     */     }
/* 308 */     catch (Exception e) {
/*     */       
/* 310 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void loadInstance() {
/*     */     try {
/* 322 */       File f = new File("FileUtility.data");
/* 323 */       if (!f.exists()) {
/*     */         
/* 325 */         instance = new FileUtility();
/*     */         return;
/*     */       } 
/* 328 */       FileInputStream fis = new FileInputStream(f);
/* 329 */       ObjectInputStream ois = new ObjectInputStream(fis);
/* 330 */       FileUtility fu = (FileUtility)ois.readObject();
/* 331 */       instance = fu;
/*     */     }
/* 333 */     catch (Exception e) {
/*     */       
/* 335 */       e.printStackTrace();
/* 336 */       instance = new FileUtility();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void openTour(Component component) {
/*     */     try {
/* 346 */       if (Settings.getMode() == 0 && !confirmTourChange(component)) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 353 */       JFileChooser chooser = new JFileChooser();
/* 354 */       chooser.setCurrentDirectory(getInstance().getCurrentDirectory());
/*     */       
/* 356 */       chooser.setDialogTitle("Open Tour File");
/* 357 */       chooser.setDialogType(0);
/* 358 */       TourFileFilter filter = new TourFileFilter();
/* 359 */       chooser.setFileFilter((FileFilter)filter);
/* 360 */       int result = chooser.showOpenDialog(component);
/* 361 */       if (result == 1) {
/*     */         return;
/*     */       }
/* 364 */       File selectedFile = chooser.getSelectedFile();
/*     */ 
/*     */       
/*     */       try {
/* 368 */         Global.setLoadingTour(true);
/* 369 */         FileInputStream fis = new FileInputStream(selectedFile);
/* 370 */         ObjectInputStream ois = new ObjectInputStream(fis);
/* 371 */         Tour tour = (Tour)ois.readObject();
/* 372 */         ois.close();
/*     */ 
/*     */         
/* 375 */         getInstance().setCurrentFile(selectedFile);
/* 376 */         Global.setTour(tour, getInstance());
/* 377 */         tour.setModified(false);
/*     */ 
/*     */         
/* 380 */         String path = selectedFile.getAbsolutePath();
/* 381 */         String name = selectedFile.getName();
/* 382 */         RecentFilesMap.getInstance().put(path, name);
/* 383 */         RecentFilesMap.saveInstance();
/*     */ 
/*     */       
/*     */       }
/* 387 */       catch (Exception e2) {
/*     */         
/* 389 */         e2.printStackTrace();
/* 390 */         JOptionPane.showMessageDialog(component, e2.toString(), e2.toString(), 0);
/*     */ 
/*     */         
/*     */         return;
/*     */       } finally {
/* 395 */         Global.setLoadingTour(false);
/*     */       } 
/*     */       
/*     */       try {
/* 399 */         Global.setLoadingTour(true);
/*     */         
/* 401 */         if (Global.getTour() != null)
/*     */         {
/* 403 */           Global.setView(Global.getTour().getFirstView(), null);
/* 404 */           if (Global.getView() != null) {
/*     */             
/* 406 */             Global.setPhotoPoint(Global.getView().getFirstPhotoPoint(), null);
/* 407 */             if (Global.getPhotoPoint() != null)
/*     */             {
/* 409 */               Global.setPhoto(Global.getPhotoPoint().getFirstPhoto(), null);
/*     */             }
/*     */           } 
/* 412 */           boolean isLocked = Global.getTour().isLocked();
/* 413 */           Global.getTour().setLocked(false);
/* 414 */           Global.getTour().doCalculations();
/* 415 */           Global.getTour().setLocked(isLocked);
/*     */         }
/*     */       
/* 418 */       } catch (Exception e3) {
/*     */         
/* 420 */         JOptionPane.showMessageDialog(component, e3.toString(), e3.toString(), 0);
/*     */       }
/*     */       finally {
/*     */         
/* 424 */         Global.setLoadingTour(false);
/*     */       }
/*     */     
/* 427 */     } catch (Exception exception) {
/*     */       
/* 429 */       JOptionPane.showMessageDialog(component, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void openTour(String filename, Component component) {
/* 436 */     Global.setLoadingTour(true);
/*     */     
/* 438 */     if (Settings.getMode() == 0 && !confirmTourChange(component)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 443 */     File selectedFile = new File(filename);
/*     */     
/* 445 */     Tour tour = null;
/*     */ 
/*     */     
/*     */     try {
/* 449 */       FileInputStream fis = new FileInputStream(selectedFile);
/* 450 */       ObjectInputStream ois = new ObjectInputStream(fis);
/* 451 */       tour = (Tour)ois.readObject();
/* 452 */       ois.close();
/* 453 */       getInstance().setCurrentFile(selectedFile);
/* 454 */       getInstance().setCurrentDirectory(selectedFile.getParentFile());
/*     */ 
/*     */       
/* 457 */       String path = selectedFile.getAbsolutePath();
/* 458 */       String name = selectedFile.getName();
/* 459 */       RecentFilesMap.getInstance().put(path, name);
/* 460 */       RecentFilesMap.saveInstance();
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 465 */     catch (Exception e2) {
/*     */       
/* 467 */       JOptionPane.showMessageDialog(component, e2.toString(), e2.toString(), 0);
/* 468 */       e2.printStackTrace();
/*     */       
/* 470 */       RecentFilesMap.getInstance().remove(selectedFile.getAbsolutePath());
/* 471 */       RecentFilesMap.saveInstance();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/* 477 */       Global.setTour(tour, "");
/* 478 */       tour.setModified(false);
/*     */       
/* 480 */       if (Global.getTour() != null)
/*     */       {
/* 482 */         Global.setView(Global.getTour().getFirstView(), "");
/* 483 */         if (Global.getView() != null) {
/*     */           
/* 485 */           Global.setPhotoPoint(Global.getView().getFirstPhotoPoint(), "");
/* 486 */           if (Global.getPhotoPoint() != null)
/*     */           {
/* 488 */             Global.setPhoto(Global.getPhotoPoint().getFirstPhoto(), "");
/*     */           }
/*     */         } 
/* 491 */         boolean isLocked = Global.getTour().isLocked();
/* 492 */         Global.getTour().setLocked(false);
/* 493 */         Global.getTour().doCalculations();
/* 494 */         Global.getTour().setLocked(isLocked);
/*     */       }
/*     */     
/*     */     }
/* 498 */     catch (Exception e3) {
/*     */       
/* 500 */       JOptionPane.showMessageDialog(component, e3.toString(), e3.toString(), 0);
/* 501 */       e3.printStackTrace();
/*     */     }
/*     */     finally {
/*     */       
/* 505 */       Global.setLoadingTour(false);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean confirmTourChange(Component component) {
/* 521 */     if (Settings.getMode() == 1) return true;
/*     */ 
/*     */     
/* 524 */     if (Global.getTour() != null && Global.getTour().getFirstView() != null) {
/*     */       
/* 526 */       String message = "Do you wish to save changes to the current Tour?";
/* 527 */       String title = "Save Changes";
/* 528 */       int result = JOptionPane.showConfirmDialog(component, message, title, 1);
/* 529 */       if (result == 2) return false; 
/* 530 */       if (result == 1) return true; 
/* 531 */       if (result == 0) {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 536 */           String filename = Global.getTour().getFilename();
/* 537 */           File f = null;
/* 538 */           if (filename == null) {
/*     */             
/* 540 */             JFileChooser chooser = new JFileChooser();
/* 541 */             TourFileFilter tff = new TourFileFilter();
/* 542 */             chooser.setFileFilter((FileFilter)tff);
/* 543 */             chooser.setCurrentDirectory(getInstance().getCurrentDirectory());
/* 544 */             chooser.setSelectedFile(getInstance().getCurrentFile());
/* 545 */             chooser.setDialogTitle("Save Tour As");
/* 546 */             int result2 = chooser.showSaveDialog(component);
/* 547 */             if (result2 == 1) return false; 
/* 548 */             f = chooser.getSelectedFile();
/*     */           } 
/*     */           
/* 551 */           FileOutputStream fos = new FileOutputStream(f);
/* 552 */           ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 553 */           Global.getTour().setModified(false);
/* 554 */           oos.writeObject(Global.getTour());
/* 555 */           oos.flush();
/* 556 */           oos.close();
/*     */         }
/* 558 */         catch (Exception e2) {
/*     */           
/* 560 */           JOptionPane.showMessageDialog(component, e2.toString(), e2.toString(), 
/* 561 */               0);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 570 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getCurrentDirectory() {
/* 579 */     if (this.currentDirectory == null)
/*     */     {
/* 581 */       this.currentDirectory = new File(String.valueOf(System.getProperty("user.home")) + File.separator + "My Documents");
/*     */     }
/*     */     
/* 584 */     return this.currentDirectory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentDirectory(File file) {
/* 591 */     this.currentDirectory = file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getCurrentFile() {
/* 598 */     return this.currentFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentFile(File file) {
/* 605 */     this.currentFile = file;
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\FileUtility.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */