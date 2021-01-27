/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import utils.UserSession;

/**
 *
 * @author Jones
 */
public class FactureTableModel extends AbstractTableModel{
    
    private String[] columnNames = {"Créancier", "Description", "Date Limite", "Montant"};
    private ArrayList<Facture> listeFacture;
    
    public FactureTableModel(ArrayList<Facture> listeF){
        listeFacture = listeF;
    }
    
    @Override
    public int getRowCount() {
        int size;
        if (listeFacture == null) {
            size = 0;
        } else {
            size = listeFacture.size();
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
                tmp = listeFacture.get(rowIndex).getCreancier();
                break;
            case 1:
                tmp = listeFacture.get(rowIndex).getDescription();
                break;
            case 2:
                tmp = listeFacture.get(rowIndex).getDateLimite();
                break;
            case 3:
                tmp = listeFacture.get(rowIndex).getMontant();
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
            case 3:
                return Double.class;
            default:
                return String.class;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void removeRow(int row){
        listeFacture.remove(row);
        fireTableRowsDeleted(row, row);
    }
    public void addRow(Facture facture){
        listeFacture.add(facture);
        fireTableRowsInserted(listeFacture.size() -1, listeFacture.size() -1);
    }
    
    public Facture getRow(int row){
        String creancier = String.valueOf(getValueAt(row, 0));
        String description = String.valueOf(getValueAt(row, 1));
        String dateLimite = String.valueOf(getValueAt(row, 2));
        double montant = Double.parseDouble(String.valueOf(getValueAt(row, 3)));
        return new Facture(creancier, description, dateLimite, montant);
    }
    
   
}
