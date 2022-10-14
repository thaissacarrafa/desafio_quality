package com.meli.desafio_quality.controller;

import com.meli.desafio_quality.dto.PropertyDTO;
import com.meli.desafio_quality.model.Property;
import com.meli.desafio_quality.service.IProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private IProperty service;

    @PostMapping
    public ResponseEntity<PropertyDTO> processProperty(@RequestBody Property property) {
        return ResponseEntity.ok(service.processProperty(property));
    }

}
