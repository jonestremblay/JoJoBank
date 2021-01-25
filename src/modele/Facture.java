/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jones
 */
public class Facture {
    int facture_id;
    String description;
    String creancier;
    double montant;
    LocalDate dateLimite;
    
    public Facture(){
        
    }

    public Facture(int facture_id, String creancier, String description, LocalDate dateLimite, double montant) {
        this.facture_id = facture_id;
        this.description = description;
        this.creancier = creancier;
        this.montant = montant;
        this.dateLimite = dateLimite;
    }

    public int getFacture_id() {
        return facture_id;
    }

    public void setFacture_id(int facture_id) {
        this.facture_id = facture_id;
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

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }
    
    public void incrementerID(){
        facture_id++;
    }
    
    /*
    Retourne facture en format CSV. 
    */
    public String convertirFactureEnLigne(){
        return String.valueOf(facture_id) + ";" + 
               creancier + ";" +
               description + ";" +
               getDateString() + ";" +
               String.valueOf(montant);

    }
    
    public String getDateString(){
        DateFormat df = new SimpleDateFormat("dd-mon-yyyy");
        return df.format(dateLimite);
    }
    

    @Override
    public String toString() {
        return "Facture{" + "facture_id=" + facture_id + ", description=" + description + ", creancier=" + creancier + ", montant=" + montant + ", dateLimite=" + dateLimite + '}';
    }
    
    
}
