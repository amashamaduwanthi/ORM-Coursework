package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDAO;
import lk.ijse.Entity.Person;

public interface PersonDAO extends CrudDAO<Person> {
    boolean checkPassword(String username, String password);

    String generateUserID();

    String get(String username);
}
