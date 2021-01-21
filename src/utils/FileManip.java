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
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Client;

/**
 *
 * @author Jones
 */
public class FileManip {
    
    /**
     * Cette méthode écris dans le registre un nouveau client
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
     * Cette méthode ne fais pas seulement que lire le registre, 
     * elle le décrypte(à sa lecture) au passage, et vérifie en même temps
     * si le client existe dans notre registre de clients.
     * @param loginInfo
     *          Suite à la lecture du registre...
     * @return  [false: existePas , true: existe]
     */
    public static boolean lireRegistreClients(String[] loginInfo){
         // 1. create the directory where the files are stored, if not already.
        String directory = "DATA/registreClients";
        Path path = Paths.get(directory);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File(directory + "/" + "registre.txt");
        FileReader fr = null;
        BufferedReader br = null;
        boolean clientExist = false;
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            
            // Lecture 
            String ligne;
            //StringBuilder decrypted = new StringBuilder();
            while ((ligne = br.readLine()) != null){
                clientExist = verifierClientExiste(decryptData(ligne), loginInfo);
               // decrypted.append(decryptData(ligne)).append("\n");
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
        return clientExist;
    }
    
    /**
     *
     * @param data
     * @return [data encrypté]
     */
    public static String encryptData(String data){
        final int KEY = 14;
        System.out.println("Encryption en cours...");
        StringBuilder encryptedData = new StringBuilder();
        char[] dataChars = data.toCharArray();
        for (char c : dataChars){
            c += KEY;
            encryptedData.append(c);
        }
        System.out.println(encryptedData.toString());
        return encryptedData.toString();
    }
    
    /**
     *
     * @param encryptedData
     * @return [data décryptée]
     */
    public static String decryptData(String encryptedData){
        final int KEY = 14;
        System.out.println("Décryption en cours...");
        StringBuilder decryptedData = new StringBuilder();
        char[] dataChars = encryptedData.toCharArray();
        for(char c : dataChars){
            c -= KEY;
            decryptedData.append(c);
        }
        System.out.println(decryptedData.toString());
        return decryptedData.toString();
    }
    
    /**
     *
     * @param decryptedLigne
     * @param loginInfo
     * @return [Si le client existe dans le registre]
     */
    public static boolean verifierClientExiste(String decryptedLigne, String[] loginInfo){
        boolean exist = false;
        String[] tokens = decryptedLigne.split(";");
        // No need for variables here, but for reading purposes...
        String userRegistre = tokens[1];
        String passRegistre = tokens[2];
        
        if(loginInfo[0].equals(userRegistre)){
            if(loginInfo[1].equals(passRegistre)){
                exist = true;
            }
        } else {
            exist = false;
        }
        return exist;
    }
}
