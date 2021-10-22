package com.eroluzun.carrentalsystem.api;
import com.eroluzun.carrentalsystem.dto.CustomerDto;
import com.eroluzun.carrentalsystem.service.impl.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl){

        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getByCustomerId (@PathVariable(value = "customerId", required = true) Long customerId){

        CustomerDto customerDto = customerServiceImpl.getByCustomerId(customerId);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer (@Valid @RequestBody CustomerDto customer){

        return ResponseEntity.ok(customerServiceImpl.save(customer));
    }


    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable(value = "customerId", required = true) Long customerId,
                                                      @Valid @RequestBody CustomerDto customer){

        return ResponseEntity.ok(customerServiceImpl.update(customerId, customer));
    }


    @DeleteMapping("/{customerId}")
    public ResponseEntity<Boolean> delete (@PathVariable(value = "customerId", required = true) Long customerId){

        return ResponseEntity.ok(customerServiceImpl.delete(customerId));
    }
}
