package com.hanghae.cinema;

import java.util.List;

public class ScreeningDto {

    private Long movieId;

    private int screenNumber;

    private ScreeningTime screeningTime;

    private int seatCount;

    public static List<Screening> toScreenings(List<ScreeningDto> screenings) {
        return screenings.stream()
                .map(screening -> new Screening(screening.getMovieId(), screening.getScreenNumber(), screening.getScreeningTime(), screening.getSeatCount()))
                .toList();
    }

    public ScreeningDto(Long movieId, int screenNumber, ScreeningTime screeningTime, int seatCount) {
        this.movieId = movieId;
        this.screenNumber = screenNumber;
        this.screeningTime = screeningTime;
        this.seatCount = seatCount;
    }

    public Long getMovieId() {
        return movieId;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public ScreeningTime getScreeningTime() {
        return screeningTime;
    }

    public int getSeatCount() {
        return seatCount;
    }
}
