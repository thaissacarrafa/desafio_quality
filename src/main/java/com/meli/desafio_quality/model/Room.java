package com.meli.desafio_quality.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Room {

    private String roomName;
    private double roomWidth;
    private double roomLength;
    private double roomArea = 0.0;

    public double setRoomArea() {
        return this.roomArea = roomWidth * roomLength;
    }
}
