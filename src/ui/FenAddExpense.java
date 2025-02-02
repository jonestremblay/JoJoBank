
package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import modele.Client;
import modele.ListeClient;
import modele.Transaction;
import utils.FileManip;
import utils.FormValidation;
import utils.UserSession;


public class FenAddExpense extends javax.swing.JFrame {
    FenExpenses fenExpenses = new FenExpenses();
    
    /**
     * Creates new form FenAddExpanse
     */
    public FenAddExpense() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = background =  new JPanel() {
            public void paintComponent(Graphics g) {
                Image img = Toolkit.getDefaultToolkit().getImage(
                    FenConnection.class.getResource("/img/wowBackground.png"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        btnMenuPrincipal = new javax.swing.JButton();
        btnSeeExpenses = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        lblCategorie = new javax.swing.JLabel();
        lblCommerce = new javax.swing.JLabel();
        lblMontant = new javax.swing.JLabel();
        lblShareWith = new javax.swing.JLabel();
        lblNotes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        montantField = new javax.swing.JTextField();
        commerceField = new javax.swing.JTextField();
        categorieField = new javax.swing.JTextField();
        lblDD = new javax.swing.JLabel();
        lblMM = new javax.swing.JLabel();
        lblYY = new javax.swing.JLabel();
        ddField = new javax.swing.JTextField();
        mmField = new javax.swing.JTextField();
        yyField = new javax.swing.JTextField();
        String[] usersArray = FileManip.getAllUsernamesFromListeClient().toArray(new String[]{});
        shareWithComboBox = new javax.swing.JComboBox<>();
        btnAjouter = new javax.swing.JButton();
        lblLastBillAdded = new javax.swing.JLabel();
        lblLastBillCAndC = new javax.swing.JLabel();
        lblLastBillDate = new javax.swing.JLabel();
        lblLastBillMontant = new javax.swing.JLabel();
        lblAddExpenses = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add an expense");
        setResizable(false);

        btnMenuPrincipal.setBackground(new java.awt.Color(25, 23, 26));
        btnMenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuPrincipal.setText("Home Menu");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });

        btnSeeExpenses.setBackground(new java.awt.Color(25, 23, 26));
        btnSeeExpenses.setForeground(new java.awt.Color(255, 255, 255));
        btnSeeExpenses.setText("See all my expenses");
        btnSeeExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeExpensesActionPerformed(evt);
            }
        });

        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date");

        lblCategorie.setForeground(new java.awt.Color(255, 255, 255));
        lblCategorie.setText("Category");

        lblCommerce.setForeground(new java.awt.Color(255, 255, 255));
        lblCommerce.setText("Merchant");

        lblMontant.setForeground(new java.awt.Color(255, 255, 255));
        lblMontant.setText("Amount");

        lblShareWith.setForeground(new java.awt.Color(255, 255, 255));
        lblShareWith.setText("Share with");

        lblNotes.setForeground(new java.awt.Color(255, 255, 255));
        lblNotes.setText("Notes");

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        jScrollPane1.setViewportView(notesTextArea);

        lblDD.setForeground(new java.awt.Color(255, 255, 255));
        lblDD.setText("DD");

        lblMM.setForeground(new java.awt.Color(255, 255, 255));
        lblMM.setText("MM");

        lblYY.setForeground(new java.awt.Color(255, 255, 255));
        lblYY.setText("YY");

        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        yyField.setText(String.valueOf(currYear).substring(2));
        yyField.setEditable(false);

        shareWithComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(usersArray));
        shareWithComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shareWithComboBoxActionPerformed(evt);
            }
        });

        btnAjouter.setBackground(new java.awt.Color(25, 23, 26));
        btnAjouter.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouter.setText("Add expense");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        lblLastBillAdded.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLastBillAdded.setForeground(new java.awt.Color(255, 255, 255));
        lblLastBillAdded.setText("Last transaction added:");

        lblLastBillCAndC.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblLastBillCAndC.setForeground(new java.awt.Color(255, 255, 255));
        lblLastBillCAndC.setText("");
        lblLastBillCAndC.setText(fenExpenses.onLoadListeTransaction.getListeTransaction().get(fenExpenses.onLoadListeTransaction.getListeTransaction().toArray().length - 1).getCommerce()
            + " | " + fenExpenses.onLoadListeTransaction.getListeTransaction().get(fenExpenses.onLoadListeTransaction.getListeTransaction().toArray().length - 1).getCategorie());

        lblLastBillDate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblLastBillDate.setForeground(new java.awt.Color(255, 255, 255));
        lblLastBillDate.setText("");
        lblLastBillDate.setText(String.valueOf(fenExpenses.onLoadListeTransaction.getListeTransaction().get(fenExpenses.onLoadListeTransaction.getListeTransaction().toArray().length - 1).getDate()));

        lblLastBillMontant.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblLastBillMontant.setForeground(new java.awt.Color(255, 255, 255));
        lblLastBillMontant.setText("");
        lblLastBillMontant.setText(String.valueOf(fenExpenses.onLoadListeTransaction.getListeTransaction().get(fenExpenses.onLoadListeTransaction.getListeTransaction().toArray().length - 1).getMontant()) + " $");

        lblAddExpenses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lblAddExpenses.png"))); // NOI18N

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenuPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeeExpenses)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(0, 72, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblShareWith, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMontant, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNotes, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCommerce, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCategorie, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shareWithComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addComponent(montantField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLastBillMontant))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                    .addComponent(commerceField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLastBillCAndC))
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(categorieField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                            .addComponent(ddField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(mmField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(yyField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(lblDD)
                                            .addGap(28, 28, 28)
                                            .addComponent(lblMM)
                                            .addGap(29, 29, 29)
                                            .addComponent(lblYY)))
                                    .addGap(125, 125, 125)
                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLastBillDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblLastBillAdded)))
                                .addComponent(lblAddExpenses, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btnAjouter)))
                .addGap(40, 40, 40))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lblAddExpenses)
                .addGap(33, 33, 33)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(lblLastBillAdded)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLastBillDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLastBillCAndC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLastBillMontant)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblYY)
                            .addComponent(lblMM)
                            .addComponent(lblDD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ddField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categorieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategorie))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(commerceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCommerce))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(montantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontant))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(shareWithComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblShareWith))
                        .addGap(18, 18, 18)))
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNotes))
                .addGap(26, 26, 26)
                .addComponent(btnAjouter)
                .addGap(41, 41, 41)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeeExpenses)
                    .addComponent(btnMenuPrincipal))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
       FenAppUI fenAppUi = new FenAppUI();
       fenAppUi.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void shareWithComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shareWithComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shareWithComboBoxActionPerformed

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.FRENCH);
        String strDate = ""; String commerce = ""; String categorie = "";
        double montant = 0; String notes = "";
        LocalDate date = null;
        String user = shareWithComboBox.getSelectedItem().toString();
        Client shareWith = ListeClient.getClientWithUsername(user);
        
        // Vérifie que la date est valide, pour continuer
        if(FormValidation.checkDateValidityFacture(ddField, mmField, yyField)){
            date = FormValidation.getLocalDateFromString(ddField, mmField, yyField);
            strDate = date.format(formatter);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Invalid date. Are you sure this date exists in the calendar ?", "Invalid date", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            montant = Double.parseDouble(montantField.getText());
            commerce = commerceField.getText();
            categorie = categorieField.getText();
            notes = notesTextArea.getText();
            
            if (!strDate.equals("")){
                // Créer la transaction
                Transaction transaction = new Transaction(
                date, categorie, commerce, notes, montant, UserSession.transactionsCount + 1, shareWith);
                // Écrire la transaction dans le fichier
                FileManip.ecrireTransactionFichier(UserSession.client, transaction);
                resetTextFields();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "The amount can't contains letters.", "Invalid amount", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnSeeExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeExpensesActionPerformed
        FenExpenses fenExpenses = new FenExpenses();
        fenExpenses.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeeExpensesActionPerformed
    
    private void resetTextFields(){
        ddField.setText(""); mmField.setText("");
        commerceField.setText(""); categorieField.setText("");
        montantField.setText(""); notesTextArea.setText("");
        // Met à jour la dernière transaction entrée
        refreshLastTransactionEntered();
    }
    
    private void refreshLastTransactionEntered(){
        fenExpenses.setVisible(false);
        fenExpenses.refreshExpenseTable();
        int lastIndex = fenExpenses.onLoadListeTransaction.getListeTransaction().toArray().length - 1;
        lblLastBillDate.setText(String.valueOf(fenExpenses.onLoadListeTransaction.getListeTransaction().get(lastIndex).getDate())); 
        lblLastBillCAndC.setText(fenExpenses.onLoadListeTransaction.getListeTransaction().get(lastIndex).getCommerce()
                                + " | " + fenExpenses.onLoadListeTransaction.getListeTransaction().get(lastIndex).getCategorie());
        lblLastBillMontant.setText(String.valueOf(fenExpenses.onLoadListeTransaction.getListeTransaction().get(lastIndex).getMontant()) + " $");
    }
        
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnSeeExpenses;
    private javax.swing.JTextField categorieField;
    private javax.swing.JTextField commerceField;
    private javax.swing.JTextField ddField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddExpenses;
    private javax.swing.JLabel lblCategorie;
    private javax.swing.JLabel lblCommerce;
    private javax.swing.JLabel lblDD;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLastBillAdded;
    private javax.swing.JLabel lblLastBillCAndC;
    private javax.swing.JLabel lblLastBillDate;
    private javax.swing.JLabel lblLastBillMontant;
    private javax.swing.JLabel lblMM;
    private javax.swing.JLabel lblMontant;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblShareWith;
    private javax.swing.JLabel lblYY;
    private javax.swing.JTextField mmField;
    private javax.swing.JTextField montantField;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JComboBox<String> shareWithComboBox;
    private javax.swing.JTextField yyField;
    // End of variables declaration//GEN-END:variables
}
