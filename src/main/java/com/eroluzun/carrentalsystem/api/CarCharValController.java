package com.eroluzun.carrentalsystem.api;
import com.eroluzun.carrentalsystem.dto.CarCharValDto;
import com.eroluzun.carrentalsystem.service.impl.CarCharValServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/carcharval")
public class CarCharValController {

    private final CarCharValServiceImpl carCharValServiceImpl;

    public CarCharValController(CarCharValServiceImpl carCharValServiceImpl){

        this.carCharValServiceImpl = carCharValServiceImpl;
    }

    @GetMapping("/{carCharValId}")
    public ResponseEntity<CarCharValDto> getByCarCharValId (@PathVariable(value = "carCharValId", required = true) Long carCharValId){

        CarCharValDto carCharValDto = carCharValServiceImpl.getByCarCharValId(carCharValId);
        return ResponseEntity.ok(carCharValDto);
    }

    @PostMapping
    public ResponseEntity<CarCharValDto> createCarCharVal (@Valid @RequestBody CarCharValDto carCharVal){

        return ResponseEntity.ok(carCharValServiceImpl.save(carCharVal));
    }
}
