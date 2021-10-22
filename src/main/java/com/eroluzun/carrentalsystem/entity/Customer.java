package com.eroluzun.carrentalsystem.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customerId;

    @Column(name = "CUST_NAME")
    private String customerName;

    @Column(name = "CUST_SURNAME")
    private String customerSurname;

    @Column(name = "CUST_IDENTITY_NUMBER", length = 11)
    private String customerIdentityNumber;

    @Column(name = "CUST_PHONE")
    private String customerPhone;
}
