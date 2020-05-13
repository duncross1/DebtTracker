/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.DBManager;
import Classes.Debt;
import Classes.Person;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/** ViewDebtee view
 this is the menu for view the debts you owe to/owed by individual debtees
 *
 * @author Ross Duncan
 * 01/05/2020
 */
public class ViewDebtee extends javax.swing.JFrame {

    //Passed in debtee being viewed
    private int viewedDebteeID;
    //String for storing viewed debtees name
    private String debteeName;
    //Load DBManager
    private DBManager db = new DBManager();
    //Hashmap for storing debts tied to this debtee
    private HashMap<Integer, Debt> debts = new HashMap<>();
    
    /**
     * Creates new form ViewDebtees
     */
    public ViewDebtee(int viewedDebteeIDIn, String debteeNameIn) {
        initComponents();
        
        //Assign passed in debteeID to the viewDebteeId variable
        viewedDebteeID = viewedDebteeIDIn;
        //Assign passed in debteeName to debteeName variable
        debteeName = debteeNameIn;    
        
        //Sets title to display debtees name
        lblDebteeName.setText(debteeName);
        
        //Call the method to load the debts table
        LoadTable();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDebts = new javax.swing.JTable();
        lblDebteeName = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnAddDebt = new javax.swing.JButton();
        btnRemoveDebtee = new javax.swing.JButton();
        btnRemoveDebt = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DesktopDebter - Debtee View");
        setResizable(false);

        tblDebts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Debt", "Value", "DOD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDebts);

        lblDebteeName.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblDebteeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDebteeName.setText("Name of Debtee");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAddDebt.setText("Add Debt");
        btnAddDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDebtActionPerformed(evt);
            }
        });

        btnRemoveDebtee.setText("Remove This Debtee");
        btnRemoveDebtee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDebteeActionPerformed(evt);
            }
        });

        btnRemoveDebt.setText("Remove Debt");
        btnRemoveDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDebtActionPerformed(evt);
            }
        });

        lblMessage.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(lblDebteeName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveDebtee, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMessage))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDebteeName)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDebt)
                    .addComponent(btnRemoveDebtee)
                    .addComponent(btnRemoveDebt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //Open Control Panel Menu and Close This Menu
        ControlPanel cp = new ControlPanel();
        this.dispose();
        cp.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDebtActionPerformed
        //Open add debt Menu, passing in the viewed debtee ID and the viewed Debtees name and Close This Menu
        AddDebt ad = new AddDebt(viewedDebteeID, debteeName);
        this.dispose();
        ad.setVisible(true);
    }//GEN-LAST:event_btnAddDebtActionPerformed

    private void btnRemoveDebteeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDebteeActionPerformed
        
        db.removeDebtee(viewedDebteeID);
        
        //Open view debtees view passing in the selected debtees ID
        ControlPanel cp = new ControlPanel();
        this.dispose();
        cp.setVisible(true);
    }//GEN-LAST:event_btnRemoveDebteeActionPerformed

    private void btnRemoveDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDebtActionPerformed
        //If a debt has been selected from the table
        if(tblDebts.getSelectedRow() != -1) 
        {
            //Get model of the debts table
            DefaultTableModel model = (DefaultTableModel)tblDebts.getModel(); 
            //Get the selected debts ID
            int debtID = Integer.parseInt(String.valueOf(model.getValueAt(tblDebts.getSelectedRow(), 0)));
            //Call the DBManager method to remove the debt from the database
            db.removeDebt(debtID);
            
            //calls the method to load the table, basically updating it by reloading it
            LoadTable();
        }
        else
        {
            lblMessage.setText("Please Select A Debt from the table first");
        }
    }//GEN-LAST:event_btnRemoveDebtActionPerformed

    private void LoadTable()
    {
        //Clear the debts hashmap
        debts.clear();
        //Load debts for this debtee into debts hashmap
        debts = db.loadIndividualDebts(debts, viewedDebteeID);
        
        //Create a table model and assign it the table model of the debts table
        DefaultTableModel model = (DefaultTableModel)tblDebts.getModel();
        //deletes any existing rows from the table
        model.setRowCount(0);
        //Loop through the hashmap of debts and add them to the debts table
        for(Map.Entry<Integer, Debt> entry : debts.entrySet())
        {
            //Get the current debt in the entry set
            Debt debtToAdd = entry.getValue();
            //add that debt to the debts table
            model.addRow(new Object[] 
            {debtToAdd.getDebtID(), debtToAdd.getDebtName(), "£" +  String.format("%.02f", debtToAdd.getAmount()), debtToAdd.getDOD()});
        }
        
        //Hide message label
        lblMessage.setText("");
    }
    
    
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
            java.util.logging.Logger.getLogger(ViewDebtee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDebtee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDebtee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDebtee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //   new ViewDebtee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDebt;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveDebt;
    private javax.swing.JButton btnRemoveDebtee;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDebteeName;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTable tblDebts;
    // End of variables declaration//GEN-END:variables
}
