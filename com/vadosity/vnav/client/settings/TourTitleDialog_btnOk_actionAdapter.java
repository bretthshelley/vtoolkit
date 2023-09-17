package com.vadosity.vnav.client.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TourTitleDialog_btnOk_actionAdapter implements ActionListener {
  TourTitleDialog adaptee;
  
  TourTitleDialog_btnOk_actionAdapter(TourTitleDialog paramTourTitleDialog) {
    this.adaptee = paramTourTitleDialog;
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    this.adaptee.btnOk_actionPerformed(paramActionEvent);
  }
}


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\TourTitleDialog_btnOk_actionAdapter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */