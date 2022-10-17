package com.meli.desafio_quality.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.meli.desafio_quality.exception.NotFoundException;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;

import java.util.List;

public interface IProperty {

    Property getProperty(String propName) throws NotFoundException;

    List<Property> getAllProperties();

    Property getTotalArea(String propName);

    Room getBiggerRoom(String propName);

    List<Room>  getAreaRoomsService(String propName );

    Property addPropertyValue(Property property);
}
