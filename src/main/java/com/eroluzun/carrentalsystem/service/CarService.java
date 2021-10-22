package com.eroluzun.carrentalsystem.service;
import com.eroluzun.carrentalsystem.dto.CarDto;
import com.eroluzun.carrentalsystem.util.TPage;
import org.springframework.data.domain.Pageable;

public interface CarService {

    CarDto save (CarDto car);
    CarDto getByCarId (Long carId);
    TPage<CarDto> getAllPageable (Pageable pageable);
    Boolean delete (Long carId);
    CarDto update(Long carId, CarDto car);
}
