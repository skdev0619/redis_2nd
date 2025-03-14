package com.hanghae.cinema;

public class Seat {

    private final SeatCol col;
    private final SeatRow row;

    public Seat(int row, int col) {
        this(new SeatRow(row), new SeatCol(col));
    }

    public Seat(SeatRow row, SeatCol col) {
        this.row = row;
        this.col = col;
    }
}
