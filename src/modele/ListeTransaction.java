/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Jones
 */
public class ListeTransaction {
    private String user;
    private static Set listeTransaction = new TreeSet();

    public ListeTransaction(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Set getListeTransaction() {
        return listeTransaction;
    }

    public void setListeTransaction(Set listeTransaction) {
        this.listeTransaction = listeTransaction;
    }

    @Override
    public String toString() {
        return "ListeTransaction{" + "user=" + user + " liste: " + listeTransaction.toString() +  '}';
    }
    
    
    
}
