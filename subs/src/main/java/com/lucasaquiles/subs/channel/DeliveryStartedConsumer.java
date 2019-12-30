package com.lucasaquiles.subs.channel;

import com.lucasaquiles.stream.DeliveryStartedEvent;
import com.lucasaquiles.subs.controller.service.DeliveryService;
import com.lucasaquiles.subs.model.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeliveryStartedConsumer {

    @Autowired
    private DeliveryService deliveryService;

    @StreamListener(DeliveryStartedChannel.DELIVERY_STARTED_INPUT)
    public void proccess(DeliveryStartedEvent event) {

        try {
            Delivery delivery = new Delivery();

            delivery.setFrom((String) event.getFrom());
            delivery.setTo((String) event.getTo());
            delivery.setBagId((Long) event.getBagId());

            deliveryService.save(delivery);

            log.info("M=DeliveryStartedConsumer#proccess, received {}", event);
        }catch (Exception e) {
            log.error("M=DeliveryStartedConsumer#error, fail {}", e.getMessage());
        }
    }
}
