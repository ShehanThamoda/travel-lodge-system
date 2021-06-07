package lk.wiley.travellodge.dao;

import lk.wiley.travellodge.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;


@Transactional
public interface BookingCrudRepository extends JpaRepository<BookingDetail,Long> {

	@Query(value = "SELECT * FROM booking_detail b WHERE b.hotel_id =:id and b.date =:date FOR UPDATE ",nativeQuery = true)
	BookingDetail findByHotelIdAndDate(int id, Timestamp date);


}
