package reservationSystem.mappers;

import reservationSystem.models.GuestAccount;

import java.util.List;

public interface GuestAccountMapper {

    GuestAccount selectGuestAccountById(int id);
    void insertGuestAccount(GuestAccount guestAccount);
    void updateGuestAccount(GuestAccount guestAccount);
    void deleteGuestAccount(int id);
    List<GuestAccount> selectAllGuestAccounts();
}
