package com.lucasaquiles.publisher.channel;

import com.lucasaquiles.publisher.controller.dto.DeliveryDTO;
import com.lucasaquiles.stream.DeliveryStartedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeliveryStartedProducer {

    @Autowired
    DeliveryStartedChannel deliveryStartedChannel;

    @SendTo(Processor.OUTPUT)
    public void send(final DeliveryDTO deliveryDTO) {

        DeliveryStartedEvent builder = DeliveryStartedEvent.newBuilder()
                .setBagId(deliveryDTO.getBagId())
                .setFrom(deliveryDTO.getFrom())
                .setTo(deliveryDTO.getTo())
                .build();

        Message<DeliveryStartedEvent> build = MessageBuilder
                .withPayload(builder)
                .build();

        deliveryStartedChannel.output()
                .send(build);

        log.info("M=LocationUpdated#send, sent {}", build);
    }
}
