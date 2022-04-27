package com.reactive.netflux.service;

import com.reactive.netflux.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
  Mono<Movie> getMovieById(String id);
  Flux<Movie> getAllMovies();
}
