
package modele;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import utils.ClientComparator;
import utils.ClientExistantException;


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
    
    /**
     * Ajoute un client au set listeClient, si ce n'est pas un doublon.
     * @param client
     * @throws ClientExistantException
     */
    public static void ajouterClient(Client client) throws ClientExistantException {
        if (verifierDoublon(client)){
            throw new ClientExistantException(client, "Ce client existe déjà");
        }else {
            listeClient.add(client);
            JOptionPane.showMessageDialog(null, client + " a été ajouté.", "Succès", 0);
            System.out.println(listeClient.toString());
        }
    }
    
    /**
     * Vérifie que le client donné en param. n'existe pas déjà dans le set.
     * @param client
     * @return
     */
    public static boolean verifierDoublon(Client client) {
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
    
    /**
     * Avec le username d'un client donné en paramètre, trouve
     * et return ce même client.
     * @param username
     * @return
     */
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
