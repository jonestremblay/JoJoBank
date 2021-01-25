/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import modele.Client;

/**
 *
 * @author Jones
 */
public class ClientExistantException extends Exception{
    private Client client;

    public ClientExistantException(){
        
    }
    
    public ClientExistantException(Client client, String message) {
        super(message);
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientExistantException{" + "client=" + client + '}';
    }
    
    
}
