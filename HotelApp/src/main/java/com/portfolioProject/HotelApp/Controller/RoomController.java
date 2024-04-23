package com.portfolioProject.HotelApp.Controller;

import com.portfolioProject.HotelApp.Model.Room;
import com.portfolioProject.HotelApp.Response.RoomResponse;
import com.portfolioProject.HotelApp.Service.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

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
}
