package com.eroluzun.carrentalsystem.repository;
import com.eroluzun.carrentalsystem.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car getByCarId(Long carId);
    Car getByCarIdContains(Long carId);
    Page<Car> findAll (Pageable pageable);
    List<Car> findAll (Sort sort);
}
