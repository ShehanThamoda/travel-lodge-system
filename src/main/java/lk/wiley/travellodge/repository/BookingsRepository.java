package lk.wiley.travellodge.repository;

import lk.wiley.travellodge.entity.BookingDetail;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
public interface BookingsRepository {

    BookingDetail findByHotelIdAndDate(int id, Timestamp date);
    BookingDetail save(BookingDetail bookingDetail);



}
