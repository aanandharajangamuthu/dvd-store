package model;
import model.Order;
import model.Disc;

public class Cart {
	
	private int id;
	private Order order;
	private Disc disc;
	private int quantity;
	private long totalPrice;
	
	public Cart(){}
	
	public Cart(int id, Order order, Disc disc, int quantity, lont totalPrice) {
		this.id = id;
		this.order = order;
		this.disc = disc;
		this.quantity = quantity;
		this.totalPrice  = totalPrice;
	}

// Getter and Setter

	public int getId() {
		return id;
	}

	public void setId(int idd) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	

	
}
