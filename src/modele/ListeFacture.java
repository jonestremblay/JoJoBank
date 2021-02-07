
package modele;

import java.util.ArrayList;


public class ListeFacture {
    private static ArrayList<Facture> listeFacture;

   
    
    public ListeFacture(){
        listeFacture = new ArrayList<Facture>();
    }

    public  ArrayList<Facture> getListeFacture() {
        return listeFacture;
    }

    public void setListeFacture(ArrayList<Facture> listeFacture) {
        this.listeFacture = listeFacture;
    }    
    
    public void add(Facture facture){
        this.listeFacture.add(facture);
    }
    
    public void remove(Facture facture){
        this.listeFacture.remove(facture);
    }
    
    /**
     * Calcule la somme des factures mensuelles contenues dans la
     * liste des factures.
     * @return double sommeFactureMensuelles
     */
    public Double calculerSommeFactureMensuelle(){
        double montant = 0;
        for(Facture f : listeFacture){
            if(f.dateLimite.contains(" du mois")){
                montant += f.montant;
            }
        }
        return montant;
    }
    
    /**
     * Calcule la somme des factures uniques contenues dans la
     * liste des factures.
     * @return double sommeFactureUniques
     */
    public Double calculerSommeFactureUnique(){
        double montant = 0;
        for(Facture f : listeFacture){
            if(!f.dateLimite.contains(" du mois")){
                montant += f.montant;
            }
        }
        return montant;
    }

   
}
