package com.lucasaquiles.subs.repository;

import com.lucasaquiles.subs.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}
