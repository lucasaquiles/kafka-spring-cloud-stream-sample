package com.lucasaquiles.publisher.conf;

import com.lucasaquiles.publisher.channel.LocationUpdatedChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding (
        LocationUpdatedChannel.class
)
public class StreamConfig {
}
