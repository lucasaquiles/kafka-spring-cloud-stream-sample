package com.lucasaquiles.subs.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Location {

    @Id
    private String id;

    private BigDecimal lat;
    private BigDecimal lon;
    private String description;

    private Long deliveryBy;
}
