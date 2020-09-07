package com.cab.hailing.system.model;

public class BookCabResponse {

  private Status status;
  private Trip trip;
  private String error;

  public enum Status {
    SUCCESS,
    FAILURE
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }
}
