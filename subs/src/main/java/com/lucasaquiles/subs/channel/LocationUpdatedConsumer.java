package com.lucasaquiles.subs.channel;

import com.lucasaquiles.stream.LocationUpdatedEvent;
import com.lucasaquiles.subs.controller.dto.LocationDTO;
import com.lucasaquiles.subs.controller.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Conversion;
import org.apache.avro.Conversions;
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
        try {

            Conversion<BigDecimal> conversion = new Conversions.DecimalConversion();


            log.info("M=LocationUpdated#proccess, received {}", event);
            locationService.addLocation(
                  LocationDTO.builder()
                          .bagId(((Integer) event.getBagId()).longValue())
                          .lat(BigDecimal.valueOf(((Double) event.getLat()).doubleValue()))
                          .lon(BigDecimal.valueOf(((Double) event.getLon()).doubleValue()))
                          .build()
            );
        }catch (Exception e) {
            log.error("M=LocationUpdated#error, fail {}", e.getMessage());
            e.printStackTrace();
        }
    }
}