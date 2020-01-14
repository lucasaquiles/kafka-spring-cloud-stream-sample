package com.lucasaquiles.subs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    private BigDecimal lon;
    private BigDecimal lat;
    private String bagId;
    private String description;
}
