package group1.booklend.models;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import group1.booklend.utils.DatabaseHelper;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author User
 */
@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String email;

    @DatabaseField
    private String password;

    // Setter Getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // logic
    public static User authenticate(String email, String password) {

        // Start Dao
        try {
            Dao<User, String> userDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), User.class);
            User user = userDao.queryBuilder().where().eq("email", email).queryForFirst();
            if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
