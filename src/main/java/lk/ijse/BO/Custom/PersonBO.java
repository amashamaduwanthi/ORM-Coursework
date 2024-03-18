package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.DTO.PersonDTO;
import lk.ijse.Entity.Person;

import java.sql.SQLException;

public interface PersonBO extends SuperDAO {
    boolean savePerson(Person person) throws SQLException;

    boolean checkPassword(String username, String password);

    String generateClientId();

    Person searchPerson(String searchId);

    boolean changePassword(Person person);
    PersonDTO getUserId(String username) throws SQLException;
}
