package com.vadosity.vnav.client.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TourTitleDialog_btnCancel_actionAdapter implements ActionListener {
  TourTitleDialog adaptee;
  
  TourTitleDialog_btnCancel_actionAdapter(TourTitleDialog paramTourTitleDialog) {
    this.adaptee = paramTourTitleDialog;
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    this.adaptee.btnCancel_actionPerformed(paramActionEvent);
  }
}


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\settings\TourTitleDialog_btnCancel_actionAdapter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */