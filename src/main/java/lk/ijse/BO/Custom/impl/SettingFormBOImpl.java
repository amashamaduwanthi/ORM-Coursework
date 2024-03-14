package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.SettingFormBO;
import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.RegisterDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Person;

import java.util.ArrayList;
import java.util.List;


public class SettingFormBOImpl implements SettingFormBO {
    Book.PersonDAO personDAO= (Book.PersonDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PERSON);
    @Override
    public boolean updateCredential(RegisterDto userDTO) {
        return personDAO.update(new Person(userDTO.getPassword()));
    }

    @Override
    public List<RegisterDto> getAllUser() {
        List<Person> getAll = personDAO.getAll();
        List<RegisterDto> registerDTO = new ArrayList<>();

        for (Person register : getAll){
            registerDTO.add(new RegisterDto(register.getUserName(),register.getNic(),register.getEmail(),register.getAddress(),register.getTel(),register.getPassword(),register.getUserID()));
        }
        return registerDTO;
    }
    }

