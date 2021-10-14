package hotelReservation;

import api.AdminResource;
import api.HotelResource;
import model.RoomTypes;
import service.CustomerService;
import service.ReservationService;

import java.util.Scanner;

public class AdminMenu {

    public void AdminMenu(Scanner scanner, HotelResource hotelResource, AdminResource adminResource){

        boolean keepRunning = true;

        try(scanner) {

            while (keepRunning) {

                try {
                    System.out.println("=================== Admin menu =======================" + "\n"
                    + "1. See all customers" + "\n" + "2. See all rooms" + "\n" + "3. See all reservations" +
                    "\n" + "4. Add a room" + "\n" + "5. Back to main menu");
                   /** System.out.println("1. See all customers");
                    System.out.println("2. See all rooms");
                    System.out.println("3. See all reservations");
                    System.out.println("4. Add a room");
                    System.out.println("5. Back to main menu");**/

                    int selection = Integer.parseInt(scanner.nextLine());

                    switch (selection) {

                        /**
                         * See All Customers
                         */
                        case 1:
                            System.out.println("=============== See all customers ===================");
                            System.out.println(adminResource.getAllCustomers());
                            break;

                        /**
                         * See All Rooms
                         **/
                        case 2:
                            System.out.println("================ See all rooms ========================");
                            System.out.println(adminResource.getAllRooms());
                            break;

                        /**
                         * See All Reservations
                         */
                        case 3:
                            System.out.println("================ See all reservations ==================");
                            System.out.println(adminResource.displayAllReservations());
                            break;

                        /**
                         * Add A Room
                         */
                        case 4:
                            System.out.println("================ Add a room =============================");

                            try {
                                System.out.println("What is the room number?");
                                String roomNumber = scanner.nextLine();

                                System.out.println("What is the price?");
                                String price = scanner.nextLine();

                                System.out.println("What is the room type?");
                                String enumeration = scanner.nextLine();

                                System.out.println("Is it free?");
                                String isFree = scanner.nextLine();

                                adminResource.addRoom(roomNumber, Double.valueOf(price),
                                        RoomTypes.RoomType.valueOf(enumeration), Boolean.parseBoolean(isFree));

                            } catch (Exception ex) {
                                System.out.println("Invalid input.  Please try again.");
                            }
                            break;

                        /**
                         * Goes back to the main menu
                         */
                        case 5:
                            keepRunning = false;

                            ApplicationMenu menu = new ApplicationMenu();
                            menu.ApplicationMenu(adminResource, hotelResource);

                            break;
                         }

                     } catch (Exception exAdmin){
                    System.out.println("\n Invalid Input \n");
                    System.out.println("Admin exception:" + exAdmin);
                }
            }
        }
    }
}
