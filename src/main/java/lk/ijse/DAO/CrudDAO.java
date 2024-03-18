package lk.ijse.DAO;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    boolean Save(T entity) throws SQLException;
    List<T> getAll();
    T exists(String title);
    boolean update(T entity) throws SQLException;
    boolean delete(String title) throws SQLException;
    String getCount();
    T search(String title);
}
