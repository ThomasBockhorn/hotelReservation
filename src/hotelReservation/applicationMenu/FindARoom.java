package hotelReservation.applicationMenu;

import api.HotelResource;

import java.time.LocalDate;
import java.util.Scanner;

public class FindARoom {

    public void FindARoom(Scanner scanner, HotelResource hotelResource){
        boolean running = true;

        while(running){
            try{

                System.out.println("Enter your check in date");
                String checkInDate = scanner.nextLine();

                System.out.println("Enter your check out date");
                String checkOutDate = scanner.nextLine();

                if ( hotelResource.findARoom(LocalDate.parse(checkInDate),
                        LocalDate.parse(checkOutDate)) == null ){
                    System.out.println(hotelResource.findAFreeRoom(true));
                }else{
                    System.out.println(" All rooms are full for that date");
                }
                running = false;

            }catch(Exception ex){
                System.out.println("Please reenter your information");
                System.out.println(ex);
                running = true;
            }
        }
    }
}
