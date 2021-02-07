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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Client;
import modele.Facture;
import modele.ListeClient;
import modele.ListeFacture;
import modele.ListeTransaction;
import modele.Transaction;

/*  Cette classe me permet d'organiser mes méthodes 
    qui manipulent les fichiers de données 
*/
public class FileManip {
    
    /**
     * Cette méthode écris dans le fichier registre un nouveau client
     * de la banque, de façon encrypté.
     * @param client
     */
    public static void ecrireClientDansRegistre(Client client){
        // 1. create the directory where the files are stored, if not already.
        Path path = Paths.get("DATA/registreClients");
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 2. Create the file for the data.
        File registre = new File("DATA/registreClients/" + "registre.txt");
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
     * Cette méthode lit le registre client, le décrypte au passage, afin de trouver
     * et retourner le client correspondant aux données entrés en paramètre, s'il existe.
     * @param username
     * @param password
     * @return  objet Client correspondant
     */
    public static Client getClientFromFile(String username, String password){
         // 1. create the directory where the files are stored, if not already.
        Path path = Paths.get("DATA/registreClients");
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File("DATA/registreClients/" + "registre.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null){
                ligne = decryptData(ligne);
                String[] tokens = ligne.split(";");
                // No need for variables here, but for reading purposes...
                String nameRegistre = tokens[0];
                String userRegistre = tokens[1];
                String passRegistre = tokens[2];

                if(username.equals(userRegistre)){
                    if(password.equals(passRegistre)){
                        return new Client(nameRegistre, userRegistre, passRegistre);
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
        return new Client(); // Should never happen since the method is called after checking the user exists
    }
    
    /**
     * Vérifie si le client correspondant aux données entrée en paramètre
     * existe déjà dans la listeClient.
     * @param user
     * @param pass
     * @return [false: existePas , true: existe]
     */
    public static boolean chercherClientDansListe(String user, String pass){
        Client client = new Client(user, pass);
        for (Object c : ListeClient.getListeClient()){
            if (client.equals(c)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Encrypte la ligne donnée
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
     * Décrypte la ligne donnée
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
        File registre = new File("DATA/registreClients/" + "registre.txt");
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
     * Transforme une ligne donnée en objet client.
     * @param ligne
     * @param delimeter ; , . / (what separate values in CSV file)
     * @return objet Client
     */
    public static Client convertirLigneClient(String ligne, String delimeter){
        String[] tokens = ligne.split(delimeter);
        return new Client(tokens[0], tokens[1], tokens[2]);
    }
    
    
    /**
     * Lis le fichier contenant les factures, créer des objets factures pour chaque
     * ligne, puis ajoute ces objets à sa liste
     * @param client
     * @return ListeFacture
     */
    public static ListeFacture lireFichierAjouterFacture(Client client){
          // 1. create the directory where the files are stored, if not already.
        String repertoire = "DATA/registreFactures";
        Path path = Paths.get(repertoire);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File(repertoire + "/" + client.getUsername() + "-factures.txt");
        FileReader fr = null;
        BufferedReader br = null;
        ListeFacture lf = new ListeFacture();
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null){
               lf.getListeFacture().add(convertirLigneFacture(ligne));
            }
            return lf;
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
        return lf;
    }

    /**
     * Converti une ligne donnée en un objet Facture.
     * @param ligne
     * @return objet Facture
     */
    public static Facture convertirLigneFacture(String ligne){
        String[] tokens = ligne.split(";");
        return new Facture(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]));
    }


    /**
     * Rajoute une facture dans le fichier de facture.
     * @param client
     * @param facture
     */
    public static void ecrireFactureFichier(Client client, Facture facture){
        String repertoire = "DATA/registreFactures";
        Path path = Paths.get(repertoire);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 2. Create the file for the data.
        File registre = new File(repertoire + "/" + client.getUsername() + "-factures.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(registre, true);
            bw = new BufferedWriter(fw);
            // Écriture
            bw.write(facture.convertirFactureEnLigne()+ "\n");
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
     * Get new ListeFacture after having deleted the choosen row, so we could rewrite the file.
     * @param client
     * @param facture
     * @return new ListeFacture
     */
    public static ListeFacture getNewListeFactureAfterDeletion(Client client, Facture factureToDelete){
          // 1. create the directory where the files are stored, if not already.
        String repertoire = "DATA/registreFactures";
        Path path = Paths.get(repertoire);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File(repertoire + "/" + client.getUsername() + "-factures.txt");
        FileReader fr = null;
        BufferedReader br = null;
        ListeFacture lf = new ListeFacture();
        String lineToRemove = factureToDelete.convertirFactureEnLigne();
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null){
               if(!ligne.equals(lineToRemove)){
                    lf.getListeFacture().add(convertirLigneFacture(ligne));}
            }
            return lf;
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
        return lf;
    }
    
    /**
     * Overwrites the facture's file with an entire ListeFacture, instead of only one
     * facture. Called after having deleting one in the list.
     * @param client
     * @param lf
     */
    public static void ecrireListeFactureDansFichier(Client client, ListeFacture lf){
        String repertoire = "DATA/registreFactures";
        Path path = Paths.get(repertoire);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 2. Create the file for the data.
        File registre = new File(repertoire + "/" + client.getUsername() + "-factures.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(registre);
            bw = new BufferedWriter(fw);
            // Écriture
            for (Facture f: lf.getListeFacture()){
                bw.write(f.convertirFactureEnLigne() + "\n");
            }
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
     * Lis le fichier contenant les transactions d'un client, et créer un objet
     * Transaction pour chaque ligne, puis l'ajoute à sa liste. 
     * @param client
     * @return ListeTransaction
     */
    public static ListeTransaction lireFichierTransaction(Client client){
        String repertoire = "DATA/registreTransactions";
        Path path = Paths.get(repertoire);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File(repertoire + "/" + client.getUsername() + "-transactions.txt");
        FileReader fr = null;
        BufferedReader br = null;
        ListeTransaction lt = new ListeTransaction();
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null){
               lt.getListeTransaction().add(convertirLigneTransaction(ligne));
            }
            return lt;
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
        return lt;
    }
    
    /**
     * Ajoute la transaction donnée en paramètre dans le fichier transaction du
     * client donné en paramètre.
     * @param client
     * @param transaction
     */
    public static void ecrireTransactionFichier(Client client, Transaction transaction){
        String repertoire = "DATA/registreTransactions";
        Path path = Paths.get(repertoire);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File(repertoire + "/" + client.getUsername() + "-transactions.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(registre, true);
            bw = new BufferedWriter(fw);
            // Écriture
            bw.write(transaction.convertirTransactionLigne() + "\n");
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
     * Avec une ligne donnée en paramètre, créer un objet Transaction
     * @param ligne
     * @return objet Transaction
     */
    public static Transaction convertirLigneTransaction(String ligne) {
        String[] data = ligne.split(";");
        String[] strDate = data[0].split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1]), Integer.parseInt(strDate[2]));
        Transaction transaction = new Transaction(date, data[1], data[2], data[3],
                Double.parseDouble(data[4]), Integer.parseInt(data[5]), ListeClient.getClientWithUsername(data[6]));
        return transaction;
    }
    
    /**
     * Search in ListeClient a client with the same username. If found,
     * return that wantedClient.
     * @param username
     * @return theWantedClient obj
     */
    public static Object getClientFromListe(String username){
        Client result = null;
        for (Object c : ListeClient.getListeClient()){

               if(((Client)c).getUsername().equals(username)){
                   result = (Client)c;
               }
        }
        return result;
        
    }

    /**
     * Utilisée pour générer le combo box des utilisateurs pouvant share une transaction.
     * Lis le fichier registreClient, et ajoute tous les username dans son ArrayList.
     * @return une ArrayList de tous les usernames de la banque
     */
    public static ArrayList<String> getAllUsernamesFromListeClient(){
        ArrayList<String> listeClient = new ArrayList<String>();
        File registre = new File("DATA/registreClients/" + "registre.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null){
                Client c = convertirLigneClient(decryptData(ligne), ";");
                listeClient.add(c.getUsername());
            }
            return listeClient;
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
        return listeClient;
    }
    
    /**
     * Get new ListeTransaction after having deleted the choosen row, so we could rewrite the file.
     * @param client
     * @param transactionToDelete
     * @return ListeTransaction
     */
    public static ListeTransaction getNewListeTransactionAfterDeletion(Client client, Transaction transactionToDelete){
        String repertoire = "DATA/registreTransactions";
        Path path = Paths.get(repertoire);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File(repertoire + "/" + client.getUsername() + "-transactions.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String lineToRemove = transactionToDelete.convertirTransactionLigne();
        ListeTransaction lt = new ListeTransaction();
        try {
            fr = new FileReader(registre);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null){
                if (!ligne.equals(lineToRemove)){
                    lt.getListeTransaction().add(convertirLigneTransaction(ligne));
                }
            }
            return lt;
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
        return lt;
    }
    
    /**
     * Overwrites the entire transaction's file of the client, with the new
     * ListeTransaction after a deletion (after having called getNewListeTransactionAfterDeletion() )
     * @param client
     * @param lt
     */
    public static void ecrireListeTransactionFichier(Client client, ListeTransaction lt){
        String repertoire = "DATA/registreTransactions";
        Path path = Paths.get(repertoire);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManip.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Read the file
        File registre = new File(repertoire + "/" + client.getUsername() + "-transactions.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(registre);
            bw = new BufferedWriter(fw);
            // Écriture
            for (Transaction t : lt.getListeTransaction()){
                bw.write(t.convertirTransactionLigne() + "\n");
            }
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
}
