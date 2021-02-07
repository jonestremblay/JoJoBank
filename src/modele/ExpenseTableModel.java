/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jones
 */
public class ExpenseTableModel extends AbstractTableModel{

    private String[] columnNames = {"Date", "Catégorie", "Commerce", "Notes", "Montant", "# de facture", "ShareWith"};
    private ArrayList<Transaction> listeTransactions;
    
    public ExpenseTableModel(ArrayList<Transaction> listeT){
        listeTransactions = listeT;
    }
    
    @Override
    public int getRowCount() {
        int size;
        if (listeTransactions == null) {
            size = 0;
        } else {
            size = listeTransactions.size();
        }
        return size;
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object tmp = null;
        switch (columnIndex) {
            case 0:
                tmp = listeTransactions.get(rowIndex).getDate();
                break;
            case 1:
                tmp = listeTransactions.get(rowIndex).getCategorie();
                break;
            case 2:
                tmp = listeTransactions.get(rowIndex).getCommerce();
                break;
            case 3:
                tmp = listeTransactions.get(rowIndex).getTexteNotes();
                break;
            case 4:
                tmp = listeTransactions.get(rowIndex).getMontant();
                break;
            case 5:
                tmp = listeTransactions.get(rowIndex).getNumeroFacture();
                break;
            case 6:
                tmp = listeTransactions.get(rowIndex).getShareWith();
                break;
            default:
                break;
        }
        return tmp;
    }
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    public Class getColumnsClass(int col){
        switch (col) {
            case 0:
                return LocalDate.class;
            case 4:
                return Double.class;
            case 5:
                return Integer.class;
            case 6:
                return Client.class;
            default:
                return String.class;
        }
    }
    
    /**
     * Retourne un objet transaction correspondant à la rangée
     * donnée en paramètre
     * @param row
     * @return Transaction transactionDeLaRangée
     */
    public Transaction getRow(int row){
        LocalDate date = (LocalDate) getValueAt(row, 0);
        String categorie = String.valueOf(getValueAt(row, 1));
        String commerce = String.valueOf(getValueAt(row, 2));
        String notes = String.valueOf(getValueAt(row, 3));
        double montant = (double)getValueAt(row, 4);
        int numeroFacture = (int)getValueAt(row, 5);
        Client shareWith = (Client)getValueAt(row, 6);
        return new Transaction(date, categorie, commerce, notes,
                               montant, numeroFacture, shareWith);
    }
}
