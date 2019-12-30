package com.lucasaquiles.publisher.controller;

import com.lucasaquiles.publisher.controller.dto.DeliveryDTO;
import com.lucasaquiles.publisher.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/delivery")
    HttpEntity<DeliveryDTO> create(@Valid @RequestBody DeliveryDTO deliveryDTO) {

        deliveryService.createDelivery(deliveryDTO);

        return new ResponseEntity<>(deliveryDTO, HttpStatus.CREATED);
    }
}
