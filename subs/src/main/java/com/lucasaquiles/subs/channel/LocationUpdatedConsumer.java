package com.lucasaquiles.subs.channel;

import com.lucasaquiles.stream.LocationUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationUpdatedConsumer {

    @StreamListener(LocationUpdatedChannel.LOCATION_UPDATED_INPUT)
    public void proccess(LocationUpdatedEvent event) {

        log.info("M=LocationUpdated#proccess, received {}", event);
    }
}