package dao;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import exception.ApplicationException;
import utilities.StringUtils;

/**
 * <p>
 * GenericDao---Generates the sessionFactory for the application 
 * </p>
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @created 2016-07-25
 *
 */

public class GenericDao {
	
    protected static SessionFactory sessionFactory;    

    static { // initiates the connection when program gets started
        getConnection();
    }

    /**
     * Creates a sessionFactoryimport exception.ApplicationException;
     * @exception throwable 
     */ 
    public static void getConnection() {
       try{
          sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
       }catch(Throwable ex) { 
          System.err.println("Failed to create sessionFactory object." + ex);
       }
    }

    /**
     * Creates rollback when transaction is not null
     */
    protected void rollBack(Transaction transaction) {
            if(transaction != null) {
                transaction.rollback();
            }
    }
    /**
     * <p>
     * This method used to get the physical connection to the database through the session object.
     * </p>
     * @throws ApplicationException
     *         if there is any error occurs while creating session object.
     * @return Session 
     *         returns session object to interact with the objects 
     */       
     protected Session checkSessionFactory() throws ApplicationException {
         if(null == sessionFactory) {
             throw new ApplicationException("SessionFactory is not opened while creating");            
         } else {     
             try {
                 return sessionFactory.openSession();
             } catch (HibernateException e) {
                 throw new ApplicationException("Some error occured while Session is opened",e);                  
             }
         }
        
     }  

    /**
     * Closes the session
     * @exception HibernateException
     */            
    protected void closeSession(Session session) {
        try {
            if(null != session) {
                session.close();
            }
        } catch(HibernateException e) {
            StringUtils.appendToFile(e);
        }
    }
    
    /**
     * Closes the sessionFactory
     * @exception HibernateException
     */
    public static void closeSessionFactory() {
        try {
            if(null != sessionFactory) {
                sessionFactory.close();
            }
        } catch (HibernateException e) {
            StringUtils.appendToFile(e);
        }
    }   
}
