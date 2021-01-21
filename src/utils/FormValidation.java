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
    
    /* 
    Return true if it's OK, false if not.
    */
    public static boolean verifierSaisie_LOGIN(String user, char [] password){
        if ( (user == null) || ( password == null) ){
            return false;
        } else {
            return true;
        }
    }
}
