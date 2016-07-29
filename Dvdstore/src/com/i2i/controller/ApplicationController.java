/**
 * 
 */
package com.i2i.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.service.UserService;
import com.i2i.model.User;
import com.i2i.exception.UserApplicationException;


/**
 * @author ideas2it
 *
 */
@Controller
public class ApplicationController {
	
	
	private UserService userService = new UserService();
	
	@RequestMapping("/home")
	public ModelAndView homePage(@ModelAttribute("user") User user,
			BindingResult result) {
		
		return new ModelAndView("home");
	}
	
	@RequestMapping("/register")
	public ModelAndView getRegister(@ModelAttribute("user") User user,
			BindingResult result) {
		
		return new ModelAndView("registration");
	}
  
	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		try {
		    userService.addUser(user);
			System.out.println("Save User Data");
		} catch(UserApplicationException e) {
		    System.out.println("Exception occur");		
		}
		
		return new ModelAndView("redirect:/userList.html");
	}
	
	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("user", userService.getAllUsers());			
		} catch (UserApplicationException e) {
			System.out.println(e);			
		}
		return new ModelAndView("UserDetails", model);
	}
}
	
	

	