package com.hanghae.movie.dto;

import com.hanghae.common.vo.PositiveNumber;
import com.hanghae.movie.Movie;
import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieGrade;
import com.hanghae.movie.UrlString;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovieCreateResponse {

    private Long id;

    private String title;

    private MovieGrade grade;

    private LocalDate releaseDate;

    private UrlString thumbnailUrl;

    private PositiveNumber runningTime;

    private MovieGenre genre;

    private LocalDateTime createdDate;

    private String createdBy;

    public static MovieCreateResponse from(Movie movie) {
        return new MovieCreateResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getGrade(),
                movie.getReleaseDate(),
                movie.getThumbnailUrl(),
                movie.getRunningTime(),
                movie.getGenre(),
                movie.getCreatedDate(),
                movie.getCreatedBy()
        );
    }

    public MovieCreateResponse(Long id, String title,MovieGrade grade,  LocalDate releaseDate, UrlString thumbnailUrl, PositiveNumber runningTime, MovieGenre genre, LocalDateTime createdDate, String createdBy) {
        this.id = id;
        this.title = title;
        this.grade = grade;
        this.releaseDate = releaseDate;
        this.thumbnailUrl = thumbnailUrl;
        this.runningTime = runningTime;
        this.genre = genre;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
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

    public UrlString getThumbnailUrl() {
        return thumbnailUrl;
    }

    public PositiveNumber getRunningTime() {
        return runningTime;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
