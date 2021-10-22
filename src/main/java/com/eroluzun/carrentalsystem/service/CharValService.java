package com.eroluzun.carrentalsystem.service;
import com.eroluzun.carrentalsystem.dto.GnlCharValDto;
import com.eroluzun.carrentalsystem.util.TPage;
import org.springframework.data.domain.Pageable;

public interface CharValService {

    GnlCharValDto save (GnlCharValDto gnlCharVal);
    GnlCharValDto getByGnlCharValId(Long gnlCharValId);
    TPage<GnlCharValDto> getAllPageable(Pageable pageable);
    Boolean delete (Long gnlCharValId);
    GnlCharValDto update(Long gnlCharValId, GnlCharValDto gnlCharVal);
}
