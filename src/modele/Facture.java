/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.FenBills;

/**
 *
 * @author Jones
 */
public class Facture {
    String description;
    String creancier;
    double montant;
    String dateLimite;
    
    public Facture(){
        
    }

    public Facture(String creancier, String description, String dateLimite, double montant) {
        this.description = description;
        this.creancier = creancier;
        this.montant = montant;
        this.dateLimite = dateLimite;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreancier() {
        return creancier;
    }

    public void setCreancier(String creancier) {
        this.creancier = creancier;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(String dateLimite) {
        this.dateLimite = dateLimite;
    }
    
    
    /*
    Retourne facture en format CSV. 
    */
    public String convertirFactureEnLigne(){
        return creancier + ";" +
               description + ";" +
               dateLimite + ";" +
               String.valueOf(montant);

    }
    
//    public String getDateString(){
//        DateFormat df = new SimpleDateFormat("dd MMM yy");
//        return df.format(dateLimite);
//    }
    
    public static String formatDateFactureUnique(String dateString){
       
        String[] dateData = dateString.split(" ");
        LocalDate date = null;
        try{
        date = LocalDate.of(Integer.parseInt("20" + dateData[2]), Integer.parseInt(dateData[1]), Integer.parseInt(dateData[0]));
        } catch(DateTimeException dte){
            JOptionPane.showMessageDialog(null, "Invalid date. Are you sure this date exists in the calendar ?", dte.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        //df.format(date);
        System.out.println(date);
        System.out.println(date.toString());
        
        String[] resultDate = date.toString().split("-");
        String mois;
        switch(Integer.parseInt(resultDate[1])){
            case 1:
                mois = "Janvier";
                break;
            case 2:
                mois = "Février";
                break;
            case 3:
                mois = "Mars";
                break;
            case 4:
                mois = "Avril";
                break;
            case 5:
                mois = "Mai";
                break;
            case 6:
                mois = "Juin";
                break;
            case 7:
                mois = "Juillet";
                break;
            case 8:
                mois = "Août";
                break;
            case 9:
                mois = "Septembre";
                break;
            case 10:
                mois = "Octobre";
                break;
            case 11:
                mois = "Novembre";
                break;
            case 12:
                mois = "Décembre";
                break;
            default:
                mois = "???";
                break;
        }
        String formattedDate = resultDate[2] + " " + mois + " " + resultDate[0];
        System.out.println(formattedDate);
        return formattedDate;
    }
    
   
    public static String formatDateFactureMensuelle(String jourDate){
        return jourDate + " du mois";
    }

    @Override
    public String toString() {
        return "Facture{" + "description=" + description + ", creancier=" + creancier + ", montant=" + montant + ", dateLimite=" + dateLimite + '}';
    }
    
    
}
