/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static Date formatDateFactureUnique(String dateString){
        DateFormat df = new SimpleDateFormat("dd mm yy");
        Date date = new Date();
        try {
            date = df.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(FenBills.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
   
    public static String formatDateFactureMensuelle(String jourDate){
        return jourDate + " du mois";
    }

    @Override
    public String toString() {
        return "Facture{" + "description=" + description + ", creancier=" + creancier + ", montant=" + montant + ", dateLimite=" + dateLimite + '}';
    }
    
    
}
