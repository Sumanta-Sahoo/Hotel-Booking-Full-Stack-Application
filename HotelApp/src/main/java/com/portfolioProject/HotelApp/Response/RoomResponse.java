package com.portfolioProject.HotelApp.Response;

import com.portfolioProject.HotelApp.Model.BookedRoom;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
public class RoomResponse {
    private Long roomId;

    private String roomType;
    private BigDecimal roomPrice;
    private Boolean isBooked;
    @Lob
    private String roomPhoto;
    private List<BookedRoom> roomBookings;

    public RoomResponse(Long roomId, String roomType, BigDecimal roomPrice) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long roomId, String roomType, BigDecimal roomPrice,
                        Boolean isBooked, byte[] roomPhoto, List<BookedRoom> roomBookings) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.roomPhoto = roomPhoto!= null ? Base64.getEncoder().encodeToString(roomPhoto) : null;
        this.roomBookings = roomBookings;
    }
}
