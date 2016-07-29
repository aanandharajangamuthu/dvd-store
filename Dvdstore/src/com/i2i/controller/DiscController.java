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
=======
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.i2i.exception.UserApplicationException;
import com.i2i.model.Disc;
import com.i2i.service.DiscService;
import com.i2i.model.Language;
import com.i2i.service.LanguageService;

/**
 * @author Anandharaj Angamuthu
 *
 */
@Controller
public class DiscController {

	
	@Autowired
	DiscService discService;
	
	@RequestMapping("/registerDisc")
	public ModelAndView getRegisterForm(@ModelAttribute("disc") Disc disc,
			BindingResult result) {
		System.out.println("Register Form");
		return new ModelAndView("discRegister");
	}
	
	@RequestMapping("/saveDisc")
	public ModelAndView saveUserData(@ModelAttribute("disc") Disc disc,
			BindingResult result) {
		try {
			discService.createDisc(disc);
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
		}
		System.out.println("Save Category Data");
		return new ModelAndView("redirect:/categoryList.html");
	}

	@RequestMapping("/discList")
	public ModelAndView getLanguageList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("discDetails", model);
    }
}

