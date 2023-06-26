/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.booklend.utils;

/**
 *
 * @author User
 */
public class DarkModeUtil {

    private static DarkModeUtil instance;
    private boolean isDark = false;

    private DarkModeUtil() {
    }

    public static DarkModeUtil getInstance() {
        if (instance == null) {
            instance = new DarkModeUtil();
        }
        return instance;
    }

    public boolean getIsDark() {
        return isDark;
    }

    public void setIsDark(boolean stat) {
        this.isDark = stat;
    }

}
