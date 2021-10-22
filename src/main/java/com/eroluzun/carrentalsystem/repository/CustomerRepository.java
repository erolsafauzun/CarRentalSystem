package com.eroluzun.carrentalsystem.repository;
import com.eroluzun.carrentalsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getByCustomerId(Long customerId);
    Customer findByCustomerIdentityNumber(String customerIdentityNumber);

}
