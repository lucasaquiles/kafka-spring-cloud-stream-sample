package com.lucasaquiles.publisher.channel;

import com.lucasaquiles.publisher.controller.dto.LocationDTO;
import com.lucasaquiles.stream.LocationUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationUpdatedProducer {

    @Autowired
    private LocationUpdatedChannel channel;

    @SendTo(Processor.OUTPUT)
    public void send(final LocationDTO locationDTO) {

        LocationUpdatedEvent builder = LocationUpdatedEvent.newBuilder()
                .setLat(locationDTO.getLat()
                        .doubleValue()).setLon(locationDTO.getLon().doubleValue())
                .setDescription(locationDTO.getDescription()).build();

        Message<LocationUpdatedEvent> build = MessageBuilder
                .withPayload(builder)
                .build();

        channel.output()
                .send(build);

        log.info("M=LocationUpdated#send, sent {}", builder);
    }
}
