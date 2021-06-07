package lk.wiley.travellodge.service;

import lk.wiley.travellodge.entity.BookingDetail;
import lk.wiley.travellodge.entity.HotelDetail;
import lk.wiley.travellodge.entity.UserGuest;
import lk.wiley.travellodge.repository.BookingsRepository;
import lk.wiley.travellodge.request.BookingSubmitRequest;
import lk.wiley.travellodge.response.BookingResponse;
import lk.wiley.travellodge.response.CreateBookingResponse;
import lombok.Synchronized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author shehan
 * @des implement all the business logic of booking in here
 */
@Service
public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingsRepository bookingsRepository;

    /**
     * @des insert booking details in here
     * @param requestSubmitRequest
     * @return CreateBookingResponse
     */
    @Synchronized
    public CreateBookingResponse requestReservation(BookingSubmitRequest requestSubmitRequest){
        CreateBookingResponse createBookingResponse = new CreateBookingResponse();
        BookingResponse bookingResponse = new BookingResponse();
        BookingDetail bookingDetail = new BookingDetail();
        bookingDetail.setNoOfRooms(requestSubmitRequest.getNoOfRooms());
        bookingDetail.setNoOfAdults(requestSubmitRequest.getAdult());
        bookingDetail.setNoOfChild(requestSubmitRequest.getChildren());

        LocalDate localDate = LocalDate.parse(requestSubmitRequest.getDate());
        LocalDateTime startOfDayInDateFrom = localDate.atStartOfDay();
        bookingDetail.setDate(Timestamp.valueOf(startOfDayInDateFrom));

        bookingDetail.setHotelDetail(new HotelDetail(requestSubmitRequest.getHotelId()));
        bookingDetail.setUserGuest(new UserGuest(requestSubmitRequest.getGuestId()));
        bookingDetail = bookingsRepository.save(bookingDetail);
        logger.info("Successfully inserted the booking detail.Booking Id:{}",bookingDetail.getId());

        bookingResponse.setId(bookingDetail.getId());
        createBookingResponse.setData(bookingResponse);
        return createBookingResponse;
    }


}
