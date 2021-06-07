package lk.wiley.travellodge.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the Payment database table.
 *
 */
@Entity
@Table(name="payment")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
@Data
public class Payment implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(unique=true, nullable=false)
        private int id;

        @Column(name="method",length = 50)
        private String method;

        @Column(name="amount",precision=5, scale=2)
        private BigDecimal amount;

        @Column(name="paid_amount",precision=10, scale=2)
        private BigDecimal paidAmount;

        @Column(name="gateway_charges",precision=10, scale=2)
        private BigDecimal gatewayCharges;

        @Column(name="paid",nullable = false)
        private Integer paid;

        @Column(name="transaction_date")
        private Timestamp transactionDate;

        @Column(name="ipg_reference")
        private String ipgReference;

        @Column(name="transaction_reference")
        private String transactionReference;

        @Column(name="created_at")
        private Timestamp createdAt;

        @Column(name="updated_at")
        private Timestamp updatedAt;

        //bi-directional many-to-one association to BookingDetail
        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="booking_id")
        private BookingDetail bookingDetail;


}
