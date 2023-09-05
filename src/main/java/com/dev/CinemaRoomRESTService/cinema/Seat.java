package com.dev.CinemaRoomRESTService.cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Seat {

    private int row;
    private int column;
    private int price;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean taken;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UUID token;


    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }


    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Seat(){};


    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.taken = false;
        this.token = UUID.randomUUID();
    }

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.taken = false;
        this.token = UUID.randomUUID();
    }



    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setcolumn(int column) {
        this.column = column;
    }


}
