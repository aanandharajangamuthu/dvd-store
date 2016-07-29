package com.i2i.model;

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
	private String directorName;
	private String actorName;
	private byte[] imageUrl;	
	private int price;
	private int stock;
	private Set<Cart> cart = new HashSet<Cart> ();
	 
	public Disc(){};
	
	
	public Disc(Category category, Language language, String name, String directorName, String actorName, byte[] imageUrl, int stock, int price) {
		this.category = category;
		this.language = language;
		this.name = name;
		this.directorName = directorName;
		this.actorName = actorName;
		this.setImageUrl(imageUrl);
		this.stock = stock;
		this.price = price;	
	}

		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	
	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDirectorName() {
		return directorName;
	}
	
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	public String getActorName() {
		return actorName;
	}
	
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}	

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}


	public byte[] getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(byte[] imageUrl) {
		this.imageUrl = imageUrl;
	}

}