package com.dev.CinemaRoomRESTService.cinema;

import com.dev.CinemaRoomRESTService.cinema.DTOs.CinemaDTO;
import com.dev.CinemaRoomRESTService.cinema.DTOs.PurchaseDTO;
import com.dev.CinemaRoomRESTService.cinema.DTOs.ReturnDTO;
import com.dev.CinemaRoomRESTService.cinema.DTOs.StatsDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CinemaService {

    public final Cinema cinema;
    private Seat seat = new Seat();


    public StatsDTO statsDTO;

    @Autowired
    public CinemaService(){
        this.cinema = new Cinema();
        this.statsDTO = new StatsDTO();
    }

    public Cinema getSeats(){
        return cinema;
    }
    public CinemaDTO getCinemaDTO(){
        return new CinemaDTO(cinema.getSeatList());
    }

    //////////////////////////////////////////////////////////////////////////

    public Optional<Seat> getSeat(int row, int col){
        return getSeats().getSeatList().stream().filter(
                s -> s.getRow() == row && s.getColumn() == col
        ).findFirst();
    }

    public Optional<Seat> getSeatByToken(UUID token){
        return getSeats().getSeatList().stream().filter(
                s -> s.getToken().equals(token)
        ).findFirst();

    }

    public int calcTakenSeats(){
        return (int)cinema.getSeatList().stream().filter(seat -> seat.isTaken()).count();
    }
    public int calcIncome(){
        int income = 0;
        for(Seat seat : cinema.getSeatList()){
            if(seat.isTaken()){
                income += seat.getPrice();
            }
        }
        return income;
    }

    public ResponseEntity<String> calcStats(String password){
        if(password != null){
            if(password.equals("super_secret")){
                int takenSeats = calcTakenSeats();

                statsDTO.setCurrentIncome(calcIncome());
                statsDTO.setNumberOfAvailableSeats(cinema.getTotal_rows()*cinema.getTotal_columns() - takenSeats);
                statsDTO.setNumberOfPurchasedSeats(takenSeats);

                return new ResponseEntity(statsDTO, HttpStatus.OK);
            }
        }

        return new ResponseEntity(new java.lang.Error("The password is wrong!"), HttpStatus.UNAUTHORIZED);
    }
    ///////////////////////////////////////////////////////////////////////////

    public ResponseEntity<String> purchaseTicket(Seat seat) throws JsonProcessingException {
        if(seat.getRow() > 9 || seat.getColumn() > 9
                || seat.getRow() < 1 || seat.getColumn() < 1) {
            return new ResponseEntity(new java.lang.Error("The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);

        }

        if(getSeat(seat.getRow(), seat.getColumn()).map(Seat::isTaken).get()){
            return new ResponseEntity(new java.lang.Error("The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);

        }


        getSeat(seat.getRow(), seat.getColumn()).ifPresent(
                    s -> s.setTaken(true)
        );

        //objectMapper.writeValueAsString <String> <?>
        return new ResponseEntity(new PurchaseDTO(getSeat(seat.getRow(), seat.getColumn()).get()), HttpStatus.OK);
    }


    public ResponseEntity<String> returnTicket(Seat seat){
        UUID givenSeatsToken = null;


        Optional<Seat> optional = getSeatByToken(seat.getToken());
        if(optional.isPresent()) {
            givenSeatsToken = optional.get().getToken();
        }

        if(givenSeatsToken != null){
            if(optional.get().isTaken()){
                optional.get().setTaken(false);
                return new ResponseEntity(new ReturnDTO(getSeatByToken(seat.getToken()).get()), HttpStatus.OK);
            }
        }

        return new ResponseEntity(new java.lang.Error("Wrong token!"), HttpStatus.BAD_REQUEST);
    }





}
