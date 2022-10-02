package com.cinema.cinemaRoom.controller;

import com.cinema.cinemaRoom.CustomError;
import com.cinema.cinemaRoom.cinema.Cinema;
import com.cinema.cinemaRoom.cinema.Statistics;
import com.cinema.cinemaRoom.seat.ReturnedTicket;
import com.cinema.cinemaRoom.seat.Seat;
import com.cinema.cinemaRoom.seat.SeatDTO;
import com.cinema.cinemaRoom.token.Token;
import com.cinema.cinemaRoom.token.TokenDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class CinemaController {

    Cinema cinema = new Cinema(9, 9);

    @GetMapping("/seats")
    public Cinema getLayout() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> buyTicket(@RequestBody SeatDTO seatDTO) {
        int row = seatDTO.getRow();
        int column = seatDTO.getColumn();
        if (row > cinema.getTotalRows() || row < 1 || column > cinema.getTotalColumns() || column < 1) {
            return new ResponseEntity<>(new CustomError("The number of a row or a column is out of bounds!"), HttpStatus.valueOf(400));
        } else {
            for (Seat seat : cinema.getSeats()) {
                if (row == seat.getRow() && column == seat.getColumn() && !seat.isBooked()) {
                    seat.setBooked(true);
                    String token = String.valueOf(UUID.randomUUID());
                    seat.setToken(token);
                    cinema.setCurrentIncome(cinema.getCurrentIncome() + seat.getPrice());
                    cinema.setNumberOfPurchasedTickets(cinema.getNumberOfPurchasedTickets() + 1);
                    cinema.setNumberOfSeats(cinema.getNumberOfSeats() - 1);
                    return new ResponseEntity<>(new Token(seat, token), HttpStatus.valueOf(200));
                }
            }
        }

        return new ResponseEntity<>(new CustomError("The ticket has been already purchased!"), HttpStatus.valueOf(400));
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody TokenDTO tokenDTO) {
        for (Seat seat : cinema.getSeats()) {
            if (tokenDTO.getToken().equals(seat.getToken())) {
                seat.setBooked(false);
                cinema.setCurrentIncome(cinema.getCurrentIncome() - seat.getPrice());
                cinema.setNumberOfPurchasedTickets(cinema.getNumberOfPurchasedTickets() - 1);
                cinema.setNumberOfSeats(cinema.getNumberOfSeats() + 1);
                return new ResponseEntity<>(new ReturnedTicket(seat), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new CustomError("Wrong token!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam(required = false) String password) {
        if ("super_secret".equals(password)) {
            return new ResponseEntity<>(new Statistics(cinema), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomError("The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }
    }
}
