package com.lucasaquiles.publisher.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface DeliveryStartedChannel {

    String DELIVERY_STARTED_OUTPUT = "delivery-started-output";

    @Output(DELIVERY_STARTED_OUTPUT)
    MessageChannel output();
}
