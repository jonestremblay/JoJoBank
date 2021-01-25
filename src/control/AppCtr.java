/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashSet;
import javax.swing.JFrame;
import modele.ListeClient;
import ui.FenConnection;
import utils.FileManip;

/**
 *
 * @author Jones
 */
public class AppCtr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            FileManip.chargerCollectionClient();
            FenConnection fenConnection = new FenConnection();
            fenConnection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenConnection.setSize(660, 550);
            fenConnection.setVisible(true);
            fenConnection.setTitle("Connexion à Jojo's Bank");
    }
    
}
