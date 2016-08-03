/**
 * 
 */
package com.i2i.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.i2i.exception.UserApplicationException;
import com.i2i.model.Disc;
import com.i2i.service.DiscService;
import com.i2i.model.Language;
import com.i2i.service.LanguageService;
import com.i2i.model.Category;
import com.i2i.service.CategoryService;

/**
 * @author Anandharaj Angamuthu
 *
 */
@Controller
public class DiscController {


	
	@Autowired
	DiscService discService;
	
	@Autowired
	LanguageService languageService;

	@Autowired
	CategoryService categoryService;

	
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
		System.out.println("Save Disc Data");
		return new ModelAndView("redirect:/discList.html");
	}

	@RequestMapping("/discList")
	public ModelAndView getdiscList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("discDetails", model);
    }
	
	@RequestMapping("/showDisc")
	public ModelAndView searchDisc(@ModelAttribute("disc") Disc disc,
			BindingResult result) { 	
		return new ModelAndView("findDisc");
	}
	
	
	@RequestMapping("/discFind")
	public ModelAndView retrieveDisc(@ModelAttribute("disc") Disc disc,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc",discService.findByDiscId(disc.getId()));
		} catch (UserApplicationException e) {
			
			e.getMessage();
		}
		System.out.println("Save Disc Data");
		return new ModelAndView("viewDisc",model);
	}
		
	@RequestMapping("/movieList")
	public ModelAndView getMovies() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("movies", model);
    }
	
	@RequestMapping("/tamilMovies")
	public ModelAndView getTamilMovies() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("tamil", model);
    }
	
	@RequestMapping("/englishMovies")
	public ModelAndView getEnglishMovies() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("english", model);
    }

	@RequestMapping("/hindiMovies")
	public ModelAndView getHindiMovies() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("hindi", model);
    }
	
	@RequestMapping("/songList")
	public ModelAndView getSongs() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("songs", model);
    }
	
	@RequestMapping("/tamilSongs")
	public ModelAndView getTamilSongs() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("tamilSong", model);
    }
	
	@RequestMapping("/hindiSongs")
	public ModelAndView getHindiSongs() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("hindiSong", model);
    }

	@RequestMapping("/englishSongs")
	public ModelAndView getEnglishSongs() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("englishSong", model);
    }
	
	@RequestMapping("/tamilShows")
	public ModelAndView getTamilShows() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());	
			 
		}catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("tamilTvShows", model);
    }
	
	/*public List<Disc> getAllDisc(){
		List<Disc> discs = new ArrayList<Disc>();
		try {
			discs = discService.discList();
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return discs;				
	}*/


	
	@RequestMapping("/assignLanguage")
	public ModelAndView showLanguage() { 	
		return new ModelAndView("languageAndDisc");
	}

	
	@RequestMapping(value="/allocate",method=RequestMethod.POST)
	public ModelAndView allocateDisc(@RequestParam("discId") int discId, 
			            @RequestParam("languageId") int languageId) {
		Disc disc;
		Language language;
		try {
		//Map<String, Object> model = new HashMap<String, Object>();
		    disc = discService.findByDiscId(discId);
		    language = languageService.findByLanguageId(languageId);
		    Set<Disc> discs = new HashSet<Disc>();
		    discs.add(disc);
			discService.languageForDiscs(discs,language);
		} catch (UserApplicationException e) {
			
			e.getMessage();
		}
		System.out.println("Save Disc Data");
		return new ModelAndView("assigned");
	}
	
	@RequestMapping("/assignCategory")
	public ModelAndView showCategory() { 	
		return new ModelAndView("categoryAndDisc");
	}

	
	@RequestMapping(value="/allocateCategory",method=RequestMethod.POST)
	public ModelAndView allocateCategory(@RequestParam("discId") int discId, 
			            @RequestParam("categoryId") int categoryId) {
		Disc disc;
		Category category;
		try {
		//Map<String, Object> model = new HashMap<String, Object>();
		    disc = discService.findByDiscId(discId);
		    category = categoryService.findByCategoryId(categoryId);
		    Set<Disc> discs = new HashSet<Disc>();
		    discs.add(disc);
			discService.categoryForDiscs(discs,category);
		} catch (UserApplicationException e) {
			
			e.getMessage();
		}
		System.out.println("Save Disc Data");
		return new ModelAndView("assigned");
	}
	
   
}
