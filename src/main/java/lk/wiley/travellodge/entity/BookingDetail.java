package lk.wiley.travellodge.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author shehan
 * @des The persistent class for the BookingDetail database table.
 *
 */
@Entity
@Table(name="booking_detail")
@NamedQuery(name="BookingDetail.findAll", query="SELECT b FROM BookingDetail b")
@Data
public class BookingDetail implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(unique=true, nullable=false)
        private int id;

        @Column(name="no_of_room",nullable = false)
        private int noOfRooms;

        @Column(name="no_of_adult",nullable = false)
        private int noOfAdults;

        @Column(name="no_of_child")
        private int noOfChild;

        @Column(name="date",nullable = false)
        private Timestamp date;

        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="hotel_id")
        private HotelDetail hotelDetail;

        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="guest_id")
        private UserGuest userGuest;




}
