package lk.ijse.DAO.DAOFactory.custom;

import lk.ijse.DAO.DAOFactory.CrudDAO;
import lk.ijse.Entity.Person;

public interface PersonDAO extends CrudDAO<Person> {
    boolean checkPassword(String username, String password);

    String generateUserID();
}
