package com.hanghae.inmemory;

import com.hanghae.movie.Movie;
import com.hanghae.movie.MovieRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMovieRepository implements MovieRepository {

    private Map<Long, Movie> movies = new ConcurrentHashMap<Long, Movie>();

    @Override
    public Movie save(Movie movie) {
        movies.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return Optional.ofNullable(movies.get(id));
    }
}
