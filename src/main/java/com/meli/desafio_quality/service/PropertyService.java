package com.meli.desafio_quality.service;

import com.meli.desafio_quality.exception.NotFoundException;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import com.meli.desafio_quality.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Room getBiggerRoom(String propName) {
        Optional<Property> property = this.repo.getProperty(propName);

        if(property.isEmpty()){
            throw new NotFoundException("Propriedade: " + propName + " não encontrada!");
        }

        List<Room> roomList = property.get().getRooms();
        double area = 0;
        Room roomWidth = new Room();

        for(Room room : roomList){
            if(this.calculoArea(room) > area){
                area = this.calculoArea(room);
                roomWidth = room;
            }
        }
        return roomWidth;
    }
}
