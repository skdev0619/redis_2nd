package com.hanghae.movie;

import com.hanghae.movie.dto.MovieCreateRequest;
import com.hanghae.movie.dto.MovieCreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieCreateResponse save(MovieCreateRequest request) {
        Movie movie = MovieCreateRequest.toMovie(request);
        Movie savedMovie = movieRepository.save(movie);
        return MovieCreateResponse.from(savedMovie);
    }
}
