/**
 * 
 */
package com.i2i.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.model.Language;
import com.i2i.service.LanguageService;
import com.i2i.exception.UserApplicationException;


/**
 * <p>
 * Category Controller - Manipulates the categories in the database
 * </p>
 * @author Anandharaj Angamuthu
 *
 * @modified 2016-07-28
 */
@Controller
public class LanguageController {
	
    @Autowired
	LanguageService languageService;
	
	@RequestMapping("/registerLanguage")
	public ModelAndView getRegisterForm(@ModelAttribute("language") Language language,
			BindingResult result) {
		System.out.println("Register Form");
		return new ModelAndView("languageRegister");
	}
	
	@RequestMapping("/saveLanguage")
	public ModelAndView saveUserData(@ModelAttribute("language") Language language,
			BindingResult result) {
		try {
			languageService.createLanguage(language);
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
		}
		System.out.println("Save Language Data");
		return new ModelAndView("redirect:/languageList.html");
	}

	@RequestMapping("/languageList")
	public ModelAndView getLanguageList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("language", languageService.languageList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("languageDetails", model);
    }
	

	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}*/
	
}
