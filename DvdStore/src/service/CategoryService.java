/**
 * 
 */
package service;

import java.util.List;
import model.Category;
import dao.CategoryDao;
import exception.ApplicationException;

/**
 * @author Anandharaj Angamuthu
 *
 */
public class CategoryService {
	
	CategoryDao categoryDao  = new CategoryDao();
	
    /**
     * <p>
     * Creates a new category
     * Accepts input from the admin & assign  it to the category. Insert the category into database
     * Using insertCategory method
     * </p>
     *
     * @param name
     *        which is the name of the category
     * 
     * @throws ApplicationException
     *         if there is any error in the given input or error while inserting into databse
     */
    public void createCategory(String name) throws ApplicationException {
        Category category = new Category(name);
        categoryDao.insertCategory(category);
    } 
    
    /**
     * <p>
     * Retrieves list of Category from the database
     * Using listOfCategories method
     * </p>
     *
     * @return categoryDao.listOfCategories()
     *         List of categories available in the database
     */
    public List<Category> CategoryList() throws ApplicationException{
        return categoryDao.listOfCategories();
    } 
    
    /**
     * <p>
     * Finds & Retrieves particular category from the database
     * Using findCategoryById method
     * </p>
     *
     * @param id
     *        which is the unique id of the category
     * @return categoryDao.findCategoryById(id)
     *         category
     * @throws ApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public Category findByCategoryId(int id) throws ApplicationException {
        return categoryDao.findCategoryById(id);
    } 

    /**
     * <p>
     * Removes particular category from database
     * Using removeCategoryById method
     * </p>
     *
     * @param id
     *        which is the unique id of the category
     * @throws ApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public void removeByCategoryId(int id) throws ApplicationException {
        categoryDao.removeCategoryById(id);
    }
    
    /**
     * <p>
     * Updates the particular category detail in the database
     * Using updateCategoryById method
     * </p>
     *
     * @param id
     *        which is the unique id of the category
     * @param name
     *        which will be the new name of the category
     * @throws ApplicaionException
     *         if there is any error in the given input or error while updating into databse  
     */  
    public void updateByCategoryId(int id, String name) throws ApplicationException {
        Category category = categoryDao.findCategoryById(id);
        category.setName(name);   
        categoryDao.updateCategoryById(category);
    }	

}
