package com.eroluzun.carrentalsystem.repository;
import com.eroluzun.carrentalsystem.entity.CarCharVal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarCharValRepository extends JpaRepository<CarCharVal, Long> {

    CarCharVal getByCarCharValId(Long carCharValId);
    CarCharVal getByCarCharValIdContains(Long carCharValId);
    Page<CarCharVal> findAll (Pageable pageable);
    List<CarCharVal> findAll (Sort sort);

}
