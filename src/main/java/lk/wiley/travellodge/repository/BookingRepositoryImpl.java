package lk.wiley.travellodge.repository;


import lk.wiley.travellodge.dao.BookingCrudRepository;
import lk.wiley.travellodge.entity.BookingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;


@Repository
public class BookingRepositoryImpl implements BookingsRepository {

	@Autowired
	private BookingCrudRepository bookingCrudRepository;
	@Override
	public BookingDetail findByHotelIdAndDate(int id, Timestamp date) {
		return bookingCrudRepository.findByHotelIdAndDate(id,date);
	}

	@Override
	public BookingDetail save(BookingDetail bookingDetail) {
		return bookingCrudRepository.save(bookingDetail);
	}
}
