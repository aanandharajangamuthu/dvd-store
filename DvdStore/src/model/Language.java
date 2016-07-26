/**
 * 
 */
package model;
import java.util.Set;
import java.util.HashSet;


/**
 * <p> Language class contains attributes include id, name
 * discs
 * </p>  
 *
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @created 2016-07-25
 *
 */
public class Language {
	
    private int id;
    private String name;
    private Set<Disc> discs = new HashSet<Disc>();
    

    public Language(){}
    
    public Language(String name) {
    	this.name = name;
    }

    public Language(String name, Set<Disc> discs ) {
	this.name = name;
	this.discs = discs;
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

	public Set<Disc> getDisc() {
		return discs;
	}

	public void setDisc(Set<Disc> discs) {
		this.discs = discs;
	}

}
