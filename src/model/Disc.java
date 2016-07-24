package model;

import java.util.HashSet;
import java.util.Set;
/**
 * @author manikandan 
 *
 */
public class Disc {
	private int id;
	private Category category ;
	private Language language;
	private String name;
	private String actorName;
	private String directorName;
	private int price;
	private boolean stock;
	private Set<Cart> cart = new HashSet<Cart> ();
	 
	public Disc(){};
		
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
	
	public String getActorName() {
		return actorName;
	}
	
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	
	public String getDirectorName() {
		return directorName;
	}
	
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public boolean isStock() {
		return stock;
	}
	
	public void setStock(boolean stock) {
		this.stock = stock;
	}	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
}
