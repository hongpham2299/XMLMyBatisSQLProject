package reservationSystem.mappers;

import reservationSystem.models.RoomType;

import java.util.List;

public interface RoomTypeMapper {

    RoomType selectRoomTypeById(int id);
    void insertRoomType(RoomType roomType);
    void updateRoomType(RoomType roomType);
    void deleteRoomType(int id);
    List<RoomType> selectAllRoomTypes();
}
