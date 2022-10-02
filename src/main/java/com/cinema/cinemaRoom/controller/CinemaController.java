package com.cinema.cinemaRoom.controller;

import com.cinema.cinemaRoom.Cinema;
import com.cinema.cinemaRoom.CustomError;
import com.cinema.cinemaRoom.Seat;
import com.cinema.cinemaRoom.SeatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CinemaController {

    Cinema cinema = new Cinema(9,9);

    @GetMapping("/seats")
    public Cinema getLayout() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> buyTicket(@RequestBody SeatDTO seatDTO) {
        int row = seatDTO.getRow();
        int column = seatDTO.getColumn();
        if (row > cinema.getTotalRows() || row < 1 || column > cinema.getTotalColumns() || column < 1) {
            return new ResponseEntity<>(new CustomError("The number of a row or a column is out of bounds!"),HttpStatus.valueOf(400));
        } else {
            for (Seat seat : cinema.getSeats()) {
                if (row == seat.getRow() && column == seat.getColumn()) {
                    cinema.availableSeats.remove(seat);
                    return new ResponseEntity<>(seat, HttpStatus.valueOf(200));
                }
            }
        }

        return new ResponseEntity<>(new CustomError("The ticket has been already purchased!"),HttpStatus.valueOf(400));
    }
}
