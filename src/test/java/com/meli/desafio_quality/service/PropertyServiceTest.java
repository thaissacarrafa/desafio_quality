package com.meli.desafio_quality.service;

import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    private IProperty iProperty;

    @InjectMocks
    private PropertyService service;

    private Property property;

//    @BeforeEach
    public ArrayList<Room> setup() {
        ArrayList<Room> listsRooms = new ArrayList<Room>(2);
        Room room = new Room("room1", 40.0, 30.0, 1200.0);
        Room room2 = new Room("room2", 20.0, 20.0, 0);
        listsRooms.add(room);
        listsRooms.add(room2);
        return listsRooms;
    }

    @Test
    @DisplayName("Validating room area")
    void getRoomArea_testCalculate() {
        final String RoomName = "RoomName";
        final Double RoomWidth = 50.0;
        final Double RoomLength = 50.0;
        final double Result = RoomWidth * RoomLength;

        Room room = new Room(RoomName, RoomWidth, RoomLength, Result);

        double area = this.service.getRoomArea(room);
        assertThat(area).isEqualTo(Result);
        assertThat(area).isNotNull();
        assertThat(area).isPositive();
    }

    @Test
    @DisplayName("Validating larger room")
    public void getBiggerRoom_returnsRoom_withBiggerRoomArea() {
        final double expectedBiggerRoomArea = 1200d;

        String response = this.service.getLargestRoom(setup());

        assertThat(response).isEqualTo("room1");

    }
}