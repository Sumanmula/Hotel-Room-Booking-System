package HotelManagement;

import java.util.UUID;

public class Room {

    private final UUID id;
    private final String roomNumber;
    private RoomType roomType;
    private double price;
    private boolean available;


    public Room(String roomNumber, RoomType roomType, double price) {
        
        this.id = UUID.randomUUID();
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.available = true;
    }

    public UUID getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
