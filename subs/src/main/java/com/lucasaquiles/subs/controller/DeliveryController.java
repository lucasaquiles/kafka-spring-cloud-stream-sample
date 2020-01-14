package com.lucasaquiles.subs.controller;

import com.lucasaquiles.subs.controller.service.DeliveryService;
import com.lucasaquiles.subs.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/{id}/")
    public ResponseEntity<Mono<Delivery>> get(@Valid @PathVariable Long id) {

        Mono<Delivery> delivery = deliveryService.getById(id);

        return new ResponseEntity<>(
                delivery,
                HttpStatus.OK
        );
    }
}
