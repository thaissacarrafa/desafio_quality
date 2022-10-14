package com.meli.desafio_quality.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Room {


    private String roomName;
    private double roomWidth;
    private double roomLength;
    private double roomArea = 0.0;

    public double setRoomArea() {
       return this.roomArea = roomWidth * roomLength;
    }
}
