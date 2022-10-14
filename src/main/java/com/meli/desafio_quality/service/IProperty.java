package com.meli.desafio_quality.service;

import com.meli.desafio_quality.exception.NotFoundException;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;

import java.util.List;

public interface IProperty {

    Property getProperty(String propName) throws NotFoundException;

    List<Property> getAllProperties();

    List<Room>  getAeraRomsService(String propName );

    Object getBiggerRoom(String propName);
}
