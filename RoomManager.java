package HotelManagement;

import java.util.*;
import java.util.stream.Collectors;

public class RoomManager {

    private Map<UUID, Room> roomMap = new HashMap<>();

    public Room addRoom(String roomNumber, RoomType roomType, double price) {
        for (Room room : roomMap.values()) {
            if (room.getRoomNumber().equalsIgnoreCase(roomNumber)) {
                System.out.println("Room with number " + roomNumber + " already exists!");
                return null;
            }
        }
        Room room = new Room(roomNumber, roomType, price);
        roomMap.put(room.getId(), room);
        return room;
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(roomMap.values());
    }



    public Room updateRoom(UUID id, RoomType newRoomType) {
        Room room = roomMap.get(id);
        if (room != null) {
            room.setRoomType(newRoomType);
        }
        return room;
    }

    public Room updatePrice(UUID id, RoomType newRoomType, double newPrice) {
        Room room = roomMap.get(id);
        if (room != null) {
            room.setRoomType(newRoomType);
            room.setPrice(newPrice);
        }
        return room;
    }

    public Room updateRoomDetails(UUID id, RoomType newRoomType, double newPrice) {
        Room room = roomMap.get(id);
        if (room != null) {
            room.setRoomType(newRoomType);
            room.setPrice(newPrice);
        }
        return room;
    }

    public boolean removeRoom(UUID id) {
        return roomMap.remove(id) != null;
    }

    public Room getRoom(UUID id) {
        return roomMap.get(id);
    }

    public List<Room> getAvailableRooms() {
        return roomMap.values().stream()
            .filter(Room::isAvailable)
            .collect(Collectors.toList());
    }

    public List<Room> getAvailableRoomsByType(RoomType roomType) {
        return roomMap.values().stream()
            .filter(room -> room.isAvailable() && room.getRoomType() == roomType)
            .collect(Collectors.toList());
    }
    
}
