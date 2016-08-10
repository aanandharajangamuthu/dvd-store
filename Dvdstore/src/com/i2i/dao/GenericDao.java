package com.i2i.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session; 
 
import com.i2i.exception.UserApplicationException;

/**
 * <h1>GenericDao</h1>
 * This class written for generic functions used to provide hibernate configuration,SessionFactory,Session to the Application.
 *
 * @author Manikandan
 * @created 2016-7-8
 */
public class GenericDao {
      
    protected static SessionFactory sessionFactory;
    
    
    static {
        getConnection();       
    }    
    /**
     * <p>
     * This method provides the SessionFactory instance used to get the database connection through the configured xml file.
     * It provides the hibernate query language query.
     * </p>
     */
    private static void getConnection() {
        try {
            sessionFactory = new AnnotationConfiguration().configure("com/i2i/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);             
        }   
    }     

    /**
     * <p>
     * This method used to close SessionFactory when the user close the application     
     * </p> 
     * @exception HibernateException
     *           if there is any error in closeFactory,it prints message.
     */      
    protected static void closeFactory() {
        if (null != sessionFactory) {
            try {
                sessionFactory.close();
            } catch (HibernateException e) {
                System.out.print("Some error occured while closing the SessionFactory" +e);
            }
        }
    }    
    
    /**
     * <p>
     * This method used to close session object.
     * </p>
     * @exception HibernateException
     *         if there is any error or interrupted,it prints message     
     */
    protected void closeSession(Session session) {
        if(null != session) {
            try {
                session.close();    
            } catch (HibernateException e) {
                System.out.print("Some error occured while closing the session object"); 
            }
        }
    }        
    
   /**
    * <p>
    * This method used to get the phyical connection to the database through the session object.
    * </p>
    * @throws UserApplicationException
    *         if there is any error or interrupted when creating session object.
    * @return Session 
    *         returns session object to be interact with the objects 
    */       
    protected Session checkSessionFactory() throws UserApplicationException {
        if(null == sessionFactory) {
            throw new UserApplicationException("SessionFactory is not opened while creating");            
        } else {     
            try {
                return sessionFactory.openSession();
            } catch (HibernateException e) {
                throw new UserApplicationException("Some error occured while Session is opened",e);                  
            }
        }
       
    }  

}


