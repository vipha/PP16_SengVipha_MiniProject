package com.kshrd.spring.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kshrd.spring.model.User;
import com.kshrd.spring.services.UserService;

@Controller
public class UserController {
	private UserService userservice;
	List<User> users;
	
	@Autowired
	public UserController(UserService userservice) {
		this.userservice=userservice;
	}
	
	@RequestMapping("/user/userlist")
	public String list(ModelMap model) {
		model.addAttribute("user", userservice.findAll());
		return "user-list";
	}
	
	@RequestMapping(value = {"/user", "/"})
	public String homepage(ModelMap model) {
		users = userservice.findAll();
		model.addAttribute("user", users);

		return "/dashboard";
	}
	
	@RequestMapping("/user/userrole")
	public String userrole(ModelMap model) {
		users = userservice.findAll();
		model.addAttribute("user", users);

		return "/role-cu";
	}
	
	@RequestMapping("/user/userroledata")
	public String userroledata(ModelMap model) {
		users = userservice.findAll();
		model.addAttribute("user", users);

		return "/role-list";
	}
	
	@RequestMapping(value = "/user/remove")
	public String remove(@RequestParam("user_hash") String user_hash) {
		if (userservice.deleteByUserHash(user_hash)) {
			System.out.println("success");
		}
		return "redirect:/user/userlist";
	}
	
	@RequestMapping(value = "/user/add")
	public String add(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("addStatus", true);
		return "/user-cu";
	}
	
	@RequestMapping(value = "/user/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("user") User user, ModelMap model) {
		model.addAttribute("user", userservice.save(user));
		return "redirect:/user/userlist";
	}

	@PostMapping(value = "/user/update")
	public String update(@ModelAttribute("user") User user) {
		if (userservice.updateByUserHash(user)) {
			System.out.println("success!");
		}
		return "redirect:/user/userlist";
	}
	
	@GetMapping(value = "/user/edit")
	public String edit(ModelMap model, @RequestParam("user_hash") String userhash) {
		User user=userservice.findOne(userhash);
		model.addAttribute("user", user);
		model.addAttribute("addStatus", false);
		return "/user-cu";
	}
}
