package com.hanghae.movie;

import com.hanghae.movie.dto.MovieScreeningDto;
import com.hanghae.movie.query.MovieScreeningQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieScreeningQueryRestController {
    private final MovieScreeningQueryService movieScreeningQueryService;

    public MovieScreeningQueryRestController(MovieScreeningQueryService movieScreeningQueryService) {
        this.movieScreeningQueryService = movieScreeningQueryService;
    }

    @GetMapping("/now-showing")
    public List<MovieScreeningDto> findShowingMovies() {
        return movieScreeningQueryService.findShowingMovies();
    }
}