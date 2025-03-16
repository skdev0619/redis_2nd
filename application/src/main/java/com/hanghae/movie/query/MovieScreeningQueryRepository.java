package com.hanghae.movie.query;

import com.hanghae.movie.dto.MovieScreeningDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieScreeningQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<MovieScreeningDto> findShowingMovies() {
        return em.createQuery(
                        "SELECT new com.hanghae.movie.dto.MovieScreeningDto( " +
                                "t.name, " +
                                "m.title, m.grade, m.releaseDate, m.thumbnailUrl.url, m.runningTime.value, m.genre, " +
                                "s.screeningTime.startTime, s.screeningTime.endTime" +
                                ") " +
                                "FROM Theater t " +
                                "JOIN t.screenings s " +
                                "JOIN Movie m on m.id = s.movieId " +
                                "ORDER BY m.releaseDate ASC, m.id ASC, s.screeningTime.startTime ASC",
                        MovieScreeningDto.class)
                .getResultList();
    }
}
