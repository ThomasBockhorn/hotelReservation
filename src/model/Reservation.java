package model;

import java.time.LocalDate;

/**
 * Reservation model
 */
public class Reservation {
     Customer customer;
     IRoom room;
     LocalDate checkInDate;
     LocalDate checkOutDate;

     public Reservation(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate ){
         super();
         this.customer = customer;
         this.room = room;
         this.checkInDate = checkInDate;
         this.checkOutDate = checkOutDate;
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
