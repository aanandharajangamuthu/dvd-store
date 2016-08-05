package com.i2i.model;

import java.util.HashSet;
import java.util.Set;
/**
 * @author Anandharaj Angamuthu
 *
 */
public class PurchaseOrder {
		
    private int id;
	private String payment;
	private String status;
	private User user;
	private Set<Cart> cart = new HashSet<Cart> (); 
		
	public PurchaseOrder(){};
	    
    public PurchaseOrder(String payment, String status, User user) {
	    this.payment = payment;
	    this.status = status;
	    this.user = user;
    }
    public PurchaseOrder(Set<Cart> cart,User user) {
    	this.user = user;
    	this.cart = cart;
    }    

	// Getter and Setter	    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}	
	    
}
