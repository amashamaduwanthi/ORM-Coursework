package lk.ijse.BO.Custom;

import lk.ijse.DAO.RegisterDto;
import lk.ijse.DAO.SuperDAO;

import java.util.List;

public interface SettingFormBO extends SuperDAO {
    boolean updateCredential(RegisterDto userDTO);
    List<RegisterDto> getAllUser();
}
