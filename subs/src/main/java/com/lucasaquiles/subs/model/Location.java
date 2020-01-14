package com.lucasaquiles.subs.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Location {

    @Id
    private String id;

    private BigDecimal lat;
    private BigDecimal lon;
    private String description;

    private String deliveryBy;
}
