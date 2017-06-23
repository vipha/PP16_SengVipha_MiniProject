package com.kshrd.spring.controller.rest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController // = @Contoller + @ResponseBody
//@RequestMapping("/user")
public class UserRestController {

//	private UserService userService;
//	
//	/**
//	 * ..........??????
//	 * @param userService
//	 */
//	@Autowired
//	public UserRestController(UserService userService) {
//		this.userService = userService;
//	}
//	
//	/**
//	 * ????????????????
//	 * @return
//	 */
//	@RequestMapping
//	public List<User> findAll(){
//		return userService.findAll();
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/save")
//	public boolean save(){
//		return userService.save(new User());
//	}
//	
//	/**
//	 * 
//	 * @param userHash
//	 * @return
//	 */
//	@RequestMapping("/delete/{user_hash}")
//	public boolean delete(@PathVariable("user_hash") String userHash){
//		return userService.deleteByUserHash(userHash);
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/update")
//	public boolean update(){
//		User user = new User();
//		user.setUsername("DADA");
//		user.setUser_hash("");
//		return userService.updateByUserHash(user);
//	}
	
	
}
