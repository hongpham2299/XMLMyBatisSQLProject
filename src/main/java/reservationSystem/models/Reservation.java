package reservationSystem.models;

import java.time.LocalDate;
import java.util.List;

public class Reservation {

    private int id;
    private String confirmationNumber;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private int numOfGuest;
    private RoomType roomType;
    private List<Guest> guests;

    public Reservation(){}

    public Reservation(int id, String confirmationNumber, LocalDate arrivalDate, LocalDate departureDate,
                       int numOfGuest, RoomType roomType, List<Guest> guests) {
        this.id = id;
        this.confirmationNumber = confirmationNumber;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.numOfGuest = numOfGuest;
        this.roomType = roomType;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public int getNumOfGuest() {
        return numOfGuest;
    }

    public void setNumOfGuest(int numOfGuest) {
        this.numOfGuest = numOfGuest;
    }

    @Override
    public String toString() {
        return "Reservation \n"
                + "id: " + id + "\n"
                + "Confirmation Number: " + confirmationNumber + "\n"
                + "Arrival Date: " + arrivalDate + "\n"
                + "Departure Date: " + departureDate + "\n"
                + "Number of Guest: " + numOfGuest + "\n"
                + "Room Type: " + roomType + "\n"
                + "Guest: " + guests + "\n-------\n";
    }
}
