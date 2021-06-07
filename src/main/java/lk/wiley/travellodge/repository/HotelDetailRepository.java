package lk.wiley.travellodge.repository;

import lk.wiley.travellodge.entity.HotelDetail;
import org.springframework.stereotype.Service;


@Service
public interface HotelDetailRepository {

    HotelDetail findById(int id);


}
