package com.portfolioProject.HotelApp.Controller;

import com.portfolioProject.HotelApp.Model.Room;
import com.portfolioProject.HotelApp.Response.RoomResponse;
import com.portfolioProject.HotelApp.Service.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {
    private final RoomServiceImpl roomService;

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo")MultipartFile file,
            @RequestParam("roomType")String roomType,
            @RequestParam("roomPrice")BigDecimal roomPrice) throws IOException, SQLException {

        Room savedRoom = roomService.addNewRoom(file, roomType, roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getRoomId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomResponse>> getAllRoom() throws SQLException{
        List<Room> listOfRoom = roomService.getAllRoom();
        List<RoomResponse> roomResponses = new ArrayList<>();
        for(Room room : listOfRoom){
            RoomResponse roomResponse = new RoomResponse(room.getRoomId(),room.getRoomType(),room.getRoomPrice());
            roomResponses.add(roomResponse);
        }
        return ResponseEntity.ok(roomResponses);
    }
    @DeleteMapping("/del/{roomId}")
    public ResponseEntity<String> deleteRoomById(@PathVariable Long roomId){
        roomService.deleteRoomById(roomId);
        return ResponseEntity.ok("Deleteion Succesfully Done");
    }
}
