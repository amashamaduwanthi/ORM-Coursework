package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.PersonBO;

import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.DAOFactory.custom.PersonDAO;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Person;

public class PersonBOImpl implements PersonBO {
    PersonDAO personDAO= (PersonDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PERSON);

    @Override
    public boolean savePerson(Person person) {
        return false;
    }

    @Override
    public String generateClientId() {
        return null;
    }

    @Override
    public Person searchPerson(String searchId) {
        return null;
    }

    @Override
    public boolean checkPassword(String username, String password) {
        return false;
    }

    @Override
    public boolean changePassword(Person person) {
        return false;
    }
}
