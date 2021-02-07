
package modele;

import java.util.ArrayList;


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
