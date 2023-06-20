package reservationSystem.mappers;

import reservationSystem.models.Guest;

import java.util.List;

public interface GuestMapper {

    Guest selectGuestById(int id);
    void insertGuest(Guest guest);
    void updateGuest(Guest guest);
    void deleteGuest(int id);
    List<Guest> selectAllGuests();
}
