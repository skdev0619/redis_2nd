package com.hanghae.inmemory;

import com.hanghae.theater.Theater;
import com.hanghae.theater.TheaterRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTheaterRepository implements TheaterRepository {
    private Map<Long, Theater> theaters = new ConcurrentHashMap<>();

    @Override
    public Theater save(Theater theater) {
        theaters.put(theater.getId(), theater);
        return theater;
    }

    @Override
    public Optional<Theater> findById(Long theaterId) {
        return Optional.ofNullable(theaters.get(theaterId));
    }
}
