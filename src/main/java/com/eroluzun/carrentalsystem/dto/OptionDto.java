package com.eroluzun.carrentalsystem.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionDto {

    private Long optionId;
    private String optionName;
    private Double optionAmount;
    private CustOrderDto custOrder;
}
