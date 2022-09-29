package com.cinema.cinemaRoom;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;



public class Cinema {
    private int totalRows;
    private int totalColumns;
    private ArrayList<Seat> seats;


    public Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.seats = new ArrayList<>();
    }

    public Cinema() {

    }
    @JsonGetter(value = "total_rows")
    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    @JsonGetter(value = "total_columns")
    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    @JsonGetter(value = "available_seats")
    public ArrayList<Seat> getSeats() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                seats.add(new Seat(i,j));
            }
        }
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
