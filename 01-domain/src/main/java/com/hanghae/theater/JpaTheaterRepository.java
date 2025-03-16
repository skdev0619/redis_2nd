package com.hanghae.theater;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTheaterRepository extends TheaterRepository, JpaRepository<Theater, Long> {
}
