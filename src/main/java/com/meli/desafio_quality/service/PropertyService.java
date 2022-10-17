package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.model.Property;
import org.springframework.stereotype.Service;

import com.meli.desafio_quality.model.Room;
import com.meli.desafio_quality.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IProperty {

    public PropertyDTO processProperty(Property property) {
        return new PropertyDTO(property, 0, null, null, null);
    }

    @Override
    public List<Room> getAreaRoomsService(String propName) {
        List<Room> property = repo.getProperty(propName).get().getRooms();
        property.stream().map(room -> { room.setRoomArea(); return null;}).collect(Collectors.toList());
        return property;
    }

    @Override
    public Room getBiggerRoom(String propName) {
        Optional<Property> property = this.repo.getProperty(propName);

        if (property.isEmpty()) {
            throw new NotFoundException("Propriedade: " + propName + " não encontrada!");
        }

        List<Room> roomList = property.get().getRooms();
        Room roomWidth = new Room();
        double area = 0.0;

            for (int index = 0; index < roomList.size(); index++) {
                Room element = roomList.get(index);
                element.setRoomArea();

                if (element.getRoomArea() >= area) {
                    area = element.getRoomArea();
                    roomWidth = element;
                }
            }

            return roomWidth;
        }
}
