package com.lucasaquiles.subs.integration;

import com.lucasaquiles.stream.DeliveryStartedEvent;
import com.lucasaquiles.subs.channel.DeliveryStartedChannel;
import com.lucasaquiles.subs.model.Delivery;
import com.lucasaquiles.subs.repository.DeliveryRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureDataMongo
public class DeliveryStartedIntegrationTest{

    private final DeliveryStartedChannel deliveryStartedChannel;

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryStartedIntegrationTest(DeliveryStartedChannel deliveryStartedChannel, DeliveryRepository deliveryRepository) {
        this.deliveryStartedChannel = deliveryStartedChannel;
        this.deliveryRepository = deliveryRepository;
    }

    @Test
    void testDeliveryStarted() {

        DeliveryStartedEvent message = DeliveryStartedEvent.newBuilder()
                .setBagId(2L)
                .setFrom("budega")
                .setTo("client@email.com")
                .build();

        deliveryStartedChannel
                .input()
                .send(withPayload(message)
                        .build());

        Optional<Delivery> byBagId = deliveryRepository.findByBagId(2L);

        Assert.assertThat(byBagId.isPresent(), Matchers.is(true));
    }
}
