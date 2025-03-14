package com.hanghae.cinema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositiveNumberTest {

    @DisplayName("양수가 아닌 수를 입력하면 예외 발생한다")
    @ValueSource(ints = {-1, 0})
    @ParameterizedTest
    void create(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PositiveNumber(value));
    }
}
