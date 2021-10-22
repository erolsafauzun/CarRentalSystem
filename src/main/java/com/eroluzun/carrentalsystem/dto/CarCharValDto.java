package com.eroluzun.carrentalsystem.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarCharValDto {

    /* Client'a göndermek istediğim
    fieldları burada belirtirim */

    private Long carCharValId;
    private String val;

    private CarDto car;
    private GnlCharDto gnlChars;
    private GnlCharValDto gnlCharVals;
}
