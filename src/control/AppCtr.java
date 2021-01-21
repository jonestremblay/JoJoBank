/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JFrame;
import ui.FenConnection;

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
        
            FenConnection fenConnection = new FenConnection();
            fenConnection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenConnection.setSize(600,400);
            fenConnection.setVisible(true);
            fenConnection.setTitle("Connexion à Jojo's Bank");
    }
    
}
