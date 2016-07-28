/**
 * 
 */
package com.i2i.model;
import java.util.HashSet;
import java.util.Set;
	/**
	 * @author Anandharaj Angamuthu
	 *
	 */
	public class Language {
		
	    private int id;
	    private String name;
	    private Set<Disc> disc = new HashSet<Disc>();   

	    public Language(){}

	    public Language(String name ){
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
		
		public Set<Disc> getDisc() {
			return disc;
		}

		public void setDisc(Set<Disc> disc) {
			this.disc = disc;
		}

	}


