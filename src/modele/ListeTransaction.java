/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Jones
 */
public class ListeTransaction {
    private static ArrayList<Transaction> listeTransaction;

    public ListeTransaction() {
        this.listeTransaction = new ArrayList<Transaction>();
    }

    public ArrayList<Transaction> getListeTransaction() {
        return listeTransaction;
    }

    public void setListeTransaction(ArrayList<Transaction> listeTransaction) {
        this.listeTransaction = listeTransaction;
    }

    @Override
    public String toString() {
        return "ListeTransaction{" + " liste: " + listeTransaction.toString() +  '}';
    }
    
    
    
}
