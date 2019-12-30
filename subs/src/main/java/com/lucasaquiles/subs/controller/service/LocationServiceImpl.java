package com.lucasaquiles.subs.controller.service;

import com.lucasaquiles.subs.controller.dto.LocationDTO;
import com.lucasaquiles.subs.model.Delivery;
import com.lucasaquiles.subs.model.Location;
import com.lucasaquiles.subs.repository.DeliveryRepository;
import com.lucasaquiles.subs.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addLocation(LocationDTO locationDTO) {

        Delivery delivery = deliveryRepository.findByBagId(locationDTO.getBagId())
                .orElseThrow(() -> new RuntimeException("Delivery was not started"));

        Location location = new Location();

        location.setDescription(locationDTO.getDescription());
        location.setLat(locationDTO.getLat());
        location.setLon(locationDTO.getLon());
        location.setDeliveryBy(locationDTO.getBagId());

        locationRepository.save(location);

        delivery.addLocation(location);

        log.info("M=addLocation, saving -> {}", locationDTO);
        deliveryRepository.save(delivery);
    }
}
