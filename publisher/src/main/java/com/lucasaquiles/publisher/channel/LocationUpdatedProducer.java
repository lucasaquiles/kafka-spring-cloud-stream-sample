package com.lucasaquiles.publisher.channel;

import com.lucasaquiles.publisher.controller.dto.LocationDTO;
import com.lucasaquiles.stream.LocationUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationUpdatedProducer {

    @Autowired
    private LocationUpdatedChannel channel;

    @SendTo(Processor.OUTPUT)
    public void send(final LocationDTO locationDTO) {

        LocationUpdatedEvent.Builder builder = LocationUpdatedEvent.newBuilder()
                .setLat(locationDTO.getLat()
                        .longValue()).setLon(locationDTO.getLon().longValue())
                .setDescription(locationDTO.getDescription());

        channel.output()
                .send(MessageBuilder
                    .withPayload(builder)
                    .build());

        log.info("M=LocationUpdated#send, sent {}", builder);
    }
}
