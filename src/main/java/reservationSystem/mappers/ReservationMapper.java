package reservationSystem.mappers;

import reservationSystem.models.Reservation;

import java.util.List;

public interface ReservationMapper {

    Reservation selectReservationById(int id);
    List<Reservation> selectAllReservations();
    void insertReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(int id);

}
