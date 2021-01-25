/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JTextField;
import ui.FenAppUI;

/**
 *
 * @author Jones
 */
public class FormValidation {

    /**
     * Return true if it's OK, false if not.
     * @param user
     * @param password
     * @return
     */

    public static boolean verifierSaisie_LOGIN(String user, char [] password){
        if ( (user == null) || ( password == null) ){
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean verifierSaisie_REGISTER(String user, char [] password){
        if ( (user == null) || ( password == null) ){
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Check the password's validity. Is it strong enough ? Uses ASCII table.
     * @param pass
     * @return
     */
    public static boolean isValid(String pass){
        // Maj : 65 to 90 (incl)
        // Digit : 48 à 57 (incl)
        // symbol : 32 a 47
        int maj = 0;
        int digit = 0;
        int symbol = 0;
        char[] chars = pass.toCharArray();
        for (int c: chars){
            System.out.println(c);
            if (c <= 90 && c >= 65){
                maj++;
            }  
            if (c <= 57 && c >= 48){
                digit++;
            } 
            if (c <= 47 && c >= 32){
                symbol++;
            }
        }
        System.out.println(maj + ";" + digit + ";" + symbol);
         
        if(pass.length() < 8){
            return false;
        }else if(maj>= 1 && digit >= 1 && symbol >= 1){
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean requiredFieldsFilled(JTextField name, JTextField user, JTextField pass){
        if (name.getText().isEmpty() || user.getText().isEmpty() || pass.getText().isEmpty()){
            return false;
        }
        return true;
    }
}
