package com.meli.desafio_quality.model;

import lombok.Data;

@Data
public class Room {


    private String roomName;
    private double roomWidth;
    private double roomLength;
    private double roomArea = 0.0;

    public void setRoomArea() {
        this.roomArea = roomWidth * roomLength;
    }
}
