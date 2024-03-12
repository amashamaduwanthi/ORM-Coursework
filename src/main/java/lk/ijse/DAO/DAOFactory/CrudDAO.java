package lk.ijse.DAO.DAOFactory;

import lk.ijse.DAO.SuperDAO;

public interface CrudDAO<T> extends SuperDAO {
    boolean Save(T type);
    boolean update(T type);

    boolean delete(String id);

    T search(String id);

}
