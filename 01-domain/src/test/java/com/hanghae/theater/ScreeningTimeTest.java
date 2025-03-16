package com.hanghae.theater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class ScreeningTimeTest {

    @DisplayName("상영 시작/종료 시간은 둘 다 입력하지 않으면 예외 발생한다")
    @NullSource
    @ParameterizedTest
    void notNull(LocalDateTime dateTime) {
        assertThatNullPointerException()
                .isThrownBy(() -> new ScreeningTime(dateTime, LocalDateTime.now()));

        assertThatNullPointerException()
                .isThrownBy(() -> new ScreeningTime(LocalDateTime.now(), dateTime));
    }

    @DisplayName("상영 시작 시간이 상영 종료 시간보다 이후라면 예외 발생한다")
    @Test
    void validateDate() {
        LocalDateTime startTime = LocalDateTime.of(2025, 3, 15, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 3, 15, 8, 0);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ScreeningTime(startTime, endTime));
    }

    @DisplayName("상영일이 특정 일자보다 이전인지 확인한다")
    @Test
    void isBefore() {
        //given
        LocalDateTime startTime = LocalDateTime.of(2025, 3, 15, 8, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 3, 15, 10, 0);

        ScreeningTime screeningTime = new ScreeningTime(startTime, endTime);
        //when
        LocalDate targetDate = LocalDate.of(2025, 3, 16);
        boolean result = screeningTime.isBefore(targetDate);
        //then
        assertThat(result).isTrue();
    }
}
