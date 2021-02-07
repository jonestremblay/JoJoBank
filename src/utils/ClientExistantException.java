
package utils;

import modele.Client;


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
