package com.hanghae.movie.dto;

import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieGrade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovieScreeningDto {
    private String name;
    private String title;
    private MovieGrade grade;
    private LocalDate releaseDate;
    private String thumbnailUrl;
    private int runningTime;
    private MovieGenre genre;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public MovieScreeningDto(String name, String title, MovieGrade grade, LocalDate releaseDate, String thumbnailUrl, int runningTime, MovieGenre genre, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.title = title;
        this.grade = grade;
        this.releaseDate = releaseDate;
        this.thumbnailUrl = thumbnailUrl;
        this.runningTime = runningTime;
        this.genre = genre;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
