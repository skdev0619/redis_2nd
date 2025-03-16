package com.hanghae.theater;

import com.hanghae.common.entity.BaseEntity;
import com.hanghae.common.vo.PositiveNumber;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Screening extends BaseEntity {
    /*
    현재 요구사항에서는 좌석이 5*5 고정이라서 static final 로 선언
    좌석의 수 유동적으로 생성한다면 Theater 에서 좌석 생성하도록 변경 예정
    */
    private static final int SEAT_ROW_SIZE = 5;
    private static final int SEAT_COL_SIZE = 5;
    private static final Seats seats = Seats.create(SEAT_ROW_SIZE, SEAT_COL_SIZE);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private Long movieId;

    @Column(nullable = false)
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "screen_number"))
    )
    private PositiveNumber screenNumber;

    @Embedded
    private ScreeningTime screeningTime;

    @Column(nullable = false)
    private int seatCount;

    protected Screening() {
    }

    public Screening(Long movieId, int screenNumber, ScreeningTime screeningTime, int seatCount) {
        this(null, movieId, new PositiveNumber(screenNumber), screeningTime, seatCount);
    }

    public Screening(Long id, Long movieId, PositiveNumber screenNumber, ScreeningTime screeningTime, int seatCount) {
        this.id = id;
        this.movieId = Objects.requireNonNull(movieId, "상영할 영화를 입력하세요");
        this.screenNumber = Objects.requireNonNull(screenNumber, "상영 회차를 입력하세요");
        this.screeningTime = screeningTime;
        this.seatCount = seatCount;
        validate();
    }

    private void validate() {
        if (this.seatCount > SEAT_ROW_SIZE * SEAT_COL_SIZE) {
            throw new IllegalArgumentException("정해진 좌석 수를 초과했습니다");
        }

        if (this.seatCount < 0) {
            throw new IllegalArgumentException("좌석 수는 음수일 수 없습니다");
        }
    }

    public void decreaseSeatCount() {
        if (seatCount == 0) {
            throw new IllegalStateException("남아있는 좌석의 수가 없습니다");
        }
        seatCount--;
    }

    public Long getId() {
        return id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public PositiveNumber getScreenNumber() {
        return screenNumber;
    }

    public ScreeningTime getScreeningTime() {
        return screeningTime;
    }

    public int getSeatCount() {
        return seatCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return Objects.equals(id, screening.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
