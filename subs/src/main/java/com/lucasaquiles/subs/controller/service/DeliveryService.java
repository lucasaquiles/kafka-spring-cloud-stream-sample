package com.lucasaquiles.subs.controller.service;

import com.lucasaquiles.subs.model.Delivery;
import reactor.core.publisher.Mono;

public interface DeliveryService {

    void save(Delivery delivery);

    Mono<Delivery> getById(Long id);
}
