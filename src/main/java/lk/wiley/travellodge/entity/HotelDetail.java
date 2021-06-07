package lk.wiley.travellodge.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author shehan
 * @des The persistent class for the HotelDetail database table.
 *
 */
@Entity
@Table(name="hotel_detail")
@NamedQuery(name="HotelDetail.findAll", query="SELECT h FROM HotelDetail h")
@Data
@NoArgsConstructor
public class HotelDetail implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(unique=true, nullable=false)
        private int id;

        @Column(name="name",length = 200,nullable = false)
        private String name;

        @Column(name="all_room_count",nullable = false)
        private int allRoomCount;

        @Column(name="email",length = 100)
        private String email;

        @Column(name="created_at")
        private Timestamp createdAt;
        
        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="town_id",nullable = false)
        private Town town;

        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="hotel_type_id")
        private HotelType hotelType;

        public HotelDetail(int id) {
                this.id = id;
        }
}
