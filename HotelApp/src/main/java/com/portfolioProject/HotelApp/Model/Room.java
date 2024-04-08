package com.portfolioProject.HotelApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String roomType;
    private BigDecimal roomPrice;
    private Boolean isBooked;
    @Lob
    private Blob roomPhoto;
    private List<BookedRoom> roomBookings;

    public Room(){
        this.roomBookings = new ArrayList<>();
    }

    public void addBookings(BookedRoom booking){
        if(roomBookings == null) {
            roomBookings = new ArrayList<>();
        }
        roomBookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        booking.setBookingConfirmationCode(RandomStringUtils.randomNumeric(10));
    }
}
