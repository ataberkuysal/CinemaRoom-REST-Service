package com.dev.CinemaRoomRESTService.cinema.DTOs;

import com.dev.CinemaRoomRESTService.cinema.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PurchaseDTO {
    private UUID token;
    @JsonProperty("ticket")
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
    public PurchaseDTO(){};

    public PurchaseDTO (Seat seat){
        this.seat = seat;
        //seat.setToken(UUID.randomUUID());
        token = this.seat.getToken();

    }




}
