package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;

public interface IProperty {
    PropertyDTO processProperty(Property property);

    Room getBiggerRoom(String propName);

    List<Room>  getAreaRoomsService(String propName);
}
