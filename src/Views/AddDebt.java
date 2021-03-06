/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.DBManager;
import Classes.Debt;
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;

/**Add Debt View
 *This is the menu for adding new debts to the database
 * @author Ross Duncan
 * 01/05/2020
 */
public class AddDebt extends javax.swing.JFrame {

    //Int for storing debtees's ID
    private int debteeID;
    //String for storing debtee's name
    private String debteeName;
    //Load DBManager
    DBManager db = new DBManager();
    
    /**
     * Creates new form AddDebt
     */
    public AddDebt(int debteeIDIn, String debteeNameIn) {
        initComponents();
        
        //Assign passed in debteeID to debteeID variable
        debteeID = debteeIDIn;
        //Assign passed in debtee name to debteeName variable
        debteeName = debteeNameIn;
        
        //Show debtee ID in text box
        txtDebtee.setText(String.valueOf(debteeID));
        
        //Set date text box to default to the current date
        txtDOD.setText(String.valueOf(Date.valueOf(LocalDate.now())));
        //default amount text box to 0.00
        txtAmount.setText("0.00");
        
        //Clear message label
        lblMessage.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDebtee = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDebtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDOD = new javax.swing.JTextField();
        btnAddDebt = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        cbxDebtType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DesktopDebter");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon.png")).getImage());
        setResizable(false);

        txtDebtee.setEditable(false);

        jLabel1.setText("Debtee:");

        jLabel2.setText("Debt Name:");

        jLabel4.setText("Amount: £");

        jLabel5.setText("DOD:");

        btnAddDebt.setText("Add Debt");
        btnAddDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDebtActionPerformed(evt);
            }
        });

        lblMessage.setText("Message");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cbxDebtType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debit (You Owe Them)", "Credit(They Owe You)" }));

        jLabel6.setText("Debit or Credit:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Mandatory Fields");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDebt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxDebtType, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDebtee, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                        .addComponent(txtDebtName)
                                        .addComponent(txtAmount)
                                        .addComponent(txtDOD))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel7))
                            .addComponent(lblMessage))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxDebtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDebtee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDebtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddDebt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDebtActionPerformed
        //If mandatory textfields are filled out
        if(!txtDebtName.getText().isEmpty() && !txtAmount.getText().isEmpty()
        && !txtDOD.getText().isEmpty())
        {
            Debt nd = new Debt();
            //Assign text box values to a new debt object
            nd.setDebteeID(debteeID);
            nd.setDebtName(txtDebtName.getText());
            //If debt is a debit (you owe them) convert value to a negative number
            if (cbxDebtType.getSelectedIndex() == 0)
            {
                nd.setAmount((Double.valueOf(txtAmount.getText())) * -1);
            }
            else if (cbxDebtType.getSelectedIndex() == 1)
            {
                nd.setAmount(Double.valueOf(txtAmount.getText()));
            }

            nd.setDOD(Date.valueOf(txtDOD.getText()));

            //Call the add debt DBManager method, passing in the new debt 'nd'
            db.addDebt(nd);

            //Clear the text boxes
            txtDebtName.setText("");
            txtAmount.setText("0.00");
            txtDOD.setText(String.valueOf(Date.valueOf(LocalDate.now())));

            //lblMessage.setForeground(Color.green);
            //Display a success message
            lblMessage.setText("Debt Added, Add Another Debt, or click the back button");
        }
        else
        {
            lblMessage.setText("Please Fill out all required fields");
        }

    }//GEN-LAST:event_btnAddDebtActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //Open view debtees view passing in the selected debtees ID
        ControlPanel cp = new ControlPanel();
        this.dispose();
        cp.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddDebt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDebt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDebt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDebt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AddDebt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDebt;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cbxDebtType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDOD;
    private javax.swing.JTextField txtDebtName;
    private javax.swing.JTextField txtDebtee;
    // End of variables declaration//GEN-END:variables
}
