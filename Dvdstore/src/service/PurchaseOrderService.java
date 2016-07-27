package service;

import java.util.List;

import model.PurchaseOrder;
import dao.PurchaseOrderDao;
import exception.UserApplicationException;

/**
 * @author Manikandan
 *
 */
public class PurchaseOrderService {
	private PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDao();
	
	/**
     * <p>
     * This method used to get all purchaseOrder list through purchaseOrderDao      
     * </p>                
     * @return returns the purchaseOrder list.  
     * @throws UserApplicationException
     *         If there is failed or interrupted get purchaseOrder list operation.               
     */
    public List<PurchaseOrder> getAllPurchaseOrders()throws UserApplicationException {
    	return purchaseOrderDao.retrieveAllPurchaseOrders();
    }
    
    /**
     * <p>
     * This method used to view particular PurchaseOrder by purchaseOrderId. 
     * </p>
     * @param purchaseOrderId
     *        Used to find PurchaseOrder,and it should be type of int
     * @return PurchaseOrder 
     *         returns the PurchaseOrder
     * @throws UserApplicationException 
     *         If there is failed or interrupted view user operation.                        
     */    
    public PurchaseOrder getPurchaseOrderById(int purchaseOrderId) throws UserApplicationException  {       
        return purchaseOrderDao.findUserById(purchaseOrderId);       
    }
	
    /**
     * <p>
     * This method used to remove PurchaseOrder based on the purchaseOrderId. 
     * </p>
     * @param purchaseOrderId
     *        Used to remove PurchaseOrder from the PurchaseOrderlist and it should be type of int     
     * @throws UserApplicationException 
     *        If there is failed or interrupted remove PurchaseOrder operation.                      
     */
    public void removePurchaseOrderById(int purchaseOrderId) throws UserApplicationException  {       
         purchaseOrderDao.deletePurchaseOrderById(purchaseOrderId);       
    }

}
