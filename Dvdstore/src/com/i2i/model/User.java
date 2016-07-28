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
	private boolean isAdmin;
    private Set<PurchaseOrder> 	purchaseOrder = new HashSet<PurchaseOrder> ();
    
    
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	

}
