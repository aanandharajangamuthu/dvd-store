/**
 * 
 */
package com.i2i.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.Language;
import com.i2i.dao.LanguageDao;
import com.i2i.exception.UserApplicationException;

/**
 * @author Anandharaj Angamuthu
 *
 */
@Service
public class LanguageService {
	
	@Autowired
	private LanguageDao languageDao;
	
    /**
     * <p>
     * Creates a new language
     * Accepts input from the user & assign  it to the language. Insert the language into database
     * Using insertCategory method
     * </p>
     *
     * @param name
     *        which is the name of the category
     * 
     * @throws UserApplicationException
     *         if there is any error in the given input or error while inserting into databse
     */
    public void createLanguage(Language language) throws UserApplicationException {
    	//Language language = new Language(name);
    	languageDao.insertLanguage(language);
    } 
    
    /**
     * <p>
     * Retrieves list of Language from the database
     * Using listOfLanguages method
     * </p>
     *
     * @return languageDao.listOfLanguages()
     *         List of languages available in the database
     */
    public List<Language> languageList() throws UserApplicationException{
        return languageDao.listOfLanguages();
    } 
    
    /**
     * <p>
     * Finds & Retrieves particular language from the database
     * Using findCategoryById method
     * </p>
     *
     * @param id
     *        which is the unique id of the language
     * @return categoryDao.findCategoryById(id)
     *         category
     * @throws UserApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public Language findByLanguageId(int id) throws UserApplicationException {
        return languageDao.findLanguageById(id);
    } 

    /**
     * <p>
     * Removes particular language from database
     * Using removeLanguageById method
     * </p>
     *
     * @param id
     *        which is the unique id of the language
     * @throws UserApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public void removeByLanguageId(int id) throws UserApplicationException {
    	languageDao.removeLanguageById(id);
    }
    
    /**
     * <p>
     * Updates the particular language detail in the database
     * Using updateLanguageById method
     * </p>
     *
     * @param id
     *        which is the unique id of the language
     * @param name
     *        which will be the new name of the language
     * @throws ApplicaionException
     *         if there is any error in the given input or error while updating into databse  
     */  
    public void updateByLanguageId(int id, String name) throws UserApplicationException {
    	Language language = languageDao.findLanguageById(id);
        language.setName(name);   
        languageDao.updateLanguageById(language);
    }	


}