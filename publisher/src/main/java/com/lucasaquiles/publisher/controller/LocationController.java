package com.lucasaquiles.publisher.controller;

import com.lucasaquiles.publisher.controller.dto.LocationDTO;
import com.lucasaquiles.publisher.controller.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationDTO> addLocation(@Valid @RequestBody LocationDTO request) {

        locationService.addLocation(request);

        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }
}
