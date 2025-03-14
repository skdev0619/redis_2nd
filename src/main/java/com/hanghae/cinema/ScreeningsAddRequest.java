package com.hanghae.cinema;

import java.util.List;

public class ScreeningsAddRequest {
    private Long theaterId;

    private List<ScreeningDto> screenings;

    public static List<Screening> toScreenings(ScreeningsAddRequest request) {
        return request.getScreenings().stream()
                .map(item -> new Screening(item.getMovieId(), item.getScreenNumber(), item.getScreeningTime(), item.getSeatCount()))
                .toList();
    }

    public ScreeningsAddRequest(Long theaterId, List<ScreeningDto> screenings) {
        this.theaterId = theaterId;
        this.screenings = screenings;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public List<ScreeningDto> getScreenings() {
        return screenings;
    }
}
