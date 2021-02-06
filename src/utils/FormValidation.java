/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.LocalDate;
import java.time.Month;
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
    
    /**
     *
     * @param user
     * @param password
     * @return
     */
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
    public static boolean passIsValid(String pass){
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
    
    /**
     * For Register form.
     * @param name
     * @param user
     * @param pass
     * @return
     */
    public static boolean requiredFieldsFilled(JTextField name, JTextField user, JTextField pass){
        if (name.getText().isEmpty() || user.getText().isEmpty() || pass.getText().isEmpty()){
            return false;
        }
        return true;
    }
    
    public static boolean factureUniqueFieldsFilled(JTextField creancier, JTextField description,
                                           JTextField dd, JTextField mm, JTextField yy,
                                           JTextField montant){
        if (creancier.getText().length() < 1 || description.getText().length() < 1
                || dd.getText().length() < 1 || mm.getText().length() < 1
                || yy.getText().length() < 1 || montant.getText().length() < 1){
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean factureMensuelleFieldsFilled(JTextField creancier, JTextField description,
                                           JTextField dd, JTextField montant){
        if (creancier.getText().length() < 1 || description.getText().length() < 1
                || dd.getText().length() < 1 || montant.getText().length() < 1){
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean checkDateValidityFacture(JTextField dd, JTextField mm, JTextField yy){
        final int DAY_LIMIT = 31;
        final int MM_LIMIT = 12;
        final int YY_MINIMUM = 21;
        char[] date;
        if (mm.getText().isEmpty() && yy.getText().isEmpty()){
            date = dd.getText().toCharArray();
        } else {
            date = (dd.getText() + mm.getText() + yy.getText()).toCharArray();
        }
        
        boolean dateOK = true;
        for (int c : date) {
            if (c > 57 || c < 48){
                dateOK = false;
            }
        }
        
        int day =0; int month = 0; int year = 0;
        if (mm.getText().isEmpty() && yy.getText().isEmpty()){
            try{
                day = Integer.parseInt(dd.getText());
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
            if (day > DAY_LIMIT || day < 1){
                dateOK = false;}
        } else {
            try{
                day = Integer.parseInt(dd.getText());
                month = Integer.parseInt(mm.getText());
                year = Integer.parseInt(yy.getText());
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
            if (day > DAY_LIMIT || day < 1){
                dateOK = false;
            } else if (month > MM_LIMIT || month < 1){
                dateOK = false;
            } else if (year < YY_MINIMUM){
                dateOK = false;
            }
        }
        return dateOK;
    }
    
    /* 
    Called after verification only. Return in the format : yyyy-mm-dd
    */
    public static LocalDate getLocalDateFromString(JTextField dd, JTextField mm, JTextField yy){
        
        int day = Integer.parseInt(dd.getText());
        int month = Integer.parseInt(mm.getText());
        int year = Integer.parseInt("20" + yy.getText());
        
        return LocalDate.of(year, month, day);
    }
}
