package com.lucasaquiles.publisher.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class LocationDTO {

    private BigDecimal lon;
    private BigDecimal lat;
    private String description;
    private String bagId;
}
