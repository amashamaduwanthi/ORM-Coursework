package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.Dto.AdminDTO;
import lk.ijse.Entity.Person;

import java.util.List;

public interface PersonBO extends SuperDAO {
    boolean savePerson(Person person);



    String generateClientId();

    Person searchPerson(String searchId);





    boolean checkPassword(String username, String password);

    boolean changePassword(Person person);

    List<AdminDTO> getAllAdmin();
}
