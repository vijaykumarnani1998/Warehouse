package com.vijay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vijay.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
    @Query("SELECT COUNT(userEmail) FROM User WHERE userEmail=:email")
	  Integer getUserEmailCount(String email);
    
    @Query("SELECt userId,userCode FROM User where userType=:userType")
   List<Object[]> getUserTypeVendorIdAndCodeByUserType(String userType);
}
