
package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modele.Facture;
import modele.FactureTableModel;
import modele.ListeFacture;
import utils.FileManip;
import utils.FormValidation;
import utils.UserSession;


public class FenBills extends javax.swing.JFrame {
    ListeFacture onLoadListeFacture = FileManip.lireFichierAjouterFacture(UserSession.client);
    
    /**
     * Creates new form FenBills
     */
    public FenBills() {
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

        radioBtnGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        background = background =  new JPanel() {
            public void paintComponent(Graphics g) {
                Image img = Toolkit.getDefaultToolkit().getImage(
                    FenConnection.class.getResource("/img/background.png"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        btnMenuPrincipal = new javax.swing.JButton();
        jPanel2 = new JPanel() {
            public void paintComponent(Graphics g) {
                Image img = Toolkit.getDefaultToolkit().getImage(
                    FenConnection.class.getResource("/img/lblAddBills.png"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };  ;
        jPanel3 = new JPanel() {
            public void paintComponent(Graphics g) {
                Image img = Toolkit.getDefaultToolkit().getImage(
                    FenConnection.class.getResource("/img/lblMyBills.png"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };  ;
        creancierField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        montantField = new javax.swing.JTextField();
        ddField = new javax.swing.JTextField();
        mmField = new javax.swing.JTextField();
        yyField = new javax.swing.JTextField();
        rBtnFactureUnique = new javax.swing.JRadioButton();
        rBtnFactureMensuelle = new javax.swing.JRadioButton();
        lblDD = new javax.swing.JLabel();
        lblMM = new javax.swing.JLabel();
        lblYY = new javax.swing.JLabel();
        lblCreancier = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblMontant = new javax.swing.JLabel();
        lblDateLimite = new javax.swing.JLabel();
        btnAjouterFacture = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        factureTable = new javax.swing.JTable();
        FactureTableModel model = new FactureTableModel(onLoadListeFacture.getListeFacture());
        factureTable.setModel(model);
        lblMensualiteString = new javax.swing.JLabel();
        lblMensualite = new javax.swing.JLabel();
        lblTotalDette = new javax.swing.JLabel();
        btnDeleteRow = new javax.swing.JButton();
        lblTotalDettesString = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Your bills");

        background.setForeground(new java.awt.Color(255, 255, 255));

        btnMenuPrincipal.setText("Menu principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        creancierField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creancierFieldActionPerformed(evt);
            }
        });

        radioBtnGroup.add(rBtnFactureUnique);
        rBtnFactureUnique.setForeground(new java.awt.Color(255, 255, 255));
        rBtnFactureUnique.setText("Facture unique");
        rBtnFactureUnique.setOpaque(false);
        rBtnFactureMensuelle.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ie){
                    mmField.setEnabled(false); mmField.setText("");
                    yyField.setEnabled(false); yyField.setText("");
                    mmField.setVisible(true); yyField.setVisible(true);
                    mmField.revalidate(); mmField.repaint();
                    yyField.revalidate(); yyField.repaint();

                }
            });
            rBtnFactureUnique.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent ie){
                        ddField.setEnabled(true);
                        mmField.setEnabled(true);
                        yyField.setEnabled(true);
                    }
                });
                rBtnFactureUnique.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        rBtnFactureUniqueActionPerformed(evt);
                    }
                });

                radioBtnGroup.add(rBtnFactureMensuelle);
                rBtnFactureMensuelle.setForeground(new java.awt.Color(255, 255, 255));
                rBtnFactureMensuelle.setText("Facture mensuelle");
                rBtnFactureMensuelle.setOpaque(false);
                rBtnFactureMensuelle.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent ie){
                            mmField.setEnabled(false); mmField.setText("");
                            yyField.setEnabled(false); yyField.setText("");
                            mmField.setVisible(false); yyField.setVisible(false);
                        }
                    });
                    rBtnFactureUnique.addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent ie){
                                ddField.setEnabled(true);
                                mmField.setEnabled(true);
                                yyField.setEnabled(true);
                            }
                        });

                        lblDD.setForeground(new java.awt.Color(255, 255, 255));
                        lblDD.setText("DD");

                        lblMM.setForeground(new java.awt.Color(255, 255, 255));
                        lblMM.setText("MM");

                        lblYY.setForeground(new java.awt.Color(255, 255, 255));
                        lblYY.setText("YY");

                        lblCreancier.setForeground(new java.awt.Color(255, 255, 255));
                        lblCreancier.setText("Créancier");

                        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
                        lblDescription.setText("Description");

                        lblMontant.setForeground(new java.awt.Color(255, 255, 255));
                        lblMontant.setText("Montant");

                        lblDateLimite.setForeground(new java.awt.Color(255, 255, 255));
                        lblDateLimite.setText("Date limite");

                        btnAjouterFacture.setText("Ajouter facture");
                        btnAjouterFacture.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAjouterFactureActionPerformed(evt);
                            }
                        });

                        jScrollPane2.setViewportView(factureTable);

                        lblMensualiteString.setForeground(new java.awt.Color(255, 255, 255));
                        lblMensualiteString.setText("Mensualité totale :");

                        lblMensualite.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                        String mensualite = String.valueOf(FileManip.lireFichierAjouterFacture(UserSession.client).calculerSommeFactureMensuelle());
                        lblMensualite.setForeground(new java.awt.Color(255, 255, 255));
                        lblMensualite.setText(mensualite + " $");

                        lblTotalDette.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                        String dettes = String.valueOf(FileManip.lireFichierAjouterFacture(UserSession.client).calculerSommeFactureUnique());
                        lblTotalDette.setForeground(new java.awt.Color(255, 255, 255));
                        lblTotalDette.setText(dettes + " $");

                        btnDeleteRow.setText("Delete row");
                        btnDeleteRow.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDeleteRowActionPerformed(evt);
                            }
                        });

                        lblTotalDettesString.setForeground(new java.awt.Color(255, 255, 255));
                        lblTotalDettesString.setText("Total des dettes   :");

                        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
                        background.setLayout(backgroundLayout);
                        backgroundLayout.setHorizontalGroup(
                            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                        .addGap(363, 363, 363)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(creancierField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                                .addComponent(btnDeleteRow)
                                                .addGap(175, 175, 175)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(lblTotalDettesString)
                                                            .addComponent(lblMensualiteString))
                                                        .addGap(47, 47, 47)
                                                        .addComponent(lblTotalDette))
                                                    .addComponent(lblMensualite, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addGap(68, 68, 68))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCreancier)
                                            .addComponent(lblDescription)
                                            .addComponent(lblDateLimite)
                                            .addComponent(montantField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMontant)
                                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnAjouterFacture)
                                                .addGroup(backgroundLayout.createSequentialGroup()
                                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ddField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addComponent(lblDD)))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(mmField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addComponent(lblMM)))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(yyField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addComponent(lblYY)))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(rBtnFactureUnique)
                                                        .addComponent(rBtnFactureMensuelle))))))
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnMenuPrincipal)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                        backgroundLayout.setVerticalGroup(
                            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblMensualiteString)
                                            .addComponent(lblMensualite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDeleteRow))
                                        .addGap(18, 18, 18)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblTotalDettesString)
                                            .addComponent(lblTotalDette, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addComponent(lblCreancier)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(creancierField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDescription)
                                        .addGap(2, 2, 2)
                                        .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDateLimite)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ddField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(mmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(yyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rBtnFactureMensuelle))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblDD)
                                            .addComponent(lblMM)
                                            .addComponent(lblYY)
                                            .addComponent(rBtnFactureUnique))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblMontant)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(montantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnMenuPrincipal)
                                    .addComponent(btnAjouterFacture))
                                .addGap(24, 24, 24))
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

    private void creancierFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creancierFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creancierFieldActionPerformed

    private void rBtnFactureUniqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnFactureUniqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnFactureUniqueActionPerformed

    private void btnAjouterFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterFactureActionPerformed
        String date = "";
        double montant = 0;
        // Vérifie quelle type de facture est séléctionné
        
        if (rBtnFactureUnique.isSelected()) {
            
            if (FormValidation.checkDateValidityFacture(ddField, mmField, yyField)){
                date = Facture.formatDateFactureUnique(ddField.getText() + " " + mmField.getText() + " " + yyField.getText());
            } else{
                JOptionPane.showMessageDialog(rootPane, "Invalid date. Are you sure this date exists in the calendar ?", "Invalid date", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (rBtnFactureMensuelle.isSelected()){

            if (FormValidation.checkDateValidityFacture(ddField, mmField, yyField)){
                date = Facture.formatDateFactureMensuelle(ddField.getText());
            } 
            
        } else if (!rBtnFactureMensuelle.isSelected() && !rBtnFactureUnique.isSelected()){
            JOptionPane.showMessageDialog(rootPane, "Please select a bill type.", "Incorrect bill type", JOptionPane.ERROR_MESSAGE);
        }
        
        
        try {
            montant = Double.parseDouble(montantField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "The amount can't contains letters.", "Invalid amount", JOptionPane.ERROR_MESSAGE);
        }
        if (!date.equals("")){
            Facture facture = new Facture(creancierField.getText(),
                                    descriptionField.getText(), date,
                                    Double.parseDouble(montantField.getText()));
            FileManip.ecrireFactureFichier(UserSession.client, facture);
            onLoadListeFacture.setListeFacture(FileManip.lireFichierAjouterFacture(UserSession.client).getListeFacture());
            // Actualiser la factureTable.
            FactureTableModel model = new FactureTableModel(onLoadListeFacture.getListeFacture());
            factureTable.setModel(model);
            actualiserLabels();
        }
    }//GEN-LAST:event_btnAjouterFactureActionPerformed

    private void btnDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRowActionPerformed
        // On crée un model basé sur la table et son contenu
        FactureTableModel model = new FactureTableModel(FileManip.lireFichierAjouterFacture(UserSession.client).getListeFacture());
        int rowIndexSelected = factureTable.getSelectedRow();
        // On créer la nouvelle liste de facture après DELETION.
        ListeFacture lf = FileManip.getNewListeFactureAfterDeletion(UserSession.client, model.getRow(rowIndexSelected));
        // On overwrite cette nouvelle liste dans le fichier facture
        FileManip.ecrireListeFactureDansFichier(UserSession.client, lf);
        // On créer un nouveau table model avec la nouvelle liste mise à jour
        FactureTableModel newModel = new FactureTableModel(lf.getListeFacture());
        // On met à jour le model de la table.
        factureTable.setModel(newModel);
        actualiserLabels();
    }//GEN-LAST:event_btnDeleteRowActionPerformed
    
    public void actualiserLabels(){
        ListeFacture lf = FileManip.lireFichierAjouterFacture(UserSession.client);
        lblMensualite.setText(String.valueOf(lf.calculerSommeFactureMensuelle()));
        lblTotalDette.setText(String.valueOf(lf.calculerSommeFactureUnique()));
        creancierField.setText(""); descriptionField.setText("");
        ddField.setText(""); mmField.setText(""); yyField.setText("");
        montantField.setText("");
    }
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAjouterFacture;
    private javax.swing.JButton btnDeleteRow;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JTextField creancierField;
    private javax.swing.JTextField ddField;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JTable factureTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCreancier;
    private javax.swing.JLabel lblDD;
    private javax.swing.JLabel lblDateLimite;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblMM;
    private javax.swing.JLabel lblMensualite;
    private javax.swing.JLabel lblMensualiteString;
    private javax.swing.JLabel lblMontant;
    private javax.swing.JLabel lblTotalDette;
    private javax.swing.JLabel lblTotalDettesString;
    private javax.swing.JLabel lblYY;
    private javax.swing.JTextField mmField;
    private javax.swing.JTextField montantField;
    private javax.swing.JRadioButton rBtnFactureMensuelle;
    private javax.swing.JRadioButton rBtnFactureUnique;
    private javax.swing.ButtonGroup radioBtnGroup;
    private javax.swing.JTextField yyField;
    // End of variables declaration//GEN-END:variables

}
