package com.lucasaquiles.subs.controller.service;

import com.lucasaquiles.subs.model.Location;
import com.lucasaquiles.subs.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addLocation(Location location) {

        log.info("M=addLocation, saving -> {}", location);
        locationRepository.save(location);
    }
}
