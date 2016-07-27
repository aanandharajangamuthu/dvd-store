/**
 * 
 */
package controller;

import service.LanguageService;
import exception.UserApplicationException;

public class Test {
    public static void main(String[] a) {
     LanguageService languageService = new LanguageService();
     try { 
      languageService.createLanguage("Tamil");
      System.out.println("Added successfully");     
     } catch (UserApplicationException e) {
      System.out.println("Exception"+e);     
     }

}


}