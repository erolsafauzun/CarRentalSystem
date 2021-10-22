package com.eroluzun.carrentalsystem.service.impl;
import com.eroluzun.carrentalsystem.dto.CarDto;
import com.eroluzun.carrentalsystem.entity.Car;
import com.eroluzun.carrentalsystem.repository.CarRepository;
import com.eroluzun.carrentalsystem.service.CarService;
import com.eroluzun.carrentalsystem.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper){

        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CarDto save(CarDto car) {

        Car carDb = modelMapper.map(car, Car.class);
        carDb = carRepository.save(carDb);
        return modelMapper.map(carDb, CarDto.class);
    }

    @Override
    public CarDto getByCarId(Long carId) {

        Car car = carRepository.getByCarId(carId);
        return modelMapper.map(car, CarDto.class);
    }

    @Override
    public TPage<CarDto> getAllPageable(Pageable pageable) {

        Page<Car> data = carRepository.findAll(pageable);
        TPage <CarDto> response = new TPage<CarDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), CarDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Long carId) {

        carRepository.deleteById(carId);
        return true;
    }



    public CarDto update(Long carId, CarDto car){

        Car carDb = carRepository.getByCarId(carId);

        if (carDb == null)
            throw new IllegalArgumentException("Car does not exist, id: " + carId);

        carDb.setCarStatus(car.getCarStatus());
        carDb.setLicensePlate(car.getLicensePlate());

        carRepository.save(carDb);
        return modelMapper.map(carDb, CarDto.class);
    }

}
