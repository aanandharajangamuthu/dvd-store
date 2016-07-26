/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import model.Category;
import model.Language;
import model.Disc;
import exception.ApplicationException;

/**
 * 
 * <p>DiscDao --- Subclass of GenericDao
 * Manipulates the discs in the database
 * </p>
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @created 2016-07-25
 */
public class DiscDao extends GenericDao {
	
    /**
     * Insert the Disc into the database
     * @param disc
     *        Disc object contains its attributes
     * @exception HibernateException
     *      
     */
    public void insertDisc(Disc disc) throws ApplicationException {
    	Session session =null;
    	Transaction transaction = null;
        try {
            checkSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(disc); 
            transaction.commit();
        } catch (HibernateException e) {
            rollBack(transaction);
            throw new ApplicationException();
        } finally {
            closeSession(session);
        }        
    }
    
    /**
     * Retrieves the list of disc available in the database
     * @return discs
     *         List of discs  
     * @throws ApplicationException 
     *         if there is an error occurs while retrieve
     */
    public List<Disc> listOfDiscs() throws ApplicationException {
    	Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Disc> discs= session.createQuery("FROM Disc").list();
        return discs;        
        } catch(HibernateException e) {
            e.printStackTrace(); 
            throw new ApplicationException();
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
     * @throws ApplicationException 
     *         if there is any error occurs while retrieving  
     */
    public Disc findDiscById(int id) throws ApplicationException {
    	Session session =null;
        try {
            checkSessionFactory();
            session = sessionFactory.openSession();        	
        	Disc disc = (Disc)session.get(Disc.class, id);
            return disc;
        } catch(HibernateException e) {
            e.printStackTrace(); 
            throw new ApplicationException("unable to find disc having id: "+id);
        } finally {
            closeSession(session);
        }
    }
    
    /**
     * Removes the particular disc from the database
     * @param id
     *        by which the disc can be removed
     * @throws ApplicationException
     *         if there is any error occurs while removing
     */
    public void removeDiscById(int id) throws ApplicationException {
    	Session session =null;
    	Transaction transaction = null;
        try{
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();  
        	Disc disc = (Disc)session.get(Disc.class, id);
            session.delete(disc);  
            transaction.commit();
        } catch(HibernateException e) {
            rollBack(transaction);
            e.printStackTrace(); 
            throw new ApplicationException("unable to remove disc having id: "+id);
        } catch(IllegalArgumentException e) {
            throw new ApplicationException("Null entity, Try again by entering valid Id. problem with entered id: "+id);
        } finally {
            closeSession(session); 
        }
    }
        
    /**
     * Updates the particular disc in the database
     * @param disc
     *        Disc object contains its attributes
     * @throws ApplicationException
     *         if there is any error occurs while updating
     * 
     */
    public void updateDiscById(Disc disc) throws ApplicationException {
    	Session session =null;
    	Transaction transaction = null;
       try {
    	   checkSessionFactory();
    	   session = sessionFactory.openSession();
    	   transaction = session.beginTransaction();
            session.update(disc); 
            transaction.commit();
        } catch(HibernateException e) {
            rollBack(transaction);
            e.printStackTrace();
            throw new ApplicationException("unable to update disc "+disc); 
        } catch(IllegalArgumentException e) {
            throw new ApplicationException("Null Entity, Try again by Entering valid id. Problem with entered id: "+disc.getId());
        } finally {
            closeSession(session); 
        }
    }
    
    /**
     * Allocates category to a set of discs
     * @param  
     */
    public void allocateCategoryToDiscs(Disc disc, Category category) {
    	Session session =null;
    	Transaction transaction = null;
        try {
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
            disc.setCategory(category);
            session.update(disc);
            transaction.commit();
        }catch(HibernateException e) {
            rollBack(transaction);
            e.printStackTrace(); 
        }finally {
            closeSession(session); 
      }
    }
    
    /**
     * Allocates languages to a set of discs
     * @param  
     */
    public void allocateLanguageToDiscs(Disc disc, Language language) {
    	Session session =null;
    	Transaction transaction = null;
        try {
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
            disc.setLanguage(language);
            session.update(disc);
            transaction.commit();
        }catch(HibernateException e) {
            rollBack(transaction);
            e.printStackTrace(); 
        }finally {
            closeSession(session); 
      }
    }

}
