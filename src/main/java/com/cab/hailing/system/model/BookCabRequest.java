package com.cab.hailing.system.model;

public class BookCabRequest {

  private Rider rider;
  private int numOfPassengers;
  private String destination;

  public int getNumOfPassengers() {
    return numOfPassengers;
  }

  public void setNumOfPassengers(int numOfPassengers) {
    this.numOfPassengers = numOfPassengers;
  }

  public Rider getRider() {
    return rider;
  }

  public void setRider(Rider rider) {
    this.rider = rider;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }
}
