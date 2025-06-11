package HotelManagement;

import java.util.*;

public class GuestManager {

    private List<Guest> guestList = new ArrayList<>();
    private Map<String, String> otpMap = new HashMap<>();

    public Guest addGuest(String phoneNumber, String name) {
        Guest guest = new Guest(name, phoneNumber);
        guestList.add(guest);
        return guest;
    }

    public String generateOTP(String phoneNumber) {
        String otp = String.valueOf(new Random().nextInt(9000) + 1000);
        otpMap.put(phoneNumber, otp);
        return otp;
    }

    public boolean validateOTP(String phoneNumber, String otp) {

        if (otpMap.containsKey(phoneNumber)) {
            String storedOtp = otpMap.get(phoneNumber);
            if (storedOtp.equals(otp)) {
                return true;
            }
        }
        return false;
    }

    public List<Guest> getAllGuests() {
        return guestList;
    }
}
