package service;

import model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ReservationService class sets up addRoom, getARoom, reserveARoom, printAllReservations, getCustomerReservation
 * findRooms
 */

public class ReservationService {

    static LinkedList<Reservation> reservations;
    static List<Room> roomList;


    public ReservationService(){
        roomList = new LinkedList<>();
        reservations = new LinkedList<>();
    }

    public void addRoom(String roomNumber, Double price, RoomTypes.RoomType enumeration, boolean isFree){

        Room newRoom = new Room(roomNumber,price,enumeration,isFree);
        roomList.add(newRoom);
    }

    public Room getARoom(String roomID){

       List<Room> result = roomList.stream()
               .filter(pickedRoom -> roomID.equals(pickedRoom.getRoomNumber()))
               .map(pickedRoom -> new Room(pickedRoom.getRoomNumber(), pickedRoom.getRoomPrice(),
                       pickedRoom.getRoomType(), pickedRoom.isFree()))
               .collect(Collectors.toList());

        return result.iterator().next();
    }


    public void reserveARoom (Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate){

        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);
        reservations.add(reservation);
    }


    public String printAllReservation(){

       String resultList;

       resultList = "The List of all Reservations" + "\n";

      for(Reservation reservationEntry: reservations){
           resultList += reservationEntry.toString();
       };

       return resultList;
    }


    public Reservation getCustomerReservation(Customer customer){

        List<Reservation> resultList = reservations.stream()
                .filter( pickedCustomer -> customer.equals(pickedCustomer.getCustomer()))
                .map( pickedCustomer -> new Reservation(pickedCustomer.getCustomer(), pickedCustomer.getRoom(),
                        pickedCustomer.getCheckInDate(), pickedCustomer.getCheckOutDate()))
                .collect(Collectors.toList());

        return resultList.iterator().next();
    }


    public Reservation findRooms(LocalDate checkInDate, LocalDate checkOutDate){

        List<Reservation> resultList = reservations.stream()
                .filter( pickedDate -> checkInDate.isEqual(pickedDate.getCheckInDate()))
                .filter( pickedDate -> checkOutDate.isEqual(pickedDate.getCheckOutDate()))
                .map( pickedDate -> new Reservation( pickedDate.getCustomer(),
                        pickedDate.getRoom(), pickedDate.getCheckInDate(), pickedDate.getCheckOutDate()))
                .collect(Collectors.toList());

        return resultList.iterator().next();
    }




}
