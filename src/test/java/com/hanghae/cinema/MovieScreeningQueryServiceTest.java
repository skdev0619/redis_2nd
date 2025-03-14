package com.hanghae.cinema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieScreeningQueryServiceTest {

    @Autowired
    private MovieScreeningQueryService movieScreeningQueryService;

    @DisplayName("상영 중인 영화를 조회한다")
    @Test
    void findShowingMovies() {
        List<MovieScreeningDto> datas = movieScreeningQueryService.findShowingMovies();
    }
}
