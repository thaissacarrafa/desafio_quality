package com.meli.desafio_quality.service;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.model.Property;

public interface IProperty {

    PropertyDTO processProperty(Property property);

}
