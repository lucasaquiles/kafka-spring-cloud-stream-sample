package com.lucasaquiles.publisher.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String description;

    private Long bagId;
    private BigDecimal lat;
    private BigDecimal lon;
}
