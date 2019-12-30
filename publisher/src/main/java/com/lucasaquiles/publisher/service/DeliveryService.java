package com.lucasaquiles.publisher.controller;

import com.lucasaquiles.publisher.controller.dto.DeliveryDTO;
import com.lucasaquiles.publisher.model.Delivery;

public interface DeliveryService {

    Delivery createDelivery(DeliveryDTO deliveryDTO);
}
