package com.eroluzun.carrentalsystem.service;
import com.eroluzun.carrentalsystem.dto.CustOrderDto;
import com.eroluzun.carrentalsystem.util.TPage;
import org.springframework.data.domain.Pageable;

public interface CustOrderService {

    CustOrderDto save (CustOrderDto custOrder);
    CustOrderDto getByCustOrderId (Long custOrderId);
    TPage<CustOrderDto> getAllPageable (Pageable pageable);
    Boolean delete (Long custOrderId);
    CustOrderDto update (Long custOrderId, CustOrderDto custOrder);
}
