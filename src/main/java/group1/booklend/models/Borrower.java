/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.booklend.models;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import group1.booklend.utils.DatabaseHelper;

/**
 *
 * @author User
 */

@DatabaseTable(tableName = "borrowers")
public class Borrower {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String number;

    @DatabaseField
    private String email;

    @DatabaseField
    private String address;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void create(Borrower borrower) throws SQLException {
        Dao<Borrower, Integer> borrowerDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Borrower.class);
        borrowerDao.create(borrower);
    }

    public static Borrower read(int id) throws SQLException {
        Dao<Borrower, Integer> borrowerDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Borrower.class);
        return borrowerDao.queryForId(id);
    }

    public static void update(Borrower borrower) throws SQLException {
        Dao<Borrower, Integer> borrowerDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Borrower.class);
        borrowerDao.update(borrower);
    }

    public static void delete(Borrower borrower) throws SQLException {
        Dao<Borrower, Integer> borrowerDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Borrower.class);
        borrowerDao.delete(borrower);
    }

    public static List<Borrower> all() throws SQLException {
        Dao<Borrower, Integer> borrowerDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Borrower.class);
        return borrowerDao.queryForAll();
    }

}
