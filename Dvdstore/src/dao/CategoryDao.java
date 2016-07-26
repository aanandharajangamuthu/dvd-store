/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import model.Category;
import exception.UserApplicationException;


/**
 *
 * CategoryDao --- Subclass of GenericDao
 * Manipulates the categories in the database
 *
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @modified 2016-07-26
 * 
 */
public class CategoryDao extends GenericDao {
	
    /**
     * Insert the category into the database
     * @param category
     *        Category object contains its attributes
     * @exception HibernateException
     *      
     */
    public void insertCategory(Category category) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
    	try {
            transaction = session.beginTransaction();
            session.save(category); 
            transaction.commit();
        } catch (HibernateException e) {
            throw new UserApplicationException("Unable to insert category",e);
        } finally {
            closeSession(session);
        }        
    }
    
    /**
     * Retrieves the list of categories available in the database
     * @return categories
     *         List of categories  
     * @throws UserApplicationException 
     *         if there is an error occurs while retrieve
     */
    public List<Category> listOfCategories() throws UserApplicationException {
    	Session session = checkSessionFactory();
    	try {
            List<Category> categories = session.createQuery("FROM Category").list();
            return categories;        
        } catch(HibernateException e) {
            throw new UserApplicationException("Unable to list the categories",e);
        } finally {
            closeSession(session); 
        } 
    }
    
    /**
     * Finds & retrieves the particular category detail from the database
     * @param id
     *        by which the category can be retrieved
     * @return category
     *         Category object contains its attributes
     * @throws UserApplicationException 
     *         if there is any error occurs while retrieving  
     */
    public Category findCategoryById(int id) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	try {
            Category category = (Category)session.get(Category.class, id);
            return category;
        } catch(HibernateException e) { 
            throw new UserApplicationException("unable to find category having id: "+id);
        } finally {
            closeSession(session);
        }
    }
    
    /**
     * Removes the particular category from the database
     * @param id
     *        by which the category can be removed
     * @throws UserApplicationException
     *         if there is any error occurs while removing
     */
    public void removeCategoryById(int id) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
    	try {
            transaction = session.beginTransaction();
            Category category = (Category)session.get(Category.class, id);
            session.delete(category);  
            transaction.commit();
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to remove category having id: "+id);
        } catch(IllegalArgumentException e) {
            throw new UserApplicationException("Null entity, Try again by entering valid Id. problem with entered id: "+id);
        } finally {
            closeSession(session); 
        }
    }
        
    /**
     * Updates the particular category in the database
     * @param category
     *        Category object contains its attributes
     * @throws UserApplicationException
     *         if there is any error occurs while updating
     * 
     */
    public void updateCategoryById(Category category) throws UserApplicationException {
    	Session session = checkSessionFactory();
    	Transaction transaction = null;
    	try {
            transaction = session.beginTransaction();
            session.update(category); 
            transaction.commit();
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to update employee "+category); 
        } catch(IllegalArgumentException e) {
            throw new UserApplicationException("Null Entity, Try again by Entering valid id. Problem with entered id: "+category.getId());
        } finally {
            closeSession(session); 
        }
    }
}
