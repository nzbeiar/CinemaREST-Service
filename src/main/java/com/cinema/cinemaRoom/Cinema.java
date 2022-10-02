package com.cinema.cinemaRoom;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;



public class Cinema {

    private int totalRows;
    private int totalColumns;
    public ArrayList<Seat> availableSeats = new ArrayList<>();


    public Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                if (i <= 4) {
                    this.availableSeats.add(new Seat(i, j, 10));
                } else {
                    this.availableSeats.add(new Seat(i, j, 8));
                }
            }
        }

    }

    public Cinema(){}

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
        return availableSeats;
    }

    public void setSeats(ArrayList<Seat> availableSeats) {
        this.availableSeats= availableSeats;
    }
}
