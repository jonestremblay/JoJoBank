/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Objects;

/**
 *
 * @author Jones
 */
public class Client{
    private String name;
    private String username;
    private String password;

    private ListeFacture listeFacture;
    public Client(){
        
    }
    
    public Client(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public Client(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.listeFacture = new ListeFacture();
    }
    
    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public ListeFacture getListeFacture() {
        return listeFacture;
    }
    
    public void setListeFacture(ListeFacture listeFacture) {
        this.listeFacture = listeFacture;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    /**
     * Converti un objet Client en ligne
     * @param client
     * @return
     */
    public static String convertirClientLigne(Client client){
        return client.getName() + ";" + client.getUsername() + ";" + client.getPassword();
    }
    
    
    
    
    
    @Override
    public String toString() {
        return username;
    }
    
}
