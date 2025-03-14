package com.hanghae.cinema;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MovieScreeningQueryService {

    private final MovieScreeningQueryRepository movieScreeningQueryRepository;

    public MovieScreeningQueryService(MovieScreeningQueryRepository movieScreeningQueryRepository) {
        this.movieScreeningQueryRepository = movieScreeningQueryRepository;
    }

    public List<MovieScreeningDto> findShowingMovies() {
        return movieScreeningQueryRepository.findShowingMovies();
    }
}
