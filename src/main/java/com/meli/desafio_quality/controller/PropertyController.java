package com.meli.desafio_quality.controller;

import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.service.IProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private IProperty service;

    @GetMapping("/{propName}")
    public ResponseEntity<Property> getProperty(@PathVariable String propName) {
        return ResponseEntity.ok(service.getProperty(propName));
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(service.getAllProperties());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProperty(@RequestBody Property property) {
        service.createProperty(property);
    }

}
