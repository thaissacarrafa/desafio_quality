package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.model.Property;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IProperty {

    public PropertyDTO processProperty(Property property) {
        return new PropertyDTO(property, 0, null, null, null);
    }

}
