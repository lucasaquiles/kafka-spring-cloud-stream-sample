package com.lucasaquiles.subs.controller.service;

import com.lucasaquiles.subs.channel.LocationUpdatedConsumer;
import com.lucasaquiles.subs.controller.dto.LocationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationUpdatedConsumer locationUpdatedProducer;


    @Override
    public void addLocation(LocationDTO locationDTO) {

    }
}
