package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.RoomDTO;
import com.meli.desafio_quality.model.District;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        String response = this.service.getLargestRoom(setup());

        assertThat(response).isEqualTo("room1");

    }

    @Test
    void getRoomsFormatted() {
    }

    @Test
    @DisplayName("Validating Property Area")
    void getPropArea() {
        List<Room> rooms = setup();

        double response = this.service.getPropArea(rooms);
        assertThat(response).isNotNegative();
        assertThat(response).isEqualTo(1600);
        assertThat(response).isNotNegative();
    }

    @Test
    void getPropValue() {
    }
    @Test
    @DisplayName("Validating property value")
    public void getPropValue_returnsProperty_withValue() {
        final BigDecimal expectedPropertyValue = new BigDecimal(600000);

        District district = new District("District01", new BigDecimal(1000));
        ArrayList<Room> rooms = new ArrayList<Room>(2);
        Room room = new Room("room1", 10, 20, 200.0);
        Room room2 = new Room("room2", 20.0, 20.0, 400.0);
        rooms.add(room);
        rooms.add(room2);
        Property property = new Property("Property 01", district, rooms);

        BigDecimal propertyValue  = this.service.getPropValue(property);

        org.hamcrest.MatcherAssert.assertThat(propertyValue, Matchers.comparesEqualTo(expectedPropertyValue));

    }

    @Test
    @DisplayName("Validating format Json Rooms ")
    void testGetRoomsFormatted(){
        List<RoomDTO> expectResult = new ArrayList<>(2);
        expectResult.add(new RoomDTO(setup().get(0),  1200.0));
        expectResult.add(new RoomDTO(setup().get(1),  400.0));

        List<RoomDTO> response = this.service.getRoomsFormatted(setup());

        assertThat(response).isNotNull();
        assertThat(response.get(0).getRoomName()).isEqualTo(expectResult.get(0).getRoomName());
        assertThat(response.get(1).getRoomName()).isEqualTo(expectResult.get(1).getRoomName());
        assertThat(response.get(0).getRoomArea()).isEqualTo(expectResult.get(0).getRoomArea());
        assertThat(response.get(1).getRoomArea()).isEqualTo(expectResult.get(1).getRoomArea());
    }
}