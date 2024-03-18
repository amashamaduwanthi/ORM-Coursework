package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.DTO.UserDTO;
import lk.ijse.Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperDAO {
    boolean checkPassword(String username, String password);

    boolean RegisterUser(User user) throws SQLException;

    List<UserDTO> getAllAdmin();
}
