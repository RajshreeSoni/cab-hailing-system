package com.cab.hailing.system.services;

import com.cab.hailing.system.model.BookCabRequest;
import com.cab.hailing.system.model.Cab;
import com.cab.hailing.system.model.CabStatus;
import com.cab.hailing.system.model.CabType;
import com.cab.hailing.system.model.Driver;
import com.cab.hailing.system.model.Trip;
import com.cab.hailing.system.model.TripStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookCabService {

  public Trip bookCabForALocation(final BookCabRequest bookCabRequest) {
    int riderLoc = bookCabRequest.getRider().getLocation();
    int numOfPassenger = bookCabRequest.getNumOfPassengers();
    String cabType;
    if (numOfPassenger <= 4) {
      cabType = CabType.SADAN.name();
    } else if(numOfPassenger <= 6) {
      cabType = CabType.SUV.name();
    } else return null;
    List<Driver> drivers = getDriverDetails();
    int time = Integer.MAX_VALUE;
    Trip trip = new Trip();
    for (Driver driver:drivers) {
      if (isValidDriver(riderLoc, cabType, driver)) {
        // fetching min time required to reach to rider.
        int driverTime = getTime(riderLoc, driver.getCurrLocation());
        if (driverTime < time) {
          time = driverTime;
          trip.setDriver(driver);
        }
      }
    }
    trip.setRider(bookCabRequest.getRider());
    trip.setDestination(bookCabRequest.getDestination());
    trip.setSource(String.valueOf(bookCabRequest.getRider().getLocation()));
    trip.setTripStatus(TripStatus.NOT_STARTED);
    // Mocking it right now, ideally it should be get from ETA api
    trip.setTripDuration("30 mins");
    trip.setTripStartTime(LocalDateTime.now());
    // Once the driver will reach to the source, he can change the trip status to IN-PROGRESS and
    // once the driver will mark the trip status "COMPLETED", end time will be set to that current time.
    return trip;
  }

  private int getTime(final int riderLoc, final int driverLoc) {
    return Math.abs(riderLoc-driverLoc);
  }

  /* Need to fetch all the drivers who's current location is
   from riderLoc-2 to riderLoc+2 range, cab status is EMPTY and cab type is cabType.
   mocking it right now. */
  private List<Driver> getDriverDetails() {
    Cab cab1 = new Cab();
    cab1.setCabNumber("TN-1234");
    cab1.setCabStatus(CabStatus.EMPTY);
    cab1.setCabType(CabType.SADAN);
    Driver driver1 = new Driver();
    driver1.setCab(cab1);
    driver1.setAvailable(true);
    driver1.setName("Sam");
    driver1.setCurrLocation(6);
    driver1.setDriverId("1234");

    Cab cab2 = new Cab();
    cab2.setCabNumber("TN-4567");
    cab2.setCabStatus(CabStatus.EMPTY);
    cab2.setCabType(CabType.SADAN);
    Driver driver2 = new Driver();
    driver2.setCab(cab2);
    driver2.setAvailable(true);
    driver2.setName("Ram");
    driver2.setCurrLocation(1);
    driver2.setDriverId("4567");

    List<Driver> drivers = new ArrayList<>();
    drivers.add(driver1);
    drivers.add(driver2);
    return drivers;
  }

  private boolean isValidDriver(final int riderLoc,
      final String cabType, final Driver driver) {
    if (driver == null || driver.getCab() == null) return false;
    if (riderLoc-4 <= driver.getCurrLocation() && driver.getCurrLocation() <= riderLoc+4
        && driver.getCab().getCabType().name().equals(cabType)) {
      return true;
    }
    return false;
  }
}
