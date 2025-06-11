package HotelManagement;

public enum RoomType {
    SINGLE(1),
    DOUBLE(2),
    DELUXE(4);

    private final int capacity;

    RoomType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
