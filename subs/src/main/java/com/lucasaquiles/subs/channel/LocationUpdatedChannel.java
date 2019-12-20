package com.lucasaquiles.subs.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface LocationUpdatedChannel {

    String LOCATION_UPDATED_INPUT = "location-updated-input";

    @Output(LOCATION_UPDATED_INPUT)
    MessageChannel input();
}
