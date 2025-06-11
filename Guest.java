package HotelManagement;

import java.util.UUID;

public class Guest {

    private UUID id;
    private String name;
    private String phoneNumber;

    public Guest(String name, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

}
