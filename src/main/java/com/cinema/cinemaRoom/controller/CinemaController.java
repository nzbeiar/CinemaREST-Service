package com.cinema.cinemaRoom.controller;

import com.cinema.cinemaRoom.Cinema;
import com.cinema.cinemaRoom.Seat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CinemaController {


    @GetMapping("/seats")
    public Cinema getLayout() {
        return new Cinema(9,9);
    }
}
