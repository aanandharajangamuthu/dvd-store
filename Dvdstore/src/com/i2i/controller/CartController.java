/**
 * 
 */
package com.i2i.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;

import com.i2i.exception.UserApplicationException;
import com.i2i.model.Cart;
import com.i2i.model.Disc;
import com.i2i.service.CartService;
import com.i2i.service.DiscService;
import com.i2i.model.Language;

/**
 * @author Anandharaj Angamuthu
 *
 */
@Controller
@SessionAttributes({"Cart"})
public class CartController {
	


	@Autowired
	DiscService discService;
	
	@Autowired
	CartService cartservice;
	
	
	static double totalAmount ;
	private static List<Cart> carts = new ArrayList<Cart>();
	@RequestMapping(value = "addProduct",method = RequestMethod.POST)
	public ModelAndView getCart(@RequestParam("id") int id ,@RequestParam("quantity") int quantity) {
		Map<String, Object> model = new HashMap<String, Object>();		
		try {
			Disc disc = discService.findByDiscId(id);			
			double totalprice  = quantity * disc.getPrice();		
			
			Cart cart = new Cart(disc,quantity,totalprice);			
			cartservice.addCart(cart);
			totalAmount += totalprice;
			carts.add(cart);
			model.put("cart",cartservice.getAllCarts());	
			model.put("amt",totalAmount);	
		} catch (UserApplicationException e) {
			System.out.println(e);
		}		
		return new ModelAndView("Cart",model);
	}
	
	
	@RequestMapping("/deleteCart")
	public ModelAndView getCart(@RequestParam("id") int id) {
		Map<String, Object> model = new HashMap<String, Object>();	
		try {			
			Cart cart = cartservice.getCartById(id);	
		    cartservice.removeCartById(id);
		    carts.remove(cart);
		    totalAmount = totalAmount - cart.getTotalPrice();
			model.put("cart", cartservice.getAllCarts());
			model.put("amt",totalAmount);
			System.out.println(model);
		} catch (UserApplicationException e) {
			System.out.println(e);
		}		
		return new ModelAndView("Cart",model);
	}
	
	
	
	@RequestMapping("/cartList")
	public ModelAndView cartList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {				
			model.put("cart", cartservice.getAllCarts());
			model.put("amt",totalAmount);
		} catch (UserApplicationException e) {
			System.out.println(e);		
		}
		return new ModelAndView("Cart", model);
	}
	
	
	@RequestMapping("/buyDisc")
	public ModelAndView buyDisc(@RequestParam("id") int id ) {
		Map<String, Object> model = new HashMap<String, Object>();		
		try {
			Disc disc = discService.findByDiscId(id);
			System.out.println(disc.getName());		
			model.put("BuyDisc", disc);
		} catch (UserApplicationException e) {
			System.out.println(e);		
		}
		return new ModelAndView("buyDisc", model);
	}	
}