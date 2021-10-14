package model;

/**
 * This is the room interface that sets up required methods for all objects that extend this interface
 */

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomTypes.RoomType getRoomType();
    public boolean isFree();
}
