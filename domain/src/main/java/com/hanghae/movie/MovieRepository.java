package com.hanghae.movie;

import java.util.Optional;

public interface MovieRepository {

    Movie save(Movie movie);

    Optional<Movie> findById(Long id);
}