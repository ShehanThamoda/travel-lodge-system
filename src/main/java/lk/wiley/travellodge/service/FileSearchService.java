package lk.wiley.travellodge.service;

import lk.wiley.travellodge.bean.ErrorsBean;
import lk.wiley.travellodge.entity.BookingDetail;
import lk.wiley.travellodge.entity.HotelDetail;
import lk.wiley.travellodge.repository.BookingsRepository;
import lk.wiley.travellodge.repository.HotelDetailRepository;
import lk.wiley.travellodge.response.GetHotelResponse;
import lk.wiley.travellodge.response.HotelDetailsResponse;
import lk.wiley.travellodge.util.CommonUtil;
import lk.wiley.travellodge.util.ErrorCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author shehan
 * @des implement all methods related to the search details in here
 */
@Service
public class FileSearchService {
    private static final Logger logger = LoggerFactory.getLogger(FileSearchService.class);

    @Autowired
    private BookingsRepository bookingsRepository;

    @Autowired
    private HotelDetailRepository hotelDetailRepository;

    @Autowired
    private MessageSource messageSource;

    /**
     * @des Get each reservations from booking details and compare with the
     * hotel details records and get the available number of rooms.
     * @param id
     * @param date
     * @return GetHotelResponse
     */
    public GetHotelResponse getHotelDetails(int id,String date){
        GetHotelResponse getHotelResponse = new GetHotelResponse();
        HotelDetailsResponse hotelDetailsResponse = new HotelDetailsResponse();
        Timestamp requestedDateTime=null;

        try {
            //convert requestedDateTime to TimeStamp
            if (date != null) {
                LocalDate localDateFrom = LocalDate.parse(date);
                LocalDateTime startOfDayInDateFrom = localDateFrom.atStartOfDay();
                requestedDateTime = Timestamp.valueOf(startOfDayInDateFrom);
            } else{
                requestedDateTime = CommonUtil.getDateTimeNow();
            }
            HotelDetail hotelDetail = hotelDetailRepository.findById(id);
            if(hotelDetail!=null){
                hotelDetailsResponse.setId(id);
                hotelDetailsResponse.setName(hotelDetail.getName());
                BookingDetail bookingDetail = bookingsRepository.findByHotelIdAndDate(id,requestedDateTime);
                    if(bookingDetail!=null){
                        int availabeRooms = hotelDetail.getAllRoomCount()-bookingDetail.getNoOfRooms();
                        hotelDetailsResponse.setAvailableRooms(availabeRooms);
                    }else{
                        hotelDetailsResponse.setAvailableRooms(hotelDetail.getAllRoomCount());
                    }
            }else{
                ErrorsBean errorsBean = CommonUtil.setError(String.valueOf(ErrorCodes.NO_RECORDS_FOUND_DB), messageSource.getMessage(String.valueOf(ErrorCodes.NO_RECORDS_FOUND_DB), null, LocaleContextHolder.getLocale()));
                getHotelResponse.setErrorsBean(errorsBean);
            }

            //set request entity data to response bean
            getHotelResponse.setHotelDetailsResponse(hotelDetailsResponse);
        }catch (Exception ex){
            logger.error("Exception occurred:" + ex);
        }
        return getHotelResponse;
    }
}
