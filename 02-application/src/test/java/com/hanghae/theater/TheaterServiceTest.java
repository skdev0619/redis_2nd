package com.hanghae.theater;

import com.hanghae.common.vo.PositiveNumber;
import com.hanghae.movie.Movie;
import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieGrade;
import com.hanghae.movie.MovieRepository;
import com.hanghae.theater.dto.ScreeningDto;
import com.hanghae.theater.dto.ScreeningsAddRequest;
import com.hanghae.theater.dto.ScreeningsAddResponse;
import com.hanghae.theater.dto.TheaterCreateResponse;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class TheaterServiceTest {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterService theaterService;

    @DisplayName("상영관 이름을 입력하여 상영관을 생성한다")
    @Test
    void create() {
        TheaterCreateResponse response = theaterService.save("상영관1");

        assertAll(
                () -> assertThat(response.getId()).isNotNull(),
                () -> assertThat(response.getName()).isEqualTo("상영관1")
        );
    }

    @DisplayName("상영시간표를 등록한다")
    @Test
    void addScreenings() {
        //given
        Movie movie = movieRepository.save(createMovie(LocalDate.of(2025, 3, 15)));
        Theater theater = theaterRepository.save(createTheater());
        ScreeningTime screeningTime = new ScreeningTime(
                LocalDateTime.of(2025, 3, 17, 8, 0),
                LocalDateTime.of(2025, 3, 17, 10, 0)
        );

        ScreeningsAddRequest request = new ScreeningsAddRequest(
                theater.getId(),
                List.of(
                        new ScreeningDto(movie.getId(), 1, screeningTime, 25)
                )
        );
        //when
        ScreeningsAddResponse response = theaterService.addScreenings(request);
        //then
        assertThat(response.getTheaterId()).isEqualTo(theater.getId());
        assertThat(response.getScreenings())
                .extracting(
                        Screening::getScreenNumber,
                        Screening::getScreeningTime,
                        Screening::getSeatCount
                )
                .containsExactlyInAnyOrder(
                        new Tuple(new PositiveNumber(1), screeningTime, 25)
                );
    }

    private Theater createTheater() {
        return new Theater("unknown");
    }

    private Movie createMovie(LocalDate releaseDate) {
        return new Movie(
                "unknown",
                MovieGrade.ALL,
                releaseDate,
                "https://test.com/image.png",
                120,
                MovieGenre.ROMANCE
        );
    }
}
