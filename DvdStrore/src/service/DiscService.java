/**
 * 
 */
package service;

import java.util.List;
import java.util.Set;

import model.Disc;
import model.Category;
import model.Language;
import dao.DiscDao;
import exception.ApplicationException;

/**
 * @author Anandharaj Angamuthu
 *
 */
public class DiscService {
	
	DiscDao discDao = new DiscDao();
	
    /**
     * <p>
     * Creates a new disc
     * Accepts input from the admin & assign  it to the disc. Insert the disc into database
     * Using insertDisc method
     * </p>
     *
     * @param name
     *        which is the name of the disc
     * @param directorName
     *        which is the name of the director
     * @param actorName
     *        which is the name of the actor
     * @param imageUrl
     *        which is the image of the disc
     * @param stock
     *        which is the number of available disc
     * @param price
     *        which is the cost of the disc
     * 
     * @throws ApplicationException
     *         if there is any error in the given input or error while inserting into databse
     */
    public void createDisc(String name, String directorName, String actorName, String imageUrl, int stock, int price) throws ApplicationException {
    	Disc disc = new Disc(name, directorName, actorName, imageUrl, stock, price);
    	discDao.insertDisc(disc);
    } 
    
    /**
     * <p>
     * Retrieves list of Disc from the database
     * Using listOfDiscs method
     * </p>
     *
     * @return discDao.listOfDiscs()
     *         List of discs available in the database
     */
    public List<Disc> DiscList() throws ApplicationException{
        return discDao.listOfDiscs();
    } 
    
    /**
     * <p>
     * Finds & Retrieves particular disc from the database
     * Using findDiscById method
     * </p>
     *
     * @param id
     *        which is the unique id of the disc
     * @return discDao.findDiscById(id)
     *         disc
     * @throws ApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public Disc findByDiscId(int id) throws ApplicationException {
        return discDao.findDiscById(id);
    } 

    /**
     * <p>
     * Removes particular disc from database
     * Using removeDiscById method
     * </p>
     *
     * @param id
     *        which is the unique id of the disc
     * @throws ApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public void removeByDiscId(int id) throws ApplicationException {
    	discDao.removeDiscById(id);
    }
    
    /**
     * <p>
     * Updates the particular disc detail in the database
     * Using updateDiscById method
     * </p>
     *
     * @param id
     *        which is the unique id of the disc
     * @param name
     *        which will be the new name of the language
       * @param directorName
     *        which is the name of the director
     * @param actorName
     *        which is the name of the actor
     * @param imageUrl
     *        which is the image of the disc
     * @param stock
     *        which is the number of the available disc
     * @param price
     *        which is the cost of the disc
     * @throws ApplicaionException
     *         if there is any error in the given input or error while updating into databse  
     */  
    public void updateByDiscId(int id, String name, String directorName, String actorName, String imageUrl, int stock, int price) throws ApplicationException {
    	Disc disc = discDao.findDiscById(id);   
    	disc.setName(name);
    	disc.setDirectorName(directorName);
    	disc.setActorName(actorName);
    	disc.setImageUrl(imageUrl);
    	disc.setStock(stock);
    	disc.setPrice(price);
    	discDao.updateDiscById(disc);
        
    }	

    /**
     * <p>
     * Allocates category to a set of discs
     * Using allocateCategoryToDiscs method
     * </p>
     *
     * @param discs
     *        Set of discs selected for the category
     * @param category
     *        where the set discs belongs to  
     */
    public void categoryForDiscs(Set<Disc> discs, Category category) {
        for(Disc disc : discs) {
            discDao.allocateCategoryToDiscs(disc, category);
        }
    }
    
    /**
     * <p>
     * Allocates category to a set of discs
     * Using allocateCategoryToDiscs method
     * </p>
     *
     * @param discs
     *        Set of discs selected for the category
     * @param category
     *        where the set discs belongs to  
     */
    public void languageForDiscs(Set<Disc> discs, Language language) {
        for(Disc disc : discs) {
            discDao.allocateLanguageToDiscs(disc, language);
        }
    }

}
