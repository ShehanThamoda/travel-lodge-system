package lk.wiley.travellodge.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author shehan
 * @des The persistent class for the HotelType database table.
 *
 */
@Entity
@Table(name="hotel_type")
@NamedQuery(name="HotelType.findAll", query="SELECT c FROM HotelType c")
@Data
@NoArgsConstructor
public class HotelType implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(unique=true, nullable=false)
        private int id;

        @Column(name="star")
        private int star;

        public HotelType(int star) {
                this.star = star;
        }
}
