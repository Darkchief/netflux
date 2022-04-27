package com.reactive.netflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Always use reactive classes
 */
public interface MovieRepository extends ReactiveMongoRepository {
}
