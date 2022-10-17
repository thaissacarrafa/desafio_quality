package com.meli.desafio_quality.dto;

import com.meli.desafio_quality.model.Property;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyDTO {

    private String propName;
    private double propArea;
    private BigDecimal propValue;
    private String largestRoom;
    private List<RoomDTO> rooms;

    public PropertyDTO(
        Property property,
        double propArea,
        BigDecimal propValue,
        String largestRoom,
        List<RoomDTO> rooms
    ) {
        this.propName = property.getPropName();
        this.propArea = propArea;
        this.propValue = propValue;
        this.largestRoom = largestRoom;
        this.rooms = rooms;
    }
}
