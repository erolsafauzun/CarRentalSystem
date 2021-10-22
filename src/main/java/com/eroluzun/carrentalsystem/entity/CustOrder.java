package com.eroluzun.carrentalsystem.entity;
import com.eroluzun.carrentalsystem.common.GeneralEnumerations.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUST_ORDER")
@Getter
@Setter
public class CustOrder extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long custOrderId;

    @Column(name = "ORDER_STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    
    @Column(name = "ORDER_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderStartDate;

    @Column(name = "ORDER_FINISH_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderFinishDate;

    @Column(name = "ORDER_RETURN_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderReturnDate;

    @Column(name = "ORDER_AMOUNT")
    private Double orderAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

}
