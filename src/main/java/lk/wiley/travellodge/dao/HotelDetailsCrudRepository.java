package lk.wiley.travellodge.dao;

import lk.wiley.travellodge.entity.HotelDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;


@Transactional
public interface HotelDetailsCrudRepository extends JpaRepository<HotelDetail,Long> {

	HotelDetail findById(int id);



}
