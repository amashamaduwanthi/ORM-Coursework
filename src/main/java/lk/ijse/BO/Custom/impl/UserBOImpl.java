package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DAO.Custom.UserDAO;
import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DTO.UserDTO;
import lk.ijse.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO= (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);
    @Override
    public boolean checkPassword(String username, String password) {
        return userDAO.checkPassword(username, password);
    }

    @Override
    public boolean RegisterUser(User user) throws SQLException {
        User users = new User(user.getAdminId(),user.getUserName(),user.getPassword(),user.getConfirmPassword());
        return userDAO.Save(users);
    }

    @Override
    public List<UserDTO> getAllAdmin() {
        List<User> admins = userDAO.getAll();
        List<UserDTO> adminDtos = new ArrayList<>();
        for(User admin : admins){
            adminDtos.add(new UserDTO(admin.getAdminId(),admin.getUserName(), admin.getPassword(), admin.getConfirmPassword()));
        }
        return adminDtos;
    }

}
