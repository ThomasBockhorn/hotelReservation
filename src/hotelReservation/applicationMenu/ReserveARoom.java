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

                if(hotelResource.findARoom(LocalDate.parse(checkInDate), LocalDate.parse(checkOutDate)) == null){

                    hotelResource.bookARoom(customer, roomID, LocalDate.parse(checkInDate),
                            LocalDate.parse(checkOutDate), false);

                }
                else if((hotelResource.findARoom(LocalDate.parse(checkInDate).plusDays(7),
                        LocalDate.parse(checkOutDate).plusDays(7))) == null){

                    /**
                     * Asks the user if 7 days later do
                     */
                    System.out.println("Would " + LocalDate.parse(checkInDate).plusDays(7) + " to " +
                            LocalDate.parse(checkOutDate).plusDays(7) + " do?" + "\n" + "Yes(yes) or No(no)");
                    String ask = scanner.nextLine();

                    if( ask.equals("Yes") || ask.equals("yes")){

                        LocalDate newCheckInDate = LocalDate.parse(checkInDate).plusDays(7);
                        LocalDate newCheckOutDate = LocalDate.parse(checkOutDate).plusDays(7);

                        hotelResource.bookARoom(customer, roomID, newCheckInDate,
                                newCheckOutDate, false);

                    } else{
                        System.out.println("All rooms are booked for those dates");
                    }
                }

                keepRunning = false;

            }catch(Exception ex){
                System.out.println("Error in reserving a room" + "\n");
                keepRunning = false;
            }
        }
    }
}
