package com.lucasaquiles.subs.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Delivery {

    private String id;
    private Long bagId;
    private String from;
    private String to;

    @DBRef
    private List<Location> locations;


    public void addLocation(Location location) {

        if(locations == null) {

            this.locations = new ArrayList<>();
        }

        locations.add(location);
    }
}
