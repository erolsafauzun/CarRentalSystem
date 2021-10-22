package com.eroluzun.carrentalsystem.entity;
import com.eroluzun.carrentalsystem.common.GeneralEnumerations.CarStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Car extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long carId;

    @Column(name = "seq_car_id")
    private Long seqCarId;

    @Column(name = "CAR_STATUS")
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    @Column(name = "LICENSE_PLATE",length = 9)
    private String licensePlate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<CarCharVal> carCharVals = new ArrayList<>();

}
