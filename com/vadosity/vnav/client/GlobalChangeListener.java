package com.vadosity.vnav.client;

import com.vadosity.vnav.bean.Photo;
import com.vadosity.vnav.bean.PhotoPoint;
import com.vadosity.vnav.bean.Tour;
import com.vadosity.vnav.bean.View;

public interface GlobalChangeListener {
  void tourChanged(Tour paramTour, Object paramObject);
  
  void viewChanged(View paramView, Object paramObject);
  
  void photoChanged(Photo paramPhoto, Object paramObject);
  
  void photoPointChanged(PhotoPoint paramPhotoPoint, Object paramObject);
}


/* Location:              C:\Users\17175\Downloads\vtoolkit.zip!\com\vadosity\vnav\client\GlobalChangeListener.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */