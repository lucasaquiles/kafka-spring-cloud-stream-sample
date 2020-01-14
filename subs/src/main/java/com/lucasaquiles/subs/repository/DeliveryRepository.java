package com.lucasaquiles.subs.repository;

import com.lucasaquiles.subs.model.Delivery;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface DeliveryRepository extends ReactiveMongoRepository<Delivery, String> {

    Mono<Delivery> findByBagId(String bagId);
}
