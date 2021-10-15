package hotelReservation.adminMenu;

import model.RoomTypes;

import java.util.Scanner;
import api.AdminResource;

public class AddARoomMenu {

    public void addARoomMenu(Scanner scanner, AdminResource adminResource ){
        boolean keepRunning = true;
        while(keepRunning){
            try {
                System.out.println("What is the room number?");
                String roomNumber = scanner.nextLine();

                System.out.println("What is the price?");
                String price = scanner.nextLine();

                System.out.println("What is the room type? SINGLE or DOUBLE");
                String enumeration = scanner.nextLine();

                adminResource.addRoom(roomNumber, Double.valueOf(price),
                        RoomTypes.RoomType.valueOf(enumeration), true);
                keepRunning = false;

            } catch (Exception ex) {
                System.out.println("Invalid input.  Please try again.");
                keepRunning = true;
            }
        }
    }
}
