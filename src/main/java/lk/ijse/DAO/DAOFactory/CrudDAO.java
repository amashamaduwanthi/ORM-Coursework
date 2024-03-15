package lk.ijse.DAO.DAOFactory;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.Entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T entity) throws SQLException;
    List<T> getAll();
    T exists(String title);
    boolean update(T entity) throws SQLException;
    boolean delete(String title) throws SQLException;
    String getCount();
    T search(String title);
}
