package com.hanghae.cinema;

import java.util.List;

public class ScreeningsAddResponse {

    private Long theaterId;

    private String name;

    private List<Screening> screenings;

    public static ScreeningsAddResponse from(Theater theater){
        return new ScreeningsAddResponse(
                theater.getId(),
                theater.getName(),
                theater.getScreenings()
        );
    }

    public ScreeningsAddResponse(Long theaterId, String name, List<Screening> screenings) {
        this.theaterId = theaterId;
        this.name = name;
        this.screenings = screenings;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public String getName() {
        return name;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }
}
