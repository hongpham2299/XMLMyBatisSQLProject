package reservationSystem.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reservationSystem.MyBatisUtil;
import reservationSystem.mappers.GuestAccountMapper;
import reservationSystem.models.GuestAccount;
import java.util.List;

public class GuestAccountService {

    Logger logger = LogManager.getLogger(GuestAccountService.class.getName());

    public GuestAccount selectGuestAccountById(int id){
        try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GuestAccountMapper guestAccountMapper = session.getMapper(GuestAccountMapper.class);
            return guestAccountMapper.selectGuestAccountById(id);
        }
    }

    public void insertGuestAccount(GuestAccount guestAccount){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        GuestAccountMapper guestAccountMapper = session.getMapper(GuestAccountMapper.class);
        guestAccountMapper.insertGuestAccount(guestAccount);
        logger.info("Guest account id: " + guestAccount.getId() + " -> Inserted Successfully!!!");
        session.close();
    }

    public void updateGuestAccount(GuestAccount guestAccount){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        GuestAccountMapper guestAccountMapper = session.getMapper(GuestAccountMapper.class);
        guestAccountMapper.updateGuestAccount(guestAccount);
        logger.info("Guest account id: " + guestAccount.getId() + "-> Updated Successfully!!!");
        session.close();
    }

    public void deleteGuestAccount(int id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        GuestAccountMapper guestAccountMapper = session.getMapper(GuestAccountMapper.class);
        guestAccountMapper.deleteGuestAccount(id);
        logger.info("Guest account id: " + id + "-> Deleted successfully!!!");
        session.close();
    }

    public List<GuestAccount> selectAllGuestAccounts(){
        try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GuestAccountMapper guestAccountMapper = session.getMapper(GuestAccountMapper.class);
            return guestAccountMapper.selectAllGuestAccounts();
        }
    }
}
