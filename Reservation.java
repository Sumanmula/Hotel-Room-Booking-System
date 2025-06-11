package HotelManagement;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private Guest guest;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate) {
        
        this.id = UUID.randomUUID();
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
