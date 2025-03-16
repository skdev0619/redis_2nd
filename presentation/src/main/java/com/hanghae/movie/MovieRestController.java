package com.hanghae.movie;

import com.hanghae.movie.dto.MovieCreateRequest;
import com.hanghae.movie.dto.MovieCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/create")
    public ResponseEntity<MovieCreateResponse> create(@RequestBody MovieCreateRequest request) {
        MovieCreateResponse response = movieService.save(request);
        return ResponseEntity.created(URI.create("/api/movies/" + response.getId()))
                .body(response);
    }
}