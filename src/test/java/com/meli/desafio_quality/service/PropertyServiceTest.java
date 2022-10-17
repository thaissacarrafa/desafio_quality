package com.meli.desafio_quality.service;

import com.meli.desafio_quality.model.Room;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @InjectMocks
    private PropertyService service;
    @Test
    void getRoomArea_testCalculate(){
        final String RoomName = "RoomName";
        final Double RoomWidth = 50.0;
        final Double RoomLength = 50.0;
        final double Result = RoomWidth * RoomLength;

      Room room = new Room( RoomName, RoomWidth, RoomLength);

      double area = this.service.getRoomArea(room);
        assertThat(area).isEqualTo(Result);
        assertThat(area).isNotNull();
        assertThat(area).isPositive();
    }

    @Test
    void getLargestRoom() {
    }

    @Test
    void getRoomsFormatted() {
    }

    @Test
    void getPropArea() {
    }

    @Test
    void getPropValue() {
    }

    @Test
    void processProperty() {
    }
}