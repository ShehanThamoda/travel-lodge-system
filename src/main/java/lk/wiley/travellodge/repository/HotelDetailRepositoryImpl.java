package lk.wiley.travellodge.repository;


import lk.wiley.travellodge.dao.HotelDetailsCrudRepository;
import lk.wiley.travellodge.entity.HotelDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class HotelDetailRepositoryImpl implements HotelDetailRepository {

	@Autowired
	private HotelDetailsCrudRepository hotelDetailsCrudRepository;


	@Override
	public HotelDetail findById(int id) {
		return hotelDetailsCrudRepository.findById(id);
	}
}
