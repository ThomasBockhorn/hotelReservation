package api;

import model.Customer;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.time.LocalDate;

/**
 * This API class will interact with the service class
 */
public class HotelResource {

    static CustomerService customerServiceSession;
    static ReservationService reservationServiceSession;

    public HotelResource(){
        super();
        customerServiceSession = new CustomerService();
        reservationServiceSession = new ReservationService();
    }

    public Customer getCustomer(String email){

        return customerServiceSession.getCustomer(email);

    }


    public void createACustomer(String email, String firstName, String lastName){

        customerServiceSession.addCustomer(email,firstName,lastName);

    }

    public Room getRoom(String roomNumber, boolean isFree){

       return reservationServiceSession.getARoom(roomNumber, isFree);

    }

    public void bookARoom(Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate){

        reservationServiceSession.reserveARoom(customer, room, checkInDate, checkOutDate);

    }

    public Reservation findARoom(LocalDate checkIn, LocalDate checkOut){

        return reservationServiceSession.findRooms( checkIn, checkOut);

    }

}
