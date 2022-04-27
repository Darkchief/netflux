package com.reactive.netflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Always use reactive classes
 */
@Repository
public interface MovieRepository extends ReactiveMongoRepository {
}
