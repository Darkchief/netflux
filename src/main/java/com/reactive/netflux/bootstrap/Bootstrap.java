package com.reactive.netflux.bootstrap;

import com.reactive.netflux.domain.Movie;
import com.reactive.netflux.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

  private MovieRepository movieRepository;

  @Override
  public void run(String... args) throws Exception {
    movieRepository.deleteAll().thenMany(
            Flux.just("Back to the future", "Terminator", "The Lord of the Rings")
                    .map(title -> {return new Movie("1", title)}).flatMap(MovieRepository::save));
    )
  }
}
