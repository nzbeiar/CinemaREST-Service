package com.cinema.cinemaRoom.cinema;

import com.cinema.cinemaRoom.seat.Seat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;



public class Cinema {

    private int totalRows;
    private int totalColumns;
    ArrayList<Seat> availableSeats = new ArrayList<>();

    private int numberOfSeats;

    private int currentIncome = 0;

    private int numberOfPurchasedTickets = 0;


    public Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                this.availableSeats.add(new Seat(i, j));
            }
        }
        this.numberOfSeats = totalRows * totalColumns;

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

    @JsonIgnore
    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    @JsonIgnore
    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    @JsonIgnore
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}

