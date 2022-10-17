package com.meli.desafio_quality.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Room {


    private String roomName;
    private double roomWidth;
    private double roomLength;
    private double roomArea = 0.0;

    public double setRoomArea() {
        return this.roomArea = roomWidth * roomLength;
    }
}
