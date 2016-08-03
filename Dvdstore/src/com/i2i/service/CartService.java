/**
 * 
 */
package com.i2i.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.CartDao;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.Cart;
import com.i2i.model.Disc;

/**
 * <h1>UserService</h1>
 * This class calls the CartDao class.
 * And gets output returning from CartDao class.  
 * 
 * @author Manikandan
 *
 */
@Service
public class CartService {
	
	@Autowired
    private CartDao cartDao;
    
    
    
    public void addCart(Cart cart)  throws UserApplicationException  {
    	cartDao.insertCart(cart);
    }
	
    /**
     * <p>
     * This method used to get all carts list through cartDao      
     * </p>                
     * @return the carts list.  
     * @throws UserApplicationException
     *         If there is failed or interrupted get carts list operation.               
     */ 
    public List<Cart> getAllCarts() throws UserApplicationException {
    	return cartDao.retrieveAllCarts();
    }
    
    /**
     * <p>
     * This method used to view particular cart by cartId. 
     * </p>
     * @param cartId
     *        Used to find Cart,and it should be type of int
     * @return Cart 
     *         returns the Cart details.
     * @throws UserApplicationException 
     *         If there is failed or interrupted view Cart operation.                        
     */    
    public Cart getCartById(int cartId) throws UserApplicationException  {       
        return cartDao.findCartById(cartId);       
    }
    
    /**
     * <p>
     * This method used to remove particular cart based on the cartId. 
     * </p>
     * @param cartId
     *        Used to remove a cart from the cart list and it should be type of int     
     * @throws UserApplicationException 
     *        If there is failed or interrupted remove cart operation.                      
     */	
    public void removeCartById(int cartId) throws UserApplicationException  {       
    	cartDao.deleteCartById(cartId);       
    }
    
    public void addToCart(Disc disc, Cart cart) throws UserApplicationException {
    	cartDao.insertDiscToCart(disc ,cart);
    } 
    


}