package com.lucasaquiles.publisher.channel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasaquiles.publisher.controller.dto.LocationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationUpdatedProducer {

    @Autowired
    private LocationUpdatedChannel channel;

    @SendTo(Processor.OUTPUT)
    public void send(final LocationDTO locationDTO) {

        Message<byte[]> builder = null;
        try {
            builder = MessageBuilder
                    .withPayload(new ObjectMapper().writeValueAsBytes(locationDTO))
                    .build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        channel.output()
                .send(builder);

        log.info("M=LocationUpdated#send, sent {}", builder);
    }
}
