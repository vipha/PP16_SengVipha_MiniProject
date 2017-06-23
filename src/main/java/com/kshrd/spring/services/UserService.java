package com.kshrd.spring.services;

import java.util.List;

import com.kshrd.spring.model.User;


public interface UserService {
	User findOne(String user_hash);
	public List<User> findAll();
	public boolean save(User user);
	public boolean deleteByUserHash(String userHash);
	public boolean updateByUserHash(User user);
	
}
