package com.eroluzun.carrentalsystem.service;
import com.eroluzun.carrentalsystem.dto.CarCharValDto;
import com.eroluzun.carrentalsystem.util.TPage;
import org.springframework.data.domain.Pageable;

public interface CarCharValService {

    CarCharValDto save (CarCharValDto carCharVal);
    CarCharValDto getByCarCharValId (Long carCharValId);
    TPage<CarCharValDto> getAllPageable (Pageable pageable);
    CarCharValDto delete (Long carCharValId);

}
