package hotelReservation.applicationMenu;

import api.HotelResource;

import java.util.Scanner;

public class CreateAAccount {

    public void CreateAAccount(Scanner scanner, HotelResource hotelResource){

        boolean keepRunning = true;

        while(keepRunning){
            try{
                System.out.println("First Name: ");
                String firstName = scanner.nextLine();

                System.out.println("Last Name: ");
                String lastName = scanner.nextLine();

                System.out.println("Email: ");
                String email = scanner.nextLine();

                hotelResource.createACustomer(firstName, lastName, email);
                keepRunning = false;
            }catch(Exception ex){
                System.out.println("Please reenter your information" + "\n" + ex);
                keepRunning = true;
            }
        }

    }
}
