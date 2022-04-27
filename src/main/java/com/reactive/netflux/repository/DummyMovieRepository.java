package com.reactive.netflux.repository;

import com.reactive.netflux.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DummyMovieRepository {


  Mono<Movie> getMovieById(String id) {
    return null;
  }

  Flux<Movie> getAllMovies() {
    return null;
  }
}
