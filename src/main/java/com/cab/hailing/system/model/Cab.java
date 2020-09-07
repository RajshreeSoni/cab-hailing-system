package com.cab.hailing.system.model;

public class Cab {
  private String cabNumber;
  private CabType cabType;
  private CabStatus cabStatus;

  public String getCabNumber() {
    return cabNumber;
  }

  public void setCabNumber(String cabNumber) {
    this.cabNumber = cabNumber;
  }

  public CabType getCabType() {
    return cabType;
  }

  public void setCabType(CabType cabType) {
    this.cabType = cabType;
  }

  public CabStatus getCabStatus() {
    return cabStatus;
  }

  public void setCabStatus(CabStatus cabStatus) {
    this.cabStatus = cabStatus;
  }

}
