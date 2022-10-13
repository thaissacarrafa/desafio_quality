package com.meli.desafio_quality.service;

import com.meli.desafio_quality.exception.NotFoundException;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import com.meli.desafio_quality.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IProperty {

    @Autowired
    private PropertyRepo repo;

    @Override
    public Property getProperty(String propName) {
        Optional<Property> property = repo.getProperty(propName);

        if (property.isEmpty()) throw new NotFoundException("Property not found");

        return property.get();
    }

    @Override
    public List<Property> getAllProperties() {
        return repo.getAllProperties();
    }


    @Override
    public List<Room>  getAeraRomsService(String propName) {
        List<Room> property = repo.getProperty(propName).get().getRooms();
        property.stream().map(room -> { room.setRoomArea(); return null;}).collect(Collectors.toList());
        return property;
    }
}
