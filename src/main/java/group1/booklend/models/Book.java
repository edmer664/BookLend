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
@DatabaseTable(tableName = "books")
public class Book {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String author;

    @DatabaseField
    private String isbn;

    // Setter and Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Logic
    public boolean isLoaned() {
        try {
            Dao<Loan, Integer> loanDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Loan.class);
            List<Loan> loans = loanDao.queryBuilder().where().eq("book_id", id).and().isNull("return_date").query();
            return !loans.isEmpty();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void create(Book book) throws SQLException {
        Dao<Book, Integer> bookDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Book.class);
        bookDao.create(book);
    }

    public static Book read(int id) throws SQLException {
        Dao<Book, Integer> bookDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Book.class);
        return bookDao.queryForId(id);
    }

    public static void update(Book book) throws SQLException {
        Dao<Book, Integer> bookDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Book.class);
        bookDao.update(book);
    }

    public static void delete(Book book) throws SQLException {
        Dao<Book, Integer> bookDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Book.class);
        bookDao.delete(book);
    }

    public static List<Book> all() throws SQLException {
        Dao<Book, Integer> bookDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Book.class);
        return bookDao.queryForAll();
    }

}
