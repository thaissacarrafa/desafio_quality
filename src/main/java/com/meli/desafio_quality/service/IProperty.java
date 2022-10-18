package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.dto.RoomDTO;
import com.meli.desafio_quality.model.District;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import java.math.BigDecimal;
import java.util.List;

public interface IProperty {
    String getLargestRoom(List<Room> rooms);
    double getPropArea(List<Room> rooms);
    BigDecimal getPropValue(Property property);
    List<RoomDTO> getRoomsFormatted(List<Room> rooms);
    PropertyDTO processProperty(Property property);
    boolean districtExists(District district);
}
