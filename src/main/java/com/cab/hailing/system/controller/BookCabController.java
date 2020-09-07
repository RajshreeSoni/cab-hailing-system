package com.cab.hailing.system.controller;

import com.cab.hailing.system.model.BookCabRequest;
import com.cab.hailing.system.model.BookCabResponse;
import com.cab.hailing.system.model.BookCabResponse.Status;
import com.cab.hailing.system.model.Trip;
import com.cab.hailing.system.services.BookCabService;
import io.swagger.annotations.ApiOperation;
import javax.inject.Inject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCabController {

  private BookCabService bookCabService;

  @Inject
  public BookCabController(final BookCabService bookCabService) {
    this.bookCabService = bookCabService;
  }
  @ApiOperation(
      value = "bookCab",
      notes = "Book a cab with required type and number of passengers"
  )
  @RequestMapping(
      value = "/bookCab",
      method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public BookCabResponse bookCabForRider(@RequestBody final BookCabRequest request) {
    BookCabResponse bookCabResponse = new BookCabResponse();
    if (!validateRequest(request)) {
      bookCabResponse.setError("Invaild request");
      bookCabResponse.setStatus(Status.FAILURE);
    }
    Trip tripDetails = bookCabService.bookCabForALocation(request);
    if (tripDetails != null && tripDetails.getDriver() != null) {
      bookCabResponse.setTrip(tripDetails);
      bookCabResponse.setStatus(Status.SUCCESS);
    } else {
      bookCabResponse.setError("Sorry no cab is available right now, please try after sometime");
      bookCabResponse.setStatus(Status.FAILURE);
    }
    return bookCabResponse;
  }

  private boolean validateRequest(final BookCabRequest request) {
    return (request != null && request.getRider() != null &&
        request.getDestination() != null && request.getRider().getLocation() > 0 &&
        request.getRider().getRiderId() != null);
  }
}
