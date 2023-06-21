/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.booklend.models;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import group1.booklend.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */

@DatabaseTable(tableName = "loans")
public class Loan {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, columnName = "borrower_id")
    private Borrower borrower;

    @DatabaseField(foreign = true, columnName = "book_id")
    private Book book;

    @DatabaseField
    private Date borrow_date;

    @DatabaseField(canBeNull = true)
    private Date return_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public static void create(Loan loan) throws SQLException {
        Dao<Loan, Integer> loanDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Loan.class);
        loanDao.create(loan);
    }

    public static Loan read(int id) throws SQLException {
        Dao<Loan, Integer> loanDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Loan.class);
        return loanDao.queryForId(id);
    }

    public static void update(Loan loan) throws SQLException {
        Dao<Loan, Integer> loanDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Loan.class);
        loanDao.update(loan);
    }

    public static void delete(Loan loan) throws SQLException {
        Dao<Loan, Integer> loanDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Loan.class);
        loanDao.delete(loan);
    }

    public static List<Loan> all() throws SQLException {
        Dao<Loan, Integer> loanDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), Loan.class);
        return loanDao.queryForAll();
    }

}
