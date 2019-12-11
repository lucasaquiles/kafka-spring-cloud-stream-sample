package com.lucasaquiles.publisher.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface LocationUpdatedChannel {

    String LOCATION_UPDATED_OUTPUT = "location-updated-output";

    @Output(LOCATION_UPDATED_OUTPUT)
    MessageChannel output();
}
