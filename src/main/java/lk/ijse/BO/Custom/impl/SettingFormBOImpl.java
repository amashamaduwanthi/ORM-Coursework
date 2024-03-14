package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.SettingFormBO;
import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.DAOFactory.custom.PersonDAO;
import lk.ijse.DAO.RegisterDto;
import lk.ijse.Dto.AdminDTO;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Person;

import java.util.ArrayList;
import java.util.List;


public class SettingFormBOImpl implements SettingFormBO {
    PersonDAO personDAO= (PersonDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PERSON);
//    @Override
//    public boolean updateCredential(RegisterDto userDTO) {
//        return personDAO.update(new Person(userDTO.getPassword()));
//    }


}

