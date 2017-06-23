package com.kshrd.spring.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.spring.model.User;
import com.kshrd.spring.repository.UserRepository;
import com.kshrd.spring.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public boolean save(User user) {
		// TODO: save user to database
		String user_hash = UUID.randomUUID().toString();
		user.setUser_hash(user_hash);
		boolean status = userRepository.save(user);
		if (status) {
			System.out.println("USER ID : " + user.getId());
			System.out.println("User has been inserted!");
		} else {
			System.out.println("User has not been inserted!.");
		}
		return status;
	}

	@Override
	public boolean deleteByUserHash(String user_hash) {
		// TODO: delete user from database by userHash
		boolean status = userRepository.delete(user_hash);
		if (status) {
			System.out.println("User has been deleted!");
		} else {
			System.out.println("User has not been deleted!.");
		}
		return status;
	}

	@Override
	public boolean updateByUserHash(User user) {
		// TODO: update user from database by userHash
		boolean status = userRepository.update(user);
		if (status) {
			System.out.println("User has been updated!");
		} else {
			System.out.println("User has not been updated!");
		}
		return status;
	}

	@Override
	public User findOne(String user_hash) {
		return userRepository.fineOne(user_hash);
	}

}
