/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;

/**
 *
 * @author Jones
 */
public class Transaction {
    Date date;
    String categorie;
    String commerce;
    String texteNotes;
    double montant;
    int numeroFacture;
    Client shareWith;

    public Transaction() {

    }

    public Transaction(Date date, String categorie, String commerce, String texteNotes, double montant, int numeroFacture, Client shareWith) {
        this.date = date;
        this.categorie = categorie;
        this.commerce = commerce;
        this.texteNotes = texteNotes;
        this.montant = montant;
        this.numeroFacture = numeroFacture;
        this.shareWith = shareWith;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @Override
    public String toString() {
        return "Transaction{" + "date=" + date + ", categorie=" + categorie + ", commerce=" + commerce + ", texteNotes=" + texteNotes + ", montant=" + montant + ", numeroFacture=" + numeroFacture + ", shareWith=" + shareWith.toString() + '}';
    }
    
    
}
