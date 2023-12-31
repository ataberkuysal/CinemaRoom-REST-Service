package com.dev.CinemaRoomRESTService.cinema.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class StatsDTO {

    @JsonProperty("current_income")
    private int currentIncome;
    @JsonProperty("number_of_available_seats")
    private int numberOfAvailableSeats;
    @JsonProperty("number_of_purchased_tickets")
    private int numberOfPurchasedSeats;

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedSeats() {
        return numberOfPurchasedSeats;
    }

    public void setNumberOfPurchasedSeats(int numberOfPurchasedSeats) {
        this.numberOfPurchasedSeats = numberOfPurchasedSeats;
    }

    public StatsDTO(){};

    public StatsDTO(int currentIncome, int numberOfAvailableSeats, int numberOfPurchasedSeats) {
        this.currentIncome = currentIncome;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.numberOfPurchasedSeats = numberOfPurchasedSeats;
    }
}
