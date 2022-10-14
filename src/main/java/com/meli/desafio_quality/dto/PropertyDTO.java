package com.meli.desafio_quality.dto;

import com.meli.desafio_quality.model.Property;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PropertyDTO {

    private String propName;
    private double propArea;
    private BigDecimal propValue;
    private String largestRoom;
    private List<RoomDTO> rooms;

    public PropertyDTO(Property property) {
        this.propName = property.getPropName();
        this.propArea = property.getPropArea();
        this.propValue = property.getPropValue();
        this.largestRoom = property.getLargestRoom();
        this.rooms = property.getRooms();
    }

}
