package com.hanghae.cinema;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class PositiveNumber {
    private int value;

    protected PositiveNumber() {
    }

    public PositiveNumber(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
