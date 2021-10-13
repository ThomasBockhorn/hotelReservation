package hotelReservation;

import java.util.Scanner;

public class ApplicationMenu {

    public void ApplicationMenu(){

        boolean keepRunning = true;

        try(Scanner scanner = new Scanner(System.in)){

            while(keepRunning){
                try{
                    System.out.println("========================= Main Menu ===============================");
                    System.out.println("1. Find a room");
                    System.out.println("2. Reserve a room");
                    System.out.println("3. See my reservation");
                    System.out.println("4. Create an account");
                    System.out.println("5. Admin");
                    System.out.println("6. Exit");
                    System.out.println("Enter your selection");
                    int selection = Integer.parseInt(scanner.nextLine());


                    if(selection == 1){
                        System.out.println("======================= Find a Room ==============================");
                    }
                    else if(selection == 2){
                        System.out.println("======================== Reserve a Room ===========================");
                    }
                    else if(selection == 3){
                        System.out.println("======================== See my Reservation ========================");
                    }
                    else if(selection == 4){
                        System.out.println("======================== Create an Account ==========================");
                    }
                    else if(selection == 5) {
                        AdminMenu choice = new AdminMenu();
                        choice.AdminMenu( scanner );
                    }
                    else if(selection == 6){
                        keepRunning = false;
                    }
                    else{
                        System.out.println("Enter your selection");
                    }
                } catch (Exception exMain){
                    System.out.println("\n Invalid Input \n");
                    System.out.println("Main exception: " + exMain);
                    scanner.nextLine();
                }
            }
        }
    }
}
