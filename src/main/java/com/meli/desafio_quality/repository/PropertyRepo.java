package com.meli.desafio_quality.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio_quality.model.Property;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PropertyRepo {

    private final String fileLink = "src/main/resources/properties.json";
    ObjectMapper mapper = new ObjectMapper();

    public Optional<Property> getProperty(String propName) {
        List<Property> properties = null;

        try {
            properties = Arrays.asList(mapper.readValue(new File(fileLink), Property[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (Property p : properties) {
            if (p.getPropName().equals(propName)) return Optional.of(p);
        }

        return Optional.empty();
    }

    public List<Property> getAllProperties() {
        List<Property> properties = null;

        try {
            properties = Arrays.asList(mapper.readValue(new File(fileLink), Property[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return properties;
    }

}
