package model;

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomTypes.RoomType getRoomType();
    public boolean isFree();
}
