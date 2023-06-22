/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group1.booklend.views;

import java.sql.SQLException;

import group1.booklend.models.Borrower;

/**
 *
 * @author User
 */
public class RegisterNewBorrowerView extends javax.swing.JFrame {

    private static RegisterNewBorrowerView instance = null;

    /**
     * Creates new form RegisterNewBorrowerView
     */
    private RegisterNewBorrowerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblHeading = new javax.swing.JLabel();
                txtName = new javax.swing.JTextField();
                lblName = new javax.swing.JLabel();
                lblEmail = new javax.swing.JLabel();
                txtEmail = new javax.swing.JTextField();
                txtContact = new javax.swing.JTextField();
                lblContact = new javax.swing.JLabel();
                lblAddress = new javax.swing.JLabel();
                txtAddress = new javax.swing.JTextField();
                btnRegister = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setPreferredSize(new java.awt.Dimension(425, 450));
                setResizable(false);
                setSize(new java.awt.Dimension(425, 450));
                getContentPane().setLayout(null);

                lblHeading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                lblHeading.setText("Register a New Borrower");
                getContentPane().add(lblHeading);
                lblHeading.setBounds(6, 0, 170, 30);
                getContentPane().add(txtName);
                txtName.setBounds(10, 60, 380, 30);

                lblName.setText("Name");
                getContentPane().add(lblName);
                lblName.setBounds(10, 40, 32, 16);

                lblEmail.setText("Email Address");
                getContentPane().add(lblEmail);
                lblEmail.setBounds(10, 100, 100, 20);
                getContentPane().add(txtEmail);
                txtEmail.setBounds(10, 120, 380, 30);
                getContentPane().add(txtContact);
                txtContact.setBounds(10, 180, 380, 30);

                lblContact.setText("Contact No.");
                getContentPane().add(lblContact);
                lblContact.setBounds(10, 160, 100, 16);

                lblAddress.setText("Address");
                getContentPane().add(lblAddress);
                lblAddress.setBounds(10, 220, 60, 16);
                getContentPane().add(txtAddress);
                txtAddress.setBounds(10, 240, 380, 30);

                btnRegister.setBackground(new java.awt.Color(51, 0, 51));
                btnRegister.setForeground(new java.awt.Color(255, 255, 255));
                btnRegister.setText("Register");
                btnRegister.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRegisterActionPerformed(evt);
                        }
                });
                getContentPane().add(btnRegister);
                btnRegister.setBounds(310, 360, 80, 30);

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegisterActionPerformed

        String name = txtName.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();

        Borrower borrower = new Borrower();
        borrower.setName(name);
        borrower.setEmail(email);
        borrower.setNumber(contact);
        borrower.setAddress(address);

        try {
            Borrower.create(borrower);
            this.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        txtName.setText("");
        txtEmail.setText("");
        txtContact.setText("");
        txtAddress.setText("");

	BorrowView borrowView = BorrowView.getInstance();
	try {
		borrowView.loadBorrowers();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
		
        this.dispose();

    }// GEN-LAST:event_btnRegisterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterNewBorrowerView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterNewBorrowerView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterNewBorrowerView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterNewBorrowerView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterNewBorrowerView().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnRegister;
        private javax.swing.JLabel lblAddress;
        private javax.swing.JLabel lblContact;
        private javax.swing.JLabel lblEmail;
        private javax.swing.JLabel lblHeading;
        private javax.swing.JLabel lblName;
        private javax.swing.JTextField txtAddress;
        private javax.swing.JTextField txtContact;
        private javax.swing.JTextField txtEmail;
        private javax.swing.JTextField txtName;
        // End of variables declaration//GEN-END:variables

    public static synchronized RegisterNewBorrowerView getInstance() {
        if (instance == null) {
            instance = new RegisterNewBorrowerView();
        }
        return instance;
    }
}
