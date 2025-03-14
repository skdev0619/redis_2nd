package com.hanghae.cinema;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    Movie save(Movie movie);

    Optional<Movie> findById(Long id);

    List<Movie> findAllByIdIn(List<Long> ids);
}
