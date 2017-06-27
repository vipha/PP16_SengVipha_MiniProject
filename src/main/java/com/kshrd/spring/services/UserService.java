package com.kshrd.spring.services;

import java.util.List;

import com.kshrd.spring.model.Dashboard;
import com.kshrd.spring.model.User;


public interface UserService {
	User findOne(String user_hash);
	public List<User> findAll();
	public int findMale();
	public List<Dashboard> countGender();
	public boolean save(User user);
	public boolean deleteByUserHash(String userHash);
	public boolean updateByUserHash(User user);
	
}
