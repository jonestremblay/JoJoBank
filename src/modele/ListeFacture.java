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
    private  ArrayList<Facture> listeFacture;
    
    public ListeFacture(){
        listeFacture = new ArrayList<Facture>();
    }

    public ArrayList<Facture> getListeFacture() {
        return listeFacture;
    }

    public void setListeFacture(ArrayList<Facture> listeFacture) {
        this.listeFacture = listeFacture;
    }    
    
}
