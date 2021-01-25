/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
        for (char c: chars){
            if (Character.getNumericValue(c) <= 90 && Character.getNumericValue(c) >= 65){
                maj++;
            } else if (Character.getNumericValue(c) <= 57 && Character.getNumericValue(c) >= 48){
                digit++;
            } else if (Character.getNumericValue(c) <= 47 && Character.getNumericValue(c) >= 32){
                symbol++;
            }
        }
        if(maj>= 1 && digit >= 1 && symbol >= 1){
            return true;
        } else {
            return false;
        }
    }
}
