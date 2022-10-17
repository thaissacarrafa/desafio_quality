package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.dto.RoomDTO;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import java.util.List;

public interface IProperty {
    String getLargestRoom(List<Room> rooms);

    List<RoomDTO> getRoomsFormatted(List<Room> rooms);
    PropertyDTO processProperty(Property property);
}
