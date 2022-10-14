package com.meli.desafio_quality.model;

import com.meli.desafio_quality.dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    private String propName;
    private District district;
    private List<RoomDTO> rooms;
    private double propArea;
    private BigDecimal propValue;
    private String largestRoom;

}
