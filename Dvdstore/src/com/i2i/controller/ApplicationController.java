/**
 * 
 */
package com.i2i.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.service.CartService;
import com.i2i.service.CategoryService;
import com.i2i.service.DiscService;
import com.i2i.service.LanguageService;
import com.i2i.service.PurchaseOrderService;
import com.i2i.service.UserService;
import com.i2i.model.Cart;
import com.i2i.model.Category;
import com.i2i.model.Disc;
import com.i2i.model.Language;
import com.i2i.model.PurchaseOrder;
import com.i2i.model.User;
import com.i2i.exception.UserApplicationException;


/**
 * @author ideas2it
 *
 */
@Controller
public class ApplicationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	DiscService discService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	PurchaseOrderService purchaseOrderService;	
	
    @Autowired
	CategoryService categoryService;
    
	@Autowired
	LanguageService languageService;
	
	private static List<Disc> discs = new ArrayList<Disc> ();
	
	private User currentUser = null;
	
	@RequestMapping("/register")
	public ModelAndView getRegister(@ModelAttribute("user") User user,
			BindingResult result) {
		
		return new ModelAndView("registration");
	}
	
	@RequestMapping("/userDetail")
	public ModelAndView getUserDetail(@ModelAttribute("user") User user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currentUser", currentUser);
		return new ModelAndView("userIndex",model);
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
		
		return new ModelAndView("home");
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
	
	@RequestMapping("/user_home")
	public ModelAndView userHomePage(@ModelAttribute("user") User user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currentUser", currentUser);
		return new ModelAndView("userHome",model);
	}
	
	@RequestMapping("/login")
	public ModelAndView getLogin(@ModelAttribute("user") User user,
			BindingResult result) {	
		System.out.println("Entering into login page");
		return new ModelAndView("login");
	}
	
	@RequestMapping("/checkUser")
	public ModelAndView checkAdmin(@ModelAttribute("user") User user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
		    User loginUser  =  userService.findUser(user);	
		    currentUser = loginUser;
		    model.put("currentUser", currentUser);
		    if(null != loginUser && loginUser.getIsAdmin() == 1) {
		    	System.out.println("Admin page");
		    	return new ModelAndView("index");
		    } else if(null != loginUser){
		    	System.out.println("User page");
		    	if(carts.isEmpty()) {
		    		System.out.println("entering into user home");
		    		return new ModelAndView("userHome",model);
		    	} else {
		    		System.out.println("entering into purchase page");
		    		return new ModelAndView("redirect:/purchaseDisc.html");
		    	}
		    	//loginUser.getName();
		    	//return new ModelAndView("userHome",model);
		    }
		} catch(UserApplicationException e) {
		    System.out.println("Exception occur");		
		}		
		return new ModelAndView("tryAgain");
	}
	
	@RequestMapping("/signOut")
	public ModelAndView logOut(@ModelAttribute("user") User user,
			BindingResult result) {	
		totalAmount = 0;
		currentUser = null;
		for(Cart cart : carts) {
		    Disc disc = cart.getDisc();
			int stock = disc.getStock() + cart.getQuantity();			 
			try {
			    discService.updateByDiscStock(disc,stock);
			} catch (UserApplicationException e) {
				System.out.println(e);		
			} 
			 
		}
		carts.clear();
		System.out.println("Entering into Log out");
		return new ModelAndView("home");
	}
	
	
// Cart Controller
		
	
	static double totalAmount ;	
	private static Set<Cart> carts = new HashSet<Cart> ();	
	@RequestMapping(value = "addProduct",method = RequestMethod.POST)
	public ModelAndView getCart(@RequestParam("id") int id , @RequestParam("stock") int stock, 
			@RequestParam("quantity") int quantity) {
		Map<String, Object> model = new HashMap<String, Object>();		
		try {
			stock = stock - quantity;
			Disc disc = discService.findByDiscId(id);			
			double totalPrice  = quantity * disc.getPrice();
			discService.updateByDiscStock(disc,stock);
			Cart cart = new Cart(disc,quantity,totalPrice);			
			cartService.addCart(cart);	
			carts.add(cart);
			totalAmount += totalPrice;		
			model.put("cart",carts);
			model.put("totalAmount",totalAmount);				
		} catch (UserApplicationException e) {
			System.out.println(e);
		}		
		return new ModelAndView("Cart",model);
	}
	
	@RequestMapping("/deleteCart")
	public ModelAndView deleteCart(@RequestParam("id") int id, @RequestParam("discId") int discId ,@RequestParam("quantity") int quantity) {
		Map<String, Object> model = new HashMap<String, Object>();	
		try {	
			System.out.println(quantity);
			Disc disc = discService.findByDiscId(discId);			
			Cart cart = cartService.getCartById(id);	
			System.out.println("Disc "+disc);
			totalAmount = totalAmount - cart.getTotalPrice();			
			int stock = disc.getStock() + quantity;
			discService.updateByDiscStock(disc,stock);			
			System.out.println("before Set Collections"+carts);			
			Iterator<Cart> cartIterator = carts.iterator();
			while (cartIterator.hasNext()) {
				cart = cartIterator.next();
			    if (cart.getId() ==  id) {
			    	cartIterator.remove();
			    }
			}		    
		    System.out.println("after remove Set Collections"+carts);
		    cartService.removeCartById(id);			
			model.put("cart", carts);	
			model.put("totalAmount",totalAmount);
		} catch (UserApplicationException e) {
			System.out.println(e);
		}		
		return new ModelAndView("Cart",model);
	}	


	@RequestMapping("/cartList")
	public ModelAndView cartList() {
		Map<String, Object> model = new HashMap<String, Object>();
		double amount = 0;
		for(Cart cart:carts) {				
			amount += cart.getTotalPrice();         
		}
		model.put("cart", carts);			
		model.put("totalAmount", amount);
		return new ModelAndView("Cart", model);
	}
	
	
	@RequestMapping("/buyDisc")
	public ModelAndView buyDisc(@RequestParam("id") int id ) {
		Map<String, Object> model = new HashMap<String, Object>();		
		try {
			Disc disc = discService.findByDiscId(id);			
			model.put("BuyDisc", disc);
		} catch (UserApplicationException e) {
			System.out.println(e);		
		}
		return new ModelAndView("buyDisc", model);
	}
	
	
	
	@RequestMapping("/purchase")
	public ModelAndView getPurchase(@ModelAttribute("user") User user, BindingResult result) {
		if(currentUser != null) {
			System.out.println("User already logged in");
			return new ModelAndView("redirect:/purchaseDisc.html");
		}
		else {
		return new ModelAndView("redirect:/login.html");
	    }
	}
	
    PurchaseOrder purchaseOrder = null;
	@RequestMapping("/purchaseDisc")
	public ModelAndView checkUser(@ModelAttribute("user") User user, BindingResult result) {
		System.out.println("PurchaseDisc");

		Map<String, Object> model = new HashMap<String, Object>();		
		try {
			if(currentUser == null ) {
		    User newUser  =  userService.findUser(user);	
		        if(null != newUser) {	
		    	    System.out.println("newUser");
		    	    purchaseOrder = new PurchaseOrder(carts,newUser);	
		    	    System.out.println(purchaseOrder.getId());
		    	    model.put("totalAmount", totalAmount);	
		    	    model.put("cart", purchaseOrder.getCart());
		    	    model.put("order", purchaseOrder);
		            return new ModelAndView("PurchaseOrder",model);
		        } else {
		    		return new ModelAndView("PurchaseLogin");

		        }
		        
			} else {
				purchaseOrder = new PurchaseOrder(carts,currentUser);	
	    	    System.out.println("currentUser");
	    	    System.out.println(purchaseOrder.getId());
	    	    model.put("totalAmount", totalAmount);	
	    	    model.put("cart", purchaseOrder.getCart());
	    	    model.put("order", purchaseOrder);
	            return new ModelAndView("PurchaseOrder",model);
			}
		    	
		} catch(UserApplicationException e) {
		    System.out.println("Exception occur");		
		}
		return new ModelAndView("PurchaseLogin");
	}	
	
	
	@RequestMapping("/success")
	public ModelAndView conformPurchase() {		
		 System.out.println("Sucess");	
		 totalAmount = 0;
		 Map<String, Object> model = new HashMap<String, Object>();	
		 model.put("currentUser", currentUser);
		try {								
			purchaseOrderService.add(purchaseOrder);
			for(Cart cart:purchaseOrder.getCart()) {				
				cartService.updateCart(cart, purchaseOrder);	           
			}
			carts.clear();
		} catch (UserApplicationException e) {
			System.out.println(e);			
		}
		return new ModelAndView("Success",model);
	}
// Category Controller
		
	@RequestMapping("/registerCategory")
	public ModelAndView getRegisterForm(@ModelAttribute("category") Category category,
			BindingResult result) {
		System.out.println("Register Form");
		return new ModelAndView("categoryRegister");
	}
	
	@RequestMapping("/saveCategory")
	public ModelAndView saveUserData(@ModelAttribute("category") Category category,
			BindingResult result) {
		try {
			categoryService.createCategory(category);
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
		}
		System.out.println("Save Category Data");
		return new ModelAndView("redirect:/categoryList.html");
	}

	@RequestMapping("/categoryList")
	public ModelAndView getCategoryList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("category", categoryService.categoryList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("categoryDetails", model);
    }
	

	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}*/

	// Language Controller
	
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

	// Disc Controller		
	
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
			System.out.println("Entering into disc List");
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
			System.out.println("Entering into Movie List");
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
	
	@RequestMapping("/showList")
	public ModelAndView getShows() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("shows", model);
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
	
	@RequestMapping("/englishShows")
	public ModelAndView getEnglishShows() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());	
			 
		}catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("english_Shows", model);
    }

	@RequestMapping("/hindiShows")
	public ModelAndView getHindiShows() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());	
			 
		}catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("hindi_Shows", model);
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
	
	

	