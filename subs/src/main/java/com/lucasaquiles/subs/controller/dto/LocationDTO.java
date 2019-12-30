package com.lucasaquiles.subs.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
public class LocationDTO {

    private BigDecimal lon;
    private BigDecimal lat;
    private Long deliveryId;
    private String description;
}
