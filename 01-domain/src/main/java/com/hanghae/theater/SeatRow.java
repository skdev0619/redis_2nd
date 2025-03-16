package com.hanghae.theater;

public class SeatRow {

    private static final int ROW_SIZE = 5;
    private static final char START_ROW = 'A';

    private final char row;

    public SeatRow(final int row){
        this(toChar(row));
    }

    private static char toChar(int row) {
        return (char) (START_ROW + row - 1);
    }

    public SeatRow(final char row) {
        validate(row);
        this.row = row;
    }

    private void validate(char row) {
        char endRow = toChar(ROW_SIZE);
        if(START_ROW > row || row > endRow){
            throw new IllegalArgumentException("");
        }
    }

    public char getRow() {
        return row;
    }
}
