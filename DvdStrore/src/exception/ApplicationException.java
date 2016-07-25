/**
 * 
 */
package exception;

/**
 * <p>
 * ApplicationException--- handles the exception based on the user customization
 * </p>
 * 
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @created 2016-07-25
 */
public class ApplicationException extends Exception{
	

    public ApplicationException() {}   
  
    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable e) {
        super(message,e); 
    }

}
