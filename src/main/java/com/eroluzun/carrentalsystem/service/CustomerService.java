package com.eroluzun.carrentalsystem.service;
import com.eroluzun.carrentalsystem.dto.CustomerDto;
import com.eroluzun.carrentalsystem.entity.Customer;
import com.eroluzun.carrentalsystem.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    CustomerDto save (CustomerDto customer);
    CustomerDto getByCustomerId (Long customerId);
    List<Customer> getByCustomerIdentityNumber (String customerIdentityNumber);
    TPage<CustomerDto> getAllPageable(Pageable pageable);
    Boolean delete (Long customerId);
    CustomerDto update (Long customerId, CustomerDto customer);

}
