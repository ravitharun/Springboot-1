package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.UserProfileModel;

public interface UserProfileRepo extends JpaRepository<UserProfileModel, Long> {
	UserProfileModel  findByUser_Userid(long user_id);
	
	 
}