package com.cab.hailing.system.model;

import java.time.LocalDateTime;

public class Trip {

  private Driver driver;
  private Rider rider;
  private String source;
  private String destination;
  private String tripDuration;
  private LocalDateTime tripStartTime;
  private LocalDateTime tripEndTime;
  private TripStatus tripStatus;

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  public Rider getRider() {
    return rider;
  }

  public void setRider(Rider rider) {
    this.rider = rider;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getTripDuration() {
    return tripDuration;
  }

  public void setTripDuration(String tripDuration) {
    this.tripDuration = tripDuration;
  }

  public LocalDateTime getTripStartTime() {
    return tripStartTime;
  }

  public void setTripStartTime(LocalDateTime tripStartTime) {
    this.tripStartTime = tripStartTime;
  }

  public LocalDateTime getTripEndTime() {
    return tripEndTime;
  }

  public void setTripEndTime(LocalDateTime tripEndTime) {
    this.tripEndTime = tripEndTime;
  }

  public TripStatus getTripStatus() {
    return tripStatus;
  }

  public void setTripStatus(TripStatus tripStatus) {
    this.tripStatus = tripStatus;
  }
}
