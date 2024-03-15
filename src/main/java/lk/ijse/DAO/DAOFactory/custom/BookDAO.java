package lk.ijse.DAO.DAOFactory.custom;


import lk.ijse.DAO.DAOFactory.CrudDAO;
import lk.ijse.Entity.Book;

import java.sql.SQLException;

public interface BookDAO extends CrudDAO<Book> {

    Book getId(String title);

    boolean updateStatus(Book entity) throws SQLException;
}
