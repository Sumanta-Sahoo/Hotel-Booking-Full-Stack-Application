package com.portfolioProject.HotelApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private Room room;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookedRoomId;

    @Column(name = "check_in")
    private LocalDate checkInDate;
    @Column(name = "check_out")
    private LocalDate checkOutDate;
    @Column(name = "name")
    private String guestFullName;
    @Column(name = "email")
    private String guestEmail;
    @Column(name = "adult")
    private Integer noOfAdults;
    @Column(name = "children")
    private Integer noOfChildren;
    @Column(name = "total_guest")
    private Integer totalNoOfGuests;
    @Column(name = "booking_code")
    private String bookingConfirmationCode;

    public void calculateTotalNoOfGuests(){
        this.totalNoOfGuests = this.noOfAdults+this.noOfChildren;
    }
    public void setNoOfAdults(Integer noOfAdult){
        noOfAdults = noOfAdult;
        calculateTotalNoOfGuests();
    }
    public void setNoOfChildren(Integer noOfChild){
        noOfChildren = noOfChild;
        calculateTotalNoOfGuests();
    }
    public void setBookingConfirmationCode(String code){
        this.bookingConfirmationCode = code;
    }

}
