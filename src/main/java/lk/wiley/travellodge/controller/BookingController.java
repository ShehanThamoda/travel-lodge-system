package lk.wiley.travellodge.controller;

import io.swagger.annotations.ApiOperation;
import lk.wiley.travellodge.request.BookingSubmitRequest;
import lk.wiley.travellodge.response.CreateBookingResponse;
import lk.wiley.travellodge.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    BookingService bookingService;

    /**
     * @des create a reservation in this controller
     * @param requestSubmitRequest
     * @param authHeader
     * @return ResponseEntity<CreateBookingResponse>
     */
    @ApiOperation(value = "submit booking request details", notes = "submit booking request details")
    @PostMapping(value = "/booking-request")
    public ResponseEntity<CreateBookingResponse> createBookingRequest(@Valid @RequestBody BookingSubmitRequest requestSubmitRequest,
                                                                      @RequestHeader("Authorization") String authHeader) {
        long startTime = System.currentTimeMillis();
        logger.info("START | Create Booking Request - Request: {}", requestSubmitRequest.toString());

        CreateBookingResponse createRequestResponse = bookingService.requestReservation(requestSubmitRequest);
        long endTime = System.currentTimeMillis();
        logger.info("END | Create Booking Request | TOTAL_RESPONSE_TIME_MILSEC - {}", (endTime - startTime));
        return ResponseEntity.status(HttpStatus.OK).body(createRequestResponse);
    }

}
