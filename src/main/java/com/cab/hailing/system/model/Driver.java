package com.cab.hailing.system.model;

public class Driver {
  private String driverId;
  private String name;
  private int currLocation;
  private Cab cab;
  private boolean isAvailable;

  public String getDriverId() {
    return driverId;
  }

  public void setDriverId(String driverId) {
    this.driverId = driverId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCurrLocation() {
    return currLocation;
  }

  public void setCurrLocation(int currLocation) {
    this.currLocation = currLocation;
  }

  public Cab getCab() {
    return cab;
  }

  public void setCab(Cab cab) {
    this.cab = cab;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }
}
