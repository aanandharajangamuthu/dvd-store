/**
 * 
 */
package com.i2i.service;

import java.util.List;

import com.i2i.model.User;
import com.i2i.dao.UserDao;
import com.i2i.exception.UserApplicationException;

/**
 * <h1>UserService</h1>
 * This class calls the UserDao class.
 * And gets output returning from UserDao class. 
 * 
 * @author Manikandan
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();	
	
	/**
     * <p>
     * This method used to add user details, here we create an object for an user 
     * </p>
     * @param name    
     *        name should be type of String.
     * @param email  
     *        email should be type of String.
     * @param password
     *        password should be type of String.
     * @param mobileNumber 
     *        mobileNumber should be type of String.                
     * @throws UserApplicationException  
     *         If there is failed or interrupted insert operation.              
     */	
	public void addUser(User user) throws UserApplicationException {	
		userDao.insert(user);	
	}
	
	/**
     * <p>
     * This method used to get all users list through userDao      
     * </p>                
     * @return returns the users list.  
     * @throws UserApplicationException
     *         If there is failed or interrupted get user list operation.               
     */ 	
    public List<User> getAllUsers() throws UserApplicationException {
    	return userDao.retrieveAllUsers();    	
    }
    
    /**
     * <p>
     * This method used to view particular user by userId. 
     * </p>
     * @param userId
     *        Used to find Project,and it should be type of int
     * @return Project 
     *         returns the Project to ApplicationController class.
     * @throws UserApplicationException 
     *         If there is failed or interrupted view user operation.                        
     */	
    public User getUserById(int userId) throws UserApplicationException  {       
        return userDao.findUserById(userId);       
    }
    
    /**
     * <p>
     * This method used to remove user based on the userId. 
     * </p>
     * @param userId
     *        Used to remove an user from the users list and it should be type of int     
     * @throws UserApplicationException 
     *        If there is failed or interrupted remove user operation.                      
     */
    public void removeUserById(int userId) throws UserApplicationException {
    	userDao.deleteUserById(userId);
    } 
    
    /**
     * <p>
     * This method used to update user details based on the userId. 
     * </p>
     * @param userId 
     *        used to find user object,it should be type of int
     * @param name
     *        name should be type of String
     * @param email
     *        email should be type of String
     * @param password 
     *        password should be type of String
     * @param mobileNumber
     *        mobileNumber should be type of String             
     * @throws UserApplicationException  
     *        If there is failed or interrupted updated User operation.                                       
     */
    public void updateUserById(int userId,  String name, String email, String password, String mobileNumber) throws UserApplicationException {
        User user = userDao.findUserById(userId);   
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setMobileNumber(mobileNumber);
        userDao.updateUser(user);
    }   
    
    
    public User findUser(User user) throws UserApplicationException  {
    	return userDao.searchUser(user);
    }



}
