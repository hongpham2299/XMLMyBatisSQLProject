package reservationSystem.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reservationSystem.MyBatisUtil;
import reservationSystem.mappers.GuestMapper;
import reservationSystem.models.Guest;

import java.util.List;

public class GuestService {

    Logger logger = LogManager.getLogger(GuestService.class.getName());

    public Guest selectGuestById(int id){
        try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GuestMapper guestMapper = session.getMapper(GuestMapper.class);
            return guestMapper.selectGuestById(id);
        }
    }

    public void insertGuest(Guest guest){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        GuestMapper guestMapper = session.getMapper(GuestMapper.class);
        guestMapper.insertGuest(guest);
        logger.info("Insert guest successfully below: \n" + guest);
        session.close();
    }

    public void updateGuest(Guest guest){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        GuestMapper guestMapper = session.getMapper(GuestMapper.class);
        guestMapper.updateGuest(guest);
        logger.info("Guest id: " + guest.getId() + "-> Updated Successfully!!!");
        session.close();
    }

    public void deleteGuest(int id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        GuestMapper guestMapper = session.getMapper(GuestMapper.class);
        guestMapper.deleteGuest(id);
        logger.info("Guest id: " + id + "-> Delete Successfully!!!!");
        session.close();
    }

    public List<Guest> selectAllGuests(){
        try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GuestMapper guestMapper = session.getMapper(GuestMapper.class);
            return guestMapper.selectAllGuests();
        }
    }
}
