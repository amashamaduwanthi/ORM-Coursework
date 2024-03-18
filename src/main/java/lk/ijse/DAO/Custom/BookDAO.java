package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDAO;
import lk.ijse.Entity.Book;

import java.sql.SQLException;

public interface BookDAO extends CrudDAO<Book> {
    Book getId(String title);

    boolean updateStatus(Book entity) throws SQLException;
    public Book getWithBorrowedBooks(String bookId);
}
