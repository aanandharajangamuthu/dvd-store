/**
 * 
 */
package com.i2i.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


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
 * <p> Application controller - Manipulates the Details of DvdStore
 * </p>
 * @author Anandharaj Angamuthu
 * 
 * @modified 2016-08-06 
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
	
	private User currentUser = null;	
	static double totalAmount ;
	private static Set<Cart> carts = new HashSet<Cart> ();
	PurchaseOrder purchaseOrder = null;

	/**
	 * <p>Redirects to the register Page</p>
	 * @param user
	 * @param result
	 * @return registration page
	 */
	@RequestMapping("/register")
	public ModelAndView getRegister(@ModelAttribute("user") User user,
			BindingResult result) {
		
		return new ModelAndView("registration");
	}
	/**
	 * <p> Redirects the user to the userIndex Page after getting login</p> 
	 * @param user
	 * @param result
	 * @return userIndex Page
	 */
	@RequestMapping("/userDetail")
	public ModelAndView getUserDetail(@ModelAttribute("user") User user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currentUser", currentUser);
		return new ModelAndView("userIndex",model);
	}
	/**
	 * </p> Saves the user and redirects to the home page</p> 
	 * @param user
	 * @param result
	 * @return home page
	 */
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
	/**
	 * <P> Retrieves the list of registered Users</p>
	 * @return userDetails page
	 *         contains list of users with details
	 */
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
	/**
	 * </p> Directs to userHome page </p>
	 * @param user
	 * @param result
	 * @return userHome page
	 *         which can be the home page of the cuurentUser
	 */
	@RequestMapping("/user_home")
	public ModelAndView userHomePage(@ModelAttribute("user") User user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currentUser", currentUser);
		return new ModelAndView("userHome",model);
	}
	/**
	 * <p> Directs to login page</p>
	 * @param user
	 * @param result
	 * @return login Page
	 *         Asks details for getting logged in
	 */
	@RequestMapping("/login")
	public ModelAndView getLogin(@ModelAttribute("user") User user,
			BindingResult result) {	
		System.out.println("Entering into login page");
		return new ModelAndView("login");
	}
	/**
	 * </p>Checks whether the User is an Admin or Normal User</p> 
	 * @param user
	 *        user object
	 * @param result
	 * @return index page 
	 *         when the user satisfies the admin condition   
	 * @return UserHoem page
	 *         when the user satisfies the normal user condition
	 * @return tryAgain page
	 *         when both condition fails
	 * 
	 */
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
		    	
		    }
		} catch(UserApplicationException e) {
		    System.out.println("Exception occur");		
		}		
		return new ModelAndView("tryAgain");
	}
	/**
	 * <p> Redirects to home page & clears the cart details when the user gets sign out</p>
	 * @param user
	 * @param result
	 * @return home page
	 *         Starting page of the DvdStore 
	 */
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
	
	/**
	 * <Adds the disc details into the cart, calculates the total price & reduces the quantity of disc</p>
	 * @param id
	 *        by which the cart to be inserted into the database
	 * @param stock
	 *        which is the available quantity of disc
	 * @param quantity
	 *        which can be the quantity of disc required by the user
	 * @return Cart page
	 */
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
	
	/**
	 * <p> Deletes the cart based on user need & restores the available stock of disc</p>
	 * @param id
	 * @param discId
	 * @param quantity
	 * @return Cart page
	 *         contains the cart details
	 */
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

   /**
    * <p> Retrieves the list of carts</p> 
    * @return Cart page
    *         contains the cart details
    */
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
	
	/**
	 * <p> Displays the particular disc detail chosen by the user to buy</p>
	 * @param id
	 *        which can be the id of the disc chosen by the user
	 * @return buyDisc Page
	 *        contains disc details chosen by the user
	 */
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
	
	
	/**
	 * <p> Redirects to login page when the user tries to purchase without login</P>
	 * @param user
	 *        User object 
	 * @param result
	 * @return login page
	 *         contains the login details
	 */
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
	
	/**
	 * <p> Redirects to puchase login or purchase order page based on login status of user</p>
	 * @param user
	 *        User object
	 * @param result
	 * @return purchaseOrder page
	 *         when the user already logged in & chosen the disc to purchase
	 * @return purchaselogin page
	 *         when the user not logged in but chosen the disc to purchase
	 */
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
	
	/**
	 * <p>Redirects to Success page when the user confirms the purchase order, clears the cart
	 * details added by the user & subtracts the required quantity of disc from the available quantity
	 * of disc
	 * </P>
	 * @return Success page
	 *         shows Success message
	 */
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
	
	/**
	 * <p> Registers the new category by the admin</p> 
	 * @param category
	 *        Category object to be added into the database
	 * @param result
	 * @return categoryRegister page
	 *         Asks for category to be registered
	 */
	@RequestMapping("/registerCategory")
	public ModelAndView getRegisterForm(@ModelAttribute("category") Category category,
			BindingResult result) {
		System.out.println("Register Form");
		return new ModelAndView("categoryRegister");
	}
	
	/**
	 * <p> Saves the category details into the database & redirects to categoryDetails Page
	 * @param category
	 *        Category object
	 * @param result
	 * @return CategoryDetails Page 
	 *         shows the list of categories
	 */
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

	/**
	 * <p>Retrieves the list of categories from the database & directs to categoryDetails page</p> 
	 * @return categoryDetails Page
	 *         shows the list of categories
	 */
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

	
	// Language Controller
	/**
	 * <p> Registers the new language by the admin</p> 
	 * @param language
	 *        Language object to be added into the database
	 * @param result
	 * @return languageRegister page
	 *         ask for language to be registered
	 */	
	@RequestMapping("/registerLanguage")
	public ModelAndView getRegisterForm(@ModelAttribute("language") Language language,
			BindingResult result) {
		System.out.println("Register Form");
		return new ModelAndView("languageRegister");
	}
	
	/**
	 * <p> Saves the language details into the database & redirects to categoryDetails Page
	 * @param language
	 *        Language object
	 * @param result
	 * @return LangaueDetails Page
	 *         shows list of languages 
	 */
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

	/**
	 * <p>Retrieves the list of languages from the database & directs to categoryDetails page</p> 
	 * @return languageDetails Page
	 *         shows list of languages
	 */
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


	// Disc Controller		
	
	
	/**
	 * <p>
     * This method used to redirect to discRegister page.    
     * <p>
	 * @param disc should not be null
	 * @param result
	 * @return ModelAndView 
	 *          It returns discRegister page.
	 */
	@RequestMapping("/registerDisc")
	public ModelAndView getRegisterForm(@ModelAttribute("disc") Disc disc,
			BindingResult result) {		
		return new ModelAndView("discRegister");
	}	
	
	
	/**
	 * <p>
     * This method used to store new disc.Disc object get from the modelAttribute. 
     * <p>
	 * @param disc object should not be null.
	 * @param result
	 * @return ModelAndView
	 *         returns redirect to discList.
	 */
	@RequestMapping("/saveDisc")
	public ModelAndView saveUserData(@ModelAttribute("disc") Disc disc,
			BindingResult result) {
		try {
			discService.createDisc(disc);
		} catch (UserApplicationException e) {
			System.out.println(e);			
		}		
		return new ModelAndView("redirect:/discList.html");
	}	
	
	/**
	 *  <p>
     * This method used to get all discs and shows in disDetails page. 
     * <p> 
	 * @return ModelAndView
	 *          returns discDetails page. 
	 */
	@RequestMapping("/discList")
	public ModelAndView getdiscList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			System.out.println("Entering into disc List");
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("discDetails", model);
    }
	
	
	
	/**
	 * <p>
     * This method used to shows the page for search disc . 
     * <p>
	 * @param disc object should not be null
	 * @param result
	 * @return ModelAndView 
	 *         returns to findDisc page.
	 */
	@RequestMapping("/showDisc")
	public ModelAndView searchDisc(@ModelAttribute("disc") Disc disc,
			BindingResult result) { 	
		return new ModelAndView("findDisc");
	}		
	
	/**
	 * <p>
     * This method used to retrieve the particular disc from discList with the use of disc object. 
     * <p>
	 * @param disc object should not be null
	 * @param result
	 * @return ModelAndView
	 *         returns to viewDisc page
	 */
	@RequestMapping("/discFind")
	public ModelAndView retrieveDisc(@ModelAttribute("disc") Disc disc,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc",discService.findByDiscId(disc.getId()));
		} catch (UserApplicationException e) {			
			System.out.println(e);	
		}
		System.out.println("Save Disc Data");
		return new ModelAndView("viewDisc",model);
	}	
	
	/**
	 * <p>
     * This method used to show all movies. 
     * <p>
	 * @return ModelAndView
	 *         returns model to movies page.
	 */
	@RequestMapping("/movieList")
	public ModelAndView getMovies() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			System.out.println("Entering into Movie List");
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("movies", model);
    }	
	
	/**
	 * <p>
     * This method used to show only tamil movies from movies list. 
     * <p>
	 * @return ModelAndView
	 *         returns model to tamil page.
	 */
	@RequestMapping("/tamilMovies")
	public ModelAndView getTamilMovies() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("tamil", model);
    }
	
	
	/**
	 * <p>
     * This method used to show only english movies from movies list. 
     * <p> 
	 * @return ModelAndView
	 *         returns model to english page.
	 */
	@RequestMapping("/englishMovies")
	public ModelAndView getEnglishMovies() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("english", model);
    }
	
	/**
	 * <p>
     * This method used to show only hindi movies from movies list. 
     * <p> 
	 * @return ModelAndView
	 *          returns model to hindi page. 
	 */
	@RequestMapping("/hindiMovies")
	public ModelAndView getHindiMovies() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("hindi", model);
    }	
	
	/**
	 * <p>
     * This method used to show songs list. 
     * <p>
	 * @return ModelAndView
	 *         returns model to songs page. 
	 */
	@RequestMapping("/songList")
	public ModelAndView getSongs() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {			
			System.out.println(e);	
		}
		return new ModelAndView("songs", model);
    }
	
	
	/**
	 * <p>
     * This method used to list only tamil songs list. 
     * <p>
	 * @return ModelAndView
	 *         returns model to tamilSong page. 
	 */
	@RequestMapping("/tamilSongs")
	public ModelAndView getTamilSongs() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("tamilSong", model);
    }
	
	/**
	 * <p>
     * This method used to list only tamil songs list. 
     * <p> 
	 * @return ModelAndView 
	 *         returns model to hindiSong page. 
	 */
	@RequestMapping("/hindiSongs")
	public ModelAndView getHindiSongs() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("hindiSong", model);
    }	

	/**
     * <p>
     * This method used to list only english songs list. 
     * <p>     
	 * @return ModelAndView
	 *         returns model to englishSong page.
	 */
	@RequestMapping("/englishSongs")
	public ModelAndView getEnglishSongs() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("englishSong", model);
    }	

	/**
	 * <p>
     * This method used to list all langauge shows. 
     * <p> 
	 * @return ModelAndView 
	 *         returns model to shows page.
	 */
	@RequestMapping("/showList")
	public ModelAndView getShows() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());
		} catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("shows", model);
    }
	
	/**
	 * <p>
     * This method used to list the tamil tv shows. 
     * <p> 
	 * @return ModelAndView 
	 *         returns model to tamilTvShows page.
	 */
	@RequestMapping("/tamilShows")
	public ModelAndView getTamilShows() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());			 
		}catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("tamilTvShows", model);
    }
	
	
	/**
	 * <p>
     * This method used to list the english shows. 
     * <p>
	 * @return ModelAndView 
	 *         returns model to english_Shows page.
	 */
	@RequestMapping("/englishShows")
	public ModelAndView getEnglishShows() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());			 
		}catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("english_Shows", model);
    }  
	
	/**
	 * <p>
     * This method used to list the hindi shows. 
     * <p>
	 * @return ModelAndView
	 *         returns model to hindi_Shows page.
	 */
	@RequestMapping("/hindiShows")
	public ModelAndView getHindiShows() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("disc", discService.discList());			 
		}catch (UserApplicationException e) {
			System.out.println(e);	
		}
		return new ModelAndView("hindi_Shows", model);
    }	
	
	/**
	 * <p>
     * This method used to redirect to languageAndDisc page for assign language to disc. 
     * <p>
	 * @return ModelAndView
	 *         returns to languageAndDisc page.
	 */
	@RequestMapping("/assignLanguage")
	public ModelAndView showLanguage() { 	
		return new ModelAndView("languageAndDisc");
	}	
	
	/**
	 * <p>
     * This method used to assign language to disc. 
     * <p>
	 * @param discId should be integer,Used to get Disc object.
	 * @param languageId should be integer, Used to get Language object
	 * @return ModelAndView
	 *         returns model to languageAndDisc page.
	 */
	@RequestMapping(value="/allocate",method=RequestMethod.POST)
	public ModelAndView allocateDisc(@RequestParam("discId") int discId, 
			            @RequestParam("languageId") int languageId) {
		Disc disc;
		Language language;
		try {		
		    disc = discService.findByDiscId(discId);
		    language = languageService.findByLanguageId(languageId);
		    Set<Disc> discs = new HashSet<Disc>();
		    discs.add(disc);
			discService.languageForDiscs(discs,language);
		} catch (UserApplicationException e) {		
			System.out.println(e);			
		}		
		return new ModelAndView("assigned");
	}
	
	/**
	 * <p>
     * This method used to redirect categoryAndDisc page for assign category to disc. 
     * <p> 
	 * @return ModelAndView
	 *         returns to categoryAndDisc page.
	 */
	@RequestMapping("/assignCategory")
	public ModelAndView showCategory() { 	
		return new ModelAndView("categoryAndDisc");
	}		
	
	/**
	 * <p>
     * This method used to assign category to Disc and shows assigned success message page. 
     * <p> 
	 * @param discId should be integer,Used to get Disc object.
	 * @param categoryId should be integer, Used to get Category object
	 * @return ModelAndView 
	 *         returns to assigned page.
	 */
	@RequestMapping(value="/allocateCategory",method=RequestMethod.POST)
	public ModelAndView allocateCategory(@RequestParam("discId") int discId, 
			            @RequestParam("categoryId") int categoryId) {
		Disc disc;
		Category category;
		try {
		    disc = discService.findByDiscId(discId);
		    category = categoryService.findByCategoryId(categoryId);
		    Set<Disc> discs = new HashSet<Disc>();
		    discs.add(disc);
			discService.categoryForDiscs(discs,category);
		} catch (UserApplicationException e) {
			System.out.println(e);		
		}		
		return new ModelAndView("assigned");
	}
		
}
	
	

	