package utils;


import modele.Client;


public abstract class UserSession {
    
    /* 
    Cette classe me permet de stocker le client qui est connecté, 
    pour simuler une session. Il est utile de conserver son nombre de transactions
    totales, pour générer un id de transaction automatiquement avec la dernière
    transaction entrée.
    */
    
    
    public static Client client = new Client();
    public static int transactionsCount;

   
 
    
}
