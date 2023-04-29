package com.vijay.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.model.User;
import com.vijay.repo.UserRepository;
import com.vijay.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository  userRepo;

	@Override
	public Integer saveUser(User user) {
		return userRepo.save(user).getUserId() ;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll() ;
	}

	@Override
	public User getOneUser(Integer id) {
		Optional<User> opt=userRepo.findById(id) ;
		User user=opt.get();
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);

	}

	@Override
	public void updateUser(User user) {
		if(user.getUserId()!=null) {
		userRepo.save(user);
		}
	}

	@Override
	public boolean isUserEmailExist(String email) {
		return userRepo.getUserEmailCount(email)>0;
	}

	@Override
	public Map<String, String> getUserTypeVendorIdAndCodeByUserType(String userType) {
		
		List<Object[]>list=userRepo.getUserTypeVendorIdAndCodeByUserType(userType);
		Map<String,String> map=new LinkedHashMap<>();
		for(Object[] ob:list)
		{
			map.put(ob[0].toString(),ob[1].toString());
		}
		return map;
	}

	
}
