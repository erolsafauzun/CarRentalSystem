package com.eroluzun.carrentalsystem.repository;

import com.eroluzun.carrentalsystem.entity.CustOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustOrderRepository extends JpaRepository<CustOrder, Long> {

    CustOrder getByCustOrderId (Long custOrderId);

}
