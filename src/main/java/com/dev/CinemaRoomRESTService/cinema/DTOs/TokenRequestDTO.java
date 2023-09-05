package com.dev.CinemaRoomRESTService.cinema.DTOs;

import java.util.UUID;

public class TokenRequestDTO {

    private UUID token;


    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }


    public TokenRequestDTO(){};
    public TokenRequestDTO (UUID token){
        this.token = token;

    }
}
