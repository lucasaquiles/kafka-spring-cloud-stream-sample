package com.lucasaquiles.subs.controller.service;

import com.lucasaquiles.subs.model.Delivery;
import com.lucasaquiles.subs.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void save(Delivery delivery) {

        deliveryRepository.findByBagId(delivery.getBagId())
                .orElse(deliveryRepository.save(delivery));
    }

    @Override
    public Optional<Delivery> getById(Long id) {

        return deliveryRepository.findById(String.valueOf(id));
    }
}
