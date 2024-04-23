package com.portfolioProject.HotelApp.Service;

import com.portfolioProject.HotelApp.Model.Room;
import com.portfolioProject.HotelApp.Repository.IRoomRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@NotNull
public class RoomServiceImpl implements IRoomService{

    private final IRoomRepository roomRepository;

    @Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws SQLException, IOException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        if(file!=null){
            byte[] photoByte = file.getBytes();
            Blob photoBlob = new SerialBlob(photoByte);
            room.setRoomPhoto(photoBlob);
        }
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomById(Long roomId) {
        return Optional.of(roomRepository.findById(roomId).get());
    }

    @Override
    public byte[] getRoomPhotoById(Long roomId) throws SQLException {
        return new byte[0];
    }

    @Override
    public void updateRoom(Long roomId, String roomType, BigDecimal roomPrice, byte[] roomPhoto) {

    }

    @Override
    public void deleteRoomById(Long roomId) {

    }
}