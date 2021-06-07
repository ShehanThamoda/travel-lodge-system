package lk.wiley.travellodge.controller;

import io.swagger.annotations.ApiOperation;
import lk.wiley.travellodge.response.GetHotelResponse;
import lk.wiley.travellodge.service.FileSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Min;


/**
 * @author shehan
 * @des define all search APIs
 */

@RestController
public class FileSearchController {
    private static final Logger logger = LoggerFactory.getLogger(FileSearchController.class);

    @Autowired
    FileSearchService fileSearchService;


    /**
     * @des Controller for get all hotel common details.
     * @param hotelId
     * @param authHeader
     * @return

    @ApiOperation(value = "get hotels details", notes = "get all hotels details")
    @GetMapping(value = "/hotel-details")
    public ResponseEntity<GetHotelResponse> getAllHotelDetails(
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "town", required = false) String town,
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "page", required = true) @NotBlank @Size(min = 0, message = "Page number cannot be null") int page,
            @RequestParam(value = "size", required = true) @NotBlank @Size(min = 1, message = "Page size cannot be null") int size,
            @RequestHeader("Authorization") String authHeader) {
        long startTime = System.currentTimeMillis();
        logger.info("START | Get All Hotels Details - Request: {}, {], {}, {}",date,town,country,page,size);

        //have to call service method here
        GetHotelResponse getRequestListResponse = fileSearchService.getAllHotelDetails(hotelId);
        long endTime = System.currentTimeMillis();
        logger.info("END | Get All Hotels Details | TOTAL_RESPONSE_TIME_MILSEC - {}", (endTime - startTime));
        return ResponseEntity.status(HttpStatus.OK).body(getRequestResponse);
    }*/


    /**
     * @des Controller for get hotel details by hotel id and date.Assume hotel name and date always
     * given by customer.
     * @param hotelId
     * @param date
     * @param authHeader
     * @param response
     * @return ResponseEntity<GetHotelResponse>
     */
    @ApiOperation(value = "get hotel details by id and date", notes = "get hotel details by id and date")
    @GetMapping(value = "/hotel-details/{id}/{date}")
    public ResponseEntity<GetHotelResponse> getHotelsDeatils(
            @PathVariable("id") @Min(value = 1, message="minimum value for requestId should be 1") int hotelId,
            @PathVariable("date")  String date,
            @RequestHeader("Authorization") String authHeader, HttpServletResponse response) {
        long startTime = System.currentTimeMillis();
        logger.info("START: Get Hotel Details By Id and date: {}, {}",hotelId,date);

        GetHotelResponse getHotelResponse = fileSearchService.getHotelDetails(hotelId,date);

        long endTime = System.currentTimeMillis();
        logger.info("END | Get Hotel Details By Id and date | TOTAL_RESPONSE_TIME_MILSEC - {}", (endTime - startTime));
        return ResponseEntity.status(HttpStatus.OK).body(getHotelResponse);
    }




}
