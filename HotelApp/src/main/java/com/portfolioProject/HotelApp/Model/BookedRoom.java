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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookedRoomId;

    @Temporal(TemporalType.DATE)
    private LocalDate checkInDate;
    @Temporal(TemporalType.DATE)
    private LocalDate checkOutDate;
    @Basic
    private String guestFullName;
    @Basic
    private String guestEmail;
    @Basic
    private Integer noOfAdults;
    @Basic
    private Integer noOfChildren;
    @Basic
    private Integer totalNoOfGuests;
    @Basic
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private Room room;

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
