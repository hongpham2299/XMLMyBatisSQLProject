package reservationSystem.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reservationSystem.MyBatisUtil;
import reservationSystem.mappers.RoomTypeMapper;
import reservationSystem.models.RoomType;

import java.util.List;

public class RoomTypeService {

    Logger logger = LogManager.getLogger(RoomTypeService.class.getName());

    public RoomType selectRoomTypeById(int id){
        try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
            RoomTypeMapper roomTypeMapper = session.getMapper(RoomTypeMapper.class);
            return roomTypeMapper.selectRoomTypeById(id);
        }
    }

    public void insertRoomType(RoomType roomType){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        RoomTypeMapper roomTypeMapper = session.getMapper(RoomTypeMapper.class);
        roomTypeMapper.insertRoomType(roomType);
        logger.info("Room type id: " + roomType.getId() + " -> Insert room type successfully");
        session.close();
    }

    public void updateRoomType(RoomType roomType){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        RoomTypeMapper roomTypeMapper = session.getMapper(RoomTypeMapper.class);
        roomTypeMapper.updateRoomType(roomType);
        logger.info("Room type id: " + roomType.getId() + " -> Updated successfully");
        session.close();
    }

    public void deleteRoomType(int id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        RoomTypeMapper roomTypeMapper = session.getMapper(RoomTypeMapper.class);
        roomTypeMapper.deleteRoomType(id);
        logger.info("Room type id: " + id + " -> Deleted successfully");
        session.close();
    }

    public List<RoomType> selectAllRoomTypes(){
        try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
            RoomTypeMapper roomTypeMapper = session.getMapper(RoomTypeMapper.class);
            return roomTypeMapper.selectAllRoomTypes();
        }
    }
}
