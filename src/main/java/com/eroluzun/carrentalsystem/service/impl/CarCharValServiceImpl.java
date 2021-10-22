package com.eroluzun.carrentalsystem.service.impl;
import com.eroluzun.carrentalsystem.dto.CarCharValDto;
import com.eroluzun.carrentalsystem.entity.CarCharVal;
import com.eroluzun.carrentalsystem.repository.CarCharValRepository;
import com.eroluzun.carrentalsystem.service.CarCharValService;
import com.eroluzun.carrentalsystem.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CarCharValServiceImpl implements CarCharValService {

    private final CarCharValRepository carCharValRepository;
    private final ModelMapper modelMapper;

    public CarCharValServiceImpl(CarCharValRepository carCharValRepository, ModelMapper modelMapper){

        this.carCharValRepository = carCharValRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CarCharValDto save(CarCharValDto carCharVal) {

        CarCharVal carCharValDb = modelMapper.map(carCharVal, CarCharVal.class);
        carCharValDb = carCharValRepository.save(carCharValDb);
        return modelMapper.map(carCharValDb, CarCharValDto.class);
    }

    public CarCharValDto getByCarCharValId(Long carCharValId) {

        CarCharVal carCharVal = carCharValRepository.getByCarCharValId(carCharValId);
        return modelMapper.map(carCharVal, CarCharValDto.class);
    }

    @Override
    public TPage<CarCharValDto> getAllPageable(Pageable pageable) {

        Page<CarCharVal> data = carCharValRepository.findAll(pageable);
        TPage <CarCharValDto> response = new TPage<CarCharValDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), CarCharValDto[].class)));
        return response;
    }

    @Override
    public CarCharValDto delete(Long carCharValId) {

        CarCharVal carCharValDb = carCharValRepository.getByCarCharValId(carCharValId);
        carCharValRepository.deleteById(carCharValDb.getCarCharValId());
        return modelMapper.map(carCharValDb, CarCharValDto.class);
    }

}
