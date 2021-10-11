package api;

import model.Customer;
import model.Room;
import model.RoomTypes;
import service.CustomerService;
import service.ReservationService;

import java.util.List;

/**
 * AdminResource interacts with the service classes
 */
public class AdminResource {

    static CustomerService customerServiceSession;
    static ReservationService reservationServiceSession;

    public AdminResource(){
        super();
        customerServiceSession = new CustomerService();
        reservationServiceSession = new ReservationService();
    }

    public Customer getCustomer(String email){

        return customerServiceSession.getCustomer(email);

    }

    public void addRoom(String roomNumber, Double price, RoomTypes.RoomType enumeration, boolean isFree){

        reservationServiceSession.addRoom(roomNumber, price, enumeration, isFree);

    }


    public String getAllRooms(){

        return reservationServiceSession.printAllRooms();

    }

    public String getAllCustomers(){

        return customerServiceSession.printAllCustomers();

    }

    public String displayAllReservations(){

        return reservationServiceSession.printAllReservation();

    }
}
