package com.hanghae.cinema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class ScreeningTest {

    @DisplayName("상영은 좌석 수가 음수면 예외 발생한다")
    @ValueSource(ints = {-1})
    @ParameterizedTest
    void create(int seatCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new Screening(
                                1L,
                                1,
                                new ScreeningTime(
                                        LocalDateTime.of(2025, 3, 14, 8, 0),
                                        LocalDateTime.of(2025, 3, 14, 10, 0)
                                ),
                                seatCount
                        ));
    }

    @DisplayName("좌석의 수를 감소한다")
    @Test
    void decreaseSeatCount() {
        Screening screening = new Screening(
                1L,
                1,
                new ScreeningTime(
                        LocalDateTime.of(2025, 3, 14, 8, 0),
                        LocalDateTime.of(2025, 3, 14, 10, 0)
                ),
                25
        );

        screening.decreaseSeatCount();

        assertThat(screening.getSeatCount()).isEqualTo(24);
    }

    @DisplayName("좌석의 수가 0개일 때, 좌석의 수를 감소하면 예외 발생한다")
    @Test
    void decreaseSeatCountByNegativeCount() {
        Screening screening = new Screening(
                1L,
                1,
                new ScreeningTime(
                        LocalDateTime.of(2025, 3, 14, 8, 0),
                        LocalDateTime.of(2025, 3, 14, 10, 0)
                ),
                0
        );

        assertThatIllegalStateException()
                .isThrownBy(screening::decreaseSeatCount);
    }
}
