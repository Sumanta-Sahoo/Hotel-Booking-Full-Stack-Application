package com.portfolioProject.HotelApp.Repository;

import com.portfolioProject.HotelApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
