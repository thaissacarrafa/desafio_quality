package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.dto.RoomDTO;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IProperty {

    @Override
    public String getLargestRoom(List<Room> rooms) {
        String largestRoom = "";
        double largestRoomArea = 0;

        for (Room room : rooms) {
            double roomArea = room.getRoomWidth() * room.getRoomLength();
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
                double roomArea = room.getRoomWidth() * room.getRoomLength();
                return new RoomDTO(room, roomArea);
            })
            .collect(Collectors.toList());
    }

    @Override
    public PropertyDTO processProperty(Property property) {
        return new PropertyDTO(
            property,
            0,
            null,
            getLargestRoom(property.getRooms()),
            getRoomsFormatted(property.getRooms())
        );
    }
}
