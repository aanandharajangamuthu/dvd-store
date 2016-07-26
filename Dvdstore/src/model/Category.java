package model;

import java.util.HashSet;
import java.util.Set;
/**
 * @author manikandan 
 *
 */
public class Category {
	private int id;
	private String name;	
	private Set<Disc> discs = new HashSet<Disc>();   
	
	public Category(){};
	
	
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

	public Set<Disc> getDisc() {
		return discs;
	}

	public void setDisc(Set<Disc> discs) {
		this.discs = discs;
	}

}
