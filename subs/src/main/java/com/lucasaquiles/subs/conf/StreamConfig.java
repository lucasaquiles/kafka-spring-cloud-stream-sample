package com.lucasaquiles.subs.conf;

import com.lucasaquiles.subs.channel.LocationUpdatedChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding (
        LocationUpdatedChannel.class
)
public class StreamConfig {
}
