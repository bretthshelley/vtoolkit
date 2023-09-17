/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import com.vadosity.vnav.applet.AppletViewImagePanel;
/*     */ import com.vadosity.vnav.bean.Photo;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JWindow;
/*     */ import javax.swing.ToolTipManager;
/*     */ 
/*     */ public class MiniDocumentWindow
/*     */   extends JWindow
/*     */ {
/*  15 */   BorderLayout borderLayout1 = new BorderLayout();
/*  16 */   Photo photo = null;
/*  17 */   int x = 0;
/*  18 */   int y = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public MiniDocumentWindow(Photo photo, ViewImagePanel vip) {
/*     */     try {
/*  24 */       jbInit();
/*  25 */       ImageUtil.getDocumentImage();
/*  26 */       setBackground((Color)null);
/*     */       
/*  28 */       setSize(21, 28);
/*  29 */       this.x = (vip.getLocationOnScreen()).x + photo.getPhotoPoint().getX() + 10;
/*  30 */       this.y = (vip.getLocationOnScreen()).y + photo.getPhotoPoint().getY();
/*  31 */       setLocation(this.x, this.y);
/*  32 */       setVisible(true);
/*     */       
/*  34 */       (new KillerThread(this, this)).start();
/*  35 */       this.photo = photo;
/*     */     }
/*  37 */     catch (Exception e) {
/*     */       
/*  39 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MiniDocumentWindow(Photo photo, AppletViewImagePanel vip) {
/*     */     try {
/*  47 */       jbInit();
/*  48 */       ImageUtil.getDocumentImage();
/*  49 */       setBackground((Color)null);
/*     */       
/*  51 */       setSize(21, 28);
/*  52 */       this.x = (vip.getLocationOnScreen()).x + photo.getPhotoPoint().getX();
/*  53 */       this.y = (vip.getLocationOnScreen()).y + photo.getPhotoPoint().getY();
/*  54 */       setLocation(this.x, this.y);
/*  55 */       setVisible(true);
/*     */       
/*  57 */       (new KillerThread(this, this)).start();
/*  58 */       this.photo = photo;
/*     */     }
/*  60 */     catch (Exception e) {
/*     */       
/*  62 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MiniDocumentWindow() {
/*     */     try {
/*  71 */       jbInit();
/*     */       
/*  73 */       (new KillerThread(this, this)).start();
/*     */     
/*     */     }
/*  76 */     catch (Exception e) {
/*  77 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  83 */     super.paint(g);
/*  84 */     g.drawImage(ImageUtil.getDocumentImage(), 0, 0, this);
/*     */   }
/*     */   
/*     */   class KillerThread
/*     */     extends Thread {
/*     */     MiniDocumentWindow mdWindow;
/*     */     final MiniDocumentWindow this$0;
/*     */     
/*     */     KillerThread(MiniDocumentWindow this$0, MiniDocumentWindow mdWindow) {
/*  93 */       this.this$0 = this$0;
/*     */       this.mdWindow = null;
/*  95 */       this.mdWindow = mdWindow;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/* 102 */         Thread.sleep(ToolTipManager.sharedInstance().getDismissDelay());
/* 103 */         this.mdWindow.dispose();
/*     */       }
/* 105 */       catch (Exception e) {
/*     */         
/* 107 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void jbInit() throws Exception {
/* 113 */     getContentPane().setLayout(this.borderLayout1);
/* 114 */     addMouseListener(new MiniDocumentWindow_this_mouseAdapter(this));
/*     */   }
/*     */ 
/*     */   
/*     */   void this_mouseClicked(MouseEvent e) {
/* 119 */     dispose();
/*     */     
/* 121 */     if (this.photo != null)
/*     */     {
/* 123 */       if (Settings.getMode() == 0) {
/*     */         
/* 125 */         TextEditDialog ted = new TextEditDialog(VadosityToolkit.getInstance());
/* 126 */         ted.setFormattedText(this.photo.getDescription());
/* 127 */         ted.setPhoto(this.photo); 
/* 128 */         try { Global.setPhoto(this.photo, this); } catch (Exception exception) {}
/* 129 */         ted.setModal(true);
/* 130 */         ted.setTitle("Edit Photo Description");
/* 131 */         int width = 320;
/* 132 */         int height = 340;
/* 133 */         ted.setSize(width, height);
/* 134 */         ted.setLocation(getLocation());
/* 135 */         ted.setVisible(true);
/*     */         
/* 137 */         int result = ted.getResult();
/* 138 */         if (result == 0)
/*     */         {
/* 140 */           Global.getPhoto().setDescription(ted.getFormattedText());
/*     */         }
/*     */       } else {
/*     */       
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\MiniDocumentWindow.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */