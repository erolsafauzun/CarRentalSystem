package com.eroluzun.carrentalsystem.repository;
import com.eroluzun.carrentalsystem.entity.GnlCharVal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharValRepository extends JpaRepository<GnlCharVal, Long> {

    GnlCharVal getByGnlCharValId (Long gnlCharValId);
    GnlCharVal getByGnlCharValIdContains (Long gnlCharValId);
    Page<GnlCharVal> findAll (Pageable pageable);
    List<GnlCharVal> findAll (Sort sort);

}
