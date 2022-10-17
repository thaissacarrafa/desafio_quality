package com.meli.desafio_quality.controller;

import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.model.Room;
import com.meli.desafio_quality.service.IProperty;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/totalArea/{propName}")
    public ResponseEntity<Property> getTotalArea(@PathVariable String propName) {
        return ResponseEntity.ok(service.getTotalArea(propName));
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(service.getAllProperties());

    }
}
