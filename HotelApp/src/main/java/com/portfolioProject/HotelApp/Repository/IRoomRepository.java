package com.portfolioProject.HotelApp.Repository;

import com.portfolioProject.HotelApp.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Long> {
}
