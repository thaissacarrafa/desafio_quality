package com.meli.desafio_quality.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class District {

    private String propDistrict;
    private BigDecimal valueDistrictM2;

}
