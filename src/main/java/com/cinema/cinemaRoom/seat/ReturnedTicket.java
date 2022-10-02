package com.cinema.cinemaRoom.seat;

import com.fasterxml.jackson.annotation.JsonGetter;

public class ReturnedTicket{
    Seat seat;

    public ReturnedTicket(Seat seat) {
        this.seat = seat;
    }

    @JsonGetter(value = "returned_ticket")
    public Seat getReturnedTicket() {
        return seat;
    }

    public void setReturnedTicket(Seat seat) {
        this.seat = seat;
    }
}

