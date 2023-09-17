/*     */ package com.vadosity.vnav.client;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Point;
/*     */ import java.awt.dnd.DropTargetDragEvent;
/*     */ import java.awt.dnd.DropTargetDropEvent;
/*     */ import java.awt.dnd.DropTargetEvent;
/*     */ import java.awt.dnd.DropTargetListener;
/*     */ import javax.swing.SwingUtilities;
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
/*     */ 
/*     */ class TCPDropTargetListener
/*     */   implements DropTargetListener
/*     */ {
/*     */   public void dragEnter(DropTargetDragEvent e) {}
/*     */   
/*     */   public void dragExit(DropTargetEvent e) {
/* 157 */     ToolkitContentPane tcp = (ToolkitContentPane)e.getDropTargetContext().getComponent();
/* 158 */     tcp.setDataDragging(false);
/* 159 */     tcp.setMouse((Point)null);
/*     */ 
/*     */     
/* 162 */     tcp.updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dragOver(DropTargetDragEvent e) {
/* 169 */     ToolkitContentPane tcp = (ToolkitContentPane)e.getDropTargetContext().getComponent();
/* 170 */     tcp.setDataDragging(true);
/* 171 */     tcp.setMouse(e.getLocation());
/* 172 */     tcp.updateUI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropActionChanged(DropTargetDragEvent e) {
/* 178 */     ToolkitContentPane tcp = (ToolkitContentPane)e.getDropTargetContext().getComponent();
/* 179 */     tcp.setDataDragging(false);
/* 180 */     tcp.setMouse((Point)null);
/* 181 */     tcp.updateUI();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drop(DropTargetDropEvent e) {
/* 186 */     ToolkitContentPane tcp = (ToolkitContentPane)e.getDropTargetContext().getComponent();
/* 187 */     tcp.setDataDragging(false);
/* 188 */     tcp.setMouse((Point)null);
/* 189 */     tcp.updateUI();
/*     */ 
/*     */     
/* 192 */     Component c = SwingUtilities.getDeepestComponentAt(tcp, (e.getLocation()).x, (e.getLocation()).y);
/*     */   }
/*     */ }


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\TCPDropTargetListener.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */