package reservationSystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reservationSystem.models.Guest;
import reservationSystem.models.GuestAccount;
import reservationSystem.models.Reservation;
import reservationSystem.models.RoomType;
import reservationSystem.services.GuestAccountService;
import reservationSystem.services.GuestService;
import reservationSystem.services.ReservationService;
import reservationSystem.services.RoomTypeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        This project below demonstrates how to work with mybatis XML mapping:
        One-to-One relationship: one guest can have only one guest account (Guest & GuestAccount models)
        One-to-Many relationship: one room type can be associated with one or more records in reservation table (RoomType & Reservation models)
        Many-to-Many relationship: one reservation can have many guests, and one guest can have many reservations (Guest & Reservation models)
         */

        Logger logger = LogManager.getLogger(Main.class.getName());

        ReservationService reservationService = new ReservationService();

        /*
            Select reservation by id: Handling the complex inner custom object & collection by
            using XML mapping containing collection and association
         */
        logger.info("Select reservation by Id with inner join 3 tables below \n" + reservationService.selectReservationById(1));

        /*
            Insert new reservation: Handling the complex inner custom object & collection by
            using XML mapping containing collection and association
         */
        RoomType roomTypeForResId7 = new RoomType();
        roomTypeForResId7.setId(2);

        Guest setGuestIdForResId7 = new Guest();
        setGuestIdForResId7.setId(6);

        List<Guest> guestIdForRes7 = new ArrayList<>();
        guestIdForRes7.add(setGuestIdForResId7);

        Reservation reservation7 = new Reservation(7, "TMS-813245980", LocalDate.of(2023, 7, 12),
                LocalDate.of(2023, 7, 15), 1, roomTypeForResId7, guestIdForRes7);

        reservationService.insertReservation(reservation7);

        /*
            Update reservation: Handling the complex inner custom object & collection by
            using XML mapping containing collection and association
         */
        Guest setGuestUpdate = new Guest();
        setGuestUpdate.setId(4);

        List<Guest> updateGuestIdForRes6 = new ArrayList<>();
        updateGuestIdForRes6.add(setGuestUpdate);

        RoomType updateRoomTypeForRes6 = new RoomType();
        updateRoomTypeForRes6.setId(6);

        Reservation updateRes = reservationService.selectReservationById(6);
        updateRes.setConfirmationNumber("TMS-5623841");
        updateRes.setArrivalDate(LocalDate.of(2023, 10, 7));
        updateRes.setDepartureDate(LocalDate.of(2023, 10, 10));
        updateRes.setNumOfGuest(1);
        updateRes.setGuests(updateGuestIdForRes6);
        updateRes.setRoomType(updateRoomTypeForRes6);

        reservationService.updateReservation(updateRes);

        //Delete reservation
        reservationService.deleteReservation(7);

        /*
            Select all reservations: Handling the complex inner custom object & collection by
            using XML mapping containing collection and association
         */
        logger.info("Select all reservations by left join 3 tables below \n" + reservationService.selectAllReservations());

        logger.info("----------");

        RoomTypeService roomTypeService = new RoomTypeService();

        //Select room type by id
        logger.info("Select room type by id below: \n" + roomTypeService.selectRoomTypeById(5));

        //Insert new room type
        RoomType roomType = new RoomType(9, "LUX", "Luxury Suite");
        roomTypeService.insertRoomType(roomType);

        //Update room type
        RoomType roomTypeUpdate = roomTypeService.selectRoomTypeById(8);
        roomTypeUpdate.setName("PSUITE");
        roomTypeUpdate.setDescription("Presidential Suite King");

        roomTypeService.updateRoomType(roomTypeUpdate);

        //Delete room type
        roomTypeService.deleteRoomType(9);

        //Select all room type
        logger.info("Select all room types below: \n" + roomTypeService.selectAllRoomTypes());

        logger.info("----------");

        GuestService guestService = new GuestService();

        //Select guest by id
        logger.info("Select guest by id below: \n" + guestService.selectGuestById(3));

        //Insert new guest
        Guest marioDiaz = new Guest(7, "Mario", "Diaz", "mariodiaz123@verizon.net", "(813) 546-1485");
        guestService.insertGuest(marioDiaz);

        //Update guest
        Guest guestId6 = guestService.selectGuestById(6);
        guestId6.setFirstName("Mai");
        guestId6.setLastName("Nguyen");
        guestId6.setEmail("mainguyen123@outlook.com");
        guestId6.setPhone("(302) 478-0266");

        guestService.updateGuest(guestId6);

        //Delete guest
        guestService.deleteGuest(7);

        //Select all guest
        logger.info("Select all guest below: \n" + guestService.selectAllGuests());

        logger.info("----------");

        GuestAccountService guestAccountService = new GuestAccountService();

        //Select guest account by id
        logger.info("Select guest account by id with inner join of 2 tables (Guest & Guest Account) below \n"
                            + guestAccountService.selectGuestAccountById(2));

        //Insert guest account
        Guest guestIdForAccount4 = new Guest();
        guestIdForAccount4.setId(3);

        GuestAccount guestAccountId4 = new GuestAccount(4, "stevenJ1809$", "steven1820", guestIdForAccount4);
        guestAccountService.insertGuestAccount(guestAccountId4);

        //Update guest account
        Guest updateGuestIdForAcc1 = new Guest();
        updateGuestIdForAcc1.setId(6);

        GuestAccount updateGuestAccId1 = guestAccountService.selectGuestAccountById(1);
        updateGuestAccId1.setUsername("maiNg1822");
        updateGuestAccId1.setPassword("nguyenMai1822!#");
        updateGuestAccId1.setGuest(updateGuestIdForAcc1);

        guestAccountService.updateGuestAccount(updateGuestAccId1);

        //Delete guest account
        guestAccountService.deleteGuestAccount(4);

        //Select all guest accounts
        logger.info("Select all guest accounts by left join of 2 tables (Guest & Guest Account) below \n"
                            + guestAccountService.selectAllGuestAccounts());

    }
}
