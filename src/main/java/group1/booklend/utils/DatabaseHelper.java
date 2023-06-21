/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.booklend.utils;

/**
 *
 * @author User
 */
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

public class DatabaseHelper {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/booklend";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    private static ConnectionSource connectionSource;

    public static ConnectionSource getConnectionSource() throws SQLException {
        if(connectionSource == null) {
            connectionSource = new JdbcConnectionSource(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        }
        return connectionSource;
    }
}
