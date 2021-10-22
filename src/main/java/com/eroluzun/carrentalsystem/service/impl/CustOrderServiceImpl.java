package com.eroluzun.carrentalsystem.service.impl;
import com.eroluzun.carrentalsystem.dto.CustOrderDto;
import com.eroluzun.carrentalsystem.entity.CustOrder;
import com.eroluzun.carrentalsystem.repository.CustOrderRepository;
import com.eroluzun.carrentalsystem.service.CustOrderService;
import com.eroluzun.carrentalsystem.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustOrderServiceImpl implements CustOrderService {

    private final CustOrderRepository custOrderRepository;
    private final ModelMapper modelMapper;

    public CustOrderServiceImpl(CustOrderRepository custOrderRepository,ModelMapper modelMapper ){

        this.custOrderRepository = custOrderRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CustOrderDto save(CustOrderDto custOrder) {

        CustOrder custOrderDb = modelMapper.map(custOrder, CustOrder.class);
        custOrderDb = custOrderRepository.save(custOrderDb);
        return modelMapper.map(custOrderDb, CustOrderDto.class);
    }

    @Override
    public CustOrderDto getByCustOrderId(Long custOrderId) {

        CustOrder custOrder = custOrderRepository.getByCustOrderId(custOrderId);
        return modelMapper.map(custOrder, CustOrderDto.class);

    }

    @Override
    public TPage<CustOrderDto> getAllPageable(Pageable pageable) {

        Page<CustOrder> data = custOrderRepository.findAll(pageable);
        TPage <CustOrderDto> response = new TPage<CustOrderDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), CustOrderDto[].class)));
        return response;

    }

    @Override
    public Boolean delete(Long custOrderId) {

        custOrderRepository.deleteById(custOrderId);
        return true;
    }

    @Override
    public CustOrderDto update(Long custOrderId, CustOrderDto custOrder) {

        CustOrder custOrderDb = custOrderRepository.getByCustOrderId(custOrderId);

        if (custOrderDb == null)
            throw new IllegalArgumentException("CustOrder does not exist, id: " + custOrderId);

        custOrderDb.setOrderStatus(custOrder.getOrderStatus());
        custOrderDb.setOrderStartDate(custOrder.getOrderStartDate());
        custOrderDb.setOrderFinishDate(custOrder.getOrderFinishDate());
        custOrderDb.setOrderAmount(custOrder.getOrderAmount());

        custOrderRepository.save(custOrderDb);
        return modelMapper.map(custOrderDb, CustOrderDto.class);
    }

}
