package com.hanghae.cinema;


import java.time.LocalDateTime;
import java.util.List;

public class TheaterCreateResponse {
    private Long id;

    private String name;

    private List<Screening> screenings;

    private LocalDateTime createdDate;

    private String createdBy;

    public static TheaterCreateResponse from(Theater theater) {
        return new TheaterCreateResponse(
                theater.getId(),
                theater.getName(),
                theater.getScreenings(),
                theater.getCreatedDate(),
                theater.getCreatedBy()
        );
    }

    public TheaterCreateResponse(Long id, String name, List<Screening> screenings, LocalDateTime createdDate, String createdBy) {
        this.id = id;
        this.name = name;
        this.screenings = screenings;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
