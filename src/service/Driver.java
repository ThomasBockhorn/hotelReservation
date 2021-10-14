package service;

import model.Customer;
import model.Room;
import model.RoomTypes;

import java.time.LocalDate;


public class Driver {


    public static void main(String [] arcs){


        CustomerService customer = new CustomerService();

        customer.addCustomer("Thomas", "Bockhorn", "thomas.bockhorn@gmail.com");

        System.out.println(customer.getCustomer("thomas.bockhorn@gmail.com"));


        System.out.println("-----------------------------------------------------------------------------------------");


        ReservationService service = new ReservationService();
        
        service.addRoom("100", 102.00, RoomTypes.RoomType.DOUBLE, true);

        System.out.println(service.getARoom("100", true));


        System.out.println("-------------------------------------------------------------------------------------------");

        /**
         * Sample customer 1
         */
        Customer newCustomer = new Customer("Thomas", "Bockhorn", "thomas.bockhorn@tecktonet.com");
        Room newRoom = new Room("101", 134.45, RoomTypes.RoomType.SINGLE, false);
        LocalDate checkInDate =  LocalDate.of(2021, 02, 12);
        LocalDate checkOutDate =  LocalDate.of(2021, 03, 12);

        service.reserveARoom(newCustomer, newRoom, checkInDate,checkOutDate);

        /**
         * Sample customer 2
         */
        Customer newCustomerTwo = new Customer("Bob", "Bockhorn", "bob.bockhorn@tecktonet.com");
        Room newRoomTwo = new Room("103", 136.00, RoomTypes.RoomType.DOUBLE, false);
        LocalDate checkInDateTwo =  LocalDate.of(2021, 04, 14);
        LocalDate checkOutDateTwo =  LocalDate.of(2021, 04, 18);

        service.reserveARoom(newCustomerTwo, newRoomTwo, checkInDateTwo ,checkOutDateTwo);

        System.out.println(service.printAllReservation());


        System.out.println("-----------------------------------------------------------------------------------------");

        /**
         * Sample customer 1
         */
        Customer newerCustomer = new Customer("Jane", "Bockhorn", "thomas.bockhorn@tecktonet.com");
        Room newerRoom = new Room("104", 134.45, RoomTypes.RoomType.SINGLE, false);
        LocalDate newerCheckInDate =  LocalDate.of(2021, 06, 12);
        LocalDate newerCheckOutDate =  LocalDate.of(2021, 06, 12);
        service.reserveARoom(newerCustomer, newerRoom, newerCheckInDate , newerCheckOutDate);


        System.out.println(service.findRooms(checkInDateTwo ,checkOutDateTwo));

        System.out.println("-----------------------------------------------------------------------");

        System.out.println(service.printAllReservation());

        System.out.println("==========================================================================");

        //System.out.println(service.printAllRooms());

        System.out.println(service.getARoom("100", true));
        //System.out.println(customer.getCustomer("thomas.bockhorn@gmail.com"));
        Customer customer99 = customer.getCustomer("thomas.bockhorn@gmail.com");

        System.out.println("============================================================================");
        Customer customer999 = customer.getCustomer("thomas.bockhorn@tecktonet.com");

        System.out.println(service.getCustomerReservation(customer.getCustomer("thomas.bockhorn@tecktonet.com")));

    }
}
