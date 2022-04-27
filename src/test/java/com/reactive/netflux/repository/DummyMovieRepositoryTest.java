package com.reactive.netflux.repository;

import com.reactive.netflux.domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

class DummyMovieRepositoryTest {

  private DummyMovieRepository dummyMovieRepository;

  @BeforeEach
  void setUp() {
    dummyMovieRepository = new DummyMovieRepository();
  }

  @Test
  void getMovieByIdBlocking() {
    Mono<Movie> monoMovie = dummyMovieRepository.getMovieById("asdf");

    // We should not block the mono, only test Purpose
    Movie movie = monoMovie.block();
    System.out.println(movie.toString());
  }

  @Test
  void getMovieByIdNonBlocking() {
    Mono<Movie> monoMovie = dummyMovieRepository.getMovieById("asdf");
    monoMovie.subscribe(movie -> System.out.println(movie.toString()));

    // Web client replaces RestTemplate
    // WebClient

  }

  @Test
  void getMovieByIdMap() {
    Mono<Movie> monoMovie = dummyMovieRepository.getMovieById("asdf");
    monoMovie.map(Movie::getName).subscribe(name -> System.out.println(name));

  }

  @Test
  void getMovieBlockFlux() {
    Flux<Movie> fluxMovies = dummyMovieRepository.getAllMovies();

    //Always avoid block
    Movie movie = fluxMovies.blockFirst();
    System.out.println(movie.getName());
  }


  @Test
  void getMovieNoBlockFlux() {
    Flux<Movie> fluxMovies = dummyMovieRepository.getAllMovies();

    fluxMovies.subscribe(System.out::println);
  }


  @Test
  void getMovieNoBlockFluxToMono() {
    Flux<Movie> fluxMovies = dummyMovieRepository.getAllMovies();
    Mono<List<Movie>> listMono = fluxMovies.collectList();
    listMono.subscribe(movies -> movies.forEach(System.out::println));
  }


}