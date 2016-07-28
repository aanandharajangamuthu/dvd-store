/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import com.i2i.model.Category;
import com.i2i.model.Language;
import com.i2i.model.Disc;
import com.i2i.exception.UserApplicationException;

/**
 * 
 * <p>DiscDao --- Subclass of GenericDao
 * Manipulates the discs in the database
 * </p>
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @modified 2016-07-26
 */
public class DiscDao extends GenericDao {
	
    /**
     * Insert the Disc into the database
     * @param disc
     *        Disc object contains its attributes
     * @exception HibernateException
     *      
     */
    public void insertDisc(Disc disc) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(disc); 
            transaction.commit();
        } catch (HibernateException e) {
            throw new UserApplicationException("unable to insert disc",e);
        } finally {
            closeSession(session);
        }        
    }
    
    /**
     * Retrieves the list of disc available in the database
     * @return discs
     *         List of discs  
     * @throws UserApplicationException 
     *         if there is an error occurs while retrieve
     */
    public List<Disc> listOfDiscs() throws UserApplicationException {
    	Session session = checkSessionFactory();
        try {
            List<Disc> discs= session.createQuery("FROM Disc").list();
        return discs;        
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to list disc",e);
        } finally {
            closeSession(session); 
        } 
    }
    
    /**
     * Finds & retrieves the particular disc detail from the database
     * @param id
     *        by which the disc can be retrieved 
     * @return disc
     *         Disc object contains its attributes
     * @throws UserApplicationException 
     *         if there is any error occurs while retrieving  
     */
    public Disc findDiscById(int id) throws UserApplicationException {
    	Session session = checkSessionFactory();
        try {        	
        	Disc disc = (Disc)session.get(Disc.class, id);
            return disc;
        } catch(HibernateException e) { 
            throw new UserApplicationException("unable to find disc having id: "+id);
        } finally {
            closeSession(session);
        }
    }
    
    /**
     * Removes the particular disc from the database
     * @param id
     *        by which the disc can be removed
     * @throws UserApplicationException
     *         if there is any error occurs while removing
     */
    public void removeDiscById(int id) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
        try{
        	transaction = session.beginTransaction();  
        	Disc disc = (Disc)session.get(Disc.class, id);
            session.delete(disc);  
            transaction.commit();
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to remove disc having id: "+id);
        } catch(IllegalArgumentException e) {
            throw new UserApplicationException("Null entity, Try again by entering valid Id. problem with entered id: "+id);
        } finally {
            closeSession(session); 
        }
    }
        
    /**
     * Updates the particular disc in the database
     * @param disc
     *        Disc object contains its attributes
     * @throws UserApplicationException
     *         if there is any error occurs while updating
     * 
     */
    public void updateDiscById(Disc disc) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
       try {
    	    transaction = session.beginTransaction();
            session.update(disc); 
            transaction.commit();
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to update disc "+disc); 
        } catch(IllegalArgumentException e) {
            throw new UserApplicationException("Null Entity, Try again by Entering valid id. Problem with entered id: "+disc.getId());
        } finally {
            closeSession(session); 
        }
    }
    
    /**
     * Allocates category to a set of discs
     * @param  disc
     *         Disc object which belongs to category
     * @param category
     *        Category object which is allocated for discs
     */
    public void allocateCategoryToDiscs(Disc disc, Category category) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
        try {
        	transaction = session.beginTransaction();
            disc.setCategory(category);
            session.update(disc);
            transaction.commit();
        }catch(HibernateException e) {
            throw new UserApplicationException("unable to allocate category");
        }finally {
            closeSession(session); 
      }
    }
    
    /**
     * Allocates languages to a set of discs
     * @param  disc
     *         Disc object belongs to the respective language
     * @param language
     *        Language object which is allocated for discs
     */
    public void allocateLanguageToDiscs(Disc disc, Language language) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
        try {
        	transaction = session.beginTransaction();
            disc.setLanguage(language);
            session.update(disc);
            transaction.commit();
        }catch(HibernateException e) {
            throw new UserApplicationException("unable to allocate category");
        }finally {
            closeSession(session); 
      }
    }

}
