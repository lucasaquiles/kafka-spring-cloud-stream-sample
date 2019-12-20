package com.lucasaquiles.subs.channel;

import com.lucasaquiles.subs.controller.dto.LocationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationUpdatedConsumer {

    @Autowired
    private LocationUpdatedChannel channel;

    @StreamListener(Processor.INPUT)
    public void receive(final LocationDTO locationDTO) {

        log.info("M=LocationUpdated#receive, sent {}", locationDTO);
    }
}