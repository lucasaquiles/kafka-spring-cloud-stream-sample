package com.lucasaquiles.subs.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface LocationUpdatedChannel {

    String LOCATION_UPDATED_INPUT = "location-updated-input";

    @Input(LOCATION_UPDATED_INPUT)
    SubscribableChannel input();
}
