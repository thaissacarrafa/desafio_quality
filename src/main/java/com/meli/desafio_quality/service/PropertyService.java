package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.dto.RoomDTO;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IProperty {

    private double getRoomArea(Room room) {
        return room.getRoomWidth() * room.getRoomLength();
    }

    @Override
    public String getLargestRoom(List<Room> rooms) {
        String largestRoom = "";
        double largestRoomArea = 0;

        for (Room room : rooms) {
            double roomArea = getRoomArea(room);
            if (roomArea > largestRoomArea) {
                largestRoomArea = roomArea;
                largestRoom = room.getRoomName();
            }
        }
        return largestRoom;
    }

    @Override
    public List<RoomDTO> getRoomsFormatted(List<Room> rooms) {
        return rooms
            .stream()
            .map(room -> {
                double roomArea = getRoomArea(room);
                return new RoomDTO(room, roomArea);
            })
            .collect(Collectors.toList());
    }

    @Override
    public double getPropArea(List<Room> rooms) {
        return rooms.stream().mapToDouble(this::getRoomArea).sum();
    }

    @Override
    public BigDecimal getPropValue(Property property) {
        double propArea = getPropArea(property.getRooms());
        return property
            .getDistrict()
            .getValueDistrictM2()
            .multiply(BigDecimal.valueOf(propArea));
    }

    @Override
    public PropertyDTO processProperty(Property property) {
        return new PropertyDTO(
            property,
            getPropArea(property.getRooms()),
            getPropValue(property),
            getLargestRoom(property.getRooms()),
            getRoomsFormatted(property.getRooms())
        );
    }
}
