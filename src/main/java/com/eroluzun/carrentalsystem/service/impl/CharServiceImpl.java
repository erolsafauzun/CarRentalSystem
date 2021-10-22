package com.eroluzun.carrentalsystem.service.impl;
import com.eroluzun.carrentalsystem.dto.GnlCharDto;
import com.eroluzun.carrentalsystem.entity.GnlChar;
import com.eroluzun.carrentalsystem.repository.CharRepository;
import com.eroluzun.carrentalsystem.service.CharService;
import com.eroluzun.carrentalsystem.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CharServiceImpl implements CharService {

    private final CharRepository charRepository;
    private final ModelMapper modelMapper;

    public CharServiceImpl(CharRepository charRepository, ModelMapper modelMapper){

        this.charRepository = charRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GnlCharDto save(GnlCharDto gnlChar) {

        GnlChar gnlCharDb = modelMapper.map(gnlChar, GnlChar.class);
        gnlCharDb = charRepository.save(gnlCharDb);
        return modelMapper.map(gnlCharDb, GnlCharDto.class);
    }

    @Override
    public GnlCharDto getByGnlCharId(Long gnlCharId) {

        GnlChar gnlChar = charRepository.getByGnlCharId(gnlCharId);
        return  modelMapper.map(gnlChar, GnlCharDto.class);
    }

    @Override
    public TPage<GnlCharDto> getAllPageable(Pageable pageable) {

        Page<GnlChar> data = charRepository.findAll(pageable);
        TPage <GnlCharDto> response = new TPage<GnlCharDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), GnlCharDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Long gnlCharId) {

        charRepository.deleteById(gnlCharId);
        return true;
    }

    @Override
    public GnlCharDto update(Long gnlCharId, GnlCharDto gnlChar) {

        GnlChar gnlCharDb = charRepository.getByGnlCharId(gnlCharId);

        if (gnlCharDb == null)
            throw new IllegalArgumentException("Char does not exist, id: " + gnlCharId);

        gnlCharDb.setShortCode(gnlChar.getShortCode());
        gnlCharDb.setName(gnlChar.getName());

        charRepository.save(gnlCharDb);
        return modelMapper.map(gnlCharDb, GnlCharDto.class);
    }

}
