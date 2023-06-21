/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package group1.booklend;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

import group1.booklend.views.Login;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;

/**
 *
 * @author User
 */
public class BookLend {

    public static void main(String[] args) {
        // Add material swing LAF
        try {
            UIManager.setLookAndFeel(new FlatLightLaf() );
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }

        // Entry point
        SwingUtilities.invokeLater(() -> {
            Login app = new Login();
            app.setVisible(true);
        });

    }
}
