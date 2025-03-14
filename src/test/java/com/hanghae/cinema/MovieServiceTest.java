package com.hanghae.cinema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Transactional
@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @DisplayName("영화를 등록한다")
    @Test
    void create() {
        MovieCreateRequest request = new MovieCreateRequest(
                "범죄도시5",
                MovieGrade.TEEN_15,
                LocalDate.of(2025, 3, 14),
                "https://test.com/image.png",
                120,
                MovieGenre.ACTION
        );

        MovieCreateResponse response = movieService.save(request);

        assertAll(
                () -> assertThat(response.getId()).isNotNull(),
                () -> assertThat(response.getTitle()).isEqualTo("범죄도시5"),
                () -> assertThat(response.getGrade()).isEqualTo(MovieGrade.TEEN_15),
                () -> assertThat(response.getReleaseDate()).isEqualTo(LocalDate.of(2025, 3, 14)),
                () -> assertThat(response.getThumbnailUrl()).isEqualTo(new UrlString("https://test.com/image.png")),
                () -> assertThat(response.getRunningTime()).isEqualTo(new PositiveNumber(120)),
                () -> assertThat(response.getGenre()).isEqualTo(MovieGenre.ACTION)
        );
    }
}
