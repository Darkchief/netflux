package com.reactive.netflux.service;

import com.reactive.netflux.domain.Movie;
import com.reactive.netflux.repository.MovieRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MovieServiceImpl implements MovieService {

  private MovieRepository movieRepository;

  @Override
  public Mono<Movie> getMovieById(String id) {
    return movieRepository.findById(id);
  }

  @Override
  public Flux<Movie> getAllMovies() {
    return movieRepository.findAll();
  }
}
