package com.dev.CinemaRoomRESTService.cinema;

import com.dev.CinemaRoomRESTService.cinema.DTOs.CinemaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class CinemaController {

    private CinemaService cinemaService;

    @Autowired
    public CinemaController() {
        this.cinemaService =  new CinemaService();
    }

    ///////////////////////////////////////////////////

    @GetMapping("/seats")
    public CinemaDTO getSeats(){

        return cinemaService.getCinemaDTO();
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody Seat seat) throws JsonProcessingException {

        return cinemaService.purchaseTicket(seat);
    }

    @PostMapping("/return")
    public ResponseEntity<?> refund(@RequestBody Seat seat) {

        return cinemaService.returnTicket(seat);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> stats(@RequestParam(required = false) String password){

        return cinemaService.calcStats(password);
    }

}

