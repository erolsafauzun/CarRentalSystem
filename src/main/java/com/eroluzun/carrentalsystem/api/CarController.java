package com.eroluzun.carrentalsystem.api;
import com.eroluzun.carrentalsystem.dto.CarDto;
import com.eroluzun.carrentalsystem.service.impl.CarServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    private final CarServiceImpl carServiceImpl;

    public CarController(CarServiceImpl carServiceImpl){

        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("/{carId]")
    public ResponseEntity<CarDto> getByCarId (@PathVariable(value = "carId",required = true) Long carId){

        CarDto carDto = carServiceImpl.getByCarId(carId);
        return ResponseEntity.ok(carDto);
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto car){

        return ResponseEntity.ok(carServiceImpl.save(car));
    }


    @PutMapping("/{carId}")
    public ResponseEntity<CarDto> updateCar(@PathVariable(value = "carId", required = true) Long carId, @Valid @RequestBody CarDto car){

        return ResponseEntity.ok(carServiceImpl.update(carId, car));
    }


    @DeleteMapping("/{carId}")
    public ResponseEntity<Boolean> delete (@PathVariable(value = "carId",required = true) Long carId){

        return ResponseEntity.ok(carServiceImpl.delete(carId));
    }
}
