package com.eroluzun.carrentalsystem.service;
import com.eroluzun.carrentalsystem.dto.OptionDto;
import com.eroluzun.carrentalsystem.util.TPage;
import org.springframework.data.domain.Pageable;

public interface OptionService {

    OptionDto save (OptionDto option);
    OptionDto getByOptionId (Long optionId);
    TPage<OptionDto> getAllPageable (Pageable pageable);
    Boolean delete (Long optionId);
    OptionDto update (Long optionId, OptionDto option);
}
