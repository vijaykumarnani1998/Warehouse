package com.vijay.service;

import java.util.List;
import java.util.Map;

import com.vijay.model.User;

public interface UserService {
	public Integer saveUser( User user);
	public List<User> getAllUsers();
	public User getOneUser(Integer id);
	public void deleteUser(Integer id);
	public void updateUser(User user);
	 
	public boolean isUserEmailExist(String email);

	public Map<String,String> getUserTypeVendorIdAndCodeByUserType(String userType);
}
