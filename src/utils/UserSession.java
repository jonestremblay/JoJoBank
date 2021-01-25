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
public class UserSession {
    public static Client client;

    public UserSession(){
        
    }
    
    public UserSession(Client client){
        this.client = client;
    }
    
 
    
}
