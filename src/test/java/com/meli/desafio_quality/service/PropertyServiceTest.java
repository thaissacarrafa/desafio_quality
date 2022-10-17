package com.meli.desafio_quality.service;

import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    private IProperty iProperty;

    @InjectMocks
    private PropertyService service;

    private Property property;

    @BeforeEach
    public void setup(){
        Room room = new Room("room1", 30.0, 30.0, 0);
        Room room2 = new Room("room2", 20.0, 20.0, 0);
    }
    @Test
    @DisplayName("Validating larger room")
    public void getBiggerRoom_returnsRoom_withBiggerRoomArea() {
        final double expectedBiggerRoomArea = 900d;
        Mockito.when(iProperty.getBiggerRoom(ArgumentMatchers.anyString()));

        Room response = this.service.getBiggerRoom(this.property.getPropName());
        double responseArea = response.getRoomWidth() * response.getRoomLength();

        assertThat(response).isNotNull();
        assertThat(response.getRoomName()).isNotNull();
        assertThat(responseArea).isEqualTo(expectedBiggerRoomArea);
    }

}

