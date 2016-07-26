/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import exception.UserApplicationException;
import model.PurchaseOrder;
import model.User;

/**
 * <h1>PurchaseOrderDao</h1>
 * 
 * This class handles the hibernate operations for different PurchaseOrder methods
 * @author Manikandan
 *
 */
public class PurchaseOrderDao extends GenericDao {	
	
	/**
     * <p>
     * This method used to retrieve all PurchaseOrder list from the database
     * </p>     
     * @return returns the list of all PurchaseOrder.  
     * @throws UserApplicationException
     *         If there is error in returning all PurchaseOrder through session object.  
     */	
	public List<PurchaseOrder> retrieveAllPurchaseOrders() throws UserApplicationException {        
        Session session = openSession();     
        try {         
            return session.createQuery("FROM PurchaseOrder").list();           
        } finally {
            closeSession(session);
        }        
    }
	
	/**
     * <p>
     * This method used to find particular PurchaseOrder by purchaseOrderId from database
     * </p>
     * @param purchaseOrderId 
     *        purchaseOrderId should be type of int.  
     * @return returns the PurchaseOrder.
     * @throws UserApplicationException
     *        If there is error in returning PurchaseOrder object.    
     */	
	public PurchaseOrder findUserById(int purchaseOrderId) throws UserApplicationException {       
        Session session = openSession();
        try {            
            return (PurchaseOrder)session.get(User.class, purchaseOrderId);           
        } catch (HibernateException e) {            
            throw new UserApplicationException("Could not find for this purchaseOrderId "+purchaseOrderId, e);
        } finally {
            closeSession(session);        
        }       
    }	
	
	/**
     * <p>
     * This method used to delete particular PurchaseOrder by purchaseOrderId
     * </p>
     * @param purchaseOrderId 
     *        used to find PurchaseOrder object,it should be type of int  
     * PurchaseOrder object can be deleted using session object.
     * @throws UserApplicationException
     *         If there is error in deleting PurchaseOrder object.    
     */	
	public void deletePurchaseOrderById(int purchaseOrderId) throws UserApplicationException {
		Session session = openSession();
        Transaction transaction = null;               
        try {              
            transaction = session.beginTransaction();                                         
            PurchaseOrder purchaseOrder = (PurchaseOrder)session.get(PurchaseOrder.class, purchaseOrderId);    
            session.delete(purchaseOrder); 
            transaction.commit();                 
        } catch (HibernateException e) {            
           throw new UserApplicationException("Could not delete for this purchaseOrder Id:"+purchaseOrderId, e);
        } finally {
           closeSession(session);
        }    
    
	}

}
