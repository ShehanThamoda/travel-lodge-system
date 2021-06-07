package lk.wiley.travellodge.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author shehan
 * @des The persistent class for the Country database table.
 *
 */
@Entity
@Table(name="country")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
@Data
@NoArgsConstructor
public class Country implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(unique=true, nullable=false)
        private int id;

        @Column(name="country",length = 100,nullable = false)
        private String country;

        @Column(name="code",length = 10,nullable = false)
        private String code;

        public Country(int id) {
                this.id = id;
        }

}
