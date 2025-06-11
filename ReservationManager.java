package HotelManagement;

import java.time.LocalDate;
import java.util.*;

public class ReservationManager {
    
    private List<Reservation> reservations = new ArrayList<>();

    public boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        for (Reservation r : reservations) {
            if (r.getRoom().getId().equals(room.getId()) &&
                !(endDate.isBefore(r.getStartDate()) || startDate.isAfter(r.getEndDate()))) {
                return false;
            }
        }
        return true;
    }

    public Reservation createReservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate) {
        if (!isRoomAvailable(room, startDate, endDate)) {
            System.out.println("Room not available for the selected dates.");
            return null;
        }

        Reservation reservation = new Reservation(guest, room, startDate, endDate);
        reservations.add(reservation);
        room.setAvailable(false);
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
