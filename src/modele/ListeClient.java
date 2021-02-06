/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import utils.ClientComparator;
import utils.ClientExistantException;

/**
 *
 * @author Jones
 */
public abstract class ListeClient {
    //private static ArrayList<Client> listeClient = new ArrayList<>();
    private static Set listeClient = new TreeSet(new ClientComparator());
    
    public ListeClient(){
        
    }

    public static Set getListeClient() {
        return listeClient;
    }

    public static void setListeClient(Set listeClient) {
        ListeClient.listeClient = listeClient;
    }
    

    
    public static void ajouterClient(Client client) throws ClientExistantException {
        if (verifierDoublon(client)){
            throw new ClientExistantException(client, "Ce client existe déjà");
        }else {
            listeClient.add(client);
            JOptionPane.showMessageDialog(null, client + " a été ajouté.", "Succès", 0);
            System.out.println(listeClient.toString());
        }
    }
    
    private static boolean verifierDoublon(Client client) {
        ArrayList<Client> listeClient = new ArrayList<Client>();
        for (Object c: ListeClient.listeClient){
            listeClient.add((Client)c);
        }
        for (Client c: listeClient){
            if (c.getUsername().equals(client.getUsername())){
                return true;
            } 
        }
        return false;
    }
    
    public static Client getClientWithUsername(String username){
        ArrayList<Client> listeClient = new ArrayList<Client>();
        Client client = null;
        for (Object c: ListeClient.listeClient){
            listeClient.add((Client)c);
        }
        for (Client c: listeClient){
            if (c.getUsername().equals(username)){
                client = c;
            } 
        }
        return client;
    }
    
    @Override
    public String toString() {
        return "ListeClient{" + '}';
    }
    
    
}
