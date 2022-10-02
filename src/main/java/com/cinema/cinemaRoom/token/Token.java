package com.cinema.cinemaRoom.token;

import com.cinema.cinemaRoom.seat.Seat;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Token {

    private String token;

    private Seat seat;


    @JsonGetter(value = "ticket")
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Token(Seat seat, String token) {
        this.token = token;
        this.seat = seat;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
