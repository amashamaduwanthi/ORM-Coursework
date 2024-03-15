package lk.ijse.DAO.DAOFactory.custom;


import lk.ijse.DAO.DAOFactory.CrudDAO;
import lk.ijse.Entity.Library;

import java.sql.SQLException;

public interface LibraryDAO extends CrudDAO<Library> {
    Library search(String Id);
    boolean del(String Id) throws SQLException;
}
