package com.lucasaquiles.subs.repository;

import com.lucasaquiles.subs.model.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DeliveryRepository extends MongoRepository<Delivery, String> {

    Optional<Delivery> findByBagId(Long id);
}
