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
    static LinkedList<Room> roomList;


    public ReservationService(){
        roomList = new LinkedList<>();
        reservations = new LinkedList<>();
    }

    public void addRoom(String roomNumber, Double price, RoomTypes.RoomType enumeration, boolean isFree){

        List<Room> roomCheck = roomList.stream()
                .filter(checkRoom -> roomNumber.equals(checkRoom.getRoomNumber()))
                .map(checkRoom -> new Room(checkRoom.getRoomNumber(), checkRoom.getRoomPrice(),
                        checkRoom.getRoomType(), checkRoom.isFree()))
                .collect(Collectors.toList());

        if (roomCheck.isEmpty()){
            Room newRoom = new Room(roomNumber,price,enumeration,isFree);
            roomList.add(newRoom);
        }
    }

    public Room getARoom(String roomID, Boolean isFree){

       List<Room> result = roomList.stream()
               .filter(pickedRoom -> roomID.equals(pickedRoom.getRoomNumber()))
               .filter(pickedRoom -> isFree.equals(pickedRoom.isFree()))
               .map(pickedRoom -> new Room(pickedRoom.getRoomNumber(), pickedRoom.getRoomPrice(),
                       pickedRoom.getRoomType(), pickedRoom.isFree()))
               .collect(Collectors.toList());

        return result.iterator().next();
    }


    public void reserveARoom (Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate, Boolean isFree){

        List<Reservation> result = reservations.stream()
                .filter( pickedReservation -> room.getRoomNumber().equals(pickedReservation.getRoom().getRoomNumber()))
                .filter( pickedReservation -> checkInDate.isEqual( pickedReservation.getCheckInDate()))
                .filter( pickedReservation -> checkOutDate.isEqual( pickedReservation.getCheckOutDate()))
                .map( pickedReservation -> new Reservation(pickedReservation.getCustomer(), pickedReservation.getRoom(),
                        pickedReservation.getCheckInDate(), pickedReservation.getCheckOutDate(), pickedReservation.getFree()))
                .collect(Collectors.toList());

            if(result.isEmpty()){
                Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate, isFree);
                reservations.add(reservation);
            }
    }


    public String printAllReservation(){

       String resultList;

       resultList = "The List of all Reservations" + "\n";

      for(Reservation reservationEntry: reservations){
           resultList += reservationEntry.toString();
       }

       return resultList;
    }

    public String printAllRooms(){

        String resultList;

        resultList = "The List of all Rooms: " + "\n";

        for(Room rooms : roomList){
            resultList += rooms.toString();
        }

        return resultList;
    }


    public List<Reservation> getCustomerReservation ( Customer customer ){

        List<Reservation> result = reservations.stream()
                .filter(picked -> customer.getFirstName().equals(picked.getCustomer().getFirstName()))
                .filter(picked -> customer.getLastName().equals(picked.getCustomer().getLastName()))
                .filter(picked -> customer.getEmail().equals(picked.getCustomer().getEmail()))
                .map( picked -> new Reservation( picked.getCustomer(), picked.getRoom(),
                        picked.getCheckInDate(), picked.getCheckOutDate(), picked.getFree()))
                .collect(Collectors.toList());

            return result;
    }


    public Reservation findRooms(LocalDate checkInDate, LocalDate checkOutDate){

        List<Reservation> resultList = reservations.stream()
                .filter( pickedDate -> checkInDate.isEqual(pickedDate.getCheckInDate()))
                .filter( pickedDate -> checkOutDate.isEqual(pickedDate.getCheckOutDate()))
                .map( pickedDate -> new Reservation( pickedDate.getCustomer(),
                        pickedDate.getRoom(), pickedDate.getCheckInDate(), pickedDate.getCheckOutDate(), pickedDate.getFree()))
                .collect(Collectors.toList());
        if(resultList.isEmpty()){
            return null;
        } else {
            return resultList.iterator().next();
        }
    }

    public Room findAllFreeRooms(Boolean isFree){

        List<Room> resultList = roomList.stream()
                .filter( pickedReservation -> isFree.equals(pickedReservation.isFree()))
                .map( pickedReservation -> new Room( pickedReservation.getRoomNumber(),
                        pickedReservation.getRoomPrice(), pickedReservation.getRoomType(),
                        pickedReservation.isFree()))
                .collect(Collectors.toList());

        return resultList.iterator().next();
    }

}
