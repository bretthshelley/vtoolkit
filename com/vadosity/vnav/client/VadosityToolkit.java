/*      */ package com.vadosity.vnav.client;
/*      */ import com.vadosity.vnav.bean.Tour;
/*      */ import com.vadosity.vnav.bean.View;
/*      */ import com.vadosity.vnav.bean.ViewSettings;
/*      */ import com.vadosity.vnav.client.filefilter.TourFileFilter;
/*      */ import com.vadosity.vnav.client.settings.AdvancedSettingsDialog;
/*      */ import com.vadosity.vnav.client.settings.CircleSettingsDialog;
/*      */ import com.vadosity.vnav.client.settings.TourTitleDialog;
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Insets;
/*      */ import java.awt.MediaTracker;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.util.Vector;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.KeyStroke;
/*      */ 
/*      */ public class VadosityToolkit extends JFrame implements GlobalChangeListener, SettingsChangeListener {
/*   37 */   int width = 1000;
/*   38 */   int height = 800;
/*      */   
/*   40 */   private static VadosityToolkit toolkit = null;
/*   41 */   public static VadosityToolkit getInstance() { return toolkit; } public static void setInstance(VadosityToolkit tk) {
/*   42 */     toolkit = tk;
/*      */   }
/*      */   
/*      */   private static boolean viewOnly = false;
/*      */   private static boolean checkedForFlag = false;
/*      */   
/*      */   public static boolean isViewOnly() {
/*   49 */     checkForViewOnlyFlag();
/*   50 */     return viewOnly;
/*      */   }
/*      */   
/*      */   private static void checkForViewOnlyFlag() {
/*   54 */     if (checkedForFlag)
/*      */       return; 
/*      */     try {
/*   57 */       File file = new File("." + File.separator + "system.dat");
/*   58 */       viewOnly = file.exists();
/*   59 */       checkedForFlag = true;
/*      */     }
/*   61 */     catch (Exception ex) {
/*      */       
/*   63 */       checkedForFlag = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setupTitle() {
/*   72 */     if (Global.getTour() == null) {
/*      */       
/*   74 */       setTitle("Vadosity 2");
/*      */       return;
/*      */     } 
/*   77 */     String name = Global.getTour().getName();
/*   78 */     if (name != null && !name.trim().equals("")) {
/*      */       
/*   80 */       setTitle(name);
/*      */       
/*      */       return;
/*      */     } 
/*   84 */     String[] sa = new String[2];
/*      */     
/*      */     try {
/*   87 */       sa[0] = FileUtility.getInstance().getCurrentFile().getAbsolutePath();
/*   88 */       sa[1] = "";
/*      */     }
/*   90 */     catch (Exception e) {
/*      */       
/*   92 */       setTitle("Vadosity 2");
/*      */       return;
/*      */     } 
/*   95 */     String title = "Vadosity - {0}";
/*   96 */     setTitle(MessageFormat.format(title, (Object[])sa));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  106 */   private JMenuBar menubar = new JMenuBar();
/*  107 */   private int currentViewIndex = 0;
/*      */   
/*  109 */   private byte[] imageBytes = null;
/*      */   public int getCurrentViewIndex() {
/*  111 */     return this.currentViewIndex;
/*      */   }
/*      */   public void setCurrentViewIndex(int index) {
/*  114 */     this.currentViewIndex = index;
/*  115 */     View currentView = Global.getTour().getViews().elementAt(index);
/*  116 */     if (currentView != null)
/*      */     {
/*  118 */       this.viewImagePanel.repaint();
/*      */     }
/*      */   }
/*      */   
/*  122 */   JMenu menuTour = new JMenu();
/*  123 */   JMenuItem miExit = new JMenuItem();
/*  124 */   JMenuItem miNewTour = new JMenuItem();
/*  125 */   JMenuItem miCloseTour = new JMenuItem();
/*  126 */   JMenu menuAdvanced = new JMenu();
/*  127 */   JMenuItem miSaveTour = new JMenuItem();
/*  128 */   JMenu menuHelp = new JMenu();
/*  129 */   ViewImagePanel viewImagePanel = new ViewImagePanel();
/*  130 */   JMenuItem miSaveTourAs = new JMenuItem();
/*  131 */   ButtonGroup photoModeGroup = new ButtonGroup();
/*  132 */   ButtonGroup addPhotoModeGroup = new ButtonGroup();
/*  133 */   JScrollPane viewScroller = new JScrollPane();
/*  134 */   JMenu menuSettings = new JMenu();
/*  135 */   LightningMouseMenuItem miLightningMouse = new LightningMouseMenuItem();
/*  136 */   ButtonGroup groupAppendPhotoMode = new ButtonGroup();
/*  137 */   JMenuItem miExportView = new JMenuItem();
/*  138 */   JMenuItem miImportView = new JMenuItem();
/*  139 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  140 */   JMenuItem miTourOpen = new JMenuItem();
/*  141 */   JMenuItem miImportSettings = new JMenuItem();
/*  142 */   JMenuItem miExportSettings = new JMenuItem();
/*  143 */   JTabbedPane topTabbedPane = new JTabbedPane();
/*  144 */   JPanel selectedPhotoTabPanel = new JPanel();
/*  145 */   SelectedPhotoImagePanel selectedPhotoImagePanel = new SelectedPhotoImagePanel();
/*  146 */   TourTreePanel tourTreePanel = new TourTreePanel();
/*  147 */   JTabbedPane tabbedPaneAddElements = new JTabbedPane();
/*  148 */   JPanel addPhotosSectionPanel = new JPanel();
/*  149 */   GridBagLayout gridBagLayout3 = new GridBagLayout();
/*  150 */   GridBagLayout gb4 = new GridBagLayout();
/*      */   
/*  152 */   JList listPhotos = new JList();
/*  153 */   JScrollPane photoListScroller = new JScrollPane();
/*  154 */   PhotoSelectorImagePanel selectorImagePanel = new PhotoSelectorImagePanel();
/*  155 */   JScrollPane selectorImagePanelScroller = new JScrollPane();
/*  156 */   GridBagLayout gridBagLayout2 = new GridBagLayout();
/*  157 */   MultiPanel multiPanel = new MultiPanel();
/*  158 */   JPanel panelAddPhotos = new JPanel();
/*  159 */   JScrollPane scrollerSelectedPhotoImage = new JScrollPane();
/*  160 */   FlowLayout flowLayout2 = new FlowLayout();
/*  161 */   OrderPanel orderPanel = new OrderPanel();
/*  162 */   JMenuItem miAbout = new JMenuItem();
/*  163 */   MainClientToolBar mainClientToolBar = new MainClientToolBar();
/*  164 */   JSplitPane splitPaneMain = new JSplitPane();
/*  165 */   JSplitPane splitPaneTop = new JSplitPane();
/*  166 */   BorderLayout borderLayout1 = new BorderLayout();
/*  167 */   JMenu menuTools = new JMenu();
/*  168 */   JMenuItem miLicenseSoftware = new JMenuItem();
/*  169 */   JMenuItem miSatellitePhotos = new JMenuItem();
/*  170 */   JMenuItem miHosting = new JMenuItem();
/*  171 */   JMenuItem miVadosityWebsite = new JMenuItem();
/*      */   
/*      */   TitledBorder titledBorder5;
/*      */   TitledBorder multiPanelBorder;
/*  175 */   JMenuItem miImageProcessor = new JMenuItem();
/*  176 */   TextViewPanel textEditPanel = new TextViewPanel();
/*  177 */   GridBagLayout gridBagLayout4 = new GridBagLayout();
/*  178 */   JMenuItem miManagePhotos = new JMenuItem();
/*  179 */   JMenuItem miFootsteps = new JMenuItem();
/*  180 */   JMenuItem miCircle = new JMenuItem();
/*  181 */   JMenuItem miFlashes = new JMenuItem();
/*  182 */   JMenuItem miLightArrow = new JMenuItem();
/*  183 */   JMenuItem miPanoramic = new JMenuItem();
/*  184 */   JMenuItem miFloodLight = new JMenuItem();
/*  185 */   AlwaysCenterMenuItem miAlwaysCenter = new AlwaysCenterMenuItem();
/*  186 */   JMenuItem miAdvanced = new JMenuItem();
/*  187 */   JMenuItem miHelp = new JMenuItem();
/*  188 */   AlphaSlider alphaSlider = new AlphaSlider();
/*  189 */   JMenuItem miUploadTour = new JMenuItem();
/*  190 */   ViewTabbedPane viewTabbedPane = new ViewTabbedPane();
/*  191 */   JMenu menuProject = new JMenu();
/*  192 */   JMenuItem miNewProject = new JMenuItem();
/*  193 */   RecentFilesMenu recentFilesMenu = new RecentFilesMenu();
/*  194 */   JMenuItem miOpenProject = new JMenuItem();
/*  195 */   JMenuItem miAddPhotos = new JMenuItem();
/*  196 */   AddPhotosButton addPhotosButton = new AddPhotosButton();
/*  197 */   BorderLayout borderLayout2 = new BorderLayout();
/*  198 */   BorderLayout borderLayout3 = new BorderLayout();
/*  199 */   JMenu menuNavigation = new JMenu();
/*  200 */   JMenuItem miFirst = new JMenuItem();
/*  201 */   JMenuItem miPrevious = new JMenuItem();
/*  202 */   JMenuItem miNext = new JMenuItem();
/*  203 */   JMenuItem miLast = new JMenuItem(); protected boolean licenseOk; private int daysRemaining; JLabel jLabel1; JLabel lblMiniHelp;
/*      */   JMenuItem miTitleDialog;
/*      */   
/*      */   public void settingsChanged(Object src) {
/*  207 */     int mode = Settings.getMode();
/*      */     
/*  209 */     boolean updateNeeded = false;
/*  210 */     if (mode == 0 && !this.menuProject.isVisible()) updateNeeded = true; 
/*  211 */     if (mode == 1 && this.menuProject.isVisible()) updateNeeded = true;
/*      */     
/*  213 */     if (!updateNeeded)
/*      */       return; 
/*  215 */     boolean v = (mode == 0);
/*  216 */     this.menuSettings.setVisible(v);
/*  217 */     this.menuProject.setVisible(v);
/*  218 */     this.menuTools.setVisible(v);
/*  219 */     this.miNewTour.setVisible(true);
/*  220 */     this.miSaveTour.setVisible(true);
/*  221 */     this.miSaveTourAs.setVisible(true);
/*      */     
/*  223 */     this.splitPaneMain.setBottomComponent(v ? this.tabbedPaneAddElements : null);
/*  224 */     this.splitPaneMain.setDividerLocation(getHeight() - 400);
/*  225 */     if (v) {
/*      */       
/*  227 */       this.topTabbedPane.add(this.tourTreePanel, "<html><b><font size=\"3\">Tour Tree</font></b></html>");
/*      */     }
/*      */     else {
/*      */       
/*  231 */       this.topTabbedPane.remove(this.tourTreePanel);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void doCustomizations() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void openCurrentProject() {
/*  320 */     setupPhotoDirectory(RegistryInterface.getCurrentProjectDirectory().getAbsolutePath());
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean createAndAddViewFromImageFile(Component c, File f) {
/*  325 */     if (c == null) throw new IllegalArgumentException("c cannot be null - needed for error message"); 
/*  326 */     if (f == null) throw new IllegalArgumentException("file is null");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  332 */       if (Global.getTour() == null) {
/*      */ 
/*      */         
/*  335 */         String newTourName = getInstance().createNewTourName();
/*      */ 
/*      */         
/*  338 */         Tour tour = new Tour();
/*  339 */         tour.setName(newTourName);
/*  340 */         Global.setTour(tour, "");
/*      */         
/*  342 */         String fileName = RegistryInterface.getCurrentProjectDirectory() + File.separator + newTourName;
/*  343 */         FileUtility.getInstance().setCurrentFile(new File(fileName));
/*  344 */         getInstance().setupTitle();
/*      */       } 
/*      */       
/*  347 */       String name = f.getName().toLowerCase();
/*  348 */       if (name.indexOf("gif") == -1 && name.indexOf("jpg") == -1) {
/*  349 */         throw new RuntimeException("Image must be saved as GIF or JPG image");
/*      */       }
/*      */ 
/*      */       
/*  353 */       View view = new View();
/*  354 */       String viewName = f.getName().substring(0, f.getName().lastIndexOf("."));
/*  355 */       view.setName(viewName);
/*      */ 
/*      */       
/*  358 */       FileInputStream fis = new FileInputStream(f);
/*  359 */       byte[] bytes = new byte[fis.available()];
/*  360 */       fis.read(bytes);
/*  361 */       view.setImageBytes(bytes);
/*  362 */       fis.close();
/*      */ 
/*      */ 
/*      */       
/*  366 */       Image image = Toolkit.getDefaultToolkit().createImage(bytes);
/*      */ 
/*      */       
/*  369 */       JFrame observer = new JFrame();
/*  370 */       MediaTracker tracker = new MediaTracker(observer);
/*  371 */       tracker.addImage(image, 0);
/*  372 */       tracker.waitForAll();
/*      */       
/*  374 */       int w = image.getWidth(observer);
/*  375 */       int h = image.getHeight(observer);
/*  376 */       if (w == -1 || h == -1) throw new RuntimeException("Image must be GIF or JPG image file");
/*      */ 
/*      */       
/*  379 */       Global.getTour().getViews().addElement(view);
/*  380 */       Global.setView(view, c);
/*  381 */       return true;
/*      */     }
/*  383 */     catch (Exception e) {
/*      */       
/*  385 */       e.printStackTrace();
/*  386 */       JOptionPane.showMessageDialog(c, e.getMessage(), "Error Creating View", 0);
/*  387 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void main(String[] args) {
/*  397 */     VadosityToolkit client = new VadosityToolkit();
/*  398 */     setInstance(client);
/*      */     
/*  400 */     Global.setWindowContainer(client);
/*  401 */     client.openCurrentProject();
/*      */     
/*  403 */     Preferences.placeWindow(client);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  408 */     client.setupSplitPane();
/*      */ 
/*      */     
/*  411 */     if (args != null && args.length > 0) {
/*      */       
/*  413 */       String filename = args[0];
/*  414 */       VadosityToolkit tk = client;
/*      */       
/*  416 */       Runnable doLoadTour = new Runnable(filename, tk) { private final String val$filename;
/*      */           private final VadosityToolkit val$tk;
/*      */           
/*      */           public void run() {
/*  420 */             FileUtility.openTour(this.val$filename, this.val$tk);
/*  421 */             Settings.setMode(1);
/*  422 */             Global.fireSettingsChanged(this);
/*  423 */             this.val$tk.setVisible(true);
/*      */             
/*  425 */             boolean licenseOk = this.val$tk.isLicenseOk();
/*      */ 
/*      */             
/*  428 */             if (!licenseOk) {
/*      */               
/*  430 */               LicenseKeyDialog dlg = new LicenseKeyDialog(this.val$tk, true);
/*  431 */               if (this.val$tk.getDaysRemaining() < 0) this.val$tk.setDaysRemaining(0); 
/*  432 */               dlg.setDaysRemaining(this.val$tk.getDaysRemaining());
/*  433 */               int dlgWidth = 450, dlgHeight = 250;
/*  434 */               dlg.setSize(dlgWidth, dlgHeight);
/*  435 */               dlg.setModal(true);
/*      */               
/*  437 */               int x = (this.val$tk.getLocation()).x;
/*  438 */               int y = (this.val$tk.getLocation()).y;
/*  439 */               int w = (this.val$tk.getSize()).width;
/*  440 */               int h = (this.val$tk.getSize()).height;
/*      */               
/*  442 */               int dlgx = x + w / 2 - dlgWidth / 2;
/*  443 */               int dlgy = y + h / 2 - dlgHeight / 2;
/*      */               
/*  445 */               dlg.setLocation(dlgx, dlgy);
/*  446 */               dlg.setVisible(true);
/*      */             } 
/*      */           } }
/*      */         ;
/*      */       
/*  451 */       SwingUtilities.invokeLater(doLoadTour);
/*      */     } else {
/*      */ 
/*      */       
/*      */       try {
/*      */ 
/*      */         
/*  458 */         String lastFileOpened = RegistryInterface.getLastTourFile();
/*  459 */         VadosityToolkit tk = client;
/*  460 */         if (lastFileOpened != null && Global.getTour() == null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  470 */           Runnable doLoadTour = new Runnable(lastFileOpened, tk) { private final String val$lastFileOpened; private final VadosityToolkit val$tk;
/*      */               public void run() {
/*  472 */                 FileUtility.openTour(this.val$lastFileOpened, this.val$tk);
/*  473 */                 Settings.setMode(1);
/*  474 */                 Global.fireSettingsChanged(this);
/*  475 */                 this.val$tk.setVisible(true);
/*      */                 
/*  477 */                 boolean licenseOk = this.val$tk.isLicenseOk();
/*  478 */                 if (!licenseOk) {
/*      */ 
/*      */                   
/*  481 */                   LicenseKeyDialog dlg = new LicenseKeyDialog(this.val$tk, true);
/*  482 */                   if (this.val$tk.getDaysRemaining() < 0) this.val$tk.setDaysRemaining(0); 
/*  483 */                   dlg.setDaysRemaining(this.val$tk.getDaysRemaining());
/*  484 */                   int dlgWidth = 450, dlgHeight = 250;
/*  485 */                   dlg.setSize(dlgWidth, dlgHeight);
/*  486 */                   dlg.setModal(true);
/*      */                   
/*  488 */                   int x = (this.val$tk.getLocation()).x;
/*  489 */                   int y = (this.val$tk.getLocation()).y;
/*  490 */                   int w = (this.val$tk.getSize()).width;
/*  491 */                   int h = (this.val$tk.getSize()).height;
/*      */                   
/*  493 */                   int dlgx = x + w / 2 - dlgWidth / 2;
/*  494 */                   int dlgy = y + h / 2 - dlgHeight / 2;
/*      */                   
/*  496 */                   dlg.setLocation(dlgx, dlgy);
/*  497 */                   dlg.setVisible(true);
/*      */                 } 
/*      */               } }
/*      */             ;
/*      */ 
/*      */           
/*  503 */           SwingUtilities.invokeLater(doLoadTour);
/*      */         }
/*      */       
/*      */       }
/*  507 */       catch (Exception e) {
/*      */         
/*  509 */         e.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setupSplitPane() {
/*  517 */     int space = 40;
/*      */     
/*  519 */     int neededWidth = 0;
/*  520 */     Tour tour = Global.getTour();
/*  521 */     if (tour == null || tour.getPhotoSize() == -1) {
/*      */       
/*  523 */       neededWidth = 320 + space;
/*      */     }
/*  525 */     else if (tour.getPhotoSize() == 0) {
/*      */       
/*  527 */       neededWidth = 480 + space;
/*      */     }
/*  529 */     else if (tour.getPhotoSize() == 1) {
/*      */       
/*  531 */       neededWidth = 480 + space;
/*      */     } 
/*      */ 
/*      */     
/*  535 */     this.splitPaneTop.setDividerLocation(getWidth() - neededWidth);
/*      */     
/*  537 */     int y = this.height - 420;
/*  538 */     this.splitPaneMain.setDividerLocation(y);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jbInit() throws Exception {
/*  544 */     this.titledBorder5 = new TitledBorder("");
/*  545 */     this.multiPanelBorder = new TitledBorder("");
/*  546 */     setContentPane(new ToolkitContentPane());
/*  547 */     setDefaultCloseOperation(0);
/*  548 */     setEnabled(true);
/*  549 */     setDefaultCloseOperation(3);
/*  550 */     addComponentListener(new VadosityToolkit_this_componentAdapter(this));
/*  551 */     this.menuTools.setText("Tools");
/*  552 */     this.miLicenseSoftware.setText("Purchase License");
/*  553 */     this.miLicenseSoftware.addActionListener(new VadosityToolkit_miLicenseSoftware_actionAdapter(this));
/*  554 */     this.miSatellitePhotos.setText("Satellite Images");
/*  555 */     this.miSatellitePhotos.addActionListener(new VadosityToolkit_miSatellitePhotos_actionAdapter(this));
/*  556 */     this.miHosting.setText("Hosting Wizard");
/*  557 */     this.miHosting.addActionListener(new VadosityToolkit_miHosting_actionAdapter(this));
/*  558 */     this.miVadosityWebsite.setText("Vadosity Website");
/*  559 */     this.miVadosityWebsite.addActionListener(new VadosityToolkit_miVadosityWebsite_actionAdapter(this));
/*  560 */     this.multiPanelBorder.setTitleColor(Color.black);
/*  561 */     this.multiPanelBorder.setTitleFont(new Font("Dialog", 0, 12));
/*  562 */     this.multiPanelBorder.setTitle("Photo Angle Editor");
/*  563 */     this.multiPanelBorder.setBorder(BorderFactory.createRaisedBevelBorder());
/*  564 */     this.tabbedPaneAddElements.setMinimumSize(new Dimension(626, 290));
/*  565 */     this.tabbedPaneAddElements.setPreferredSize(new Dimension(1015, 290));
/*  566 */     this.miImageProcessor.setText("Image Processor");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  572 */     this.miManagePhotos.setText("Manage Photos");
/*  573 */     this.miManagePhotos.addActionListener(new VadosityToolkit_miManagePhotos_actionAdapter(this));
/*  574 */     this.miFootsteps.setText("Footsteps");
/*  575 */     this.miFootsteps.addActionListener(new VadosityToolkit_miFootsteps_actionAdapter(this));
/*  576 */     this.miCircle.setText("Circles");
/*  577 */     this.miCircle.addActionListener(new VadosityToolkit_miCircle_actionAdapter(this));
/*  578 */     this.miFlashes.setText("Flashes");
/*  579 */     this.miFlashes.addActionListener(new VadosityToolkit_miFlashes_actionAdapter(this));
/*  580 */     this.miLightArrow.setText("Arrows");
/*  581 */     this.miLightArrow.addActionListener(new VadosityToolkit_miLightArrow_actionAdapter(this));
/*  582 */     this.miPanoramic.setText("Panoramic");
/*  583 */     this.miPanoramic.addActionListener(new VadosityToolkit_miPanoramic_actionAdapter(this));
/*  584 */     this.miFloodLight.setText("FloodLight");
/*  585 */     this.miFloodLight.addActionListener(new VadosityToolkit_miFloodLight_actionAdapter(this));
/*  586 */     this.miAlwaysCenter.setText("Always Center");
/*  587 */     this.miAdvanced.setText("Advanced");
/*  588 */     this.miAdvanced.addActionListener(new VadosityToolkit_miAdvanced_actionAdapter(this));
/*  589 */     this.miHelp.setText("Help...");
/*  590 */     this.miHelp.addActionListener(new VadosityToolkit_miHelp_actionAdapter(this));
/*  591 */     this.miUploadTour.addActionListener(new VadosityToolkit_miUploadTour_actionAdapter(this));
/*  592 */     this.miUploadTour.setText("Upload Tour");
/*  593 */     this.menuProject.setText("Project");
/*  594 */     this.menuProject.setMnemonic(80);
/*  595 */     this.miNewProject.setText("New Project...");
/*  596 */     this.miNewProject.setMnemonic(78);
/*  597 */     this.miNewProject.addActionListener(new VadosityToolkit_miNewProject_actionAdapter(this));
/*  598 */     this.miOpenProject.setText("Open Project");
/*  599 */     this.miOpenProject.setMnemonic(79);
/*  600 */     this.miOpenProject.addActionListener(new VadosityToolkit_miOpenProject_actionAdapter(this));
/*  601 */     this.miAddPhotos.setText("Add Photos...");
/*  602 */     this.miAddPhotos.setMnemonic(65);
/*  603 */     this.miAddPhotos.addActionListener(new VadosityToolkit_miAddPhotos_actionAdapter(this));
/*      */     
/*  605 */     this.listPhotos.addKeyListener(new VadosityToolkit_listPhotos_keyAdapter(this));
/*  606 */     this.addPhotosButton.setMaximumSize(new Dimension(240, 40));
/*  607 */     this.addPhotosButton.setMinimumSize(new Dimension(240, 40));
/*  608 */     this.addPhotosButton.setPreferredSize(new Dimension(240, 40));
/*  609 */     this.addPhotosButton.setText("Add Photos");
/*  610 */     this.addPhotosSectionPanel.setMinimumSize(new Dimension(310, 300));
/*  611 */     this.addPhotosSectionPanel.setPreferredSize(new Dimension(1010, 300));
/*  612 */     this.menuNavigation.setText("Navigation");
/*  613 */     this.miFirst.setText("First");
/*  614 */     this.miFirst.setAccelerator(KeyStroke.getKeyStroke(37, 1));
/*  615 */     this.miFirst.addActionListener(new VadosityToolkit_miFirst_actionAdapter(this));
/*  616 */     this.miPrevious.setText("Previous");
/*  617 */     this.miPrevious.setAccelerator(KeyStroke.getKeyStroke(37, 8));
/*  618 */     this.miPrevious.addActionListener(new VadosityToolkit_miPrevious_actionAdapter(this));
/*  619 */     this.miNext.setText("Next");
/*  620 */     this.miNext.setAccelerator(KeyStroke.getKeyStroke(39, 8));
/*  621 */     this.miNext.addActionListener(new VadosityToolkit_miNext_actionAdapter(this));
/*  622 */     this.miLast.setText("Last");
/*  623 */     this.miLast.setAccelerator(KeyStroke.getKeyStroke(39, 1));
/*  624 */     this.miLast.addActionListener(new VadosityToolkit_miLast_actionAdapter(this));
/*  625 */     this.jLabel1.setFont(new Font("Dialog", 1, 12));
/*  626 */     this.jLabel1.setMaximumSize(new Dimension(360, 16));
/*  627 */     this.jLabel1.setMinimumSize(new Dimension(240, 16));
/*  628 */     this.jLabel1.setPreferredSize(new Dimension(240, 16));
/*  629 */     this.jLabel1.setHorizontalAlignment(0);
/*  630 */     this.jLabel1.setHorizontalTextPosition(0);
/*  631 */     this.jLabel1.setText("Project Photo Selection");
/*  632 */     this.lblMiniHelp.setFont(new Font("Dialog", 1, 12));
/*  633 */     this.lblMiniHelp.setText("Drag Photos Below onto View Tab above");
/*  634 */     this.miTitleDialog.setText("Set Tour Title");
/*  635 */     this.miTitleDialog.addActionListener(new VadosityToolkit_miTitleDialog_actionAdapter(this));
/*  636 */     this.viewScroller.getViewport().add(this.viewImagePanel);
/*      */ 
/*      */     
/*  639 */     getContentPane().add(this.splitPaneMain);
/*  640 */     getContentPane().add(this.splitPaneTop);
/*  641 */     getContentPane().add(this.viewScroller);
/*  642 */     getContentPane().add(this.tabbedPaneAddElements);
/*      */ 
/*      */     
/*  645 */     this.menuTour.setText("File");
/*  646 */     this.miExit.setText("Exit");
/*  647 */     this.miExit.addActionListener(new VadosityToolkit_miExit_actionAdapter(this));
/*  648 */     setJMenuBar(this.menubar);
/*  649 */     setTitle("Vadosity");
/*  650 */     getContentPane().setLayout(this.borderLayout1);
/*  651 */     addWindowListener(new VadosityToolkit_this_windowAdapter(this));
/*  652 */     this.miNewTour.setText("New");
/*  653 */     this.miNewTour.addActionListener(new VadosityToolkit_miNewTour_actionAdapter(this));
/*  654 */     this.miCloseTour.setAlignmentY(0.5F);
/*  655 */     this.miCloseTour.setText("Close");
/*  656 */     this.miCloseTour.addActionListener(new VadosityToolkit_miCloseTour_actionAdapter(this));
/*  657 */     this.menuAdvanced.setText("Advanced");
/*  658 */     this.miSaveTour.setText("Save");
/*  659 */     this.miSaveTour.addActionListener(new VadosityToolkit_miSaveTour_actionAdapter(this));
/*  660 */     this.menuHelp.setText("Help");
/*  661 */     this.viewImagePanel.setSize(400, 400);
/*  662 */     this.viewImagePanel.setBounds(new Rectangle(2, 2, 507, 400));
/*  663 */     this.viewImagePanel.setBackground(Color.white);
/*  664 */     this.viewImagePanel.setBorder(BorderFactory.createRaisedBevelBorder());
/*  665 */     this.miSaveTourAs.setText("Save As");
/*  666 */     this.miSaveTourAs.addActionListener(new VadosityToolkit_miSaveTourAs_actionAdapter(this));
/*  667 */     this.viewScroller.setBorder(BorderFactory.createLineBorder(Color.black));
/*  668 */     this.viewScroller.setDoubleBuffered(true);
/*  669 */     this.viewScroller.setMinimumSize(new Dimension(20, 22));
/*  670 */     this.menuSettings.setText("Edit");
/*  671 */     this.miLightningMouse.setSelected(true);
/*  672 */     this.miLightningMouse.setText("Lightning Mouse");
/*  673 */     this.miExportView.setText("Export View");
/*  674 */     this.miExportView.addActionListener(new VadosityToolkit_miExportView_actionAdapter(this));
/*  675 */     this.miImportView.setText("Import View");
/*  676 */     this.miImportView.addActionListener(new VadosityToolkit_miImportView_actionAdapter(this));
/*      */     
/*  678 */     this.miTourOpen.setText("Open");
/*  679 */     this.miTourOpen.addActionListener(new VadosityToolkit_miTourOpen_actionAdapter(this));
/*  680 */     this.miExportSettings.setText("Export Settings");
/*  681 */     this.miExportSettings.addActionListener(new VadosityToolkit_miExportSettings_actionAdapter(this));
/*  682 */     this.miImportSettings.setText("Import Settings");
/*  683 */     this.miImportSettings.addActionListener(new VadosityToolkit_miImportSettings_actionAdapter(this));
/*  684 */     this.topTabbedPane.setMinimumSize(new Dimension(340, 280));
/*  685 */     this.topTabbedPane.setPreferredSize(new Dimension(350, 400));
/*  686 */     this.selectedPhotoTabPanel.setLayout(this.gridBagLayout4);
/*  687 */     this.selectedPhotoImagePanel.setBorder(BorderFactory.createLoweredBevelBorder());
/*  688 */     this.selectedPhotoImagePanel.setMaximumSize(new Dimension(32000, 24000));
/*  689 */     this.selectedPhotoImagePanel.setMinimumSize(new Dimension(320, 240));
/*  690 */     this.selectedPhotoImagePanel.setPreferredSize(new Dimension(320, 240));
/*  691 */     this.selectedPhotoImagePanel.setBounds(new Rectangle(0, 0, 320, 240));
/*  692 */     this.selectedPhotoImagePanel.setLayout(this.flowLayout2);
/*  693 */     this.selectedPhotoTabPanel.setMinimumSize(new Dimension(340, 330));
/*  694 */     this.selectedPhotoTabPanel.setPreferredSize(new Dimension(345, 390));
/*      */     
/*  696 */     this.listPhotos.addListSelectionListener(new VadosityToolkit_listPhotos_listSelectionAdapter(this));
/*  697 */     this.listPhotos.addMouseListener(new VadosityToolkit_listPhotos_mouseAdapter(this));
/*  698 */     this.photoListScroller.setMaximumSize(new Dimension(360, 198));
/*  699 */     this.photoListScroller.setMinimumSize(new Dimension(60, 110));
/*  700 */     this.photoListScroller.setPreferredSize(new Dimension(80, 240));
/*  701 */     this.selectorImagePanel.setBackground(Color.white);
/*  702 */     this.selectorImagePanel.setEnabled(true);
/*  703 */     this.selectorImagePanel.setBorder(BorderFactory.createLoweredBevelBorder());
/*  704 */     this.selectorImagePanel.setMaximumSize(new Dimension(320, 240));
/*  705 */     this.selectorImagePanel.setMinimumSize(new Dimension(320, 240));
/*  706 */     this.selectorImagePanel.setPreferredSize(new Dimension(320, 240));
/*  707 */     this.selectorImagePanel.setLayout((LayoutManager)null);
/*      */     
/*  709 */     this.selectorImagePanelScroller.setBorder(BorderFactory.createLoweredBevelBorder());
/*  710 */     this.selectorImagePanelScroller.setMaximumSize(new Dimension(325, 245));
/*  711 */     this.selectorImagePanelScroller.setMinimumSize(new Dimension(325, 245));
/*  712 */     this.selectorImagePanelScroller.setPreferredSize(new Dimension(325, 245));
/*  713 */     this.selectorImagePanelScroller.getViewport().setLayout((LayoutManager)null);
/*      */ 
/*      */     
/*  716 */     this.multiPanel.setBorder(this.multiPanelBorder);
/*  717 */     this.multiPanel.setMinimumSize(new Dimension(320, 240));
/*  718 */     this.multiPanel.setPreferredSize(new Dimension(320, 240));
/*  719 */     this.panelAddPhotos.setLayout(this.gridBagLayout2);
/*  720 */     this.panelAddPhotos.setMinimumSize(new Dimension(300, 300));
/*  721 */     this.panelAddPhotos.setPreferredSize(new Dimension(1000, 300));
/*  722 */     this.addPhotosSectionPanel.setLayout(this.borderLayout2);
/*  723 */     this.listPhotos.setBounds(new Rectangle(0, 0, 500, 300));
/*  724 */     this.listPhotos.setCellRenderer(new IconListCellRenderer());
/*  725 */     this.scrollerSelectedPhotoImage.setDoubleBuffered(true);
/*      */     
/*  727 */     setupPhotoScrollerSize();
/*      */ 
/*      */ 
/*      */     
/*  731 */     this.scrollerSelectedPhotoImage.getViewport().setLayout((LayoutManager)null);
/*  732 */     this.photoListScroller.setMinimumSize(new Dimension(240, 198));
/*  733 */     this.photoListScroller.setPreferredSize(new Dimension(240, 198));
/*  734 */     this.miAbout.setText("About");
/*  735 */     this.miAbout.addActionListener(new VadosityToolkit_miAbout_actionAdapter(this));
/*  736 */     this.menubar.add(this.menuTour);
/*  737 */     this.menubar.add(this.menuSettings);
/*  738 */     this.menubar.add(this.menuTools);
/*      */     
/*  740 */     this.menubar.add(this.menuHelp);
/*      */     
/*  742 */     this.menuTour.add(this.miTourOpen);
/*  743 */     this.menuTour.add(this.miNewTour);
/*  744 */     this.menuTour.add(this.miSaveTour);
/*  745 */     this.menuTour.add(this.miSaveTourAs);
/*  746 */     this.menuTour.add(this.miCloseTour);
/*  747 */     this.menuTour.add(this.menuProject);
/*  748 */     this.menuTour.addSeparator();
/*  749 */     this.menuTour.add(this.recentFilesMenu);
/*  750 */     this.menuTour.addSeparator();
/*  751 */     this.menuTour.add(this.miExit);
/*  752 */     this.menuAdvanced.add(this.miExportView);
/*  753 */     this.menuAdvanced.add(this.miImportView);
/*  754 */     this.menuAdvanced.addSeparator();
/*  755 */     this.menuAdvanced.add(this.miExportSettings);
/*  756 */     this.menuAdvanced.add(this.miImportSettings);
/*  757 */     this.menuAdvanced.add(this.menuNavigation);
/*      */ 
/*      */     
/*  760 */     this.viewScroller.getViewport().setLayout((LayoutManager)null);
/*  761 */     this.menuSettings.add(this.miTitleDialog);
/*  762 */     this.menuSettings.add(this.miFootsteps);
/*  763 */     this.menuSettings.add(this.miCircle);
/*  764 */     this.menuSettings.add(this.miLightArrow);
/*  765 */     this.menuSettings.add(this.miFlashes);
/*  766 */     this.menuSettings.add(this.miPanoramic);
/*  767 */     this.menuSettings.add(this.miFloodLight);
/*  768 */     this.menuSettings.add(this.miAlwaysCenter);
/*  769 */     this.menuSettings.add(this.miLightningMouse);
/*  770 */     this.menuSettings.add(this.miAdvanced);
/*  771 */     JScrollPane scroller = new JScrollPane();
/*  772 */     scroller.setMinimumSize(new Dimension(50, 50));
/*  773 */     scroller.getViewport().add(this.topTabbedPane);
/*  774 */     this.topTabbedPane.add(this.selectedPhotoTabPanel, "<html><b><font size=\"3\">Selected Photo</font></html>");
/*      */     
/*  776 */     this.selectedPhotoTabPanel.add(this.scrollerSelectedPhotoImage, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  777 */           11, 3, new Insets(0, 0, 0, 0), 0, 0));
/*  778 */     this.scrollerSelectedPhotoImage.getViewport().add(this.selectedPhotoImagePanel, (Object)null);
/*  779 */     this.selectedPhotoTabPanel.add(this.textEditPanel, new GridBagConstraints(0, 1, 1, 1, 0.0D, 1.0D, 
/*  780 */           11, 1, new Insets(0, 0, 0, 0), 0, 0));
/*  781 */     this.topTabbedPane.add(this.tourTreePanel, "<html><b><font size=\"3\">Tour Tree</font></b></html>");
/*  782 */     this.tabbedPaneAddElements.add(this.addPhotosSectionPanel, "<html><b><font size=\"3\">Add Photos</font></b></html>");
/*  783 */     this.tabbedPaneAddElements.add(this.orderPanel, "<html><b><font size=\"3\">Order Photos</font></b></html>");
/*      */     
/*  785 */     this.selectorImagePanelScroller.getViewport().add(this.selectorImagePanel);
/*  786 */     this.panelAddPhotos.add(this.selectorImagePanelScroller, new GridBagConstraints(1, 1, 1, 2, 0.0D, 0.0D, 
/*  787 */           11, 0, new Insets(5, 5, 5, 5), 0, 0));
/*      */ 
/*      */     
/*  790 */     this.panelAddPhotos.add(this.photoListScroller, new GridBagConstraints(0, 1, 1, 1, 2.0D, 0.0D, 
/*  791 */           13, 3, new Insets(5, 25, 0, 5), 0, 0));
/*  792 */     this.photoListScroller.getViewport().add(this.listPhotos, (Object)null);
/*  793 */     this.panelAddPhotos.add(this.multiPanel, new GridBagConstraints(2, 1, 1, 2, 1.0D, 0.0D, 
/*  794 */           17, 1, new Insets(0, 5, 5, 20), 0, 0));
/*  795 */     this.panelAddPhotos.add(this.addPhotosButton, new GridBagConstraints(0, 2, 1, 1, 2.0D, 0.0D, 
/*  796 */           13, 0, new Insets(5, 25, 5, 5), 0, 0));
/*  797 */     this.panelAddPhotos.add(this.jLabel1, new GridBagConstraints(0, 0, 1, 1, 2.0D, 0.0D, 
/*  798 */           13, 0, new Insets(0, 25, 0, 5), 0, 0));
/*  799 */     this.panelAddPhotos.add(this.lblMiniHelp, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  800 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  801 */     this.addPhotosSectionPanel.add(this.panelAddPhotos, "Center");
/*  802 */     this.menuHelp.add(this.miHelp);
/*  803 */     this.menuHelp.addSeparator();
/*  804 */     this.menuHelp.add(this.miVadosityWebsite);
/*  805 */     this.menuHelp.add(this.miAbout);
/*      */ 
/*      */     
/*  808 */     this.splitPaneMain.setOrientation(0);
/*  809 */     this.splitPaneMain.setDividerSize(10);
/*  810 */     this.splitPaneMain.setOneTouchExpandable(true);
/*  811 */     this.splitPaneMain.setTopComponent(this.splitPaneTop);
/*  812 */     this.splitPaneMain.setBottomComponent(this.tabbedPaneAddElements);
/*  813 */     this.splitPaneMain.setContinuousLayout(true);
/*  814 */     this.splitPaneTop.setDividerSize(10);
/*  815 */     this.splitPaneTop.setOneTouchExpandable(true);
/*  816 */     this.splitPaneTop.setContinuousLayout(true);
/*      */     
/*  818 */     this.splitPaneTop.setRightComponent(scroller);
/*      */ 
/*      */     
/*  821 */     this.alphaSlider.setImagePanel(this.viewImagePanel);
/*  822 */     JPanel panelViewRegion = new JPanel();
/*  823 */     panelViewRegion.setLayout(new BorderLayout());
/*  824 */     panelViewRegion.add(this.viewScroller, "Center");
/*  825 */     panelViewRegion.add(this.alphaSlider, "West");
/*      */     
/*  827 */     this.splitPaneTop.setLeftComponent(this.viewTabbedPane);
/*  828 */     this.viewTabbedPane.setMainViewPanel(panelViewRegion);
/*      */ 
/*      */     
/*  831 */     getContentPane().add(this.mainClientToolBar, "North");
/*  832 */     getContentPane().add(this.splitPaneMain, "Center");
/*  833 */     this.menuHelp.add(this.miLicenseSoftware);
/*  834 */     this.menuTools.add(this.miHosting);
/*  835 */     this.menuTools.add(this.miManagePhotos);
/*  836 */     this.menuTools.add(this.miSatellitePhotos);
/*  837 */     this.menuTools.add(this.miUploadTour);
/*  838 */     this.menuTools.add(this.menuAdvanced);
/*  839 */     this.menuProject.add(this.miNewProject);
/*  840 */     this.menuProject.add(this.miAddPhotos);
/*  841 */     this.menuProject.add(this.miOpenProject);
/*  842 */     this.menuNavigation.add(this.miFirst);
/*  843 */     this.menuNavigation.add(this.miPrevious);
/*  844 */     this.menuNavigation.add(this.miNext);
/*  845 */     this.menuNavigation.add(this.miLast);
/*      */ 
/*      */ 
/*      */     
/*  849 */     this.tabbedPaneAddElements.addChangeListener(new AddElementTabChangeListener(this));
/*  850 */     this.topTabbedPane.addChangeListener(new TopTabChangeListener(this));
/*      */ 
/*      */     
/*  853 */     String ttAddPhotos = "<html><body>";
/*  854 */     ttAddPhotos = String.valueOf(ttAddPhotos) + "<font size=\"4\" color=\"#0000ff\"><b>";
/*  855 */     ttAddPhotos = String.valueOf(ttAddPhotos) + "&nbsp;Adds Photos to your project.&nbsp;<br>";
/*  856 */     ttAddPhotos = String.valueOf(ttAddPhotos) + "&nbsp;The photos are resized to keep your tour fast and light.&nbsp;<br>";
/*  857 */     ttAddPhotos = String.valueOf(ttAddPhotos) + "</b></font>";
/*  858 */     ttAddPhotos = String.valueOf(ttAddPhotos) + "</body></html>";
/*  859 */     this.addPhotosButton.setToolTipText(ttAddPhotos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void setupPhotoScrollerSize() {
/*  866 */     Tour tour = Global.getTour();
/*      */     
/*  868 */     int w = -1;
/*  869 */     int h = -1;
/*  870 */     int inset = 5;
/*      */     
/*  872 */     if (tour == null || tour.getPhotoSize() == -1) {
/*      */       
/*  874 */       w = 320 + inset;
/*  875 */       h = 240 + inset;
/*      */     }
/*  877 */     else if (tour.getPhotoSize() == 0) {
/*      */       
/*  879 */       w = 480 + inset;
/*  880 */       h = 360 + inset;
/*      */     }
/*  882 */     else if (tour.getPhotoSize() == 1) {
/*      */       
/*  884 */       w = 640 + inset;
/*  885 */       h = 480 + inset;
/*      */     } 
/*      */     
/*  888 */     Dimension size = new Dimension(w, h);
/*  889 */     this.scrollerSelectedPhotoImage.setMinimumSize(size);
/*  890 */     this.scrollerSelectedPhotoImage.setPreferredSize(size);
/*  891 */     this.scrollerSelectedPhotoImage.updateUI();
/*      */     
/*  893 */     this.textEditPanel.setMinimumSize(new Dimension(w, 100));
/*  894 */     this.textEditPanel.setPreferredSize(new Dimension(w, 250));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miExit_actionPerformed(ActionEvent e) {
/*  903 */     exit();
/*      */   }
/*      */ 
/*      */   
/*      */   public void exit() {
/*  908 */     if (Global.getTour() != null && Global.getTour().isModified()) {
/*      */       
/*  910 */       String message = "Do you wish to Save Changes?";
/*  911 */       String title = "Save Changes";
/*  912 */       int result = JOptionPane.showConfirmDialog(null, message, title, 1, 3);
/*  913 */       if (result == 2)
/*  914 */         return;  if (result == 1) {
/*      */         
/*  916 */         System.exit(0);
/*      */         return;
/*      */       } 
/*  919 */       if (result == 0) {
/*      */ 
/*      */         
/*  922 */         saveTour();
/*  923 */         System.exit(0);
/*      */         return;
/*      */       } 
/*      */     } 
/*  927 */     System.exit(0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String createNewTourName() {
/*  933 */     String baseName = "Tour";
/*  934 */     Collection c = RecentFilesMap.getInstance().values();
/*  935 */     String possibleName = null;
/*  936 */     for (int i = 1; i < 10000; i++) {
/*      */       
/*  938 */       possibleName = String.valueOf(baseName) + " " + i + TourFileFilter.TOUR_EXTENSION;
/*  939 */       if (!c.contains(possibleName))
/*      */       {
/*  941 */         return possibleName;
/*      */       }
/*      */     } 
/*  944 */     throw new IllegalStateException("Some crazy bastid created too many tours - No worries- You are a millionaire");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miNewTour_actionPerformed(ActionEvent e) {
/*  951 */     EditModeToggleButton.doEditRoutine();
/*      */ 
/*      */     
/*  954 */     if (Settings.getMode() != 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/*  960 */       if (Global.getTour() != null && Global.getTour().isModified()) {
/*      */ 
/*      */         
/*  963 */         String message = "Save Changes to Current Tour";
/*  964 */         String str1 = "Save Changes";
/*      */         
/*  966 */         int i = JOptionPane.showConfirmDialog(this, 
/*  967 */             message, str1, 1);
/*  968 */         if (i == 2)
/*  969 */           return;  if (i == 0)
/*      */         {
/*  971 */           saveTour();
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  977 */       Global.clearGlobalValues();
/*      */ 
/*      */       
/*  980 */       String newTourName = createNewTourName();
/*      */ 
/*      */       
/*  983 */       Tour tour = new Tour();
/*  984 */       tour.setName(newTourName);
/*  985 */       Global.setTour(tour, this);
/*      */       
/*  987 */       String fileName = RegistryInterface.getCurrentProjectDirectory() + 
/*  988 */         File.separator + newTourName;
/*  989 */       FileUtility.getInstance().setCurrentFile(new File(fileName));
/*  990 */       setupTitle();
/*      */ 
/*      */       
/*  993 */       JFileChooser chooser = new JFileChooser();
/*  994 */       chooser.setFileFilter((FileFilter)new ImageFileFilter());
/*  995 */       String title = "Select Base Image for 1st Tab";
/*  996 */       chooser.setDialogTitle(title);
/*  997 */       int result = chooser.showOpenDialog(this);
/*  998 */       if (result == 1)
/*      */         return; 
/* 1000 */       File f = chooser.getSelectedFile();
/* 1001 */       if (f == null)
/*      */         return; 
/* 1003 */       createAndAddViewFromImageFile(this, f);
/*      */     
/*      */     }
/* 1006 */     catch (Throwable t) {
/*      */       
/* 1008 */       JOptionPane.showMessageDialog(this, t);
/*      */     } 
/*      */ 
/*      */     
/* 1012 */     Settings.setMode(0);
/* 1013 */     Global.fireSettingsChanged(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miCloseTour_actionPerformed(ActionEvent e) {
/* 1020 */     if (Global.getTour() == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1026 */     VadosityToolkit tk = this;
/* 1027 */     Runnable doCloseTour = new Runnable(this, tk) {
/*      */         final VadosityToolkit this$0;
/*      */         private final VadosityToolkit val$tk;
/*      */         
/*      */         public void run() {
/* 1032 */           FileUtility.getInstance().closeTour(this.val$tk);
/*      */         }
/*      */       };
/*      */     
/* 1036 */     SwingUtilities.invokeLater(doCloseTour);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1041 */     this.recentFilesMenu.updateMenuItems();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setupPhotoDirectory(String directory) {
/* 1048 */     if (directory == null || directory.equals("")) {
/*      */       
/* 1050 */       this.listPhotos.setListData(new Vector());
/* 1051 */       this.listPhotos.updateUI();
/* 1052 */       ((JViewport)this.listPhotos.getParent()).updateUI();
/* 1053 */       ((JScrollPane)((JViewport)this.listPhotos.getParent()).getParent()).updateUI();
/*      */       
/*      */       return;
/*      */     } 
/* 1057 */     TreeMap tm = new TreeMap();
/* 1058 */     Vector vPhotos = getPhotosInDirectory(new File(directory));
/* 1059 */     FileUtility.getInstance().setPhotoFileMap(new TreeMap());
/* 1060 */     for (int i = 0; i < vPhotos.size(); i++) {
/*      */       
/* 1062 */       File f = vPhotos.elementAt(i);
/* 1063 */       tm.put(new Long(f.lastModified()), f);
/* 1064 */       FileUtility.getInstance().getPhotoFileMap().put(f.getName(), f);
/*      */     } 
/*      */     
/* 1067 */     Iterator it = tm.values().iterator();
/* 1068 */     Vector v = new Vector();
/* 1069 */     while (it.hasNext())
/*      */     {
/* 1071 */       v.add(((File)it.next()).getName());
/*      */     }
/* 1073 */     this.listPhotos.setListData(v);
/* 1074 */     this.listPhotos.updateUI();
/* 1075 */     ((JViewport)this.listPhotos.getParent()).updateUI();
/* 1076 */     ((JScrollPane)((JViewport)this.listPhotos.getParent()).getParent()).updateUI();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miSaveTour_actionPerformed(ActionEvent e) {
/* 1087 */     saveTour();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveTour() {
/* 1093 */     if (Global.getTour() == null) {
/*      */       
/* 1095 */       String message = "No Tour Open to Save";
/* 1096 */       String title = "No Tour Open";
/* 1097 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*      */     try {
/* 1104 */       File f = FileUtility.getInstance().getCurrentFile();
/* 1105 */       FileOutputStream fos = new FileOutputStream(f);
/* 1106 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 1107 */       Global.getTour().setModified(false);
/* 1108 */       oos.writeObject(Global.getTour());
/* 1109 */       oos.flush();
/* 1110 */       oos.close();
/* 1111 */       oos = null;
/* 1112 */       RecentFilesMap.getInstance().put(f.getAbsolutePath(), f.getName());
/* 1113 */       RecentFilesMap.saveInstance();
/*      */     }
/* 1115 */     catch (Exception e2) {
/*      */       
/* 1117 */       e2.printStackTrace();
/*      */ 
/*      */       
/* 1120 */       saveTourAs();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveTourAs() {
/* 1127 */     if (Global.getTour() == null) {
/*      */       
/* 1129 */       String message = "No Tour Open to Save";
/* 1130 */       String title = "No Tour Open";
/* 1131 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1137 */     JFileChooser chooser = new JFileChooser();
/* 1138 */     TourFileFilter filter = new TourFileFilter();
/* 1139 */     chooser.setFileFilter((FileFilter)filter);
/* 1140 */     chooser.setCurrentDirectory(FileUtility.getInstance().getCurrentDirectory());
/* 1141 */     chooser.setSelectedFile(FileUtility.getInstance().getCurrentFile());
/* 1142 */     chooser.setDialogType(0);
/* 1143 */     chooser.setMultiSelectionEnabled(false);
/* 1144 */     chooser.setDialogTitle("Save Tour As");
/* 1145 */     int result = chooser.showSaveDialog(null);
/*      */     
/* 1147 */     if (result == 1) {
/*      */       return;
/*      */     }
/* 1150 */     String filename = chooser.getSelectedFile().getAbsolutePath();
/* 1151 */     File fileToSave = null;
/*      */     
/* 1153 */     if (!filename.endsWith(TourFileFilter.TOUR_EXTENSION))
/*      */     {
/* 1155 */       filename = String.valueOf(filename) + TourFileFilter.TOUR_EXTENSION;
/*      */     }
/* 1157 */     fileToSave = new File(filename);
/* 1158 */     FileUtility.getInstance().setCurrentFile(fileToSave);
/* 1159 */     FileUtility.getInstance().setCurrentDirectory(chooser.getSelectedFile().getParentFile());
/* 1160 */     saveTour();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miSaveTourAs_actionPerformed(ActionEvent e) {
/* 1167 */     if (Global.getTour() == null) {
/*      */       
/* 1169 */       String message = "No Tour Open";
/* 1170 */       String title = "No Tour Open";
/* 1171 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */       return;
/*      */     } 
/* 1174 */     saveTourAs();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void photoResized() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void tourChanged(Tour selectedTour, Object src) {
/* 1184 */     if (selectedTour == null) {
/*      */       
/* 1186 */       setupTitle();
/* 1187 */       this.viewImagePanel.setImage((Image)null);
/* 1188 */       this.viewImagePanel.updateUI();
/* 1189 */       this.selectedPhotoImagePanel.setImage((Image)null);
/* 1190 */       this.selectedPhotoImagePanel.updateUI();
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 1196 */       setupTitle();
/*      */ 
/*      */       
/* 1199 */       setupPhotoDirectory(RegistryInterface.getCurrentProjectDirectory().getAbsolutePath());
/*      */     } 
/*      */     
/* 1202 */     setupPhotoScrollerSize();
/* 1203 */     setupSplitPane();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void viewChanged(View selectedView, Object src) {
/* 1209 */     if (Global.getView() == null) {
/*      */       
/* 1211 */       this.selectedPhotoImagePanel.setImage((Image)null);
/*      */       
/*      */       return;
/*      */     } 
/* 1215 */     setupTitle();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void photoChanged(Photo selectedPhoto, Object src) {
/* 1221 */     if (Global.getView() == null || selectedPhoto == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1227 */     int width = selectedPhoto.getPhotoWidth();
/* 1228 */     int height = selectedPhoto.getPhotoHeight();
/* 1229 */     if (selectedPhoto != null && selectedPhoto.isPanoramic()) {
/*      */       
/* 1231 */       this.selectedPhotoImagePanel.setSize(width, height);
/* 1232 */       this.selectedPhotoImagePanel.setMinimumSize(new Dimension(width, height));
/* 1233 */       this.selectedPhotoImagePanel.setPreferredSize(new Dimension(width, height));
/* 1234 */       this.selectedPhotoImagePanel.updateUI();
/* 1235 */       this.scrollerSelectedPhotoImage.updateUI();
/*      */     }
/*      */     else {
/*      */       
/* 1239 */       Dimension d = new Dimension(width, height);
/* 1240 */       this.selectedPhotoImagePanel.setSize(d);
/* 1241 */       this.selectedPhotoImagePanel.setMinimumSize(new Dimension(d));
/* 1242 */       this.selectedPhotoImagePanel.setPreferredSize(new Dimension(d));
/* 1243 */       this.selectedPhotoImagePanel.updateUI();
/* 1244 */       this.scrollerSelectedPhotoImage.updateUI();
/*      */     } 
/* 1246 */     photoPointChanged(Global.getPhotoPoint(), this);
/*      */     
/* 1248 */     int scrollOffset = 30;
/*      */ 
/*      */     
/* 1251 */     if (!Settings.isAlwaysCenter())
/*      */     {
/*      */       
/* 1254 */       if (Global.getPhotoPoint() != null && this.viewScroller.getViewport() != null) {
/*      */         
/* 1256 */         Rectangle rectangle = this.viewScroller.getViewport().getViewRect();
/* 1257 */         if (rectangle.contains(Global.getPhotoPoint().getPoint())) {
/*      */ 
/*      */           
/* 1260 */           int i = (int)rectangle.getLocation().getX() + scrollOffset;
/* 1261 */           int j = (int)rectangle.getLocation().getY() + scrollOffset;
/* 1262 */           int w = (int)rectangle.getSize().getWidth() - 2 * scrollOffset;
/* 1263 */           int h = (int)rectangle.getSize().getHeight() - 2 * scrollOffset;
/* 1264 */           Rectangle r = new Rectangle(i, j, w, h);
/*      */           
/* 1266 */           if (Global.getPhoto() == null || Global.getPhotoPoint() == null) {
/*      */ 
/*      */             
/* 1269 */             this.viewImagePanel.scrollRectToVisible(new Rectangle(0, 0, this.viewScroller.getWidth(), this.viewScroller.getHeight()));
/*      */             
/*      */             return;
/*      */           } 
/* 1273 */           if (r.contains(Global.getPhoto().getPhotoPoint().getPoint())) {
/*      */             return;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/* 1279 */           this.viewImagePanel.scrollRectToVisible(r);
/* 1280 */           this.viewImagePanel.updateUI();
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1288 */     if (Global.getPhotoPoint() == null)
/* 1289 */       return;  Point centerPoint = Global.getPhotoPoint().getPoint();
/* 1290 */     if (centerPoint == null) {
/*      */ 
/*      */       
/* 1293 */       Rectangle r = new Rectangle(0, 0, this.viewScroller.getWidth(), this.viewScroller.getHeight());
/* 1294 */       this.viewImagePanel.scrollRectToVisible(r);
/*      */       return;
/*      */     } 
/* 1297 */     int x0 = (int)centerPoint.getX() - (this.viewScroller.getSize()).width / 2;
/* 1298 */     if (x0 < 0) x0 = 0; 
/* 1299 */     int y0 = (int)centerPoint.getY() - (this.viewScroller.getSize()).height / 2;
/* 1300 */     if (y0 < 0) y0 = 0; 
/* 1301 */     Rectangle rect = new Rectangle(x0, y0, this.viewScroller.getWidth(), this.viewScroller.getHeight());
/* 1302 */     this.viewImagePanel.scrollRectToVisible(rect);
/* 1303 */     this.viewImagePanel.updateUI();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void photoPointChanged(PhotoPoint selectedPhotoPoint, Object src) {
/* 1309 */     this.viewImagePanel.updateUI();
/*      */   }
/*      */ 
/*      */   
/*      */   void miDeleteCurrentView_actionPerformed(ActionEvent e) {
/* 1314 */     (new DeleteSelectedViewCommand()).execute(this);
/*      */   }
/*      */ 
/*      */   
/*      */   private Vector getPhotosInDirectory(File directory) {
/* 1319 */     if (directory == null || !directory.isDirectory())
/*      */     {
/* 1321 */       return new Vector();
/*      */     }
/* 1323 */     directory = new File((String)directory);
/* 1324 */     File[] files = directory.listFiles();
/* 1325 */     if (files == null || files.length == 0) return new Vector();
/*      */     
/* 1327 */     Vector v = new Vector();
/* 1328 */     for (int i = 0; i < files.length; i++) {
/*      */       
/* 1330 */       if (extensionOk(files[i].getName()))
/*      */       {
/* 1332 */         v.add(files[i]);
/*      */       }
/*      */     } 
/* 1335 */     return v;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean extensionOk(String filename) {
/* 1340 */     if (filename == null) return false;
/*      */     
/* 1342 */     filename = filename.toLowerCase().trim();
/*      */     
/* 1344 */     if (filename.endsWith("jpg") || 
/* 1345 */       filename.endsWith("gif") || 
/* 1346 */       filename.endsWith("pjpeg") || 
/* 1347 */       filename.endsWith("jpeg"))
/*      */     {
/* 1349 */       return true;
/*      */     }
/* 1351 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void listPhotos_valueChanged(ListSelectionEvent e) {
/* 1357 */     String filename = this.listPhotos.getSelectedValue();
/* 1358 */     if (filename == null)
/*      */       return; 
/* 1360 */     File f = (File)FileUtility.getInstance().getPhotoFileMap().get(filename);
/*      */     
/*      */     try {
/* 1363 */       FileInputStream fis = new FileInputStream(f);
/* 1364 */       byte[] bytes = new byte[fis.available()];
/* 1365 */       fis.read(bytes);
/* 1366 */       fis.close();
/* 1367 */       if (bytes == null || bytes.length == 0) throw new IllegalStateException("File can't be read");
/*      */       
/* 1369 */       Image im = Toolkit.getDefaultToolkit().createImage(bytes);
/*      */       
/* 1371 */       this.selectorImagePanel.setImageBytes(bytes);
/* 1372 */       this.imageBytes = bytes;
/* 1373 */       MediaTracker tracker = new MediaTracker(this);
/* 1374 */       tracker.addImage(im, 0);
/* 1375 */       tracker.waitForID(0);
/* 1376 */       int width = im.getWidth(this);
/* 1377 */       int height = im.getHeight(this);
/*      */       
/* 1379 */       if (width > 2 * height)
/*      */       {
/* 1381 */         Settings.setAddPanoramicPhotos(true);
/* 1382 */         Global.fireSettingsChanged(this);
/*      */       }
/*      */       else
/*      */       {
/* 1386 */         Settings.setAddPanoramicPhotos(false);
/* 1387 */         Global.fireSettingsChanged(this);
/*      */       }
/*      */     
/*      */     }
/* 1391 */     catch (Exception e2) {
/*      */ 
/*      */       
/*      */       try {
/* 1395 */         f.delete();
/*      */       }
/* 1397 */       catch (Exception exception) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1403 */     int numPhotos = (this.listPhotos.getSelectedValues()).length;
/* 1404 */     Settings.setNumberOfPhotos(numPhotos);
/* 1405 */     Global.fireSettingsChanged(this);
/*      */ 
/*      */ 
/*      */     
/* 1409 */     Object[] names = this.listPhotos.getSelectedValues();
/* 1410 */     PhotoBytes[] pba = new PhotoBytes[names.length];
/* 1411 */     for (int i = 0; i < names.length; i++) {
/*      */       
/* 1413 */       String name = (String)names[i];
/* 1414 */       File ithFile = (File)FileUtility.getInstance().getPhotoFileMap().get(name);
/* 1415 */       pba[i] = new PhotoBytes(ithFile);
/*      */     } 
/* 1417 */     MultiPhotoUtil.getInstance().setPhotoBytes(pba);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void listPhotos_mouseClicked(MouseEvent e) {
/* 1423 */     if (e.getClickCount() > 1) {
/*      */ 
/*      */       
/* 1426 */       if (Global.getPhoto() == null)
/* 1427 */         return;  Global.getPhoto().setBytes(this.imageBytes);
/* 1428 */       Global.fireSelectedPhotoChanged(this);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1433 */       Global.setPhoto(null, this.listPhotos);
/* 1434 */       Global.setPhotoPoint(null, this.listPhotos);
/*      */     } 
/*      */   }
/*      */   
/*      */   void miExportView_actionPerformed(ActionEvent e) {
/* 1439 */     if (Global.getView() == null) {
/*      */       
/* 1441 */       String message = "No View Tab to Export";
/* 1442 */       String title = "No View Available";
/* 1443 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */       return;
/*      */     } 
/* 1446 */     JFileChooser fc = new JFileChooser();
/* 1447 */     ViewFileFilter vff = new ViewFileFilter();
/* 1448 */     fc.setFileFilter((FileFilter)vff);
/* 1449 */     fc.setDialogTitle("Export View");
/* 1450 */     fc.setFileSelectionMode(0);
/* 1451 */     if (FileUtility.getInstance().getProjectDirectory() != null)
/*      */     {
/* 1453 */       fc.setCurrentDirectory(new File(FileUtility.getInstance().getProjectDirectory()));
/*      */     }
/* 1455 */     String viewfilename = String.valueOf(Global.getView().getName()) + ".view";
/* 1456 */     fc.setSelectedFile(new File(viewfilename));
/* 1457 */     int result = fc.showSaveDialog(this);
/* 1458 */     if (result == 1)
/*      */       return; 
/* 1460 */     File f = fc.getSelectedFile();
/* 1461 */     if (f.getName() == null || f.getName().trim().equals("")) {
/*      */       
/* 1463 */       String message = "No File Name specified";
/* 1464 */       String title = "No File Specified";
/* 1465 */       JOptionPane.showMessageDialog(this, message, title, 0);
/*      */       return;
/*      */     } 
/* 1468 */     if (!f.getAbsolutePath().endsWith(".view")) {
/*      */       
/* 1470 */       String newName = String.valueOf(f.getAbsolutePath()) + ".view";
/* 1471 */       f = new File(newName);
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/* 1476 */       FileOutputStream fos = new FileOutputStream(f);
/* 1477 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 1478 */       oos.writeObject(Global.getView());
/* 1479 */       oos.flush();
/* 1480 */       oos.close();
/*      */     
/*      */     }
/* 1483 */     catch (Exception e2) {
/*      */       
/* 1485 */       JOptionPane.showMessageDialog(this, e2.toString(), "", 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void miImportView_actionPerformed(ActionEvent e) {
/* 1492 */     JFileChooser fc = new JFileChooser();
/* 1493 */     ViewFileFilter vff = new ViewFileFilter();
/* 1494 */     fc.setFileFilter((FileFilter)vff);
/* 1495 */     fc.setDialogTitle("Import View File");
/* 1496 */     fc.setFileSelectionMode(0);
/* 1497 */     if (FileUtility.getInstance().getProjectDirectory() != null)
/*      */     {
/* 1499 */       fc.setCurrentDirectory(new File(FileUtility.getInstance().getProjectDirectory()));
/*      */     }
/* 1501 */     int result = fc.showOpenDialog(this);
/* 1502 */     if (result == 1)
/*      */       return; 
/* 1504 */     File f = fc.getSelectedFile();
/*      */     
/*      */     try {
/* 1507 */       FileInputStream fis = new FileInputStream(f);
/* 1508 */       ObjectInputStream ois = new ObjectInputStream(fis);
/* 1509 */       View view = (View)ois.readObject();
/* 1510 */       Global.getTour().add(view);
/* 1511 */       Global.setView(view, this);
/* 1512 */       Global.setPhotoPoint(view.getFirstPhotoPoint(), this);
/* 1513 */       Global.setPhoto(Global.getPhotoPoint().getFirstPhoto(), this);
/*      */     }
/* 1515 */     catch (Exception e2) {
/*      */       
/* 1517 */       String message = "Unable to Import View\n {0}";
/* 1518 */       String[] sa = { e2.toString() };
/* 1519 */       message = MessageFormat.format(message, (Object[])sa);
/* 1520 */       String title = "Unable to Import View";
/* 1521 */       JOptionPane.showMessageDialog(this, message, title, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void miTourOpen_actionPerformed(ActionEvent e) {
/* 1528 */     VadosityToolkit tk = this;
/* 1529 */     Runnable doOpenTour = new Runnable(this, tk) {
/*      */         final VadosityToolkit this$0;
/*      */         private final VadosityToolkit val$tk;
/*      */         
/*      */         public void run() {
/* 1534 */           FileUtility.openTour(this.val$tk);
/*      */         }
/*      */       };
/*      */     
/* 1538 */     SwingUtilities.invokeLater(doOpenTour);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miExportSettings_actionPerformed(ActionEvent e) {
/* 1548 */     if (Global.getTour() == null) {
/*      */       
/* 1550 */       String message = "open Tour First";
/* 1551 */       String title = "Open Tour First";
/* 1552 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */       return;
/*      */     } 
/* 1555 */     if (Global.getView() == null) {
/*      */       
/* 1557 */       String message = "open View First";
/* 1558 */       String title = "Open View First";
/* 1559 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */       return;
/*      */     } 
/* 1562 */     JFileChooser fc = new JFileChooser();
/* 1563 */     SettingsFileFilter sff = new SettingsFileFilter();
/* 1564 */     fc.setFileFilter((FileFilter)sff);
/* 1565 */     fc.setDialogTitle("Export Settings");
/* 1566 */     fc.setFileSelectionMode(0);
/* 1567 */     if (FileUtility.getInstance().getProjectDirectory() != null)
/*      */     {
/* 1569 */       fc.setCurrentDirectory(new File(FileUtility.getInstance().getProjectDirectory()));
/*      */     }
/* 1571 */     String settingsFileName = String.valueOf(Global.getView().getName().trim()) + ".settings";
/* 1572 */     settingsFileName = settingsFileName.replaceAll("'", "_");
/* 1573 */     settingsFileName = settingsFileName.replaceAll(" ", "_");
/* 1574 */     fc.setSelectedFile(new File(settingsFileName));
/* 1575 */     int result = fc.showSaveDialog(this);
/* 1576 */     if (result == 1)
/*      */       return; 
/* 1578 */     File f = fc.getSelectedFile();
/* 1579 */     if (f.getName() == null || f.getName().trim().equals("")) {
/*      */       
/* 1581 */       String message = "No file specified";
/* 1582 */       String title = "No file specified";
/* 1583 */       JOptionPane.showMessageDialog(this, message, title, 0);
/*      */       return;
/*      */     } 
/* 1586 */     if (!f.getAbsolutePath().toLowerCase().endsWith(".settings")) {
/*      */       
/* 1588 */       String path = null;
/* 1589 */       if (f.getAbsolutePath().indexOf(".") == -1) {
/*      */         
/* 1591 */         path = f.getAbsolutePath().toLowerCase();
/*      */       }
/*      */       else {
/*      */         
/* 1595 */         path = f.getAbsolutePath().toLowerCase().substring(0, f.getAbsolutePath().lastIndexOf("."));
/*      */       } 
/* 1597 */       String newName = String.valueOf(path) + ".settings";
/* 1598 */       f = new File(newName);
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/* 1603 */       FileOutputStream fos = new FileOutputStream(f);
/* 1604 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 1605 */       oos.writeObject(Global.getView().getViewSettings());
/* 1606 */       oos.flush();
/* 1607 */       oos.close();
/*      */     
/*      */     }
/* 1610 */     catch (Exception e2) {
/*      */       
/* 1612 */       String message = "Unable to export settings\n {0}";
/* 1613 */       String[] sa = { e2.toString() };
/* 1614 */       message = MessageFormat.format(message, (Object[])sa);
/* 1615 */       String title = "Unable to export settings";
/* 1616 */       JOptionPane.showMessageDialog(this, message, title, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miImportSettings_actionPerformed(ActionEvent e) {
/* 1625 */     if (Global.getTour() == null) {
/*      */       
/* 1627 */       String message = "Open Tour First";
/* 1628 */       String title = "No Tour Open";
/* 1629 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */       return;
/*      */     } 
/* 1632 */     if (Global.getView() == null) {
/*      */       
/* 1634 */       String message = "No View Tab Available";
/* 1635 */       String title = "Open View First";
/* 1636 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1641 */     JFileChooser fc = new JFileChooser();
/* 1642 */     SettingsFileFilter sff = new SettingsFileFilter();
/* 1643 */     fc.setFileFilter((FileFilter)sff);
/* 1644 */     fc.setDialogTitle("Import Settings");
/* 1645 */     fc.setFileSelectionMode(0);
/* 1646 */     if (FileUtility.getInstance().getProjectDirectory() != null)
/*      */     {
/* 1648 */       fc.setCurrentDirectory(new File(FileUtility.getInstance().getProjectDirectory()));
/*      */     }
/* 1650 */     int result = fc.showOpenDialog(this);
/*      */ 
/*      */     
/* 1653 */     if (result == 1)
/* 1654 */       return;  File f = fc.getSelectedFile();
/*      */ 
/*      */     
/* 1657 */     ViewSettings viewSettings = null;
/*      */     
/*      */     try {
/* 1660 */       FileInputStream fis = new FileInputStream(f);
/* 1661 */       ObjectInputStream ois = new ObjectInputStream(fis);
/* 1662 */       viewSettings = (ViewSettings)ois.readObject();
/* 1663 */       ois.close();
/*      */     }
/* 1665 */     catch (Exception e2) {
/*      */       
/* 1667 */       String message = "Error: \n{0}";
/* 1668 */       String[] sa = { e2.toString() };
/* 1669 */       message = MessageFormat.format(message, (Object[])sa);
/* 1670 */       String title = "Import Settings Error";
/* 1671 */       JOptionPane.showMessageDialog(this, message, title, 0);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1676 */     if (Global.getTour().getViews().size() > 1) {
/*      */       
/* 1678 */       Object[] oa = new Object[3];
/* 1679 */       String current = "Current View Only";
/* 1680 */       String all = "All";
/* 1681 */       String cancel = "Cancel";
/* 1682 */       oa[0] = current;
/* 1683 */       oa[1] = all;
/* 1684 */       oa[2] = cancel;
/*      */       
/* 1686 */       String message = "Apply Settings to All Views?";
/* 1687 */       String title = "Apply Settings Decision";
/*      */ 
/*      */       
/* 1690 */       Object decision = JOptionPane.showInputDialog(this, message, title, 3, 
/* 1691 */           null, 
/* 1692 */           oa, 
/* 1693 */           current);
/*      */       
/* 1695 */       if (decision == null || decision.equals(cancel))
/* 1696 */         return;  if (decision.equals(all)) {
/*      */         
/* 1698 */         for (int i = 0; i < Global.getTour().getViews().size(); i++) {
/*      */           
/* 1700 */           View ithView = Global.getTour().getViews().elementAt(i);
/* 1701 */           if (ithView != null) {
/* 1702 */             ithView.setViewSettings(viewSettings.copyOf());
/*      */           }
/*      */         } 
/* 1705 */       } else if (decision.equals(current)) {
/*      */         
/* 1707 */         Global.getView().setViewSettings(viewSettings);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1712 */       Global.getView().setViewSettings(viewSettings);
/*      */     } 
/* 1714 */     Global.fireSelectedViewChanged(this);
/*      */   }
/*      */ 
/*      */   
/*      */   void miTourSummary_actionPerformed(ActionEvent e) {
/* 1719 */     JFrame f = new JFrame();
/* 1720 */     f.getContentPane().add(new TourTreePanel());
/* 1721 */     f.setSize(400, 400);
/* 1722 */     f.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   void listPhotos_mousePressed(MouseEvent e) {}
/*      */ 
/*      */   
/*      */   void listPhotos_mouseReleased(MouseEvent e) {
/* 1730 */     if (e.isPopupTrigger()) {
/*      */ 
/*      */       
/*      */       try {
/*      */         
/* 1735 */         String[] sa = new String[2];
/* 1736 */         sa[0] = "iexplore";
/* 1737 */         sa[1] = RegistryInterface.getCurrentProjectDirectory().getAbsolutePath();
/*      */         
/* 1739 */         Runtime.getRuntime().exec(sa);
/*      */       }
/* 1741 */       catch (Exception ex) {
/*      */         
/* 1743 */         JOptionPane.showMessageDialog(this, ex.toString());
/*      */       } 
/* 1745 */       setupPhotoDirectory(RegistryInterface.getCurrentProjectDirectory().getAbsolutePath());
/*      */     } 
/*      */   }
/*      */   
/*      */   void listPhotos_mouseEntered(MouseEvent e) {}
/*      */   
/*      */   void listPhotos_mouseExited(MouseEvent e) {}
/*      */   
/*      */   class TopTabChangeListener implements ChangeListener {
/*      */     final VadosityToolkit this$0;
/*      */     
/*      */     TopTabChangeListener(VadosityToolkit this$0) {
/* 1757 */       this.this$0 = this$0;
/*      */     }
/*      */     
/*      */     public void stateChanged(ChangeEvent e) {
/* 1761 */       JTabbedPane pane = (JTabbedPane)e.getSource();
/* 1762 */       int selectedIndex = pane.getSelectedIndex();
/*      */       
/* 1764 */       if (selectedIndex == 0) {
/*      */ 
/*      */ 
/*      */         
/* 1768 */         this.this$0.tourTreePanel.setActivated(false);
/*      */       
/*      */       }
/* 1771 */       else if (selectedIndex == 1) {
/*      */         
/* 1773 */         this.this$0.tourTreePanel.setActivated(true);
/*      */       } 
/*      */     } }
/*      */   
/*      */   class AddElementTabChangeListener implements ChangeListener {
/*      */     final VadosityToolkit this$0;
/*      */     
/*      */     AddElementTabChangeListener(VadosityToolkit this$0) {
/* 1781 */       this.this$0 = this$0;
/*      */     }
/*      */     
/*      */     public void stateChanged(ChangeEvent e) {
/* 1785 */       JTabbedPane pane = (JTabbedPane)e.getSource();
/* 1786 */       int selectedIndex = pane.getSelectedIndex();
/*      */       
/* 1788 */       if (selectedIndex == 0) {
/*      */ 
/*      */ 
/*      */         
/* 1792 */         this.this$0.orderPanel.setActivated(false);
/*      */       
/*      */       }
/* 1795 */       else if (selectedIndex == 1) {
/*      */ 
/*      */         
/* 1798 */         this.this$0.orderPanel.setActivated(true);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void this_windowClosing(WindowEvent e) {
/* 1806 */     Preferences.saveWindowLocation(this);
/* 1807 */     exit();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miAbout_actionPerformed(ActionEvent e) {
/* 1814 */     AboutDialog dlg = new AboutDialog(this, null, true);
/* 1815 */     dlg.setSize(450, 250);
/* 1816 */     int x = (getLocation()).x + getWidth() / 2 - 225;
/* 1817 */     int y = (getLocation()).y + getHeight() / 2 - 125;
/* 1818 */     dlg.setResizable(false);
/* 1819 */     dlg.setLocation(x, y);
/* 1820 */     dlg.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   void miSatellitePhotos_actionPerformed(ActionEvent e) {
/* 1825 */     TerraFrame terraFrame = new TerraFrame(this, null, true);
/* 1826 */     int dlgWidth = 600;
/* 1827 */     int dlgHeight = 600;
/* 1828 */     terraFrame.setSize(dlgWidth, dlgHeight);
/*      */ 
/*      */ 
/*      */     
/* 1832 */     int x = (getLocation()).x;
/* 1833 */     int y = (getLocation()).y;
/* 1834 */     int w = (getSize()).width;
/* 1835 */     int h = (getSize()).height;
/*      */     
/* 1837 */     int dlgx = x + w / 2 - dlgWidth / 2;
/* 1838 */     int dlgy = y + h / 2 - dlgHeight / 2;
/*      */     
/* 1840 */     terraFrame.setLocation(dlgx, dlgy);
/* 1841 */     terraFrame.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miHosting_actionPerformed(ActionEvent e) {
/* 1849 */     if (Global.getTour() == null) {
/*      */       
/* 1851 */       String message = "No Tour Open";
/* 1852 */       String title = "No Tour Open";
/* 1853 */       JOptionPane.showMessageDialog(this, message, title, 2);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*      */     try {
/* 1860 */       HostingDialog dlg = new HostingDialog(this, null, true);
/* 1861 */       dlg.setSize(500, 450);
/*      */       
/* 1863 */       dlg.setLocation((getLocation()).x + getWidth() / 2 - 250, (getLocation()).y + getHeight() / 2 - 225);
/* 1864 */       dlg.setVisible(true);
/*      */     }
/* 1866 */     catch (Throwable ex) {
/*      */       
/* 1868 */       JOptionPane.showMessageDialog(this, ex.toString());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void miVadosityWebsite_actionPerformed(ActionEvent e) {
/*      */     try {
/* 1876 */       String url = "http://www.vadosity.com";
/* 1877 */       BrowserUtil.displayURL(url);
/*      */     }
/* 1879 */     catch (Exception e2) {
/*      */       
/* 1881 */       JOptionPane.showMessageDialog(this, e2, "Error", 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miLicenseSoftware_actionPerformed(ActionEvent e) {
/* 1891 */     LicenseKeyDialog dlg = new LicenseKeyDialog(this, true);
/* 1892 */     if (getDaysRemaining() < 0) setDaysRemaining(0); 
/* 1893 */     dlg.setDaysRemaining(getDaysRemaining());
/* 1894 */     int dlgWidth = 450, dlgHeight = 250;
/* 1895 */     dlg.setSize(dlgWidth, dlgHeight);
/* 1896 */     dlg.setModal(true);
/*      */     
/* 1898 */     int x = (getLocation()).x;
/* 1899 */     int y = (getLocation()).y;
/* 1900 */     int w = (getSize()).width;
/* 1901 */     int h = (getSize()).height;
/*      */     
/* 1903 */     int dlgx = x + w / 2 - dlgWidth / 2;
/* 1904 */     int dlgy = y + h / 2 - dlgHeight / 2;
/*      */     
/* 1906 */     dlg.setLocation(dlgx, dlgy);
/* 1907 */     dlg.setVisible(true);
/*      */   }
/*      */   
/* 1910 */   public VadosityToolkit() { this.licenseOk = false;
/* 1911 */     this.daysRemaining = -1;
/* 1912 */     this.jLabel1 = new JLabel();
/* 1913 */     this.lblMiniHelp = new JLabel();
/* 1914 */     this.miTitleDialog = new JMenuItem(); this.viewScroller.setPreferredSize(new Dimension(200, 200)); try { jbInit(); Global.addGlobalChangeListener(this); Global.addSettingsChangeListener(this); this.multiPanel.setEnabled(false); this.tourTreePanel.setActivated(false); this.orderPanel.setActivated(false); Global.fireSettingsChanged(this); UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); SwingUtilities.updateComponentTreeUI(this); pack(); try { setIconImage((new ImageIcon(ImageUtil.loadVadosityImage())).getImage()); this.miFootsteps.setIcon(new ImageIcon(ImageUtil.loadFootstepImage())); this.miCircle.setIcon(new ImageIcon(ImageUtil.loadCircleImage())); this.miFlashes.setIcon(new ImageIcon(ImageUtil.loadFlashesImage())); this.miLightArrow.setIcon(new ImageIcon(ImageUtil.loadLightArrowImage())); this.miPanoramic.setIcon(new ImageIcon(ImageUtil.loadPanoramicImage())); this.miFloodLight.setIcon(new ImageIcon(ImageUtil.loadFloodLightImage())); this.miLightningMouse.setIcon(new ImageIcon(ImageUtil.loadLightningMouseImage())); this.miAlwaysCenter.setIcon(new ImageIcon(ImageUtil.loadAlwaysCenterImage())); this.menuTour.setMnemonic(70); this.miNewTour.setAccelerator(KeyStroke.getKeyStroke(78, 2)); this.miNewTour.setMnemonic(78); this.miTourOpen.setAccelerator(KeyStroke.getKeyStroke(79, 2)); this.miTourOpen.setMnemonic(79); this.miSaveTour.setAccelerator(KeyStroke.getKeyStroke(83, 2)); this.miSaveTour.setMnemonic(83); this.miSaveTourAs.setMnemonic(65); this.miSaveTourAs.setAccelerator(KeyStroke.getKeyStroke(65, 2)); this.miExit.setAccelerator(KeyStroke.getKeyStroke(88, 2)); this.miExit.setMnemonic(88); this.miHelp.setAccelerator(KeyStroke.getKeyStroke(112, 0)); }
/*      */       catch (Exception exception) {} }
/*      */     catch (Exception e) { e.printStackTrace(); }
/* 1917 */      } public boolean isLicenseOk() { if (viewOnly) return true;
/*      */ 
/*      */     
/* 1920 */     String key = RegistryInterface.getLicenseKeyFromWindowsRegistry();
/* 1921 */     this.licenseOk = LicenseEvaluator.isKeyOk(key);
/* 1922 */     if (this.licenseOk) {
/*      */       
/* 1924 */       this.miLicenseSoftware.setVisible(false);
/* 1925 */       return true;
/*      */     } 
/*      */ 
/*      */     
/* 1929 */     long evalTime = RegistryInterface.getEvalTimeFromWindowsRegistry();
/* 1930 */     if (evalTime <= 0L) {
/*      */       
/* 1932 */       evalTime = System.currentTimeMillis();
/* 1933 */       RegistryInterface.setEvalTimeInWindowsRegistry(evalTime);
/*      */     } 
/*      */ 
/*      */     
/* 1937 */     Date evalDate = new Date(evalTime);
/* 1938 */     Date nowDate = new Date();
/*      */     
/* 1940 */     long timeElapsed = nowDate.getTime() - evalDate.getTime();
/* 1941 */     long totalTime = 1296000000L;
/* 1942 */     long timeRemaining = totalTime - timeElapsed;
/* 1943 */     long day = 86400000L;
/*      */     
/* 1945 */     this.daysRemaining = (int)(timeRemaining / day);
/* 1946 */     if (this.daysRemaining < 0) this.daysRemaining = 0; 
/* 1947 */     return this.licenseOk; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void this_componentResized(ComponentEvent e) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miManagePhotos_actionPerformed(ActionEvent e) {
/*      */     try {
/* 1986 */       String[] sa = new String[2];
/* 1987 */       sa[0] = "iexplore";
/* 1988 */       sa[1] = RegistryInterface.getCurrentProjectDirectory().getAbsolutePath();
/*      */       
/* 1990 */       Runtime.getRuntime().exec(sa);
/*      */     }
/* 1992 */     catch (Exception ex) {
/*      */       
/* 1994 */       JOptionPane.showMessageDialog(this, ex.toString());
/*      */     } 
/* 1996 */     setupPhotoDirectory(RegistryInterface.getCurrentProjectDirectory().getAbsolutePath());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void miFootsteps_actionPerformed(ActionEvent e) {
/* 2002 */     FootStepSettingsDialog dlg = new FootStepSettingsDialog(this, null, true);
/* 2003 */     int w = 400, h = 300;
/* 2004 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - w / 2, (getLocation()).y + getHeight() / 2 - h / 2);
/* 2005 */     dlg.setSize(w, h);
/* 2006 */     dlg.setResizable(false);
/* 2007 */     dlg.setVisible(true);
/*      */   }
/*      */   
/*      */   void miCircle_actionPerformed(ActionEvent e) {
/* 2011 */     CircleSettingsDialog dlg = new CircleSettingsDialog(this, null, true);
/* 2012 */     int w = 400, h = 300;
/* 2013 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - w / 2, (getLocation()).y + getHeight() / 2 - h / 2);
/* 2014 */     dlg.setSize(w, h);
/* 2015 */     dlg.setResizable(false);
/* 2016 */     dlg.setVisible(true);
/*      */   }
/*      */   
/*      */   void miFlashes_actionPerformed(ActionEvent e) {
/* 2020 */     FlashSettingsDialog dlg = new FlashSettingsDialog(this, null, true);
/* 2021 */     int w = 450, h = 350;
/* 2022 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - w / 2, (getLocation()).y + getHeight() / 2 - h / 2);
/* 2023 */     dlg.setSize(w, h);
/* 2024 */     dlg.setResizable(false);
/* 2025 */     dlg.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void miLightArrow_actionPerformed(ActionEvent e) {
/* 2031 */     ArrowSettingsDialog dlg = new ArrowSettingsDialog(this, null, true);
/* 2032 */     int w = 400, h = 300;
/* 2033 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - w / 2, (getLocation()).y + getHeight() / 2 - h / 2);
/* 2034 */     dlg.setSize(w, h);
/* 2035 */     dlg.setResizable(false);
/* 2036 */     dlg.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   void miPanoramic_actionPerformed(ActionEvent e) {
/* 2041 */     PanoramicSettingsDialog dlg = new PanoramicSettingsDialog(this, null, true);
/* 2042 */     int w = 400, h = 300;
/* 2043 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - w / 2, (getLocation()).y + getHeight() / 2 - h / 2);
/* 2044 */     dlg.setSize(w, h);
/* 2045 */     dlg.setResizable(false);
/* 2046 */     dlg.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   void miFloodLight_actionPerformed(ActionEvent e) {
/* 2051 */     FloodLightSettingsDialog dlg = new FloodLightSettingsDialog(this, null, true);
/* 2052 */     int w = 400, h = 300;
/* 2053 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - w / 2, (getLocation()).y + getHeight() / 2 - h / 2);
/* 2054 */     dlg.setSize(w, h);
/* 2055 */     dlg.setResizable(false);
/* 2056 */     dlg.setVisible(true);
/*      */   }
/*      */   
/*      */   void miAdvanced_actionPerformed(ActionEvent e) {
/* 2060 */     AdvancedSettingsDialog dlg = new AdvancedSettingsDialog(this, null, true);
/* 2061 */     dlg.setTitle("Advanced Settings");
/* 2062 */     int w = 400, h = 300;
/* 2063 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - w / 2, (getLocation()).y + getHeight() / 2 - h / 2);
/* 2064 */     dlg.setSize(w, h);
/* 2065 */     dlg.setResizable(false);
/* 2066 */     dlg.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miHelp_actionPerformed(ActionEvent e) {
/*      */     try {
/* 2074 */       File root = new File(".");
/* 2075 */       String helpUrl = String.valueOf(root.getAbsolutePath()) + File.separator + "FlashHelp" + File.separator + "Help.htm";
/* 2076 */       RoboHelp_CSH.RH_ShowHelp(0, helpUrl, 0, 0);
/*      */     }
/* 2078 */     catch (Exception ex) {
/*      */       
/* 2080 */       JOptionPane.showMessageDialog(this, ex);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void miUploadTour_actionPerformed(ActionEvent e) {
/*      */     try {
/* 2088 */       BrowserUtil.displayURL("http://www.vadosity.com/ToolkitUploadTour.do");
/*      */     }
/* 2090 */     catch (Exception e2) {
/*      */       
/* 2092 */       JOptionPane.showMessageDialog(this, e2, "Error", 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void miNewProject_actionPerformed(ActionEvent e) {
/*      */     try {
/* 2099 */       NewProjectDialog dlg = new NewProjectDialog(this);
/* 2100 */       dlg.setSize(480, 160);
/* 2101 */       dlg.setLocation((getLocation()).x + getWidth() / 2 - dlg.getWidth() / 2, (getLocation()).y + getHeight() / 2 - dlg.getHeight() / 2);
/* 2102 */       dlg.setDefaultCloseOperation(2);
/* 2103 */       dlg.setModal(true);
/* 2104 */       dlg.setVisible(true);
/* 2105 */       int result = dlg.getResult();
/* 2106 */       if (result == 2)
/* 2107 */         return;  openCurrentProject();
/*      */     }
/* 2109 */     catch (Exception exception) {}
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void miOpenProject_actionPerformed(ActionEvent e) {
/* 2115 */     File f = RegistryInterface.getCurrentProjectDirectory();
/*      */     
/*      */     try {
/* 2118 */       JDirChooser chooser = new JDirChooser();
/* 2119 */       chooser.setSelectedFile(f);
/* 2120 */       chooser.setFileSelectionMode(1);
/*      */       
/* 2122 */       int result = chooser.showDialog(this, "Select Project Directory", null);
/* 2123 */       if (result == 1)
/*      */         return; 
/* 2125 */       f = chooser.getSelectedFile();
/* 2126 */       RegistryInterface.setCurrentProjectDirectory(f.getAbsolutePath());
/*      */       
/* 2128 */       openCurrentProject();
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 2133 */     catch (Exception ex) {
/*      */       
/* 2135 */       ex.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void miAddPhotos_actionPerformed(ActionEvent e) {
/* 2146 */     ImportPhotosDialog dlg = new ImportPhotosDialog(this, "Add Photos to Project", true);
/* 2147 */     dlg.setSize(500, 250);
/* 2148 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - dlg.getWidth() / 2, (getLocation()).y + getHeight() / 2 - dlg.getHeight() / 2);
/* 2149 */     dlg.setVisible(true);
/* 2150 */     setupPhotoDirectory(RegistryInterface.getCurrentProjectDirectory().getAbsolutePath());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void listPhotos_keyTyped(KeyEvent e) {
/*      */     try {
/* 2159 */       String[] sa = new String[2];
/* 2160 */       sa[0] = "iexplore";
/* 2161 */       sa[1] = RegistryInterface.getCurrentProjectDirectory().getAbsolutePath();
/*      */       
/* 2163 */       Runtime.getRuntime().exec(sa);
/*      */     }
/* 2165 */     catch (Exception ex) {
/*      */       
/* 2167 */       JOptionPane.showMessageDialog(this, ex.toString());
/*      */     } 
/* 2169 */     setupPhotoDirectory(RegistryInterface.getCurrentProjectDirectory().getAbsolutePath());
/*      */   }
/*      */ 
/*      */   
/*      */   void miFirst_actionPerformed(ActionEvent e) {
/* 2174 */     Global.stopRunner();
/* 2175 */     Global.selectFirstPhoto(this);
/*      */   }
/*      */   
/*      */   void miPrevious_actionPerformed(ActionEvent e) {
/* 2179 */     Global.stopRunner();
/* 2180 */     Global.selectPreviousPhoto(this);
/*      */   }
/*      */   
/*      */   void miNext_actionPerformed(ActionEvent e) {
/* 2184 */     Global.stopRunner();
/* 2185 */     Global.selectNextPhoto(this);
/*      */   }
/*      */ 
/*      */   
/*      */   void miLast_actionPerformed(ActionEvent e) {
/* 2190 */     Global.stopRunner();
/* 2191 */     Global.selectLastPhoto(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLicenseOk(boolean licenseOk) {
/* 2203 */     this.licenseOk = licenseOk;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDaysRemaining() {
/* 2209 */     return this.daysRemaining;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDaysRemaining(int daysRemaining) {
/* 2215 */     this.daysRemaining = daysRemaining;
/*      */   }
/*      */ 
/*      */   
/*      */   void miTitleDialog_actionPerformed(ActionEvent e) {
/* 2220 */     if (Global.getTour() == null) {
/*      */       
/* 2222 */       String message = "No Tour Loaded\n\nUnable to set Title";
/* 2223 */       String title = "Unable to set title";
/* 2224 */       JOptionPane.showMessageDialog(this, message, title, 
/* 2225 */           2);
/*      */       
/*      */       return;
/*      */     } 
/* 2229 */     TourTitleDialog dlg = new TourTitleDialog();
/* 2230 */     int x = (int)(getLocationOnScreen().getX() + (getWidth() / 2) - (dlg.getWidth() / 2));
/* 2231 */     int y = (int)(getLocationOnScreen().getY() + (getHeight() / 2) - (dlg.getHeight() / 2));
/* 2232 */     dlg.setLocation(x, y);
/* 2233 */     dlg.setVisible(true);
/*      */   }
/*      */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\VadosityToolkit.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */