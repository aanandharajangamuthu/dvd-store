package com.i2i.model;

import java.util.HashSet;
import java.util.Set;
/**
 * @author Manikandan 
 *
 */
public class User {  

	private int id;
	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private byte isAdmin;
    private Set<PurchaseOrder> 	purchaseOrders = new HashSet<PurchaseOrder> ();
    
    
    public User(String name, String email, String password, String mobileNumber) {	
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;		
	}
	
	public User(){};
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public byte getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}
	

}
