package com.eroluzun.carrentalsystem.service.impl;
import com.eroluzun.carrentalsystem.dto.CustomerDto;
import com.eroluzun.carrentalsystem.entity.Customer;
import com.eroluzun.carrentalsystem.repository.CustomerRepository;
import com.eroluzun.carrentalsystem.service.CustomerService;
import com.eroluzun.carrentalsystem.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper){

        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto save(CustomerDto customer) {

        Customer customerDb = modelMapper.map(customer, Customer.class);
        customerDb = customerRepository.save(customerDb);
        return modelMapper.map(customerDb, CustomerDto.class);
    }

    @Override
    public CustomerDto getByCustomerId(Long customerId) {

        Customer customer = customerRepository.getByCustomerId(customerId);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public List<Customer> getByCustomerIdentityNumber(String customerIdentityNumber) {
        return null;
    }

    @Override
    public TPage<CustomerDto> getAllPageable(Pageable pageable) {

        Page<Customer> data = customerRepository.findAll(pageable);
        TPage <CustomerDto> response = new TPage<CustomerDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), CustomerDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    public CustomerDto update(Long customerId, CustomerDto customer){

        Customer customerDb = customerRepository.getByCustomerId(customerId);

        if (customerDb == null)
            throw new IllegalArgumentException("Customer does not exist, id: " + customerId);

        customerDb.setCustomerName(customer.getCustomerName());
        customerDb.setCustomerSurname(customer.getCustomerSurname());
        customerDb.setCustomerIdentityNumber(customer.getCustomerIdentityNumber());
        customerDb.setCustomerPhone(customer.getCustomerPhone());

        customerRepository.save(customerDb);
        return modelMapper.map(customerDb, CustomerDto.class);
    }

}
