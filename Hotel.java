package HotelManagement;

import java.util.*;

public class Hotel {

    private UUID id;
    private String name;
    private List<Room> rooms;

    public Hotel(String name) {
        
        this.id = UUID.randomUUID();
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

}
