package reservationSystem.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reservationSystem.MyBatisUtil;
import reservationSystem.mappers.ReservationMapper;
import reservationSystem.models.Reservation;

import java.util.List;

public class ReservationService {

    Logger logger = LogManager.getLogger(ReservationService.class.getName());

    public Reservation selectReservationById(int id){
        try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
           ReservationMapper reservationMapper = session.getMapper(ReservationMapper.class);
           return reservationMapper.selectReservationById(id);
        }
    }

    public List<Reservation> selectAllReservations(){
        try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ReservationMapper reservationMapper = session.getMapper(ReservationMapper.class);
            return reservationMapper.selectAllReservations();
        }
    }

    public void insertReservation(Reservation reservation){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        ReservationMapper reservationMapper = session.getMapper(ReservationMapper.class);
        reservationMapper.insertReservation(reservation);
        logger.info("Reservation id: " + reservation.getId() + " -> Insert reservation successfully");
        session.close();
    }

    public void updateReservation(Reservation reservation){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        ReservationMapper reservationMapper = session.getMapper(ReservationMapper.class);
        reservationMapper.updateReservation(reservation);
        logger.info("Reservation id: " + reservation.getId() + " -> Updated successfully!!!!");
        session.close();
    }

    public void deleteReservation(int id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        ReservationMapper reservationMapper = session.getMapper(ReservationMapper.class);
        reservationMapper.deleteReservation(id);
        logger.info("Reservation id: " + id + " -> Deleted successfully!!!!");
        session.close();
    }
}
