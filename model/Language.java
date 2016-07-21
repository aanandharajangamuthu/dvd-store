/**
 * 
 */
package model;
import java.util.Set;
import java.util.HashSet;

/**
 * @author ideas2it
 *
 */
public class Language {
	
    private int id;
    private String language;
    private Set<Disc> discs = new HashSet<Disc>;   

public Language(){}

public Language(int id, String language ){
	this.id = id;
	this.language = language;
}
//Getter and Setter

private int getId() {
	return id;
}

private String getLanguage() {
	return language;
}

private Set<Disc> getDiscs() {
	return discs;
}
private void setId(int id) {
	this.id = id;
}

private void setLanguage(String language) {
	this.language = language;
}

private void setDiscs(Set<Disc> discs) {
	this.discs = discs;
}
}