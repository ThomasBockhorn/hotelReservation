package model;

/**
 * This is the Room model.
 */

public class Room implements IRoom{

   protected String roomNumber;
   protected Double price;
   protected boolean isFree;
   protected RoomTypes.RoomType enumeration;


   public Room(String roomNumber, Double price, RoomTypes.RoomType enumeration, boolean isFree){
       super();
       this.roomNumber = roomNumber;
       this.price = price;
       this.isFree = isFree;
       this.enumeration = enumeration;
   }

    @Override
   public String toString(){
       return "---------------------------------" + "\n" +
               "Room number: " + roomNumber + "\n" +
               "Price: " + price + "\n" +
               "Single or Double: " + enumeration + "\n"+
               "Available: " + isFree + "\n";
   }

    /**
     * Getters
     */
    @Override
    public String getRoomNumber() {
       return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
       return price;
    }

    @Override
    public RoomTypes.RoomType getRoomType() {
       return  enumeration;
    }

    @Override
    public boolean isFree(){
      return isFree;
    }
}
