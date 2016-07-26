/**
 * 
 */
package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;

/**
 * @author Anandharaj Angamuthu
 *
 */
public class StringUtils {
	
    private static BufferedWriter bufferedWriter;
    private static PrintWriter printWriter; 
    public static void appendToFile(Exception exception) {
         try {
             Date date = new Date() ;
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy") ;
             FileWriter fileWriter = new FileWriter("dvdlog/"+dateFormat.format(date) + ".txt",true) ;
             bufferedWriter = new BufferedWriter(fileWriter);
             printWriter = new PrintWriter(bufferedWriter, true);
             exception.printStackTrace(printWriter);
         } catch (IOException e) {
             throw new RuntimeException("Could not write Exception to file", e);
         } finally {
              try {
                  bufferedWriter.close();
              } catch (IOException e) {
                  e.printStackTrace();
              } catch (Exception e) {
                  e.printStackTrace();
              }
         }        
    }

}
