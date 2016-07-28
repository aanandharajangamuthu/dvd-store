/**
 * 
 */
package com.i2i.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.src.service.UserService;
import com.i2i.model.User;
import com.i2i.exception.UserApplicationException;


/**
 * @author ideas2it
 *
 */
@Controller
@RequestMapping("/register")
public class ApplicationController {
	
	
	/*private UserService userService = new UserService();
	
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		try {
		userService.addUser("admin","admin@ideas2it","admin","9042608658");
		System.out.println("Save User Data");
		} catch(UserApplicationException e) {
			System.out.println("Exception occur");		
		}
		return new ModelAndView("Register");
	}	*/

	@RequestMapping("/register")
	public ModelAndView welcome(@ModelAttribute("user") User user,
			BindingResult result) {
		return new ModelAndView("registration");	
	}
}
	
	

	