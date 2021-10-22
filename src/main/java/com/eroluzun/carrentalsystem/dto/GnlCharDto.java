package com.eroluzun.carrentalsystem.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel(value = "Char Data Transfer Object")
public class GnlCharDto {

    @ApiModelProperty(value = "Char ID")
    private Long gnlCharId;

    @NotNull
    @ApiModelProperty(required = true, value = "Name of Char")
    private String name;

    @NotNull
    @ApiModelProperty(required = true, value = "Description of Char")
    private String description;

    @NotNull
    @ApiModelProperty(required = true, value = "Short Code of Char")
    private String shortCode;
}
