package lk.wiley.travellodge.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author shehan
 * @des The persistent class for the Town database table.
 *
 */
@Entity
@Table(name="town")
@NamedQuery(name="Town.findAll", query="SELECT t FROM Town t")
@Data
@NoArgsConstructor
public class Town implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(unique=true, nullable=false)
        private int id;

        @Column(name="town",length =100,nullable = false)
        private String town;

        @Column(name="code",length = 10,nullable = false)
        private String code;

        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="assigning_office_location_id",nullable = false)
        private Country country;

        public Town(int id) {
                this.id = id;
        }
}
