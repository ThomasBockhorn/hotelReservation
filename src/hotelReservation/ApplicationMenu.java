package hotelReservation;

import api.AdminResource;
import api.HotelResource;
import model.Customer;

import model.Room;
import java.time.LocalDate;
import java.util.Scanner;

public class ApplicationMenu {

    public void ApplicationMenu(AdminResource adminResource, HotelResource hotelResource){


        boolean keepRunning = true;

        try(Scanner scanner = new Scanner(System.in)){

            while(keepRunning){
                try{
                    System.out.println("========================= Main Menu ===============================" + "\n" +
                            "1. Find a room" + "\n" + "2. Reserve a room" + "\n" + "3. See my reservation" + "\n" +
                            "4. Create an account" + "\n" + "5. Admin" + "\n" + "6. Exit" + "\n" + "Enter your selection");
                    int selection = Integer.parseInt(scanner.nextLine());

                    switch(selection){

                        /**
                         * Find a Room
                         */
                        case 1:
                            System.out.println("======================= Find a Room ==============================");

                            try{
                                System.out.println("Please enter a room number");
                                String roomNumber = scanner.nextLine();

                                System.out.println( hotelResource.getRoom( roomNumber, true));

                            } catch(Exception ex) {
                                System.out.println("Please reenter a room number");
                            }
                            break;

                        /**
                         * Reserve a room
                         */
                        case 2:
                            System.out.println("======================== Reserve a Room ===========================");

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
                                        LocalDate.parse(checkOutDate));

                            }catch(Exception ex){
                                System.out.println("Please reenter your information");
                            }
                            break;

                        /**
                         * See my Reservation
                         */
                        case 3:
                            System.out.println("======================== See my Reservation ========================");

                            try{
                                System.out.println("Enter your check in date: YYYY-MM-DD");
                                String checkInDate = scanner.nextLine();

                                System.out.println("Enter your check out date: YYYY-MM-DD");
                                String checkOutDate = scanner.nextLine();


                                System.out.println(hotelResource.findARoom(LocalDate.parse(checkInDate), LocalDate.parse(checkOutDate)));


                            } catch( Exception ex ){
                                System.out.println("Please reenter information");
                            }
                            break;

                        /**
                         * Create an Account
                         */
                        case 4:
                            System.out.println("======================== Create an Account ==========================");

                            try{
                                System.out.println("First Name: ");
                                String firstName = scanner.nextLine();

                                System.out.println("Last Name: ");
                                String lastName = scanner.nextLine();

                                System.out.println("Email: ");
                                String email = scanner.nextLine();

                                hotelResource.createACustomer(firstName, lastName, email);

                            }catch(Exception ex){
                                System.out.println("Please reenter your information");
                            }
                            break;

                        /**
                         * Go to the Admin menu
                         */
                        case 5:
                            AdminMenu choice = new AdminMenu();
                            choice.AdminMenu( scanner, hotelResource, adminResource );
                            break;

                        /**
                         * Quit
                         */
                        case 6:
                            keepRunning = false;
                    }

                } catch (Exception exMain){
                    System.out.println("\n Invalid Input \n");
                    System.out.println("Main exception: " + exMain);
                    System.out.println("Enter your selection");
                    scanner.nextLine();
                }
            }
        }
    }
}
