package com.dev.CinemaRoomRESTService.cinema.DTOs;

import com.dev.CinemaRoomRESTService.cinema.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class CinemaDTO {
    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    private final int total_rows = 9;
    private final int total_columns =9;


    @JsonProperty("available_seats")
    private List<Seat> availableSeats;

    public CinemaDTO(){};
    public CinemaDTO(List<Seat> seats){
        availableSeats = seats;
    }
}
