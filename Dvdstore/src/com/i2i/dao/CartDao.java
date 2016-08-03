/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.exception.UserApplicationException;
import com.i2i.model.Cart;
import com.i2i.model.Disc;
import com.i2i.model.User;

/**
 * <h1>CartDao</h1>
 *    This class handles the hibernate operations for different Cart methods.
 *    
 * @author Manikandan
 *
 */
@Repository
public class CartDao extends GenericDao {
	
	
	
	public void insertCart(Cart cart) throws UserApplicationException {
		Session session = checkSessionFactory();
    	Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cart); 
            transaction.commit();
        } catch (HibernateException e) {
            throw new UserApplicationException("unable to insert Cart",e);
        } finally {
            closeSession(session);
        }      
	}
	
	/**
     * <p>
     * This method used to retrieve all cart list from the database
     * </p>     
     * @return returns the list of all cart.  
     * @throws UserApplicationException
     *         If there is error in returning all cart through session object.  
     */	
	public List<Cart> retrieveAllCarts() throws UserApplicationException {        
        Session session = checkSessionFactory();     
        try {         
            return session.createQuery("FROM Cart").list();           
        } finally {
            closeSession(session);
        }        
    }
	
	/**
     * <p>
     * This method used to find particular cart by cartId from database
     * </p>
     * @param cartId 
     *        cartId should be type of int.  
     * @return returns the Cart.
     * @throws UserApplicationException
     *        If there is error in returning Cart object.    
     */	
	public Cart findCartById(int cartId) throws UserApplicationException {       
        Session session = checkSessionFactory();
        try {            
            return (Cart)session.get(Cart.class, cartId);           
        } catch (HibernateException e) {            
            throw new UserApplicationException("Could not find for this cartId "+cartId, e);
        } finally {
            closeSession(session);        
        }       
    }
	
	/**
     * <p>
     * This method used to delete particular Cart by cartId from database
     * </p>
     * @param cartId 
     *        used to find Cart object,it should be type of int  
     * Cart object can be deleted using session object.
     * @throws UserApplicationException
     *         If there is error in deleting Cart object.    
     */	
	public void deleteCartById(int cartId) throws UserApplicationException {
		Session session = checkSessionFactory();
        Transaction transaction = null;               
        try {              
            transaction = session.beginTransaction();                                         
            Cart cart = (Cart)session.get(Cart.class, cartId);    
            session.delete(cart); 
            transaction.commit();                 
        } catch (HibernateException e) {            
           throw new UserApplicationException("Could not delete for this cartId "+cartId, e);
        } finally {
           closeSession(session);
        }    
    
	}
	
	
	public void insertDiscToCart(Disc disc, Cart cart) throws UserApplicationException {
		Session session = checkSessionFactory();
        Transaction transaction = null;          
        try {
        	transaction = session.beginTransaction();                                         
        	cart.setDisc(disc);
        	session.update(cart); 
        	transaction.commit();
        } catch (HibernateException e) {            
            throw new UserApplicationException("Could not Add for this Disc to Cart "+disc.getName(), e);
         } finally {
            closeSession(session);
         } 
	}
}