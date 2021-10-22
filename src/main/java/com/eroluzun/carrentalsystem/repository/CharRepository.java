package com.eroluzun.carrentalsystem.repository;
import com.eroluzun.carrentalsystem.entity.GnlChar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharRepository extends JpaRepository<GnlChar, Long> {

    GnlChar getByGnlCharId (Long gnlCharId);
    GnlChar getByGnlCharIdContains (Long gnlCharId);
    Page<GnlChar> findAll (Pageable pageable);
    List<GnlChar> findAll (Sort sort);
}
