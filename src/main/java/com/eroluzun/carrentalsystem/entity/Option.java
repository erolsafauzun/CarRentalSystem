package com.eroluzun.carrentalsystem.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Option extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long optionId;

    @Column(name = "OPTION_NAME")
    private String optionName;

    @Column(name = "OPTION_AMOUNT")
    private Double optionAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustOrder custOrder;
}
