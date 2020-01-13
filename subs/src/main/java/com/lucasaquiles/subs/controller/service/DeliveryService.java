package com.lucasaquiles.subs.controller.service;

import com.lucasaquiles.subs.model.Delivery;

import java.util.Optional;

public interface DeliveryService {

    void save(Delivery delivery);

    Optional<Delivery> getById(Long id);
}
