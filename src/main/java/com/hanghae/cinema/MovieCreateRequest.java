package com.hanghae.cinema;

import java.time.LocalDate;

public class MovieCreateRequest {
    private String title;

    private MovieGrade grade;

    private LocalDate releaseDate;

    private String thumbnailUrl;

    private int runningTime;

    private MovieGenre genre;

    public MovieCreateRequest(String title, MovieGrade grade, LocalDate releaseDate, String thumbnailUrl, int runningTime, MovieGenre genre) {
        this.title = title;
        this.grade = grade;
        this.releaseDate = releaseDate;
        this.thumbnailUrl = thumbnailUrl;
        this.runningTime = runningTime;
        this.genre = genre;
    }

    public static Movie toMovie(MovieCreateRequest request) {
        return new Movie(
                request.getTitle(),
                request.getGrade(),
                request.getReleaseDate(),
                request.getThumbnailUrl(),
                request.getRunningTime(),
                request.getGenre()
        );
    }

    public String getTitle() {
        return title;
    }

    public MovieGrade getGrade() {
        return grade;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public MovieGenre getGenre() {
        return genre;
    }
}
