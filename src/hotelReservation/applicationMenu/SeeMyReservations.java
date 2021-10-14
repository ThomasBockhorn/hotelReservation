package hotelReservation.applicationMenu;

import api.HotelResource;
import model.Customer;

import java.util.Scanner;

public class SeeMyReservations {

    public void SeeMyReservations(Scanner scanner, HotelResource hotelResource){
        boolean running = true;

        while(running) {
            try{

                System.out.println("Please enter your email");
                String email = scanner.nextLine();

                Customer customer = hotelResource.getCustomer(email);

                System.out.println(hotelResource.findACustomerReservation(customer));
                running = false;

            }catch(Exception ex) {
                System.out.println("Please Reenter your info" + "\n" + ex );
                running = true;
            }
        }
    }
}
