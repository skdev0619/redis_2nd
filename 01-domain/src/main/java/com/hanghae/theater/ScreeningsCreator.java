package com.hanghae.theater;

import com.hanghae.movie.Movie;
import com.hanghae.movie.MovieRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 상영관에 상영 추가 시,
 * 상영할 영화를 검증 후, 상영 리스트를 반환하는 도메인 서비스
 * 1) 영화는 영화 db에 존재해야 한다
 * 2) 상영일은 영화의 개봉일보다 이전이면 안된다
 */
@Component
public class ScreeningsCreator {

    private final MovieRepository movieRepository;

    public ScreeningsCreator(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Screening> create(List<Screening> screenings) {
        validateScreenings(screenings);
        return screenings;
    }

    private void validateScreenings(List<Screening> screenings) {
        for (Screening screening : screenings) {
            validateScreening(screening);
        }
    }

    private void validateScreening(Screening screening) {
        LocalDate releaseDate = getMovieReleaseDate(screening);
        ScreeningTime screeningTime = screening.getScreeningTime();
        if (screeningTime.isBefore(releaseDate)) {
            throw new IllegalArgumentException("상영 시간은 영화 개봉일 이후여야 합니다");
        }
    }

    private LocalDate getMovieReleaseDate(Screening screening) {
        Movie movie = movieRepository.findById(screening.getMovieId())
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 영화입니다"));
        return movie.getReleaseDate();
    }
}
