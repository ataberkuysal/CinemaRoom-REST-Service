package com.dev.CinemaRoomRESTService.cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Cinema {

    private int total_rows;
    private int total_columns;
    @JsonProperty("available_seats")
    private List<Seat> seats;
    @JsonIgnore
    private final int number = 4, price10 = 10, price8 = 8;


    public Cinema(){
        this.total_rows = 9;
        this.total_columns = 9;
        this.seats = new ArrayList<>();

        createSeats();

    }

    public Cinema (int total_rows, int total_columns, List<Seat> seats ){
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.seats = seats;
    }
    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    //@JsonProperty("available_seats")
    public List<Seat> getSeatList() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void createSeats(){
        for(int a = 1 ; a <= getTotal_rows() ; a++){
            for(int b = 1 ; b <= getTotal_columns() ; b++){
                seats.add(new Seat(a, b, a <= number ? price10 : price8));
            }

        }

    }
}
