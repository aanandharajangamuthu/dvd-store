/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import model.User;
import exception.UserApplicationException;

/**
 * <h1>UserDao</h1>
 * This class handles the hibernate operations for different user methods
 * 
 * @author Manikandan
 *
 */
public class UserDao extends GenericDao {
	
	/**
     * <p>
     * This  method used to insert the user details to the database
     * </p>
     * @param user 
     *        user object to be inserted,and it contains user details     
     * @throws UserApplicationException
     *        If there is error in inserting user through session object.     
     */	
	public void insert(User user) throws UserApplicationException {
		Session session = checkSessionFactory();
        Transaction transaction = null;                 
        try {                
            transaction = session.beginTransaction();
            session.save(user);               
            transaction.commit();    
        } catch (HibernateException e) {                
            throw new UserApplicationException("Could not insert a new User "+user, e); 
        } finally {
            closeSession(session);               
        }   
	}
	
	/**
     * <p>
     * This method used to retrieve all users list from the database
     * </p>     
     * @return returns the list of all users.  
     * @throws UserApplicationException
     *         If there is error in returning users through session object.  
     */	
	public List<User> retrieveAllUsers() throws UserApplicationException {        
        Session session = checkSessionFactory();     
        try {         
            return session.createQuery("FROM User").list();           
        } finally {
            closeSession(session);
        }        
    }	
	
	/**
     * <p>
     * This method used to find particular user by userId from database
     * </p>
     * @param userId 
     *        userId should be type of int.  
     * @return User
     *        returns the User.
     * @throws UserApplicationException
     *        If there is error in returning User object.    
     */	
	public User findUserById(int userId) throws UserApplicationException {       
        Session session = checkSessionFactory();
        try {            
            return (User)session.get(User.class, userId);           
        } catch (HibernateException e) {            
            throw new UserApplicationException("Could not find for this userId "+userId, e);
        } finally {
            closeSession(session);        
        }       
    }
	
	/**
     * <p>
     * This method used to delete particular User by userId from database
     * </p>
     * @param userId 
     *        used to find user object,it should be type of int  
     * User object can be deleted using session object.
     * @throws UserApplicationException
     *         If there is error in deleting User object.    
     */	
	public void deleteUserById(int userId) throws UserApplicationException {
		Session session = checkSessionFactory();
        Transaction transaction = null;               
        try {              
            transaction = session.beginTransaction();                                         
            User user = (User)session.get(User.class, userId);    
            session.delete(user); 
            transaction.commit();                 
        } catch (HibernateException e) {            
           throw new UserApplicationException("Could not delete for this user Id "+userId, e);
        } finally {
           closeSession(session);
        }    
	}
	
	/**
     * <p>
     * This method used to update the given User object,which is already exisiting in the database.
     * </p>
     * @param user
     *        User object to be modified.
     * @throws ApplicationException
     *     If there is error in updating User object by session object.    
     */	
	public void updateUser(User user) throws UserApplicationException {
		Session session = checkSessionFactory();
        Transaction transaction = null;
        try {            
            transaction = session.beginTransaction();            
	        session.update(user);  
            transaction.commit();          
        } catch (HibernateException e) {            
            throw new UserApplicationException("could not update for this user Id "+user, e);
        } finally {
            closeSession(session);
        }
	}
	

}
