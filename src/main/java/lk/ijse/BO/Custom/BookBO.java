package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.Entity.Book;

import java.sql.SQLException;

public interface BookBO extends SuperDAO {
    boolean saveBook(Book books) throws SQLException, ClassNotFoundException;

    boolean deleteBook(String id);

    Book searchBook(String id);

    boolean updateBook(Book books);
}
