/*      */ package com.vadosity.vnav.map;
/*      */ 
/*      */ import com.vadosity.vnav.bean.Tour;
/*      */ import com.vadosity.vnav.bean.View;
/*      */ import com.vadosity.vnav.client.FileUtility;
/*      */ import com.vadosity.vnav.client.Global;
/*      */ import com.vadosity.vnav.client.ImageUtil;
/*      */ import com.vadosity.vnav.client.RegistryInterface;
/*      */ import com.vadosity.vnav.client.SessionUtil;
/*      */ import com.vadosity.vnav.client.VadosityToolkit;
/*      */ import com.vadosity.vnav.client.WaitDialog;
/*      */ import com.vadosity.vnav.client.filefilter.JpegFileFilter;
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Frame;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Insets;
/*      */ import java.awt.LayoutManager;
/*      */ import java.awt.Point;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ComponentEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.io.DataInputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.URL;
/*      */ import java.util.Vector;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JMenuBar;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSlider;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.SwingUtilities;
/*      */ import javax.swing.UIManager;
/*      */ import javax.swing.border.TitledBorder;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.filechooser.FileFilter;
/*      */ import sun.awt.image.codec.JPEGImageEncoderImpl;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TerraFrame
/*      */   extends JFrame
/*      */ {
/*   67 */   JLabel lblLat = new JLabel();
/*   68 */   JLabel lblLon = new JLabel();
/*   69 */   JTextField tfLat = new JTextField();
/*   70 */   JTextField tfLon = new JTextField();
/*   71 */   JLabel lblWidth = new JLabel();
/*   72 */   JLabel lblHeight = new JLabel();
/*   73 */   JButton btnGetMap = new JButton();
/*   74 */   MapRequestor mapRequestor = null;
/*   75 */   JMenuBar menuBar = new JMenuBar();
/*   76 */   int numMaps = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   81 */   String theme = null;
/*   82 */   int widthInPixels = 800;
/*   83 */   int heightInPixels = 600;
/*   84 */   double longitude = -1.0D;
/*   85 */   double latitude = -1.0D;
/*      */   
/*   87 */   String meterPerPixel1 = "1 meter per pixel";
/*   88 */   String metersPerPixel2 = "2 meters per pixel";
/*   89 */   String metersPerPixel4 = "4 meters per pixel";
/*   90 */   String metersPerPixel8 = "8 meters per pixel";
/*   91 */   String metersPerPixel16 = "16 meters per pixel";
/*   92 */   String metersPerPixel32 = "32 meters per pixel";
/*   93 */   String metersPerPixel64 = "64 meters per pixel";
/*   94 */   String metersPerPixel128 = "128 meters per pixel";
/*   95 */   String metersPerPixel256 = "256 meters per pixel";
/*   96 */   String metersPerPixel512 = "512 meters per pixel";
/*      */   
/*   98 */   Scale scale = null;
/*      */ 
/*      */   
/*  101 */   byte[] imageBytes = null;
/*  102 */   byte[] overlayImageBytes = null;
/*      */   
/*      */   boolean mapModified = false;
/*  105 */   JPanel panelNorth = new JPanel();
/*  106 */   GridBagLayout gridBagLayout2 = new GridBagLayout();
/*  107 */   BorderLayout borderLayout1 = new BorderLayout();
/*  108 */   JComboBox cbPixelWidth = new JComboBox();
/*  109 */   JComboBox cbPixelHeight = new JComboBox();
/*  110 */   JLabel lblScale = new JLabel();
/*  111 */   JButton btnLookup = new JButton();
/*  112 */   JPanel panelMapDimensions = new JPanel();
/*      */   TitledBorder borderMapDimensions;
/*      */   TitledBorder borderMapCoordinates;
/*  115 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  116 */   JPanel panelCoordinates = new JPanel();
/*  117 */   GridBagLayout gridBagLayout3 = new GridBagLayout();
/*  118 */   JComboBox cbScale = new JComboBox();
/*  119 */   JPanel panelGetMap = new JPanel();
/*      */   TitledBorder borderMapType;
/*  121 */   JRadioButton radioSatellite = new JRadioButton();
/*  122 */   JRadioButton radioTopo = new JRadioButton();
/*  123 */   GridBagLayout gridBagLayout4 = new GridBagLayout();
/*  124 */   ButtonGroup groupMapType = new ButtonGroup();
/*  125 */   JPanel panelNavigation = new JPanel();
/*      */   TitledBorder borderNavigation;
/*  127 */   GridBagLayout gridBagLayout5 = new GridBagLayout();
/*  128 */   WestButton westButton = new WestButton();
/*  129 */   NorthWestButton northWestButton = new NorthWestButton();
/*  130 */   SouthWestButton southWestButton = new SouthWestButton();
/*  131 */   NorthButton northButton = new NorthButton();
/*  132 */   EastButton eastButton = new EastButton();
/*  133 */   SouthEastButton southEastButton = new SouthEastButton();
/*  134 */   SouthButton southButton = new SouthButton();
/*  135 */   NorthEastButton northEastButton = new NorthEastButton();
/*  136 */   JPanel panelButtons = new JPanel();
/*  137 */   GridBagLayout gridBagLayout6 = new GridBagLayout();
/*  138 */   JButton btnSaveImage = new JButton();
/*  139 */   JButton btnCreateView = new JButton();
/*  140 */   TerraImagePanel terraImagePanel = new TerraImagePanel();
/*  141 */   BorderLayout borderLayout2 = new BorderLayout();
/*  142 */   JButton btnOk = new JButton();
/*  143 */   JLabel jLabel3 = new JLabel();
/*  144 */   JPanel panelSouth = new JPanel();
/*  145 */   JLabel lblBytes = new JLabel();
/*  146 */   GridBagLayout gridBagLayout7 = new GridBagLayout();
/*  147 */   JScrollPane scrollPaneMap = new JScrollPane();
/*  148 */   JRadioButton radioBoth = new JRadioButton();
/*  149 */   JSlider sliderTopo = new JSlider();
/*      */ 
/*      */   
/*      */   public boolean isMapModified() {
/*  153 */     return this.mapModified; } public void setMapModified(boolean b) {
/*  154 */     this.mapModified = b;
/*      */   }
/*      */   
/*      */   private void populateComboBoxes() {
/*  158 */     populatePixelWidth();
/*  159 */     populatePixelHeight();
/*      */   }
/*      */ 
/*      */   
/*      */   private void populatePixelWidth() {
/*  164 */     this.cbPixelWidth.removeAllItems();
/*      */ 
/*      */     
/*  167 */     this.cbPixelWidth.addItem(new Integer(400));
/*  168 */     this.cbPixelWidth.addItem(new Integer(500));
/*  169 */     this.cbPixelWidth.addItem(new Integer(600));
/*  170 */     this.cbPixelWidth.addItem(new Integer(700));
/*  171 */     this.cbPixelWidth.addItem(new Integer(800));
/*  172 */     this.cbPixelWidth.addItem(new Integer(1000));
/*  173 */     this.cbPixelWidth.addItem(new Integer(1200));
/*  174 */     this.cbPixelWidth.addItem(new Integer(1500));
/*  175 */     this.cbPixelWidth.addItem(new Integer(2000));
/*      */     
/*  177 */     this.cbPixelWidth.setMinimumSize(new Dimension(60, 21));
/*  178 */     this.cbPixelWidth.setPreferredSize(new Dimension(60, 21));
/*  179 */     this.cbPixelWidth.setSelectedItem(new Integer(600));
/*  180 */     this.cbPixelWidth.addActionListener(new TerraFrame_cbPixelWidth_actionAdapter(this));
/*      */   }
/*      */ 
/*      */   
/*      */   private void populatePixelHeight() {
/*  185 */     this.cbPixelHeight.removeAllItems();
/*      */     
/*  187 */     this.cbPixelHeight.addItem(new Integer(400));
/*  188 */     this.cbPixelHeight.addItem(new Integer(500));
/*  189 */     this.cbPixelHeight.addItem(new Integer(600));
/*  190 */     this.cbPixelHeight.addItem(new Integer(700));
/*  191 */     this.cbPixelHeight.addItem(new Integer(800));
/*  192 */     this.cbPixelHeight.addItem(new Integer(1000));
/*  193 */     this.cbPixelHeight.addItem(new Integer(1200));
/*  194 */     this.cbPixelHeight.addItem(new Integer(1500));
/*  195 */     this.cbPixelHeight.addItem(new Integer(2000));
/*      */     
/*  197 */     this.cbPixelHeight.setMinimumSize(new Dimension(60, 21));
/*  198 */     this.cbPixelHeight.setPreferredSize(new Dimension(60, 21));
/*  199 */     this.cbPixelHeight.setSelectedItem(new Integer(400));
/*  200 */     this.cbPixelHeight.addActionListener(new TerraFrame_cbPixelHeight_actionAdapter(this));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TerraFrame(Frame frame, String title, boolean modal) {
/*  210 */     super(title);
/*      */     
/*  212 */     setIconImage((new ImageIcon(ImageUtil.loadVadosityImage())).getImage());
/*      */ 
/*      */     
/*  215 */     this.theme = new String("1");
/*      */ 
/*      */     
/*  218 */     this.cbScale.addItem(new Scale(this.metersPerPixel2, 11, 2));
/*  219 */     this.cbScale.addItem(new Scale(this.metersPerPixel4, 12, 4));
/*  220 */     this.cbScale.addItem(new Scale(this.metersPerPixel8, 13, 8));
/*  221 */     this.cbScale.addItem(new Scale(this.metersPerPixel16, 14, 16));
/*  222 */     this.cbScale.addItem(new Scale(this.metersPerPixel32, 15, 32));
/*  223 */     this.cbScale.addItem(new Scale(this.metersPerPixel64, 16, 64));
/*  224 */     this.cbScale.addItem(new Scale(this.metersPerPixel128, 17, 128));
/*  225 */     this.cbScale.addItem(new Scale(this.metersPerPixel256, 18, 256));
/*  226 */     this.cbScale.addItem(new Scale(this.metersPerPixel512, 19, 512));
/*      */ 
/*      */     
/*      */     try {
/*  230 */       jbInit();
/*  231 */       setLookAndFeel();
/*  232 */       setupLatLon();
/*      */     }
/*  234 */     catch (Exception e) {
/*      */       
/*  236 */       e.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setupLatLon() {
/*  243 */     if (Global.getTour() == null)
/*  244 */       return;  double lat = Global.getTour().getLatitude();
/*  245 */     double lon = Global.getTour().getLongitude();
/*  246 */     if (lat == 0.0D || lon == 0.0D) {
/*      */       return;
/*      */     }
/*  249 */     lat = MapUtility.round7(lat);
/*  250 */     lon = MapUtility.round7(lon);
/*  251 */     this.tfLat.setText(lat);
/*  252 */     this.tfLon.setText(lon);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setLookAndFeel() {
/*      */     try {
/*  259 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*  260 */       SwingUtilities.updateComponentTreeUI(this);
/*  261 */       pack();
/*      */     }
/*  263 */     catch (Exception e) {
/*      */       
/*  265 */       e.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jbInit() throws Exception {
/*  271 */     this.btnCreateView.setMargin(new Insets(2, 4, 2, 4));
/*  272 */     this.borderMapDimensions = new TitledBorder("Map Dimensions");
/*  273 */     this.borderMapCoordinates = new TitledBorder("Map Coordinates");
/*  274 */     this.borderMapType = new TitledBorder("Map Type");
/*  275 */     this.borderNavigation = new TitledBorder("Navigation");
/*  276 */     this.lblLat.setHorizontalAlignment(4);
/*  277 */     this.lblLat.setHorizontalTextPosition(4);
/*  278 */     this.lblLat.setText("Latitude");
/*  279 */     getContentPane().setLayout(this.borderLayout1);
/*  280 */     this.lblLon.setHorizontalAlignment(4);
/*  281 */     this.lblLon.setHorizontalTextPosition(4);
/*  282 */     this.lblLon.setText("Longitude");
/*  283 */     this.tfLat.setMinimumSize(new Dimension(70, 21));
/*  284 */     this.tfLat.setPreferredSize(new Dimension(100, 21));
/*  285 */     this.tfLat.setText("38.9112473");
/*  286 */     this.tfLon.setMinimumSize(new Dimension(70, 21));
/*  287 */     this.tfLon.setPreferredSize(new Dimension(100, 21));
/*  288 */     this.tfLon.setText("-76.8946152");
/*  289 */     this.lblWidth.setMaximumSize(new Dimension(27, 15));
/*  290 */     this.lblWidth.setMinimumSize(new Dimension(30, 15));
/*  291 */     this.lblWidth.setPreferredSize(new Dimension(30, 15));
/*  292 */     this.lblWidth.setHorizontalAlignment(2);
/*  293 */     this.lblWidth.setHorizontalTextPosition(4);
/*  294 */     this.lblWidth.setText(" Width");
/*  295 */     this.lblHeight.setMaximumSize(new Dimension(30, 15));
/*  296 */     this.lblHeight.setMinimumSize(new Dimension(30, 15));
/*  297 */     this.lblHeight.setHorizontalAlignment(2);
/*  298 */     this.lblHeight.setHorizontalTextPosition(2);
/*  299 */     this.lblHeight.setText("Height");
/*  300 */     this.btnGetMap.setText("Get Map Now");
/*  301 */     this.btnGetMap.addActionListener(new TerraFrame_btnGetMap_actionAdapter(this));
/*      */     
/*  303 */     addComponentListener(new TerraFrame_this_componentAdapter(this));
/*  304 */     this.lblScale.setMaximumSize(new Dimension(50, 15));
/*  305 */     this.lblScale.setMinimumSize(new Dimension(50, 15));
/*  306 */     this.lblScale.setPreferredSize(new Dimension(50, 15));
/*  307 */     this.lblScale.setHorizontalAlignment(2);
/*  308 */     this.lblScale.setHorizontalTextPosition(2);
/*  309 */     this.lblScale.setText("Scale");
/*  310 */     this.btnLookup.setText("Lookup Coordinates");
/*  311 */     this.btnLookup.addActionListener(new TerraFrame_btnLookup_actionAdapter(this));
/*  312 */     this.panelMapDimensions.setBorder(this.borderMapDimensions);
/*  313 */     this.panelMapDimensions.setMinimumSize(new Dimension(200, 120));
/*  314 */     this.panelMapDimensions.setPreferredSize(new Dimension(200, 120));
/*  315 */     this.panelMapDimensions.setLayout(this.gridBagLayout1);
/*  316 */     this.panelCoordinates.setBorder(this.borderMapCoordinates);
/*  317 */     this.panelCoordinates.setMinimumSize(new Dimension(180, 120));
/*  318 */     this.panelCoordinates.setPreferredSize(new Dimension(180, 120));
/*  319 */     this.panelCoordinates.setLayout(this.gridBagLayout3);
/*  320 */     this.cbScale.setMinimumSize(new Dimension(100, 21));
/*  321 */     this.cbScale.setPreferredSize(new Dimension(100, 21));
/*  322 */     this.cbScale.setMaximumRowCount(12);
/*  323 */     this.cbScale.addActionListener(new TerraFrame_cbScale_actionAdapter(this));
/*  324 */     this.panelGetMap.setBorder(this.borderMapType);
/*  325 */     this.panelGetMap.setLayout(this.gridBagLayout4);
/*  326 */     this.radioSatellite.setActionCommand("Satellite Photo");
/*  327 */     this.radioSatellite.setSelected(true);
/*  328 */     this.radioSatellite.setText("Satellite Photo");
/*  329 */     this.radioSatellite.addActionListener(new TerraFrame_radioSatellite_actionAdapter(this));
/*  330 */     this.radioTopo.setText("Topographic Map");
/*  331 */     this.radioTopo.addActionListener(new TerraFrame_radioTopo_actionAdapter(this));
/*  332 */     this.panelNavigation.setBorder(this.borderNavigation);
/*  333 */     this.panelNavigation.setMinimumSize(new Dimension(90, 90));
/*  334 */     this.panelNavigation.setPreferredSize(new Dimension(90, 90));
/*  335 */     this.panelNavigation.setLayout(this.gridBagLayout5);
/*  336 */     this.westButton.setMaximumSize(new Dimension(80, 80));
/*  337 */     this.westButton.setMinimumSize(new Dimension(30, 30));
/*  338 */     this.westButton.setPreferredSize(new Dimension(30, 30));
/*  339 */     this.westButton.setText("");
/*  340 */     this.westButton.addActionListener(new TerraFrame_westButton_actionAdapter(this));
/*  341 */     this.southWestButton.setMaximumSize(new Dimension(80, 80));
/*  342 */     this.southWestButton.setMinimumSize(new Dimension(30, 30));
/*  343 */     this.southWestButton.setPreferredSize(new Dimension(30, 30));
/*  344 */     this.southWestButton.setText("");
/*  345 */     this.southWestButton.addActionListener(new TerraFrame_southWestButton_actionAdapter(this));
/*  346 */     this.northWestButton.setMaximumSize(new Dimension(80, 80));
/*  347 */     this.northWestButton.setMinimumSize(new Dimension(30, 30));
/*  348 */     this.northWestButton.setPreferredSize(new Dimension(30, 30));
/*  349 */     this.northWestButton.setText("");
/*  350 */     this.northWestButton.addActionListener(new TerraFrame_northWestButton_actionAdapter(this));
/*  351 */     this.northButton.setText("");
/*  352 */     this.northButton.addActionListener(new TerraFrame_northButton_actionAdapter(this));
/*  353 */     this.northButton.setPreferredSize(new Dimension(30, 30));
/*  354 */     this.northButton.setMinimumSize(new Dimension(30, 30));
/*  355 */     this.northButton.setMaximumSize(new Dimension(80, 80));
/*  356 */     this.eastButton.setText("");
/*  357 */     this.eastButton.addActionListener(new TerraFrame_eastButton_actionAdapter(this));
/*  358 */     this.eastButton.setPreferredSize(new Dimension(30, 30));
/*  359 */     this.eastButton.setMinimumSize(new Dimension(30, 30));
/*  360 */     this.eastButton.setMaximumSize(new Dimension(32767, 32767));
/*  361 */     this.southEastButton.setText("");
/*  362 */     this.southEastButton.addActionListener(new TerraFrame_southEastButton_actionAdapter(this));
/*  363 */     this.southEastButton.setPreferredSize(new Dimension(30, 30));
/*  364 */     this.southEastButton.setMinimumSize(new Dimension(30, 30));
/*  365 */     this.southEastButton.setMaximumSize(new Dimension(80, 80));
/*  366 */     this.southButton.setText("");
/*  367 */     this.southButton.addActionListener(new TerraFrame_southButton_actionAdapter(this));
/*  368 */     this.southButton.setPreferredSize(new Dimension(30, 30));
/*  369 */     this.southButton.setMinimumSize(new Dimension(30, 30));
/*  370 */     this.southButton.setMaximumSize(new Dimension(80, 80));
/*  371 */     this.northEastButton.setText("");
/*  372 */     this.northEastButton.addActionListener(new TerraFrame_northEastButton_actionAdapter(this));
/*  373 */     this.northEastButton.setPreferredSize(new Dimension(30, 30));
/*  374 */     this.northEastButton.setMinimumSize(new Dimension(30, 30));
/*  375 */     this.northEastButton.setMaximumSize(new Dimension(80, 80));
/*  376 */     this.panelButtons.setMinimumSize(new Dimension(120, 80));
/*  377 */     this.panelButtons.setPreferredSize(new Dimension(200, 80));
/*  378 */     this.panelButtons.setLayout(this.gridBagLayout6);
/*  379 */     this.btnSaveImage.setText("Save Image");
/*  380 */     this.btnSaveImage.addActionListener(new TerraFrame_btnSaveImage_actionAdapter(this));
/*  381 */     this.btnCreateView.setText("Create View");
/*  382 */     this.btnCreateView.addActionListener(new TerraFrame_btnCreateView_actionAdapter(this));
/*      */     
/*  384 */     setJMenuBar(this.menuBar);
/*  385 */     setTitle("VadosityToolkit Satellite Map Utility (USA Only)");
/*  386 */     this.panelNorth.setLayout(this.gridBagLayout2);
/*  387 */     this.panelNorth.setMinimumSize(new Dimension(400, 160));
/*  388 */     this.panelNorth.setPreferredSize(new Dimension(600, 160));
/*  389 */     this.terraImagePanel.setBackground(Color.white);
/*  390 */     this.terraImagePanel.setMinimumSize(new Dimension(600, 400));
/*  391 */     this.terraImagePanel.setPreferredSize(new Dimension(600, 400));
/*  392 */     this.terraImagePanel.setToolTipText("Click on Point  to Center Image");
/*  393 */     this.terraImagePanel.setVerifyInputWhenFocusTarget(true);
/*  394 */     this.terraImagePanel.addMouseListener(new TerraFrame_imagePanel_mouseAdapter(this));
/*  395 */     this.btnOk.setText("OK");
/*  396 */     this.btnOk.addActionListener(new TerraFrame_btnOk_actionAdapter(this));
/*  397 */     this.jLabel3.setMaximumSize(new Dimension(10, 15));
/*  398 */     this.jLabel3.setMinimumSize(new Dimension(40, 15));
/*  399 */     this.jLabel3.setPreferredSize(new Dimension(10, 15));
/*  400 */     this.jLabel3.setText(".");
/*  401 */     this.panelSouth.setMinimumSize(new Dimension(200, 30));
/*  402 */     this.panelSouth.setPreferredSize(new Dimension(400, 30));
/*  403 */     this.panelSouth.setLayout(this.gridBagLayout7);
/*  404 */     this.lblBytes.setMaximumSize(new Dimension(34, 15));
/*  405 */     this.lblBytes.setMinimumSize(new Dimension(250, 15));
/*  406 */     this.lblBytes.setPreferredSize(new Dimension(250, 15));
/*  407 */     this.lblBytes.setText("0 Bytes");
/*      */     
/*  409 */     this.radioBoth.setText("Both");
/*  410 */     this.radioBoth.addActionListener(new TerraFrame_radioBoth_actionAdapter(this));
/*  411 */     this.sliderTopo.setOrientation(1);
/*  412 */     this.sliderTopo.setPaintLabels(true);
/*  413 */     this.sliderTopo.setEnabled(false);
/*  414 */     this.sliderTopo.addChangeListener(new TerraFrame_sliderTopo_changeAdapter(this));
/*  415 */     getContentPane().add(this.scrollPaneMap, "Center");
/*  416 */     getContentPane().add(this.sliderTopo, "East");
/*  417 */     this.scrollPaneMap.getViewport().setLayout((LayoutManager)null);
/*  418 */     this.scrollPaneMap.getViewport().add((Component)this.terraImagePanel);
/*      */ 
/*      */     
/*  421 */     getContentPane().add(this.panelNorth, "North");
/*  422 */     this.panelNorth.add(this.panelMapDimensions, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 
/*  423 */           10, 1, new Insets(5, 1, 5, 1), 0, 0));
/*  424 */     this.panelMapDimensions.add(this.lblWidth, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  425 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  426 */     this.panelMapDimensions.add(this.cbPixelWidth, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  427 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  428 */     this.panelMapDimensions.add(this.lblHeight, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/*  429 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  430 */     this.panelMapDimensions.add(this.cbPixelHeight, new GridBagConstraints(1, 1, 2, 1, 0.0D, 0.0D, 
/*  431 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  432 */     this.panelMapDimensions.add(this.lblScale, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/*  433 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  434 */     this.panelMapDimensions.add(this.cbScale, new GridBagConstraints(1, 2, 1, 1, 1.0D, 0.0D, 
/*  435 */           17, 2, new Insets(5, 5, 5, 5), 0, 0));
/*  436 */     this.panelCoordinates.add(this.lblLon, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/*  437 */           13, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  438 */     this.panelCoordinates.add(this.tfLon, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 
/*  439 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  440 */     this.panelCoordinates.add(this.lblLat, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  441 */           17, 0, new Insets(0, 5, 5, 5), 0, 0));
/*  442 */     this.panelCoordinates.add(this.tfLat, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  443 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  444 */     this.panelCoordinates.add(this.btnLookup, new GridBagConstraints(0, 2, 2, 1, 0.0D, 0.0D, 
/*  445 */           10, 2, new Insets(5, 5, 5, 5), 0, 0));
/*  446 */     this.panelNorth.add(this.panelButtons, new GridBagConstraints(4, 0, 1, 2, 0.0D, 0.0D, 
/*  447 */           10, 1, new Insets(5, 5, 5, 5), 0, 0));
/*  448 */     this.panelButtons.add(this.btnSaveImage, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/*  449 */           10, 2, new Insets(0, 5, 5, 5), 0, 0));
/*  450 */     this.panelNorth.add(this.panelNavigation, new GridBagConstraints(3, 1, 1, 1, 0.0D, 0.0D, 
/*  451 */           10, 3, new Insets(5, 1, 5, 1), 24, 0));
/*  452 */     this.panelNavigation.add(this.westButton, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/*  453 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  454 */     this.panelNavigation.add(this.northWestButton, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  455 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  456 */     this.panelNavigation.add(this.southWestButton, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/*  457 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  458 */     this.panelNavigation.add(this.northButton, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  459 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  460 */     this.panelNavigation.add(this.southEastButton, new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 
/*  461 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  462 */     this.panelNavigation.add(this.southButton, new GridBagConstraints(1, 2, 1, 1, 0.0D, 0.0D, 
/*  463 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  464 */     this.panelNavigation.add(this.northEastButton, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 
/*  465 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  466 */     this.panelNavigation.add(this.eastButton, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/*  467 */           13, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  468 */     this.panelNorth.add(this.panelGetMap, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/*  469 */           10, 1, new Insets(5, 1, 5, 1), 0, 0));
/*  470 */     this.panelGetMap.add(this.radioTopo, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/*  471 */           17, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  472 */     this.panelGetMap.add(this.radioSatellite, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  473 */           17, 0, new Insets(0, 0, 0, 0), 0, 0));
/*  474 */     this.panelGetMap.add(this.radioBoth, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/*  475 */           17, 2, new Insets(0, 0, 0, 0), 0, 0));
/*  476 */     this.panelGetMap.add(this.btnGetMap, new GridBagConstraints(0, 3, 2, 1, 1.0D, 0.0D, 
/*  477 */           17, 2, new Insets(5, 5, 5, 5), 0, 0));
/*  478 */     this.panelNorth.add(this.panelCoordinates, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/*  479 */           10, 1, new Insets(5, 5, 5, 1), 0, 0));
/*      */     
/*  481 */     getContentPane().add(this.jLabel3, "West");
/*      */     
/*  483 */     this.sliderTopo.setValue(20);
/*      */ 
/*      */     
/*  486 */     populateComboBoxes();
/*  487 */     this.groupMapType.add(this.radioTopo);
/*  488 */     this.groupMapType.add(this.radioSatellite);
/*  489 */     this.groupMapType.add(this.radioBoth);
/*  490 */     this.panelButtons.add(this.btnCreateView, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/*  491 */           10, 2, new Insets(5, 5, 5, 5), 0, 0));
/*  492 */     this.panelButtons.add(this.btnOk, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  493 */           10, 2, new Insets(5, 5, 5, 5), 0, 0));
/*  494 */     getContentPane().add(this.panelSouth, "South");
/*  495 */     this.panelSouth.add(this.lblBytes, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  496 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*      */     
/*  498 */     this.btnGetMap.setIcon(new ImageIcon(ImageUtil.loadLightningImage()));
/*      */     
/*  500 */     this.radioBoth.setSelected(true);
/*  501 */     this.cbScale.setSelectedIndex(1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void btnGetMap_actionPerformed(ActionEvent e) {
/*  509 */     getMap();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isLatitudeOk() {
/*      */     try {
/*  516 */       this.latitude = Double.parseDouble(this.tfLat.getText().trim());
/*  517 */       if (this.latitude < 0.0D) {
/*      */         
/*  519 */         this.latitude = Math.abs(this.latitude);
/*  520 */         this.tfLat.setText(this.latitude);
/*      */       } 
/*  522 */       this.latitude = MapUtility.round7(this.latitude);
/*  523 */       return true;
/*      */     }
/*  525 */     catch (Exception ex) {
/*      */       
/*  527 */       String message = "Please enter a numeric latitude coordinate. \nOmit North/South (N/S) references. (USA Only)";
/*  528 */       String title = "Invalid Latitude Format";
/*  529 */       JOptionPane.showMessageDialog(this, message, title, 2);
/*  530 */       this.tfLat.requestFocus();
/*  531 */       this.tfLat.selectAll();
/*  532 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isLongitudeOk() {
/*      */     try {
/*  540 */       this.longitude = Double.parseDouble(this.tfLon.getText().trim());
/*  541 */       if (this.longitude > 0.0D) {
/*      */         
/*  543 */         this.longitude = -this.longitude;
/*  544 */         this.tfLon.setText(this.longitude);
/*      */       } 
/*  546 */       this.longitude = MapUtility.round7(this.longitude);
/*  547 */       return true;
/*      */     }
/*  549 */     catch (Exception ex) {
/*      */       
/*  551 */       String message = "Please enter a numeric longitude coordinate. \nOmit East/West (E/W) references. (USA Only)";
/*  552 */       String title = "Invalid Longitude Format";
/*  553 */       JOptionPane.showMessageDialog(this, message, title, 2);
/*  554 */       this.tfLon.requestFocus();
/*  555 */       this.tfLon.selectAll();
/*  556 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void determineTheme() {
/*  562 */     if (this.radioSatellite.isSelected()) this.theme = "1"; 
/*  563 */     if (this.radioTopo.isSelected()) this.theme = "2"; 
/*  564 */     if (this.radioBoth.isSelected()) this.theme = "1";
/*      */   
/*      */   }
/*      */   
/*      */   public void readImageBytes(String sUrl) {
/*  569 */     URL url = null;
/*  570 */     HttpURLConnection httpConn = null;
/*  571 */     DataInputStream dis = null;
/*  572 */     Vector vBytes = new Vector();
/*      */ 
/*      */     
/*      */     try {
/*  576 */       url = new URL(sUrl);
/*  577 */       httpConn = (HttpURLConnection)url.openConnection();
/*  578 */       httpConn.setDoInput(true);
/*  579 */       httpConn.setDoOutput(false);
/*  580 */       dis = new DataInputStream(httpConn.getInputStream());
/*  581 */       vBytes = new Vector();
/*  582 */       boolean ok = true;
/*  583 */       while (ok)
/*      */       {
/*  585 */         vBytes.add(new Byte(dis.readByte()));
/*      */       }
/*  587 */       throw new RuntimeException("This should never be reached -EOF not being thrown");
/*      */     }
/*  589 */     catch (Exception ex2) {
/*      */       
/*  591 */       if (ex2 instanceof java.io.EOFException) {
/*      */         
/*  593 */         this.imageBytes = null;
/*  594 */         this.imageBytes = new byte[vBytes.size()];
/*  595 */         for (int i = 0; i < vBytes.size(); i++)
/*      */         {
/*  597 */           this.imageBytes[i] = ((Byte)vBytes.elementAt(i)).byteValue();
/*      */         }
/*      */         
/*  600 */         vBytes.removeAllElements();
/*  601 */         vBytes = null;
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  606 */       ex2.printStackTrace();
/*      */     } finally {
/*      */ 
/*      */ 
/*      */       
/*      */       try { 
/*  612 */         dis.close(); } catch (Exception e) { e.printStackTrace(); }
/*  613 */        dis = null;
/*  614 */       httpConn.disconnect();
/*  615 */       httpConn = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] readImageBytes2(String sUrl) {
/*  623 */     byte[] bytes = (byte[])null;
/*  624 */     URL url = null;
/*  625 */     HttpURLConnection httpConn = null;
/*  626 */     DataInputStream dis = null;
/*  627 */     Vector vBytes = new Vector();
/*      */ 
/*      */     
/*      */     try {
/*  631 */       url = new URL(sUrl);
/*  632 */       httpConn = (HttpURLConnection)url.openConnection();
/*  633 */       httpConn.setDoInput(true);
/*  634 */       httpConn.setDoOutput(false);
/*  635 */       dis = new DataInputStream(httpConn.getInputStream());
/*  636 */       vBytes = new Vector();
/*  637 */       boolean ok = true;
/*  638 */       while (ok)
/*      */       {
/*  640 */         vBytes.add(new Byte(dis.readByte()));
/*      */       }
/*  642 */       throw new RuntimeException("This should never be reached -EOF not being thrown");
/*      */     
/*      */     }
/*  645 */     catch (Exception ex2) {
/*      */       
/*  647 */       if (ex2 instanceof java.io.EOFException) {
/*      */         
/*  649 */         bytes = (byte[])null;
/*  650 */         bytes = new byte[vBytes.size()];
/*  651 */         for (int i = 0; i < vBytes.size(); i++)
/*      */         {
/*  653 */           bytes[i] = ((Byte)vBytes.elementAt(i)).byteValue();
/*      */         }
/*  655 */         vBytes.removeAllElements();
/*  656 */         vBytes = null;
/*      */       }
/*      */       else {
/*      */         
/*  660 */         JOptionPane.showMessageDialog(this, ex2);
/*      */       } 
/*      */     } finally {
/*      */ 
/*      */       
/*  665 */       try { dis.close(); } catch (Exception exception) {}
/*  666 */       dis = null;
/*  667 */       httpConn.disconnect();
/*  668 */       httpConn = null;
/*      */     } 
/*  670 */     return bytes;
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
/*      */   public void getMap() {
/*  682 */     if (!isLatitudeOk())
/*  683 */       return;  if (!isLongitudeOk())
/*  684 */       return;  if (!isInternetAvailable())
/*      */       return; 
/*  686 */     WaitDialog dlg = new WaitDialog(this, null, false);
/*  687 */     int dlgw = 200, dlgh = 60;
/*  688 */     dlg.setSize(dlgw, dlgh);
/*  689 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - dlgw / 2, 
/*  690 */         (getLocation()).y + getHeight() / 2 - dlgh / 2);
/*  691 */     dlg.setVisible(true);
/*      */ 
/*      */     
/*  694 */     if (Global.getTour() != null) {
/*      */       
/*  696 */       Global.getTour().setLatitude(this.latitude);
/*  697 */       Global.getTour().setLongitude(this.longitude);
/*      */     } 
/*      */     
/*  700 */     this.overlayImageBytes = null;
/*      */ 
/*      */     
/*  703 */     this.widthInPixels = ((Integer)this.cbPixelWidth.getSelectedItem()).intValue();
/*  704 */     this.heightInPixels = ((Integer)this.cbPixelHeight.getSelectedItem()).intValue();
/*  705 */     this.scale = (Scale)this.cbScale.getSelectedItem();
/*  706 */     determineTheme();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  712 */     String sUrl = SessionUtil.getTerraServerUrl();
/*  713 */     sUrl = String.valueOf(sUrl) + "?Lon=" + this.longitude + "&Lat=" + this.latitude + "&S=" + this.scale.getValue() + 
/*  714 */       "&T=" + this.theme + "&W=" + this.widthInPixels + "&H=" + this.heightInPixels;
/*  715 */     readImageBytes(sUrl);
/*      */     
/*  717 */     Image image = Toolkit.getDefaultToolkit().createImage(this.imageBytes);
/*  718 */     this.terraImagePanel.setImage(image);
/*      */     
/*  720 */     if (this.radioBoth.isSelected()) {
/*      */       
/*  722 */       this.overlayImageBytes = null;
/*  723 */       this.terraImagePanel.setOverlayImage((Image)null);
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/*  728 */         sUrl = SessionUtil.getTerraServerUrl();
/*  729 */         sUrl = String.valueOf(sUrl) + "?Lon=" + this.longitude + "&Lat=" + this.latitude + "&S=" + this.scale.getValue() + 
/*  730 */           "&T=" + (this.theme.equals("1") ? "2" : "1") + "&W=" + this.widthInPixels + "&H=" + this.heightInPixels;
/*      */         
/*  732 */         this.overlayImageBytes = readImageBytes2(sUrl);
/*  733 */         Image im2 = Toolkit.getDefaultToolkit().createImage(this.overlayImageBytes);
/*  734 */         this.terraImagePanel.setOverlayImage(im2);
/*      */         
/*  736 */         this.sliderTopo.setEnabled(true);
/*      */       
/*      */       }
/*  739 */       catch (Exception exception) {}
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/*  745 */       this.terraImagePanel.setOverlayImage((Image)null);
/*  746 */       this.sliderTopo.setEnabled(false);
/*  747 */       this.overlayImageBytes = null;
/*      */     } 
/*      */     
/*  750 */     dlg.dispose();
/*      */     
/*  752 */     if (this.radioBoth.isSelected() && this.overlayImageBytes != null) {
/*      */       
/*  754 */       int numBytes = this.imageBytes.length + this.overlayImageBytes.length;
/*  755 */       this.lblBytes.setText("Bytes:  " + numBytes);
/*      */     } else {
/*  757 */       this.lblBytes.setText("Bytes: " + this.imageBytes.length);
/*      */     } 
/*      */     
/*  760 */     int spW = this.scrollPaneMap.getWidth();
/*  761 */     int spH = this.scrollPaneMap.getHeight();
/*  762 */     int w = this.terraImagePanel.getWidth();
/*  763 */     int h = this.terraImagePanel.getHeight();
/*      */     
/*  765 */     if (spW > w && spH > h) {
/*      */ 
/*      */       
/*  768 */       int x = spW / 2 - w / 2;
/*  769 */       int y = spH / 2 - h / 2;
/*  770 */       this.terraImagePanel.setBounds(x, y, w, h);
/*  771 */       this.terraImagePanel.updateUI();
/*      */     }
/*  773 */     else if (spW < w && spH < h) {
/*      */       
/*  775 */       int x = w / 2 - spW / 2;
/*  776 */       int y = h / 2 - spH / 2;
/*  777 */       this.scrollPaneMap.getViewport().setViewPosition(new Point(x, y));
/*  778 */       this.scrollPaneMap.updateUI();
/*      */     }
/*  780 */     else if (spW > w && spH < h) {
/*      */       
/*  782 */       int x = spW / 2 - w / 2;
/*  783 */       int y = h / 2 - spH / 2;
/*  784 */       this.terraImagePanel.setLocation(x, 0);
/*  785 */       this.terraImagePanel.setBounds(x, 0, w, h);
/*  786 */       this.terraImagePanel.updateUI();
/*  787 */       this.scrollPaneMap.getViewport().setViewPosition(new Point(0, y));
/*  788 */       this.scrollPaneMap.updateUI();
/*      */     }
/*  790 */     else if (spW < w && spH > h) {
/*      */       
/*  792 */       int x = w / 2 - spW / 2;
/*  793 */       int y = spH / 2 - h / 2;
/*  794 */       this.terraImagePanel.setLocation(0, y);
/*  795 */       this.terraImagePanel.setBounds(0, y, w, h);
/*  796 */       this.terraImagePanel.updateUI();
/*  797 */       this.scrollPaneMap.getViewport().setViewPosition(new Point(x, 0));
/*  798 */       this.scrollPaneMap.updateUI();
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
/*      */   public boolean isInternetAvailable() {
/*  818 */     if (SessionUtil.isInternetAvailable())
/*      */     {
/*  820 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  824 */     String message = "Please connect to the Internet to use this feature.";
/*  825 */     String title = "No Internet Connection found.";
/*  826 */     JOptionPane.showMessageDialog(this, message, title, 1);
/*  827 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void btnStop_actionPerformed(ActionEvent e) {
/*  837 */     if (this.mapRequestor == null)
/*  838 */       return;  this.mapRequestor.setOkToContinue(false);
/*  839 */     this.mapRequestor.interrupt();
/*  840 */     this.btnGetMap.setEnabled(true);
/*      */   }
/*      */ 
/*      */   
/*      */   void this_componentResized(ComponentEvent e) {
/*  845 */     int w = getWidth();
/*  846 */     int h = getHeight();
/*      */     
/*  848 */     boolean fixNeeded = false;
/*  849 */     if (w < 800) {
/*      */       
/*  851 */       fixNeeded = true;
/*  852 */       w = 800;
/*      */     } 
/*  854 */     if (h < 600) {
/*      */       
/*  856 */       fixNeeded = true;
/*  857 */       h = 600;
/*      */     } 
/*  859 */     if (fixNeeded)
/*      */     {
/*  861 */       setSize(w, h);
/*      */     }
/*      */   }
/*      */   
/*      */   void btnCancel_actionPerformed(ActionEvent e) {
/*  866 */     dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void btnLookup_actionPerformed(ActionEvent e) {
/*  872 */     ZipDialog dlg = new ZipDialog(this, null, true);
/*  873 */     int w = 350;
/*  874 */     int h = 130;
/*  875 */     dlg.setSize(w, h);
/*  876 */     dlg.setLocation((getLocation()).x + getWidth() / 2 - w / 2, (getLocation()).y + getHeight() / 2 - h / 2);
/*  877 */     dlg.setTitle("Lookup Coordinates");
/*  878 */     dlg.setVisible(true);
/*      */     
/*  880 */     if (dlg.getLatitude() != null) {
/*      */       
/*  882 */       this.tfLat.setText(dlg.getLatitude());
/*  883 */       this.tfLon.setText(dlg.getLongitude());
/*  884 */       getMap();
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
/*      */   void radioSatellite_actionPerformed(ActionEvent e) {
/*  904 */     Scale currentScale = (Scale)this.cbScale.getSelectedItem();
/*      */     
/*  906 */     this.cbScale.removeAllItems();
/*      */     
/*  908 */     this.cbScale.addItem(new Scale(this.meterPerPixel1, 10, 1));
/*  909 */     this.cbScale.addItem(new Scale(this.metersPerPixel2, 11, 2));
/*  910 */     this.cbScale.addItem(new Scale(this.metersPerPixel4, 12, 4));
/*  911 */     this.cbScale.addItem(new Scale(this.metersPerPixel8, 13, 8));
/*  912 */     this.cbScale.addItem(new Scale(this.metersPerPixel16, 14, 16));
/*  913 */     this.cbScale.addItem(new Scale(this.metersPerPixel32, 15, 32));
/*  914 */     this.cbScale.addItem(new Scale(this.metersPerPixel64, 16, 64));
/*  915 */     this.cbScale.addItem(new Scale(this.metersPerPixel128, 17, 128));
/*  916 */     this.cbScale.addItem(new Scale(this.metersPerPixel256, 18, 256));
/*  917 */     this.cbScale.addItem(new Scale(this.metersPerPixel512, 19, 512));
/*      */     
/*  919 */     this.cbScale.setSelectedItem(currentScale);
/*      */   }
/*      */ 
/*      */   
/*      */   void radioTopo_actionPerformed(ActionEvent e) {
/*  924 */     Scale currentScale = (Scale)this.cbScale.getSelectedItem();
/*  925 */     this.cbScale.removeAllItems();
/*      */     
/*  927 */     this.cbScale.addItem(new Scale(this.metersPerPixel2, 11, 2));
/*  928 */     this.cbScale.addItem(new Scale(this.metersPerPixel4, 12, 4));
/*  929 */     this.cbScale.addItem(new Scale(this.metersPerPixel8, 13, 8));
/*  930 */     this.cbScale.addItem(new Scale(this.metersPerPixel16, 14, 16));
/*  931 */     this.cbScale.addItem(new Scale(this.metersPerPixel32, 15, 32));
/*  932 */     this.cbScale.addItem(new Scale(this.metersPerPixel64, 16, 64));
/*  933 */     this.cbScale.addItem(new Scale(this.metersPerPixel128, 17, 128));
/*  934 */     this.cbScale.addItem(new Scale(this.metersPerPixel256, 18, 256));
/*  935 */     this.cbScale.addItem(new Scale(this.metersPerPixel512, 19, 512));
/*      */     
/*  937 */     if (currentScale.getMetersPerPixel() == 1) {
/*      */       
/*  939 */       this.cbScale.setSelectedIndex(0);
/*      */     }
/*      */     else {
/*      */       
/*  943 */       this.cbScale.setSelectedItem(currentScale);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void cbPixelWidth_actionPerformed(ActionEvent e) {}
/*      */ 
/*      */ 
/*      */   
/*      */   void cbPixelHeight_actionPerformed(ActionEvent e) {}
/*      */ 
/*      */ 
/*      */   
/*      */   void cbScale_actionPerformed(ActionEvent e) {}
/*      */ 
/*      */ 
/*      */   
/*      */   void northButton_actionPerformed(ActionEvent e) {
/*  962 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/*  965 */     double heightInMeters = (this.heightInPixels * this.scale.getMetersPerPixel());
/*  966 */     double metersToMoveNorth = heightInMeters / 2.0D;
/*  967 */     double degreesToMoveNorth = MapUtility.getWGS84DegreesLatitude(metersToMoveNorth);
/*  968 */     this.latitude = MapUtility.round7(this.latitude + degreesToMoveNorth);
/*  969 */     this.tfLat.setText(this.latitude);
/*      */     
/*  971 */     getMap();
/*      */   }
/*      */ 
/*      */   
/*      */   void southButton_actionPerformed(ActionEvent e) {
/*  976 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/*  979 */     double heightInMeters = (this.heightInPixels * this.scale.getMetersPerPixel());
/*  980 */     double metersToMoveNorth = -heightInMeters / 2.0D;
/*  981 */     double degreesToMoveNorth = MapUtility.getWGS84DegreesLatitude(metersToMoveNorth);
/*  982 */     this.latitude = MapUtility.round7(this.latitude + degreesToMoveNorth);
/*  983 */     this.tfLat.setText(this.latitude);
/*      */     
/*  985 */     getMap();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void eastButton_actionPerformed(ActionEvent e) {
/*  992 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/*  995 */     double widthInMeters = (this.widthInPixels * this.scale.getMetersPerPixel());
/*  996 */     double metersToMoveEast = widthInMeters / 2.0D;
/*  997 */     double degreesToMoveEast = MapUtility.getWGS84DegreesLongitude(metersToMoveEast, this.latitude);
/*  998 */     this.longitude = MapUtility.round7(this.longitude + degreesToMoveEast);
/*  999 */     this.tfLon.setText(this.longitude);
/*      */     
/* 1001 */     getMap();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void westButton_actionPerformed(ActionEvent e) {
/* 1007 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/* 1010 */     double widthInMeters = (this.widthInPixels * this.scale.getMetersPerPixel());
/* 1011 */     double metersToMoveEast = -widthInMeters / 2.0D;
/* 1012 */     double degreesToMoveEast = MapUtility.getWGS84DegreesLongitude(metersToMoveEast, this.latitude);
/* 1013 */     this.longitude = MapUtility.round7(this.longitude + degreesToMoveEast);
/* 1014 */     this.tfLon.setText(this.longitude);
/*      */     
/* 1016 */     getMap();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void northEastButton_actionPerformed(ActionEvent e) {
/* 1022 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/* 1025 */     double heightInMeters = (this.heightInPixels * this.scale.getMetersPerPixel());
/* 1026 */     double metersToMoveNorth = heightInMeters / 2.0D;
/* 1027 */     double degreesToMoveNorth = MapUtility.getWGS84DegreesLatitude(metersToMoveNorth);
/* 1028 */     this.latitude = MapUtility.round7(this.latitude + degreesToMoveNorth);
/* 1029 */     this.tfLat.setText(this.latitude);
/*      */ 
/*      */     
/* 1032 */     double widthInMeters = (this.widthInPixels * this.scale.getMetersPerPixel());
/* 1033 */     double metersToMoveEast = widthInMeters / 2.0D;
/* 1034 */     double degreesToMoveEast = MapUtility.getWGS84DegreesLongitude(metersToMoveEast, this.latitude);
/* 1035 */     this.longitude = MapUtility.round7(this.longitude + degreesToMoveEast);
/* 1036 */     this.tfLon.setText(this.longitude);
/*      */     
/* 1038 */     getMap();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean okToMove() {
/* 1045 */     if (this.latitude == -1.0D || this.longitude == -1.0D) {
/*      */       
/* 1047 */       String title = "No Map Visible";
/* 1048 */       String message = "Please get a Map First";
/* 1049 */       JOptionPane.showMessageDialog(this, message, title, 1);
/* 1050 */       return false;
/*      */     } 
/* 1052 */     return true;
/*      */   }
/*      */   
/*      */   void southEastButton_actionPerformed(ActionEvent e) {
/* 1056 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/* 1059 */     double heightInMeters = (this.heightInPixels * this.scale.getMetersPerPixel());
/* 1060 */     double metersToMoveNorth = -heightInMeters / 2.0D;
/* 1061 */     double degreesToMoveNorth = MapUtility.getWGS84DegreesLatitude(metersToMoveNorth);
/* 1062 */     this.latitude = MapUtility.round7(this.latitude + degreesToMoveNorth);
/* 1063 */     this.tfLat.setText(this.latitude);
/*      */ 
/*      */     
/* 1066 */     double widthInMeters = (this.widthInPixels * this.scale.getMetersPerPixel());
/* 1067 */     double metersToMoveEast = widthInMeters / 2.0D;
/* 1068 */     double degreesToMoveEast = MapUtility.getWGS84DegreesLongitude(metersToMoveEast, this.latitude);
/* 1069 */     this.longitude = MapUtility.round7(this.longitude + degreesToMoveEast);
/* 1070 */     this.tfLon.setText(this.longitude);
/*      */ 
/*      */     
/* 1073 */     getMap();
/*      */   }
/*      */ 
/*      */   
/*      */   void southWestButton_actionPerformed(ActionEvent e) {
/* 1078 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/* 1081 */     double heightInMeters = (this.heightInPixels * this.scale.getMetersPerPixel());
/* 1082 */     double metersToMoveNorth = -heightInMeters / 2.0D;
/* 1083 */     double degreesToMoveNorth = MapUtility.getWGS84DegreesLatitude(metersToMoveNorth);
/* 1084 */     this.latitude = MapUtility.round7(this.latitude + degreesToMoveNorth);
/* 1085 */     this.tfLat.setText(this.latitude);
/*      */ 
/*      */     
/* 1088 */     double widthInMeters = (this.widthInPixels * this.scale.getMetersPerPixel());
/* 1089 */     double metersToMoveEast = -widthInMeters / 2.0D;
/* 1090 */     double degreesToMoveEast = MapUtility.getWGS84DegreesLongitude(metersToMoveEast, this.latitude);
/* 1091 */     this.longitude = MapUtility.round7(this.longitude + degreesToMoveEast);
/* 1092 */     this.tfLon.setText(this.longitude);
/*      */ 
/*      */     
/* 1095 */     getMap();
/*      */   }
/*      */ 
/*      */   
/*      */   void northWestButton_actionPerformed(ActionEvent e) {
/* 1100 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/* 1103 */     double heightInMeters = (this.heightInPixels * this.scale.getMetersPerPixel());
/* 1104 */     double metersToMoveNorth = heightInMeters / 2.0D;
/* 1105 */     double degreesToMoveNorth = MapUtility.getWGS84DegreesLatitude(metersToMoveNorth);
/* 1106 */     this.latitude = MapUtility.round7(this.latitude + degreesToMoveNorth);
/* 1107 */     this.tfLat.setText(this.latitude);
/*      */ 
/*      */     
/* 1110 */     double widthInMeters = (this.widthInPixels * this.scale.getMetersPerPixel());
/* 1111 */     double metersToMoveEast = -widthInMeters / 2.0D;
/* 1112 */     double degreesToMoveEast = MapUtility.getWGS84DegreesLongitude(metersToMoveEast, this.latitude);
/* 1113 */     this.longitude = MapUtility.round7(this.longitude + degreesToMoveEast);
/* 1114 */     this.tfLon.setText(this.longitude);
/*      */     
/* 1116 */     getMap();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void imagePanel_mouseClicked(MouseEvent e) {
/* 1122 */     if (!okToMove()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1127 */     Point pt = e.getPoint();
/* 1128 */     Point center = new Point(this.terraImagePanel.getWidth() / 2, this.terraImagePanel.getHeight() / 2);
/* 1129 */     int dx = 0;
/* 1130 */     int dy = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1135 */     dx = pt.x - center.x;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1140 */     dy = center.y - pt.y;
/*      */ 
/*      */     
/* 1143 */     int dxMeters = dx * this.scale.getMetersPerPixel();
/* 1144 */     int dyMeters = dy * this.scale.getMetersPerPixel();
/*      */ 
/*      */     
/* 1147 */     double degreesToMoveEast = MapUtility.getWGS84DegreesLongitude(dxMeters, this.latitude);
/* 1148 */     this.longitude = MapUtility.round7(this.longitude + degreesToMoveEast);
/* 1149 */     this.tfLon.setText(this.longitude);
/*      */     
/* 1151 */     double degreesToMoveNorth = MapUtility.getWGS84DegreesLatitude(dyMeters);
/* 1152 */     this.latitude = MapUtility.round7(this.latitude + degreesToMoveNorth);
/* 1153 */     this.tfLat.setText(this.latitude);
/*      */     
/* 1155 */     getMap();
/*      */   }
/*      */ 
/*      */   
/*      */   void btnOk_actionPerformed(ActionEvent e) {
/* 1160 */     dispose();
/*      */   }
/*      */ 
/*      */   
/*      */   void btnCreateView_actionPerformed(ActionEvent e) {
/* 1165 */     if (this.imageBytes == null) {
/*      */       
/* 1167 */       String title = "No Map/Satellite Image Visible";
/* 1168 */       String message = "Please get a Map or Satellite Image First";
/* 1169 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1174 */     if (Global.getTour() == null) {
/*      */ 
/*      */       
/* 1177 */       String newTourName = VadosityToolkit.getInstance().createNewTourName();
/*      */ 
/*      */       
/* 1180 */       Tour tour = new Tour();
/* 1181 */       tour.setName(newTourName);
/* 1182 */       Global.setTour(tour, this);
/*      */       
/* 1184 */       String fileName = RegistryInterface.getCurrentProjectDirectory() + File.separator + newTourName;
/* 1185 */       FileUtility.getInstance().setCurrentFile(new File(fileName));
/* 1186 */       VadosityToolkit.getInstance().setupTitle();
/*      */     } 
/*      */ 
/*      */     
/* 1190 */     View view = new View();
/* 1191 */     view.setImageBytes(this.imageBytes);
/* 1192 */     view.setOverlayImageBytes(this.overlayImageBytes);
/* 1193 */     if (this.overlayImageBytes != null && this.overlayImageBytes.length > 0) {
/*      */       
/* 1195 */       double value = this.sliderTopo.getValue() / 100.0D;
/* 1196 */       view.setOverlayAlpha(value);
/*      */     } 
/* 1198 */     String viewName = "Satellite View";
/* 1199 */     view.setName(viewName);
/*      */     
/* 1201 */     Global.getTour().add(view);
/* 1202 */     Global.fireSelectedViewChanged(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefaultViewName(String baseName) {
/* 1211 */     if (Global.getTour() == null) return baseName; 
/* 1212 */     if (Global.getTour().getViews() == null || Global.getTour().getViews().isEmpty()) {
/* 1213 */       return baseName;
/*      */     }
/*      */     
/* 1216 */     View ithView = null;
/* 1217 */     String ithViewName = null;
/* 1218 */     String possibleName = null;
/* 1219 */     int index = 2;
/*      */     
/*      */     while (true) {
/* 1222 */       boolean viewNameUnique = true;
/* 1223 */       for (int i = 0; i < Global.getTour().getViews().size(); i++) {
/*      */         
/* 1225 */         ithView = Global.getTour().getViews().elementAt(i);
/* 1226 */         ithViewName = ithView.getName();
/* 1227 */         possibleName = String.valueOf(baseName) + " " + index;
/* 1228 */         if (possibleName.trim().equalsIgnoreCase(ithViewName.trim())) viewNameUnique = false; 
/*      */       } 
/* 1230 */       if (viewNameUnique) return possibleName; 
/* 1231 */       index++;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void btnSaveImage_actionPerformed(ActionEvent e) {
/* 1240 */     if (this.imageBytes == null) {
/*      */       
/* 1242 */       String title = "No Map Open";
/* 1243 */       String message = "Please get Map First";
/* 1244 */       JOptionPane.showMessageDialog(this, message, title, 1);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*      */     try {
/* 1250 */       JFileChooser chooser = new JFileChooser();
/*      */       
/*      */       try {
/* 1253 */         String dir = String.valueOf(System.getProperty("user.home")) + File.separator + "My Documents";
/* 1254 */         if (dir != null && !dir.trim().equals(""))
/*      */         {
/* 1256 */           chooser.setCurrentDirectory(new File(dir));
/*      */         }
/*      */       }
/* 1259 */       catch (Exception exception) {}
/*      */ 
/*      */ 
/*      */       
/* 1263 */       String filename = null;
/* 1264 */       if (this.theme.equals("1")) { filename = "Satellite Image.jpg"; }
/* 1265 */       else { filename = "Topography Map.jpg"; }
/* 1266 */        chooser.setSelectedFile(new File(filename));
/*      */ 
/*      */       
/* 1269 */       JpegFileFilter filter = new JpegFileFilter();
/* 1270 */       chooser.setFileFilter((FileFilter)filter);
/*      */       
/* 1272 */       if (this.theme.equals("1")) { chooser.setDialogTitle("Save Satellite Image"); }
/* 1273 */       else { chooser.setDialogTitle("Save Map"); }
/* 1274 */        chooser.setDialogType(0);
/* 1275 */       int result = chooser.showSaveDialog(this);
/* 1276 */       if (result == 1)
/* 1277 */         return;  if (chooser.getSelectedFile() == null) {
/*      */         return;
/*      */       }
/* 1280 */       filename = chooser.getSelectedFile().getAbsolutePath();
/* 1281 */       filename = filename.toLowerCase().trim();
/* 1282 */       if (!filename.endsWith(".jpg")) {
/*      */         
/* 1284 */         int lastDotIndex = filename.lastIndexOf(".");
/* 1285 */         if (lastDotIndex == -1) {
/*      */           
/* 1287 */           filename = String.valueOf(filename) + ".jpg";
/*      */         }
/*      */         else {
/*      */           
/* 1291 */           String firstPart = filename.substring(0, lastDotIndex);
/* 1292 */           filename = String.valueOf(firstPart) + ".jpg";
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1297 */       FileOutputStream fos = new FileOutputStream(filename);
/* 1298 */       if (this.overlayImageBytes == null)
/*      */       {
/*      */         
/* 1301 */         fos.write(this.imageBytes);
/* 1302 */         fos.flush();
/* 1303 */         fos.close();
/*      */       
/*      */       }
/*      */       else
/*      */       {
/* 1308 */         BufferedImage awtImage = new BufferedImage(this.terraImagePanel.getWidth(), 
/* 1309 */             this.terraImagePanel.getHeight(), 
/* 1310 */             1);
/* 1311 */         Graphics g = awtImage.getGraphics();
/* 1312 */         this.terraImagePanel.printAll(g);
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/* 1317 */           JPEGImageEncoderImpl j = new JPEGImageEncoderImpl(fos);
/* 1318 */           j.encode(awtImage);
/* 1319 */           fos.flush();
/* 1320 */           fos.close();
/*      */         }
/* 1322 */         catch (Exception ex) {
/*      */           
/* 1324 */           ex.printStackTrace();
/*      */         }
/*      */       
/*      */       }
/*      */     
/* 1329 */     } catch (Exception ex) {
/*      */       
/* 1331 */       JOptionPane.showMessageDialog(this, ex.toString(), ex.toString(), 0);
/* 1332 */       ex.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void radioBoth_actionPerformed(ActionEvent e) {
/* 1340 */     Scale currentScale = (Scale)this.cbScale.getSelectedItem();
/* 1341 */     this.cbScale.removeAllItems();
/*      */     
/* 1343 */     this.cbScale.addItem(new Scale(this.metersPerPixel2, 11, 2));
/* 1344 */     this.cbScale.addItem(new Scale(this.metersPerPixel4, 12, 4));
/* 1345 */     this.cbScale.addItem(new Scale(this.metersPerPixel8, 13, 8));
/* 1346 */     this.cbScale.addItem(new Scale(this.metersPerPixel16, 14, 16));
/* 1347 */     this.cbScale.addItem(new Scale(this.metersPerPixel32, 15, 32));
/* 1348 */     this.cbScale.addItem(new Scale(this.metersPerPixel64, 16, 64));
/* 1349 */     this.cbScale.addItem(new Scale(this.metersPerPixel128, 17, 128));
/* 1350 */     this.cbScale.addItem(new Scale(this.metersPerPixel256, 18, 256));
/* 1351 */     this.cbScale.addItem(new Scale(this.metersPerPixel512, 19, 512));
/*      */     
/* 1353 */     if (currentScale.getMetersPerPixel() == 1) {
/*      */       
/* 1355 */       this.cbScale.setSelectedIndex(0);
/*      */     }
/*      */     else {
/*      */       
/* 1359 */       this.cbScale.setSelectedItem(currentScale);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void sliderTopo_stateChanged(ChangeEvent e) {
/* 1367 */     if (!this.sliderTopo.isEnabled())
/*      */       return; 
/* 1369 */     double value = this.sliderTopo.getValue() / 100.0D;
/* 1370 */     this.terraImagePanel.setOverlayAlpha(value);
/* 1371 */     this.terraImagePanel.updateUI();
/*      */   }
/*      */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\map\TerraFrame.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */