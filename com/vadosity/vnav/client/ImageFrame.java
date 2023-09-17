/*     */ package com.vadosity.vnav.client;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.io.File;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class ImageFrame extends JFrame {
/*  12 */   static Hashtable theCookies = new Hashtable();
/*     */   
/*  14 */   GridBagLayout gridBagLayout1 = new GridBagLayout();
/*  15 */   JLabel jLabel1 = new JLabel();
/*  16 */   JTextField tfPrefix = new JTextField();
/*  17 */   JLabel jLabel2 = new JLabel();
/*  18 */   JLabel jLabel3 = new JLabel();
/*  19 */   JTextField tfStart = new JTextField();
/*  20 */   JTextField tfFinish = new JTextField();
/*  21 */   JLabel jLabel4 = new JLabel();
/*  22 */   JTextField tfPostfix = new JTextField();
/*  23 */   JButton btnGo = new JButton();
/*  24 */   JLabel lblStatus = new JLabel();
/*  25 */   JLabel jLabel5 = new JLabel();
/*  26 */   JTextField tfOutDir = new JTextField();
/*  27 */   JButton btnGetEmail = new JButton();
/*  28 */   JTextField tfStartUrl = new JTextField();
/*  29 */   JTextField tfClassYear = new JTextField();
/*  30 */   JLabel jLabel6 = new JLabel();
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
/*     */   void jbInit() throws Exception {
/*  46 */     this.jLabel1.setText("Prefix");
/*  47 */     getContentPane().setLayout(this.gridBagLayout1);
/*  48 */     this.jLabel2.setText("Start Index");
/*  49 */     this.jLabel3.setText("Finish Index");
/*  50 */     this.tfFinish.setMinimumSize(new Dimension(60, 20));
/*  51 */     this.tfFinish.setPreferredSize(new Dimension(60, 20));
/*  52 */     this.tfFinish.setText("");
/*  53 */     this.tfStart.setMinimumSize(new Dimension(60, 20));
/*  54 */     this.tfStart.setPreferredSize(new Dimension(60, 20));
/*  55 */     this.tfStart.setText("");
/*  56 */     this.tfPrefix.setText("");
/*  57 */     this.jLabel4.setText("PostFix");
/*  58 */     this.tfPostfix.setText(".jpg");
/*  59 */     this.btnGo.setText("Go");
/*  60 */     this.btnGo.addActionListener(new ImageFrame_btnGo_actionAdapter(this));
/*  61 */     this.lblStatus.setText("Status:");
/*  62 */     this.jLabel5.setText("Output Directory: ");
/*  63 */     this.tfOutDir.setText("C:\\Test\\");
/*  64 */     this.btnGetEmail.setText("Get Email");
/*  65 */     this.btnGetEmail.addActionListener(new ImageFrame_btnGetEmail_actionAdapter(this));
/*  66 */     this.tfClassYear.setText("1992");
/*  67 */     this.jLabel6.setText("class year");
/*  68 */     this.ckUSMA.setSelected(true);
/*  69 */     this.ckUSMA.setText("USMA");
/*  70 */     this.jLabel7.setText("file name");
/*  71 */     this.tfFilename.setText("C:\\temp\\email_list.txt");
/*  72 */     this.tfStartUrl.setText("http://ssl.whoglue.net/default.cfm?fuse_action=search_drill_in&ID=iMA");
/*  73 */     this.ckUSNA.setText("USNA");
/*  74 */     this.ckUSAFA.setText("USAFA");
/*  75 */     this.ckUSCGA.setText("USCGA");
/*  76 */     this.jLabel8.setText("File to Read");
/*  77 */     this.tfEmailFile.setText("");
/*  78 */     this.jLabel9.setText("Emails to Send");
/*  79 */     this.tfSpamNumber.setMinimumSize(new Dimension(100, 20));
/*  80 */     this.tfSpamNumber.setPreferredSize(new Dimension(100, 20));
/*  81 */     this.tfSpamNumber.setText("");
/*  82 */     this.btnSpam.setText("Spam Away!");
/*  83 */     this.btnSpam.addActionListener(new ImageFrame_btnSpam_actionAdapter(this));
/*  84 */     getContentPane().add(this.jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  85 */           10, 0, new Insets(5, 5, 5, 5), 60, 0));
/*  86 */     getContentPane().add(this.tfPrefix, new GridBagConstraints(1, 0, 2, 1, 0.0D, 0.0D, 
/*  87 */           10, 0, new Insets(5, 5, 5, 5), 381, 0));
/*  88 */     getContentPane().add(this.jLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/*  89 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  90 */     getContentPane().add(this.jLabel3, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/*  91 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  92 */     getContentPane().add(this.tfStart, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/*  93 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  94 */     getContentPane().add(this.tfFinish, new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 
/*  95 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  96 */     getContentPane().add(this.jLabel4, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/*  97 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/*  98 */     getContentPane().add(this.tfPostfix, new GridBagConstraints(2, 3, 1, 1, 0.0D, 0.0D, 
/*  99 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 100 */     getContentPane().add(this.btnGo, new GridBagConstraints(3, 0, 1, 1, 0.0D, 0.0D, 
/* 101 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 102 */     getContentPane().add(this.lblStatus, new GridBagConstraints(0, 4, 4, 1, 0.0D, 0.0D, 
/* 103 */           17, 0, new Insets(20, 5, 5, 5), 0, 0));
/* 104 */     getContentPane().add(this.jLabel5, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.0D, 
/* 105 */           17, 0, new Insets(5, 5, 5, 5), 0, 0));
/* 106 */     getContentPane().add(this.tfOutDir, new GridBagConstraints(2, 5, 1, 1, 0.0D, 0.0D, 
/* 107 */           17, 2, new Insets(5, 5, 5, 5), 288, 0));
/* 108 */     getContentPane().add(this.btnGetEmail, new GridBagConstraints(0, 6, 1, 1, 0.0D, 0.0D, 
/* 109 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 110 */     getContentPane().add(this.tfStartUrl, new GridBagConstraints(2, 6, 2, 1, 0.0D, 0.0D, 
/* 111 */           10, 2, new Insets(5, 5, 5, 5), 0, 0));
/* 112 */     getContentPane().add(this.tfClassYear, new GridBagConstraints(2, 7, 1, 1, 0.0D, 0.0D, 
/* 113 */           17, 2, new Insets(5, 5, 5, 5), 99, 0));
/* 114 */     getContentPane().add(this.jLabel6, new GridBagConstraints(0, 7, 1, 1, 0.0D, 0.0D, 
/* 115 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 116 */     getContentPane().add(this.jLabel7, new GridBagConstraints(0, 8, 1, 1, 0.0D, 0.0D, 
/* 117 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 118 */     getContentPane().add(this.ckUSMA, new GridBagConstraints(2, 9, 1, 1, 0.0D, 0.0D, 
/* 119 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 120 */     getContentPane().add(this.tfFilename, new GridBagConstraints(2, 8, 1, 1, 0.0D, 0.0D, 
/* 121 */           17, 2, new Insets(5, 5, 5, 5), 130, 0));
/* 122 */     getContentPane().add(this.ckUSNA, new GridBagConstraints(2, 10, 1, 1, 0.0D, 0.0D, 
/* 123 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 124 */     getContentPane().add(this.ckUSAFA, new GridBagConstraints(2, 11, 1, 1, 0.0D, 0.0D, 
/* 125 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 126 */     getContentPane().add(this.ckUSCGA, new GridBagConstraints(2, 12, 1, 1, 0.0D, 0.0D, 
/* 127 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 128 */     getContentPane().add(this.jLabel8, new GridBagConstraints(0, 13, 1, 1, 0.0D, 0.0D, 
/* 129 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 130 */     getContentPane().add(this.tfEmailFile, new GridBagConstraints(2, 13, 1, 1, 0.0D, 0.0D, 
/* 131 */           10, 2, new Insets(0, 0, 0, 0), 0, 0));
/* 132 */     getContentPane().add(this.jLabel9, new GridBagConstraints(0, 14, 1, 1, 0.0D, 0.0D, 
/* 133 */           10, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 134 */     getContentPane().add(this.tfSpamNumber, new GridBagConstraints(2, 14, 1, 1, 0.0D, 0.0D, 
/* 135 */           17, 0, new Insets(0, 0, 0, 0), 0, 0));
/* 136 */     getContentPane().add(this.btnSpam, new GridBagConstraints(2, 15, 1, 1, 0.0D, 0.0D, 
/* 137 */           10, 0, new Insets(5, 5, 5, 5), 0, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] readImageBytes(String sUrl) {
/* 143 */     URL url = null;
/* 144 */     HttpURLConnection httpConn = null;
/* 145 */     DataInputStream dis = null;
/* 146 */     Vector vBytes = new Vector();
/* 147 */     byte[] imageBytes = (byte[])null;
/*     */ 
/*     */     
/*     */     try {
/* 151 */       url = new URL(sUrl);
/* 152 */       httpConn = (HttpURLConnection)url.openConnection();
/* 153 */       httpConn.setDoInput(true);
/* 154 */       httpConn.setDoOutput(true);
/* 155 */       dis = new DataInputStream(httpConn.getInputStream());
/* 156 */       vBytes = new Vector();
/* 157 */       boolean ok = true;
/* 158 */       while (ok)
/*     */       {
/* 160 */         vBytes.add(new Byte(dis.readByte()));
/*     */       }
/* 162 */       throw new RuntimeException("This should never be reached -EOF not being thrown");
/*     */     }
/* 164 */     catch (Exception ex2) {
/*     */       
/* 166 */       if (ex2 instanceof java.io.EOFException) {
/*     */         
/* 168 */         imageBytes = (byte[])null;
/* 169 */         imageBytes = new byte[vBytes.size()];
/* 170 */         for (int i = 0; i < vBytes.size(); i++)
/*     */         {
/* 172 */           imageBytes[i] = ((Byte)vBytes.elementAt(i)).byteValue();
/*     */         }
/*     */         
/* 175 */         vBytes.removeAllElements();
/* 176 */         vBytes = null;
/* 177 */         return imageBytes;
/*     */       } 
/*     */ 
/*     */       
/* 181 */       System.out.println("error: " + ex2);
/* 182 */       return null;
/*     */     } finally {
/*     */ 
/*     */ 
/*     */       
/* 187 */       try { dis.close(); } catch (Exception e) { e.printStackTrace(); }
/* 188 */        dis = null;
/* 189 */       httpConn.disconnect();
/* 190 */       httpConn = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCookies(String filename) {
/*     */     try {
/* 200 */       File f = new File(filename);
/* 201 */       FileInputStream is = new FileInputStream(f);
/* 202 */       InputStreamReader isr = new InputStreamReader(is);
/* 203 */       BufferedReader br = new BufferedReader(isr);
/*     */       
/* 205 */       String line = br.readLine();
/* 206 */       String name = null;
/* 207 */       String value = null;
/* 208 */       boolean recorded = false;
/* 209 */       while (line != null)
/*     */       {
/* 211 */         if (name == null) { name = line.trim(); }
/* 212 */         else if (name != null && value == null) { value = line.trim(); }
/*     */         
/* 214 */         if (name != null && value != null && !recorded) {
/*     */           
/* 216 */           theCookies.put(name, value);
/* 217 */           recorded = true;
/*     */         } 
/*     */         
/* 220 */         if (line.indexOf("*") != -1) {
/*     */           
/* 222 */           recorded = false;
/* 223 */           name = null;
/* 224 */           value = null;
/*     */         } 
/* 226 */         line = br.readLine();
/*     */       }
/*     */     
/* 229 */     } catch (Exception exception) {}
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
/*     */   public URLConnection writeCookies(URLConnection urlConn, boolean printCookies) {
/* 248 */     String cookieString = "";
/* 249 */     Enumeration keys = theCookies.keys();
/* 250 */     while (keys.hasMoreElements()) {
/*     */       
/* 252 */       String key = keys.nextElement();
/* 253 */       cookieString = String.valueOf(cookieString) + key + "=" + theCookies.get(key);
/* 254 */       if (keys.hasMoreElements())
/* 255 */         cookieString = String.valueOf(cookieString) + "; "; 
/*     */     } 
/* 257 */     urlConn.setRequestProperty("Cookie", cookieString);
/* 258 */     if (printCookies)
/* 259 */       System.out.println("Wrote cookies:\n   " + cookieString); 
/* 260 */     return urlConn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readText(String sUrl, int index) {
/* 267 */     URL url = null;
/* 268 */     HttpURLConnection httpConn = null;
/* 269 */     DataInputStream dis = null;
/* 270 */     Vector vBytes = new Vector();
/* 271 */     byte[] imageBytes = (byte[])null;
/*     */ 
/*     */     
/*     */     try { 
/* 275 */       try { url = new URL(sUrl);
/* 276 */         httpConn = (HttpURLConnection)url.openConnection();
/* 277 */         httpConn.setDoInput(true);
/* 278 */         httpConn.setDoOutput(false);
/*     */         
/* 280 */         writeCookies(httpConn, false);
/*     */ 
/*     */         
/* 283 */         dis = new DataInputStream(httpConn.getInputStream());
/* 284 */         vBytes = new Vector();
/* 285 */         boolean ok = true;
/* 286 */         while (ok)
/*     */         {
/* 288 */           vBytes.add(new Byte(dis.readByte()));
/*     */         }
/*     */ 
/*     */         
/* 292 */         imageBytes = (byte[])null;
/* 293 */         imageBytes = new byte[vBytes.size()];
/* 294 */         for (int i = 0; i < vBytes.size(); i++)
/*     */         {
/* 296 */           imageBytes[i] = ((Byte)vBytes.elementAt(i)).byteValue();
/*     */         }
/*     */         
/* 299 */         vBytes.removeAllElements();
/* 300 */         vBytes = null;
/* 301 */         return new String(imageBytes);
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
/*     */          }
/*     */       
/*     */       finally
/*     */       
/*     */       { 
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
/* 329 */         imageBytes = (byte[])null; 
/* 330 */         try { dis.close(); } catch (Exception e) { e.printStackTrace(); }
/* 331 */          dis = null;
/* 332 */         httpConn.disconnect();
/* 333 */         httpConn = null; }  }
/*     */     catch (Exception ex2) { if (ex2 instanceof java.io.EOFException) { imageBytes = (byte[])null; imageBytes = new byte[vBytes.size()]; for (int i = 0; i < vBytes.size(); i++)
/*     */           imageBytes[i] = ((Byte)vBytes.elementAt(i)).byteValue();  vBytes.removeAllElements(); vBytes = null; return new String(imageBytes); }
/*     */        System.out.println("error: " + ex2); return null; }
/* 337 */      } private static Hashtable htSent = new Hashtable(); HashSet emailBuffer; JCheckBox ckUSMA; JLabel jLabel7; JTextField tfFilename; JCheckBox ckUSNA; JCheckBox ckUSAFA; JCheckBox ckUSCGA; int firstIndex; int lastIndex; JLabel jLabel8; JTextField tfEmailFile; JLabel jLabel9;
/*     */   JTextField tfSpamNumber;
/*     */   JButton btnSpam;
/*     */   
/*     */   public boolean sendEmail(String to) {
/* 342 */     System.out.println("to: " + to + " length: " + to.length());
/* 343 */     to = to.trim().toLowerCase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     URL url = null;
/* 351 */     HttpURLConnection httpConn = null;
/*     */     
/*     */     try {
/*     */       try {
/* 355 */         url = new URL("http://www.vadosity.com/Download.do?eval=true&to=" + to);
/* 356 */         httpConn = (HttpURLConnection)url.openConnection();
/* 357 */         httpConn.setDoInput(true);
/* 358 */         httpConn.setDoOutput(true);
/*     */ 
/*     */         
/* 361 */         BufferedReader reader = null;
/*     */         
/*     */         try {
/* 364 */           reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
/* 365 */           String line = null;
/* 366 */           while ((line = reader.readLine()) != null)
/*     */           {
/* 368 */             System.out.println("line: " + line);
/*     */           }
/*     */         }
/* 371 */         catch (Exception e) {
/*     */           
/* 373 */           e.printStackTrace();
/*     */         }
/*     */         finally {
/*     */           
/* 377 */           reader.close();
/*     */         } 
/*     */ 
/*     */         
/* 381 */         return true;
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       finally {
/*     */ 
/*     */ 
/*     */         
/* 390 */         httpConn.disconnect();
/* 391 */         httpConn = null;
/*     */       } 
/*     */     } catch (Exception ex2) {
/*     */       ex2.printStackTrace();
/*     */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 403 */     ImageFrame f = new ImageFrame();
/* 404 */     f.setSize(600, 400);
/* 405 */     f.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnGo_actionPerformed(ActionEvent e) {
/* 413 */     int start = Integer.parseInt(this.tfStart.getText());
/* 414 */     int finish = Integer.parseInt(this.tfFinish.getText());
/*     */     
/* 416 */     for (int i = start; i <= finish; i++) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 421 */         String surl = String.valueOf(this.tfPrefix.getText()) + i + this.tfPostfix.getText();
/* 422 */         this.lblStatus.setText("Status: " + surl);
/* 423 */         byte[] bytes = readImageBytes(surl);
/*     */         
/* 425 */         if (bytes != null)
/*     */         {
/* 427 */           File f = new File(String.valueOf(this.tfOutDir.getText()) + File.separator + "image_" + 
/* 428 */               i + this.tfPostfix.getText());
/* 429 */           FileOutputStream fos = new FileOutputStream(f);
/* 430 */           fos.write(bytes);
/* 431 */           fos.flush();
/* 432 */           fos.close();
/*     */         }
/*     */       
/*     */       }
/* 436 */       catch (FileNotFoundException fileNotFoundException) {
/*     */ 
/*     */       
/* 439 */       } catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */     
/* 443 */     this.lblStatus.setText("Done!!!");
/*     */   }
/*     */   
/*     */   public ImageFrame() {
/* 447 */     this.emailBuffer = new HashSet();
/* 448 */     this.ckUSMA = new JCheckBox();
/* 449 */     this.jLabel7 = new JLabel();
/* 450 */     this.tfFilename = new JTextField();
/* 451 */     this.ckUSNA = new JCheckBox();
/* 452 */     this.ckUSAFA = new JCheckBox();
/* 453 */     this.ckUSCGA = new JCheckBox();
/*     */     
/* 455 */     this.firstIndex = -1;
/* 456 */     this.lastIndex = -1;
/* 457 */     this.jLabel8 = new JLabel();
/* 458 */     this.tfEmailFile = new JTextField();
/* 459 */     this.jLabel9 = new JLabel();
/* 460 */     this.tfSpamNumber = new JTextField();
/* 461 */     this.btnSpam = new JButton();
/*     */     try {
/*     */       jbInit();
/*     */     } catch (Exception ex) {
/*     */       ex.printStackTrace();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void btnGetEmail_actionPerformed(ActionEvent e) {
/*     */     try {
/* 489 */       File f = new File("C:" + File.separator + "temp" + File.separator + "cookie.txt");
/*     */       
/* 491 */       loadCookies(f.getAbsolutePath());
/*     */       
/* 493 */       FileInputStream fis = new FileInputStream(f);
/* 494 */       byte[] bytes = new byte[fis.available()];
/* 495 */       fis.read(bytes);
/* 496 */       fis.close();
/* 497 */       fis = null;
/*     */     }
/* 499 */     catch (Exception ex) {
/*     */       
/* 501 */       System.err.println("Cookie problem");
/* 502 */       ex.printStackTrace();
/*     */     } 
/*     */     
/* 505 */     int startIndex = Integer.parseInt(this.tfStart.getText());
/* 506 */     int finish = Integer.parseInt(this.tfFinish.getText());
/* 507 */     for (int i = startIndex; i < finish; i++) {
/*     */ 
/*     */       
/*     */       try {
/* 511 */         String url = this.tfStartUrl.getText().trim();
/* 512 */         url = String.valueOf(url) + i;
/*     */         
/* 514 */         if (this.ckUSMA.isSelected()) {
/*     */           
/* 516 */           String classYear = this.tfClassYear.getText();
/* 517 */           url = String.valueOf(url) + "-" + classYear;
/*     */         } 
/* 519 */         if (this.ckUSNA.isSelected())
/*     */         {
/* 521 */           url = String.valueOf(url) + "0";
/*     */         }
/*     */         
/* 524 */         url = String.valueOf(url) + "&viewUserID=";
/*     */         
/* 526 */         String html = readText(url, i);
/* 527 */         addEmailsToBuffer(html, i);
/* 528 */         if (this.lastIndex > -1 && i > this.lastIndex + 100) {
/*     */           break;
/*     */         }
/* 531 */       } catch (Exception e2) {
/*     */         
/* 533 */         System.out.println("error: " + e2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 542 */       String out = "C:" + File.separator + "temp" + File.separator + "email-list";
/* 543 */       if (this.ckUSMA.isSelected()) out = String.valueOf(out) + "-USMA-"; 
/* 544 */       if (this.ckUSNA.isSelected()) out = String.valueOf(out) + "-USNA-"; 
/* 545 */       if (this.ckUSCGA.isSelected()) out = String.valueOf(out) + "-USCGA-"; 
/* 546 */       if (this.ckUSAFA.isSelected()) out = String.valueOf(out) + "-USAFA-"; 
/* 547 */       out = String.valueOf(out) + this.tfClassYear.getText() + "-";
/*     */       
/* 549 */       out = String.valueOf(out) + this.firstIndex + "-" + this.lastIndex;
/* 550 */       out = String.valueOf(out) + ".txt";
/* 551 */       File f2 = new File(out);
/*     */       
/* 553 */       FileOutputStream fos = new FileOutputStream(f2);
/* 554 */       StringBuffer buf = new StringBuffer();
/* 555 */       Iterator it = this.emailBuffer.iterator();
/* 556 */       while (it.hasNext())
/*     */       {
/* 558 */         buf.append((new StringBuffer()).append(it.next()).append("\n").toString());
/*     */       }
/*     */       
/* 561 */       fos.write(buf.toString().getBytes());
/* 562 */       fos.flush();
/* 563 */       fos.close();
/* 564 */       fos = null;
/* 565 */       buf = null;
/*     */     }
/* 567 */     catch (FileNotFoundException fileNotFoundException) {
/*     */ 
/*     */     
/* 570 */     } catch (IOException ex1) {
/*     */       
/* 572 */       ex1.printStackTrace();
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
/*     */   public void addEmailsToBuffer(String html, int i) {
/*     */     try {
/* 602 */       if (html == null || html.trim().equals(""))
/*     */         return; 
/* 604 */       int index = 0;
/* 605 */       while ((index = html.indexOf("mailto:", index)) != -1)
/*     */       {
/* 607 */         int nextQuote = html.indexOf("\"", index);
/* 608 */         String email = html.substring(index + 7, nextQuote);
/* 609 */         if (!email.trim().equals("")) this.emailBuffer.add(email); 
/* 610 */         index = nextQuote;
/* 611 */         if (!email.trim().equals(""))
/*     */         {
/* 613 */           if (this.firstIndex == -1) this.firstIndex = i; 
/* 614 */           this.lastIndex = i;
/* 615 */           System.out.println(email);
/* 616 */           if (i % 100 == 0) System.out.println("i = " + i);
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 623 */     catch (Exception e) {
/*     */       
/* 625 */       System.out.println("error in addEmailsToBuffer " + e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void btnSpam_actionPerformed(ActionEvent e) {
/* 631 */     String sfile = this.tfEmailFile.getText().trim();
/* 632 */     File file = new File(sfile);
/*     */     
/* 634 */     int maxEmails = Integer.parseInt(this.tfSpamNumber.getText().trim());
/* 635 */     int count = 0;
/*     */ 
/*     */     
/*     */     try {
/* 639 */       BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
/*     */       
/* 641 */       String line = null;
/*     */       
/* 643 */       while ((line = reader.readLine()) != null) {
/*     */         
/* 645 */         if (line.trim().equals(""))
/*     */           continue; 
/* 647 */         if (line.trim().indexOf("@") != -1) {
/*     */           
/* 649 */           if (htSent.containsKey(line.trim().toLowerCase())) {
/*     */             continue;
/*     */           }
/* 652 */           boolean worked = sendEmail(line.toLowerCase().trim());
/* 653 */           if (worked) {
/*     */             
/* 655 */             count++;
/* 656 */             htSent.put(line.trim().toLowerCase(), "dafdaf");
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 663 */           System.out.println("email sent to " + line);
/* 664 */           Thread.sleep(750L);
/*     */         } 
/*     */         
/* 667 */         if (count == maxEmails) {
/*     */           break;
/*     */         }
/*     */       } 
/* 671 */     } catch (Exception ex) {
/*     */       
/* 673 */       JOptionPane.showMessageDialog(this, ex);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\ImageFrame.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */