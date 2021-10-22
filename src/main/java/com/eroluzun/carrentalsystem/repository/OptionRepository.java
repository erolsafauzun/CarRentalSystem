package com.eroluzun.carrentalsystem.repository;

import com.eroluzun.carrentalsystem.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {

    Option getByOptionId (Long optionId);

}
