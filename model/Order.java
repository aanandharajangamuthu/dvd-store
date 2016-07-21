/**
 * 
 */
package model;
import model.User;
/**
 * @author ideas2it
 *
 */
public class Order {
	
	private int id;
	private String payment;
	private String status;
	private User user;
	
    public Order(){}
    
    public Order(int id, String payment, String status, User user) {
    	this.id = id;
    	this.payment = payment;
    	this.status = status;
    	this.user = user;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", payment=" + payment + ", status=" + status + "]";
	}
    
    
}
