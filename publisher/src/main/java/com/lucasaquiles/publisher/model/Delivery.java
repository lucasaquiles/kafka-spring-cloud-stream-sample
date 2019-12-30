package com.lucasaquiles.publisher.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    private String deliveryId;
    private String from;
    private String to;
    private String description;
}
