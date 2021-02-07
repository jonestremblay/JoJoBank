
package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import modele.ExpenseTableModel;
import modele.ListeTransaction;
import utils.FileManip;
import utils.UserSession;


public class FenExpenses extends javax.swing.JFrame {
    public  ListeTransaction onLoadListeTransaction = FileManip.lireFichierTransaction(UserSession.client);

   
    public FenExpenses() {
        initComponents();
        UserSession.transactionsCount = expensesTable.getRowCount();
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
                    FenConnection.class.getResource("/img/background.png"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        expensesTable = new javax.swing.JTable();
        btnMenuPrincipal = new javax.swing.JButton();
        lblTitre = new javax.swing.JLabel();
        btnAddExpense = new javax.swing.JButton();
        btnDeleteRow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("See expenses");
        setResizable(false);

        onLoadListeTransaction = FileManip.lireFichierTransaction(UserSession.client);
        ExpenseTableModel model = new ExpenseTableModel(onLoadListeTransaction.getListeTransaction());
        expensesTable.setModel(model);
        jScrollPane1.setViewportView(expensesTable);

        btnMenuPrincipal.setBackground(new java.awt.Color(25, 23, 26));
        btnMenuPrincipal.setForeground(new java.awt.Color(255, 102, 196));
        btnMenuPrincipal.setText("Home Menu");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });

        lblTitre.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        lblTitre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/myExpenses_Pink.png"))); // NOI18N

        btnAddExpense.setBackground(new java.awt.Color(25, 23, 26));
        btnAddExpense.setForeground(new java.awt.Color(255, 102, 196));
        btnAddExpense.setText("Add an expanse");
        btnAddExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExpenseActionPerformed(evt);
            }
        });

        btnDeleteRow.setBackground(new java.awt.Color(25, 23, 26));
        btnDeleteRow.setForeground(new java.awt.Color(255, 102, 196));
        btnDeleteRow.setText("Delete this expense");
        btnDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnDeleteRow)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(lblTitre)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(btnAddExpense)
                        .addContainerGap())))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(btnMenuPrincipal)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteRow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnAddExpense)
                .addContainerGap())
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addContainerGap(571, Short.MAX_VALUE)
                    .addComponent(btnMenuPrincipal)
                    .addContainerGap()))
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

    private void btnAddExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExpenseActionPerformed
        FenAddExpense fenAddExpense = new FenAddExpense();
        fenAddExpense.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddExpenseActionPerformed

    private void btnDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRowActionPerformed
        // On crée un model basé sur la table et son contenu
        ExpenseTableModel model = new ExpenseTableModel(FileManip.lireFichierTransaction(UserSession.client).getListeTransaction());
        int rowIndexSelected = expensesTable.getSelectedRow();
        // On créer la nouvelle liste de transaction après DELETION.
        ListeTransaction lt = FileManip.getNewListeTransactionAfterDeletion(UserSession.client, model.getRow(rowIndexSelected));
        // On overwrite cette nouvelle liste dans le fichier transaction
        FileManip.ecrireListeTransactionFichier(UserSession.client, lt);
        // On créer un nouveau table model avec la nouvelle liste mise à jour
        ExpenseTableModel newModel = new ExpenseTableModel(lt.getListeTransaction());
        // On met à jour le model de la table.
        expensesTable.setModel(newModel);
    }//GEN-LAST:event_btnDeleteRowActionPerformed
    
    public void refreshExpenseTable(){
        onLoadListeTransaction = FileManip.lireFichierTransaction(UserSession.client);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAddExpense;
    private javax.swing.JButton btnDeleteRow;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JTable expensesTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitre;
    // End of variables declaration//GEN-END:variables
}
