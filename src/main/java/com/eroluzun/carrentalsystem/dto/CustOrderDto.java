package com.eroluzun.carrentalsystem.dto;
import com.eroluzun.carrentalsystem.common.GeneralEnumerations.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustOrderDto {

    private Long custOrderId;
    private OrderStatus orderStatus;
    private Date orderStartDate;
    private Date orderFinishDate;
    private Double orderAmount;
    private CarDto car;
    private CustomerDto customer;

}
