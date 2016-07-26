package model;

import java.util.Set;
/**
 * <p>Category class contains attributes include id, name
 * discs
 * </p>  
 *
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @created 2016-07-25
 *
 */

import java.util.HashSet;

public class Category {
	
	private int id;
	private String name;
	private Set<Disc> discs = new HashSet<Disc>(); 
	
	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category(String name, Set<Disc> discs) {
		this.name = name;
		this.discs = discs;
	}
	
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

	public Set<Disc> getDiscs() {
		return discs;
	}

	public void setDiscs(Set<Disc> discs) {
		this.discs = discs;
	}

}
