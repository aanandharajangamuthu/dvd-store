/**
 * 
 */
package model;

import java.sql.Date;
import java.util.Set;
import java.util.HashSet;

/**
 * @author Anandharaj Angamuthu
 *
 */
public class Language {
	
	private int id;
    private String name;
    private Set<Disc> discs = new HashSet<Disc>; 
    private String createdBy;
    private Date createdAt;
    private String modifiedBy;
    private Date modifiedAt;
    

    public Language(){}

    public Language(int id, String name ){
	this.id = id;
	this.name = name;
    }
    
//Getter and Setter

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Time getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Time getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Time modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt + "]";
	}

}