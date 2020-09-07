package com.cab.hailing.system.model;

public class Rider {
  private String riderId;
  private String riderName;
  private int location;

  public String getRiderId() {
    return riderId;
  }

  public void setRiderId(String riderId) {
    this.riderId = riderId;
  }

  public String getRiderName() {
    return riderName;
  }

  public void setRiderName(String riderName) {
    this.riderName = riderName;
  }

  public int getLocation() {
    return location;
  }

  public void setLocation(int location) {
    this.location = location;
  }

}
