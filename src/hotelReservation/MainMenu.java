package hotelReservation;


import api.AdminResource;
import api.HotelResource;

public class MainMenu {

   public static void main(String [] arcs){

       HotelResource hotelResource = new HotelResource();
       AdminResource adminResource = new AdminResource();

       ApplicationMenu menu = new ApplicationMenu();
       menu.ApplicationMenu( adminResource, hotelResource );
    }

}
