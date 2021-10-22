package com.eroluzun.carrentalsystem.service.impl;
import com.eroluzun.carrentalsystem.dto.GnlCharValDto;
import com.eroluzun.carrentalsystem.entity.GnlCharVal;
import com.eroluzun.carrentalsystem.repository.CharValRepository;
import com.eroluzun.carrentalsystem.service.CharValService;
import com.eroluzun.carrentalsystem.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CharValServiceImpl implements CharValService {

    private final CharValRepository charValRepository;
    private final ModelMapper modelMapper;

    public CharValServiceImpl(CharValRepository charValRepository, ModelMapper modelMapper){

        this.charValRepository = charValRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public GnlCharValDto save(GnlCharValDto gnlCharVal) {

        GnlCharVal gnlCharValDb = modelMapper.map(gnlCharVal, GnlCharVal.class);
        gnlCharValDb = charValRepository.save(gnlCharValDb);
        return modelMapper.map(gnlCharValDb, GnlCharValDto.class);
    }

    @Override
    public GnlCharValDto getByGnlCharValId(Long gnlCharValId) {

        GnlCharVal gnlCharVal = charValRepository.getByGnlCharValId(gnlCharValId);
        if(gnlCharVal!=null){
            return modelMapper.map(gnlCharVal, GnlCharValDto.class);
        }
        else{
            return null;
        }

    }

    @Override
    public TPage<GnlCharValDto> getAllPageable(Pageable pageable) {

        Page<GnlCharVal> data = charValRepository.findAll(pageable);
        TPage <GnlCharValDto> response = new TPage<GnlCharValDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), GnlCharValDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Long gnlCharValId) {

       charValRepository.deleteById(gnlCharValId);
        return true;
    }

    @Override
    public GnlCharValDto update(Long gnlCharValId, GnlCharValDto gnlCharVal) {

        GnlCharVal gnlCharValDb = charValRepository.getByGnlCharValId(gnlCharValId);

        if(gnlCharValDb == null)
            throw new IllegalArgumentException("CharVal does not exist, id: " + gnlCharValId);

        gnlCharValDb.setShortCode(gnlCharVal.getShortCode());
        gnlCharValDb.setVal(gnlCharVal.getVal());

        charValRepository.save(gnlCharValDb);
        return modelMapper.map(gnlCharValDb, GnlCharValDto.class);
    }

}
