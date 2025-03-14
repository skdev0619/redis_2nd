package com.hanghae.cinema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class ScreeningsCreatorTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreeningsCreator screeningsCreator;

    @DisplayName("존재하지 않는 영화를 상영에 추가하면 예외 발생한다")
    @Test
    void validateMovie() {
        Movie movie = createMovie(0L, LocalDate.of(2025, 3, 15));
        Screening screening = new Screening(
                movie.getId(),
                1,
                new ScreeningTime(
                        LocalDateTime.of(2025, 3, 16, 8, 0),
                        LocalDateTime.of(2025, 3, 16, 10, 0)
                ),
                25
        );

        assertThatThrownBy(() -> screeningsCreator.create(List.of(screening)))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("상영일이 영화 개봉일보다 이전이면 예외 발생한다")
    @Test
    void validateDate() {
        Movie movie = movieRepository.save(createMovie(LocalDate.of(2025, 3, 15)));
        Screening screening = new Screening(
                movie.getId(),
                1,
                new ScreeningTime(
                        LocalDateTime.of(2025, 3, 15, 8, 0),
                        LocalDateTime.of(2025, 3, 15, 10, 0)
                ),
                25
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> screeningsCreator.create(List.of(screening)));
    }

    private Movie createMovie(LocalDate releaseDate) {
        return createMovie(null, releaseDate);
    }

    private Movie createMovie(Long id, LocalDate releaseDate) {
        return new Movie(
                id,
                "unknown",
                MovieGrade.ALL,
                releaseDate,
                new UrlString("https://test.com/image.png"),
                new PositiveNumber(120),
                MovieGenre.ROMANCE
        );
    }
}
