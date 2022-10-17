package com.meli.desafio_quality.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    private String propName;
    private District district;
    private List<Room> rooms;
}
