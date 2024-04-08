package com.portfolioProject.HotelApp.Response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoomResponse {

    private Long bookedRoomId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private String guestEmail;
    private Integer noOfAdults;
    private Integer noOfChildren;
    private Integer totalNoOfGuests;
    private String bookingConfirmationCode;

    private BookedRoomResponse bookingResponse;

    public BookedRoomResponse(Long bookedRoomId, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfirmationCode) {
        this.bookedRoomId = bookedRoomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
