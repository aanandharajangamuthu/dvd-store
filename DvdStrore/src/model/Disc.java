package model;

/**
 * <p> Disc class contains attributes include id, category, language, cart, name, 
 * directorName, actorName, imageUrl, stock, price
 * </p>  
 *
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @created 2016-07-25
 *
 */

public class Disc {
	private int id;
	private Category category;
	private Language language;
	private Cart cart;
	private String name;
	private String directorName;
	private String actorName;
	private String imageUrl;
	private int stock;
	private int price;
	
	public Disc() {}
	
	public Disc(String name,  String directorName, String actorName, String imageUrl, int stock, int price) {
		this.name = name;
		this.directorName = directorName;
		this.actorName = actorName;
		this.imageUrl = imageUrl;
		this.stock = stock;
		this.price = price;	
	}
	
	
	
	// Getters and Setters
	
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
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}		

}
