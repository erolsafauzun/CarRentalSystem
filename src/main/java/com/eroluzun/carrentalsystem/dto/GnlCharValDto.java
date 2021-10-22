package com.eroluzun.carrentalsystem.dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GnlCharValDto {

    private Long gnlCharValId;

    @NotNull
    private String val;

    @NotNull
    private String shortCode;

    @NotNull
    private GnlCharDto gnlChar;
}
