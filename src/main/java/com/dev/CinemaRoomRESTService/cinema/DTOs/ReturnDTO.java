package com.dev.CinemaRoomRESTService.cinema.DTOs;

import com.dev.CinemaRoomRESTService.cinema.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ReturnDTO {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UUID token;
    @JsonProperty("returned_ticket")
    private Seat seat;

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }


    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public ReturnDTO(){};

    public ReturnDTO (Seat seat){
        this.token = seat.getToken();
        this.seat = seat;
    }
}
