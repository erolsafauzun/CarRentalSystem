package com.eroluzun.carrentalsystem.dto;
import com.eroluzun.carrentalsystem.common.GeneralEnumerations.CarStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    private Long carId;
    private CarStatus carStatus;

    private String licensePlate;
    private Long seqCarId;
}
