package com.meli.desafio_quality.model;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    private String propName;
    private District district;
    private List<Room> rooms;
}
