package model;

public class Disc {
	private int id;
	private int categoryId;
	private int languageId;
	private String name;
	private String actorName;
	private String directorName;
	private int price;
	private boolean stock;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

}
