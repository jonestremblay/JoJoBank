/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Jones
 */
public class Transaction {
    LocalDate date;
    String categorie;
    String commerce;
    String texteNotes;
    double montant;
    int numeroFacture;
    Client shareWith;

    public Transaction() {

    }

    public Transaction(LocalDate date, String categorie, String commerce, String texteNotes, double montant, int numeroFacture, Client shareWith) {
        this.date = date;
        this.categorie = categorie;
        this.commerce = commerce;
        this.texteNotes = texteNotes;
        this.montant = montant;
        this.numeroFacture = numeroFacture;
        this.shareWith = shareWith;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate  date) {
        this.date = date;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCommerce() {
        return commerce;
    }

    public void setCommerce(String commerce) {
        this.commerce = commerce;
    }

    public String getTexteNotes() {
        return texteNotes;
    }

    public void setTexteNotes(String texteNotes) {
        this.texteNotes = texteNotes;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Client getShareWith() {
        return shareWith;
    }

    public void setShareWith(Client shareWith) {
        this.shareWith = shareWith;
    }
    
    /**
     * Créer une ligne "CSV" pour l'objet transaction
     * @return string d'un objet transaction pour CSV
     */
    public String convertirTransactionLigne(){
        return String.valueOf(this.date) + ";" +
        this.categorie + ";" + this.commerce + ";" +
        this.texteNotes + ";" + String.valueOf(this.montant) + ";" +
        String.valueOf(this.numeroFacture) + ";" +
        String.valueOf(this.shareWith.getUsername());
    }
    
    /**
     * Formatte la date de la transaction selon le format en return
     * @param dateString
     * @return yyyy mon(FRENCH) dd
     */
    public static String formatDateTransaction(String dateString){
       
        String[] dateData = dateString.split(" ");
        LocalDate date = null;
        try{
        date = LocalDate.of(Integer.parseInt("20" + dateData[2]), Integer.parseInt(dateData[1]), Integer.parseInt(dateData[0]));
        } catch(DateTimeException dte){
            JOptionPane.showMessageDialog(null, "Invalid date. Are you sure this date exists in the calendar ?", dte.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        String[] resultDate = date.toString().split("-");
        String mois;
        switch(Integer.parseInt(resultDate[1])){
            case 1:
                mois = "Janv";
                break;
            case 2:
                mois = "Fév";
                break;
            case 3:
                mois = "Mars";
                break;
            case 4:
                mois = "Avr";
                break;
            case 5:
                mois = "Mai";
                break;
            case 6:
                mois = "Juin";
                break;
            case 7:
                mois = "Juil";
                break;
            case 8:
                mois = "Août";
                break;
            case 9:
                mois = "Sept";
                break;
            case 10:
                mois = "Oct";
                break;
            case 11:
                mois = "Nov";
                break;
            case 12:
                mois = "Déc";
                break;
            default:
                mois = "???";
                break;
        }
        String formattedDate = resultDate[2] + " " + mois + " " + resultDate[0];
        // Pour donner le mois en chiffre directement
        // String formattedDate = resultDate[2] + " " + resultDate[1] + " " + resultDate[0];
        return formattedDate;
    }
    
    @Override
    public String toString() {
        return "Transaction{" + "date=" + date + ", categorie=" + categorie + ", commerce=" + commerce + ", texteNotes=" + texteNotes + ", montant=" + montant + ", numeroFacture=" + numeroFacture + ", shareWith=" + shareWith.toString() + '}';
    }
    
    
}
