package com.lucasaquiles.subs.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface DeliveryStartedChannel {

    String DELIVERY_STARTED_INPUT = "delivery-started-input";

    @Input(DELIVERY_STARTED_INPUT)
    SubscribableChannel input();
}

