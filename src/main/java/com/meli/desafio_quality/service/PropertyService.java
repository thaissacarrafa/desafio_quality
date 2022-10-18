package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.dto.RoomDTO;
import com.meli.desafio_quality.exception.NotFoundException;
import com.meli.desafio_quality.model.District;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import com.meli.desafio_quality.repo.DistrictRepo;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IProperty {

    @Autowired
    private DistrictRepo districtRepo;

    public double getRoomArea(Room room) {
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
    public boolean districtExists(District district) {
        try {
            return districtRepo
                .getAll()
                .stream()
                .anyMatch(d ->
                    d.getPropDistrict().equals(district.getPropDistrict())
                );
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public PropertyDTO processProperty(Property property) {
        District district = property.getDistrict();
        List<Room> rooms = property.getRooms();

        if (!districtExists(district)) {
            throw new NotFoundException("District not found");
        }

        return new PropertyDTO(
            property,
            getPropArea(rooms),
            getPropValue(property),
            getLargestRoom(rooms),
            getRoomsFormatted(rooms)
        );
    }
}
