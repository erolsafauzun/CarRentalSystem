package com.eroluzun.carrentalsystem.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    private Long customerId;
    private String customerName;
    private String customerSurname;
    private String customerIdentityNumber;
    private String customerPhone;
}
