package com.eroluzun.carrentalsystem.service.impl;
import com.eroluzun.carrentalsystem.dto.OptionDto;
import com.eroluzun.carrentalsystem.entity.Option;
import com.eroluzun.carrentalsystem.repository.OptionRepository;
import com.eroluzun.carrentalsystem.service.OptionService;
import com.eroluzun.carrentalsystem.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;
    private final ModelMapper modelMapper;

    public OptionServiceImpl(OptionRepository optionRepository, ModelMapper modelMapper){

        this.optionRepository = optionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OptionDto save(OptionDto option) {

        Option optionDb = modelMapper.map(option, Option.class);
        optionDb = optionRepository.save(optionDb);
        return modelMapper.map(optionDb, OptionDto.class);

    }

    @Override
    public OptionDto getByOptionId(Long optionId) {

        Option option = optionRepository.getByOptionId(optionId);
        return modelMapper.map(option,OptionDto.class);

    }

    @Override
    public TPage<OptionDto> getAllPageable(Pageable pageable) {

        Page<Option> data = optionRepository.findAll(pageable);
        TPage <OptionDto> response = new TPage<OptionDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), OptionDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Long optionId) {

       optionRepository.deleteById(optionId);
       return true;
    }

    @Override
    public OptionDto update(Long optionId, OptionDto option) {

        Option optionDb = optionRepository.getByOptionId(optionId);

        if (optionDb == null)
            throw new IllegalArgumentException("Option does not exist, id: " + optionId);

        optionDb.setOptionName(option.getOptionName());
        optionDb.setOptionAmount(option.getOptionAmount());

        optionRepository.save(optionDb);
        return modelMapper.map(optionDb, OptionDto.class);
    }

}
