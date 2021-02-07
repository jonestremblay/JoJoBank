
package modele;


import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class Facture {
    String description;
    String creancier;
    double montant;
    String dateLimite;
    
    public Facture(){
        
    }

    public Facture(String creancier, String description, String dateLimite, double montant) {
        this.description = description;
        this.creancier = creancier;
        this.montant = montant;
        this.dateLimite = dateLimite;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreancier() {
        return creancier;
    }

    public void setCreancier(String creancier) {
        this.creancier = creancier;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(String dateLimite) {
        this.dateLimite = dateLimite;
    }
    
    
    /**
     * Retourne facture en format CSV. 
     * @return csv String
     */
    public String convertirFactureEnLigne(){
        return creancier + ";" +
               description + ";" +
               dateLimite + ";" +
               String.valueOf(montant);

    }
    
    /**
     * Retourne la date de la facture sous le format d'une 
     * facture unique
     * @param dateString
     * @return dd month yyyy
     */
    public static String formatDateFactureUnique(String dateString){
       
        String[] dateData = dateString.split(" ");
        LocalDate date = null;
        try{
        date = LocalDate.of(Integer.parseInt("20" + dateData[2]), Integer.parseInt(dateData[1]), Integer.parseInt(dateData[0]));
        } catch(DateTimeException dte){
            JOptionPane.showMessageDialog(null, "Invalid date. Are you sure this date exists in the calendar ?", dte.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        String[] resultDate = date.toString().split("-");
        String mois;
        switch(Integer.parseInt(resultDate[1])){
            case 1:
                mois = "January";
                break;
            case 2:
                mois = "February";
                break;
            case 3:
                mois = "March";
                break;
            case 4:
                mois = "April";
                break;
            case 5:
                mois = "May";
                break;
            case 6:
                mois = "June";
                break;
            case 7:
                mois = "July";
                break;
            case 8:
                mois = "August";
                break;
            case 9:
                mois = "September";
                break;
            case 10:
                mois = "October";
                break;
            case 11:
                mois = "November";
                break;
            case 12:
                mois = "December";
                break;
            default:
                mois = "???";
                break;
        }
        String formattedDate = mois + " " + resultDate[2] + "th " + resultDate[0];
        System.out.println(formattedDate);
        return formattedDate;
    }
    
    /**
     * Retourne la date de la facture sous le format d'une 
     * date mensuelle : x du mois
     * @param jourDate
     * @return $jourDate du mois
     */
    public static String formatDateFactureMensuelle(String jourDate){
        return jourDate + " of the month";
    }

    @Override
    public String toString() {
        return "Facture{" + "description=" + description + ", creancier=" + creancier + ", montant=" + montant + ", dateLimite=" + dateLimite + '}';
    }
    
    
}
