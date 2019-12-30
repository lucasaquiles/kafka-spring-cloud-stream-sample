package com.lucasaquiles.subs.channel;

import com.lucasaquiles.stream.LocationUpdatedEvent;
import com.lucasaquiles.subs.controller.dto.LocationDTO;
import com.lucasaquiles.subs.controller.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class LocationUpdatedConsumer {

    @Autowired
    private LocationService locationService;

    @StreamListener(LocationUpdatedChannel.LOCATION_UPDATED_INPUT)
    public void proccess(LocationUpdatedEvent event) {

        locationService.addLocation(
                LocationDTO.builder()
                        .deliveryId((Long) event.getDeliveryId())
                        .lat((BigDecimal) event.getDeliveryId())
                        .lat((BigDecimal) event.getLat())
                        .build()
        );

        log.info("M=LocationUpdated#proccess, received {}", event);
    }
}