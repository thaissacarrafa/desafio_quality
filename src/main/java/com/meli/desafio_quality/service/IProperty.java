package com.meli.desafio_quality.service;

import com.meli.desafio_quality.exception.NotFoundException;
import com.meli.desafio_quality.model.Property;

import java.util.List;

public interface IProperty {

    Property getProperty(String propName) throws NotFoundException;

    List<Property> getAllProperties();

}
