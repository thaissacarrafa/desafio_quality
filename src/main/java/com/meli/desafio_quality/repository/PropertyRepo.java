package com.meli.desafio_quality.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.desafio_quality.model.Property;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
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

    public void createProperty(Property property) {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Property> properties = getAllProperties();

        properties = new ArrayList<>(properties);

        properties.add(property);

        try {
            writer.writeValue(new File(fileLink), properties);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
