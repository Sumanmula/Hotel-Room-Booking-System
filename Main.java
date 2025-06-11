package HotelManagement;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        RoomManager roomManager = new RoomManager();
        GuestManager guestManager = new GuestManager();
        ReservationManager reservationManager = new ReservationManager();

        Hotel hotel = new Hotel("ITC Royal Bengal");

        Room room1 = roomManager.addRoom("101", RoomType.SINGLE, 1000.0);
        Room room2 = roomManager.addRoom("102", RoomType.DOUBLE, 2000.0);
        Room room3 = roomManager.addRoom("103", RoomType.DOUBLE, 2000.0);
        Room room4 = roomManager.addRoom("104", RoomType.DELUXE, 4000.0);
        Room room5 = roomManager.addRoom("105", RoomType.DELUXE, 4000.0);

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);
        hotel.addRoom(room5);

        System.out.println("\nAll Rooms Added in the Hotel " + hotel.getName() + ":");
        for (Room r : roomManager.getAllRooms()) {
            System.out.print("Room " + r.getRoomNumber() + " | ");
        }

        Guest guest1 = guestManager.addGuest("+91 8436963080", "Suman");
        Guest guest2 = guestManager.addGuest("+91 9876543210", "Rohit");
        Guest guest3 = guestManager.addGuest("+91 1234567890", "Kohli");

        System.out.print("\n\nGuests Added : ");
        for (Guest g : guestManager.getAllGuests()) {
            System.out.print(g.getName() + " | ");
        }

        String otp1 = guestManager.generateOTP(guest1.getPhoneNumber());
        System.out.println("\n\nOTP for " + guest1.getName() + " : " + otp1);

        boolean isValid = guestManager.validateOTP(guest1.getPhoneNumber(), otp1);
        System.out.println("OTP Validated : " + isValid);

        System.out.println("\nAvailable Double Rooms:");
        List<Room> availableDoubles = roomManager.getAvailableRoomsByType(RoomType.DOUBLE);
        for (Room doublee : availableDoubles) {
            System.out.println("Room " + doublee.getRoomNumber());
        }

        if (!availableDoubles.isEmpty()) {
            Room roomToBook = availableDoubles.get(0);
            LocalDate startDate = LocalDate.of(2025, 6, 10);
            LocalDate endDate = LocalDate.of(2025, 6, 15);
            Reservation reservation = reservationManager.createReservation(guest1, roomToBook, startDate, endDate);
            if (reservation != null) {
                System.out.println("\nBooking Confirmed:");
                System.out.println("Guest: " + guest1.getName() + " | Room: " + roomToBook.getRoomNumber() + " | From: " + startDate + " to " + endDate);
            }
        }

        System.out.println("\nAvailable Single Rooms:");
        List<Room> availableSingles = roomManager.getAvailableRoomsByType(RoomType.SINGLE);
        for (Room single : availableSingles) {
            System.out.println("Room " + single.getRoomNumber());
        }

        if (!availableSingles.isEmpty()) {
            Room roomToBook = availableSingles.get(0);
            LocalDate startDate = LocalDate.of(2025, 6, 11);
            LocalDate endDate = LocalDate.of(2025, 6, 14);
            Reservation reservation2 = reservationManager.createReservation(guest2, roomToBook, startDate, endDate);
            if (reservation2 != null) {
                System.out.println("\nBooking Confirmed:");
                System.out.println("Guest: " + guest2.getName() + " | Room: " + roomToBook.getRoomNumber() + " | From: " + startDate + " to " + endDate);
            }
        }

        System.out.println("\nFinal Available Rooms:");
        for (Room room : roomManager.getAvailableRooms()) {
            System.out.println("Room " + room.getRoomNumber() + " - " + room.getRoomType());
        }

    }
}
