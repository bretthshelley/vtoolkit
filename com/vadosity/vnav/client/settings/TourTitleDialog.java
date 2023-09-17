package com.vadosity.vnav.client.settings;

import com.vadosity.vnav.client.Global;
import com.vadosity.vnav.client.VadosityToolkit;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TourTitleDialog extends JDialog {
  JPanel panel1 = new JPanel();
  
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  
  JLabel jLabel1 = new JLabel();
  
  JTextField tfTitle = new JTextField();
  
  JButton btnOk = new JButton();
  
  JButton btnCancel = new JButton();
  
  public TourTitleDialog(Frame paramFrame, String paramString, boolean paramBoolean) {
    super(paramFrame, paramString, paramBoolean);
    try {
      jbInit();
      pack();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public TourTitleDialog() {
    this((Frame)null, "", false);
  }
  
  public void setupTitle() {
    if (Global.getTour() == null)
      return; 
    String str = Global.getTour().getName();
    if (str == null)
      str = ""; 
    this.tfTitle.setText(str);
  }
  
  private void jbInit() throws Exception {
    this.panel1.setLayout(this.gridBagLayout1);
    setTitle("Tour Title Dialog");
    this.jLabel1.setText("Tour Title");
    this.tfTitle.setMinimumSize(new Dimension(100, 20));
    this.tfTitle.setPreferredSize(new Dimension(250, 20));
    this.btnOk.setText("OK");
    this.btnOk.addActionListener(new TourTitleDialog_btnOk_actionAdapter(this));
    this.btnCancel.setText("Cancel");
    this.btnCancel.addActionListener(new TourTitleDialog_btnCancel_actionAdapter(this));
    getContentPane().add(this.panel1);
    this.panel1.add(this.jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 0, new Insets(5, 5, 5, 5), 0, 0));
    this.panel1.add(this.tfTitle, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 10, 0, new Insets(5, 5, 5, 5), 0, 0));
    this.panel1.add(this.btnOk, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(5, 5, 5, 5), 0, 0));
    this.panel1.add(this.btnCancel, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 10, 0, new Insets(5, 5, 5, 5), 0, 0));
    setSize(new Dimension(400, 140));
    setupTitle();
  }
  
  void btnCancel_actionPerformed(ActionEvent paramActionEvent) {
    dispose();
  }
  
  void btnOk_actionPerformed(ActionEvent paramActionEvent) {
    if (Global.getTour() == null) {
      String str1 = "No Tour Loaded\n\nUnable to set Title";
      String str2 = "Unable to set title";
      JOptionPane.showMessageDialog(this, str1, str2, 2);
      dispose();
      return;
    } 
    Global.getTour().setName(this.tfTitle.getText());
    VadosityToolkit.getInstance().setupTitle();
    dispose();
  }
}


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\TourTitleDialog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */