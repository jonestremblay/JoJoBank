
package utils;

import java.util.Comparator;
import modele.Client;


public class ClientComparator implements Comparator<Client>{

    @Override
    public int compare(Client o1, Client o2) {
      if (o1.getUsername().equals(o2.getUsername())){
            if(o1.getPassword().equals(o2.getPassword())){
                return 0;
            } 
        }
        return -1;
    }
    
}
