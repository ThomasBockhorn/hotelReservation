package model;

/**
 * This extends the Room model.  It sets the price to zero and sets the isFree to true.
 */

public class FreeRoom extends Room{

    public FreeRoom() {
        super("", 0.00, RoomTypes.RoomType.DOUBLE, true);
    }

    @Override
    public String toString(){
        return "Price is now: " + this.price;
    }
}
