package com.cinema.cinemaRoom.cinema;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Statistics {

    Cinema cinema;


    private int currentIncome = 0;

    private int numberOfSeats = 0;

    private int numberOfPurchasedTickets = 0;


    public Statistics(Cinema cinema) {
        this.numberOfSeats = cinema.getNumberOfSeats();
        this.currentIncome = cinema.getCurrentIncome();
        this.numberOfPurchasedTickets = cinema.getNumberOfPurchasedTickets();
    }

    @JsonGetter(value = "current_income")
    public int getCurrentIncome() {
        return currentIncome;
    }

    @JsonGetter(value = "number_of_available_seats")
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @JsonGetter(value = "number_of_purchased_tickets")
    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }
}

