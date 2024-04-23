package com.portfolioProject.HotelApp.Service;

import com.portfolioProject.HotelApp.Model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IRoomService {
    Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws SQLException, IOException;

    List<Room> getAllRoom();

    Optional<Room> getRoomById(Long roomId);

    byte[] getRoomPhotoById(Long roomId) throws SQLException;

    void updateRoom(Long roomId, String roomType, BigDecimal roomPrice, byte[] roomPhoto);
    
    void deleteRoomById(Long roomId);
}
