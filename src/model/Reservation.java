package model;

import java.time.LocalDate;

/**
 * This is the reservation model that contains all the information necessary for the reservation object
 */

public class Reservation {
     Customer customer;
     IRoom room;
     LocalDate checkInDate;
     LocalDate checkOutDate;
     Boolean isFree;

     public Reservation(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate, Boolean isFree ){
         super();
         this.customer = customer;
         this.room = room;
         this.checkInDate = checkInDate;
         this.checkOutDate = checkOutDate;
         this.isFree = isFree;
     }

    /**
     * Getters
     */
    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Boolean getFree() {
        return isFree;
    }

    /**
     * Setters
     */
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    /**
     * This method will borrow the formatting from the other toString methods from Customer and Room model class.
     * It will impose a format for the time.
     * @return String
     */
    @Override
    public String toString(){
         return customer + " " + room + " " +
                 "Check In: " + checkInDate + "\n" +
                 "Check Out: " + checkOutDate + "\n" +
                 "---------------------------------------" + "\n";
     }

}
