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

import com.i2i.service.DiscService;
import com.i2i.model.Disc;
import com.i2i.exception.UserApplicationException;


/**
 * @author ideas2it
 *
 */
@Controller
public class DiscController {

	
	private DiscService discService = new DiscService();
	
	@RequestMapping("/disc")
	public ModelAndView getDiscPage(@ModelAttribute("disc") Disc disc,
			BindingResult result) {		
		return new ModelAndView("Disc");
	}
  
	@RequestMapping("/saveDisc")
	public ModelAndView saveDiscData(@ModelAttribute("disc") Disc disc,
			BindingResult result) {
		try {			
			discService.createDisc(disc);
			System.out.println("Save User Data");
		} catch(UserApplicationException e) {
		    System.out.println("Exception occur");		
		}		
		return new ModelAndView("redirect:/register.html");
	}	
	

	
}
	
	

	