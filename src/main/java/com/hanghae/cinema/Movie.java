package com.hanghae.cinema;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGrade grade;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "url", column = @Column(name = "thumbnail_url"))
    )
    @Column(nullable = false)
    private UrlString thumbnailUrl;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "running_time"))
    )
    @Column(nullable = false)
    private PositiveNumber runningTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    protected Movie() {
    }

    public Movie(String title, MovieGrade grade, LocalDate releaseDate, String thumbnailUrl, int runningTime, MovieGenre genre) {
        this(null, title, grade, releaseDate, new UrlString(thumbnailUrl), new PositiveNumber(runningTime), genre);
    }

    public Movie(String title, MovieGrade grade, LocalDate releaseDate, UrlString thumbnailUrl, PositiveNumber runningTime, MovieGenre genre) {
        this(null, title, grade, releaseDate, thumbnailUrl, runningTime, genre);
    }

    public Movie(Long id, String title, MovieGrade grade, LocalDate releaseDate, UrlString thumbnailUrl, PositiveNumber runningTime, MovieGenre genre) {
        this.id = id;
        this.title = Objects.requireNonNull(title, "영화제목을 입력하세요");
        this.grade = Objects.requireNonNull(grade, "영상물등급을 입력하세요");
        this.releaseDate = Objects.requireNonNull(releaseDate, "개봉일을 입력하세요");
        this.thumbnailUrl = Objects.requireNonNull(thumbnailUrl, "섬네일 이미지 url을 입력하세요");
        this.runningTime = Objects.requireNonNull(runningTime, "러닝 타임을 입력하세요");
        this.genre = Objects.requireNonNull(genre, "영화 장르를 입력하세요");
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
}
