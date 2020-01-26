package com.lucasaquiles.subs.controller.service;

import com.lucasaquiles.subs.model.Delivery;
import com.lucasaquiles.subs.repository.DeliveryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void save(final Delivery delivery) {

        deliveryRepository.findByBagId(delivery.getBagId())
                .switchIfEmpty(
                        deliveryRepository.save(delivery)
                );

        log.info("M=DeliveryService#save save = {}", delivery);
    }

    @Override
    public Mono<Delivery> getById(final Long id) {

        return deliveryRepository.findById(String.valueOf(id));
    }
}
