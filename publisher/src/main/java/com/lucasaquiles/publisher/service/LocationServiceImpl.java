package com.lucasaquiles.publisher.service;

import com.lucasaquiles.publisher.channel.LocationUpdatedProducer;
import com.lucasaquiles.publisher.controller.dto.LocationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationUpdatedProducer locationUpdatedProducer;

    @Override
    public void addLocation(LocationDTO locationDTO) {

        locationUpdatedProducer.send(locationDTO);
    }
}
