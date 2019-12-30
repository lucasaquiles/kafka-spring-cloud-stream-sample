package com.lucasaquiles.publisher.service;

import com.lucasaquiles.publisher.channel.DeliveryStartedProducer;
import com.lucasaquiles.publisher.controller.dto.DeliveryDTO;
import com.lucasaquiles.publisher.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryStartedProducer deliveryStartedProducer;

    @Override
    public Delivery createDelivery(DeliveryDTO deliveryDTO) {

        deliveryStartedProducer.send(deliveryDTO);
        return null;
    }
}
