package group1.booklend;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import group1.booklend.utils.DarkModeUtil;
import group1.booklend.views.Login;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BookLend {

    private static BookLend instance;
    private static Login view;

    private BookLend() {
    }

    public static BookLend getInstance() {
        if (instance == null) {
            return new BookLend();
        }
        return instance;
    }

    public static void main(String[] args) {
        // Entry point
        SwingUtilities.invokeLater(() -> {
            BookLend app = BookLend.getInstance();
            app.initializeLookAndFeel();
            app.showLogin();
        });
    }

    public void initializeLookAndFeel() {
        System.out.println("Invoked: LAF");
        DarkModeUtil darkModeUtil = DarkModeUtil.getInstance();

        // Set the look and feel based on dark mode setting
        try {
            if (darkModeUtil.getIsDark()) {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
    }

    public void showLogin() {
        if (BookLend.view == null) {
            BookLend.view = new Login();
            view.setVisible(true);
            return;
        }
        BookLend.view.dispose();
        BookLend.view = new Login();
        view.setVisible(true);
    }
}
