package com.eroluzun.carrentalsystem.service;
import com.eroluzun.carrentalsystem.dto.GnlCharDto;
import com.eroluzun.carrentalsystem.util.TPage;
import org.springframework.data.domain.Pageable;

public interface CharService {

    GnlCharDto save (GnlCharDto gnlChar);
    GnlCharDto getByGnlCharId (Long gnlCharId);
    TPage<GnlCharDto> getAllPageable (Pageable pageable);
    Boolean delete (Long gnlCharId);
    GnlCharDto update(Long gnlCharId, GnlCharDto gnlChar);
}
