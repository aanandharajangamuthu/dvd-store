package model;

import java.util.Set;
import java.util.HashSet;
import model.PurchaseOrder;

/**
 * <p> User class contains attributes include id, name, email, password,
 * mobileNumber, isAdmin
 * </p>  
 *
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @created 2016-07-25
 *
 */

public class User {
	
	 private int id;
	 private String name;
	 private String email;
	 private String password;
	 private String mobileNumber;
	 private boolean isAdmin; 
	 Set<PurchaseOrder> purchaseOrders = new HashSet<PurchaseOrder>();
	 
// Getters and Setters
	 
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

	public Set<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}
	
}
