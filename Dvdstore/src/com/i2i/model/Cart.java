package com.i2i.model;
/**
 * <p>Cart class contains attributes include id, order
 * disc, quantity, totalPrice
 * </p>  
 * @author Anandharaj Angamuhtu
 *
 */
public class Cart {
	
	private int id;
	private PurchaseOrder purchaseOrder;
	private Disc disc;
	private int quantity;
	private double totalPrice;
	
	public Cart(){}
	
	public Cart(PurchaseOrder purchaseOrder, Disc disc, int quantity, double totalPrice) {
		this.purchaseOrder = purchaseOrder;
		this.disc = disc;
		this.quantity = quantity;
		this.totalPrice  = totalPrice;
	}

   // Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Disc getDisc() {
		return disc;
	}

	public void setDisc(Disc disc) {
		this.disc = disc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
}
