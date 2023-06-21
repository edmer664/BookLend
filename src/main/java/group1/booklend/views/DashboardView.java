/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group1.booklend.views;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import group1.booklend.models.Book;

/**
 *
 * @author User
 */
public class DashboardView extends javax.swing.JFrame {

    private static DashboardView instance = null;

    /**
     * Creates new form DashboardView
     */
    private DashboardView() {
        initComponents();
        tblBooks.setModel(getBooksTableModel());
    }

    public void refreshBooksTable() {
        tblBooks.setModel(getBooksTableModel());
    }
    
    public void searchBooksTable(String searchTerm) {
        String[] columnNames = { "ID", "Title", "Author", "ISBN", "Status" };
        List<Book> books;
	DefaultTableModel model;
        try {
            books = Book.search(searchTerm);
	    model = getBooksTableModel(books);
        } catch (SQLException e) {
            e.printStackTrace();
	    model = new DefaultTableModel(null, columnNames);
        }
        tblBooks.setModel(model);
    }

    public static DefaultTableModel getBooksTableModel(List<Book> books) {
        String[] columnNames = { "ID", "Title", "Author", "ISBN", "Status" };

        Object[][] data = new Object[books.size()][columnNames.length];
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            data[i][0] = book.getId();
            data[i][1] = book.getTitle();
            data[i][2] = book.getAuthor();
            data[i][3] = book.getIsbn();
            data[i][4] = book.isLoaned() ? "Loaned" : "Available";
        }

        return new DefaultTableModel(data, columnNames);
    }

    public static DefaultTableModel getBooksTableModel() {
        String[] columnNames = { "ID", "Title", "Author", "ISBN", "Status" };
        List<Book> books;
        try {
            books = Book.all();
        } catch (SQLException e) {
            e.printStackTrace();
            return new DefaultTableModel(null, columnNames);
        }
	return getBooksTableModel(books);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                pnlLeft = new javax.swing.JPanel();
                lblTitle = new javax.swing.JLabel();
                btnRefresh = new javax.swing.JButton();
                btnBorrower = new javax.swing.JButton();
                btnSettings = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                jPanel1 = new javax.swing.JPanel();
                btnAddNew = new javax.swing.JButton();
                btnSelect = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                tblBooks = new javax.swing.JTable();
                txtSearch = new javax.swing.JTextField();
                btnSearch = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("BookLend - Dashboard");
                setPreferredSize(new java.awt.Dimension(650, 450));
                setResizable(false);
                setSize(new java.awt.Dimension(600, 500));
                getContentPane().setLayout(null);

                pnlLeft.setBackground(new java.awt.Color(255, 255, 255));
                pnlLeft.setLayout(null);

                lblTitle.setBackground(new java.awt.Color(255, 255, 255));
                lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lblTitle.setForeground(new java.awt.Color(51, 0, 51));
                lblTitle.setText("BookLend");
                pnlLeft.add(lblTitle);
                lblTitle.setBounds(60, 60, 100, 40);

                btnRefresh.setText("Refresh");
                btnRefresh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRefreshActionPerformed(evt);
                        }
                });
                pnlLeft.add(btnRefresh);
                btnRefresh.setBounds(20, 110, 170, 30);

                btnBorrower.setText("Add Borrower");
                btnBorrower.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBorrowerActionPerformed(evt);
                        }
                });
                pnlLeft.add(btnBorrower);
                btnBorrower.setBounds(20, 150, 170, 30);

                btnSettings.setText("Settings");
                pnlLeft.add(btnSettings);
                btnSettings.setBounds(20, 190, 170, 30);

                getContentPane().add(pnlLeft);
                pnlLeft.setBounds(0, 0, 200, 400);

                jScrollPane1.setBackground(new java.awt.Color(228, 228, 228));

                jPanel1.setLayout(null);

                btnAddNew.setBackground(new java.awt.Color(51, 0, 51));
                btnAddNew.setForeground(new java.awt.Color(255, 255, 255));
                btnAddNew.setText("Add New");
                btnAddNew.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAddNewActionPerformed(evt);
                        }
                });
                jPanel1.add(btnAddNew);
                btnAddNew.setBounds(320, 10, 90, 23);

                btnSelect.setText("Select");
                jPanel1.add(btnSelect);
                btnSelect.setBounds(240, 10, 72, 23);

                tblBooks.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "id", "Title", "Author", "Status"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                tblBooks.getTableHeader().setReorderingAllowed(false);
                jScrollPane2.setViewportView(tblBooks);
                if (tblBooks.getColumnModel().getColumnCount() > 0) {
                        tblBooks.getColumnModel().getColumn(3).setResizable(false);
                }

                jPanel1.add(jScrollPane2);
                jScrollPane2.setBounds(10, 50, 400, 340);
                jPanel1.add(txtSearch);
                txtSearch.setBounds(10, 10, 110, 22);

                btnSearch.setText("Search");
                btnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSearchActionPerformed(evt);
                        }
                });
                jPanel1.add(btnSearch);
                btnSearch.setBounds(130, 10, 72, 23);

                jScrollPane1.setViewportView(jPanel1);

                getContentPane().add(jScrollPane1);
                jScrollPane1.setBounds(200, 0, 420, 400);

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshBooksTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

        private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
		String searchTerm = txtSearch.getText();
		searchBooksTable(searchTerm);
        }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddNewActionPerformed
        // make sure no other AddNewBookView is opened
        AddNewBookView.getInstance().setVisible(true);
    }// GEN-LAST:event_btnAddNewActionPerformed

    private void btnBorrowerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBorrowerActionPerformed
        RegisterNewBorrowerView view = RegisterNewBorrowerView.getInstance();
        view.setVisible(true);
    }// GEN-LAST:event_btnBorrowerActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardView().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAddNew;
        private javax.swing.JButton btnBorrower;
        private javax.swing.JButton btnRefresh;
        private javax.swing.JButton btnSearch;
        private javax.swing.JButton btnSelect;
        private javax.swing.JButton btnSettings;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JLabel lblTitle;
        private javax.swing.JPanel pnlLeft;
        private javax.swing.JTable tblBooks;
        private javax.swing.JTextField txtSearch;
        // End of variables declaration//GEN-END:variables
    public static synchronized DashboardView getInstance() {
        if (instance == null) {
            instance = new DashboardView();
        }
        return instance;
    }
}
