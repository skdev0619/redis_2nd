package com.hanghae.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends MovieRepository, JpaRepository<Movie, Long> {
}
