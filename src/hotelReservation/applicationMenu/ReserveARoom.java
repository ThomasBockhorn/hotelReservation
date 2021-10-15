package hotelReservation.applicationMenu;

import api.HotelResource;
import model.Customer;
import model.Room;

import java.time.LocalDate;
import java.util.Scanner;

public class ReserveARoom {

    public void ReserveARoom(Scanner scanner, HotelResource hotelResource ){
        boolean keepRunning = true;

        while(keepRunning){
            try{

                System.out.println("Enter your email address");
                String email = scanner.nextLine();

                System.out.println("Enter the room number:");
                String roomNumber = scanner.nextLine();

                System.out.println("Enter your check-in date YYYY-MM-DD");
                String checkInDate = scanner.nextLine();

                System.out.println("Enter your check-out date YYYY-MM-DD");
                String checkOutDate = scanner.nextLine();

                Customer customer = hotelResource.getCustomer(email);
                Room roomID = hotelResource.getRoom(roomNumber, true);

                hotelResource.bookARoom(customer, roomID, LocalDate.parse(checkInDate),
                        LocalDate.parse(checkOutDate), false);
                keepRunning = false;

            }catch(Exception ex){
                System.out.println("Error in reserving a room" + "\n");
                keepRunning = false;
            }
        }
    }
}
