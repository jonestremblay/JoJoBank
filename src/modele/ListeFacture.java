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
    
    public Double calculerSommeFactureMensuelle(){
        double montant = 0;
        for(Facture f : listeFacture){
            if(f.dateLimite.contains(" du mois")){
                montant += f.montant;
            }
        }
        return montant;
    }
    
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
