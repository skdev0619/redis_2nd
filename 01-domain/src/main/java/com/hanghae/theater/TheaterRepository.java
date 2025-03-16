package com.hanghae.theater;

import java.util.Optional;

public interface TheaterRepository {
    Theater save(Theater theater);
    Optional<Theater> findById(Long id);
}
