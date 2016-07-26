/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import model.Language;
import exception.UserApplicationException;


/**
 * 
 * <p>LanguageDao --- Subclass of GenericDao
 * Manipulates the languages in the database
 * </p>
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @created 2016-07-25
 */
public class LanguageDao extends GenericDao {
	
    /**
     * Insert the language into the database
     * @param language
     *        Language object contains its attributes
     * @exception HibernateException
     *      
     */
    public void insertLanguage(Language language) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
    	try {
            transaction = session.beginTransaction();
            session.save(language); 
            transaction.commit();
        } catch (HibernateException e) {
            throw new UserApplicationException("Unable to insert language",e);
        } finally {
            closeSession(session);
        }        
    }
    
    /** 
     * Retrieves the list of languages available in the database
     * @return languages
     *         List of languages  
     * @throws UserApplicationException 
     *         if there is an error occurs while retrieve
     */
    public List<Language> listOfLanguages() throws UserApplicationException {
    	Session session = checkSessionFactory();
    	try {
            List<Language> languages= session.createQuery("FROM Language").list();
        return languages;        
        } catch(HibernateException e) {
            throw new UserApplicationException("Unable to list the languages",e);
        } finally {
            closeSession(session); 
        } 
    }
    
    /**
     * Finds & retrieves the particular language detail from the database
     * @param id
     *        by which the language can be retrieved 
     * @return language
     *         Language object contains its attributes
     * @throws UserApplicationException 
     *         if there is any error occurs while retrieving  
     */
    public Language findLanguageById(int id) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	try {
            Language language = (Language)session.get(Language.class, id);
            return language;
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to find language having id: "+id);
        } finally {
            closeSession(session);
        }
    }
    
    /**
     * Removes the particular language from the database
     * @param id
     *        by which the language can be removed
     * @throws UserApplicationException
     *         if there is any error occurs while removing
     */
    public void removeLanguageById(int id) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
    	try{
            transaction = session.beginTransaction();
            Language language = (Language)session.get(Language.class, id);
            session.delete(language);  
            transaction.commit();
        } catch(HibernateException e) { 
            throw new UserApplicationException("unable to remove language having id: "+id);
        } catch(IllegalArgumentException e) {
            throw new UserApplicationException("Null entity, Try again by entering valid Id. problem with entered id: "+id);
        } finally {
            closeSession(session); 
        }
    }
        
    /**
     * Updates the particular language in the database
     * @param language
     *        Language object contains its attributes
     * @throws UserApplicationException
     *         if there is any error occurs while updating
     * 
     */
    public void updateLanguageById(Language language) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
    	try {
            transaction = session.beginTransaction();
            session.update(language); 
            transaction.commit();
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to update employee "+language); 
        } catch(IllegalArgumentException e) {
        	throw new UserApplicationException("Null Entity, Try again by Entering valid id. Problem with entered id: "+language.getId());
        } finally {
            closeSession(session); 
        }
    }
        
}
