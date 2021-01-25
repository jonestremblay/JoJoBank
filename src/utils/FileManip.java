/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Client;
import modele.ListeClient;

/**
 *
 * @author Jones
 */
public class FileManip {
    
    final static String DIRECTORY = "DATA/registreClients";

    /**
     * Cette méthode écris dans le fichier registre un nouveau client
     * de la banque, de façon encrypté.
     * @param client
     */
    public static void ecrireClientDansRegistre(Client client){
        // 1. create the directory where the files are stored, if not already.
        String directory = "DATA/registreClients";
        Path path = Paths.get(directory);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 2. Create the file for the data.
        File registre = new File(directory + "/" + "registre.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        
        try {
            fw = new FileWriter(registre, true);
            bw = new BufferedWriter(fw);
            // Écriture
            bw.write(encryptData(Client.convertirClientLigne(client)) + "\n");
        } catch (IOException e){
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException ex){
                    Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Cette méthode lit le registre, le décrypte au passage, afin de vérifier
     * si le client en paramètre existe.
     * @param loginInfo
     *          Suite à la lecture du registre...
     * @return  [false: existePas , true: existe]
     */
    public static Client getClientFromFile(String username, String password){
         // 1. create the directory where the files are stored, if not already.
        Path path = Paths.get(DIRECTORY);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File(DIRECTORY + "/" + "registre.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null){
                //clientExist = verifierClientExiste(decryptData(ligne), loginInfo);
                ligne = decryptData(ligne);
                String[] tokens = ligne.split(";");
                // No need for variables here, but for reading purposes...
                String nameRegistre = tokens[0];
                String userRegistre = tokens[1];
                String passRegistre = tokens[2];

                if(username.equals(userRegistre)){
                    if(password.equals(passRegistre)){
                        return new Client(tokens[0], tokens[1], tokens[2]);
                    }
                }
            }
        } catch (IOException e){
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (br != null){
                try{
                    br.close();
                } catch (IOException e){
                    Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return new Client(); 
    // Should never happen since the method is called after checking the user exists
    }
    
    
    public static boolean chercherClientDansSet(String user, String pass){
        Client client = new Client(user, pass);
        for (Object c : ListeClient.getListeClient()){
            if (client.equals(c)){
                return true;
            }
        }
        return false;
    }
    /**
     *
     * @param data
     * @return [data encrypté]
     */
    public static String encryptData(String data){
        final int KEY = 14;
        //System.out.println("Encryption en cours...");
        StringBuilder encryptedData = new StringBuilder();
        char[] dataChars = data.toCharArray();
        for (char c : dataChars){
            c += KEY;
            encryptedData.append(c);
        }
        //System.out.println(encryptedData.toString());
        return encryptedData.toString();
    }
    
    /**
     *
     * @param encryptedData
     * @return [data décryptée]
     */
    public static String decryptData(String encryptedData){
        final int KEY = 14;
        //System.out.println("Décryption en cours...");
        StringBuilder decryptedData = new StringBuilder();
        char[] dataChars = encryptedData.toCharArray();
        for(char c : dataChars){
            c -= KEY;
            decryptedData.append(c);
        }
        //System.out.println(decryptedData.toString());
        return decryptedData.toString();
    }
    
 
    
    /**
     * Charge la collection contenant les clients inscrits,
     * à partir du registreClient(fichier).
     */
    public static void chargerCollectionClient(){
        // 1. Store les client en hashset
        Set listeClient = new HashSet();
        File registre = new File(DIRECTORY + "/" + "registre.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null){
                listeClient.add(convertirLigneClient(decryptData(ligne), ";"));
            }
        } catch (IOException e){
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (br != null){
                try{
                    br.close();
                } catch (IOException e){
                    Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        
        ListeClient.setListeClient(listeClient);
    }
    
    /**
     *
     * @param ligne
     * @param delimeter ; , . / (what separate values in CSV file)
     * @return
     */
    public static Client convertirLigneClient(String ligne, String delimeter){
        String[] tokens = ligne.split(delimeter);
        return new Client(tokens[0], tokens[1], tokens[2]);
    }
}
